package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    
    // Declare components globally if needed in actionPerformed
    JTextField cardTextField;
    JPasswordField pinTextField;
    JButton login, clear, signup;

    Login() {
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        // Adding the logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        // Welcome text
        JLabel text = new JLabel("Welcome to Indian Bank");
        text.setFont(new Font("Osward", Font.BOLD, 30));
        text.setBounds(200, 40, 400, 40);
        add(text);

        // Card Number
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Osward", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        // PIN
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Osward", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        pinTextField.setBounds(300, 220, 230, 30);
        add(pinTextField);

        // Buttons
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this ); // Add action listener
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this); // Add action listener
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this); // Add action listener
        add(signup);

        // Background color
        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            // Handle login button click
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText(); 
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'" ;
            try{
               ResultSet rs = conn.s.executeQuery(query); 
               if(rs.next()){
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
               }else{
                   JOptionPane.showMessageDialog(null,"Incorrect card number or pin");
               }
            }catch(Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource() == clear) {
            // Handle clear button click
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == signup) {
            // Handle signup button click
            setVisible(false);
            new SignUpOne().setVisible(true); 
            
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
