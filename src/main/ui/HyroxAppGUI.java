package ui;

import model.Competitions;
import model.Hyrox;
import model.InstantHyrox;
import model.InstantsHistory;
import model.Wishlist;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// Hyrox app w Graphical User Interface
@ExcludeFromJacocoGeneratedReport
public class HyroxAppGUI  extends JFrame implements ActionListener{
    private static final String JSON_STORE = "./data/hyroxApp.json";
    private Scanner input;
    private Competitions competitions;
    private InstantsHistory instantsHistory;
    private Wishlist wishlist;
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;
    private ArrayList<String> wl;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu viewMenu;
    private JMenu addMenu;
    private JMenu quitMenu;
    private JMenuItem saveItem;
    private JMenuItem loadItem;
    private JMenuItem quitItem;

    // EFFECTS: runs the hyrox application
    public HyroxAppGUI() {
        init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setTitle("HyroxApp");
        this.setLayout(new FlowLayout());

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        viewMenu = new JMenu("View");
        addMenu = new JMenu("Add");
        quitMenu = new JMenu("Quit");

        saveItem = new JMenuItem("save");
        saveItem.addActionListener(this);
        loadItem = new JMenuItem("load");
        loadItem.addActionListener(this);

        quitItem = new JMenuItem("quit");
        quitItem.addActionListener(this);

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(addMenu);
        menuBar.add(quitMenu);

        fileMenu.add(saveItem);
        fileMenu.add(loadItem);

        quitMenu.add(quitItem);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quitItem) {
            System.exit(0);
        }

        if (e.getSource() == saveItem) {
            saveHyroxAppData();
        }

        if (e.getSource() == loadItem) {
            loadSavedHyroxAppData();
        }
    }
}
