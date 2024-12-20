package entities;
import java.lang.*;

public class OrderLine
{
	private String orderLineId,orderId, medicineId;
	private int totalAmount,quantity;
	
	public OrderLine()
	{
	}
	
	public OrderLine(String orderLineId,String orderId, String medicineId, int totalAmount,int quantity)
	{
		this.orderLineId=orderLineId;
		this.orderId=orderId;
		this.medicineId=medicineId;
		this.quantity=quantity;
		this.totalAmount=totalAmount;
	}
	
	
	public void setOrderLineId(String orderLineId)
	{
		this.orderLineId=orderLineId;
	}
	public void setOrderId(String orderId)
	{
		this.orderId=orderId;
	}
	
	public void setMedicineId(String medicineId)
	{
		this.medicineId=medicineId;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity=quantity;
	}
	
	public void setTotalAmount(int totalAmount)
	{
		this.totalAmount=totalAmount;
	}
	
	public String getOrderLineId()
	{
		return this.orderLineId;
	}
	public String getOrderId()
	{
		return this.orderId;
	}
	
	public String getMedicineId()
	{
		return this.medicineId;
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	public int getTotalAmount()
	{
		return this.totalAmount;
	}
	
	public String toStringOrderLine()
	{
		String str=this.orderLineId+","+this.orderId+","+this.medicineId+","+this.quantity+","+this.totalAmount+"\n";
		return str;
	}
	
	public OrderLine formOrderLine(String str)
	{
		String[] info=str.split(",");
		
		OrderLine rl=new OrderLine();
		rl.setOrderLineId(info[0]);
		rl.setOrderId(info[1]);
		rl.setMedicineId(info[2]);
		rl.setQuantity(Integer.parseInt(info[3]));
		rl.setTotalAmount(Integer.parseInt(info[4]));
		
		return rl;
		
	}
	
}