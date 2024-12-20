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

public class CustomerHomeFrame extends JFrame implements ActionListener {
    
    private JButton buyMedicineBtn, profileBtn, passBtn , backBtn;
    private JPanel panel;
    private User u;
    
    public CustomerHomeFrame(User u) {
        super("Customer Home Frame");
        this.setSize(800, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.panel = new JPanel();
        this.panel.setLayout(null);

        Color c1 = new Color(0, 153, 153);

		JLabel background;
		ImageIcon img= new ImageIcon("frames/Picture/Sobar.png");
		background=new JLabel("",img,JLabel.LEFT);
		background.setBounds(0,0,1000,650);
		panel.add(background);
        
        // Adding image using a JLabel
        ImageIcon imageIcon = new ImageIcon("frames/Picture/Customer.png");//ImageIcon imageIcon = new ImageIcon("absolute/path/to/Arafat.jpg");

        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(70, 50, 200, 200); // Position and size of the image
        background.add(imageLabel);
        
        // Adding bold text below the image
        JLabel welcomeLabel = new JLabel("---------Welcome Sir---------");
        welcomeLabel.setBounds(70, 260, 230, 30); // Position and size of the label
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Customize font (bold, size 16)
        welcomeLabel.setForeground(Color.BLUE); // Set text color to green
        background.add(welcomeLabel);
        
        this.buyMedicineBtn = new JButton("Buy Medicine");
        this.buyMedicineBtn.setBounds(400, 110, 250, 30);
        this.buyMedicineBtn.setBackground(c1);
        this.buyMedicineBtn.addActionListener(this);
        background.add(buyMedicineBtn);
        
        this.profileBtn = new JButton("Update Profile");
        this.profileBtn.setBounds(400, 160, 250, 30);
        this.profileBtn.setBackground(c1);
        this.profileBtn.addActionListener(this);
        background.add(profileBtn);
        
        this.passBtn = new JButton("Update Password");
        this.passBtn.setBounds(400, 210, 250, 30);
        this.passBtn.setBackground(c1);
        this.passBtn.addActionListener(this);
        background.add(passBtn);

		this.backBtn = new JButton("<-");
        this.backBtn.setBounds(0, 0, 40, 20);
        this.backBtn.setBackground(c1);
        this.backBtn.addActionListener(this);
        background.add(backBtn);
        
        this.add(panel);
        this.u=u;
    }
    
    public void actionPerformed(ActionEvent ae) {

		String command=ae.getActionCommand();

        if(command.equals(profileBtn.getText()))
		{
			CustomerUpdateProfileFrame cuf=new CustomerUpdateProfileFrame(this.u);
			this.setVisible(false);
            cuf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only the dialog when closed
			cuf.setVisible(true);
		}
        
        if(command.equals(buyMedicineBtn.getText()))
		{
			CustomerBuyMedicineFrame cufm=new CustomerBuyMedicineFrame(this.u);
			this.setVisible(false);
            cufm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only the dialog when closed
			cufm.setVisible(true);
		}


        // Handle button clicks here if needed

        if(command.equals(passBtn.getText()))
		{
			CustomerUpdatePasswordFrame cdf=new CustomerUpdatePasswordFrame(this.u);
			this.setVisible(false);
            cdf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only the dialog when closed
			cdf.setVisible(true);
		}
        // Handle button clicks here if needed

        if(command.equals(backBtn.getText()))
		{
			//back button will take you to Login page.
			LoginFrame ldf=new LoginFrame();
			this.setVisible(false);
			ldf.setVisible(true);
		}
    }



    

	
	
    
}
