package restaurant;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;


import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GenerateBill extends JFrame{
	   JTextField food,quantity;
	   String[] columnNames = {"Food Name",
	                        "Quantity",
	                        "Price"
	   };
	   //JLabel background;
   JTable cart;
  // JLabel totalP = new JLabel("TOTAL PRICE : 0.0tk");
   
   JLabel totalP = new JLabel();
  
   Object data[][] = new Object[100][3];
  
   int i = 0;
  
   double totalprice = 0;
    ArrayList<foodCart> foodList = new ArrayList<>();
    GenerateBill(){
       JPanel jp1 = new JPanel();

    	
		//jp1.getContentPane().setBackground(Color.orange);
       this.setLayout(new GridLayout(2,2));
       JLabel a = new JLabel("Food Name : ");
       jp1.add(a);
       food = new JTextField(50);
       jp1.add(food);
       JLabel b = new JLabel("Quantity : ");
       jp1.add(b);
       quantity = new JTextField(50);
       jp1.add(quantity);
      
		setBackground(Color.pink);

       JButton ok = new JButton("CheckOut");

       JPanel jp2 = new JPanel();
       jp2.setSize(700, 400);
       jp1.add(ok);
       ok.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            PreparedStatement pst;
           // DBConnection con = new DBConnection();
            ResultSet rs;
            try{
            	  Class.forName("com.mysql.cj.jdbc.Driver");
                  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
                 
                pst = con.prepareStatement("select price from food where food_name = ?");
                pst.setString(1, food.getText());
                rs = pst.executeQuery();
                System.out.println(rs);
                while (rs.next()){
                    foodCart f = new foodCart();
                    f.name = food.getText();
                    f.quantity = Integer.parseInt(quantity.getText());
                    f.totalPer = f.quantity*rs.getDouble("price");
                    totalprice += f.quantity*rs.getDouble("price");

                    foodList.add(f);
                    data[i][0] = f.name;
                    data[i][1] = Integer.parseInt(quantity.getText());
                    data[i][2] = f.quantity*rs.getDouble("price");
                    i++;
                    food.setText("");
                    quantity.setText("");
               ///     DefaultTableModel model = (DefaultTableModel) cart.getModel();
                //    model.setRowCount(0);
               //   //  cart = new JTable(data, columnNames);
                    System.out.println(totalprice);
                    removeAll();
                    //Total price not refreshing
                 //   totalP.setText("TOTAL Price : " + Double.toString(totalprice) + "tk");
                    totalP.revalidate();
                    totalP.repaint();
                    revalidate();
                    repaint();
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    double vat = 15;
                    JOptionPane.showMessageDialog(null, "Total Cost : " + (totalprice+totalprice*vat/100) + "tk with vat " + vat/100 +"%");
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
         }
      });
    //   cart = new JTable(data, columnNames);
     //  cart.setSize(300, 450);
       //cart.setEnabled(false);
//       jp2.setLayout(new GridLayout(1,1));
   //    this.background = new JLabel(new ImageIcon("r1.jpeg"));
		//this.init();

     //  jp2.add(background);
		//background.setVisible(true);
       jp2.setLayout(new FlowLayout());
       jp2.add(totalP);
       jp2.add(new JScrollPane(cart, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
      setBackground(Color.pink);


       this.add(jp1);
       this.add(jp2);
       this.setSize(600,550);
	    this.setLocationRelativeTo(null);
       this.setVisible(true);
   }

class foodCart{
    String name;
    Double totalPer;
    int quantity;
}
}