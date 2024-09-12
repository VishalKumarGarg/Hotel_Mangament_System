package com.Dashboard.reception.customerInfo;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import com.Hotel_Mangament_System;
import com.Dashboard.reception.Reception;
import com.Dashboard.reception.addCustomer.customer.customerDao.CustomerDao;

import net.proteanit.sql.DbUtils;

public class CustomerInfo extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	JTable table;
	JButton back;
	public CustomerInfo() {
		super("Show Manager");//Add title of the Page
		setResizable(false);//Setting of the resizing
		setBounds(300, 200, 1050, 600);//Setting the location and the size
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hotel_Mangament_System.class.getResource("/icons/eight.jpg")));//Add title_Image of the Page
		setLayout(null);//we use to do it null For making your own layout and not using the predefine layout
		getContentPane().setBackground(Color.WHITE);//setting the frame background color
		
		JLabel tName=new JLabel("ID");
		tName.setBounds(10, 10, 100, 20);
		add(tName);
		
		JLabel tAge=new JLabel("ID-Number");
		tAge.setBounds(150, 10, 100, 20);
		add(tAge);
		
		JLabel tGender=new JLabel("Name");
		tGender.setBounds(280, 10, 100, 20);
		add(tGender);
		
		JLabel tJob=new JLabel("Gender");
		tJob.setBounds(410, 10, 100, 20);
		add(tJob);
		
		JLabel tSalary=new JLabel("Country");
		tSalary.setBounds(530, 10, 100, 20);
		add(tSalary);
		
		JLabel tPhone=new JLabel("Customer-Room");
		tPhone.setBounds(650, 10, 100, 20);
		add(tPhone);
		
		JLabel tEmail=new JLabel("Checking Time");
		tEmail.setBounds(780, 10, 100, 20);
		add(tEmail);
		
		JLabel tAddhar=new JLabel("Deposit");
		tAddhar.setBounds(900, 10, 100, 20);
		add(tAddhar);
		
		
		table =new JTable();
		table.setBounds(0, 40, 1000, 400);
		add(table);
		table.setModel(DbUtils.resultSetToTableModel(new CustomerDao().showAllCustomer()));
		
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
//		new CustomerInfo();
//
//	}

}
