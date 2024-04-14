import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExpenseAdder extends JFrame {
    private  JTextField expenseField;
    private JComboBox <String> categoryDropdown;
    private JButton addButton;


    public ExpenseAdder() {
        super("Expense Adder");

        // componenets to add expense
        JLabel expenseLabel = new JLabel("Enter Expense:");
        expenseField = new JTextField(20);
        String[] categories = {"Utilitly". "Food"}//add other expenses
        categoryDropdown = new JComboBox<>(categories);
        addButton = new JButton("Add Expense");

        //setting the layout
        setLayout(new FlowLayout());

        //adding the components to the frame
        add (expenseLabel);
        add (expenseField);
        add (categoryDropdown);
        add (addButton);

        //adding the actionlistener to the button
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){ //override
                addExpense();
            }
        });

        //setting the frame properties 
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    private void addExpense(){
        String expenseText = expenseField.getText();
        String category = (String) categoryDropdown.getSelectedItem();
        System.out.println("Expense added: " + expenseText + "Category: " + category);
        expenseField.setText(""); //will clear text field after expense is added
    }
    public static void main (String [] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run () {
                new ExpenseAdder();
            }
        });
    }
}