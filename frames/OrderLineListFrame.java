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

public class OrderLineListFrame extends JFrame implements ActionListener
{
	
	private JButton backBtn;
	private JTable OrderTable;
	private JScrollPane OrderTableSP;
	private JPanel panel;
	private User u;
	
	
	
	public OrderLineListFrame(User u)
	{
		super(" All Order Line List ");
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
		OrderLineRepo orp=new OrderLineRepo();
		OrderLine[] OrderLineList=orp.getAllOrderLine();
		String OrderLineData1[][]=new String[OrderLineList.length][5];
		for(int i=0;i<OrderLineList.length;i++)
		{
		
			if(OrderLineList[i]!=null)
			{
				OrderLineData1[i][0]=OrderLineList[i].getOrderLineId();
				OrderLineData1[i][1]=OrderLineList[i].getOrderId();
				OrderLineData1[i][2]=OrderLineList[i].getMedicineId();
				OrderLineData1[i][4]=String.valueOf(OrderLineList[i].getQuantity());
				OrderLineData1[i][5]=String.valueOf(OrderLineList[i].getTotalAmount());
				
			}
			
			
			
		}
		//creating Table.
		//head1 is the colomn name;
		String head1[]={"Order Line id","Order Id","Medicine Id","Quantity","Total Amount"};
		
		this.OrderTable=new JTable(OrderLineData1,head1);
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