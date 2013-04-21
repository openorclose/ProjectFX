package common;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Util {
    public static void alert (String title, String body) {
        JOptionPane.showMessageDialog (null, body, title, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void alert (String body) {
        alert ("Message", body);

    }

    public static Scanner getScanner (File file) {
        try {
            return new Scanner (file);
        } catch (Exception e) {
            return null;
        }
    }
    public static String promptUntilValid (String title, String question, Function<Boolean> validate) {
        String input;
        while ((input= JOptionPane.showInputDialog (null, question, title, JOptionPane.OK_CANCEL_OPTION))!=null && !validate.isValid (input))
            alert ("Error", validate.getErrorMessage ());
        return input;
    }
    public static String toHtmlFont (String font, String text) {
        return "<html><font color = '" + font + "'>" + text + "</font></html>";
    }
    public static String toHtmlFont (String font, int size, String text) {
        return "<html><font size = '" + size + "' color = '" + font + "'>" + text + "</font></html>";
    }

    public static boolean isAlphanumeric (String s) {
        return s.matches ("[a-zA-Z0-9]+");
    }
}
