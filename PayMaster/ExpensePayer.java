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
import java.util.stream.Collectors;

public class ExpensePayer extends JFrame implements ActionListener {
    private JTextField expenseField;
    private JTextField cardNumberField;
    private JButton payButton;
    private JComboBox<String> paymentMethodComboBox;
    private JComboBox expenseDropDown;
    ExpenseListing elist;

public ExpensePayer(ExpenseListing elist){
    this.elist = elist;
    setTitle("Automated Teller System");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 400);
    setLayout(new GridLayout(5,2));

    JLabel expenseLabel = new JLabel("Select Expense:");
    add(expenseLabel);

    String[] expenselist = new String[elist.getExpenseList().size()];
    for (int i = 0; i < expenselist.length; i++) {
        Expense e= elist.getExpenseList().get(i);
        expenselist[i] = String.format("%s(%s)", e.name,e.id);
    }


    expenseDropDown = new JComboBox<>(expenselist);
    add(expenseDropDown);

    JLabel expense2Label = new JLabel("Enter Expense Amount:");
    add(expense2Label);

    expenseField = new JTextField();
    add (expenseField);


    JLabel paymentMethodLabel = new JLabel("Payment Method:");
    add(paymentMethodLabel);

    String[] paymentMethods = {"Credit Card", "Debit Card", "PayPal", "Bank Transfer"};
    paymentMethodComboBox = new JComboBox<>(paymentMethods);
    add(paymentMethodComboBox);

    JLabel cardnumLabel = new JLabel("Please Enter the Card/Account Number:");
    add(cardnumLabel);

    cardNumberField = new JTextField();
    add(cardNumberField);


    payButton = new JButton("Click Here to Pay Expenses");
    payButton.addActionListener(this);
    add(payButton);

    setVisible(true);
}

public void actionPerformed (ActionEvent start){
    if (start.getSource() == payButton){
        double expenseAmmount = Double.parseDouble(expenseField.getText());
        String cardNumber = cardNumberField.getText();
        String paymentMethod = (String) paymentMethodComboBox.getSelectedItem();
        String expense = expenseDropDown.getSelectedItem().toString();
        elist.removeExpense(expense);

        JOptionPane.showMessageDialog(this, "Expense paid successfully");
    }
}
       
}
