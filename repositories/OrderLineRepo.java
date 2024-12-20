package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;

public class OrderLineRepo implements IOrderLineRepo
{
	public void addOrderLine(OrderLine n)
	{
		OrderLine[] list= this.getAllOrderLine();
		for(int i=0; i< list.length;i++)
		{
			if(list[i]==null)
			{
				list[i]=n;
				break;
			}
		}
		this.write(list);
	}
	public void removeOrderLine(String id)
	{
		OrderLine[] list= this.getAllOrderLine();
		for(int i=0;i<list.length;i++)
		{
			if(list[i] != null)
			{
				if(list[i].getOrderLineId().equals(id))
				{
					list[i]=null;
					break;
				}
			}
		}
		this.write(list);
	}
	
    public void updateOrderLine(OrderLine n)
	{
		OrderLine[] list= this.getAllOrderLine();
		for(int i=0;i<list.length;i++)
		{
			if(list[i].getOrderLineId().equals(n.getOrderLineId()))
			{
				list[i]=n;
				break;
			}
		}
		this.write(list);
	}
	
	public OrderLine searchOrderLineByOrderLineId(String id)
	{
		OrderLine[] list=this.getAllOrderLine();
		for(int i=0;i<list.length;i++)
		{
			if(list[i].getOrderLineId().equals(id))
			{
				return list[i];
			}
			
		}
		return null;
	}
	public OrderLine[] searchOrderLineByOrderId(String id)
	{
		OrderLine[] list= this.getAllOrderLine();
		OrderLine[] orderList=new OrderLine[100];
		for( int i=0; i<list.length;i++)
		{
			if(orderList[i]!=null)
			{
			
			   if(list[i].getOrderLineId().equals(id))
			   {
				orderList[i]=list[i];
			   }
			}
		}
		return orderList;
	}
	public OrderLine[] searchOrderLineByMedicineId(String id)
	{
		OrderLine[] list= this.getAllOrderLine();
		OrderLine[] findList= new OrderLine[100];
		for(int i=0;i<list.length;i++)
		{
			if(list[i]!=null)
			{
				if(list[i].getMedicineId().equals(id))
				{
					findList[i]=list[i];
					
				}
			}
		}
		return findList;
	}
	public OrderLine[] getAllOrderLine()
	{
		FileIO fia=new FileIO();
		String[] data = fia.readFile("repositories/data/orderLine.txt");
		
		OrderLine l=new OrderLine();
		OrderLine[] list=new OrderLine[100];
		int i=0;
		for(String str : data)
		{
			if( str!= null)
			{
				list[i]=l.formOrderLine(str);
			}
			i++;
		}
		return list;
	}
	public void write(OrderLine[] list)
	{
		FileIO fia = new FileIO();
		String[] strList = new String[100];
		OrderLine l= new OrderLine();
		
		for(int i=0;i<list.length;i++)
		{
			if(list[i] != null)
			{
				strList[i]=list[i].toStringOrderLine();
			}
		}	
		fia.writeFile(strList,"repositories/data/orderLine.txt");
	}
	
}