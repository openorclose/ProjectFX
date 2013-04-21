package common;

//import java.io.BufferedWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class CustomFile extends File {
    private static final String EXTENSION = ".dat";
    public static String getExtension (String path) {
        try {
            return path.substring (path.lastIndexOf ('.'));
        } catch (Exception e) {
            return "";
        }
    }
    public String getExtension () {
        return getExtension (getPath());
    }
    public CustomFile (String pathname) {
        super (pathname);
    }
    public CustomFile (File parent, String child) {
        super (parent, child);
    }
    public CustomFile (String parent, String child) {
        super (parent, child);
    }

    public static String appendExtension (String fileName) {
        return fileName + EXTENSION;
    }

    public CustomFile getFolder (String filePath) {
        return new CustomFile (this, filePath);
    }
    public CustomFile getFile (String filePath) {
        return getFolder (appendExtension (filePath));
    }
    public static CustomFile getFolderAtRoot (String filePath) {
        return new CustomFile ("data", filePath);
    }
    public BufferedWriter getBufferedWriter() {
        try {
            return new BufferedWriter (new FileWriter (this, true));
        } catch (Exception e) {
            return null;
        }
    }
    public void appendText (String text) {
        try {
            BufferedWriter stream = getBufferedWriter ();
            stream.append (text);
            stream.close();
        } catch (Exception e) {

        }
    }
}
