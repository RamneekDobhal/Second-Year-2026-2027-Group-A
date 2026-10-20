import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BookFileStore {
    private final Path file;

    public BookFileStore(Path file) {
        this.file = file;
    }

    private String toCsvRow(Book book) {
        return book.getTitle() + ","
                + book.getAuthor() + ","
                + book.getPageCount() + ","
                + book.getStatus();
    }

    public void save(List<Book> books) throws IOException {
        Files.createDirectories(file.getParent());
        List<String> lines = new ArrayList<>();
        lines.add("title, author, pageCount, status");
        for (Book book : books) {
            lines.add(toCsvRow(book));
        }
        Files.write(file, lines);
    }

    private Book fromCsvRow(String row) {
        String[] parts = row.split(",", -1);
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid CSV row: " + row);
        }
        int pageCount = Integer.parseInt(parts[2]);
        Book book = new Book(parts[0], parts[1], pageCount);
        if (parts[3].equals("ON_LOAN")) {
            book.borrowBook();
        }
        return book;
    }

    public List<Book> load() throws IOException {
        List<Book> books = new ArrayList<>();
        if (Files.notExists(file)) {
            return books;
        }
        List<String> lines = Files.readAllLines(file);
        for (int i = 1; i < lines.size(); i++) {
            String row = lines.get(i);
            if (!row.isBlank()) {
                books.add(fromCsvRow(row));
            }
        }
        return books;
    }
}
