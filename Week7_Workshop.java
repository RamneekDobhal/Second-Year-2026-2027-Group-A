
package org.example;

import java.util.HashSet;
import java.util.Set;

public class Workshop {

    private String workshopName;
    private int capacity;
    private HashSet<String> registeredStudentIDs;

    // Constructor
    public Workshop(String workshopName, int capacity) {
        this.workshopName = workshopName;
        this.capacity = capacity;
        this.registeredStudentIDs = new HashSet<>();
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public int getCapacity() {
        return capacity;
    }

    public Set<String> getRegisteredStudentIDs() {
        return new HashSet<>(registeredStudentIDs);
    }

    public boolean isFull() {
        return registeredStudentIDs.size() >= capacity;
    }

    public boolean isRegistered(String studentID) {
        return registeredStudentIDs.contains(studentID);
    }

    public boolean addStudent(String studentID) {

        if (isFull() || isRegistered(studentID)) {
            return false;
        }

        return registeredStudentIDs.add(studentID);
    }

    public int getPlacesRemaining() {
        return capacity - registeredStudentIDs.size();
    }
}
