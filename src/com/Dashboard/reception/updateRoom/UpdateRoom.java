package com.Dashboard.reception.updateRoom;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.Hotel_Mangament_System;
import com.Connection1.getConnnection;
import com.Dashboard.reception.Reception;
import com.Dashboard.reception.addCustomer.customer.customerDao.CustomerDao;

public class UpdateRoom extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	Choice customerId;
	JTextField customerRoom,customercusAvailable,customerCleanSatus;
	JButton check,update,back;
	public UpdateRoom() {
		super("Reception");//Add title of the Page
		setResizable(false);//Setting of the resizing
		setBounds(300, 200, 980,500);//Setting the location and the size
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hotel_Mangament_System.class.getResource("/icons/eight.jpg")));//Add title_Image of the Page
		setLayout(null);//we use to do it null For making your own layout and not using the predefine layout
		getContentPane().setBackground(Color.WHITE);//setting the frame background color
		
		
		
		JLabel text=new JLabel("Update Room Status");
		text.setFont(new Font("Tahoma",Font.PLAIN,25));
		text.setBounds(90, 20, 250, 30);
		text.setBackground(Color.blue);
		add(text);
		
		JLabel cusId=new JLabel("Customer ID");
		cusId.setBounds(30, 80, 100, 20);
		add(cusId);
		customerId=new Choice();
		customerId.setBounds(200, 80, 150, 25);
		add(customerId);
		try {
			ResultSet rs=new CustomerDao().showAllCustomer();
			while(rs.next())
				customerId.add(rs.getString(2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel cusRoom=new JLabel("Room No");
		cusRoom.setBounds(30, 130, 100, 20);
		add(cusRoom);
		customerRoom=new JTextField();
		customerRoom.setBounds(200, 130, 150, 25);
		add(customerRoom);
		
		JLabel cusAvailable=new JLabel("Availablity");
		cusAvailable.setBounds(30, 180, 100, 20);
		add(cusAvailable);
		customercusAvailable=new JTextField();
		customercusAvailable.setBounds(200, 180, 150, 25);
		add(customercusAvailable);
		
		JLabel cusCleanSatus=new JLabel("Cleaning Satus");
		cusCleanSatus.setBounds(30, 230, 100, 20);
		add(cusCleanSatus);
		customerCleanSatus=new JTextField();
		customerCleanSatus.setBounds(200, 230, 150, 25);
		add(customerCleanSatus);
		
		
		check=new JButton("Check");
		check.setBackground(Color.black);
		check.setForeground(Color.WHITE);
		check.setBounds(30,300,100,30);
		check.addActionListener(this);
		add(check);
		
		
		update=new JButton("Update");
		update.setBackground(Color.black);
		update.setForeground(Color.WHITE);
		update.setBounds(150,300,100,30);
		update.addActionListener(this);
		add(update);
		
		
		
		back=new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.WHITE);
		back.setBounds(270,300,100,30);
		back.addActionListener(this);
		add(back);
		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));//Storing the image in the ImageIcon
		JLabel image=new JLabel(i1);//create it JLable and pass the ImageIcon to create the image
		image.setBounds(400, 50,500,300);//Setting the location and size
		add(image);
		
		
		setVisible(true);
		
		// Add a WindowListener to detect when this frame is closing
				setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
				addWindowListener(new WindowAdapter() {
		            @Override
		            public void windowClosing(WindowEvent e) {
		                // Create and show the second JFrame
		                new Reception();
		            }
		        });
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==check) {
			
			ResultSet rs= new CustomerDao().showOneCustomer(customerId.getSelectedItem());
			try {
				if(rs.next()) {
					customerRoom.setText(rs.getNString(6));
				}
			ResultSet rs2=getConnnection.connection().createStatement().executeQuery("select * from rooms where roomNo="+customerRoom.getText());
			while(rs2.next()) {
				customercusAvailable.setText(rs2.getString(2));
				customerCleanSatus.setText(rs2.getString(3));
			}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
				
		}else if(e.getSource()==back) {
			setVisible(false);
			new Reception();
		}else if(e.getSource()==update) {
			String room=customerRoom.getText();
			String available=customercusAvailable.getText();
			String status=customerCleanSatus.getText();
			String update="update rooms set roomAvailablity='"+available+"',roomStatus='"+status+"' where roomNo="+room;
			try {
				getConnnection.connection().createStatement().executeUpdate(update);
				setVisible(false);
				new Reception();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		new UpdateRoom();
	}

}
