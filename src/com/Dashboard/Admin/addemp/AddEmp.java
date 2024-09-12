package com.Dashboard.Admin.addemp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.Hotel_Mangament_System;
import com.Dashboard.Admin.addemp.Employee.Emp;
import com.Dashboard.Admin.addemp.Employee.Dao.EmpDao;

public class AddEmp extends JFrame implements ActionListener{
	JTextField eName,eAge,eSalary,ePhone,eEmail,eAddhar;
	JRadioButton eMale,eFemale;
	ButtonGroup buttonGroup1 = new ButtonGroup();
	JComboBox<String> eJob;
	JButton submit,cancel;
	private static final long serialVersionUID = 1L;
	public AddEmp() {
		super("ADD-Employee");//Add title of the Page
		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hotel_Mangament_System.class.getResource("/icons/eight.jpg")));//Add title_Image of the Page
		setLayout(null);//we use to do it null For making your own layout and not using the predefine layout
		setBounds(350, 170, 900, 640);//Setting the location and Size
		getContentPane().setBackground(Color.WHITE);//setting the frame background color 
		
		JLabel heading=new JLabel("ADD EMPLOYEE");//Create a JLable for Headiing 
		heading.setBounds(60, 30, 350, 44);//Setting the location and Size
		heading.setFont(new Font("Tahona",Font.BOLD,44));//Setting the style and size
		add(heading);//Added to frame
		
		JLabel empName=new JLabel("Name");//Create a JLable for tell what textField is this
		empName.setBounds(60, 110, 120, 30);//Setting the location and Size
		empName.setFont(new Font("Tahona",Font.PLAIN,17));//Setting the Style
		add(empName);//Added to Frame
		eName=new JTextField();//Created the JTextField to take input
		eName.setBounds(200, 110, 200, 30);//Setting the location and Size
		add(eName);//added to frame
		
		JLabel empAge=new JLabel("Age");//Create a JLable for tell what textField is this
		empAge.setBounds(60, 160, 120, 30);//Setting the location and Size
		empAge.setFont(new Font("Tahona",Font.PLAIN,17));//Setting the Style
		add(empAge);//Added to Frame
		eAge=new JTextField();//Created the JTextField to take input
		eAge.setBounds(200, 160, 200, 30);//Setting the location and Size
		add(eAge);//added to frame

		JLabel empGender=new JLabel("Gender");//Create a JLable for tell what textField is this
		empGender.setBounds(60, 210, 120, 30);//Setting the location and Size
		empGender.setFont(new Font("Tahona",Font.PLAIN,17));//Setting the Style
		add(empGender);//Added to Frame
		
		eMale=new JRadioButton("Male");//Created JRadioButton
		eMale.setBounds(200, 210, 70, 30);//Setting the location and Size
		eMale.setFont(new Font("Tahoma",Font.PLAIN,14));//Setting the style
		eMale.setBackground(Color.WHITE);//Setting the background
		eMale.setText("Male");
		add(eMale);//Added to Frame
		buttonGroup1.add(eMale);
		
		eFemale=new JRadioButton("Female");//Created JRadioButton
		eFemale.setBounds(310, 210, 70, 30);//Setting the location and Size
		eFemale.setFont(new Font("Tahoma",Font.PLAIN,14));//Setting the style
		eFemale.setBackground(Color.WHITE);//Setting the background
		eFemale.setText("Female");
		add(eFemale);//Added to frame
		buttonGroup1.add(eFemale);
		
		JLabel empJob=new JLabel("Job");//Create a JLable for tell what textField is this
		empJob.setBounds(60, 260, 120, 30);//Setting the location and Size
		empJob.setFont(new Font("Tahona",Font.PLAIN,17));//Setting the Style
		add(empJob);//Added to Frame
		
		String str[]={null,"Front Desk Clerks","Porters","HouseKeeping","Kitchen Staff","Room Service"};//Creted the Array of String Which is pas in the ComboBox
		eJob =new JComboBox<>(str);//Created the ComboBox 
		eJob.setBounds(210,260 ,150 ,30 );//Set the Size and Loaction 
		eJob.setBackground(Color.WHITE);//Set the BackGround Color 
		add(eJob);//Added to Frame
		
		JLabel empSalary=new JLabel("Salary");//Create a JLable for tell what textField is this
		empSalary.setBounds(60, 310, 120, 30);//Setting the location
		empSalary.setFont(new Font("Tahona",Font.PLAIN,17));//Setting the Style
		add(empSalary);//Added to Frame
		eSalary=new JTextField();//Created the JTextField to take input
		eSalary.setBounds(200, 310, 200, 30);//Setting the location and Size
		add(eSalary);//added to frame
		
		JLabel empPhone=new JLabel("Phone-No");//Create a JLable for tell what textField is this
		empPhone.setBounds(60, 360, 120, 30);//Setting the location
		empPhone.setFont(new Font("Tahona",Font.PLAIN,17));//Setting the Style
		add(empPhone);//Added to Frame
		ePhone=new JTextField();//Created the JTextField to take input
		ePhone.setBounds(200, 360, 200, 30);//Setting the location and Size
		add(ePhone);//added to frame
		
		JLabel empEmail=new JLabel("Email");//Create a JLable for tell what textField is this
		empEmail.setBounds(60, 410, 120, 30);//Setting the location
		empEmail.setFont(new Font("Tahona",Font.PLAIN,17));//Setting the Style
		add(empEmail);//Added to Frame
		eEmail=new JTextField();//Created the JTextField to take input
		eEmail.setBounds(200, 410, 200, 30);//Setting the location and Size
		add(eEmail);//added to frame
		
		JLabel empAddhar=new JLabel("AADHAAR");//Create a JLable for tell what textField is this
		empAddhar.setBounds(60, 460, 120, 30);//Setting the location
		empAddhar.setFont(new Font("Tahona",Font.PLAIN,17));//Setting the Style
		add(empAddhar);//Added to Frame
		eAddhar=new JTextField();//Created the JTextField to take input
		eAddhar.setBounds(200, 460, 200, 30);//Setting the location and Size
		add(eAddhar);//added to frame
		
		submit=new JButton("SUBMIT");//Created the JButton
		submit.setBackground(Color.black);//Setting the background
		submit.setForeground(Color.WHITE);//Setting the text color
		submit.setFont(new Font("Tahona",Font.BOLD,15));//Setting the text style
		submit.setBounds(120, 510, 180, 50);//Setting the Location and the size
		submit.addActionListener(this);
		add(submit);//Added to Frame
		
		cancel=new JButton("CANCEL");//Created the JButton
		cancel.setBackground(Color.black);//Setting the background
		cancel.setForeground(Color.WHITE);//Setting the text color
		cancel.setFont(new Font("Tahona",Font.BOLD,15));//Setting the text style
		cancel.setBounds(320, 510, 180, 50);//Setting the Location and the size
		cancel.addActionListener(this);
		add(cancel);//Added to Frame
		
		ImageIcon i1= new ImageIcon(AddEmp.class.getResource("/icons/tenth.jpg"));//place the image inside the Object of ImageIcon
		Image i2=i1.getImage().getScaledInstance(480, 480, Image.SCALE_DEFAULT);//we used to set the image small or big with help of image method of getImage().getScaledInstance(WIDTH, HEIGHT, DO_NOTHING_ON_CLOSE)
		ImageIcon i3=new ImageIcon(i2);//Convert it Image to ImageIcon
		JLabel image= new JLabel(i3);//create it JLable and pass the ImageIcon to create the image
		image.setBounds(400, 60, 480, 400);//Setting to background
		add(image);
		
		// Start a new thread to change the text color
        new Thread(() -> {
            while (true) {
                try {
                    heading.setForeground(Color.WHITE);
                    Thread.sleep(500);
                    heading.setForeground(Color.BLACK);
                    Thread.sleep(500);
                    heading.setForeground(Color.BLUE);
                    Thread.sleep(500);
                    heading.setForeground(Color.CYAN);
                    Thread.sleep(500);
                    heading.setForeground(Color.MAGENTA);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			String name=eName.getText().trim();
			int age=tellAge();
			String gender=tellGender();
			String job=(String)eJob.getSelectedItem();
			double salary=tellSalary();
			String phone=ePhone.getText().trim();
			String email=eEmail.getText().trim();
			String addhar=eAddhar.getText().trim();
			
			if(name.isEmpty()||eAge.getText().trim().isEmpty()||gender==null||job==null||eSalary.getText().trim().isEmpty()||phone.isEmpty()||email.isEmpty()||addhar.isEmpty()) {
				if(name.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Enter the Name");
				}else if(eAge.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Enter the Age");
				}else if(gender==null) {
					JOptionPane.showMessageDialog(this, "Enter the Gender");
				}else if(job==null) {
					JOptionPane.showMessageDialog(this, "Enter the Job");
				}else if(eSalary.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(this, "Enter the Salary");
				}else if(phone.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Enter the Phone");
				}else if(email.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Enter the Email");
				}else {
					JOptionPane.showMessageDialog(this, "Enter the Aadhaar");
				}
			}else {
				Emp emp1=new Emp(name, age, gender, job, salary, phone, email, addhar);//send the empolyee details to emp to parameteried constructor
				EmpDao save1=new EmpDao();
				int done=save1.save(emp1);
				System.out.println("\n "+done);
				if(done==1) {
					JOptionPane.showMessageDialog(this, "Successfully save");
					setVisible(false);
				}else 
					JOptionPane.showMessageDialog(this, "Not save");
			}
		}else if(e.getSource()==cancel)
			setVisible(false);
		
	}
	String tellGender(){
		if(eMale.isSelected()) {
			return "Male";
		}
		else if(eFemale.isSelected()) 
			return "Female";
		else 
			return null;
	}
	int tellAge() {
		if(eAge.getText().trim().isEmpty())
			return 0;
		else
			return Integer.parseInt(eAge.getText().trim());
	}
	double tellSalary() {
		if(eSalary.getText().trim().isEmpty())
			return 0;
		else
			return Double.parseDouble(eSalary.getText().trim());
	}
//	public static void main(String[] args) {
//		new AddEmp();
//
//	}
	

}
//eName,eAge,eMale,eFemale,eJob,eSalary,ePhone,eEmail