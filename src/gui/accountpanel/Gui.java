package gui.accountpanel;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Gui extends Stage {

    public Gui() {
        try {
            Parent root = FXMLLoader.load (this.getClass ().getResource ("gui.fxml"));
            setTitle("Hello World");

            setOnCloseRequest (new EventHandler<WindowEvent> () {
                @Override
                public void handle (WindowEvent windowEvent) {
                    gui.start.Gui.show();
                }
            });
            Controller.populateBlogsPanel ();
            setScene(new Scene(root, 800, 600));
            show();
        } catch (IOException ignored) {
           System.out.println (ignored.getMessage ());
        }

    }
}
