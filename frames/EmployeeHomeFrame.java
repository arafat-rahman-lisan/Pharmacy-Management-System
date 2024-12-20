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

public class EmployeeHomeFrame extends JFrame implements ActionListener {
    
    private JButton customerBtn, medicineManagementBtn, profileBtn, passBtn, backBtn;
    private JPanel panel;
    private User u;
    
    public EmployeeHomeFrame(User u) {
        super("Employee Home Frame");
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
        ImageIcon imageIcon = new ImageIcon("frames/Picture/Arafat2.png");//ImageIcon imageIcon = new ImageIcon("absolute/path/to/Arafat.jpg");

        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(70, 70, 200, 200); // Position and size of the image
        background.add(imageLabel);
        
        // Adding bold text below the image
        JLabel welcomeLabel = new JLabel("------Welcome Assistant------");
        welcomeLabel.setBounds(70, 260, 230, 30); // Position and size of the label
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Customize font (bold, size 16)
        welcomeLabel.setForeground(Color.BLUE); // Set text color to green
        background.add(welcomeLabel);
        
        this.customerBtn = new JButton("Customer Management");
        this.customerBtn.setBounds(400, 90, 250, 30);
        this.customerBtn.setBackground(c1);
        this.customerBtn.addActionListener(this);
        background.add(customerBtn);
        
        this.medicineManagementBtn = new JButton("Medicine Management");
        this.medicineManagementBtn.setBounds(400, 140, 250, 30);
        this.medicineManagementBtn.setBackground(c1);
        this.medicineManagementBtn.addActionListener(this);
        background.add(medicineManagementBtn);
        
        this.profileBtn = new JButton("Update Profile");
        this.profileBtn.setBounds(400, 190, 250, 30);
        this.profileBtn.setBackground(c1);
        this.profileBtn.addActionListener(this);
        background.add(profileBtn);
        
        this.passBtn = new JButton("Update Password");
        this.passBtn.setBounds(400, 240, 250, 30);
        this.passBtn.setBackground(c1);
        this.passBtn.addActionListener(this);
        background.add(passBtn);

        this.backBtn=new JButton("<-");
		this.backBtn.setForeground(Color.BLUE);
		this.backBtn.setBounds(0,0,40,20);
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
			EmployeeUpdateProfileFrame euf=new EmployeeUpdateProfileFrame(this.u);
			this.setVisible(false);
            euf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only the dialog when closed
			euf.setVisible(true);
		}
        // Handle button clicks here if needed

        if(command.equals(customerBtn.getText()))
        {
            CustomerOperationFrame2 quf=new CustomerOperationFrame2(this.u);
			this.setVisible(false);
            quf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only the dialog when closed
			quf.setVisible(true);
        }

        if(command.equals(passBtn.getText()))
		{
			EmployeeUpdatePasswordFrame edf=new EmployeeUpdatePasswordFrame(this.u);
			this.setVisible(false);
            edf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only the dialog when closed
			edf.setVisible(true);
		}
        // Handle button clicks here if needed

        if(command.equals(backBtn.getText()))
		{
			//back button will take you to Login page.
			LoginFrame ldf=new LoginFrame();
			this.setVisible(false);
			ldf.setVisible(true);
		}

        if (command.equals(medicineManagementBtn.getText()))
        {
            MedicineListFrame2 mdf=new MedicineListFrame2 (this.u);
			this.setVisible(false);
            mdf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only the dialog when closed
			mdf.setVisible(true);
        }
    }



    

	
	
    
}
