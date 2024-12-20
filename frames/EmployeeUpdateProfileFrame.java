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

public class EmployeeUpdateProfileFrame extends JFrame implements ActionListener {
    private JLabel userIdLabel, nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel, designationLabel,workingHoursLabel;
    private JTextField userTF, nameTF, emailTF, phoneNoTF, genderTF, ageTF, addressTF, workingHoursTF;
    private JButton updateBtn, backBtn;
    private JPanel panel;
	private JComboBox designationCMB;
    private User u;
    private Employee employee;

    public EmployeeUpdateProfileFrame(User u) {
        super("Employee Update Profile Frame");
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
    
        EmployeeRepo erp = new EmployeeRepo();
        this.employee = erp.searchEmployeeByUserId(u.getUserId());
    
        this.userIdLabel = new JLabel("User Id:");
        this.userIdLabel.setBounds(50, 50, 60, 30);
        background.add(userIdLabel);
    
        this.userTF=new JTextField();
		this.userTF.setBounds(120,50,100,30);
		this.userTF.setText(employee.getUserId());
		this.userTF.setEditable(false);
		background.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(50,100,60,30);
		background.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,100,100,30);
		this.nameTF.setText(employee.getName());
		this.nameTF.setEditable(false);
		background.add(nameTF);
		
		this.emailLabel=new JLabel("Email:");
		this.emailLabel.setBounds(50,150,60,30);
		background.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(120,150,150,30);
		this.emailTF.setText(employee.getEmail());
		background.add(emailTF);
		
		this.phoneNoLabel=new JLabel("Phone No:");
		this.phoneNoLabel.setBounds(50,200,60,30);
		background.add(phoneNoLabel);
		
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(120,200,100,30);
		this.phoneNoTF.setText(employee.getPhoneNo());
		background.add(phoneNoTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(50,250,60,30);
		background.add(genderLabel);
		
		this.genderTF=new JTextField();
		this.genderTF.setBounds(120,250,100,30);
		this.genderTF.setText(employee.getGender());
		this.genderTF.setEditable(false);
		background.add(genderTF);
		
		
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(50,300,60,30);
		background.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(120,300,100,30);
		this.ageTF.setText(String.valueOf(employee.getAge()));
		background.add(ageTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(50,350,100,30);
		background.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(120,350,100,30);
		this.addressTF.setText(employee.getAddress());
		background.add(addressTF);
		
		this.designationLabel=new JLabel("Designation :");
		this.designationLabel.setBounds(280,250,100,30);
		this.nameTF.setEditable(false);
		background.add(designationLabel);
		
		String[] item={"Manager", "Assistant Manager", "ShopKeeper"};
		this.designationCMB=new JComboBox(item);
		this.designationCMB.setBounds(390,250,200,30);
		background.add(designationCMB);

		this.workingHoursLabel=new JLabel("Working Hours:");
		this.workingHoursLabel.setBounds(280,350,150,30);
		background.add(workingHoursLabel);
		
		this.workingHoursTF=new JTextField();
		this.workingHoursTF.setBounds(380,350,100,30);
		this.workingHoursTF.setText(employee.getWorkingHours());
		this.workingHoursTF.setEditable(false);
		background.add(workingHoursTF);
       

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
                employee.setEmail(emailTF.getText());
                employee.setPhoneNo(phoneNoTF.getText());
                employee.setAddress(addressTF.getText());

                EmployeeRepo erp = new EmployeeRepo();
                erp.updateEmployee(employee);

                JOptionPane.showMessageDialog(this, "Employee updated successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill up all the fields properly");
            }
        }

        if (command.equals(backBtn.getText())) {
            EmployeeHomeFrame eof = new EmployeeHomeFrame(this.u);
            this.setVisible(false);
            eof.setVisible(true);
        }
    }
}
