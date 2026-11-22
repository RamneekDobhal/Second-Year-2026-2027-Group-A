
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BookFileStore {

    private final Path filePath;

    // Part 7: Constructor
    public BookFileStore(String fileName) {
        this.filePath = Paths.get(fileName);
    }

    // Part 7: Convert book into CSV row
    public String toCsvRow(Book book) {
        return book.getTitle() + "," + book.getAuthor();
    }

    // Part 8: Save books to CSV
    public void save(List<Book> books) throws IOException {

        List<String> rows = new ArrayList<>();

        for (Book book : books) {
            rows.add(toCsvRow(book));
        }

        Files.createDirectories(filePath.getParent());
        Files.write(filePath, rows);
    }

    // Part 9: Convert CSV row into Book
    public Book fromCsvRow(String row) {

        String[] parts = row.split(",", -1);

        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid CSV row");
        }

        return new Book(parts[0], parts[1]);
    }

    // Part 10: Load books from CSV
    public List<Book> load() throws IOException {

        List<Book> books = new ArrayList<>();

        if (!Files.exists(filePath)) {
            return books;
        }

        List<String> rows = Files.readAllLines(filePath);

        for (String row : rows) {
            if (!row.trim().isEmpty()) {
                books.add(fromCsvRow(row));
            }
        }
      

        return books;
    }
}
