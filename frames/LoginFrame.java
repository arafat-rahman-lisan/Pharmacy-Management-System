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

public class LoginFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel, passLabel;
	private JTextField userTF;
	private JPasswordField passPF;
	private JButton loginBtn, backBtn, forgetPassBtn;
	private JPanel panel;
	private Font font;
	
	public LoginFrame()
	{
		super("Login Frame");
		this.setSize(1000,650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		this.font = new Font("Agency FB", Font.BOLD, 20);
		
		Color c1 = new Color(0, 153, 153);   //red
        Color c2 = new Color(81, 163, 0);    //green
        Color c3 = new Color(51, 51, 255);  //blue
		
		JLabel background;
		ImageIcon img = new ImageIcon("frames/Picture/Login3.png");
		background = new JLabel("", img, JLabel.LEFT);
		background.setBounds(0, 0, 1000, 650);
		panel.add(background);

		this.userIdLabel = new JLabel("User Id");
		this.userIdLabel.setFont(font);
		this.userIdLabel.setBounds(700, 230, 60, 20);
		background.add(userIdLabel);
		
		this.userTF = new JTextField();
		this.userTF.setBounds(650, 260, 150, 30);
		background.add(userTF);
		
		this.passLabel = new JLabel("Password");
		this.passLabel.setFont(font);
		this.passLabel.setBounds(690, 300, 800, 20);
		background.add(passLabel);
		
		this.passPF = new JPasswordField();
		this.passPF.setBounds(650, 330, 150, 30);
		this.passPF.addActionListener(this); // Add ActionListener to listen for Enter key
		background.add(passPF);
		
		this.loginBtn = new JButton("Login");
		this.loginBtn.setForeground(Color.WHITE);
		this.loginBtn.setBackground(c1);
		this.loginBtn.setBounds(675, 375, 100, 30);
		this.loginBtn.addActionListener(this);
		background.add(loginBtn);
		
		this.forgetPassBtn = new JButton("Forget Pass");
		this.forgetPassBtn.setForeground(Color.WHITE);
		this.forgetPassBtn.setBackground(c1);
		this.forgetPassBtn.setBounds(644, 420, 160, 30);
		this.forgetPassBtn.addActionListener(this);
		background.add(forgetPassBtn);

		this.backBtn = new JButton("<-");
		this.backBtn.setBounds(0, 0, 40, 20);
		this.backBtn.addActionListener(this);
		background.add(backBtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		// Check if the login button was pressed or Enter was pressed in the password field
		if(command.equals(loginBtn.getText()) || ae.getSource() == passPF)
		{
			performLogin();
		}
		
		if(command.equals(forgetPassBtn.getText()))
		{
			ForgetPassFrame fpf = new ForgetPassFrame();
			this.setVisible(false);
			fpf.setVisible(true);
		}
		
		if(command.equals(backBtn.getText()))
		{
			EntryFrame edf = new EntryFrame();
			this.setVisible(false);
			edf.setVisible(true);
		}
	}
	
	// Separate login logic into its own method for clarity
	private void performLogin()
	{
		String uId = userTF.getText();
		String pass = passPF.getText();
		UserRepo urp = new UserRepo();
		User user = urp.searchUserByUserId(uId);

		if(user != null)
		{
			if(user.getUserId().equals(uId) && user.getPassword().equals(pass))
			{
				if(user.getRole() == 1)
				{
					OwnerHomeFrame ohf = new OwnerHomeFrame(user);
					this.setVisible(false);
					ohf.setVisible(true);
				}
				else if(user.getRole() == 2)
				{
					EmployeeHomeFrame ehf = new EmployeeHomeFrame(user);
					this.setVisible(false);
					ehf.setVisible(true);
				}
				else if(user.getRole() == 3)
				{
					CustomerHomeFrame ahf = new CustomerHomeFrame(user);
					this.setVisible(false);
					ahf.setVisible(true);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Wrong user Id or Password!");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Wrong user Id or Password!");
		}
	}
}
