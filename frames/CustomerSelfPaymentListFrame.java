package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class CustomerSelfPaymentListFrame extends JFrame implements ActionListener
{
	
	private JButton backBtn;
	private JTable paymentTable;
	private JScrollPane paymentTableSP;
	private JPanel panel;
	private User u;
	
	
	
	public CustomerSelfPaymentListFrame(User u)
	{
		super(" Self Payment List Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		

		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(50,50,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		//getting all the payments info in payment type array
		PaymentRepo prp=new PaymentRepo();
		Payment[] paymentList=prp.searchPaymentByUserId(u.getUserId());
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
		this.panel.add(paymentTableSP);
		
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
			BuyFrame f=new BuyFrame(this.u,0);
			this.setVisible(false);
			f.setVisible(true);
		}
	}
	
}