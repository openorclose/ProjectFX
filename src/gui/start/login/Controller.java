package gui.start.login;

import common.Account;
import common.Current;
import common.CustomFile;
import common.Util;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.File;
import java.util.Scanner;

public class Controller {
    public TextField username;
    public PasswordField password;
    @FXML private void login() {
        String username = this.username.getText();
        String password = this.password.getText();
        File account =  CustomFile.getFolderAtRoot ("accounts").getFolder (username).getFile ("password");
        if (account.exists ()) {
            Scanner scanner = Util.getScanner (account);
            if (scanner.nextLine ().equals (password)) {
                Current.account = new Account (username);
                new gui.accountpanel.Gui ();
                gui.start.Gui.hide();
                gui.start.statusbar.Controller.add ("Logged in successfully!");
            }
        } else {
            gui.start.statusbar.Controller.add ("Username/Password incorrect");
        }
    }
}
