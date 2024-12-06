package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignUpTwo extends JFrame implements ActionListener{
    
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JScrollPane scrollPane;
    JComboBox religion,category,income,education,occupation;
    String formno;
     
    SignUpTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        
        // Create a panel to hold all components
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        JLabel additonaldetail = new JLabel("Page 2: Additional Details");
        additonaldetail.setFont(new Font("Raleway", Font.BOLD, 22));
        additonaldetail.setBounds(290, 80, 400, 30);
        panel.add(additonaldetail);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        panel.add(name);
        
        String valReligion[] ={"Hindi","Muslim","Sikh","Christian","Other"}; 
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        panel.add(religion);
        
     
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        panel.add(fname);
        
        String valcategory[]= {"General","OBC","SC","ST","Other"};
        category  =  new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        panel.add(category);
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        panel.add(dob);
        
        String incomecategory[]= {"Null","<1,50,000","<2,50,000","5,00,000","UpTo 10,00,000"};
        income  =  new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        panel.add(income);
        
        
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        panel.add(gender);
        
        JLabel email = new JLabel("Qualification :");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 315, 200, 30);
        panel.add(email);
        
        String educationValues[]= {"Non-Graduate","Graduation","Post-Graduation","Doctrate","Others"};
        education  =  new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        panel.add(education);
        
        JLabel martial = new JLabel("Occupation:");
        martial.setFont(new Font("Raleway", Font.BOLD, 20));
        martial.setBounds(100, 390, 200, 30);
        panel.add(martial);
        
        String occupationValues[]= {"Salaried","Self-Employee","Buiseness","Student","Retiered","Others"};
        occupation  =  new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        panel.add(occupation);
        
        JLabel address = new JLabel("Pan-no:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        panel.add(address);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        panel.add(pan);
        
        JLabel city = new JLabel("Aadhar-no:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        panel.add(city);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        panel.add(aadhar);
        
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        panel.add(state);
        
        
        syes = new JRadioButton("Yes");
        syes.setBackground(Color.WHITE);
        syes.setBounds(300, 540, 100, 30);
        panel.add(syes);
        
        sno = new JRadioButton("No");
        sno.setBackground(Color.WHITE);
        sno.setBounds(450, 540, 100, 30);
        panel.add(sno);
        
        
        ButtonGroup smaritialgroup = new ButtonGroup();
        smaritialgroup.add(syes);
        smaritialgroup.add(sno);
        
        
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        panel.add(pincode);
        
        
        eyes = new JRadioButton("Yes");
        eyes.setBackground(Color.WHITE);
        eyes.setBounds(300, 590, 100, 30);
        panel.add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBackground(Color.WHITE);
        eno.setBounds(450, 590, 100, 30);
        panel.add(eno);
        
        
        ButtonGroup emaritialgroup = new ButtonGroup();
        emaritialgroup.add(eyes);
        emaritialgroup.add(eno);
        
        
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
        String sreligion =(String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome =   (String) income.getSelectedItem();
        String seducation =   (String) education.getSelectedItem();
        String soccupation =   (String) occupation.getSelectedItem();
        String seniorcitizon =  null;
        if(syes.isSelected()){
            seniorcitizon = "Yes";
            
        }else if(sno.isSelected()){
            seniorcitizon = "No";
        }
        
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        }else if(eno.isSelected()){
            existingaccount = "No";
        }
        
        
        String span = pan.getText();
        String saadhar = aadhar.getText();    
        
        try{ 
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizon+"','"+existingaccount+"')";
                c.s.executeUpdate(query);
                
                
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
            }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    public static void main(String args[]) {
        new SignUpTwo("");
    }
}
