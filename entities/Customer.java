package entities;
import java.lang.*;

public class Customer extends User
{
	private String membershipType,discountPercentage;
	
	public Customer()
	{
		super();
	}
	
	public Customer(String userId, String name, String email, String phoneNo, String gender,int age, String address, int role,String securityAns, String password, String discountPercentage,String membershipType)
	{
		super(userId, name, email, phoneNo, gender, age, address, role, securityAns, password);
		this.discountPercentage=discountPercentage;
		this.membershipType=membershipType;
	}
	
	public void setDiscountPercentage(String discountPercentage)
	{
		this.discountPercentage=discountPercentage;
	}
	
	public void setMembershipType(String membershipType)
	{
		this.membershipType=membershipType;
	}
	
	public String getDiscountPercentage()
	{
		return this.discountPercentage;
	}
	
	public String getMembershipType()
	{
		return this.membershipType;
	}
	
	
	public String toStringCustomer()
	{
		String str=this.userId+","+this.name+","+this.email+","+this.phoneNo+","+this.gender+","+this.age+","+this.address+","+this.discountPercentage+","+this.membershipType+"\n";
		return str;
	}
	
	public Customer formCustomer(String str)
	{
		String[] info=str.split(",");
		Customer s=new Customer();
		s.setUserId(info[0]);
		s.setName(info[1]);
		s.setEmail(info[2]);
		s.setPhoneNo(info[3]);
		s.setGender(info[4]);
		s.setAge(Integer.parseInt(info[5]));
		s.setAddress(info[6]);
		s.setDiscountPercentage(info[7]);
		s.setMembershipType(info[8]);
		
		return s;
	}
	
	
}