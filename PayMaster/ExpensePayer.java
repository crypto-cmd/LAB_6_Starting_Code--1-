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
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExpensePayer extends JFrame implements ActionListener {
    private JTextField expenseField;
    private JTextField cardNumberField;
    private JButton payButton;
    private JComboBox<String> paymentMethodComboBox;
    private JComboBox<String> expenseDropDown;

public ExpensePayer(ExpenseListing elist){
    setTitle("Automated Teller System");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 500);
    setLayout(new GridLayout(5,2));

    JLabel expenseLabel = new JLabel("Select Expense:");
    add(expenseLabel);

    ArrayList<String> expenselist = elist.getExpenseList()
    .stream()
    .map(e->e.name)
    .collect(Collectors.toList());

    expenseDropDown = new JComboBox<>(expenselist);
    add(expenseDropDown);


    JLabel expenseLabel = new JLabel("Please Enter the Amount to be Paid:");
    add(expenseLabel);

    expenseField = new JTextField();
    add (expenseField);

    JLabel paymentMethodLabel = new JLabel("Payment Method:");
    add(paymentMethodLabel);

    String[] paymentMethods = {"Credit Card", "Debit Card", "PayPal", "Bank Transfer"};
    paymentMethodComboBox = new JComboBox<>(paymentMethods);
    add(paymentMethodComboBox);


    JLabel cardnumLabel = new JLabel("Please Enter the Card/Account Number:");
    add(accnumLabel);

    cardNumberField = new JTextField();
    add(cardNumberField);

    payButton = new JButton("Click Here to Pay Expenses");
    payButton.addActionListener(this);
    add(payButton);

    setVisible(true);
}

public void actionPerformed (ActionEvent start){
    if (start.getSource == payButton){
        double expenseAmmount = Double.parseDouble(expenseField.getText());
        String cardNumber = cardNumberField.getText();
        String paymentMethod = (String) paymentMethodComboBox.getSelectedItem();
        String expense = expenseDropDown.getSelectedItem();
        ExpenseListing.removeExpense(expense);


        JOptionPane.showMessageDialog(this, "Expense paid successfully");
    }
}
       
}