package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//https://www.youtube.com/watch?v=7ha78yWRDlE
//https://tedtheeconomist.wordpress.com/2015/07/06/how-to-use-rpn-calculators/comment-page-1/
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("RPM Calculator");
        primaryStage.setScene(new Scene(root, 350, 325));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
