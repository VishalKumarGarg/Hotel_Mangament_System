package com.Dashboard.reception.showAllRooms;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import com.Hotel_Mangament_System;
import com.Dashboard.Admin.addRooms.room.Dao.RoomDao;
import com.Dashboard.reception.Reception;

import net.proteanit.sql.DbUtils;

public class ShowAllRooms extends JFrame implements ActionListener{
	JTable table;
	JButton back;
	private static final long serialVersionUID = 1L;
	
	public ShowAllRooms() {
		super("Show Rooms");//Add title of the Page
		setResizable(false);//Setting of the resizing
		setBounds(300, 200, 1050, 600);//Setting the location and the size
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hotel_Mangament_System.class.getResource("/icons/eight.jpg")));//Add title_Image of the Page
		setLayout(null);//we use to do it null For making your own layout and not using the predefine layout
		getContentPane().setBackground(Color.WHITE);//setting the frame background color
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));//Storing the image in the ImageIcon
		Image i2=i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);//we used to set the image small or big with help of image method of getImage().getScaledInstance(WIDTH, HEIGHT, DO_NOTHING_ON_CLOSE)
		ImageIcon i3=new ImageIcon(i2);//Convert it Image to ImageIcon 
		JLabel image=new JLabel(i3);//create it JLable and pass the ImageIcon to create the image
		image.setBounds(500, 0,600,600);//Setting the location and size
		add(image);//Added to frame
		
		
		JLabel tRoomNo=new JLabel("Room No");
		tRoomNo.setBounds(10, 10, 100, 20);
		add(tRoomNo);
		
		JLabel tAvailable=new JLabel("Availibilty");
		tAvailable.setBounds(120, 10, 100, 20);
		add(tAvailable);
		
		JLabel tStatus=new JLabel("Status");
		tStatus.setBounds(230, 10, 100, 20);
		add(tStatus);
		
		JLabel tPrice=new JLabel("Price");
		tPrice.setBounds(330, 10, 100, 20);
		add(tPrice);
		
		JLabel tBedType=new JLabel("BedType");
		tBedType.setBounds(410, 10, 100, 20);
		add(tBedType);
		
		
		table =new JTable();
		table.setBounds(0, 40, 500, 400);
		add(table);
		table.setModel(DbUtils.resultSetToTableModel(new RoomDao().allShowRooms()));
		
		back=new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setBounds(200, 500, 120, 30);
		add(back);
		
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
		setVisible(false);
		new Reception();
		
	}
//	public static void main(String[] args) {
//		new ShowAllRooms();
//
//	}
	

}
