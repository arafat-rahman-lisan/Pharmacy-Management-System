package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;  
import java.awt.*;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.imageio.*;
import entities.*;
import repositories.*;
import java.awt.image.BufferedImage;


public class OwnerHomeFrame extends JFrame implements ActionListener
{
	
	private JButton ownerBtn, customerBtn, employeeBtn,orderList,offermedicineListBtn, paymentBtn, profileBtn, passBtn,orderLineBtn,backBtn;
	private JPanel panel;
	private User u;
	private Font font;
	
	public OwnerHomeFrame(User u)
	{
		
		super("Owner Home Frame");
		this.setSize(800,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.font=new Font("Agency FB", Font.BOLD, 20);
		
		Color c1 = new Color(165, 0, 0);   //red
        Color c2 = new Color(178, 255, 102);    //green
        Color c3 = new Color(51, 51, 255);  //blue
		
		JLabel background;
		ImageIcon img= new ImageIcon("frames/Picture/Entry.png");
		background=new JLabel("",img,JLabel.LEFT);
		background.setBounds(0,0,800,400);
		panel.add(background);
		
		
		this.ownerBtn=new JButton("Owner operation");
		this.ownerBtn.setForeground(Color.BLACK);
		this.ownerBtn.setBackground(c2);
		this.ownerBtn.setBounds(50,50,150,30);
		this.ownerBtn.addActionListener(this);
		background.add(ownerBtn);
		
		this.customerBtn=new JButton("Customer operation");
		this.customerBtn.setForeground(Color.BLACK);
		this.customerBtn.setBackground(c2);
		this.customerBtn.setBounds(210,50,150,30);
		this.customerBtn.addActionListener(this);
		background.add(customerBtn);
		
		this.employeeBtn=new JButton("Employee operation");
		this.employeeBtn.setForeground(Color.BLACK);
		this.employeeBtn.setBackground(c2);
		this.employeeBtn.setBounds(370,50,150,30);
		this.employeeBtn.addActionListener(this);
		background.add(employeeBtn);
		
		this.orderList=new JButton("Order List");
		this.orderList.setForeground(Color.BLACK);
		this.orderList.setBackground(c2);
		this.orderList.setBounds(95,100,150,30);
		this.orderList.addActionListener(this);
		background.add(orderList);
		
		this.offermedicineListBtn=new JButton("Medicine List");
		this.offermedicineListBtn.setForeground(Color.BLACK);
		this.offermedicineListBtn.setBackground(c2);
		this.offermedicineListBtn.setBounds(300,100,150,30);
		this.offermedicineListBtn.addActionListener(this);
		background.add(offermedicineListBtn);
	
		
		this.paymentBtn=new JButton("All Payment");
		this.paymentBtn.setForeground(Color.BLACK);
		this.paymentBtn.setBackground(c2);
		this.paymentBtn.setBounds(115,150,150,30);
		this.paymentBtn.addActionListener(this);
		background.add(paymentBtn);
		
		this.profileBtn=new JButton("Update Profile");
		this.profileBtn.setForeground(Color.BLACK);
		this.profileBtn.setBackground(c2);
		this.profileBtn.setBounds(275,150,150,30);
		this.profileBtn.addActionListener(this);
		background.add(profileBtn);
		
		this.passBtn=new JButton("Update Password");
		this.passBtn.setForeground(Color.BLACK);
		this.passBtn.setBackground(c3);
		this.passBtn.setBounds(190,300,180,30);
		this.passBtn.addActionListener(this);
		background.add(passBtn);
		
		this.orderLineBtn=new JButton("OrderLine List");
		this.orderLineBtn.setForeground(Color.BLACK);
		this.orderLineBtn.setBackground(c2);
		this.orderLineBtn.setBounds(193,200,160,27);
		this.orderLineBtn.addActionListener(this);
		background.add(orderLineBtn);
		
		this.backBtn=new JButton("<-");
		this.backBtn.setForeground(Color.WHITE);
		this.backBtn.setBackground(c3);
		this.backBtn.setBounds(0,0,40,20);
        this.backBtn.addActionListener(this);
		background.add(backBtn);

		
		
		
		
		this.add(panel);
		this.u=u;
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(ownerBtn.getText()))
		{
			OwnerOperationFrame f=new OwnerOperationFrame(this.u);
			this.setVisible(false);
			f.setVisible(true);
		}
		
		if(command.equals(paymentBtn.getText()))
		{
			OwnerAllPayment Oof=new OwnerAllPayment(this.u);
			this.setVisible(false);
			Oof.setVisible(true);
		}
		
		if(command.equals(profileBtn.getText()))
		{
			OwnerUpdateProfileFrame Oof=new OwnerUpdateProfileFrame(this.u);
			this.setVisible(false);
			Oof.setVisible(true);
		}
		
		if(command.equals(passBtn.getText()))
		{
			OwnerUpdatePasswordFrame Oof=new OwnerUpdatePasswordFrame(this.u);
			this.setVisible(false);
			Oof.setVisible(true);
		}
		if(command.equals(offermedicineListBtn.getText()))
		{
			MedicineListFrame mlf=new MedicineListFrame(this.u);
			this.setVisible(false);
			mlf.setVisible(true);
		}
		if(command.equals(orderList.getText()))
		{
			OrderListFrame olf=new OrderListFrame(this.u);
			this.setVisible(false);
			olf.setVisible(true);
		}
		
	    if(command.equals(orderLineBtn.getText()))
		{
			OrderLineListFrame ollf=new OrderLineListFrame(this.u);
			this.setVisible(false);
			ollf.setVisible(true);
		}    
		if(command.equals(employeeBtn.getText()))
		{
			EmployeeOperationFrame eof=new EmployeeOperationFrame(this.u);
			this.setVisible(false);
			eof.setVisible(true);
		}
		if(command.equals(customerBtn.getText()))
		{
			CustomerOperationFrame cof=new CustomerOperationFrame(this.u);
			this.setVisible(false);
			cof.setVisible(true);
		}

		if(command.equals(backBtn.getText()))
		{
			//back button will take you to Login page.
			LoginFrame ldf=new LoginFrame();
			this.setVisible(false);
			ldf.setVisible(true);
		}
		
		
		
	}
	
}
