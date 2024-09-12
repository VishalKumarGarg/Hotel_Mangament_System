package com.Dashboard.reception;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.Hotel_Mangament_System;
import com.Dashboard.reception.addCustomer.AddCustomer;
import com.Dashboard.reception.checkOut.CheckOut;
import com.Dashboard.reception.customerInfo.CustomerInfo;
import com.Dashboard.reception.pickUp.PickUp;
import com.Dashboard.reception.searchRoom.SearchRoom;
import com.Dashboard.reception.showAllEmployee.showAllEmp;
import com.Dashboard.reception.showAllRooms.ShowAllRooms;
import com.Dashboard.reception.showDepartment.showDepartment;
import com.Dashboard.reception.showManager.ShowManager;
import com.Dashboard.reception.updateCheck.UpdateCheck;
import com.Dashboard.reception.updateRoom.UpdateRoom;
import com.Login.login;

public class Reception extends JFrame implements ActionListener{
	JButton newCustomer,rooms,department,allEmployee,customers,managerInfo,checkOut,updateStatus,roomStatus,pickUp,searchRoom,logOut;
	private static final long serialVersionUID = 1L;
	public Reception() {
		super("Reception");//Add title of the Page
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);//Setting the default to close the frame
		setResizable(false);//Setting of the resizing
		setBounds(350, 200, 800,570);//Setting the location and the size
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hotel_Mangament_System.class.getResource("/icons/eight.jpg")));//Add title_Image of the Page
		setLayout(null);//we use to do it null For making your own layout and not using the predefine layout
		getContentPane().setBackground(Color.WHITE);//setting the frame background color 
		
		newCustomer=new JButton("New Customer");//Creted the JButton 
		newCustomer.setBounds(10, 30, 200, 30);//Setted the location and the Size 
		newCustomer.setFont(new Font("Tahoma",Font.PLAIN,16));//Setted the Font Style
		newCustomer.setBackground(Color.BLACK);//Setted the background Color of button
		newCustomer.setForeground(Color.WHITE);//Setted the Text Color of button
		newCustomer.addActionListener(this);
		add(newCustomer);//Added to frame
		
		rooms=new JButton("Rooms");//Creted the JButton 
		rooms.setBounds(10, 70, 200, 30);//Setted the location and the Size 
		rooms.setFont(new Font("Tahoma",Font.PLAIN,16));//Setted the Font Style
		rooms.setBackground(Color.BLACK);//Setted the background Color of button
		rooms.setForeground(Color.WHITE);//Setted the Text Color of button
		rooms.addActionListener(this);
		add(rooms);//Added to frame
		
		department=new JButton("Department");//Creted the JButton 
		department.setBounds(10, 110, 200, 30);//Setted the location and the Size 
		department.setFont(new Font("Tahoma",Font.PLAIN,16));//Setted the Font Style
		department.setBackground(Color.BLACK);//Setted the background Color of button
		department.setForeground(Color.WHITE);//Setted the Text Color of button
		department.addActionListener(this);
		add(department);//Added to frame
		
		allEmployee=new JButton("All Employee");//Creted the JButton 
		allEmployee.setBounds(10, 150, 200, 30);//Setted the location and the Size 
		allEmployee.setFont(new Font("Tahoma",Font.PLAIN,16));//Setted the Font Style
		allEmployee.setBackground(Color.BLACK);//Setted the background Color of button
		allEmployee.setForeground(Color.WHITE);//Setted the Text Color of button
		allEmployee.addActionListener(this);
		add(allEmployee);//Added to frame
		
		customers=new JButton("Customers Info");//Creted the JButton 
		customers.setBounds(10, 190, 200, 30);//Setted the location and the Size 
		customers.setFont(new Font("Tahoma",Font.PLAIN,16));//Setted the Font Style
		customers.setBackground(Color.BLACK);//Setted the background Color of button
		customers.setForeground(Color.WHITE);//Setted the Text Color of button
		customers.addActionListener(this);
		add(customers);//Added to frame
		
		managerInfo=new JButton("Manager Info");//Creted the JButton 
		managerInfo.setBounds(10, 230, 200, 30);//Setted the location and the Size 
		managerInfo.setFont(new Font("Tahoma",Font.PLAIN,16));//Setted the Font Style
		managerInfo.setBackground(Color.BLACK);//Setted the background Color of button
		managerInfo.setForeground(Color.WHITE);//Setted the Text Color of button
		managerInfo.addActionListener(this);
		add(managerInfo);//Added to frame
		
		checkOut=new JButton("Check-Out");//Creted the JButton 
		checkOut.setBounds(10, 270, 200, 30);//Setted the location and the Size 
		checkOut.setFont(new Font("Tahoma",Font.PLAIN,16));//Setted the Font Style
		checkOut.setBackground(Color.BLACK);//Setted the background Color of button
		checkOut.setForeground(Color.WHITE);//Setted the Text Color of button
		checkOut.addActionListener(this);
		add(checkOut);//Added to frame
		
		updateStatus=new JButton("Check Details");//Creted the JButton 
		updateStatus.setBounds(10, 310, 200, 30);//Setted the location and the Size 
		updateStatus.setFont(new Font("Tahoma",Font.PLAIN,16));//Setted the Font Style
		updateStatus.setBackground(Color.BLACK);//Setted the background Color of button
		updateStatus.setForeground(Color.WHITE);//Setted the Text Color of button
		updateStatus.addActionListener(this);
		add(updateStatus);//Added to frame
		
		roomStatus=new JButton("Room Status");//Creted the JButton 
		roomStatus.setBounds(10, 350, 200, 30);//Setted the location and the Size 
		roomStatus.setFont(new Font("Tahoma",Font.PLAIN,16));//Setted the Font Style
		roomStatus.setBackground(Color.BLACK);//Setted the background Color of button
		roomStatus.setForeground(Color.WHITE);//Setted the Text Color of button
		roomStatus.addActionListener(this);
		add(roomStatus);//Added to frame
		
		
		pickUp=new JButton("Pick Up");//Creted the JButton 
		pickUp.setBounds(10, 390, 200, 30);//Setted the location and the Size 
		pickUp.setFont(new Font("Tahoma",Font.PLAIN,16));//Setted the Font Style
		pickUp.setBackground(Color.BLACK);//Setted the background Color of button
		pickUp.setForeground(Color.WHITE);//Setted the Text Color of button
		pickUp.addActionListener(this);
		add(pickUp);//Added to frame
		
		
		searchRoom=new JButton("Search Room");//Creted the JButton 
		searchRoom.setBounds(10, 430, 200, 30);//Setted the location and the Size 
		searchRoom.setFont(new Font("Tahoma",Font.PLAIN,16));//Setted the Font Style
		searchRoom.setBackground(Color.BLACK);//Setted the background Color of button
		searchRoom.setForeground(Color.WHITE);//Setted the Text Color of button
		searchRoom.addActionListener(this);
		add(searchRoom);//Added to frame
		
		logOut=new JButton("LOGOUT");//Creted the JButton 
		logOut.setBounds(10, 470, 200, 30);//Setted the location and the Size 
		logOut.setFont(new Font("Tahoma",Font.PLAIN,16));//Setted the Font Style
		logOut.setBackground(Color.BLACK);//Setted the background Color of button
		logOut.setForeground(Color.WHITE);//Setted the Text Color of button
		logOut.addActionListener(this);
		add(logOut);//Added to frame
		
		ImageIcon i1= new ImageIcon(Reception.class.getResource("/icons/fourth.jpg"));//place the image inside the Object of ImageIcon
		JLabel image= new JLabel(i1);//create it JLable and pass the ImageIcon to create the image
		image.setBounds(250, 30, 500, 470);//Setting to background
		add(image);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newCustomer) {
			setVisible(false);
			new AddCustomer();
		}else if(e.getSource()==rooms) {
			setVisible(false);
			new ShowAllRooms();
		}else if(e.getSource()==department) {
			setVisible(false);
			new showDepartment();
		}else if(e.getSource()==allEmployee) {
			setVisible(false);
			new showAllEmp();
		}else if(e.getSource()==managerInfo) {
			setVisible(false);
			new ShowManager();
		}else if(e.getSource()==customers) {
			setVisible(false);
			new CustomerInfo();
		}else if(e.getSource()==searchRoom) {
			setVisible(false);
			new SearchRoom();
		}else if(e.getSource()==updateStatus) {
			setVisible(false);
			new UpdateCheck();
		}else if(e.getSource()==roomStatus) {
			setVisible(false);
			new UpdateRoom();
		}else if(e.getSource()==pickUp) {
			setVisible(false);
			new PickUp();
			
		}else if(e.getSource()==logOut) {
			dispose();
			new login();
			
		}else if(e.getSource()==checkOut) {
			setVisible(false);
			new CheckOut();
			
		}
		
	
		
	}
	
//	public static void main(String[] args) {
//		new Reception();
//
//	}

	

}
