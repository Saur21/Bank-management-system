
package bank.management.system;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        setLayout(null);
        image.setBounds(0, 0, screenWidth, screenHeight);
        add(image);
        
        
        JLabel text = new JLabel("Change Your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16)); 
        text.setBounds(400,235,700,35);
        image.add(text);
        
        JLabel pintext = new JLabel("New Pin:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16)); 
        pintext.setBounds(230,275,700,35);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD,25));
        pin.setBounds(375,275, 300,35);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter-Pin:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16)); 
        repintext.setBounds(230,330,700,35);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD,25));
        repin.setBounds(375,330, 300,35);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(375,400,100,35);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(572,400,100,35);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        
        // Adjust JFrame size and properties
        setSize(screenWidth, screenHeight); // Set frame to screen size
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== change){
          try{
          String npin =pin.getText();
          String rpin =repin.getText();
          
          if(!npin.equals(rpin)){
              JOptionPane.showMessageDialog(null, "Entered Pin Does't Match");
              return;
           }
          if(npin.equals("")){
              JOptionPane.showMessageDialog(null, "Please Enter Pin");
              return;
          }
          
          if(rpin.equals("")){
              JOptionPane.showMessageDialog(null, "Please Re-Enter Pin");
              return;
          }
          Conn conn = new Conn();
          String query1  = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
          String query2  = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
          String query3  = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
          
          conn.s.execute(query1);
          conn.s.execute(query2);
          conn.s.execute(query3); 
          
        JOptionPane.showMessageDialog(null, "Pin Change Sucessfully");
        
        setVisible(false);
        new Transactions(rpin).setVisible(true);
        
        }catch(Exception e){
            System.out.println(e);
         }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
       }
        
    }
    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
