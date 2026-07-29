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
import javax.swing.ImageIcon;
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

    private ImageIcon image;
    private JLabel imageLabel;

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu wishlistMenu;
    private JMenu addMenu;
    private JMenu quitMenu;
    private JMenuItem saveItem;
    private JMenuItem loadItem;
    private JMenuItem quitItem;
    private JMenuItem viewItem;
    private JMenuItem hyroxItem;
    private JMenuItem instantItem;
    private JMenuItem updateItem;

    private JDialog dialog;
    private JPanel panelDialog;
    private JPanel panel;

    private JTextField titleHyroxField;
    private JSpinner weightClassSpinner;
    private JComboBox<String> genderComboBox;
    private JSpinner minTimeRecSpinner;
    private JButton makeButton;

    private JTextField titleInstantField;
    private JSpinner timeSkiErgSpinner;
    private JSpinner timeBBJumpSpinner;
    private JSpinner timeSPushSpinner;
    private JSpinner timeSPullSpinner;
    private JSpinner timeRowingSpinner;
    private JSpinner timeFCSpinner;
    private JSpinner timeSLSpinner;
    private JSpinner timeWallBallSpinner;
    private JSpinner sumTimeRunsSpinner;
    private JButton recordButton;

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

        image = new ImageIcon(getClass().getResource("./data/HyroxApp.png"));
        imageLabel = new JLabel(image);
        panel.add(imageLabel);

        this.add(panel);

        this.setJMenuBar(menuBar);
        
        this.setVisible(true);
    }

    // EFFECTS: makes the menus
    private void menuSetup() {
        fileMenu = new JMenu("File");
        wishlistMenu = new JMenu("Wishlist");
        addMenu = new JMenu("Add");
        quitMenu = new JMenu("Quit");
    }

    // EFFECTS: makes the menu items
    private void menuItemSetup() {
        saveItem = new JMenuItem("save"); // File menu items
        saveItem.addActionListener(this);
        loadItem = new JMenuItem("load");
        loadItem.addActionListener(this);

        viewItem = new JMenuItem("view"); // Wishlist menu items
        viewItem.addActionListener(this);
        updateItem = new JMenuItem("update");
        updateItem.addActionListener(this);

        hyroxItem = new JMenuItem("hyrox"); // File menu items
        hyroxItem.addActionListener(this);
        instantItem = new JMenuItem("instant");
        instantItem.addActionListener(this);

        quitItem = new JMenuItem("quit"); // Quit menu items
        quitItem.addActionListener(this);
    }

    // EFFECTS: adds the menu items to corerspondiong menu
    private void addMenuItems() {
        menuBar.add(fileMenu);
        menuBar.add(wishlistMenu);
        menuBar.add(addMenu);
        menuBar.add(quitMenu);

        fileMenu.add(saveItem);
        fileMenu.add(loadItem);

        wishlistMenu.add(viewItem);
        wishlistMenu.add(updateItem);

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

    // EFFECTS: makes a hyrox and adds it to the Competitions
    // MODIFIES: this
    private void doMakeHyrox() {
        initComponentsMakeHyrox();

        makeButton.addActionListener(e -> {
            String title = titleHyroxField.getText();
            int weightClass = (int) weightClassSpinner.getValue();
            String gender = (String) genderComboBox.getSelectedItem();
            int minTimeRec = (int) minTimeRecSpinner.getValue();
            Hyrox hyrox = new Hyrox(title, weightClass, gender, minTimeRec);
            competitions.addComp(hyrox);
            dialog.dispose();
        });

        dialog.setSize(300, 400);
        dialog.setLocationRelativeTo(this);

        panelDialog.setLayout(new GridLayout(0, 2, 15, 10));

        addPanleDialogComponenetsMakeHyrox();

        dialog.add(panelDialog);
        dialog.setVisible(true);
    }

    // EFFECTS: initialize MakeHyrox componenets
    private void initComponentsMakeHyrox() {
        dialog = new JDialog(this, "Add a Hyrox", true);
        panelDialog = new JPanel();
        titleHyroxField = new JTextField();
        weightClassSpinner = new JSpinner(new SpinnerNumberModel(100, 100,
                250, 5));
        genderComboBox = new JComboBox<>();
        minTimeRecSpinner = new JSpinner(new SpinnerNumberModel(60, 50,
                210, 1));
        makeButton = new JButton("Add");

        genderComboBox.addItem("male");
        genderComboBox.addItem("female");
        genderComboBox.addItem("mixed");
    }

    // EFFECTS: add componenets to the Dialog panel for MakeHyrox
    private void addPanleDialogComponenetsMakeHyrox() {
        panelDialog.add(new JLabel("Title:"));
        panelDialog.add(titleHyroxField);

        panelDialog.add(new JLabel("Weight Class:"));
        panelDialog.add(weightClassSpinner);

        panelDialog.add(new JLabel("Gender:"));
        panelDialog.add(genderComboBox);

        panelDialog.add(new JLabel("Minimum Time Record:"));
        panelDialog.add(minTimeRecSpinner);

        panelDialog.add(makeButton);
    }

    // EFFECTS: makes an instance and adds it to the InstantsHistory
    // MODIFIES: this
    private void doRecordInstant() {
        initComponenetsRecordInstant();

        recordButton.addActionListener(e -> {
            String title = titleInstantField.getText();
            int timeSkiErg = (int) timeSkiErgSpinner.getValue();
            int timeBBJ = (int) timeBBJumpSpinner.getValue();
            int timeSPush = (int) timeSPushSpinner.getValue();
            int timeSPull = (int) timeSPullSpinner.getValue();
            int timeRowing = (int) timeRowingSpinner.getValue();
            int timeFC = (int) timeFCSpinner.getValue();
            int timeSL = (int) timeSLSpinner.getValue();
            int timeWallBall = (int) timeWallBallSpinner.getValue();
            int sumTimeRuns = (int) sumTimeRunsSpinner.getValue();
            InstantHyrox instance = new InstantHyrox(title, timeSkiErg, timeSPush, timeSPull, timeBBJ, timeRowing,
                    timeFC, timeSL, timeWallBall, sumTimeRuns);
            instantsHistory.addInstant(instance);
            dialog.dispose();
        });

        dialog.setSize(300, 400);
        dialog.setLocationRelativeTo(this);

        panelDialog.setLayout(new GridLayout(0, 2, 15, 10));

        addPanleDialogComponenetsRecordInstant();

        dialog.add(panelDialog);
        dialog.setVisible(true);
    }

    // EFFECTS: initialize RecordInstant componenets
    private void initComponenetsRecordInstant() {
        dialog = new JDialog(this, "Record and Instance", true);
        panelDialog = new JPanel();
        titleInstantField = new JTextField();
        timeSkiErgSpinner = new JSpinner(new SpinnerNumberModel(10, 0,
                50, 1));
        timeBBJumpSpinner = new JSpinner(new SpinnerNumberModel(10, 0,
                50, 1));
        timeSPushSpinner = new JSpinner(new SpinnerNumberModel(10, 0,
                50, 1));
        timeSPullSpinner = new JSpinner(new SpinnerNumberModel(10, 0,
                50, 1));
        timeRowingSpinner = new JSpinner(new SpinnerNumberModel(10, 0,
                50, 1));
        timeFCSpinner = new JSpinner(new SpinnerNumberModel(10, 0,
                50, 1));
        timeSLSpinner = new JSpinner(new SpinnerNumberModel(10, 0,
                50, 1));
        timeWallBallSpinner = new JSpinner(new SpinnerNumberModel(10, 0,
                50, 1));
        sumTimeRunsSpinner = new JSpinner(new SpinnerNumberModel(10, 0,
                50, 1));
        recordButton = new JButton("Add");
    }

    // EFFECTS: add componenets to Dialog Panel for Record Instant
    private void addPanleDialogComponenetsRecordInstant() {
        panelDialog.add(new JLabel("Title:"));
        panelDialog.add(titleInstantField);

        panelDialog.add(new JLabel("Ski Erg:"));
        panelDialog.add(timeSkiErgSpinner);

        panelDialog.add(new JLabel("Sled Push:"));
        panelDialog.add(timeSPushSpinner);

        panelDialog.add(new JLabel("Sled Pull:"));
        panelDialog.add(timeSPullSpinner);

        panelDialog.add(new JLabel("Burpee Board Jump:"));
        panelDialog.add(timeBBJumpSpinner);

        panelDialog.add(new JLabel("Rowing:"));
        panelDialog.add(timeRowingSpinner);

        panelDialog.add(new JLabel("Farmers Carry:"));
        panelDialog.add(timeFCSpinner);

        panelDialog.add(new JLabel("Sandbag Lunges:"));
        panelDialog.add(timeSLSpinner);

        panelDialog.add(new JLabel("WallBall:"));
        panelDialog.add(timeWallBallSpinner);

        panelDialog.add(new JLabel("Running:"));
        panelDialog.add(sumTimeRunsSpinner);

        panelDialog.add(recordButton);
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

    // EFFECTS: checks if the given hyroxTitle is a duplicate in wishlist or not
    private boolean notDuplicate(String hyroxTitle) {
        for (String h : wishlist.getWishlist()) {
            if (h.equals(hyroxTitle)) {
                return false;
            }
        }
        return true;
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

        if (e.getSource() == viewItem) {
            doViewWishlist();
        }

        if (e.getSource() == hyroxItem) {
            doMakeHyrox();
        }

        if (e.getSource() == instantItem) {
            doRecordInstant();
        }

        if (e.getSource() == updateItem) {
            doUpdateWishlist();
        }
    }
}
