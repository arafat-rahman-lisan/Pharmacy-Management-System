package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;
public class MedicineRepo implements IMedicineRepo
{
	public void addMedicine(Medicine s)
	{
		Medicine[] medicineList=this.getAllMedicine();
		
		for(int i=0;i<medicineList.length;i++)
		{
			if(medicineList[i]==null)
			{
				medicineList[i]=s;
				break;
			}
		}
		
		this.write(medicineList);
	}
	public void removeMedicine(String id)
	{
		Medicine[] medicineList=this.getAllMedicine();
		
		for(int i=0;i<medicineList.length;i++)
		{
			if(medicineList[i]!=null)
			{
				if(medicineList[i].getMedicineId().equals(id))
				{
					medicineList[i]=null;
					break;
				}
			}
			
		}
		
		this.write(medicineList);
	}
	public void updateMedicine(Medicine c)
	{
		Medicine[] medicineList=this.getAllMedicine();
		
		for(int i=0;i<medicineList.length;i++)
		{
			if(medicineList[i]!=null)
			{
				if(medicineList[i].getMedicineId().equals(c.getMedicineId()))
				{
					medicineList[i]=c;
					break;
				}
			}
			
		}
		
		this.write(medicineList);
	}
	public Medicine searchMedicineByMedicineId(String id)
	{
		Medicine[] medicineList=this.getAllMedicine();
		
		for(int i=0;i<medicineList.length;i++)
		{
			if(medicineList[i]!=null)
			{
				if(medicineList[i].getMedicineId().equals(id))
				{
					return medicineList[i];
				}
			}
			
		}

		return null;
	}
	
	/*public Medicine[] searchMedicineByUserId(String id)
	{
		Medicine[] medicineList=this.getAllMedicine();
		Medicine[] foundMedicine=new Medicine[100];
		
		for(int i=0;i<medicineList.length;i++)
		{
			if(medicineList[i]!=null)
			{
				if(medicineList[i].getUserId().equals(id))
				{
					foundMedicine[i]=medicineList[i];
				}
			}
			
		}

		return foundMedicine;
	}*/
	public Medicine[] getAllMedicine()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/medicine.txt");
		
		
		Medicine c=new Medicine();
		Medicine[] medicineList=new Medicine[100];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				medicineList[i]=c.formMedicine(str);
				
			}
			
			i++;
		}
		
		return medicineList;
	}
	
	public void write(Medicine[] medicineList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(medicineList[i]!=null)
			{
				data[i]=medicineList [i].toStringMedicine();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/medicine.txt");
	}
	
	
	
}