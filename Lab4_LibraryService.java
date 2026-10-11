public class LibraryService {
    private static final int MAX_LOAN_DAYS = 14;

    public void loanBook(Book book, int loanDays) {
    if (book == null) {
    throw new IllegalArgumentException("Book must not be null");
    import java.util.ArrayList;
    import java.util.List;
}
}
if (loanDays < 1 || loanDays > MAX_LOAN_DAYS) {
    throw new IllegalArgumentException("Loan days must be from 1 to 14");
    private final List<Book> books = new ArrayList<>();

book.borrowBook();
}

public void addBook(Book book) {
    if (book == null) {
        throw new IllegalArgumentException("Book must not be null");
    }
    books.add(book);
}
```[cite: 3]

* **`getBookCount` and `getAllBooks`**:
```java
public int getBookCount() {
    return books.size();
}

public List<Book> getAllBooks() {
    return new ArrayList<>(books);
}
```[cite: 4]

* **`findBookByTitle`**:
```java
public Book findBookByTitle(String title) {
    for (Book book : books) {
        if (book.getTitle().equalsIgnoreCase(title)) {
            return book;
        }
    }
    return null;
}
```[cite: 5]

* **`removeBook` (Independent Task)**:
```java
public boolean removeBook(String title) {
    Book book = findBookByTitle(title);
    if (book == null) {
        return false;
    }
    books.remove(book);
    return true;
}
```[cite: 6]

* **Updated `loanBook` and `returnBook`**:
```java
public boolean loanBook(String title, int loanDays) {
    if (loanDays < 1 || loanDays > MAX_LOAN_DAYS) {
        throw new IllegalArgumentException("Loan days must be from 1 to 14");
    }
    Book book = findBookByTitle(title);
    if (book == null) {
        return false;
    }
    book.borrowBook();
    return true;
}

public boolean returnBook(String title) {
    Book book = findBookByTitle(title);
    if (book == null) {
        return false;
    }
    book.returnBook();
    return true;
}
```[cite: 7]

---

### 2. Updates to `Main.java`

For the final verification check of your completed catalogue, replace your `Main.java` contents with this complete class[cite: 8]:

```java
public class Main {
    public static void main(String[] args) {
    Book dune = new Book("Dune", "Frank Herbert", 412);
    Book nineteenEightyFour = new Book("1984", "George Orwell", 328);
    Book cleanCode = new Book("Clean Code", "Robert C. Martin", 464);

    LibraryService service = new LibraryService();
    service.addBook(dune);
    service.addBook(nineteenEightyFour);
    service.addBook(cleanCode);

    System.out.println("Count: " + service.getBookCount());

    Book found = service.findBookByTitle("Dune");
    if (found != null) {
    System.out.println("Found: " + found.getTitle());
}

System.out.println("Loan Dune: " + service.loanBook("Dune", 7));
System.out.println("Dune status: " + dune.getStatus());
System.out.println("Loan missing: " + service.loanBook("The Hobbit", 7));
System.out.println("Return Dune: " + service.returnBook("Dune"));
System.out.println("Dune status: " + dune.getStatus());
System.out.println("Remove Clean Code: " + service.removeBook("Clean Code"));
System.out.println("Final count: " + service.getBookCount());
}
}
```[cite: 8]
}
}
