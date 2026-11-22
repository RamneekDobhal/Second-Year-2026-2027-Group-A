
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class PathExplorer {

    public static void main(String[] args) {

        Path path = Paths.get("data/books.csv");

        System.out.println("File path: " + path);

        if (Files.exists(path)) {
            System.out.println("The file exists.");
        } else {
            System.out.println("The file does not exist.");
        }
    }
}
