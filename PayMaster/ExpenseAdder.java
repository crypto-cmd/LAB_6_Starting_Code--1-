import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExpenseAdder extends JFrame {
    private JTextField expenseField;
    private JTextField costField;
    private JTextField nameField;
    private JTextArea notesArea;
    private JComboBox <String> categoryDropdown;
    private JButton addButton;

    ExpenseListing eList;

    public ExpenseAdder(ExpenseListing eList) {
        super("Expense Adder");
        this.eList = eList;
        // componenets to add expense
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(10);
        JLabel costLabel = new JLabel("Cost:");
        costField = new JTextField(10);
        JLabel categoryLabel = new JLabel("Category:");
        String[] categories = {"Utility", "Food"};//add other expenses
        categoryDropdown = new JComboBox<>(categories);
        JLabel notesLabel = new JLabel("Notes:");
        notesArea = new JTextArea(4, 20);
        addButton = new JButton("Add Expense");

        //setting the layout
        setLayout(new FlowLayout());

        //adding the components to the frame
        add (nameLabel);
        add (nameField);
        add (costLabel);
        add (costField);
        add (categoryLabel);
        add (categoryDropdown);
        add (notesLabel);
        add(notesArea);
        add (addButton);

        //adding the actionlistener to the button
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){ //override
                addExpense();
            }
        });

        //setting the frame properties 
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    private void addExpense(){
        String name = nameField.getText();
        float cost = Float.parseFloat(costField.getText());
        String category = (String) categoryDropdown.getSelectedItem();
        String notes = notesArea.getText();
        System.out.println("Expense added: Name- " + name +", Cost- " + cost + ", Category- " + category +", Notes- " + notes);
        Expense expense = new Expense(name, category, cost, notes);
        eList.addExpense(expense);
//        clearFields(); //will clear all text field after expense is added
    }

    
}