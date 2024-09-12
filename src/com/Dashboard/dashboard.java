package com.Dashboard;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.Hotel_Mangament_System;
import com.Dashboard.Admin.addDriver.AddDriver;
import com.Dashboard.Admin.addRooms.addRoom;
import com.Dashboard.Admin.addemp.AddEmp;
import com.Dashboard.reception.Reception;

public class dashboard extends JFrame implements ActionListener{
	
	JMenuBar mB;
	JMenu admin;
	JMenuItem addEmployee,addRooms,addDriver;
	JMenu hotel;
	private static final long serialVersionUID = 1L;
	
	
	public dashboard() {
		super("Dashbord");//Add title of the Page
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hotel_Mangament_System.class.getResource("/icons/eight.jpg")));//Add title_Image of the Page
		setBounds(0, 0, 1550, 850);//set location
		setLayout(null);//we use to do it null For making your own layout and not using the preding layout
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		ImageIcon i1= new ImageIcon(dashboard.class.getResource("/icons/third.jpg"));//place the image inside the Object of ImageIcon
		Image i2=i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);//we used to set the image small or big with help of image method of getImage().getScaledInstance(WIDTH, HEIGHT, DO_NOTHING_ON_CLOSE)
		ImageIcon i3=new ImageIcon(i2);//Convert it Image to ImageIcon
		JLabel bG_image= new JLabel(i3);//create it JLable and pass the ImageIcon to create the image
		bG_image.setBounds(0, 0, 1550, 850);//Setting to background
		add(bG_image);//add image to frame
		
		JLabel text=new JLabel("Our Hotel Welcomes You........");//Created the JLable to Show the text
		text.setBounds(450, 80,1000, 40);//setting the location
		bG_image.add(text);//add it to bg_image because if we will directly add it to the frame then it will hide at the back ok background image
		text.setFont(new Font("Tahoma", Font.PLAIN, 46));//change the style of image
		
		mB= new JMenuBar();//created the JMenuBar
		mB.setBounds(0, 0, 1550, 30);//Set Location
		bG_image.add(mB);//add it to bg_image because if we will directly add it to the frame then it will hide at the back ok background image
		
		hotel=new JMenu("HOTEL MANAGEMENT");//Create the the menu 
		hotel.setForeground(Color.red);//set the color of menu
		mB.add(hotel);//add it to bg_image because if we will directly add it to the frame then it will hide at the back ok background image
		JMenuItem reception=new JMenuItem("RECEPTION");
		reception.addActionListener(this);
		hotel.add(reception);
		
		
		
		admin=new JMenu("ADMIN");//Create the the menu 
		admin.setForeground(Color.BLUE);//set the color of menu
		mB.add(admin);//add it to bg_image because if we will directly add it to the frame then it will hide at the back ok background image
		
		addEmployee=new JMenuItem("ADD EMPLOYEE");
		addEmployee.addActionListener(this);
		admin.add(addEmployee);
		
		addRooms=new JMenuItem("ADD ROOMS");
		addRooms.addActionListener(this);
		admin.add(addRooms);
		
		addDriver=new JMenuItem("ADD DRIVER");
		addDriver.addActionListener(this);
		admin.add(addDriver);
		
		
		setVisible(true);//set visiblity of Frame
		
		// Start a new thread to change the text color
        new Thread(() -> {
            while (true) {
                try {
                    text.setForeground(Color.WHITE);
                    Thread.sleep(500);
                    text.setForeground(Color.BLACK);
                    Thread.sleep(500);
                    text.setForeground(Color.BLUE);
                    Thread.sleep(500);
                    text.setForeground(Color.CYAN);
                    Thread.sleep(500);
                    text.setForeground(Color.MAGENTA);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("RECEPTION")) {
			setVisible(false);
			new Reception();
		}else if(e.getActionCommand().equals("ADD EMPLOYEE")) {
			new AddEmp();
		}else if(e.getActionCommand().equals("ADD ROOMS")){
			new addRoom();
		}else if(e.getActionCommand().equals("ADD DRIVER")) {
			System.out.println("OPen");
			new AddDriver();
		}
	}
	
//	public static void main(String[] args) {
//		new dashboard();
//	}
	

}
