
package bank.management.system;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
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
        
        
         back = new JButton("BACK");
         back.addActionListener(this); 
         back.setBounds(600,400,100,35);
         image.add(back);
        
        Conn c = new Conn();
         int balance = 0;
            try{
              ResultSet  rs = c.s.executeQuery("select* from bank where pin = '"+pinnumber+"'");
              while(rs.next()){
                  if(rs.getString("type").equals("Deposit")){
                      balance += Integer.parseInt(rs.getString("amount"));
                  }else{
                      balance -= Integer.parseInt(rs.getString("amount"));
                  }
              }
            }catch(Exception e){
                System.out.println(e);
            }
            JLabel text = new JLabel("Your current Account balance is Rs " +   balance);
            text.setForeground(Color.WHITE);
            text.setBounds(250,235,700,35);
            image.add(text);
            
            
            
        // Adjust JFrame size and properties
        setSize(screenWidth, screenHeight); // Set frame to screen size
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
        
        
}
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}
