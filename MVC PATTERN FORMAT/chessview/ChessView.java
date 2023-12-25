import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ChessView {

    private GridPane gridPane;
    private double buttonSize;
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private Button[][] buttons;

    public ChessView() {
        this.gridPane = new GridPane();
        this.gridPane.setBackground(new Background(new BackgroundFill(
                Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY))); // Transparent background
        this.buttonSize = 50;

        this.buttons = new Button[ROWS][COLS];
        initializeBoard();
        initializePieces(); // Add images to specific grid positions
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
                        Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2)); // Change 2 to
                Border border = new Border(borderStroke);

                buttons[row][col] = button;

                button.setOnAction(e -> {
                    int clickedRow = GridPane.getRowIndex(button);
                    int clickedCol = GridPane.getColumnIndex(button);
                    handleButtonClick(clickedRow, clickedCol);
                });

                button.setBorder(border); // Blue gridline border
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

    private void initializePieces() {
        // Set images at specific positions during initialization
        setPieceAt(1, 0, "images\\BArrow.PNG");
        setPieceAt(1, 1, "images\\BArrow.PNG");
        setPieceAt(1, 2, "images\\BArrow.PNG");
        setPieceAt(1, 3, "images\\BArrow.PNG");
        setPieceAt(1, 4, "images\\BArrow.PNG");
        setPieceAt(1, 5, "images\\BArrow.PNG");
        setPieceAt(1, 6, "images\\BArrow.PNG");
        setPieceAt(0, 0, "images\\BPlus.PNG");
        setPieceAt(0, 1, "images\\BHourglass.PNG");
        setPieceAt(0, 2, "images\\BCross.PNG");
        setPieceAt(0, 3, "images\\BSun.PNG");
        setPieceAt(0, 4, "images\\BPlus.PNG");
        setPieceAt(0, 5, "images\\BHourglass.PNG");
        setPieceAt(0, 6, "images\\BPlus.PNG");
        setPieceAt(4, 0, "images\\WArrow.PNG");
        setPieceAt(4, 1, "images\\WArrow.PNG");
        setPieceAt(4, 2, "images\\WArrow.PNG");
        setPieceAt(4, 3, "images\\WArrow.PNG");
        setPieceAt(4, 4, "images\\WArrow.PNG");
        setPieceAt(4, 5, "images\\WArrow.PNG");
        setPieceAt(4, 6, "images\\WArrow.PNG");
        setPieceAt(5, 0, "images\\WPlus.PNG");
        setPieceAt(5, 1, "images\\WHourglass.PNG");
        setPieceAt(5, 2, "images\\WCross.PNG");
        setPieceAt(5, 3, "images\\WSun.PNG");
        setPieceAt(5, 4, "images\\WCross.PNG");
        setPieceAt(5, 5, "images\\WHourglass.PNG");
        setPieceAt(5, 6, "images\\WPlus.PNG");




        // Set more images at other positions as needed
    }

    private void handleButtonClick(int row, int col) {
        // Handle button click if needed
    }

    private void setPieceAt(int row, int col, String imagePath) {
        Image pieceImage = new Image(imagePath);
        ImageView imageView = new ImageView(pieceImage);
        imageView.setFitWidth(buttonSize);
        imageView.setFitHeight(buttonSize);

        Button targetButton = getButtonAt(row, col);
        if (targetButton != null) {
            targetButton.setGraphic(imageView);
        }
    }

    private Button getButtonAt(int row, int col) {
        if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
            return buttons[row][col];
        }
        return null;
    }

    public Scene createScene() {
        Scene scene = new Scene(gridPane);

        scene.widthProperty().addListener((observable, oldValue, newValue) -> updateBoardSize(scene));
        scene.heightProperty().addListener((observable, oldValue, newValue) -> updateBoardSize(scene));

        return scene;
    }
}
