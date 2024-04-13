import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.util.Comparator;
import java.util.Collections;
import java.awt.Color;


public class ExpenseListing extends JPanel {
    

    public ExpenseListing() {
        super(new GridLayout(2,1));
       
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                	//Create and set up the window.
                    JFrame frame = new JFrame("Expense?");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    //Create and set up the content pane.
                    ExpenseListing newContentPane = new ExpenseListing();
                    newContentPane.setOpaque(true); //content panes must be opaque
                    frame.setContentPane(newContentPane);

                    //Display the window.
                    frame.pack();
                    frame.setVisible(true);
                }
            });
    }
}