package gui.accountpanel;

import common.Blog;
import common.Current;
import common.Util;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Controller {
    @FXML
    private static VBox blogsPanel;
    public Button newBlog;
    @FXML private void createNewBlog() {
        common.Current.account.newBlog();
        populateBlogsPanel ();
    }
    public static void populateBlogsPanel() {
       blogsPanel.getChildren ().clear();
       for (Blog blog : Current.account.getBlogs ()) {
           Button button = new Button (blog.toString());
           button.setOnAction (new EventHandler<ActionEvent> () {
               @Override
               public void handle (ActionEvent actionEvent) {
                   gui.accountpanel.statusbar.Controller.add ("You clicked something");
               }
           });
           blogsPanel.getChildren ().add (button);
       }
    }
}
