import java.util.Scanner;

public class ExceptionWarmUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter a page count: ");
            String text = scanner.nextLine();
            try {
                int pageCount = Integer.parseInt(text);
                System.out.println("Page count = " + pageCount);
                valid = true;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a whole number.");
            }
        }
        System.out.println("Program continues.");
    }
}
```[cite: 49]

#### 2. `BookExceptionCheck.java` (Part 3)
Create this file to trigger and catch validation exceptions from the `Book` class[cite: 50]:
```java
public class BookExceptionCheck {
    public static void main(String[] args) {
        try {
            Book invalid = new Book("", "Frank Herbert", 412);
            System.out.println(invalid.getTitle());
        } catch (IllegalArgumentException ex) {
            System.out.println("Book rejected: " + ex.getMessage());
        }
    }
}
```[cite: 50]

#### 3. `PathExplorer.java` (Part 4)
Create this file to inspect file-system paths using `java.nio.file`[cite: 50]:
```java
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
```[cite: 50]

#### 4. Update `LibraryService.java` (Part 6)
Add this method to your existing `LibraryService` class so external classes can access books safely without mutating the internal list directly[cite: 53]:
```java
public List<Book> getBooks() {
    return new ArrayList<>(books);
}
```[cite: 53]

#### 5. `BookFileStore.java` (Parts 7, 8, 9, 10)
Create this new class to manage CSV file reading, writing, and object reconstruction[cite: 43, 53, 54, 55]:
```java
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
```[cite: 53, 54, 55]

#### 6. Final `Main.java` (Part 11)
Replace the code in your main application class with this final persistence flow (loads existing data first, or creates sample books if empty, and saves changes at the end)[cite: 56]:
```java
import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();
        BookFileStore store = new BookFileStore(Path.of("data", "books.csv"));

        try {
            for (Book book : store.load()) {
                service.addBook(book);
            }
            System.out.println("Loaded: " + service.getBookCount());
        } catch (IOException ex) {
            System.out.println("Load failed: " + ex.getMessage());
            return;
        }

        if (service.getBookCount() == 0) {
            Book dune = new Book("Dune", "Frank Herbert", 412);
            Book cleanCode = new Book("Clean Code", "Robert C. Martin", 464);
            service.addBook(dune);
            service.addBook(cleanCode);
            service.loanBook("Dune", 7);
        }

        for (Book book : service.getBooks()) {
            System.out.println(book.getTitle() + " - " + book.getStatus());
        }

        try {
            store.save(service.getBooks());
            System.out.println("Saved: " + service.getBookCount());
        } catch (IOException ex) {
            System.out.println("Save failed: " + ex.getMessage());
        }
    }
}
```[cite: 56]
