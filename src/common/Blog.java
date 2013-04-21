package common;

public class Blog {
    public String name;
    public Blog (String name, Account account) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
    public static boolean exists (String name) {
        return CustomFile.getFolderAtRoot ("blogs").getFolder (name).exists();
    }
}
