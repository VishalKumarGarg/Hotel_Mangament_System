package com.Dashboard.reception.showDepartment;

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
import com.Dashboard.reception.showDepartment.department.departmentDao.DepartmentDao;

import net.proteanit.sql.DbUtils;

public class showDepartment extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JButton back;
	JTable table;
	public showDepartment() {
		
	super("Show Departments");//Add title of the Page
	setResizable(false);//Setting of the resizing
	setBounds(300, 200, 1050, 600);//Setting the location and the size
	setIconImage(Toolkit.getDefaultToolkit().getImage(Hotel_Mangament_System.class.getResource("/icons/eight.jpg")));//Add title_Image of the Page
	setLayout(null);//we use to do it null For making your own layout and not using the predefine layout
	getContentPane().setBackground(Color.WHITE);//setting the frame background color
	

	
	JLabel tdepartmentName=new JLabel("Department Name");
	tdepartmentName.setBounds(90, 10, 150, 20);
	add(tdepartmentName);
	
	JLabel tDepartmentBudget=new JLabel("Department Budget");
	tDepartmentBudget.setBounds(560, 10, 150, 20);
	add(tDepartmentBudget);
	
	table =new JTable();
	table.setBounds(0, 40, 1000, 400);
	add(table);
	table.setModel(DbUtils.resultSetToTableModel(new DepartmentDao().showAllDepartments()));
	
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
//		new showDepartment();
//
//	}

}
