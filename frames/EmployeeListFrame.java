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

public class EmployeeListFrame extends JFrame implements ActionListener
{
		private JTable employeeTable;
		private JButton backBtn;
		private JPanel panel;
		private JScrollPane employeeTableSP;
		private User u;
		private Font font;
		
    public EmployeeListFrame(User u)
	{
		super("Employee List Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.font=new Font("Agency FB", Font.BOLD, 17);
		
		Color c1 = new Color(102, 10, 10);   //red
        Color c2 = new Color(0,153,153); 
        Color c3 = new Color(51, 51, 255);  //blue
		
		JLabel background;
		ImageIcon img= new ImageIcon("frames/Picture/Operation.png");
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,800,600);
		panel.add(background);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setForeground(Color.WHITE);
		this.backBtn.setBackground(c2);
		this.backBtn.setBounds(20,30,100,30);
		this.backBtn.addActionListener(this);
		background.add(backBtn);
		
		EmployeeRepo arp=new EmployeeRepo();
		Employee[] EmployeeList=arp.getAllEmployee();
		//converting the Owner type array in 2d String type array to put the values in the table beacuse in table there will be tow dimention. one is row, other one is colomn.
		String EmployeeData1[][]=new String[EmployeeList.length][10];
		for(int i=0;i<EmployeeList.length;i++)
		{
		
			if(EmployeeList[i]!=null)
			{
				System.out.println(EmployeeList[i].toStringEmployee());
				EmployeeData1[i][0]=EmployeeList[i].getUserId();
				EmployeeData1[i][1]=EmployeeList[i].getName();
				EmployeeData1[i][2]=EmployeeList[i].getEmail();
			    EmployeeData1[i][3]=EmployeeList[i].getPhoneNo();
				EmployeeData1[i][4]=EmployeeList[i].getGender();
				EmployeeData1[i][5]=String.valueOf(EmployeeList[i].getAge());
				EmployeeData1[i][6]=EmployeeList[i].getAddress();
				EmployeeData1[i][7]=EmployeeList[i].getDesignation();
				EmployeeData1[i][8]=EmployeeList[i].getWorkingHours();
				EmployeeData1[i][9]=String.valueOf(EmployeeList[i].getSalary());
				
				
			}
			
			
			
		}
		//creating Table.
		//head1 is the colomn name;
		String head1[]={"Id","Name","Email","PhoneNo","Gender","Age","Adress","Designation","WorkingHours","Salary"};
		//putting value and colomn name in the table.
		this.employeeTable=new JTable(EmployeeData1,head1);
		//adding scrolling bar in the table
		this.employeeTableSP=new JScrollPane(employeeTable);
		this.employeeTableSP.setBounds(20,70,760,450);
		this.employeeTable.setEnabled(false);
		background.add(employeeTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
		
		this.u=u;
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(backBtn.getText()))
		{
			EmployeeOperationFrame eof=new EmployeeOperationFrame(u);
			this.setVisible(false);
			eof.setVisible(true);
			
		}
	}
}