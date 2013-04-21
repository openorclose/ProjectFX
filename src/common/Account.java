package common;

import java.util.ArrayList;
import java.util.Scanner;

public class Account {
    private String username;
    private ArrayList<Blog> blogs = new ArrayList<> ();
    private CustomFile blogContributionsFile;
    public Account (String username) {
        this.username = username;
        blogContributionsFile = CustomFile.getFolderAtRoot ("accounts").getFolder (username).getFile ("blogcontributions");
        loadBlogs ();
    }
    public ArrayList<Blog> getBlogs() {
        loadBlogs();
        return blogs;
    }
    public static void newAccount (String username, String password) {
        if (username.isEmpty () || password.isEmpty ()) {
            //Util.push ("Username/Password cannot be empty");
            gui.start.statusbar.Controller.add ("Username/Password cannot be empty");
            return;
        }
        if (!Util.isAlphanumeric (username)) {
            //Util.push ("Username must be alphanumeric!");
            gui.start.statusbar.Controller.add ("Username must be alphanumeric!");
            return;
        }
        CustomFile accountFile = CustomFile.getFolderAtRoot ("accounts").getFolder (username).getFile ("password");
        if (accountFile.exists()) {
            // Util.push ("Username already taken");
            gui.start.statusbar.Controller.add ("Username already taken");
            return;
        }
        try {
            accountFile.getParentFile ().mkdirs ();
            accountFile.createNewFile ();
            accountFile.appendText (password);
            gui.start.statusbar.Controller.add ("Success!");
        } catch (Exception ignored) {
        }
    }
    private void loadBlogs() {
        blogs = new ArrayList<>();
        Scanner scanner = Util.getScanner (blogContributionsFile);
        while (scanner.hasNextLine()) {
            blogs.add (new Blog (scanner.nextLine(), Current.account));
        }
    }
    public void newBlog () {
        String name = Util.promptUntilValid ("New Blog", "Name:", new Function<Boolean>() {
            public Boolean isValid (String unchecked) {
                return Util.isAlphanumeric (unchecked) && !Blog.exists (unchecked);
            }
            public String getErrorMessage() {
                return "Blog name already exists or must contain letters and numbers only";
            }
        });
        if (name!=null) {
            try {
                blogContributionsFile.appendText (name + "\n");
                CustomFile.getFolderAtRoot ("blogs").getFolder (name).mkdir ();
                gui.accountpanel.statusbar.Controller.add ("Success! Blog " + name + " was created successfully!");
            } catch (Exception e) {
            }
        }
    }
}
