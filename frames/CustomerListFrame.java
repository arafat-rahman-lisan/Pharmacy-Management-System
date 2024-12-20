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

public class CustomerListFrame extends JFrame implements ActionListener
{
		private JTable customerTable;
		private JButton backBtn;
		private JPanel panel;
		private JScrollPane customerTableSP;
		private User u;
		private Font font;
		
    public CustomerListFrame(User u)
	{
		super("Customer List Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.font=new Font("Agency FB", Font.BOLD, 17);
		
		Color c1 = new Color(102, 10, 10);  
        Color c2 = new Color(0,153,153);    //green
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
		
			//getting all the Owners info in Owner type array
		CustomerRepo arp=new CustomerRepo();
		Customer[] CustomerList=arp.getAllCustomer();
		//converting the Owner type array in 2d String type array to put the values in the table beacuse in table there will be tow dimention. one is row, other one is colomn.
		String CustomerData1[][]=new String[CustomerList.length][9];
		for(int i=0;i<CustomerList.length;i++)
		{
		
			if(CustomerList[i]!=null)
			{
				System.out.println(CustomerList[i].toStringCustomer());
				CustomerData1[i][0]=CustomerList[i].getUserId();
				CustomerData1[i][1]=CustomerList[i].getName();
				CustomerData1[i][2]=CustomerList[i].getEmail();
			    CustomerData1[i][3]=CustomerList[i].getPhoneNo();
				CustomerData1[i][4]=CustomerList[i].getGender();
				CustomerData1[i][5]=String.valueOf(CustomerList[i].getAge());
				CustomerData1[i][6]=CustomerList[i].getAddress();
				CustomerData1[i][7]=CustomerList[i].getDiscountPercentage();
		        CustomerData1[i][8]=CustomerList[i].getMembershipType();
				
				
			}
			
			
			
		}
		//creating Table.
		//head1 is the colomn name;
		String head1[]={"Id","Name","Email","PhoneNo","Gender","Age","Adress","discountPercentage","membershipType"};
		//putting value and colomn name in the table.
		this.customerTable=new JTable(CustomerData1,head1);
		//adding scrolling bar in the table
		this.customerTableSP=new JScrollPane(customerTable);
		this.customerTableSP.setBounds(50,60,700,200);
		this.customerTable.setEnabled(false);
		background.add(customerTableSP);
		
		
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
			CustomerOperationFrame cof=new CustomerOperationFrame(u);
			this.setVisible(false);
			cof.setVisible(true);
			
		}
	}
}