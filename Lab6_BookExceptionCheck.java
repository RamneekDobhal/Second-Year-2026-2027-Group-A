
public class BookExceptionCheck {

    public static void main(String[] args) {

        try {
            // Replace these arguments with your Book constructor arguments.
            // This example assumes a title and author constructor.
            Book book = new Book("", "");

            System.out.println("Book created successfully.");

        } catch (IllegalArgumentException e) {
            System.out.println("Book exception caught: " + e.getMessage());
        }
    }
}
