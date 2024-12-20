package interfaces;
import java.lang.*;
import entities.*;


public interface IOrderLineRepo
{
	void addOrderLine(OrderLine n);
	void removeOrderLine(String id);
	void updateOrderLine(OrderLine n);
	OrderLine searchOrderLineByOrderLineId(String id);
	OrderLine[] searchOrderLineByOrderId(String id);
	OrderLine[] searchOrderLineByMedicineId(String id);
	OrderLine[] getAllOrderLine();
	
}