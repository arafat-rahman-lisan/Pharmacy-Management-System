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

public class EmployeeUpdatePasswordFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,currentPassLabel, newPassLabel;
	private JTextField userTF;
	private JPasswordField currentPassPF,newPassPF;
	private JButton updateBtn, backBtn;
	private JPanel panel;
	private User u;
	
	
	
	public EmployeeUpdatePasswordFrame(User u)
	{
		super("Employee Update Password Segment");
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
    
		
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,30);
		background.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(120,50,100,30);
		this.userTF.setText(u.getUserId());
		this.userTF.setEditable(false);
		background.add(userTF);
		
		this.currentPassLabel=new JLabel("Current Password:");
		this.currentPassLabel.setBounds(50,100,150,30);
		background.add(currentPassLabel);
		
		this.currentPassPF=new JPasswordField();
		this.currentPassPF.setBounds(200,100,100,30);
		background.add(currentPassPF);
		
		this.newPassLabel=new JLabel("New Password:");
		this.newPassLabel.setBounds(50,150,100,30);
		background.add(newPassLabel);
		
		this.newPassPF=new JPasswordField();
		this.newPassPF.setBounds(200,150,100,30);
		background.add(newPassPF);
		
		
		
		
		this.updateBtn=new JButton("update");
		this.updateBtn.setBounds(50,200,120,30);
		this.updateBtn.setBackground(c1);
		this.updateBtn.addActionListener(this);
		background.add(updateBtn);
		
		
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(190,200,100,30);
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
			if((!currentPassPF.getText().isEmpty()) && (!newPassPF.getText().isEmpty()))
			{
				
				if(currentPassPF.getText().equals(u.getPassword()))
				{
					
					u.setPassword(newPassPF.getText());
					//doing update operation by UserRepo's object urp.
					UserRepo urp=new UserRepo();
					urp.updateUser(u);
					//updation confirmation message.
					JOptionPane.showMessageDialog(this,"Password updated Successfully");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Current Password didn't match");
				}
		
			}
			else
			{
				//if any of the field is empty, this message will be shown.
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
		}
		
		
		if(command.equals(backBtn.getText()))
		{
			//back button will take you to admin home page.
			EmployeeHomeFrame edf=new EmployeeHomeFrame(this.u);
			this.setVisible(false);
			edf.setVisible(true);
		}
	}
	
}