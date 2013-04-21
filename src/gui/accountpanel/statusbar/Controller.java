package gui.accountpanel.statusbar;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;

public class Controller {
    public static FlowPane statusbar;

    public static void remove (Node node) {
        getChildren().remove (node);
    }
    public static Node get (int i) {
        return getChildren().get (i);
    }
    public static int size() {
        return getChildren().size ();
    }

    private static ObservableList<Node> getChildren () {
        return statusbar.getChildren();
    }

    public static void add (Node node) {
        getChildren().add (node);
    }
    public static void add (String string) {
        try {
            BlinkingLabel previousLabel = (BlinkingLabel) get (size() - 1);
            if (string.equals (previousLabel.getText())) {
                remove (previousLabel);
            }
        } catch (Exception ignored) {
        }
        add (new BlinkingLabel (string));
    }
}
