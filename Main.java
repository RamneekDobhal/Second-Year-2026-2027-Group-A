public class Main {
    public static void main(String[] args) {
        Book first = new Book("Dune", "Frank Herbert", 412);
        Book second = new Book("Clean Code", "Robert C. Martin", 464);
        LibraryService service = new LibraryService();

        System.out.println(first.getStatus());
        service.loanBook(first, 7);
        System.out.println(first.getStatus());
        service.returnBook(first);
        System.out.println(first.getStatus());
        System.out.println(second.getStatus());

        try {
            service.loanBook(first, 15);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(first.getStatus());
    }
}
