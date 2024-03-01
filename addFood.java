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

public class addFood {

   private JFrame mainFrame;
   private JLabel headerLabel;
   private JPanel controlPanel;
   private JLabel id,name,price,quantity;
   private static int count = 0;
   GridLayout experimentLayout = new GridLayout(0,2);
    ResultSet rs;
   addFood(){
    prepareGUI();
   }

   public static void main(String[] args){
      addFood  swingControlDemo = new addFood();
      swingControlDemo.showButtonDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Insert a new food item!");
      mainFrame.setSize(700,400);
      mainFrame.setLayout(new GridLayout(3, 1));
	  mainFrame.getContentPane().setBackground(Color.pink);
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            mainFrame.setVisible(false);
         }
      });
      headerLabel = new JLabel("", JLabel.CENTER);
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.setVisible(true);
   }

   public void showButtonDemo(){
		headerLabel.setText("Restaurant Management System");
		headerLabel.setFont(new Font(null, Font.BOLD, 27));
		
		
        name = new JLabel("Enter Food Name");
        JTextField tf2=new JTextField();
        tf2.setSize(100,40);

        price = new JLabel("Enter Food Price");
        JTextField tf3=new JTextField();
        tf3.setSize(100,40);

        quantity = new JLabel("Enter Food Quantity");
        JTextField tf4=new JTextField();
        tf4.setSize(100,40);

        JButton okButton = new JButton("Add Food ");
        
      okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            PreparedStatement pst;
           // DBConnection con = new DBConnection();
            
            try{
            	
            	if(tf2.getText().equals("")||tf3.getText().equals("")||tf4.getText().equals(""))
            	{
            		
            		JOptionPane.showMessageDialog(mainFrame,"Please enter all the details!!!!");
            		
            		
            	}
            	else {
            	
                 Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
             //   java.sql.PreparedStatement stmt=con.prepareStatement("insert into canteenmanagement.food(f_name,f_price,f_quantity) values (?,?,?)");
                java.sql.PreparedStatement stmt=con.prepareStatement("insert into food(food_name,price,quantity) values (?,?,?)");
               
                stmt.setString(1,tf2.getText());
                stmt.setString(2,tf3.getText());
                stmt.setString(3,tf4.getText());
                int i=stmt.executeUpdate();
            	if(i!=0) {
            		System.out.println("Record added successfully");
            		JOptionPane.showMessageDialog(mainFrame,"Record added successfully!!!");
            	}
            	else {
            		System.out.println("Failed to add");
            		JOptionPane.showMessageDialog(mainFrame,"Record is failed to add!!!");
            	}
            	
            	
            	}
            	
            }catch(Exception ex){
                System.out.println(ex);
               
            }finally{
            }
         }
      });

      JPanel jp = new JPanel(null);
      jp.add(name);
      jp.add(tf2);
      jp.add(price);
      jp.add(tf3);
      jp.add(quantity);
      jp.add(tf4);
      jp.setSize(500,500);
      jp.setLayout(experimentLayout);
      controlPanel.add(jp);
      jp.add(okButton);
	  mainFrame.setLocationRelativeTo(null);
      mainFrame.setVisible(true);
   }
}