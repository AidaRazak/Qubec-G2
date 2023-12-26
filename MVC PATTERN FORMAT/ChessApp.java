// ChessApp.java
import chessmodel.ChessModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class ChessApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tabular Chess");

        ChessModel model = new ChessModel();
        ChessView view = new ChessView();
        ChessController controller = new ChessController(model, view);

        primaryStage.setScene(view.createScene()); // Set the scene using createScene method
        primaryStage.show();
    }
}
