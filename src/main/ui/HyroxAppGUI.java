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
    private JMenuItem save;
    private JMenuItem load;
    private JMenuItem exit;

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

        save = new JMenuItem("save");
        load = new JMenuItem("load");
        exit = new JMenuItem("exit");

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(addMenu);

        fileMenu.add(save);
        fileMenu.add(load);
        fileMenu.add(exit);


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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
