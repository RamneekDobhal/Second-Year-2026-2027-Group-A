
package org.example;

public class RegistrationReport {

    public static void displayReport(Registrations registrations) {

        Workshop workshop = registrations.getWorkshop();

        System.out.println("\n===== WORKSHOP REPORT =====");

        System.out.println("Workshop: "
                + workshop.getWorkshopName());

        System.out.println("\nRegistered Student IDs:");

        for (String studentID :
                workshop.getRegisteredStudentIDs()) {

            System.out.println(studentID);
        }

        System.out.println("\nAccepted registrations: "
                + registrations.getAcceptedRegistrations());

        System.out.println("Rejected registrations: "
                + registrations.getRejectedRegistrations());

        System.out.println("Blank IDs rejected: "
                + registrations.getBlankRejected());

        System.out.println("Invalid IDs rejected: "
                + registrations.getInvalidRejected());

        System.out.println("Duplicate IDs rejected: "
                + registrations.getDuplicateRejected());

        System.out.println("Workshop full rejections: "
                + registrations.getFullRejected());

        System.out.println("Places remaining: "
                + workshop.getPlacesRemaining());

        System.out.println("===========================");
    }
}
