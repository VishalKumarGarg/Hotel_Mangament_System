package com.Dashboard.reception.pickUp;

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
import com.Dashboard.Admin.addDriver.driver.dao.DriverDao;
import com.Dashboard.reception.Reception;

import net.proteanit.sql.DbUtils;

public class PickUp extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table;
	JButton back,submit;
	JComboBox<String> roomBedType;
	JCheckBox available;
	public PickUp() {
		super("PickUp");//Add title of the Page
		setResizable(false);//Setting of the resizing
		setBounds(300, 200, 1050, 600);//Setting the location and the size
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hotel_Mangament_System.class.getResource("/icons/eight.jpg")));//Add title_Image of the Page
		setLayout(null);//we use to do it null For making your own layout and not using the predefine layout
		getContentPane().setBackground(Color.WHITE);//setting the frame background color
		
		JLabel tHeading=new JLabel("PickUp");
		tHeading.setFont(new Font("Tahoma",Font.PLAIN,20));
		tHeading.setBounds(400, 20, 200, 30);
		add(tHeading);
		
		
		JLabel tName=new JLabel("Name");
		tName.setBounds(30, 60, 100, 20);
		add(tName);
		
		JLabel tAge=new JLabel("Age");
		tAge.setBounds(200, 60, 100, 20);
		add(tAge);
		
		JLabel tStatus=new JLabel("Gender");
		tStatus.setBounds(330, 60, 100, 20);
		add(tStatus);
		
		JLabel tPrice=new JLabel("Company");
		tPrice.setBounds(460, 60, 100, 20);
		add(tPrice);
		
		JLabel tBedType=new JLabel("Brand");
		tBedType.setBounds(630, 60, 100, 20);
		add(tBedType);
		
		JLabel t2=new JLabel("Avalilability");
		t2.setBounds(740, 60, 100, 20);
		add(t2);
		
		JLabel t3=new JLabel("Location");
		t3.setBounds(890, 60, 100, 20);
		add(t3);
		
		
		table =new JTable();
		table.setBounds(0, 100, 1000, 300);
		add(table);
		table.setModel(DbUtils.resultSetToTableModel(new DriverDao().shwoDrivers()));
		
		
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
		 
			setVisible(false);
			new Reception();
		
		
	}
	
//	public static void main(String[] args) {
//		new PickUp();
//
//	}

}
