package com.Dashboard.reception.updateCheck;

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
import com.Dashboard.Admin.addRooms.room.Dao.RoomDao;
import com.Dashboard.reception.Reception;
import com.Dashboard.reception.addCustomer.customer.customerDao.CustomerDao;

public class UpdateCheck extends JFrame implements ActionListener{
	Choice customerId;
	JTextField customerRoom,customerName,customerCheckIn,customerPaid,customerPending;
	JButton check,back;
	private static final long serialVersionUID = 1L;
	
	public UpdateCheck() {
		super("Reception");//Add title of the Page
		setResizable(false);//Setting of the resizing
		setBounds(300, 200, 980,500);//Setting the location and the size
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hotel_Mangament_System.class.getResource("/icons/eight.jpg")));//Add title_Image of the Page
		setLayout(null);//we use to do it null For making your own layout and not using the predefine layout
		getContentPane().setBackground(Color.WHITE);//setting the frame background color 
		
		JLabel text=new JLabel("Update Status");
		text.setFont(new Font("Tahoma",Font.PLAIN,20));
		text.setBounds(90, 20, 200, 30);
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
		cusRoom.setBounds(30, 120, 100, 20);
		add(cusRoom);
		customerRoom=new JTextField();
		customerRoom.setBounds(200, 120, 150, 25);
		add(customerRoom);
		
		JLabel cusName=new JLabel("Name");
		cusName.setBounds(30, 160, 100, 20);
		add(cusName);
		customerName=new JTextField();
		customerName.setBounds(200, 160, 150, 25);
		add(customerName);
		
		JLabel cusCheckIn=new JLabel("CheckIn");
		cusCheckIn.setBounds(30, 200, 100, 20);
		add(cusCheckIn);
		customerCheckIn=new JTextField();
		customerCheckIn.setBounds(200, 200, 150, 25);
		add(customerCheckIn);
		
		JLabel cusPaid=new JLabel("Amount Paid");
		cusPaid.setBounds(30, 240, 100, 20);
		add(cusPaid);
		customerPaid=new JTextField();
		customerPaid.setBounds(200, 240, 150, 25);
		add(customerPaid);
		
		JLabel cusPending=new JLabel("Amount Pending");
		cusPending.setBounds(30, 280, 100, 20);
		add(cusPending);
		customerPending=new JTextField();
		customerPending.setBounds(200, 280, 150, 25);
		add(customerPending);
		
		check=new JButton("Check");
		check.setBackground(Color.black);
		check.setForeground(Color.WHITE);
		check.setBounds(30,340,100,30);
		check.addActionListener(this);
		add(check);
		
		
		
		back=new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.WHITE);
		back.setBounds(150,340,100,30);
		back.addActionListener(this);
		add(back);

		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));//Storing the image in the ImageIcon
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
					ResultSet rs1=new RoomDao().searchRoomId(Double.parseDouble(rs.getString(6)));
					customerRoom.setText(rs.getString(6));
					customerName.setText(rs.getString(3));
					customerCheckIn.setText(rs.getString(7));
					customerPaid.setText(rs.getString(8));
					double pendingPay=0;
					if(rs1.next())
						pendingPay=Double.parseDouble(rs1.getString(4))- Double.parseDouble(rs.getString(8));
					customerPending.setText(""+pendingPay);
				}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
		}else if(e.getSource()==back) {
			setVisible(false);
			new Reception();
		}
	}
//	public static void main(String[] args) {
//		new UpdateCheck();
//
//	}
	

}
