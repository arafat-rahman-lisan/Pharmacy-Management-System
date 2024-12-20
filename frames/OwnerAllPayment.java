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

public class OwnerAllPayment extends JFrame implements ActionListener
{
	
	private JButton backBtn;
	private JTable paymentTable;
	private JScrollPane paymentTableSP;
	private JPanel panel;
	private User u;
	
	
	
	public OwnerAllPayment(User u)
	{
		super(" All Payment Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		Color c1 = new Color(0, 153, 153);

		JLabel background;
		ImageIcon img= new ImageIcon("frames/Picture/Operation.png");
		background=new JLabel("",img,JLabel.LEFT);
		background.setBounds(0,0,1000,650);
		panel.add(background);
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(50,50,100,30);
		this.backBtn.setBackground(c1);
		this.backBtn.addActionListener(this);
		background.add(backBtn);
		//getting all the payments info in payment type array
		PaymentRepo prp=new PaymentRepo();
		Payment[] paymentList=prp.getAllPayment();
		//converting the payment type array in 2d String type array to put the values in the table beacuse in table there will be two dimention. one is row, other one is colomn.
		String paymentData1[][]=new String[paymentList.length][5];
		for(int i=0;i<paymentList.length;i++)
		{
		
			if(paymentList[i]!=null)
			{
				paymentData1[i][0]=paymentList[i].getPaymentId();
				paymentData1[i][1]=paymentList[i].getOrderId();
				paymentData1[i][2]=paymentList[i].getUserId();
				paymentData1[i][3]=String.valueOf(paymentList[i].getPaidAmount());
				paymentData1[i][4]=paymentList[i].getPaymentDate();
			}
			
			
			
		}
		//creating Table.
		//head1 is the colomn name;
		String head1[]={"Payment id","Order Id","User Id","Paid Amount","Date"};
		//putting value and colomn name in the table.
		this.paymentTable=new JTable(paymentData1,head1);
		//adding scrolling bar in the table
		this.paymentTableSP=new JScrollPane(paymentTable);
		this.paymentTableSP.setBounds(50,110,700,450);
		this.paymentTable.setEnabled(false);
		background.add(paymentTableSP);
		
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
			//back button will take you to payment home page.
			OwnerHomeFrame ohf=new OwnerHomeFrame(this.u);
			this.setVisible(false);
			ohf.setVisible(true);
		}
	}
	
}