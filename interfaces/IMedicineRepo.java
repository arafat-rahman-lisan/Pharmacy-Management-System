package interfaces;
import java.lang.*;
import entities.*;


public interface IMedicineRepo
{
	void addMedicine(Medicine s);
	void removeMedicine(String id);
	void updateMedicine(Medicine c);
	Medicine searchMedicineByMedicineId(String id);
	Medicine[] getAllMedicine();
	
}