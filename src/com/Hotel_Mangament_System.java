package com;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.Login.login;

public class Hotel_Mangament_System extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	public Hotel_Mangament_System() {
		super("Home Page");//Add title of the Page
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hotel_Mangament_System.class.getResource("/icons/eight.jpg")));//Add title_Image of the Page
		
//		setSize(1366, 565);//It help to set the size
//		setLocation(100, 100);//It help to set the Location setLocation(left_from_Screen, Top_of_Screen);
//		If you want to setSize and SetLocation with on method you can use the setBounds(Loc of x, Loc of y, length, breadth);
		setBounds(100,100,1366,665);
		setLayout(null);//we use to do it null For making your own layout and not using the predefine layout
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/hotelBack.jpg"));//place the image inside the Object of ImageIcon
		Image i2=i1.getImage().getScaledInstance(1366, 665, Image.SCALE_DEFAULT);//we used to set the image small or big with help of image method of getImage().getScaledInstance(WIDTH, HEIGHT, DO_NOTHING_ON_CLOSE)
		ImageIcon i3=new ImageIcon(i2);//Convert it Image to ImageIcon
		//We can can't put the image directy so we need jLabel
		JLabel image=new JLabel(i3);//we place the image inside the JLable
		image.setBounds(0, 0, 1366,665);//image.setBounds(Loc of x, Loc of y, length, breadth); and it the combnitation of setSize() and setLocation()
		add(image);//Here we have added the JLable to Frame
		JLabel text1= new JLabel("Hotel Mangement System");//Add text using the JLable
		text1.setBounds(50, 100, 750, 85);//Set postion of text1
		text1.setForeground(Color.decode("#FFD700"));//Set the color of text
		text1.setFont(new Font("serif",Font.PLAIN,70));//It is used to set the Style of text which written inside the JLable systanx:- text1.setFont(new Font("Font Style Catgory",(Plain,Blod,Italic,etc),size of text)) 
		// Custom painting to add a shadow effect
        text1.setUI(new javax.swing.plaf.basic.BasicLabelUI() {
            @Override
            protected void paintEnabledText(JLabel l, Graphics g, String s, int textX, int textY) {
                // Text shadow
                g.setColor(new Color(51, 51, 51)); // RGB for Deep Charcoal
                g.drawString(s, textX + 2, textY + 2); // Shadow position
                super.paintEnabledText(l, g, s, textX, textY);
            }
        });
		image.add(text1);//We have put it on image(JLable) because their we are Placing One JLable on Another
		
		
		
		JButton next= new JButton("Start");//Created the JButton 
		next.setBounds(1150, 525, 130, 50);//Set postion of text1
		next.setBackground(Color.decode("#191970"));//Set BackGround of button
		next.setForeground(Color.decode("#E5E4E2"));//Set text color 
		next.setFont(new Font("serif",Font.BOLD,28));//Set the text of Button 
		next.addActionListener(this);//Used to make tell the button is press
		image.add(next);//Add it on Lable 
		setVisible(true);//It is used to set the visiblity
		// Adding hover effect
        next.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                next.setBackground(Color.decode("#000080")); // Darker shade for hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                next.setBackground(Color.decode("#191970")); // Back to Celestial Blue
            }
        });
		
		
		//We have make a while loop true which will not stop.
		while(true) {
			try {
				text1.setVisible(false);//it will hide the JLable 
				Thread.sleep(500);//It will stop for 0.5 sec for execute next opreation
				text1.setVisible(true);//It will show the JLable 
				Thread.sleep(500);//It will stop for 0.5 sec for execute next opreation
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new login();
	}
	public static void main(String[] args) {
		new Hotel_Mangament_System();
	}
}