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


public class CustomerUpdateProfileFrame extends JFrame implements ActionListener {
    private JLabel userIdLabel, nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel,discountPercentageLabel, membershipTypeLabel;
    private JTextField userTF, nameTF, emailTF, phoneNoTF, genderTF, ageTF, addressTF, discountPercentageTF;
    private JButton updateBtn, backBtn;
    private JPanel panel;
	private JComboBox membershipTypeCMB;
    private User u;
    private Customer customer;

    public CustomerUpdateProfileFrame(User u) {
        super("Customer Update Profile Frame");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        this.panel = new JPanel();
        this.panel.setLayout(null);

		Color c1 = new Color(0, 153, 153);

		JLabel background;
		ImageIcon img= new ImageIcon("frames/Picture/Operation.png");
		background=new JLabel("",img,JLabel.LEFT);
		background.setBounds(0,0,1000,650);
		panel.add(background);
    
        CustomerRepo crp = new CustomerRepo();
        this.customer = crp.searchCustomerByUserId(u.getUserId());
    
        this.userIdLabel = new JLabel("User Id:");
        this.userIdLabel.setBounds(50, 50, 60, 30);
        background.add(userIdLabel);
    
        this.userTF=new JTextField();
		this.userTF.setBounds(120,50,100,30);
		this.userTF.setText(customer.getUserId());
		this.userTF.setEditable(false);
		background.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(50,100,60,30);
		background.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,100,100,30);
		this.nameTF.setText(customer.getName());
		this.nameTF.setEditable(false);
		background.add(nameTF);
		
		this.emailLabel=new JLabel("email:");
		this.emailLabel.setBounds(50,150,60,30);
		background.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(120,150,150,30);
		this.emailTF.setText(customer.getEmail());
		background.add(emailTF);
		
		this.phoneNoLabel=new JLabel("Phone No:");
		this.phoneNoLabel.setBounds(50,200,60,30);
		background.add(phoneNoLabel);
		
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(120,200,100,30);
		this.phoneNoTF.setText(customer.getPhoneNo());
		background.add(phoneNoTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(50,250,60,30);
		background.add(genderLabel);
		
		this.genderTF=new JTextField();
		this.genderTF.setBounds(120,250,100,30);
		this.genderTF.setText(customer.getGender());
		this.genderTF.setEditable(false);
		background.add(genderTF);
		
		
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(50,300,60,30);
		background.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(120,300,100,30);
		this.ageTF.setText(String.valueOf(customer.getAge()));
		background.add(ageTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(50,350,60,30);
		background.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(120,350,100,30);
		this.addressTF.setText(customer.getAddress());
		background.add(addressTF);
		
		this.membershipTypeLabel=new JLabel("Membership Type :");
		this.membershipTypeLabel.setBounds(280,250,200,30);
		background.add(membershipTypeLabel);
		
		String[] item={"Reguler", "non Reguler"};
		this.membershipTypeCMB=new JComboBox(item);
		this.membershipTypeCMB.setBounds(450,250,200,30);
		background.add(membershipTypeCMB);

		this.discountPercentageLabel=new JLabel("Discount Percentage :");
		this.discountPercentageLabel.setBounds(280,300,200,30);
		background.add(discountPercentageLabel);
		
		this.discountPercentageTF=new JTextField();
		this.discountPercentageTF.setBounds(450,300,100,30);
		this.discountPercentageTF.setText(customer.getDiscountPercentage());
		this.discountPercentageTF.setEditable(false);
		background.add(discountPercentageTF);
       

        this.updateBtn = new JButton("Update");
        this.updateBtn.setBounds(50, 450, 120, 30);
		this.updateBtn.setBackground(c1);
        this.updateBtn.addActionListener(this);
        background.add(updateBtn);

        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(190, 450, 100, 30);
		this.backBtn.setBackground(c1);
        this.backBtn.addActionListener(this);
        background.add(backBtn);

        this.add(panel);

        this.u = u;
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (command.equals(updateBtn.getText())) {
            if ((!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())) {
                customer.setEmail(emailTF.getText());
                customer.setPhoneNo(phoneNoTF.getText());
                customer.setAddress(addressTF.getText());

                CustomerRepo crp = new CustomerRepo();
                crp.updateCustomer(customer);

                JOptionPane.showMessageDialog(this, "Customer updated successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill up all the fields properly");
            }
        }

        if (command.equals(backBtn.getText())) {
            CustomerHomeFrame cof = new CustomerHomeFrame(this.u);
            this.setVisible(false);
            cof.setVisible(true);
        }
    }
}
