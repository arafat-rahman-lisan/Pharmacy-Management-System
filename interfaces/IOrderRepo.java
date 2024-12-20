package interfaces;
import java.lang.*;
import entities.*;


public interface IOrderRepo
{
	void addOrder(Order o);
	void removeOrder(String id);
	void updateOrder(Order o);
	Order searchOrderByOrderId(String id);
	Order[] searchOrderByCustomerId(String id);
	Order[] getAllOrder();
	
}