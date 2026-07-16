package ui;

import model.Competitions;
import model.Hyrox;
import model.InstantHyrox;
import model.InstantsHistory;

import java.util.Scanner;

public class HyroxApp {
    private Scanner input;

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
            
        }
    }

    // EFFECTS: shows menu options to the user
    private void showMenu() {
        System.out.println("\nOptions:");
        System.out.println("\th -> Make Hyrox");
        System.out.println("\ti -> Record and instant");
        System.out.println("\tw -> view wishlist");
        System.out.println("\te -> exit");
    }
    
}
