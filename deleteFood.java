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
import java.sql.*;
public class deleteFood {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JPanel controlPanel;
   private JLabel id,name,price,quantity;
   private static int count = 0;
   GridLayout experimentLayout = new GridLayout(1,1);
    ResultSet rs;
    
    deleteFood(){
      prepareGUI();
   }

   public static void main(String[] args){
      deleteFood  swingControlDemo = new deleteFood();
      swingControlDemo.showButtonDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Delete!");
      mainFrame.setSize(700,400);
	  mainFrame.getContentPane().setBackground(Color.pink);

      mainFrame.setLayout(new GridLayout(3, 3));
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
		headerLabel.setForeground(Color.white);
  
        name = new JLabel("Enter Food Name");
        JTextField tf2=new JTextField();
        tf2.setSize(100,30);
        
        JButton okButton = new JButton("DELETE");

      okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
           
          //  DBConnection con = new DBConnection();
            try{
            	if(tf2.getText().equals(""))
            	{
            		JOptionPane.showMessageDialog(mainFrame,"Please enter the Food items to delete!!!");
            		
            		
            		
            	}
            	else {
            		 JOptionPane.showMessageDialog(mainFrame,"Are you sure??Do you want to delete item???");
            	 PreparedStatement pst = null;
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","");
              //  Statement stmt=con.createStatement();
               
                System.out.println(tf2.getText());

                
                String query1="DELETE FROM food where food_name = ?";

                pst = con.prepareStatement(query1);
                pst.setString(1,tf2.getText());
               
                int i=pst.executeUpdate();
                System.out.println(i);
                if(i!=0) {
                    
                  	   System.out.println("Record is deleted successfully...");
                  	   JOptionPane.showMessageDialog(mainFrame,"Record deleted successfully!!!");
               
            }
                else {
             	   System.out.println("Failed to delete");
             	   JOptionPane.showMessageDialog(mainFrame,"No Record Found !!!! ");
                }

            }}
                catch(Exception ex){
               System.out.println(e);
            }
        
            }
      });
      JPanel jp = new JPanel();
      jp.add(name);
      jp.add(tf2);
      jp.setSize(700,400);
      jp.setLayout(experimentLayout);
      controlPanel.add(jp);
      jp.add(okButton);
      mainFrame.setVisible(true);
	  mainFrame.setLocationRelativeTo(null);
   }
} 
