package entities;
import java.lang.*;

public class Medicine
{
	private String MedicineId, MedicineName, category;
	private int pricePerUnit, availableQuantity;
	
	public Medicine()
	{
	}
	
	public Medicine(String MedicineId, String MedicineName, String category, int pricePerUnit, int availableQuantity)
	{
		this.MedicineId=MedicineId;
		this.MedicineName=MedicineName;
		this.category=category;
		this.pricePerUnit=pricePerUnit;
		this.availableQuantity=availableQuantity;
	}
	
	public void setMedicineId(String MedicineId)
	{
		this.MedicineId=MedicineId;
	}
	/*public void setUserId(String userId)
	{
		this.userId=userId;
	}*/

	public void setMedicineName(String MedicineName)
	{
		this.MedicineName=MedicineName;
	}
	
	public void setcategory(String category)
	{
		this.category=category;
	}
	
	public void setpricePerUnit(int pricePerUnit)
	{
		this.pricePerUnit=pricePerUnit;
	}
	
	public void setavailableQuantity(int availableQuantity)
	{
		this.availableQuantity=availableQuantity;
	}
	
	public String getMedicineId()
	{
		return this.MedicineId;
	}
	/*public String getUserId()
	{
		return this.userId;
	}*/

	public String getMedicineName()
	{
		return this.MedicineName;
	}
	
	public String getCategory()
	{
		return this.category;
	}
	
	public int getPricePerUnit()
	{
		return this.pricePerUnit;
	}
	
	public int getAvailableQuantity()
	{
		return this.availableQuantity;
	}
	
	public String toStringMedicine()
	{
		String str=this.MedicineId+","+this.MedicineName+","+this.category+","+this.pricePerUnit+","+this.availableQuantity+"\n";
		return str;
	}
	
	public Medicine formMedicine(String str)
	{
		String[] info=str.split(",");
		Medicine c=new Medicine();
		c.setMedicineId(info[0]);
		c.setMedicineName(info[1]);
		c.setcategory(info[2]);
		c.setpricePerUnit(Integer.parseInt(info[3]));
		c.setavailableQuantity(Integer.parseInt(info[4]));
		return c;
	}
}