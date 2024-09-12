package com.Dashboard.reception.searchRoom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import com.Hotel_Mangament_System;
import com.Dashboard.Admin.addRooms.room.Dao.RoomDao;
import com.Dashboard.reception.Reception;

import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JTable table;
	JButton back,submit;
	JComboBox<String> roomBedType;
	JCheckBox available;
	public SearchRoom() {
		super("Search Room");//Add title of the Page
		setResizable(false);//Setting of the resizing
		setBounds(300, 200, 1050, 600);//Setting the location and the size
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hotel_Mangament_System.class.getResource("/icons/eight.jpg")));//Add title_Image of the Page
		setLayout(null);//we use to do it null For making your own layout and not using the predefine layout
		getContentPane().setBackground(Color.WHITE);//setting the frame background color
		
		JLabel tHeading=new JLabel("Search Room");
		tHeading.setFont(new Font("Tahoma",Font.PLAIN,20));
		tHeading.setBounds(400, 30, 200, 30);
		add(tHeading);
		
		JLabel rBedType=new JLabel("Bed Type");//Creating the Label
		rBedType.setFont(new Font("Tahoma",Font.PLAIN,16));//Setting the Style of text
		rBedType.setBounds(50, 100, 100, 20);//Setting the Location and size of Label
		add(rBedType);//Add the Label to Frame
		String str3[]= {"SingleBed","DoubleBed"};
		roomBedType =new JComboBox<>(str3);
		roomBedType.setBounds(150, 100, 150, 25);
		roomBedType.setBackground(Color.WHITE);
		add(roomBedType);
		
		available=new JCheckBox("Only display Available");
		available.setBounds(650, 100, 150, 25);
		available.setBackground(Color.WHITE);
		add(available);
		
		
		JLabel tRoomNo=new JLabel("Room No");
		tRoomNo.setBounds(50, 160, 100, 20);
		add(tRoomNo);
		
		JLabel tAvailable=new JLabel("Availibilty");
		tAvailable.setBounds(270, 160, 100, 20);
		add(tAvailable);
		
		JLabel tStatus=new JLabel("Status");
		tStatus.setBounds(450, 160, 100, 20);
		add(tStatus);
		
		JLabel tPrice=new JLabel("Price");
		tPrice.setBounds(670, 160, 100, 20);
		add(tPrice);
		
		JLabel tBedType=new JLabel("BedType");
		tBedType.setBounds(870, 160, 100, 20);
		add(tBedType);
		
		
		table =new JTable();
		table.setBounds(0, 200, 1000, 300);
		add(table);
		table.setModel(DbUtils.resultSetToTableModel(new RoomDao().allShowRooms()));
		
		submit=new JButton("submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		submit.setBounds(300, 520, 120, 30);
		add(submit);
		
		back=new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setBounds(500, 520, 120, 30);
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
		if(e.getSource()==submit) {
			String search;
			if(available.isSelected()) 
				search="select * from rooms where roomBedType='"+(String)roomBedType.getSelectedItem()+"' and roomAvailablity='Available'";
			else
				search="select * from rooms where roomBedType='"+(String)roomBedType.getSelectedItem()+"'";
			table.setModel(DbUtils.resultSetToTableModel(new RoomDao().searchRoom1(search)));
		}else if(e.getSource()==back) {
			setVisible(false);
			new Reception();
		}
		
	}
	
//	public static void main(String[] args) {
//		new SearchRoom();
//
//	}

}
