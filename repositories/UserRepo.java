package repositories;
import java.lang.*;
import interfaces.*;
import entities.*;


public class UserRepo implements IUserRepo
{
	public void addUser(User u)
	{
		User[] userList=this.getAllUser();
		
		for(int i=0;i<userList.length;i++)
		{
			if(userList[i]==null)
			{
				userList[i]=u;
				break;
			}
		}
		
		this.write(userList);
		
	}
	
	public void removeUser(String key)
	{
		User[] userList=this.getAllUser();
		
		
		for(int i=0;i<userList.length;i++)
		{
			if(userList[i]!=null)
			{
				if(userList[i].getUserId().equals(key))
				{
					userList[i]=null;
					break;
				}
			}
		}
		
		this.write(userList);
	}
	
	public void updateUser(User u)
	{
		User[] userList=this.getAllUser();
		
		for(int i=0;i<userList.length;i++)
		{
			if(userList[i]!=null)
			{
				if(userList[i].getUserId().equals(u.getUserId()))
				{
					userList[i]=u;
					break;
				}
			}
		}
		
		this.write(userList);
	}
	
	public User searchUserByUserId(String id)
	{
		User[] userList=this.getAllUser();
		
		for(int i=0;i<userList.length;i++)
		{
			if(userList[i]!=null)
			{
				if(userList[i].getUserId().equals(id))
				{
					return userList[i];
				}
			}
		}
		
		return null;
	}
	
	
	public User[] getAllUser()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/user.txt");
		
		
		User u=new User();
		User[] userList=new User[100];
		int i=0;
		for(String str:data)
		{
			if(str!=null)
			{
				userList[i]=u.formUser(str);
				
			}
			
			i++;
		}
		
		return userList;
		
		
	}
	
	public void write(User[] userList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(userList[i]!=null)
			{
				data[i]=userList[i].toStringUser();
			}
			
		}
		
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/user.txt");
	}
	
}