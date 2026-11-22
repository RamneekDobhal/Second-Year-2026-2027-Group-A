
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BookFileStore store = new BookFileStore("data/books.csv");

        try {

            // Load books from CSV
            List<Book> books = store.load();

            System.out.println("Library Books:");

            // Display books
            for (Book book : books) {
                System.out.println(book.getTitle()
                    + " - " + book.getAuthor());
            }

            // Save books back to CSV
            store.save(books);

            System.out.println("Books saved successfully.");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
