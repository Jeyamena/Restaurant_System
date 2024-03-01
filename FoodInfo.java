package restaurant;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.JTableHeader;

public class FoodInfo {
   private JFrame mainFrame;
   private JLabel headerLabel;
   //private JLabel statusLabel;
   private JPanel controlPanel;
   private JLabel background;
 //  private TableColumn tColumn;
  
    FoodInfo (){
      prepareGUI();
   }

        
   public static void main(String[] args) throws SQLException{
      FoodInfo  swingControlDemo = new FoodInfo();
      swingControlDemo.showButtonDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Showing all items");
      mainFrame.setSize(700,400);
	//  mainFrame.getContentPane().setBackground(Color.pink);

   
     
     // mainFrame.setLayout(new GridLayout(4, 1));
      mainFrame.setLayout(new FlowLayout());
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            //System.exit(0);
         }
      });
      headerLabel = new JLabel("", JLabel.CENTER);
     // statusLabel = new JLabel("",JLabel.CENTER);
     // statusLabel.setSize(450,200);
      controlPanel = new JPanel();
      controlPanel.setSize(700,400);
	  mainFrame.getContentPane().setBackground(Color.pink);
      controlPanel.setLayout(new FlowLayout());
      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      //mainFrame.add(statusLabel);
      mainFrame.setVisible(true);
   }

   public void showButtonDemo() throws SQLException{
      headerLabel.setText("Restaurant Management System");
	  headerLabel.setFont(new Font(null, Font.BOLD, 25));
      String[] columnNames = {"ID","Food Name",
                        "Price",
                        "Quantity"
                        };
      Object[][] data = new Object[20][4];
     PreparedStatement pst;
       ResultSet rs;
          //  DBConnection con = new DBConnection();
       
            try{
            	Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
                pst = con.prepareStatement("select * from food");
                rs = pst.executeQuery();
                int i=0;
                while(rs.next()){
                    data[i][0] = rs.getInt("id");
                    data[i][1] = rs.getString("food_name");
                    data[i][2] = rs.getDouble("price");
                    data[i][3] =  rs.getInt("quantity");
                    i++;
                }
                mainFrame.setVisible(false);
            }catch(Exception ex){
                System.out.println(ex);
                System.out.println("Error");
                JOptionPane.showMessageDialog(null, "Error !");
            }
            
            
         	
        JTable table = new JTable(data, columnNames);
        table.setSize(400, 400);
		table.setVisible(true);
		
	     
	      Font font = new Font("Verdana", Font.PLAIN, 12);
	      table.setFont(font);
	      table.setRowHeight(30);
	      table.setBackground(Color.blue);
	      table.setForeground(Color.white);
	      JTableHeader tableHeader = table.getTableHeader();
	      tableHeader.setBackground(Color.black);
	      tableHeader.setForeground(Color.white);
	   //   JFrame frame = new JFrame();
	     // frame.setSize(600, 400);
	    //  frame.add(new JScrollPane(table));
	    //  frame.setVisible(true);
		// JTable.setCellRenderer(new ColumnColorRenderer(Color.pink, Color.red));
		// setVisible(true);
		this.background = new JLabel(new ImageIcon("login1.jpg"));
    	//	this.init();
     	table.add(background);
    		background.setVisible(true); 
	  //  table.setEnabled(false);
      controlPanel.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
      //controlPanel.add(table);
      mainFrame.setVisible(true);
	  mainFrame.setLocationRelativeTo(null);
   }
}