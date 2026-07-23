package ui;

import model.Competitions;
import model.Hyrox;
import model.InstantHyrox;
import model.InstantsHistory;
import model.Wishlist;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// Hyrox application
@ExcludeFromJacocoGeneratedReport
public class HyroxApp {
    private static final String JSON_STORE = "./data/hyroxApp.json";
    private Scanner input;
    private Competitions competitions;
    private InstantsHistory instantsHistory;
    private Wishlist wishlist;
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;
    private ArrayList<String> wl;

    // EFFECTS: tuns the hyrox application
    public HyroxApp() {
        runHyrox();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runHyrox() {
        boolean carryOn = true;
        String key = null;

        init();

        while (carryOn) {
            showMenu();
            key = input.next();

            if (key.equals("e")) {
                carryOn = false;
            } else {
                processKey(key);
            }
        }

        System.out.println("\nExitting application now...");
    }

    // EFFECTS: Initializes the aspects of the app
    // MODIFIES: this
    private void init() {
        input = new Scanner(System.in);
        competitions = new Competitions();
        instantsHistory = new InstantsHistory();
        wishlist = new Wishlist();
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        wl = new ArrayList<String>();
    }

    // EFFECTS: shows menu options to the user
    private void showMenu() {
        System.out.println("\nOptions:");
        System.out.println("\th -> Make a Hyrox Competition");
        System.out.println("\ti -> Record a Practice Hyrox");
        System.out.println("\tu -> Update Wishlist ith Eligible");
        System.out.println("\tw -> View Wishlist");
        System.out.println("\ts -> Save the Competitions, Practice Runs, and Wishlist to file");
        System.out.println("\tl -> Load the Competitions, Practice Runs, and Wishlist to file");
        System.out.println("\te -> Exit");
    }

    // MODIFIES: this
    // EFFECTS: processes user key inputs
    private void processKey(String command) {
        if (command.equals("h")) {
            doMakeHyrox();
        } else if (command.equals("i")) {
            doRecordInstant();
        } else if (command.equals("u")) {
            doUpdateWishlist();
        } else if (command.equals("w")) {
            doViewWishlist();
        } else if (command.equals("s")) {
            saveHyroxAppData();
        } else if (command.equals("l")) {
            loadSavedHyroxAppData();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: makes a hyrox and adds it to the list of competitions
    // MODIFIES: this
    private void doMakeHyrox() {
        input.nextLine();
        System.out.print("Enter The Hyrox Title: ");
        String title = input.nextLine();
        System.out.print("Enter The Hyrox Weight Class (in lbs): ");
        int weightClass = input.nextInt();
        String gender = recordGender();
        System.out.print("Enter The Hyrox Minimum Time Record (in mins): ");
        int minTimeRec = input.nextInt();
        Hyrox hyrox = new Hyrox(title, weightClass, gender, minTimeRec);
        competitions.addComp(hyrox);
    }

    // EFFECTS: makes a hyrx instant and adds to the uers history
    // MODIFIES: this
    private void doRecordInstant() {
        input.nextLine();
        System.out.println("Enter The Instant Title: ");
        String title = input.nextLine();
        int timeSkiErg = recordTime("Ski Erg");
        int timeSPush = recordTime("Sled Push");
        int timeSPull = recordTime("Sled Pull");
        int timeBBJ = recordTime("Burpee Board Jump");
        int timeRowing = recordTime("Rowing");
        int timeFC = recordTime("Farmers Carry");
        int timeSL = recordTime("Sandbag Lunges");
        int timeWallBall = recordTime("WallBall");
        int sumTimeRuns = recordTime("Running");
        InstantHyrox instance = new InstantHyrox(title, timeSkiErg, timeSPush, timeSPull, timeBBJ, timeRowing, timeFC,
                timeSL, timeWallBall, sumTimeRuns);
        instantsHistory.addInstant(instance);
    }

    // EEFECTS: records time from user entry and returns it
    private int recordTime(String forExercise) {
        System.out.println("Enter Time For " + forExercise + " (in mins): ");
        return input.nextInt();
    }

    // EFFECTS: updates thee wishliist with the hyroxes
    // that user is eligible for
    // MODIFIES: this
    private void doUpdateWishlist() {
        int lengthComp = competitions.getCompetitions().size();
        int lengthInsHis = instantsHistory.getInstantsHistory().size();
        int record;
        wl.clear();
        if (!(lengthInsHis == 0)) {
            InstantHyrox lastInstant = instantsHistory.getInstantsHistory().get(lengthInsHis - 1);
            record = lastInstant.totalTime();

            for (int i = 0; i < lengthComp; i++) {
                Hyrox cmp = competitions.getCompetitions().get(i);
                int minRec = cmp.getMinTimeRec();
                if (minRec >= record && notDuplicate(cmp.getTitle())) {
                    wl.add(cmp.getTitle());
                }
            }

            wishlist.addHyroxs(wl);
        } else {
            System.out.println("No instantces... ");
        }
    }

    // EFFECTS: prints out the wishlist of the titles comps the user is possibly going to
    private void doViewWishlist() {
        int wlLength = wishlist.getWishlist().size();
        ArrayList<String> wl = wishlist.getWishlist();
        if (!(wlLength == 0)) {
            System.out.println("The list of Hyroxs that you are eligible for: ");

            for (int i = 0; i < wlLength; i++) {
                String h = wl.get(i);
                System.out.println(h);
            }
        } else {
            System.out.println("No competitions... ");
        }
    }

    // modeled from example project JsonSerialization
    // MODIFIES: this
    // EFFECTS: loads Competitions, InstantsHistory, and Wishlist from file
    private void loadSavedHyroxAppData() {
        try {
            competitions = jsonReader.readCompetitions();
            System.out.println("Loaded saved competitions from " + JSON_STORE);
            instantsHistory = jsonReader.readInstantsHistory();
            System.out.println("Loaded saved practice runs data from " + JSON_STORE);
            wishlist = jsonReader.readWishlist();
            System.out.println("Loaded saved wishlist competitions from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // modeled from example project JsonSerialization
    // EFFECTS: saves the Competitions, InstantsHistory, and Wishlist to file
    private void saveHyroxAppData() {
        try {
            jsonWriter.open();
            jsonWriter.write(competitions, instantsHistory, wishlist);
            jsonWriter.close();
            System.out.println("Saved Competitions to " + JSON_STORE);
            System.out.println("Saved Instants History to " + JSON_STORE);
            System.out.println("Saved Wishlist to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: records the gender of the hyrox and rejectss invalid entries
    // MODIFIES: this
    private String recordGender() {
        System.out.print("Enter The Hyrox Gender: ");
        input.nextLine();
        while (true) {
            String choice = input.nextLine();
            choice = choice.toLowerCase();

            if (choice.equals("male") || choice.equals("female")
                    || choice.equals("mixed")) {
                return choice;
            } else {
                System.out.println("gender has to be chosen from male/female/mixed ...");
            }
        }
    }

    // EFFECTS: checks if the given hyroxTitle is a duplicate in wishlist or not
    private boolean notDuplicate(String hyroxTitle) {
        for (String h : wishlist.getWishlist()) {
            if (h.equals(hyroxTitle)) {
                return false;
            }
        }
        return true;
    }

}
