package restaurant;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;

public class home {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JLabel uplabel;
   private JLabel addlabel;
   private JLabel billlabel;
   private JLabel foodinfolabel;   
   private JLabel deletelabel;
   private JPanel DispPanel;
   public home(){
      prepareGUI();
   }

   public static void main(String[] args){
      //Frame2new  swingControlDemo = new Frame2new();
      //swingControlDemo.showButtonDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Restaurant Management System");
      mainFrame.setBounds(100,100,700,400);
      mainFrame.setLayout(new GridLayout(3,1));
	  mainFrame.getContentPane().setBackground(Color.pink);
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }
      });
      headerLabel = new JLabel("", JLabel.CENTER);
      uplabel =new JLabel();
      addlabel=new JLabel();
      billlabel=new JLabel();
      foodinfolabel=new JLabel();
      deletelabel=new JLabel();
      
      DispPanel =new JPanel();
     DispPanel.setLayout(new GridLayout(-1,5));
    // DispPanel.setBackground(Color.pink);
 //   DispPanel.setOpaque(true);
      controlPanel = new JPanel();
   //  controlPanel.setBounds(100,100,100,50);
      controlPanel.setLayout(new GridLayout(-1,5));
      
  
	 
      mainFrame.add(headerLabel);
     
      mainFrame.add(DispPanel);
      mainFrame.add(controlPanel);
     
    
      mainFrame.setVisible(true);
   }
   
   public void showButtonDemo(){
		headerLabel.setText("Restaurant Management System");
	  	Border blackline = BorderFactory.createLineBorder(Color.black);
		 this.headerLabel.setFont(new Font("ALGERIAN", Font.BOLD, 45));
		headerLabel.setForeground(Color.BLACK);
		
		
		
		uplabel.setText("Update Food Items");
	    this.uplabel.setFont(new Font("ALGERIAN", Font.BOLD, 30));
	    
	   // headerLabel.setBorder(BorderFactory.createLineBorder(Color.blue));
	//dispPanel.setBackground(Color.pink);
	     uplabel.setSize(10, 10);
	     uplabel.setBackground(Color.pink);
	     uplabel.setOpaque(true);
		
	    //DispPanel.setPreferredSize(new Dimension(350, 190));
	   // DispPanel.setBorder(blackline);
	   // uplabel.add(headerLabel, BorderLayout.SOUTH);
	    
	    addlabel.setText("Add Food Items");
	    this.addlabel.setFont(new Font("ALGERIAN", Font.BOLD,30 ));
	    addlabel.setSize(10, 10);
	     addlabel.setBackground(Color.pink);
	     addlabel.setOpaque(true);
		
	 //  addlabel.add(headerLabel, BorderLayout.SOUTH);
	    
		billlabel.setText("billing Food Items");
		 this.billlabel.setFont(new Font("ALGERIAN", Font.BOLD, 30));
		billlabel.setSize(10, 10);
	     billlabel.setBackground(Color.pink);
	     billlabel.setOpaque(true);
		
		//billlabel.add(headerLabel, BorderLayout.EAST);
		
		 
		foodinfolabel.setText("Menu  Card Details");
		this.foodinfolabel.setFont(new Font("ALGERIAN", Font.BOLD, 30));
		foodinfolabel.setSize(10, 10);
		foodinfolabel.setBackground(Color.pink);
		foodinfolabel.setOpaque(true);
		
		deletelabel.setText("Cancel Food");
		this.deletelabel.setFont(new Font("ALGERIAN", Font.BOLD, 30));
		deletelabel.setSize(10, 10);
		deletelabel.setBackground(Color.pink);
		deletelabel.setOpaque(true);
			
		

	   
		DispPanel.add(uplabel);
		DispPanel.add(addlabel);
		DispPanel.add(billlabel);
		DispPanel.add(foodinfolabel);
		DispPanel.add(deletelabel);
		
		
		DispPanel.setBackground(Color.pink);
        
		
		Icon icon1 = new ImageIcon("billing food.jpg");
		Icon icon2 = new ImageIcon("insert food.jpg");
		Icon icon3 = new ImageIcon("update.png");
		Icon icon4 = new ImageIcon("cancel food.jpg");
		Icon icon5 = new ImageIcon("foodinfo.jpg");
		//DELETE BUTTON
		JButton dlButton = new JButton(icon4);
		JButton billButton = new JButton(icon1);
		JButton fkButton=new JButton(icon5);
		JButton afButton = new JButton(icon2);
		JButton ufButton = new JButton(icon3);
			
        fkButton.addActionListener(new ActionListener()
{
         public void actionPerformed(ActionEvent e) {
        //   ItemInfo ii=new ItemInfo();
           FoodInfo ii=new FoodInfo();
             try {
                 ii.showButtonDemo();
             } catch (SQLException ex) {
               //  Logger.getLogger(Frame2new.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
});
        billButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
{
            GenerateBill gb=new GenerateBill();}
});
      afButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e)
{
            addFood ef=new addFood();
            ef.showButtonDemo();
         }
});
      ufButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            updateFood uf=new updateFood();
            uf.showButtonDemo();
         }
});
		//delete button actionlistener
	 dlButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
           deleteFood dl=new deleteFood();
            dl.showButtonDemo();
         }
});
      controlPanel.add(ufButton);
      controlPanel.add(afButton);
	  controlPanel.add(billButton);
      controlPanel.add(fkButton);
	  controlPanel.add(dlButton);
      mainFrame.setVisible(true);
	  mainFrame.setLocationRelativeTo(null);
   }
}