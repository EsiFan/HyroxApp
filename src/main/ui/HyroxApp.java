package ui;

import model.Competitions;
import model.Hyrox;
import model.InstantHyrox;
import model.InstantsHistory;
import model.Wishlist;

import java.util.*;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// Hyrox application
@ExcludeFromJacocoGeneratedReport
public class HyroxApp {
    private Scanner input;
    private Competitions competitions;
    private InstantsHistory instantsHistory;
    private Wishlist wishlist;
    private ArrayList<Hyrox> wl;

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
        competitions = new Competitions();
        instantsHistory = new InstantsHistory();
        wishlist = new Wishlist();
        input = new Scanner(System.in);
        wl = new ArrayList<Hyrox>();
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
            // stub: save
        } else if (command.equals("l")) {
            // stub: load
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
        System.out.println("Enter Time For Ski Erg (in mins): ");
        int timeSkiErg = input.nextInt();
        System.out.println("Enter Time For Sled Push (in mins): ");
        int timeSPush = input.nextInt();
        System.out.println("Enter Time For Sled Pull (in mins): ");
        int timeSPull = input.nextInt();
        System.out.println("Enter Time For Burpee Board Jump (in mins): ");
        int timeBBJ = input.nextInt();
        System.out.println("Enter Time For Rowing (in mins): ");
        int timeRowing = input.nextInt();
        System.out.println("Enter Time For Farmers Carry (in mins): ");
        int timeFC = input.nextInt();
        System.out.println("Enter Time For Sandbag Lunges (in mins): ");
        int timeSL = input.nextInt();
        System.out.println("Enter Time For WallBall (in mins): ");
        int timeWallBall = input.nextInt();
        System.out.println("Enter Sum Time for Running (in mins): ");
        int sumTimeRuns = input.nextInt();
        InstantHyrox instance = new InstantHyrox(title, timeSkiErg, timeSPush, timeSPull, timeBBJ, timeRowing, timeFC,
                timeSL, timeWallBall, sumTimeRuns);
        instantsHistory.addInstant(instance);
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
                if (minRec >= record && notDuplicate(cmp)) {
                    wl.add(cmp);
                }
            }

            wishlist.addHyroxs(wl);
        } else {
            System.out.println("No instantces... ");
        }
    }

    // EFFECTS: prints out the wishlist of the comps the user is possibly going to
    private void doViewWishlist() {
        int wlLength = wishlist.getWishlist().size();
        ArrayList<Hyrox> wl = wishlist.getWishlist();
        if (!(wlLength == 0)) {
            System.out.println("The list of Hyroxs that you are eligible for: ");

            for (int i = 0; i < wlLength; i++) {
                Hyrox h = wl.get(i);
                System.out.println(h.getTitle());
            }
        } else {
            System.out.println("No competitions... ");
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

    // EFFECTS: checks if the given hyrox is a duplicate in wishlist or not
    private boolean notDuplicate(Hyrox hyrox) {
        for(Hyrox h : wishlist.getWishlist()) {
            if (h.equals(hyrox)) {
                return false;
            }
        }
        return true;
    }

}
