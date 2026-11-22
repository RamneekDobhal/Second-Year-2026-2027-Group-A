
public class ExceptionWarmUp {

    public static void main(String[] args) {

        String number = "123";

        try {
            int result = Integer.parseInt(number);
            System.out.println("Number: " + result);

            String invalidNumber = "ABC";
            int result2 = Integer.parseInt(invalidNumber);

            System.out.println("Number: " + result2);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format.");
        }

        System.out.println("Program continues running.");
    }
}
