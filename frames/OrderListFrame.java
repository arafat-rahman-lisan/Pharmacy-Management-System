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

public class OrderListFrame extends JFrame implements ActionListener
{
	
	private JButton backBtn;
	private JTable OrderTable;
	private JScrollPane OrderTableSP;
	private JPanel panel;
	private User u;
	
	
	
	public OrderListFrame(User u)
	{
		super(" All Order List Frame");
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
		this.panel.add(backBtn);
		OrderRepo orp=new OrderRepo();
		Order[] OrderList=orp.getAllOrder();
		String OrderData1[][]=new String[OrderList.length][8];
		for(int i=0;i<OrderList.length;i++)
		{
		
			if(OrderList[i]!=null)
			{
				OrderData1[i][0]=OrderList[i].getOrderId();
				OrderData1[i][1]=OrderList[i].getUserId();
				OrderData1[i][2]=OrderList[i].getPaymentStatus();
				OrderData1[i][3]=OrderList[i].getOrderStatus();
				OrderData1[i][4]=String.valueOf(OrderList[i].getTotalAmount());
				OrderData1[i][5]=String.valueOf(OrderList[i].getPaidAmount());
				OrderData1[i][6]=String.valueOf(OrderList[i].getDueAmount());
				OrderData1[i][7]=OrderList[i].getOrderDate();
			}
			
			
			
		}
		//creating Table.
		//head1 is the colomn name;
		String head1[]={"Order id","User Id","Payment Status","Order Status","Total Amount","Paid Amount","Due Amount","Order Date"};
		
		this.OrderTable=new JTable(OrderData1,head1);
		this.OrderTableSP=new JScrollPane(OrderTable);
		this.OrderTableSP.setBounds(10,110,700,450);
		this.OrderTable.setEnabled(false);
		background.add(OrderTableSP);
		
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
			//back button will take you to Order home page.
			OwnerHomeFrame ohf=new OwnerHomeFrame(this.u);
			this.setVisible(false);
			ohf.setVisible(true);
		}
	}
	
}