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

public class EmployeeOperationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel, designationLabel,workingHoursLabel,salaryLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, securityAnsTF,workingHoursTF,salaryTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup bg;
	private JComboBox designationCMB;
	private JButton addBtn, removeBtn,resetBtn,searchBtn, backBtn,listBtn;
	//private JTable employeeTable;
	//private JScrollPane employeeTableSP;
	private JPanel panel;
	private User u;
	private Font font;
	
	
	
	public EmployeeOperationFrame(User u)
	{
		super("Employee Operation Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.font=new Font("Agency FB", Font.BOLD, 17);
		
		Color c1 = new Color(102, 10, 10);   //red
        Color c2 = new Color(0,153,153);    
        Color c3 = new Color(51, 51, 255);  //blue
		
		JLabel background;
		ImageIcon img= new ImageIcon("frames/Picture/Sobar.png");
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,800,600);
		panel.add(background);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,30);
		this.userIdLabel.setFont(font);
		background.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(120,50,100,30);
		background.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(50,100,60,30);
		this.nameLabel.setFont(font);
		background.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,100,100,30);
		background.add(nameTF);
		
		this.emailLabel=new JLabel("email:");
		this.emailLabel.setBounds(50,150,60,30);
		this.emailLabel.setFont(font);
		background.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(120,150,100,30);
		background.add(emailTF);
		
		this.phoneNoLabel=new JLabel("Phone No:");
		this.phoneNoLabel.setBounds(50,200,60,30);
		this.phoneNoLabel.setFont(font);
		background.add(phoneNoLabel);
		
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(120,200,100,30);
		background.add(phoneNoTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(50,250,60,30);
		this.genderLabel.setFont(font);
		background.add(genderLabel);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(120,250,60,30);
		this.maleRB.setFont(font);
		background.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(190,250,80,30);
		this.femaleRB.setFont(font);
		background.add(femaleRB);
		
		this.bg=new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(50,300,60,30);
		this.ageLabel.setFont(font);
		background.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(120,300,100,30);
		background.add(ageTF);
		
		this.addressLabel=new JLabel("Current Address:");
		this.addressLabel.setBounds(280,50,60,30);
		this.addressLabel.setFont(font);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(390,50,130,30);
		background.add(addressTF);
		
		this.securityQuesLabel=new JLabel("Security Ques: What is your pet name?:");
		this.securityQuesLabel.setBounds(280,100,300,30);
		this.securityQuesLabel.setFont(font);
		background.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(280,150,100,30);
		this.securityAnsLabel.setFont(font);
		background.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(390,150,100,30);
		background.add(securityAnsTF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(280,200,100,30);
		this.passLabel.setFont(font);
		background.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(390,200,100,30);
		background.add(passPF);
		
		this.designationLabel=new JLabel("Employee Type:");
		this.designationLabel.setBounds(280,250,100,30);
		this.designationLabel.setFont(font);
		background.add(designationLabel);
		
		String[] item={"Manager", "Sub manager","shop keeper"};
		this.designationCMB=new JComboBox(item);
		this.designationCMB.setBounds(390,250,200,30);
		background.add(designationCMB);
		
		this.workingHoursLabel=new JLabel("Working hours:");
		this.workingHoursLabel.setBounds(280,300,100,30);
		this.workingHoursLabel.setFont(font);
		background.add(workingHoursLabel);
		
		this.workingHoursTF=new JTextField();
		this.workingHoursTF.setBounds(390,300,150,30);
		background.add(workingHoursTF);
		
		this.salaryLabel=new JLabel("Salary :");
		this.salaryLabel.setBounds(280,350,100,30);
		this.salaryLabel.setFont(font);
		background.add(salaryLabel);
		
		this.salaryTF=new JTextField();
		this.salaryTF.setBounds(390,350,150,30);
		background.add(salaryTF);
		
		this.addBtn=new JButton("Add Employee");
		this.addBtn.setBounds(560,50,140,30);
		this.addBtn.setForeground(Color.WHITE);
        this.addBtn.setBackground(c2);
		this.addBtn.addActionListener(this);
		background.add(addBtn);
		
		this.listBtn=new JButton("Employee List");
		this.listBtn.setBounds(50,400,150,30);
		this.listBtn.setForeground(Color.WHITE);
		this.listBtn.setBackground(c2);
		this.listBtn.addActionListener(this);
		background.add(listBtn);

		this.removeBtn=new JButton("Remove Employee");
		this.removeBtn.setBounds(560,100,140,30);
		this.removeBtn.setForeground(Color.WHITE);
		this.removeBtn.setBackground(c2);
		this.removeBtn.addActionListener(this);
		background.add(removeBtn);
		
		this.searchBtn=new JButton("Search Employee");
		this.searchBtn.setBounds(560,150,140,30);
		this.searchBtn.setForeground(Color.WHITE);
		this.searchBtn.setBackground(c2);
		this.searchBtn.addActionListener(this);
		background.add(searchBtn);
		
		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(560,200,140,30);
		this.resetBtn.setForeground(Color.WHITE);
		this.resetBtn.setBackground(c2);
		this.resetBtn.addActionListener(this);
		background.add(resetBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(210,400,100,30);
		this.backBtn.setForeground(Color.WHITE);
		this.backBtn.setBackground(c2);
		this.backBtn.addActionListener(this);
	    background.add(backBtn);

		this.panel.revalidate();
		this.panel.repaint();
		
	

		this.add(panel);
		
		this.u=u;
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(addBtn.getText()))
		{
			String userId,name,email,phoneNo,gender,address,securityAns,pass,designation,workingHours;
			int age,salary;
			//validating every field has data or not
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!salaryTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
			{
				//storing userTF (userID) in userId variable
				userId=userTF.getText();
				//creating a UserRepo object to perform operation in the user.txt file where we stored user login information
				UserRepo urp=new UserRepo();
				//checking whether the provide user id is unique or already assign to another user.
				User user=urp.searchUserByUserId(userId);
				
				if(user==null)
				{
		
					try
					{
						//asign nameTF textfField value to a name variable.
						name=nameTF.getText();
						//asign emailTF textfField value to a email variable.
						email=emailTF.getText();
						//asign phoneNoTF textfField value to a phoneNo variable.
						phoneNo=phoneNoTF.getText();
	
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
				
						else if(femaleRB.isSelected())
						{
							gender=femaleRB.getText();
						}
				
						else
						{
							gender=maleRB.getText();
						}
						//asign ageTF textfField value to a age variable. But before assigning we have to convert the ageTF value to integer as our age varibale's expected value is integer.
						age=Integer.parseInt(ageTF.getText());
						salary=Integer.parseInt(salaryTF.getText());
						workingHours=workingHoursTF.getText(); 
				
						//asign addressTF textfField value to a address variable.
						address=addressTF.getText();
						//asign role. As all the Owner will have the same role, we won't have to take this value from user.
						//For Owner the role will be 1.
						int role=2;
						//asign securityAnsTF textfField value to a securityAns variable.
						securityAns=securityAnsTF.getText();
						//asign passPF PassField value to a pass variable.
						pass=passPF.getText();
						//asign designationCMB comboBox value to a designation variable.
						designation=designationCMB.getSelectedItem().toString();
						//Creating a Owner type variable with all the values that we get from the fields.
						Employee a=new Employee(userId,name,email,phoneNo,gender,age,address,role,securityAns,pass,designation,workingHours,salary);
						//to add Owner's user id, security ans, role and pass information in the user.txt file. as without data in the user.txt file, no user will be able to login in.
						//passing Owner type object to a userRepo. here polymorphic behaviour of object is used.
						urp.addUser(a);
						//creating a EmployeeRepo object to perform operation in the Owner.txt file where we stored Owners information
						EmployeeRepo arp=new EmployeeRepo();
						//to add Owner's information in the Owner.txt file. because all the Owners information will be stored there.
						arp.addEmployee(a);
						//After successful add operation a confirmation message will be shown.
						JOptionPane.showMessageDialog(this,"Employee added Successfully");
					}
					catch(Exception e)
					{
						//if any exception occured in the above operation, it is beacuse of string to int convertion.
						JOptionPane.showMessageDialog(this,"Ensure the validness of age and salary");
					}
				}
				
				else
				{
					//if the provided userId is already assign to any user, this message will be shown.
					JOptionPane.showMessageDialog(this,"User Id already exists.");
				}
		
			}
			else
			{
				//if any of the field is empty, this message will be shown.
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
			
		}
		
		if(command.equals(removeBtn.getText()))
		{
			String userId;
			//to delete Owner we need to have the user id.
			//validating userTF has data or not
			if(!userTF.getText().isEmpty()) 
			{
				//storing userTF (userID) in userId variable
				userId=userTF.getText();
				//creating a EmployeeRepo object to perform operation in the Owner.txt file where we stored Owners information
				EmployeeRepo arp=new EmployeeRepo();
				//checking wether the userId is associated with any Owner or not.
				//if associated searchOwnerByUserId will return an object of Owner type
				Employee a=arp.searchEmployeeByUserId(userId);
				//if we get an Owner associated with the id, we can perform the next steps.
				if(a!=null)
				{
					//if we want to delete an Owner, first we have to delete that Owner's login credentials which is stored in the user.txt file.
					//creating a UserRepo object to perform operation in the user.txt file where we stored user's login information
					UserRepo urp=new UserRepo();
					//to remove Owner's login information from user.txt, we have use the remove user functionality provided by UserRepo.
					urp.removeUser(userId);
					//removing Owner from Owner.txt.
					arp.removeEmployee(userId);
					//confirmation message of Owner remove operation
					JOptionPane.showMessageDialog(this,"Employee removed Successfully");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"provide Valid user ID");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please Provide a valid userId");
			}
		}
		
		if(command.equals(searchBtn.getText()))
		{
			String userId;
			//to search Owner we need to have the user id.
			//validating userTF has data or not
			if(!userTF.getText().isEmpty())
			{
				//storing userTF (userID) in userId variable
				userId=userTF.getText();
				//creating a EmployeeRepo object to perform operation in the Owner.txt file where we stored Owners information
				EmployeeRepo urp=new EmployeeRepo();
				//checking wether the userId is associated with any Owner or not.
				//if associated searchOwnerByUserId will return an object of Owner type
				Employee a=urp.searchEmployeeByUserId(userId);
				//if we get an Owner associated with the id, we can perform the next steps.
				if(a!=null)
				{
					//making userTF textField readonly. beacuse after search, update or delete operation will be performed.
					// to avoid user from modifying userId, we make it readonly.
					userTF.setEditable(false);
					//setting the Owner's name in the nameTF textField that we found by searching.
					nameTF.setText(a.getName());
					//setting the Owner's email in the emailTF textField that we found by searching. 
					emailTF.setText(a.getEmail());
					//setting the Owner's phoneNo in the nameTF textField that we found by searching.
					phoneNoTF.setText(a.getPhoneNo());
					//setting the Owner's gender in the maleRB or femaleRB radioButton that we found by searching. 
					if(a.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					
					else
					{
						femaleRB.setSelected(true);
					}
					//setting the Owner's designation in the designationCMB comboBox that we found by searching.
					if(a.getDesignation().equals("Manager"))
					{
						designationCMB.setSelectedItem("Manager");
					}
					if(a.getDesignation().equals("Sub manager"))
					{
						designationCMB.setSelectedItem("Sub manager");
					}
					else
					{
						designationCMB.setSelectedItem("shop keeper");
					}
					//setting the Owner's age in the ageTF textField that we found by searching.
					ageTF.setText(String.valueOf(a.getAge()));
					salaryTF.setText(String.valueOf(a.getSalary()));
					//setting the Owner's address in the addressTF textField that we found by searching.
					addressTF.setText(a.getAddress());
					//Confirmation message if Owner is found.
					JOptionPane.showMessageDialog(this,"Employee found");
				}
				
				else
				{
					//confirmation message if Owner is not found.
					JOptionPane.showMessageDialog(this,"Employee not found");
				}
			}
			
			else
			{
				//if no id is assign to perform the search operation.
				JOptionPane.showMessageDialog(this,"Please provide userId to search Employee.");
			}
			
		}
		
		if(command.equals(resetBtn.getText()))
		{
			//reseting all the field values.
			//making userId textField editable again.
			userTF.setEditable(true);
			userTF.setText("");
			nameTF.setText("");
			emailTF.setText("");
			phoneNoTF.setText("");
			ageTF.setText("");
			addressTF.setText("");
			securityAnsTF.setText("");
			passPF.setText("");
			salaryTF.setText("");
			workingHoursTF.setText("");
			JOptionPane.showMessageDialog(this,"reset successfully");
		}
		
		if(command.equals(backBtn.getText()))
		{
			//back button will take you to Employee home page.
			EmployeeHomeFrame ehf=new EmployeeHomeFrame(this.u);
			this.setVisible(false);
			ehf.setVisible(true);
		}
		if(command.equals(listBtn.getText()))
		{
			EmployeeListFrame elf=new EmployeeListFrame(u);
			this.setVisible(false);
			elf.setVisible(true);
		}
	}
	
}