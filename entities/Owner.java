package entities;
import java.lang.*;
 
public class Owner extends User
{
	private String OwnerType;
	
	public Owner()
	{
		super();
	}
	public Owner(String userId, String name, String email, String phoneNo, String gender,int age, String address, int role,String securityAns, String password, String OwnerType)
	{
		super(userId, name, email, phoneNo, gender, age, address, role, securityAns, password);
		this.OwnerType=OwnerType;
	
	}
	public void setOwnerType(String OwnerType)
	{
		this.OwnerType=OwnerType;
	}

	public String getOwnerType()
	{
		return this.OwnerType;
	}

	public String toStringOwner()
	{
		String str=this.userId+","+this.name+","+this.email+","+this.phoneNo+","+this.gender+","+this.age+","+this.address+","+this.OwnerType+"\n";
		return str;
	}
	public Owner formOwner(String str)
	{
		String[] info=str.split(",");
		Owner a=new Owner();
		a.setUserId(info[0]);
		a.setName(info[1]);
		a.setEmail(info[2]);
		a.setPhoneNo(info[3]);
		a.setGender(info[4]);
		a.setAge(Integer.parseInt(info[5]));
		a.setAddress(info[6]);
		a.setOwnerType(info[7]);
	
		return a;
	}

}