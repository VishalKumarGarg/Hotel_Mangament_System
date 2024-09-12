package com.Dashboard.reception.checkOut;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.Hotel_Mangament_System;
import com.Dashboard.Admin.addRooms.room.Dao.RoomDao;
import com.Dashboard.Admin.addemp.AddEmp;
import com.Dashboard.reception.Reception;
import com.Dashboard.reception.addCustomer.customer.customerDao.CustomerDao;

public class CheckOut extends JFrame implements ActionListener{
	Choice customerId;
	JLabel customerRoom,customerCheckIn,customerCheckOut;
	JButton back,checkout;
	private static final long serialVersionUID = 1L;
	public CheckOut() {
		super("Check Out");//Add title of the Page
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hotel_Mangament_System.class.getResource("/icons/eight.jpg")));//Add title_Image of the Page
		setBounds(300, 200, 800, 400);
		
		JLabel text=new JLabel("Check Out");
		text.setBounds(100, 20,100, 30);
		text.setForeground(Color.blue);
		text.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(text);
		
		
		
		JLabel cusRoom=new JLabel("Room No");
		cusRoom.setBounds(30, 120, 100, 20);
		add(cusRoom);
		customerRoom=new JLabel("");
		customerRoom.setBounds(200, 120, 150, 25);
		add(customerRoom);
		
		JLabel cusCheckIn=new JLabel("Check In");
		cusCheckIn.setBounds(30, 160, 100, 20);
		add(cusCheckIn);
		customerCheckIn=new JLabel("");
		customerCheckIn.setBounds(200, 160, 150, 25);
		add(customerCheckIn);
		
		JLabel cusCheckOut=new JLabel("Check Out");
		cusCheckOut.setBounds(30, 200, 100, 20);
		add(cusCheckOut);
		customerCheckOut=new JLabel(""+new Date());
		customerCheckOut.setBounds(200, 200, 150, 25);
		add(customerCheckOut);
		
		JLabel cusId=new JLabel("Customer ID");
		cusId.setBounds(30, 80, 100, 20);
		add(cusId);
		customerId=new Choice();
		customerId.setBounds(200, 80, 150, 25);
		add(customerId);
		try {
			ResultSet rs=new CustomerDao().showAllCustomer();
			while(rs.next()) {
				customerId.add(rs.getString("CustomerIdNo"));
				customerRoom.setText(rs.getString("CustomerRoomNo"));
				customerCheckIn.setText(rs.getString("CustomerCheckingTime"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		checkout=new JButton("CheckOut");
		checkout.setBackground(Color.black);
		checkout.setForeground(Color.WHITE);
		checkout.setBounds(30, 230, 120, 30);
		checkout.addActionListener(this);
		add(checkout);
		
		back=new JButton("back");
		back.setBackground(Color.black);
		back.setForeground(Color.WHITE);
		back.setBounds(180, 230, 120, 30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1= new ImageIcon(AddEmp.class.getResource("/icons/sixth.jpg"));//place the image inside the Object of ImageIcon
		Image i2=i1.getImage().getScaledInstance(450, 250, Image.SCALE_DEFAULT);//we used to set the image small or big with help of image method of getImage().getScaledInstance(WIDTH, HEIGHT, DO_NOTHING_ON_CLOSE)
		ImageIcon i3=new ImageIcon(i2);//Convert it Image to ImageIcon
		JLabel image= new JLabel(i3);//create it JLable and pass the ImageIcon to create the image
		image.setBounds(350, 50, 400, 250);//Setting to background
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
		if(e.getSource()==checkout) {
			if(customerId.getSelectedItem()==null) {
				JOptionPane.showMessageDialog(this, "No Customer");
			}else {
				new CustomerDao().deleteCustomer(customerId.getSelectedItem());
				new RoomDao().update1room(Integer.parseInt(customerRoom.getText()));
				setVisible(false);
				new Reception();
			}
		}else if(e.getSource()==back) {
			setVisible(false);
			new Reception();
			
		}
		
	}
//	public static void main(String[] args) {
//		new CheckOut();
//	}
	

}
