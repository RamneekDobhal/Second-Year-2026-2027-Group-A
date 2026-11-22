
package org.example;

public class Registrations {

    private Workshop workshop;

    private int acceptedRegistrations;
    private int rejectedRegistrations;
    private int blankRejected;
    private int invalidRejected;
    private int duplicateRejected;
    private int fullRejected;

    public Registrations(Workshop workshop) {
        this.workshop = workshop;
    }

    public String registerStudent(String studentID) {

        if (studentID == null || studentID.trim().isEmpty()) {
            rejectedRegistrations++;
            blankRejected++;
            return "Rejected: Blank student ID.";
        }

        studentID = studentID.trim().toUpperCase();

        // Check ATU-style student ID format.
        if (!studentID.matches("G\\d{8}")) {
            rejectedRegistrations++;
            invalidRejected++;
            return "Rejected: Invalid student ID format.";
        }

        if (workshop.isRegistered(studentID)) {
            rejectedRegistrations++;
            duplicateRejected++;
            return "Rejected: Student already registered.";
        }

        if (workshop.isFull()) {
            rejectedRegistrations++;
            fullRejected++;
            return "Rejected: Workshop is full.";
        }

        workshop.addStudent(studentID);
        acceptedRegistrations++;

        return "Registration successful.";
    }

    public int getAcceptedRegistrations() {
        return acceptedRegistrations;
    }

    public int getRejectedRegistrations() {
        return rejectedRegistrations;
    }

    public int getBlankRejected() {
        return blankRejected;
    }

    public int getInvalidRejected() {
        return invalidRejected;
    }

    public int getDuplicateRejected() {
        return duplicateRejected;
    }

    public int getFullRejected() {
        return fullRejected;
    }

    public Workshop getWorkshop() {
        return workshop;
    }
}
