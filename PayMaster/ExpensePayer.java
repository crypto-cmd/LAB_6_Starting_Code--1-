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

public ExpensePayer(){
    setTitle("Automated Teller System");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 500);
    setlayout(new GridLayout(3,2));

    JLabel expenseLabel = new JLabel("Please Enter the Amount to be Paid:");
    add(expenseLabel);

    expenseField = new JTextField();
    add (expenseField);

    JLabel cardnumLabel = new JLabel("Please Enter the Credit Card Number:");
    add(cardnumLabel);

    cardNumberField = new JTextField();
    add(cardNumberField);

    payButton = new JButton("Click Here to Pay Expenses");
    payButton.addActionListener(this);
    add(payButton);

    setVisible(true);
}

public void actionPhase (ActionEvent start){
    if (start.getSource == payButton){
        double expenseAmmount = Double.parseDouble(expenseField.getText());
        String cardNumber = cardNumberField.getText();

        JOptionPane.showMessageDialog(this, "Expense paid successfully");
    }
}

public static void main(String[] args) {
    new ExpensePayer();
    
}
         

    }
}