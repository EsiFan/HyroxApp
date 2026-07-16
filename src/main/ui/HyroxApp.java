package ui;

import model.Competitions;
import model.Hyrox;
import model.InstantHyrox;
import model.InstantsHistory;

import java.util.Scanner;

// Hyrox application
public class HyroxApp {
    private Scanner input;
    private Competitions competitions;

    // EFFECTS: tuns the hyrox application
    public HyroxApp() {
        runHyrox();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runHyrox() {
        boolean carryOn = true;
        String key = null;

        while (carryOn) {
            showMenu();
            key = input.next();

            if (key.equals("q")) {
                carryOn = false;
            } else {
                processKey(key);
            }
        }

        System.out.println("\nExitting application now...");
    }

    // EFFECTS: shows menu options to the user
    private void showMenu() {
        System.out.println("\nOptions:");
        System.out.println("\th -> Make Hyrox");
        System.out.println("\ti -> Record and instant");
        System.out.println("\tw -> view wishlist");
        System.out.println("\te -> exit");
    }

    // MODIFIES: this
    // EFFECTS: processes user key inputs
    private void processKey(String command) {
        if (command.equals("h")) {
            doMakeHyrox();
        } else if (command.equals("i")) {
            doRecordInstant();
        } else if (command.equals("w")) {
            doViewWishlist();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: makes a hyrox and adds it to the list of competitions
    // MODIFIES: this
    private void doMakeHyrox() {
        System.out.print("Enter The Hyrox Title: $");
        String title = input.nextLine();
        System.out.print("Enter The Hyrox Weight Class: $");
        int weightClass = input.nextInt();
        String gender = recordGender();
        System.out.print("Enter The Hyrox Minimum Time Record: $");
        int minTimeRec = input.nextInt();
        Hyrox hyrox = new Hyrox(title, weightClass, gender, minTimeRec);
        competitions.addComp(hyrox);
    }
    
    // EFFECTS: records the gender of the hyrox and rejectss invalid entries
    // MODIFIES: this
    private String recordGender() {
        System.out.print("Enter The Hyrox Gender: $");
        String choice;
        while (true) {
            choice = input.nextLine();
            choice = choice.toLowerCase();

            if (choice == "male" || choice == "female" || choice == "mixed") {
                return choice;
            } else {
                System.out.println("gender has to be chosen from male/female/mixed ...");
            }
        }
    }
}
