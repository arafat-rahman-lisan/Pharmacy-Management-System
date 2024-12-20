package repositories;
import java.lang.*;
import java.io.*;


public class FileIO
{
	public void writeFile(String[] data, String fileName)
	{
		try
		{
			File f=new File(fileName);
			FileWriter fw=new FileWriter(f);
		
			for(String str:data)
			{
				if(str!=null)
				{
					fw.write(str);
					fw.flush();
				}
			}
		
			fw.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public String[] readFile(String fileName)
	{
		try
		{
			
			File f=new File(fileName);
			FileReader fdr=new FileReader(f);
			BufferedReader bfr=new BufferedReader(fdr);
			String[] data=new String[100];
			String str="";
			int i=0;
			while((str=bfr.readLine())!=null)
			{
				
				
				data[i]=str;
				i++;
			}
		
			return data;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
}