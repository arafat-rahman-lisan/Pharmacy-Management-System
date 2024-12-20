package interfaces;
import java.lang.*;
import entities.*;


public interface IEmployeeRepo
{
	void addEmployee(Employee f);
	void removeEmployee(String id);
	void updateEmployee(Employee f);
	Employee searchEmployeeByUserId(String id);
	Employee[] getAllEmployee();
	
}