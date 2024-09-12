package com.Dashboard.reception.addCustomer;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.util.Date;

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
import com.Dashboard.Admin.addRooms.room.Dao.RoomDao;
import com.Dashboard.reception.Reception;
import com.Dashboard.reception.addCustomer.customer.Customer;
import com.Dashboard.reception.addCustomer.customer.customerDao.CustomerDao;


public class AddCustomer extends JFrame implements ActionListener{
	JComboBox<String> customerId;
	JTextField customerIdNo,customerName,customerCountry,customerDeposit;
	Choice customerRoom;
	JLabel customerCheckingTime;
	JButton add,back;
	JRadioButton cMale,cFemale;
	ButtonGroup buttonGroup1 = new ButtonGroup();
	private static final long serialVersionUID = 1L;
	public AddCustomer() {
		super("Add Customer");//Add title of the Page
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);//Setting the default to close the frame
		setResizable(false);//Setting of the resizing
		setBounds(350, 200, 800,550);//Setting the location and the size
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hotel_Mangament_System.class.getResource("/icons/eight.jpg")));//Add title_Image of the Page
		setLayout(null);//we use to do it null For making your own layout and not using the predefine layout
		getContentPane().setBackground(Color.WHITE);//setting the frame background color
		
		JLabel heading=new JLabel("ADD CUSTOMER");//Create a JLable for Headiing 
		heading.setBounds(60, 20, 350, 30);//Setting the location and Size
		heading.setFont(new Font("Tahona",Font.PLAIN,30));//Setting the style and size
		add(heading);//Added to frame
		
		JLabel cID=new JLabel("ID");//Create a JLable for Headiing 
		cID.setBounds(35, 80, 350, 25);//Setting the location and Size
		cID.setFont(new Font("Tahona",Font.PLAIN,20));//Setting the style and size
		add(cID);//Added to frame
		String str[]={null,"PassPort","Aadhar","Driving License","Voter Id Card"};//Creted the Array of String Which is pas in the ComboBox
		customerId =new JComboBox<>(str);//Created the ComboBox 
		customerId.setBounds(210,80,150 ,25 );//Set the Size and Loaction 
		customerId.setBackground(Color.WHITE);//Set the BackGround Color 
		add(customerId);//Added to Frame
		
		JLabel cIdNumber=new JLabel("ID-Number");//Create a JLable for Headiing 
		cIdNumber.setBounds(35, 120, 150, 25);//Setting the location and Size
		cIdNumber.setFont(new Font("Tahona",Font.PLAIN,20));//Setting the style and size
		add(cIdNumber);//Added to frame
		customerIdNo=new JTextField();//Created the JTextField
		customerIdNo.setBounds(210, 120, 150, 25);//Setting the location and the size 
		add(customerIdNo);//Adding to frame
		
		JLabel cName=new JLabel("Name");//Create a JLable for Headiing 
		cName.setBounds(35, 160, 150, 25);//Setting the location and Size
		cName.setFont(new Font("Tahona",Font.PLAIN,20));//Setting the style and size
		add(cName);//Added to frame
		customerName=new JTextField();//Created the JTextField
		customerName.setBounds(210, 160, 150, 25);//Setting the location and the size 
		add(customerName);//Adding to frame
		
		JLabel cGender=new JLabel("Gender");//Create a JLable for Headiing 
		cGender.setBounds(35, 200, 150, 25);//Setting the location and Size
		cGender.setFont(new Font("Tahona",Font.PLAIN,20));//Setting the style and size
		add(cGender);//Added to frame
		
		cMale=new JRadioButton("Male");//Created JRadioButton
		cMale.setBounds(200, 200, 80, 20);//Setting the location and Size
		cMale.setFont(new Font("Tahoma",Font.PLAIN,14));//Setting the style
		cMale.setBackground(Color.WHITE);//Setting the background
		cMale.setText("Male");
		add(cMale);//Added to Frame
		buttonGroup1.add(cMale);
		
		cFemale=new JRadioButton("Female");//Created JRadioButton
		cFemale.setBounds(310, 200, 100, 20);//Setting the location and Size
		cFemale.setFont(new Font("Tahoma",Font.PLAIN,14));//Setting the style
		cFemale.setBackground(Color.WHITE);//Setting the background
		cFemale.setText("Female");
		add(cFemale);//Added to frame
		buttonGroup1.add(cFemale);
		
		JLabel cCountry=new JLabel("Country");//Create a JLable for Headiing 
		cCountry.setBounds(35, 240, 150, 25);//Setting the location and Size
		cCountry.setFont(new Font("Tahona",Font.PLAIN,20));//Setting the style and size
		add(cCountry);//Added to frame
		customerCountry=new JTextField();//Created the JTextField
		customerCountry.setBounds(210, 240, 150, 25);//Setting the location and the size 
		add(customerCountry);//Adding to frame
		
		JLabel cRoom=new JLabel("Customer-Room");//Create a JLable for Headiing 
		cRoom.setBounds(35, 280, 150, 25);//Setting the location and Size
		cRoom.setFont(new Font("Tahona",Font.PLAIN,20));//Setting the style and size
		add(cRoom);//Added to frame
		customerRoom =new Choice();//Created the Choice object
		customerRoom.add("0");
		RoomDao rd= new RoomDao();//Created the roomDao To access the ShowRoom() which is available
		try {
				ResultSet rs= rd.showRooms();//get the resultset object
				while(rs.next()) 
					customerRoom.add(rs.getString(1));
		}catch (Exception e) {
			e.printStackTrace();
		}
		customerRoom.setBounds(210, 280, 150, 25);
		add(customerRoom);
		
		JLabel cCheckingTime=new JLabel("Checking Time");//Create a JLable for Headiing 
		cCheckingTime.setBounds(35, 320, 150, 25);//Setting the location and Size
		cCheckingTime.setFont(new Font("Tahona",Font.PLAIN,20));//Setting the style and size
		add(cCheckingTime);//Added to frame
		customerCheckingTime=new JLabel(new Date()+"");//Create a JLable for Headiing 
		customerCheckingTime.setBounds(210, 320, 170, 25);//Setting the location and Size
		customerCheckingTime.setFont(new Font("Tahona",Font.PLAIN,16));//Setting the style and size
		add(customerCheckingTime);//Added to frame
		
		JLabel cDeposit=new JLabel("Deposit");//Create a JLable for Headiing 
		cDeposit.setBounds(35, 360, 150, 25);//Setting the location and Size
		cDeposit.setFont(new Font("Tahona",Font.PLAIN,20));//Setting the style and size
		add(cDeposit);//Added to frame
		customerDeposit=new JTextField();//Created the JTextField
		customerDeposit.setBounds(210, 360, 150, 25);//Setting the location and the size 
		add(customerDeposit);//Adding to frame
		
		
		add=new JButton("Add");
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Tahona",Font.BOLD,18));//Setting the style and size
		add.setBounds(50, 410, 120, 40);
		add.addActionListener(this);
		add(add);
		
		back=new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Tahona",Font.BOLD,18));//Setting the style and size
		back.setBounds(200, 410, 120, 40);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));//Storing the image in the ImageIcon
		Image i2=i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);//we used to set the image small or big with help of image method of getImage().getScaledInstance(WIDTH, HEIGHT, DO_NOTHING_ON_CLOSE)
		ImageIcon i3=new ImageIcon(i2);//Convert it Image to ImageIcon 
		JLabel image=new JLabel(i3);//create it JLable and pass the ImageIcon to create the image
		image.setBounds(400, 50,300,400);//Setting the location and size
		add(image);//Added to frame
		
		setVisible(true);
		// Add a WindowListener to detect when this frame is closing
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Create and show the second JFrame
                new Reception();
            }
        });
	}
	String tellGender(){
		if(cMale.isSelected()) {
			return "Male";
		}
		else if(cFemale.isSelected()) 
			return "Female";
		else 
			return null;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		String cusId=(String) customerId.getSelectedItem();
//		String cusIdNo=customerIdNo.getText().trim();
//		String cusName=customerName.getText().trim();
//		String cusGender=tellGender();
//		String cusCountry=customerCountry.getText().trim();
//		int cusRoom=Integer.parseInt(customerRoom.getSelectedItem());
//		String cusCheckingTime=customerCheckingTime.getText().trim();
//		double cusDeposit=Double.parseDouble(customerDeposit.getText().trim());
//		
		if(e.getSource()==add) {
				if(customerId.getSelectedItem()==null||customerIdNo.getText().trim().isEmpty()||customerName.getText().trim().isEmpty()||tellGender()==null||customerCountry.getText().trim().isEmpty()||customerRoom.getSelectedItem()=="0"||customerDeposit.getText().trim().isEmpty()) {
					if(customerId.getSelectedItem()==null)
						JOptionPane.showMessageDialog(this, "Enter the IdName");
					else if(customerIdNo.getText().trim().isEmpty())
						JOptionPane.showMessageDialog(this, "Enter the Id Number");
					else if(customerName.getText().trim().isEmpty())
						JOptionPane.showMessageDialog(this, "Enter the Name");
					else if(tellGender()==null)
						JOptionPane.showMessageDialog(this, "Enter the Gender");
					else if(customerCountry.getText().trim().isEmpty())
						JOptionPane.showMessageDialog(this, "Enter the Country");
					else if(customerRoom.getSelectedItem()=="0")
						JOptionPane.showMessageDialog(this, "Enter the Room");
					else if(customerDeposit.getText().trim().isEmpty())
						JOptionPane.showMessageDialog(this, "Customer have to deposite some Amount");
					
				}else {
					Customer c1= new Customer((String) customerId.getSelectedItem(), customerIdNo.getText().trim(), customerName.getText().trim(), tellGender(), customerCountry.getText().trim(), Integer.parseInt(customerRoom.getSelectedItem()), customerCheckingTime.getText().trim(), Double.parseDouble(customerDeposit.getText().trim()));
					CustomerDao save= new CustomerDao();
					int done=save.save(c1);
					System.out.println("\n "+done);
					if(done==1) {
						JOptionPane.showMessageDialog(this, "Successfully save");
						setVisible(false);
						new Reception();
					}else 
						JOptionPane.showMessageDialog(this, "Not save");
				}
		}else if(e.getSource()==back){
				setVisible(false);
				new Reception();
		}
	}
	
//	public static void main(String[] args) {
//		new AddCustomer();
//	}
	

}
