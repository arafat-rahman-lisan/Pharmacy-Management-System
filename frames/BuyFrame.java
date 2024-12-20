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

public class BuyFrame extends JFrame implements ActionListener
{
	private JLabel lbl1,lbl2;
	private JButton backBtn,pBtn,lBtn;
    private JPanel panel;
	private User u;
	private Font font;
	private JScrollPane scroll;
	private Medicine[] mName;
	private MedicineRepo mrp;
	private int k;
	
	String[] str;
	
	public BuyFrame(User u,int price)
	{
		
		super("Buy Medicine Frame");
		this.setSize(600,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		
		this.font = new Font("Agency FB", Font.BOLD, 20);
		Color c1 = new Color(0, 153, 153);   //red
        Color c2 = new Color(81, 103, 0);    //green
        Color c3 = new Color(51, 51, 255);  //blue
		
		
		
		
		this.k = price;
	
		
		this.lbl2=new JLabel("Your selected Total Medicine Price"+ k);
		lbl2.setFont(font);
		lbl2.setBounds(150,70,350,30);
		this.panel.add(lbl2);
		
		
		this.pBtn = new JButton("Payment");
        this.pBtn.setBounds(150, 110, 140, 30);
        this.pBtn.setForeground(Color.WHITE);
        this.pBtn.setBackground(c3);
        this.pBtn.addActionListener(this);
        this.panel.add(pBtn);
		
		this.lBtn = new JButton("Payment List");
        this.lBtn.setBounds(200, 160, 170, 30);
        this.lBtn.setForeground(Color.WHITE);
        this.lBtn.setBackground(c2);
        this.lBtn.addActionListener(this);
        this.panel.add(lBtn);
		
		this.backBtn = new JButton("Back");
        this.backBtn.setBounds(310, 110, 85, 30);
        this.backBtn.setForeground(Color.WHITE);
        this.backBtn.setBackground(c3);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);
		
		
		this.add(panel);
        this.u = u;
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(pBtn.getText()))
		{
			 String paymentId, orderId , userId , paymentDate;
               int paidAmount;
			   
			
			   userId = this.u.getUserId();
			   paidAmount= this.k;
			   orderId=userId+31;
			   paymentId=userId+778;
			  paymentDate=userId+"/"+"24";
			  Payment p=new Payment(paymentId,orderId,userId,paidAmount,paymentDate);
			  PaymentRepo prp=new PaymentRepo();
			  prp.addPayment(p);
			  JOptionPane.showMessageDialog(this, "Payment Successfull");
			   
		}
		
		if(command.equals(lBtn.getText()))
		{
			CustomerSelfPaymentListFrame cpf = new CustomerSelfPaymentListFrame(this.u);
			this.setVisible(false);
			cpf.setVisible(true);
		}
		
		
		if(command.equals(backBtn.getText()))
		{
			//back button will take you to Medicine home page.
			CustomerBuyMedicineFrame  ohf=new CustomerBuyMedicineFrame(this.u);
			this.setVisible(false);
			ohf.setVisible(true);
		}
	}
}