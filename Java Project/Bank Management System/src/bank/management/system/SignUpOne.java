package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser dateChooser;
    JScrollPane scrollPane;
    SignUpOne() {
        
        setLayout(null);
        
        // Create a panel to hold all components
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("Application Form No. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        panel.add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        panel.add(personalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        panel.add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        panel.add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        panel.add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        panel.add(fnameTextField);
        
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        panel.add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105, 105));
        panel.add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        panel.add(gender);
        
        male = new JRadioButton("Male");
        male.setBackground(Color.WHITE);
        male.setBounds(300, 290, 60, 30);
        panel.add(male);
        
        female = new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(450, 290, 120, 30);
        panel.add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email-Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        panel.add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        panel.add(emailTextField);
        
        JLabel martial = new JLabel("Marital Status:");
        martial.setFont(new Font("Raleway", Font.BOLD, 20));
        martial.setBounds(100, 390, 200, 30);
        panel.add(martial);
        
        married = new JRadioButton("Married");
        married.setBackground(Color.WHITE);
        married.setBounds(300, 390, 100, 30);
        panel.add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(450, 390, 100, 30);
        panel.add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBackground(Color.WHITE);
        other.setBounds(630, 390, 100, 30);
        panel.add(other);
        
        ButtonGroup maritialgroup = new ButtonGroup();
        maritialgroup.add(married);
        maritialgroup.add(unmarried);
        maritialgroup.add(other);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        panel.add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        panel.add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        panel.add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        panel.add(cityTextField);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        panel.add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        panel.add(stateTextField);
        
        JLabel pincode = new JLabel("PinCode:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        panel.add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        panel.add(pinTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30); // Adjust the Y-coordinate
        next.addActionListener(this);
        panel.add(next);
        
        panel.setPreferredSize(new Dimension(850, 750)); // Set preferred size for scrolling

        // Add panel to a scroll pane
        scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, 0, 850, 700);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
        
        setSize(850, 700);
        setLocation(300, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno  = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob =((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "male";
            
        }else if(female.isSelected()){
            gender = "female";
        }
        
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "married";
        }else if(unmarried.isSelected()){
            marital = "unmarried";
        }else if(other.isSelected()){
            marital = "other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String State = stateTextField.getText();
        String pin = pinTextField.getText();
        
        
        try{
            if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                JOptionPane.showMessageDialog(null, "Enter a valid Email Address");
            }
            else if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father Name is Required");
            }
            else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"Date of Birth is Required");
            }else if(gender==null){
                JOptionPane.showMessageDialog(null,"Please Select a Gender");
            }else if (email.equals("")) {
            JOptionPane.showMessageDialog(null, "Email Address is required.");
            } else if (marital == null) {
                JOptionPane.showMessageDialog(null, "Please select your Marital Status.");
            } else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is required.");
            } else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "City is required.");
            } else if (State.equals("")) {
                JOptionPane.showMessageDialog(null, "State is required.");
            } else if (pin.equals("")) {
                JOptionPane.showMessageDialog(null, "Pin Code is required.");
            }
            
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+State+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    public static void main(String args[]) {
        new SignUpOne();
    }
}
