package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{

    
    JButton deposit,whithdrwal,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;
    FastCash(String pinnumber) {
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
        
        
        JLabel text = new JLabel("SELECT WITHDRAW AMOUNT");
        text.setBounds(350,235,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(300,310,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        whithdrwal = new JButton("Rs 500");
        whithdrwal.setBounds(485,310,150,30);
        whithdrwal.addActionListener(this);
        image.add(whithdrwal);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(300,345,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(485,345,150,30);
        ministatement.addActionListener(this); 
        image.add(ministatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(300,380,150,30);
        pinchange.addActionListener(this); 
        image.add(pinchange );
        
        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(485,380,150,30);
        balanceenquiry.addActionListener(this);  
        image.add(balanceenquiry );
        
        exit = new JButton("BACK");
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
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
         }else{
           String amount = ((JButton)ae.getSource()).getText().substring(3);//Rs500
           Conn c = new Conn();
           try{
              ResultSet  rs = c.s.executeQuery("select* from bank where pin = '"+pinnumber+"'");
              int balance = 0;
              while(rs.next()){
                  if(rs.getString("type").equals("Deposit")){
                      balance += Integer.parseInt(rs.getString("amount"));
                  }else{
                      balance -= Integer.parseInt(rs.getString("amount"));
                  }
              }
              
              if(ae.getSource()!= exit && balance < Integer.parseInt(amount) ){
                  JOptionPane.showMessageDialog(null,"Insufficient Balance");
                  return;
              }
              
              Date date  = new Date();
              String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrwal', '"+amount+"')";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "Rs"+amount+"Debited Sucessfully");
              
              setVisible(false);
              new Transactions(pinnumber).setVisible(true);
              
           }catch(Exception e){
               System.out.println(e);
           }
           
         }   
    }

    public static void main(String args[]) {
        new FastCash("");
    }
}
