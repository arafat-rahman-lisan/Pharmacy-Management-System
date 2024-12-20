package interfaces;
import java.lang.*;
import entities.*;


public interface ICustomerRepo
{
	void addCustomer(Customer s);
	void removeCustomer(String id);
	void updateCustomer(Customer s);
	Customer searchCustomerByUserId(String id);
	Customer[] getAllCustomer();
	
}