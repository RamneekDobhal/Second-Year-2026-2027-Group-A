
package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Workshop Registration System");

        System.out.print("Enter workshop name: ");
        String workshopName = scanner.nextLine();

        System.out.print("Enter workshop capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        if (capacity <= 0) {
            System.out.println("Capacity must be greater than zero.");
            scanner.close();
            return;
        }

        Workshop workshop = new Workshop(workshopName, capacity);

        Registrations registrations =
                new Registrations(workshop);

        System.out.print("How many registration attempts? ");
        int attempts = scanner.nextInt();
        scanner.nextLine();

        if (attempts < 0) {
            System.out.println("Invalid number of attempts.");
            scanner.close();
            return;
        }

        for (int i = 1; i <= attempts; i++) {

            System.out.print("Enter student ID for attempt "
                    + i + ": ");

            String studentID = scanner.nextLine();

            String result =
                    registrations.registerStudent(studentID);

            System.out.println(result);
        }

        RegistrationReport.displayReport(registrations);

        scanner.close();
    }
}
