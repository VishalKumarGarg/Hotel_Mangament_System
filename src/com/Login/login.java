package com.Login;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import com.Hotel_Mangament_System;
import com.Connection1.getConnnection;
import com.Dashboard.dashboard;

public class login extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	JTextField username;
	JPasswordField password;
	JButton login,reset,cancel;
	Connection conn;
	Statement stmt=null;
    ResultSet rs=null;
	
    Action buttonAction = new AbstractAction() {//call the action listerneer
		private static final long serialVersionUID = 1L;

		@Override
        public void actionPerformed(ActionEvent e) {
            login.doClick();
        }
    };
    
	public login() {
		super("Login-Page");//Add title of the Page
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hotel_Mangament_System.class.getResource("/icons/eight.jpg")));//Add title_Image of the Page
		getContentPane().setBackground(Color.WHITE);//set Background of frame 
		setLayout(null);//we use to do it null For making your own layout and not using the preding layout
		JLabel user=new JLabel("Username");//we put the lable to tell which textfield is this
		user.setBounds(40, 20, 100, 30);//setting the location
		add(user);//add it to frame
		//JTextField
		username=new JTextField();//creating the a JTextField to accpet input
		username.setBounds(150, 20, 150, 30);//setting the location
		add(username);//add it frame
		
		
		JLabel pass=new JLabel("Password");//we put the lable to tell which textfield is this
		pass.setBounds(40, 70, 100, 30);//setting the location
		add(pass);//add it to frame
		//JTextField
		password=new JPasswordField();//creating the a JTextField to accpet input
		password.setBounds(150, 70, 150, 30);//setting the location
		add(password);//add it frame
		
		login=new JButton("Login");//Createing the JButton 
		login.setBounds(40, 150, 120, 30);//setting the location
		login.setBackground(Color.BLACK);//Setting the background color
		login.setForeground(Color.white);//setting the textColor
		login.addActionListener(this);
		add(login);//add it to frame
		login.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "clickButton");//it help y=to tell which key is prees
		login.getActionMap().put("clickButton", buttonAction);//it used to perfrom action

		reset=new JButton("Reset");//Createing the JButton
		reset.setBounds(180, 150, 120, 30);//setting the location
		reset.setBackground(Color.BLACK);//Setting the background color
		reset.setForeground(Color.white);//setting the textColor
		reset.addActionListener(this);
		add(reset);//add it to frame
		
		cancel=new JButton("Cancel");//Createing the JButton
		cancel.setBounds(110, 200, 120, 30);//setting the location
		cancel.setBackground(Color.BLACK);//Setting the background color
		cancel.addActionListener(this);
		cancel.setForeground(Color.white);//setting the textColor
		add(cancel);//add it to frame
		
		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));//Storing the image in the ImageIcon
		Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);//we used to set the image small or big with help of image method of getImage().getScaledInstance(WIDTH, HEIGHT, DO_NOTHING_ON_CLOSE)
		ImageIcon i3=new ImageIcon(i2);//Convert it Image to ImageIcon 
		JLabel image=new JLabel(i3);//create it JLable and pass the ImageIcon to create the image
		image.setBounds(350, 10,200,200);
		add(image);
		
		setBounds(500, 200, 600, 300);//setting the frame on screen
		setVisible(true);//setting the visiblity
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//if Login button press
		if(ae.getSource()==login) {
			String uname=username.getText().trim();
			String pass=new String(password.getPassword()).trim();
			//Inside if Condition check that text filed are empty or not 
			if(uname.isEmpty()||pass.isEmpty()) {
				//if text fields are empty then it will check which textfield is empty
				if(uname.isEmpty()||pass.isEmpty())
					JOptionPane.showMessageDialog(this, "Enter the Username and Password");
				else if(uname.isEmpty())
					JOptionPane.showMessageDialog(this, "Enter the Username");
				else
					JOptionPane.showMessageDialog(this, "Enter the Password");
			}else {
				//if textFields are not empty then we will check that username or pass is same or not
				String check="select * from login where username ='"+uname+"'";
				try {
					System.out.println("Start in try");
					conn=getConnnection.connection();
					stmt=conn.createStatement();
					rs=stmt.executeQuery(check);
					//if the username is correct then it will enter the if condition
					if(rs.next()) {
						if(pass.equals(rs.getString(2))) {//if pass is correct 
							setVisible(false);
							new dashboard();
						}else {//if password is worng
							JOptionPane.showMessageDialog(this, "Worng Password");
							System.out.println("Worng password");
						}
					}else {//if tghe username is incorrect
						JOptionPane.showMessageDialog(this, "Worng Username");
						System.out.println("Worng Username");
					}
					conn.close();
					System.out.println("End of Try");
						
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("Not Empty");
			}
		//if reset button is press	
		}else if(ae.getSource()==reset) {
			username.setText(null);
			password.setText(null);
			System.out.println("Reset the input text field");
		}
		//if cancel button is press
		else {
			dispose();//to close the page
			System.out.println("Out of software....");
		}
		
		
	}
	
//	public static void main(String[] args) {
//		System.out.println("working");
//		new login();
//	}
	

}
