// ChessView.java
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ChessView {

    private GridPane gridPane;
    private double buttonSize;
    private static final int ROWS = 6;
    private static final int COLS = 7;

    public ChessView() {
        this.gridPane = new GridPane();
        this.gridPane.setBackground(new Background(new BackgroundFill(
                Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY))); // Transparent background
        this.buttonSize = 50;

        initializeBoard();
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void updateBoardSize(Scene scene) {
        double newButtonSize = Math.min(scene.getWidth() / COLS, scene.getHeight() / ROWS);
        gridPane.getChildren().forEach(node -> {
            if (node instanceof Button) {
                ((Button) node).setMinSize(newButtonSize, newButtonSize);
            }
        });

        // Update the gridPane size
        gridPane.setMinSize(newButtonSize * COLS, newButtonSize * ROWS);
        positionGridPane(scene);
    }

    public void setFullScreenWindowSize(Stage primaryStage) {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        positionGridPane(primaryStage.getScene());
    }

    private void initializeBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Button button = new Button();
                button.setMinSize(buttonSize, buttonSize);
                button.setStyle("-fx-font-size: 16;");
                button.setBackground(Background.EMPTY); // Transparent button background

                // Increase the border width for a thicker border
                BorderStroke borderStroke = new BorderStroke(
                        Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2)); // Change 2 to your desired thickness
                Border border = new Border(borderStroke);

                button.setBorder(border); // Blue gridline border

                final int finalRow = row;
                final int finalCol = col;

                button.setOnAction(e -> handleButtonClick(finalRow, finalCol));
                gridPane.add(button, col, row);
            }
        }

        // Set row constraints to grow with the window
        for (int row = 0; row < ROWS; row++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setFillHeight(true);
            gridPane.getRowConstraints().add(rowConstraints);
        }

        // Set column constraints to grow with the window
        for (int col = 0; col < COLS; col++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setFillWidth(true);
            gridPane.getColumnConstraints().add(columnConstraints);
        }
    }

    private void positionGridPane(Scene scene) {
        double startX = (scene.getWidth() - gridPane.getMinWidth()) / 2.0;
        double startY = (scene.getHeight() - gridPane.getMinHeight()) / 2.0;
        gridPane.setLayoutX(startX);
        gridPane.setLayoutY(startY);
    }

    private void handleButtonClick(int row, int col) {
        // Handle button click event
        System.out.println("Button clicked: Row " + row + ", Col " + col);
        // You can notify the controller or update the model here
    }

    public Scene createScene() {
        // Create a new scene using the GridPane
        Scene scene = new Scene(gridPane);

        // Listen for changes in the scene's width and height
        scene.widthProperty().addListener((observable, oldValue, newValue) -> updateBoardSize(scene));
        scene.heightProperty().addListener((observable, oldValue, newValue) -> updateBoardSize(scene));

        return scene;
    }
}
