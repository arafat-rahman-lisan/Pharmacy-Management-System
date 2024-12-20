package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;
public class OrderRepo implements IOrderRepo
{
	public void addOrder(Order o)
	{
		Order[] orderList=this.getAllOrder();
		
		for(int i=0;i<orderList.length;i++)
		{
			if(orderList[i]==null)
			{
				orderList[i]=o;
				break;
			}
		}
		
		this.write(orderList);
	}
	public void removeOrder(String id)
	{
		Order[] orderList=this.getAllOrder();
		
		for(int i=0;i<orderList.length;i++)
		{
			if(orderList[i]!=null)
			{
				if(orderList[i].getOrderId().equals(id))
				{
					orderList[i]=null;
					break;
				}
			}
			
		}
		
		this.write(orderList);
	}
	public void updateOrder(Order o)
	{
		Order[] orderList=this.getAllOrder();
		
		for(int i=0;i<orderList.length;i++)
		{
			if(orderList[i]!=null)
			{
				if(orderList[i].getOrderId().equals(o.getOrderId()))
				{
					orderList[i]=o;
					break;
				}
			}
			
		}
		
		this.write(orderList);
	}
	public Order searchOrderByOrderId(String id)
	{
		Order[] orderList=this.getAllOrder();
		
		for(int i=0;i<orderList.length;i++)
		{
			if(orderList[i]!=null)
			{
				if(orderList[i].getOrderId().equals(id))
				{
					return orderList[i];
				}
			}
			
		}

		return null;
	}
	public Order[] getAllOrder()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/order.txt");
		
		
		Order s=new Order();
		Order[] orderList=new Order[100];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				orderList[i]=s.formOrder(str);
				
			}
			
			i++;
		}
		
		return orderList;
	}
	public Order[] searchOrderByCustomerId(String id)
	{
	
		Order[] orderList=this.getAllOrder();
		Order[] foundOrder= new Order[100];
		for(int i=0;i<orderList.length;i++)
		{
			if(orderList[i]!=null)
			{
				if(orderList[i].getUserId().equals(id))
				{
					foundOrder[i]=orderList[i];
				}
			}
			
		}

		return foundOrder;
	}
	public void write(Order[] orderList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(orderList[i]!=null)
			{
				data[i]=orderList [i].toStringOrder();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/order.txt");
	}
}