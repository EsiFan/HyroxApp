package ui;

import model.Competitions;
import model.Hyrox;
import model.InstantHyrox;
import model.InstantsHistory;
import model.Wishlist;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// Hyrox app w Graphical User Interface
@ExcludeFromJacocoGeneratedReport
public class HyroxAppGUI extends JFrame implements ActionListener {
    private static final String JSON_STORE = "./data/hyroxApp.json";
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
    private JMenuItem wishlistItem;
    private JMenuItem hyroxItem;
    private JMenuItem instantItem;
    private JPanel panel;

    // EFFECTS: runs the hyrox application
    // MODIFIES: this
    public HyroxAppGUI() {
        init();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setTitle("HyroxApp");
        this.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        menuBar = new JMenuBar();

        menuSetup();

        menuItemSetup();

        addMenuItems();

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    // EFFECTS: makes the menus
    private void menuSetup() {
        fileMenu = new JMenu("File");
        viewMenu = new JMenu("View");
        addMenu = new JMenu("Add");
        quitMenu = new JMenu("Quit");
    }

    // EFFECTS: makes the menu items
    private void menuItemSetup() {
        saveItem = new JMenuItem("save"); // File menu items
        saveItem.addActionListener(this);
        loadItem = new JMenuItem("load");
        loadItem.addActionListener(this);

        wishlistItem = new JMenuItem("wishlist"); // View menu items
        wishlistItem.addActionListener(this);

        hyroxItem = new JMenuItem("hyrox"); // File menu items
        hyroxItem.addActionListener(this);
        instantItem = new JMenuItem("ionstant");
        instantItem.addActionListener(this);

        quitItem = new JMenuItem("quit"); // Quit menu items
        quitItem.addActionListener(this);
    }

    // EFFECTS: adds the menu items to corerspondiong menu
    private void addMenuItems() {
        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(addMenu);
        menuBar.add(quitMenu);

        fileMenu.add(saveItem);
        fileMenu.add(loadItem);

        viewMenu.add(wishlistItem);

        addMenu.add(hyroxItem);
        addMenu.add(instantItem);

        quitMenu.add(quitItem);
    }

    // EFFECTS: Initializes the aspects of the app
    // MODIFIES: this
    private void init() {
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

    // EFFECTS: shows the wishlist of the titles comps the user is possibly go to
    private void doViewWishlist() {
        int wlLength = wishlist.getWishlist().size();
        ArrayList<String> wl = wishlist.getWishlist();

        JDialog dialog = new JDialog(this, "Wishlist", true);
        dialog.setSize(300, 300);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        if (!(wlLength == 0)) {
            JLabel title = new JLabel();
            title.setFont(new Font("Arial", Font.BOLD, 24));
            title.setText("The list of Hyroxs that you are eligible for:");
            panel.add(title);

            for (String name : wl) {
                panel.add(new JLabel(name));
            }
        } else {
            JLabel noComp = new JLabel();
            noComp.setFont(new Font("Arial", Font.BOLD, 24));
            noComp.setText("No competitions... ");
            panel.add(noComp);
        }

        dialog.add(panel);
        dialog.setVisible(true);
    }

    // EFFECTS: makes a hyrox and adds it to the list of competitions
    // MODIFIES: this
    private void doMakeHyrox() {
        JDialog dialog = new JDialog(this, "Add a Hyrox", true);
        JPanel panel = new JPanel();
        JTextField titleField = new JTextField();
        JSpinner weightClassSpinner = new JSpinner(new SpinnerNumberModel(100, 100, 250, 5));
        JComboBox<String> genderComboBox = new JComboBox<>();
        JSpinner minTimeRecSpinner = new JSpinner(new SpinnerNumberModel(60, 50, 210, 1));
        JButton recordButton = new JButton("Add");

        genderComboBox.addItem("male");
        genderComboBox.addItem("female");
        genderComboBox.addItem("mixed");

        recordButton.addActionListener(e -> {
            String title = titleField.getText();
            int weightClass = (int) weightClassSpinner.getValue();
            String gender = (String) genderComboBox.getSelectedItem();
            int minTimeRec = (int) minTimeRecSpinner.getValue();
            Hyrox hyrox = new Hyrox(title, weightClass, gender, minTimeRec);
            competitions.addComp(hyrox);
            dialog.dispose();
        });

        dialog.setSize(300, 400);
        dialog.setLocationRelativeTo(this);

        panel.setLayout(new GridLayout(0, 2, 15, 10));

        panel.add(new JLabel("Title:"));
        panel.add(titleField);

        panel.add(new JLabel("Weight Class:"));
        panel.add(weightClassSpinner);

        panel.add(new JLabel("Gender:"));
        panel.add(genderComboBox);

        panel.add(new JLabel("Minimum Time Record:"));
        panel.add(minTimeRecSpinner);

        panel.add(recordButton);

        dialog.add(panel);
        dialog.setVisible(true);
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

        if (e.getSource() == wishlistItem) {
            doViewWishlist();
        }

        if (e.getSource() == hyroxItem) {
            doMakeHyrox();
        }
    }
}
