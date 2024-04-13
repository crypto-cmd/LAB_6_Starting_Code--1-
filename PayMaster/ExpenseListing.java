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
    private JButton     cmdAddCard;
    private JButton     cmdAddExpense;
    private JButton     cmdPayAnExpense;
  
    private JPanel      commandPanel;
    private JPanel      displayPanel;
    private ArrayList<Expense> expenseList;
    private ExpenseListing thisForm;
    private  JScrollPane scrollPane;

    private JTable table;
    private DefaultTableModel model;

    public ExpenseListing() {
        super(new GridLayout(2,1));
        thisForm = this;
        

        commandPanel = new JPanel();
        displayPanel = new JPanel();

        expenseList= loadExpense("expenses.txt");
        String[] columnNames=  {"Name",
                "Category",
                "Cost",
                "Notes"};
        model=new DefaultTableModel(columnNames,0);
        table = new JTable(model);
        showTable(expenseList);

        table.setPreferredScrollableViewportSize(new Dimension(500, expenseList.size()*15 +50));
        table.setFillsViewportHeight(true);

        scrollPane = new JScrollPane(table);
       
        add(scrollPane);

       
        cmdAddCard  = new JButton("Add Card");
        cmdAddExpense  = new JButton("Add Expense");

        cmdAddCard.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    // Call the Add Card popup
                }
            }
        );
        
        commandPanel.add(cmdAddCard);
        commandPanel.add(cmdAddExpense);
       
        add(commandPanel);
    }

    private void showTable(ArrayList<Expense> l)
    {
       for (Expense e: l) addToTable(e);

    }
    private void addToTable(Expense expense)
    {
        
        String[] item={expense.name, expense.category, ""+expense.cost, expense.notes};
        model.addRow(item);        

    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Automated Telling System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        ExpenseListing newContentPane = new ExpenseListing();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }

    public void addExpense(Expense expense)
    {
        expenseList.add(expense);
        addToTable(expense);

    }

    private ArrayList<Expense> loadExpense(String file)
    {
        Scanner scan = null;
        ArrayList<Expense> list = new ArrayList<Expense>();
        try
        {
            scan  = new Scanner(new File(file));
            while(scan.hasNext())
            {
                
            	String [] nextLine = scan.nextLine().split(",");
                String name = nextLine[0];
                String category = nextLine[1];
                float cost = Float.parseFloat(nextLine[2]);
                String notes = nextLine[4];
                Expense expense = new Expense(name, category, cost, notes);
                list.add(expense);
            }

            scan.close();
        }
        catch(IOException e)
        {
        	System.out.println(e);
        	
        }
        return list;
    }
}