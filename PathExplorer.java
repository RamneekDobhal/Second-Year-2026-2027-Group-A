import java.nio.file.Files;
import java.nio.file.Path;

public class PathExplorer {
    public static void main(String[] args) {
        Path file = Path.of("data", "books.csv");
        
        System.out.println("Path: " + file);
        System.out.println("File name: " + file.getFileName());
        System.out.println("Parent: " + file.getParent());
        System.out.println("Absolute: " + file.toAbsolutePath());
        System.out.println("Exists: " + Files.exists(file));
    }
}
