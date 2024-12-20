package entities;
import java.lang.*;

public class Order
{
	private String orderId, userId,orderStatus,paymentStatus,orderDate;
	private int totalAmount, paidAmount, dueAmount; 
	
	public Order()
	{
	}
	
	public Order(String orderId, String userId, String paymentStatus,String orderStatus, int totalAmount, int paidAmount, int dueAmount, String orderDate)
	{
		this.orderId=orderId;
		this.userId=userId;
		this.paymentStatus=paymentStatus;
		this.orderStatus=orderStatus;
		this.totalAmount=totalAmount;
		this.paidAmount=paidAmount;
		this.dueAmount=dueAmount;
		this.orderDate=orderDate;
	}
	
	public void setOrderId(String orderId)
	{
		this.orderId=orderId;
	}
	
	public void setUserId(String userId)
	{
		this.userId=userId;
	}
	
	public void setPaymentStatus(String paymentStatus)
	{
		this.paymentStatus=paymentStatus;
	}
	public void setOrderStatus(String orderStatus)
	{
		this.orderStatus=orderStatus;
	}
	
	public void setTotalAmount(int totalAmount)
	{
		this.totalAmount=totalAmount;
	}
	
	public void setPaidAmount(int paidAmount)
	{
		this.paidAmount=paidAmount;
	}
	
	public void setDueAmount(int dueAmount)
	{
		this.dueAmount=dueAmount;
	}
	
	public void setOrderDate(String orderDate)
	{
		this.orderDate=orderDate;
	}
	
	public String getOrderId()
	{
		return this.orderId;
	}
	
	public String getUserId()
	{
		return this.userId;
	}
	
	public String getPaymentStatus()
	{
		return this.paymentStatus;
	}
	public String getOrderStatus()
	{
		return this.orderStatus;
	}
	
	public int getTotalAmount()
	{
		return this.totalAmount;
	}
	
	public int getPaidAmount()
	{
		return this.paidAmount;
	}

	public int getDueAmount()
	{
		return this.dueAmount;
	}
	
	public String getOrderDate()
	{
		return this.orderDate;
	}
	
	public String toStringOrder()
	{
		String str=this.orderId+","+this.userId+","+this.paymentStatus+","+this.orderStatus+","+this.totalAmount+","+this.paidAmount+","+this.dueAmount+","+this.orderDate+"\n";
		return str;
	}
	
	public Order formOrder(String str)
	{
		String[] info=str.split(",");
		
		Order r=new Order();
		r.setOrderId(info[0]);
		r.setUserId(info[1]);
		r.setPaymentStatus(info[2]);
		r.setOrderStatus(info[3]);
		r.setTotalAmount(Integer.parseInt(info[4]));
		r.setPaidAmount(Integer.parseInt(info[5]));
		r.setDueAmount(Integer.parseInt(info[6]));
		r.setOrderDate(info[7]);
		
		return r;
		
	}
}