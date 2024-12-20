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

public class OwnerUpdateProfileFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel,ownerTypeLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, genderTF, ageTF, addressTF, OwnerTypeTF;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JPanel panel;
	private User u;
	private Owner owner;
	
	
	
	public OwnerUpdateProfileFrame(User u)
	{
		super("Owner update profile Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);

		Color c1 = new Color(0, 153, 153);

		JLabel background;
		ImageIcon img= new ImageIcon("frames/Picture/Operation.png");
		background=new JLabel("",img,JLabel.LEFT);
		background.setBounds(0,0,1000,650);
		panel.add(background);
		
		//getting Owner's info in Owner type object ref.
		OwnerRepo arp=new OwnerRepo();
		this.owner=arp.searchOwnerByUserId(u.getUserId());
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,30);
		background.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(120,50,100,30);
		this.userTF.setText(owner.getUserId());
		this.userTF.setEditable(false);
		background.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(50,100,60,30);
		background.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,100,100,30);
		this.nameTF.setText(owner.getName());
		this.nameTF.setEditable(false);
		background.add(nameTF);
		
		this.emailLabel=new JLabel("email:");
		this.emailLabel.setBounds(50,150,60,30);
		background.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(120,150,150,30);
		this.emailTF.setText(owner.getEmail());
		background.add(emailTF);
		
		this.phoneNoLabel=new JLabel("phone No:");
		this.phoneNoLabel.setBounds(50,200,60,30);
		background.add(phoneNoLabel);
		
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(120,200,100,30);
		this.phoneNoTF.setText(owner.getPhoneNo());
		background.add(phoneNoTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(50,250,60,30);
		background.add(genderLabel);
		
		this.genderTF=new JTextField();
		this.genderTF.setBounds(120,250,100,30);
		this.genderTF.setText(owner.getGender());
		this.genderTF.setEditable(false);
		background.add(genderTF);
		
		
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(50,300,60,30);
		background.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(120,300,100,30);
		this.ageTF.setText(String.valueOf(owner.getAge()));
		this.ageTF.setEditable(false);
		background.add(ageTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(50,350,60,30);
		background.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(120,350,100,30);
		this.addressTF.setText(owner.getAddress());
		background.add(addressTF);
		
		
		this.ownerTypeLabel=new JLabel("Owner Type:");
		this.ownerTypeLabel.setBounds(50,400,100,30);
		background.add(ownerTypeLabel);
		
		this.OwnerTypeTF=new JTextField();
		this.OwnerTypeTF.setBounds(160,400,100,30);
		this.OwnerTypeTF.setText(owner.getOwnerType());
		this.OwnerTypeTF.setEditable(false);
		background.add(OwnerTypeTF);
		
		
		this.updateBtn=new JButton("update");
		this.updateBtn.setBounds(50,450,120,30);
		this.updateBtn.setBackground(c1);
		this.updateBtn.addActionListener(this);
		background.add(updateBtn);
		
		
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(190,450,100,30);
		this.backBtn.setBackground(c1);
		this.backBtn.addActionListener(this);
		background.add(backBtn);
		
		
		
		this.add(panel);
		
		this.u=u;
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		
		if(command.equals(updateBtn.getText()))
		{
			//validating every field has data or not
			if((!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()))
			{
				owner.setEmail(emailTF.getText());
				owner.setPhoneNo(phoneNoTF.getText());
				owner.setAddress(addressTF.getText());
				//doing update operation by OwnerRepo's object arp.
				OwnerRepo arp=new OwnerRepo();
				arp.updateOwner(owner);
				//updation confirmation message.
				JOptionPane.showMessageDialog(this,"Owner updated Successfully");
		
			}
			else
			{
				//if any of the field is empty, this message will be shown.
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
		}
		
		
		if(command.equals(backBtn.getText()))
		{
			//back button will take you to Owner home page.
			OwnerHomeFrame ohf=new OwnerHomeFrame(this.u);
			this.setVisible(false);
			ohf.setVisible(true);
		}
	}
	
}