package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{

    
    JButton deposit,whithdrwal,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;
    Transactions(String pinnumber) {
        // Get screen dimensions
        this.pinnumber = pinnumber;
        
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Load and scale the image to fit the screen size
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        setLayout(null);
        image.setBounds(0, 0, screenWidth, screenHeight);
        add(image);
        
        
        JLabel text = new JLabel("Please select your Transction");
        text.setBounds(350,235,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        
        deposit = new JButton("Deposit");
        deposit.setBounds(300,310,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        whithdrwal = new JButton("Cash Whithdrwal");
        whithdrwal.setBounds(485,310,150,30);
        whithdrwal.addActionListener(this);
        image.add(whithdrwal);
        
        fastcash = new JButton("FastCash");
        fastcash.setBounds(300,345,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("MiniStatement");
        ministatement.setBounds(485,345,150,30);
        ministatement.addActionListener(this); 
        image.add(ministatement);
        
        pinchange = new JButton("PinChange");
        pinchange.setBounds(300,380,150,30);
        pinchange.addActionListener(this); 
        image.add(pinchange );
        
        balanceenquiry = new JButton("Balance enquiry");
        balanceenquiry.setBounds(485,380,150,30);
        balanceenquiry.addActionListener(this);  
        image.add(balanceenquiry );
        
        exit = new JButton("Exit");
        exit.setBounds(485,413,150,30);
        exit.addActionListener(this);  
        image.add(exit );

        // Adjust JFrame size and properties
        setSize(screenWidth, screenHeight); // Set frame to screen size
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==exit){
             System.exit(0);
         }else if(ae.getSource()==deposit){
             setVisible(false);
             new Deposit(pinnumber).setVisible(true);
         }else if(ae.getSource()==whithdrwal){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
         }else if(ae.getSource()==fastcash){
             setVisible(false);
             new FastCash(pinnumber).setVisible(true);
         }else if(ae.getSource()==pinchange){
             setVisible(false);
             new PinChange(pinnumber).setVisible(true); 
         }else if(ae.getSource()==balanceenquiry){
             new BalanceEnquiry(pinnumber).setVisible(true);
         }else if(ae.getSource()==ministatement){
           
             new MiniStatement(pinnumber).setVisible(true);
         }  
    }

    public static void main(String args[]) {
        new Transactions("");
    }
}
