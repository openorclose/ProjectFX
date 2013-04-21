package gui.start;

import common.Function;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class Gui extends Application {
    private static Stage stage;
    private static Parent root;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        root = FXMLLoader.load(getClass().getResource("gui.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }
    public static void setScene (Parent parent, int width, int height) {
        stage.setScene (new Scene (parent, width, height));
    }
    public static void hide() {
        stage.close();
    }
    public static void show() {
        stage.show();
    }
    public static void main(String[] args) {
       /* String s = common.Util.promptUntilValid ("alpha", "numeric", new Function<Boolean> () {
             public Boolean isValid (String unchecked) {
                 return common.Util.isAlphanumeric (unchecked);
             }
            public String getErrorMessage() {
                return "Input must contain letters and numbers only";
            }
        });*/
        launch (args);
    }
}
