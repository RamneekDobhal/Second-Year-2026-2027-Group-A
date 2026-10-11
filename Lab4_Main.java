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

        ### What to do with the code:
        1. Open `Main.java` in IntelliJ[cite: 2].
        2. Overwrite the old code with the final block above[cite: 8].
        3. Run `Main` to verify that your console output matches the expected output:
        ```text
Count: 3
Found: Dune
Loan Dune: true
Dune status: ON_LOAN
Loan missing: false
Return Dune: true
Dune status: AVAILABLE
Remove Clean Code: true
Final count: 2
    ```[cite: 8]
