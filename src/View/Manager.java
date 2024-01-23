package View;

import Controller.Validation;
import Model.Candidate;
import Model.Experience;
import Model.Fresher;
import Model.Internship;

import java.util.ArrayList;
import java.util.Calendar;

public class Manager {

private final Validation validation;

public Manager() {
    validation = new Validation();
}

public int menu() {
    System.out.println("1. Experience");
    System.out.println("2. Fresher");
    System.out.println("3. Internship");
    System.out.println("4. Searching");
    System.out.println("5. Exit");
    System.out.print("Enter your choice: ");
    int choice = validation.checkInputIntLimit(1, 5);
    return choice;
}

public void createCandidate(ArrayList<Candidate> candidates, int type) {
    while (true) {
        System.out.print("Enter Id: ");
        String id = validation.checkInputString();
        System.out.print("Enter first name: ");
        String firstName = validation.checkInputName();
        System.out.print("Enter lastname: ");
        String lastName = validation.checkInputName();
        System.out.print("Enter birth date: ");
        int birthDate = validation.checkInputIntLimit(1900, Calendar.getInstance().get(Calendar.YEAR));
        System.out.print("Enter address: ");
        String address = validation.checkInputString();
        System.out.print("Enter phone: ");
        String phone = validation.checkInputPhone();
        System.out.print("Enter email: ");
        String email = validation.checkInputEmail();
        switch (type) {
            case 1:
                System.out.print("Enter year of experience: ");
                int yearExperience = validation.checkInputExprience(birthDate);
                String proSkill = validation.checkInputString();
                candidates.add(new Experience(yearExperience, proSkill, id, firstName, lastName, birthDate, address, phone, email));
                break;
            case 2:
                System.out.print("Enter graduation date: ");
                int graduationDate = validation.checkInputIntLimit(birthDate + 18, Calendar.getInstance().get(Calendar.YEAR));
                System.out.print("Enter graduation rank: ");
                String graduationRank = validation.checkInputGraduationRank();
                candidates.add(new Fresher(graduationDate, graduationRank, id, firstName, lastName, birthDate, address, phone, email));
                break;
            case 3:
                System.out.print("Enter major: ");
                String major = validation.checkInputString();
                System.out.print("Enter semester: ");
                String semester = validation.checkInputString();
                System.out.print("Enter university name: ");
                String universityName = validation.checkInputString();
                candidates.add(new Internship(major, semester, universityName, id, firstName, lastName, birthDate, address, phone, email));
                break;
        }
        System.out.print("Do you want to enter more candidate information? (Y/N): ");
        if (!validation.checkInputYN()) {
            return;
        }
    }
}

public void searchCandidate(ArrayList<Candidate> candidates, String id) {
    for (Candidate candidate : candidates) {
        if (candidate.getId().equalsIgnoreCase(id)) {
            candidate.display();
            return;
        }
    }
    System.err.println("Id does not exist.");
}

public void display(ArrayList<Candidate> candidates) {
    for (Candidate candidate : candidates) {
        candidate.display();
    }
}
}