import java.io.File;

public class Rekursion {

    public static void main(String[] args) {
        listFolder(new File("Data"), "");
    }

    static void listFolder(File folder, String prefix) {
        for (int i = 0; i < folder.listFiles().length; i++) {

            File fileOrFolder = folder.listFiles()[i];
            if (!fileOrFolder.isDirectory()) {
                System.out.println(prefix + fileOrFolder.getName());
            } else {
                listFolder(fileOrFolder, prefix + "  ");
            }
        }
    }
}
