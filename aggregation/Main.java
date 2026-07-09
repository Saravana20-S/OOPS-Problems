package com.oops.aggregation;

import java.util.ArrayList;
import java.util.List;

// Professor Class (Independent)
class Professor {
    private int professorId;
    private String name;
    private String subject;

    public Professor(int professorId, String name, String subject) {
        this.professorId = professorId;
        this.name = name;
        this.subject = subject;
    }

    public void displayProfessor() {
        System.out.println("Professor ID : " + professorId);
        System.out.println("Name         : " + name);
        System.out.println("Subject      : " + subject);
    }
}

// University Class (Aggregation)
class University {
    private String universityName;
    private List<Professor> professors;

    public University(String universityName) {
        this.universityName = universityName;
        this.professors = new ArrayList<>();
    }

    public void addProfessor(Professor p) {
        professors.add(p);
        System.out.println("Added " + p);
    }

    public void removeProfessor(Professor p) {
        professors.remove(p);
        System.out.println("Removed " + p);
    }

    public void displayUniversityDetails() {
        System.out.println("University : " + universityName);
        System.out.println("Professors:");
        for (Professor p : professors) {
            p.displayProfessor();
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        Professor p1 = new Professor(1, "Dr. Kumar", "Physics");
        Professor p2 = new Professor(2, "Dr. Meena", "Mathematics");

        University uni = new University("ABC University");

        uni.addProfessor(p1);
        uni.addProfessor(p2);

        uni.displayUniversityDetails();

        uni = null;
        System.out.println("University removed");

        // Professors still exist independently
        System.out.println("Professors still exist:");
        p1.displayProfessor();
        p2.displayProfessor();
    }
}