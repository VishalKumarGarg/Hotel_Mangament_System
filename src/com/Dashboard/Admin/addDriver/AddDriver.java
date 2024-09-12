package com.Dashboard.Admin.addDriver;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.Hotel_Mangament_System;
import com.Dashboard.Admin.addDriver.driver.Driver;
import com.Dashboard.Admin.addDriver.driver.dao.DriverDao;

public class AddDriver extends JFrame implements ActionListener{
	
	JTextField driverName,driverAge,driverCarCompany,driverCarModel,driverLocation;
	JComboBox<String> driverAvailable;
	JButton Submit,Cancel;
	JRadioButton eMale,eFemale;
	ButtonGroup buttonGroup1 = new ButtonGroup();
	
	private static final long serialVersionUID = 1L;
	
	public AddDriver() {
		super("ADD-DRIVERS");//Add title of the Page
		setResizable(false);//Setting of the resizing
		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);//Setting the default to close the frame
		setBounds(300, 170, 980, 600);//Setting the location and the size
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hotel_Mangament_System.class.getResource("/icons/eight.jpg")));//Add title_Image of the Page
		setLayout(null);//we use to do it null For making your own layout and not using the predefine layout
		getContentPane().setBackground(Color.WHITE);//setting the frame background color
		
		JLabel heading=new JLabel("Add Drivers");//Creating the Label
		heading.setFont(new Font("Tahoma",Font.BOLD,34));//Setting the Style of text
		heading.setBounds(100, 15, 250, 36);//Setting the Location and size of Label
		add(heading);//Add the Label to Frame
		
		JLabel dName=new JLabel("Driver Name.");//Creating the Label
		dName.setFont(new Font("Tahoma",Font.PLAIN,16));//Setting the Style of text
		dName.setBounds(60, 100, 120, 30);//Setting the Location and size of Label
		add(dName);//Add the Label to Frame
		driverName=new JTextField();//created the textField to take input
		driverName.setBounds(200, 100, 150, 30);//Setting the Location and size of Label
		add(driverName);//Add the JTextField to Frame
		
		JLabel dAge=new JLabel("Age");//Creating the Label
		dAge.setFont(new Font("Tahoma",Font.PLAIN,16));//Setting the Style of text
		dAge.setBounds(60, 150, 120, 30);//Setting the Location and size of Label
		add(dAge);//Add the Label to Frame
		driverAge=new JTextField();//created the textField to take input
		driverAge.setBounds(200, 150, 150, 30);
		add(driverAge);
		
		JLabel dGender=new JLabel("Gender");//Creating the Label
		dGender.setFont(new Font("Tahoma",Font.PLAIN,16));//Setting the Style of text
		dGender.setBounds(60, 200, 120, 30);//Setting the Location and size of Label
		add(dGender);//Add the Label to Frame
		
		eMale=new JRadioButton("Male");//Created JRadioButton
		eMale.setBounds(200, 200, 70, 30);//Setting the location and Size
		eMale.setFont(new Font("Tahoma",Font.PLAIN,14));//Setting the style
		eMale.setBackground(Color.WHITE);//Setting the background
		eMale.setText("Male");
		add(eMale);//Added to Frame
		buttonGroup1.add(eMale);
		
		eFemale=new JRadioButton("Female");//Created JRadioButton
		eFemale.setBounds(290, 200, 70, 30);//Setting the location and Size
		eFemale.setFont(new Font("Tahoma",Font.PLAIN,14));//Setting the style
		eFemale.setBackground(Color.WHITE);//Setting the background
		eFemale.setText("Female");
		add(eFemale);//Added to frame
		buttonGroup1.add(eFemale);
		
		JLabel dCarCompany=new JLabel("Car Company.");//Creating the Label
		dCarCompany.setFont(new Font("Tahoma",Font.PLAIN,16));//Setting the Style of text
		dCarCompany.setBounds(60, 250, 120, 30);//Setting the Location and size of Label
		add(dCarCompany);//Add the Label to Frame
		driverCarCompany=new JTextField();//created the textField to take input
		driverCarCompany.setBounds(200, 250, 150, 30);//Setting the Location and size of Label
		add(driverCarCompany);//Add the JTextField to Frame
		
		JLabel dCarModel=new JLabel("Car Model");//Creating the Label
		dCarModel.setFont(new Font("Tahoma",Font.PLAIN,16));//Setting the Style of text
		dCarModel.setBounds(60, 300, 120, 30);//Setting the Location and size of Label
		add(dCarModel);//Add the Label to Frame
		driverCarModel=new JTextField();//created the textField to take input
		driverCarModel.setBounds(200, 300, 150, 30);//Setting the Location and size of Label
		add(driverCarModel);//Add the JTextField to Frame
		
		JLabel dAvailable =new JLabel("Available");
		dAvailable.setFont(new Font("Tahoma",Font.PLAIN,16));//Setting the Style of text
		dAvailable.setBounds(60, 350, 120, 30);//Setting the Location and size of Label
		add(dAvailable);
		String str1[]= {null,"Available","Busy"};
		driverAvailable =new JComboBox<>(str1);
		driverAvailable.setBounds(200, 350, 150, 30);
		driverAvailable.setBackground(Color.WHITE);
		add(driverAvailable);
		
		JLabel dLocation=new JLabel("Driver Location");//Creating the Label
		dLocation.setFont(new Font("Tahoma",Font.PLAIN,16));//Setting the Style of text
		dLocation.setBounds(60, 400, 120, 30);//Setting the Location and size of Label
		add(dLocation);//Add the Label to Frame
		driverLocation=new JTextField();//created the textField to take input
		driverLocation.setBounds(200, 400, 150, 30);//Setting the Location and size of Label
		add(driverLocation);//Add the JTextField to Frame
		
		Submit =new JButton("Submit");
		Submit.setBackground(Color.black);
		Submit.setForeground(Color.WHITE);
		Submit.setFont(new Font("Tahoma",Font.BOLD,16));
		Submit.setBounds(100, 480, 100, 40);
		Submit.addActionListener(this);
		add(Submit);
		
		Cancel =new JButton("Cancel");
		Cancel.setBackground(Color.black);
		Cancel.setForeground(Color.WHITE);
		Cancel.setFont(new Font("Tahoma",Font.BOLD,16));
		Cancel.setBounds(230, 480, 100, 40);
		Cancel.addActionListener(this);
		add(Cancel);
		
		
		ImageIcon i1= new ImageIcon(AddDriver.class.getResource("/icons/eleven.jpg"));//place the image inside the Object of ImageIcon
		Image i2=i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);//we used to set the image small or big with help of image method of getImage().getScaledInstance(WIDTH, HEIGHT, DO_NOTHING_ON_CLOSE)
		ImageIcon i3=new ImageIcon(i2);//Convert it Image to ImageIcon
		JLabel image= new JLabel(i3);//create it JLable and pass the ImageIcon to create the image
		image.setBounds(400, 20, 500, 500);//Setting to background
		add(image);
		setVisible(true);//Setting the Visible on of frame
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Submit) {
			if(driverName.getText().trim().isEmpty()||driverAge.getText().trim().isEmpty()||tellGender()==null||driverCarCompany.getText().trim().isEmpty()||driverCarModel.getText().trim().isEmpty()||driverAvailable.getSelectedItem()==null||driverLocation.getText().trim().isEmpty()) {
				if(driverName.getText().trim().isEmpty())
					JOptionPane.showMessageDialog(this, "Enter the Name");
				else if(driverAge.getText().trim().isEmpty())
					JOptionPane.showMessageDialog(this, "Enter the Age");
				else if(tellGender()==null)
					JOptionPane.showMessageDialog(this, "Enter the Gender");
				else if(driverCarCompany.getText().trim().isEmpty())
					JOptionPane.showMessageDialog(this, "Enter the Car Company");
				else if(driverCarModel.getText().trim().isEmpty())
					JOptionPane.showMessageDialog(this, "Enter the Car Model");
				else if(driverAvailable.getSelectedItem()==null)
					JOptionPane.showMessageDialog(this, "Enter the Available or not");
				else 
					JOptionPane.showMessageDialog(this, "Enter the LOcation");
				
			}else {
				System.out.println("Not Empty");
				Driver d=new Driver(driverName.getText().trim(), Integer.parseInt(driverAge.getText().trim()), tellGender(), driverCarCompany.getText().trim(), driverCarModel.getText().trim(), (String) driverAvailable.getSelectedItem(), driverLocation.getText().trim());
				DriverDao save1=new DriverDao();
				int done=save1.save(d);
				System.out.println("\n "+done);
				if(done==1) {
					JOptionPane.showMessageDialog(this, "Successfully save");
					setVisible(false);
				}else 
					JOptionPane.showMessageDialog(this, "Not save");
			}
			
		}else if(e.getSource()==Cancel){
			setVisible(false);
		}
		
	}
	String tellGender(){
		if(eMale.isSelected()) {
			return "Male";
		}
		else if(eFemale.isSelected()) 
			return "Female";
		else 
			return null;
	}
	
//	public static void main(String[] args) {
//		new AddDriver();
//
//	}

}
