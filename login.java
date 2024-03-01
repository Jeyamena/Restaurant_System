package restaurant;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;

class Frame1 extends JFrame{
    JLabel idLabel;
    JLabel passLabel;
	JLabel background;
	JLabel headerLabel;
	JLabel devInfo;
    JTextField id;
    JPasswordField pass;
    JButton submit;
    JButton reset;
    JLabel login;

   public Frame1(){
		setTitle("Restaurant Management System");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
     	this.background = new JLabel(new ImageIcon("r1.jpeg"));
		this.init();

		add(background);
		background.setVisible(true);  
        this.pack();
		this.setSize(950,800);
		this.setLocationRelativeTo(null);
    }
 
    public void init(){
    	
    	
    	
		headerLabel = new JLabel();
		this.headerLabel.setText("RESTAURANT MANAGEMENT SYSTEM ");
		//this.headerLabel.setText("LOGIN PORTAL");
		this.headerLabel.setBounds(100,30,800,100);
	    this.headerLabel.setFont(new Font("ALGERIAN", Font.BOLD, 35));
		headerLabel.setForeground(Color.white);
		add(headerLabel);
		
		login = new JLabel();
		this.login.setText("LOGIN PORTAL");
		//this.headerLabel.setText("LOGIN PORTAL");
		this.login.setBounds(300,100,700,100);
	    this.login.setFont(new Font("ALGERIAN", Font.BOLD, 30));
		login.setForeground(Color.white);
		add(login);
		
		
		
		
		
		idLabel = new JLabel();
		idLabel = new JLabel();
		this.idLabel.setText("Username");
		this.idLabel.setBounds(190,200,100,50);
		this.idLabel.setFont(new Font(null, Font.BOLD, 20));
		idLabel.setForeground(Color.white);
		add(idLabel);
		
        passLabel=new JLabel("Password");
		this.passLabel.setBounds(190,270,100,50);
		this.passLabel.setFont(new Font(null, Font.BOLD, 20));
		passLabel.setForeground(Color.white);
		add(passLabel);
		
		devInfo = new JLabel();
		this.devInfo.setBounds(130,300,1000,50);
		this.devInfo.setFont(new Font("Geomanist", Font.PLAIN, 15));
		devInfo.setForeground(Color.white);
		add(devInfo);
		
		id=new JTextField();
		this.id.setBounds(300,200,250,40);
		add(id);
		
		pass=new JPasswordField();
		this.add(pass);
		this.pass.setBounds(300,270,250,40);
		this.id.setVisible(true);
     
		//JButton fkButton = new JButton(icon6);
	
       this.submit=new JButton("LOGIN");
	   this.submit.setBounds(440,350,110,50);
	   add(submit);
	//   this.submit.setBackground(Color.MAGENTA);
	      
       submit.addActionListener(this::submitActionPerformed);
      
      
      
       this.reset=new JButton("RESET");
	   this.reset.setBounds(300,350,110,50);
	   add(reset);
	//   this.reset.setBackground(Color.YELLOW);
       reset.addActionListener(this::resetActionPerformed);
      // reset = new JButton("reset");
    } 

    public void resetActionPerformed(java.awt.event.ActionEvent evt){
    	   
    	    
    	    
    	    id.setText("");
    	    pass.setText("");
    	    
    	  
    	   }
    
   public void submitActionPerformed(java.awt.event.ActionEvent evt){
   if(id.getText().equals("admin") && pass.getText().equals("admin")){
     this.hide();
   //  Frame2new fn=new Frame2new();
     home fn=new home();
    fn.showButtonDemo();
   }
   else{
    JOptionPane.showMessageDialog(null, "Invalid password!");
   }
   }
}
 public class login{
	public static void main(String[] args){
		Frame1 f = new Frame1();
		f.setVisible(true);
	}
}