package Controller;

import View.Manager;
import Model.Candidate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Candidate> candidates = new ArrayList<>();
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = manager.menu();
            switch (choice) {
                case 1:
                    manager.createCandidate(candidates, 0);
                    break;
                case 2:
                    manager.createCandidate(candidates, 1);
                    break;
                case 3:
                    manager.createCandidate(candidates, 2);
                    break;
                case 4:
                    System.out.print("Enter the candidate ID: ");
                    String id = scanner.nextLine();
                    manager.searchCandidate(candidates, id);
                    break;
                case 5:
                    return;
            }
        }
    }
}