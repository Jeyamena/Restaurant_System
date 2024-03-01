package restaurant;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class updateFood {
	
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JLabel id, Name,price,quantity;
   private static int count = 0;
   JButton reset;
  Container c;
   GridLayout experimentLayout = new GridLayout(0,2);
    ResultSet rs;
    updateFood(){
      prepareGUI();
   }

   public static void main(String[] args){
      updateFood  swingControlDemo = new updateFood();
      swingControlDemo.showButtonDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Update!");
      mainFrame.setSize(700,400);
      mainFrame.setLayout(new GridLayout(3,1));
	  mainFrame.getContentPane().setBackground(Color.pink);
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            mainFrame.setVisible(false);
         }
      });
      headerLabel = new JLabel("", JLabel.CENTER);
      statusLabel = new JLabel("",JLabel.CENTER);
      statusLabel.setSize(350,400);
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);
   }
   
   public void showButtonDemo(){
      headerLabel.setText("Restaurant Management System");
	  headerLabel.setFont(new Font(null, Font.BOLD, 27));
	
        Name = new JLabel("Enter Food Name  ");
        JTextField tf2=new JTextField();
        tf2.setSize(100,30);
        
        price = new JLabel("Enter Food Price ");
        JTextField tf3=new JTextField();
        tf3.setSize(100,30);

        quantity = new JLabel("Enter  Food Quantity");
        JTextField tf4=new JTextField();
        tf4.setSize(100,30);

        JButton okButton = new JButton("UPDATE");
       
     //   okButton.setBackground(Color.MAGENTA);
        
      okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            PreparedStatement pst;
           // DBConnection con = new DBConnection();
            try{
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
              // String query="UPDATE canteenmanagement.food SET f_quantity= ?, f_prize=?where f_name=?";
               String query="UPDATE food SET quantity=?,price=? where food_name=?";
            		   java.sql.PreparedStatement ps=con.prepareStatement(query);
            		   ps.setString(1,tf4.getText());
            		   ps.setString(2,tf3.getText());
            		   ps.setString(3,tf2.getText());
               //
               //
               ps.executeUpdate();
               int i=ps.executeUpdate();
               if(i!=0) {
              // System.out.println("Record is updated successfully...");
            	   System.out.println("Record is updated successfully..!!!!.");
            	   JOptionPane.showMessageDialog(mainFrame,"Record updated successfully");
               }
               else {
            	   System.out.println("Failed to add");
            	   JOptionPane.showMessageDialog(mainFrame,"Record not Found!!!!");
               }

            }
            catch(Exception ex){
                ex.printStackTrace();
            }finally{
                
            }
         }
      });
    
    
      JButton reset = new JButton("RESET");
     // this.reset=new JButton("RESET");
	   reset.setBounds(300,370,110,50);
	// reset.setBackground(Color.YELLOW);
      // add(reset);
      
     // c.add(reset);
     
      
      
      reset.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
          tf2.setText("");
          tf3.setText("");
          tf4.setText("");
        	  
          }
            
       });
     
      
    
      JPanel jp = new JPanel();
      jp.add(Name);
      jp.add(tf2);
      jp.add(price);
      jp.add(tf3);
      jp.add(quantity);
      jp.add(tf4);
      jp.setSize(200,200);
      jp.setLayout(experimentLayout);
      controlPanel.add(jp);
      jp.add(okButton);
      jp.add(reset);
      mainFrame.setVisible(true);
	  mainFrame.setLocationRelativeTo(null);
   }
}