package com.Dashboard.Admin.addRooms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.Hotel_Mangament_System;
import com.Dashboard.Admin.addRooms.room.Room;
import com.Dashboard.Admin.addRooms.room.Dao.RoomDao;

public class addRoom extends JFrame implements ActionListener{
	JTextField roomNo,roomPrice;
	JComboBox<String> roomAvailable,roomStatus,roomBedType;
	JButton Submit,Cancel;
	
	private static final long serialVersionUID = 1L;
	public addRoom() {
		super("ADD-ROOMS");//Add title of the Page
		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);//Setting the default to close the frame
		setResizable(false);//Setting of the resizing
		setBounds(330, 170, 940, 500);//Setting the location and the size
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hotel_Mangament_System.class.getResource("/icons/eight.jpg")));//Add title_Image of the Page
		setLayout(null);//we use to do it null For making your own layout and not using the predefine layout
		getContentPane().setBackground(Color.WHITE);//setting the frame background color 
		
		JLabel heading=new JLabel("Add Rooms");//Creating the Label
		heading.setFont(new Font("Tahoma",Font.BOLD,34));//Setting the Style of text
		heading.setBounds(100, 15, 200, 36);//Setting the Location and size of Label
		add(heading);//Add the Label to Frame
		
		JLabel rNo=new JLabel("Room No.");//Creating the Label
		rNo.setFont(new Font("Tahoma",Font.PLAIN,16));//Setting the Style of text
		rNo.setBounds(60, 100, 120, 30);//Setting the Location and size of Label
		add(rNo);//Add the Label to Frame
		roomNo=new JTextField();//created the textField to take input
		roomNo.setBounds(200, 100, 150, 30);//Setting the Location and size of Label
		add(roomNo);//Add the JTextField to Frame
		
		JLabel rAvailable=new JLabel("Room Availablity");//Creating the Label
		rAvailable.setFont(new Font("Tahoma",Font.PLAIN,16));//Setting the Style of text
		rAvailable.setBounds(60, 150, 120, 30);//Setting the Location and size of Label
		add(rAvailable);//Add the Label to Frame
		String str1[]= {"","Available","Occupied"};
		roomAvailable =new JComboBox<>(str1);
		roomAvailable.setBounds(200, 150, 150, 30);
		roomAvailable.setBackground(Color.WHITE);
		add(roomAvailable);
		
		JLabel rStatus=new JLabel("Room Status");//Creating the Label
		rStatus.setFont(new Font("Tahoma",Font.PLAIN,16));//Setting the Style of text
		rStatus.setBounds(60, 200, 120, 30);//Setting the Location and size of Label
		add(rStatus);//Add the Label to Frame
		String str2[]= {"","Clean","Dirty"};
		roomStatus =new JComboBox<>(str2);
		roomStatus.setBounds(200, 200, 150, 30);
		roomStatus.setBackground(Color.WHITE);
		add(roomStatus);
		
		JLabel rPrice=new JLabel("Room Price.");//Creating the Label
		rPrice.setFont(new Font("Tahoma",Font.PLAIN,16));//Setting the Style of text
		rPrice.setBounds(60, 250, 120, 30);//Setting the Location and size of Label
		add(rPrice);//Add the Label to Frame
		roomPrice=new JTextField();//created the textField to take input
		roomPrice.setBounds(200, 250, 150, 30);//Setting the Location and size of Label
		add(roomPrice);//Add the JTextField to Frame
		
		JLabel rBedType=new JLabel("Bed Type");//Creating the Label
		rBedType.setFont(new Font("Tahoma",Font.PLAIN,16));//Setting the Style of text
		rBedType.setBounds(60, 300, 120, 30);//Setting the Location and size of Label
		add(rBedType);//Add the Label to Frame
		String str3[]= {"","SingleBed","DoubleBed"};
		roomBedType =new JComboBox<>(str3);
		roomBedType.setBounds(200, 300, 150, 30);
		roomBedType.setBackground(Color.WHITE);
		add(roomBedType);
		
		Submit =new JButton("Submit");
		Submit.setBackground(Color.black);
		Submit.setForeground(Color.WHITE);
		Submit.setFont(new Font("Tahoma",Font.BOLD,16));
		Submit.setBounds(100, 380, 100, 40);
		Submit.addActionListener(this);
		add(Submit);
		
		Cancel =new JButton("Cancel");
		Cancel.setBackground(Color.black);
		Cancel.setForeground(Color.WHITE);
		Cancel.setFont(new Font("Tahoma",Font.BOLD,16));
		Cancel.setBounds(230, 380, 100, 40);
		Cancel.addActionListener(this);
		add(Cancel);
		
		
		ImageIcon i1= new ImageIcon(addRoom.class.getResource("/icons/twelve.jpg"));//place the image inside the Object of ImageIcon
		JLabel image= new JLabel(i1);//create it JLable and pass the ImageIcon to create the image
		image.setBounds(400, 60, 500, 300);//Setting to background
		add(image);
		setVisible(true);//Setting the Visible on of frame
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Submit) {
			if(roomNo.getText().trim().isEmpty()||roomAvailable.getSelectedItem()==null||roomStatus.getSelectedItem()==null||roomPrice.getText().trim().isEmpty()||roomBedType.getSelectedItem()==null) {
				if(roomNo.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Enter the Room Number");
				}else if(roomAvailable.getSelectedItem()==null) {
					JOptionPane.showMessageDialog(this, "Enter the Room Availablity");
				}else if(roomStatus.getSelectedItem()==null) {
					JOptionPane.showMessageDialog(this, "Enter the Room Status");
				}else if(roomPrice.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Enter the Room Price");
				}else {
					JOptionPane.showMessageDialog(this, "Enter the Room Bed Type");
				}	
			}else {
				Room r1=new Room(Integer.parseInt(roomNo.getText()),(String) roomAvailable.getSelectedItem(),(String) roomStatus.getSelectedItem(),Double.parseDouble(roomPrice.getText()),(String) roomBedType.getSelectedItem());
				RoomDao save=new RoomDao();
				int done=save.saveRoom(r1);
				System.out.println("\n "+done);
				if(done==1) {
					JOptionPane.showMessageDialog(this, "Successfully save");
					setVisible(false);
				}else 
					JOptionPane.showMessageDialog(this, "Not save");
			}
		}else if(e.getSource()==Cancel){
			setVisible(false);
		}
		
	}
	
//	public static void main(String[] args) {
//		new addRoom();
//	}

}
