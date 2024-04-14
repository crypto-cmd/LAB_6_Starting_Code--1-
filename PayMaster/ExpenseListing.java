import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;


public class ExpenseListing extends JPanel {
    private JButton     cmdAddCard;
    private JButton     cmdAddExpense;
    private JButton     cmdPayAnExpense;

    private JButton     cmdGroupCategories;
    private JButton     cmdSortName;
    private JButton     cmdSortCost;


    private JPanel      commandPanel;
    private ArrayList<Expense> expenseList;
    private ExpenseListing me;
    private  JScrollPane scrollPane;

    private JTable table;
    private DefaultTableModel model;

    public ArrayList<Expense> getExpenseList() {
        return expenseList;
    }

    public ExpenseListing() {
        super(new GridLayout(2,1));
        me = this;
        

        commandPanel = new JPanel();

        expenseList= loadExpense();
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
        cmdPayAnExpense = new JButton("Pay Expense");

        cmdAddCard.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    // Call the Add Card popup
                }
            }
        );

        cmdAddExpense.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ExpenseAdder(me);
            }
        });

        cmdPayAnExpense.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        new ExpensePayer(me);
                    }
                }
        );
        
        commandPanel.add(cmdAddCard);
        commandPanel.add(cmdAddExpense);
        commandPanel.add(cmdPayAnExpense);


        cmdGroupCategories = new JButton("Group by Category");
        cmdGroupCategories.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Map<String, List<Expense>> groups = new HashMap<>();
                for (Expense e: expenseList) {
                    if(!groups.containsKey(e.category)) {
                        groups.put(e.category, new ArrayList<>());

                    }
                    groups.get(e.category).add(e);
                }
                ArrayList<String> categories = new ArrayList<>(groups.keySet());
                Collections.sort(categories);
                expenseList.clear();
                for (String category: categories){
                    expenseList.addAll(groups.get(category));
                }
                showTable(expenseList);
            }
        });
        cmdSortCost = new JButton("Sort by Cost");
        cmdSortCost.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        expenseList.sort(new Comparator<Expense>() {
                            @Override
                            public int compare(Expense expense, Expense other) {
                                return (int) (expense.cost - other.cost);
                            }
                        });
                        showTable(expenseList);
                    }
                }
        );

        cmdSortName = new JButton("Sort by Name");
        cmdSortName.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        expenseList.sort(new Comparator<Expense>() {
                            @Override
                            public int compare(Expense expense, Expense other) {
                                return expense.name.compareTo(other.name);
                            }
                        });
                        showTable(expenseList);
                    }
                }
        );

        commandPanel.add(cmdGroupCategories);
        commandPanel.add(cmdSortName);
        commandPanel.add(cmdSortCost);
        add(commandPanel);
    }

    public void expensePaid(Expense expense) {
        model.setRowCount(0);
        expenseList.remove(expense);
        showTable(expenseList);
    }

    private void showTable(ArrayList<Expense> l)
    {
        model.setRowCount(0);
       for (Expense e: l) addToTable(e);

    }
    private void addToTable(Expense expense)
    {
        
        String[] item={expense.name, expense.category, String.valueOf(expense.cost), expense.notes};
        model.addRow(item);        

    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Automated Teller System");
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

    private ArrayList<Expense> loadExpense()
    {
        Scanner scan = null;
        ArrayList<Expense> list = new ArrayList<>();
        try
        {
            scan  = new Scanner(new File("out/production/PayMaster/expenses.dat"));
            while(scan.hasNext())
            {
                
            	String [] nextLine = scan.nextLine().split(",");
                String name = nextLine[0];
                String category = nextLine[1];
                float cost = Float.parseFloat(nextLine[2]);
                String notes = nextLine[3];
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
    public void removeExpense(String detail) {
        List<Expense> newList = expenseList.stream().filter(e -> !Objects.equals(e.name, detail)).toList();
        expenseList.clear();
        expenseList.addAll(newList);
        showTable(expenseList);

    }
}