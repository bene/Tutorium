import java.io.File;

public class Rekursion {

    public static void main(String[] args) {
        // listFolder(new File("Data"), "");
        rekursiv(0);
    }

    static void rekursiv(int a) {
        System.out.printf("Hinweg: %d\n", a);
        if (a < 3) {
            rekursiv(a + 1);
        }
        System.out.printf("Rückweg: %d\n", a);
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
