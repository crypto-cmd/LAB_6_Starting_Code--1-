import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;

class GetpaymentForm extends JFrame implements ActionListener
{
	// To declare the components
    JTextField ccNumber,lName,expDate,cVV;
	JButton btnSub;
    GetpaymentForm()
    {
		JLabel heading = new JLabel("***** Payment Form ****");
		heading.setBounds(50,5,360,30);
		heading.setForeground(Color.white); //set the text color
		heading.setFont(new Font("Calibri", Font.BOLD, 22));
		// To create Label
		JLabel lbl_ccnumber = new JLabel("Credit Card Number : ");
		lbl_ccnumber.setBounds(10,50,130,30);
		lbl_ccnumber.setForeground(Color.white); //set the text color
		// Set up the product reference formatted text field
		JFormattedTextField ccNumber = null;
		try {
         ccNumber = new JFormattedTextField(
            new MaskFormatter("#### #### #### ####")); 
         ccNumber.setColumns(16);
		} catch (ParseException e) {
         e.printStackTrace();
		}
        ccNumber.setBounds (130, 50, 200, 30);
		// To create Label
		JLabel lbl_lname = new JLabel("Name : ");
		lbl_lname.setBounds(10,90,100,30);
		lbl_lname.setForeground(Color.white); //set the text color
		// To create TextFiled
        lName = new JTextField ();
        lName.setBounds (130, 90, 150, 30);
		// To create Label
		JLabel lbl_expDate = new JLabel("Expiration Date : ");
		lbl_expDate.setBounds(10,130,100,30);
		lbl_expDate.setForeground(Color.white); //set the text color
		// To create TextFiled 
        JFormattedTextField expDate = null;
		try {
         expDate = new JFormattedTextField(
            new MaskFormatter("## / ##")); 
         expDate.setColumns(4);
		} catch (ParseException e) {
         e.printStackTrace();
		}
        expDate.setBounds (130, 130, 100, 30);
		// To create Label
		JLabel lbl_cvv = new JLabel("CVV : ");
		lbl_cvv.setBounds(10,170,100,30);
		lbl_cvv.setForeground(Color.white); //set the text color
		// To create TextFiled
        JFormattedTextField cVV = null;
		try {
         cVV = new JFormattedTextField(
            new MaskFormatter("###")); 
         cVV.setColumns(3);
		} catch (ParseException e) {
         e.printStackTrace();
		}
        cVV.setBounds (130, 170, 50, 30);
		// To create buttons
        btnSub = new JButton ("Submit");
        btnSub.setBounds (130, 220, 120, 30);
		btnSub.addActionListener(this);  
		add(btnSub);
		// to add components to JFrame
		add(heading);
		add(lbl_ccnumber);
        add(ccNumber);
		add(lbl_lname);
        add(lName);
		add(lbl_expDate);
        add(expDate);
		add(lbl_cvv);
        add(cVV);
		// JFrame Properties
        setSize(500, 400);
        setLayout(null);
        setVisible(true);
		getContentPane().setBackground(Color.BLUE) ;
		setTitle("Payment Form");
		// code to close the JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	// method to action performed
	public void actionPerformed(ActionEvent e){  
           JOptionPane.showMessageDialog(null, "Payment was successful.");
	}  
	// Main method

}

