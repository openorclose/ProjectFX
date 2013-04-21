package gui.start.register;

import common.Account;
import common.CustomFile;
import common.Util;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Controller {
    public TextField username;
    public PasswordField password;

    @FXML private void register() {
        Account.newAccount (username.getText(), password.getText());
        //Util.push ("Success!");
        //new Gui ();
    }
}
