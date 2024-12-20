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

public class MedicineListFrame2 extends JFrame implements ActionListener
{
	
	private JButton backBtn, addBtn, removeBtn;
	private JTable MedicineTable;
	private JScrollPane MedicineTableSP;
	private JPanel panel;
	private User u;
	
	
	
	public MedicineListFrame2(User u)
	{
		super(" All Medicine List Frame");
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

        
		this.addBtn=new JButton("Add Medicine");
		this.addBtn.setBounds(200,50,150,30);
		this.addBtn.setBackground(c1);
		this.addBtn.addActionListener(this);
		background.add(addBtn);

        this.removeBtn=new JButton("Remove Medicine");
		this.removeBtn.setBounds(390,50,150,30);
		this.removeBtn.setBackground(c1);
		this.removeBtn.addActionListener(this);
		background.add(removeBtn);


		MedicineRepo mrp=new MedicineRepo();
		Medicine[] MedicineList=mrp.getAllMedicine();
		String MedicineData1[][]=new String[MedicineList.length][5];
		for(int i=0;i<MedicineList.length;i++)
		{
		
			if(MedicineList[i]!=null)
			{
				MedicineData1[i][0]=MedicineList[i].getMedicineId();
				//MedicineData1[i][1]=MedicineList[i].getUserId();
				MedicineData1[i][1]=MedicineList[i].getMedicineName();
				MedicineData1[i][2]=MedicineList[i].getCategory();
				MedicineData1[i][3]=String.valueOf(MedicineList[i].getPricePerUnit());
				MedicineData1[i][4]=String.valueOf(MedicineList[i].getAvailableQuantity());
			}
			
			
			
		}
		//creating Table.
		//head1 is the colomn name;
		String head1[]={"Medicine id","Medicine Name","Medicine Category","Price","Quantity"};
		
		this.MedicineTable=new JTable(MedicineData1,head1);
		this.MedicineTableSP=new JScrollPane(MedicineTable);
		this.MedicineTableSP.setBounds(50,110,700,450);
		this.MedicineTable.setEnabled(false);
		background.add(MedicineTableSP);
		
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
			//back button will take you to Medicine home page.
			EmployeeAddMedicineFrame eahf=new EmployeeAddMedicineFrame(this.u);
			this.setVisible(false);
			eahf.setVisible(true);
		}

		if(command.equals(removeBtn.getText()))
		{
			//back button will take you to Medicine home page.
			EmployeeRemoveMedicineFrame erhf=new EmployeeRemoveMedicineFrame(this.u);
			this.setVisible(false);
			erhf.setVisible(true);
		}
		
		
		if(command.equals(backBtn.getText()))
		{
			//back button will take you to Medicine home page.
			EmployeeHomeFrame phf=new EmployeeHomeFrame(this.u);
			this.setVisible(false);
			phf.setVisible(true);
		}
	}
	
}