public class Book {
    private final String title;
    private final String author;
    private final int pageCount;
    private BookStatus status;

    public Book(String title, String author, int pageCount) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be blank");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author must not be blank");
        }
        if (pageCount <= 0) {
            throw new IllegalArgumentException("Page count must be positive");
        }

        this.title = title.trim();
        this.author = author.trim();
        this.pageCount = pageCount;
        this.status = BookStatus.AVAILABLE;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void borrowBook() {
        if (status == BookStatus.ON_LOAN) {
            throw new IllegalStateException("Book is already on loan");
        }
        status = BookStatus.ON_LOAN;
    }

    public void returnBook() {
        if (status == BookStatus.AVAILABLE) {
            throw new IllegalStateException("Book is already available");
        }
        status = BookStatus.AVAILABLE;
    }
}
