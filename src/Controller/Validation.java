package Controller;

import Model.Candidate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Validation {

private final Scanner in;

private final String PHONE_VALID = "^\\d{10}\\d*$";
private final String EMAIL_VALID = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";

public Validation() {
    in = new Scanner(System.in);
}

public int checkInputIntLimit(int min, int max) {
    while (true) {
        try {
            int result = Integer.parseInt(in.nextLine().trim());
            if (result < min || result > max) {
                throw new NumberFormatException();
            }
            return result;
        } catch (NumberFormatException e) {
            System.err.println("Please input number from [" + min + " to " + max + "]");
            System.out.print("Enter again: ");
        }
    }
}

public String checkInputString() {
    while (true) {
        String result = in.nextLine().trim();
        if (result.isEmpty()) {
            System.err.println("Cannot be empty");
            System.out.print("Enter again: ");
        } else {
            return result;
        }
    }
}

public boolean checkInputYN() {
    while (true) {
        String result = checkInputString();
        if (result.equalsIgnoreCase("Y")) {
            return true;
        } else if (result.equalsIgnoreCase("N")) {
            return false;
        }
        System.err.println("Please input Y/y or N/n.");
        System.out.print("Enter again: ");
    }
}

public String checkInputName() {
    while (true) {
        String result = in.nextLine().trim();
        if (result.isEmpty() || !result.matches("[a-zA-Z]+")) {
            System.err.println("Invalid input. Please enter a valid name (alphabetical characters only).");
            System.out.print("Enter again: ");
        } else {
            return result;
        }
    }
}

public String checkInputPhone() {
    while (true) {
        String result = checkInputString();
        if (result.matches(PHONE_VALID)) {
            return result;
        } else {
            System.err.println("Phone number should contain at least 10 digits");
            System.out.print("Enter again: ");
        }
    }
}

public String checkInputEmail() {
    while (true) {
        String result = checkInputString();
        if (result.matches(EMAIL_VALID)) {
            return result;
        } else {
            System.err.println("Invalid email format. Please enter a valid email address.");
            System.out.print("Enter again: ");
        }
    }
}

public String checkInputGraduationRank() {
    while (true) {
        String result = checkInputString();
        if (result.equalsIgnoreCase("Excellence")
                || result.equalsIgnoreCase("Good")
                || result.equalsIgnoreCase("Fair")
                || result.equalsIgnoreCase("Poor")) {
            return result;
        } else {
            System.err.println("Only allowed values: Excellence, Good, Fair, Poor");
            System.out.print("Enter again: ");
        }
    }
}

public boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
    for (Candidate candidate : candidates) {
        if (candidate.getId().equalsIgnoreCase(id)) {
            System.err.println("ID already exists.");
            return false;
        }
    }
    return true;
}

public int checkInputExprience(int birthDate) {
    int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
    int age = yearCurrent - birthDate;
    while (true) {
        int yearExperience = checkInputIntLimit(1, 100);
        if (yearExperience > age) {
            System.err.println("Experience must be less than age.");
        } else {
            return yearExperience;
        }
    }
}
}