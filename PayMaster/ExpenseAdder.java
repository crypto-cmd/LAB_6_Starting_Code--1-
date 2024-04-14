import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExpenseAdder extends JFrame {
    private JTextField expenseField;
    private JTextField costField;
    private JTextArea notesArea;
    private JTextField nameField;
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
        String[] categories = {"Utility", "Food", "Entertainment", "Personal", "Medical", "Loan"};//add other expenses
        categoryDropdown = new JComboBox<>(categories);
        JLabel notesLabel = new JLabel("Notes:");
        notesArea = new JTextArea(4, 20);
        addButton = new JButton("Add Expense");

        //setting the layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //adding the components and aligning the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(costLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(costField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(categoryLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(categoryDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(notesLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // span two columns for the notes area
        gbc.fill = GridBagConstraints.BOTH;
        add(notesArea, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // span two columns for the button
        gbc.fill = GridBagConstraints.NONE;
        add(addButton, gbc);

        //adding the actionlistener to the button
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){ //override
                addExpense();
            }
        });

        //setting the frame properties 
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes only this window
        setVisible(true);
    }


    private void addExpense(){
        String name = nameField.getText();
        float cost = Float.parseFloat(costField.getText());
        String category = (String) categoryDropdown.getSelectedItem();
        String notes = notesArea.getText();
        System.out.println("Expense added: Name- " + name +", Cost- " + cost + ", Category- " +category + ", Notes- " + notes);
        Expense expense = new Expense(name, cost, category, notes);
        eList.addExpense(expense);
    }

    
}