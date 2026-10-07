public class LibraryService {
    private static final int MAX_LOAN_DAYS = 14;

    public void loanBook(Book book, int loanDays) {
        if (book == null) {
            throw new IllegalArgumentException("Book must not be null");
        }
        if (loanDays < 1 || loanDays > MAX_LOAN_DAYS) {
            throw new IllegalArgumentException("Loan days must be from 1 to 14");
        }
        book.borrowBook();
    }

    public void returnBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book must not be null");
        }
        book.returnBook();
    }
}
