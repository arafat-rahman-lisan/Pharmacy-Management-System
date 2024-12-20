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

public class SignUpFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, securityAnsTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup bg;
	private JButton addBtn, backBtn;
	
	private JPanel panel;
	
	
	
	
	public SignUpFrame()
	{
		super("Owner Operation Frame");
		this.setSize(1000,650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);

		
		Color c1 = new Color(0, 153, 153);

		JLabel background;
		ImageIcon img= new ImageIcon("frames/Picture/SignUp2.png");
		background=new JLabel("",img,JLabel.LEFT);
		background.setBounds(0,0,1000,650);
		panel.add(background);
		
		this.userIdLabel=new JLabel("User ID");
		this.userIdLabel.setBounds(445,205,60,30);
		background.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(445,235,100,30);
		background.add(userTF);
		
		this.nameLabel=new JLabel("Name");
		this.nameLabel.setBounds(445,280,60,30);
		background.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(445,315,100,30);
		background.add(nameTF);
		
		this.emailLabel=new JLabel("Email");
		this.emailLabel.setBounds(468,370,60,30);
		background.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(468,410,150,30);
		background.add(emailTF);
		
		this.phoneNoLabel=new JLabel("Phone No");
		this.phoneNoLabel.setBounds(828,320,60,30);
		background.add(phoneNoLabel);
		
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(770,350,120,30);
		background.add(phoneNoTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(600,455,60,30);
		background.add(genderLabel);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(660,450,60,30);
		background.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(730,450,80,30);
		background.add(femaleRB);
		
		this.bg=new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);
		
		this.ageLabel=new JLabel("Age");
		this.ageLabel.setBounds(865,375,60,30);
		background.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(795,405,100,30);
		background.add(ageTF);
		
		this.addressLabel=new JLabel("Address");
		this.addressLabel.setBounds(838,265,60,30);
		background.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(740,295,150,30);
		background.add(addressTF);
		
		this.securityQuesLabel=new JLabel("Security Ques: What is your pet name?:");
		this.securityQuesLabel.setBounds(600,490,300,30);
		background.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(600,520,100,30);
		background.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(682,520,100,30);
		background.add(securityAnsTF);
		
		this.passLabel=new JLabel("Password");
		this.passLabel.setBounds(832,205,100,30);
		background.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(770,240,120,30);
		background.add(passPF);
		
		
		this.addBtn=new JButton("Submit");
		this.addBtn.setBounds(607,315,100,30);
		this.addBtn.setBackground(c1);
		this.addBtn.addActionListener(this);
		background.add(addBtn);
		
		
		this.backBtn=new JButton("<-");
		this.backBtn.setBounds(0,0,40,20);
		this.backBtn.setBackground(c1);
		this.backBtn.addActionListener(this);
		background.add(backBtn);
		
		
		this.add(panel);

		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(addBtn.getText()))
		{
			String userId,name,email,phoneNo,gender,address,securityAns,pass;
			int age;
			//validating every field has data or not
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
			{
				//storing userTF (userID) in userId variable
				userId=userTF.getText();
				//creating a UserRepo object to perform operation in the user.txt file where we stored user login information
				UserRepo urp=new UserRepo();
				//checking whether the provide user id is unique or already assign to another user.
				User user=urp.searchUserByUserId(userId);
				// if the provided userId is unique, no User type object will be found in the user.txt file.
				//if no user if assign with the userId then we can use the userId for creating new admin.
				if(user==null)
				{
					//using try catch block, so that, any type of exception can be handled. here we have a age value, which is expected to be integer.
					//but user can put string value to age varible which might cause exception.
					//to handle such exception we are using try catch block.
					try
					{
						//asign nameTF textfField value to a name variable.
						name=nameTF.getText();
						//asign emailTF textfField value to a email variable.
						email=emailTF.getText();
						//asign phoneNoTF textfField value to a phoneNo variable.
						phoneNo=phoneNoTF.getText();
						// to get gender, we use RadioButton. now to know which radioButton is selected,
						//we are applying conditions if maleRB is selected, gender variable will be assigned as maleRB's value.
						//if femaleRB is selected, gender variable will be assigned as femaleRB's value.
						//or by default maleRB's value will be assigned.
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
						//asign addressTF textfField value to a address variable.
						address=addressTF.getText();
						//asign role. As all the Student will have the same role, we won't have to take this value from user.
						//For admin the role will be 1.
						int role=3;
						//asign securityAnsTF textfField value to a securityAns variable.
						securityAns=securityAnsTF.getText();
						//asign passPF PassField value to a pass variable.
						pass=passPF.getText();
						
						//Creating a Student type variable with all the values that we get from the fields. when a new student admit, he/she has 0 completed credit, and 0.0 cgpa.
						//thats why we dont need to take user input as all new student has 0 completed credit and 0.0 cgpa.
						Customer c=new Customer(userId,name,email,phoneNo,gender,age,address,role,securityAns,pass,"40","Reguler");
						//to add Student's user id, security ans, role and pass information in the user.txt file. as without data in the user.txt file, no user will be able to login in.
						//passing student type object to a userRepo. here polymorphic behaviour of object is used.
						urp.addUser(c);
						//creating a StudentRepo object to perform operation in the student.txt file where we stored admins information
						CustomerRepo crp=new CustomerRepo();
						//to add Student's information in the student.txt file. because all the students information will be stored there.
						crp.addCustomer(c);
						//After successful add operation a confirmation message will be shown.
						JOptionPane.showMessageDialog(this,"Customer Signed Up Successfully");
					}
					catch(Exception e)
					{
						//if any exception occured in the above operation, it is beacuse of string to int convertion.
						JOptionPane.showMessageDialog(this,"provide valid age");
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
		
		
		
		
		
		
		if(command.equals(backBtn.getText()))
		{
			//back button will take you to login page.
			EntryFrame edf=new EntryFrame();
			this.setVisible(false);
			edf.setVisible(true);
		}


	}
	
}