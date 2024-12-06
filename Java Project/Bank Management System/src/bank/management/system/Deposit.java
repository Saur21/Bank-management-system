
package bank.management.system;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    Deposit(String pinnumber){
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
        
        
        JLabel text = new JLabel("Enter the amount you want to add");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(350,235,700,35);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22 ));
        amount.setBounds(260,290,450,35);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(545,375,180,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(545,410,180,30);
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
        if(ae.getSource()== deposit){
            String number = amount.getText();
            Date date = new Date();
            
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to deposit");
            }else{
                try{
                 Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"','Deposit', '"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs" + number + "Deposit SucessFully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
                }catch(Exception e){
                    System.out.println(e);
                }
               
            }
        }else if(ae.getSource() == back){
            setVisible(false);
          new Transactions(pinnumber).setVisible(true);  
        }
    }
    public static void main(String args[]){
        new Deposit("");
    }
}
