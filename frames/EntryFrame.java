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


public class EntryFrame extends JFrame implements ActionListener
{
	private JButton loginBtn, signUpBtn ;
	private JPanel panel;
	private Font font;

	    public EntryFrame ()
		{
		super("Welcome to the Error Pharma");
		this.setSize(1000,650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);

		Color c1 = new Color(0, 153, 153);

		JLabel background;
		ImageIcon img= new ImageIcon("frames/Picture/Shuru2.png");
		background=new JLabel("",img,JLabel.LEFT);
		background.setBounds(0,0,1000,650);
		panel.add(background);

        this.loginBtn=new JButton("Login");
		this.loginBtn.setForeground(Color.WHITE);
		this.loginBtn.setBackground(c1);
		this.loginBtn.setBounds(313,520,150,30);
		this.loginBtn.addActionListener(this);
		background.add(loginBtn);

        this.signUpBtn=new JButton("Sign Up");
		this.signUpBtn.setForeground(Color.WHITE);
		this.signUpBtn.setBackground(c1);
		this.signUpBtn.setBounds(513,520,150,30);
		
		this.signUpBtn.addActionListener(this);
		background.add(signUpBtn);
		
		this.add(panel);
    }

        public void actionPerformed(ActionEvent ae)
        {
            String command= ae.getActionCommand();
        
        if(command.equals(loginBtn.getText()))
		{
			LoginFrame lf=new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
		if(command.equals(signUpBtn.getText()))
		{
			SignUpFrame sf=new SignUpFrame();
			this.setVisible(false);
			sf.setVisible(true);
		}

    }

}





		
		