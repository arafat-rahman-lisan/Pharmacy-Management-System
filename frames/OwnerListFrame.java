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

public class OwnerListFrame extends JFrame implements ActionListener
{
		private JTable ownerTable;
		private JButton backBtn;
		private JPanel panel;
		private JScrollPane ownerTableSP;
		private User u;
		
    public OwnerListFrame(User u)
	{
		super("Employee List Frame");
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
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(20,30,100,30);
		this.backBtn.setBackground(c1);
		this.backBtn.addActionListener(this);
		background.add(backBtn);
		OwnerRepo arp=new OwnerRepo();
		Owner[] OwnerList=arp.getAllOwner();
		//converting the Owner type array in 2d String type array to put the values in the table beacuse in table there will be tow dimention. one is row, other one is colomn.
		String OwnerData1[][]=new String[OwnerList.length][8];
		for(int i=0;i<OwnerList.length;i++)
		{
		
			if(OwnerList[i]!=null)
			{
				System.out.println(OwnerList[i].toStringOwner());
				OwnerData1[i][0]=OwnerList[i].getUserId();
				OwnerData1[i][1]=OwnerList[i].getName();
				OwnerData1[i][2]=OwnerList[i].getEmail();
				OwnerData1[i][3]=OwnerList[i].getPhoneNo();
				OwnerData1[i][4]=OwnerList[i].getGender();
				OwnerData1[i][5]=String.valueOf(OwnerList[i].getAge());
				OwnerData1[i][6]=OwnerList[i].getAddress();
				OwnerData1[i][7]=OwnerList[i].getOwnerType();
			}
			
			
			
		}
		//creating Table.
		//head1 is the colomn name;
		String head1[]={"Id","Name","Email","PhoneNo","Gender","Age","Adress","OwnerType"};
		//putting value and colomn name in the table.
		this.ownerTable=new JTable(OwnerData1,head1);
		//adding scrolling bar in the table
		this.ownerTableSP=new JScrollPane(ownerTable);
		this.ownerTableSP.setBounds(20,70,760,450);
		this.ownerTable.setEnabled(false);
		background.add(ownerTableSP);
		
		
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
			OwnerOperationFrame oof=new OwnerOperationFrame(u);
			this.setVisible(false);
			oof.setVisible(true);
			
		}
	}
}