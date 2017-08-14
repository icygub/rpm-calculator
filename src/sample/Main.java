package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//https://www.youtube.com/watch?v=7ha78yWRDlE
//https://tedtheeconomist.wordpress.com/2015/07/06/how-to-use-rpn-calculators/comment-page-1/

/**
 * John Diaz
 * CS 115 Final Project
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("RPM Calculator");
        primaryStage.setScene(new Scene(root, 650, 700));
        primaryStage.show();
    }

    //random comment
    public static void main(String[] args) {
        launch(args);
    }
}
