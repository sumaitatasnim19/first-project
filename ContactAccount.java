package Entities;
import java.lang.*;
import java.util.*;
import java.io.*;
import Frames.*;


public class ContactAccount
{
	private String uname;
	private String uphn;
	private String uemail;
	private String uaddress;
	
	private File file;
	private FileWriter fwrite;
	private Scanner sc;
	
	public ContactAccount()
	{
		
	}
	
	public ContactAccount(String uname,String uphn,String uemail,String uaddress )//name,phn,email,address
	{
		this.uname=uname;
		this.uphn=uphn;
		this.uemail=uemail;
		this.uaddress=uaddress;
	}
	
	public void setUserName(String uname)
	{
		this.uname=uname;
	}
	
	public void setUserPhn(String uphn)
	{
		this.uphn=uphn;
	}
	
	public void setUserEmail(String uemail)
	{
		this.uemail=uemail;
	}
	
	public void setUserAddress(String uaddress)
	{
		this.uaddress=uaddress;
	}
	public String getUserName()
	{
		return uname;
	}
	
	public String getUserPhn()
	{
		return uphn;
	}
	
	public String getUserEmail()
	{
		return uemail;
	}
	
	public String getUserAddress()
	{
		return uaddress;
	}
	
	public void addAccount()
	{
		try
		{
			file=new File("./Data.txt");
			file.createNewFile();
			fwrite=new FileWriter(file,true);
			
			fwrite.write(getUserName()+"\t");
			fwrite.write(getUserPhn()+"\t");
			fwrite.write(getUserEmail()+"\t");
			fwrite.write(getUserAddress()+"\n");
			
			fwrite.flush();
			fwrite.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public boolean getAccount(String username,String userphn,String useremail,String useraddress)
	{
		boolean flag=false;
		try
		{
			file=new File("./Data.txt");
		    sc=new Scanner(file);
		}
		
		
		while(sc.hasNextLine())
		{
			String line=sc.nextLine();
			String[] value=line.split("\t");
			if(value[0].equals(username)&&value[1].equals(userphn)&&value[2].equals(useremail)&&value[3].equals(useraddress))
			{
				flag=true;
			}
		}
	}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		return flag;
	}
	public boolean saveContact(String username,String userphn,String useremail,String useraddress)
	{
		try 
		{
			FileWriter fw new FileWriter("contacts.txt", true);
            fw.write(username+"," +userphn+ ","+useremail+"," +useraddress+"\n");
            fw.close();
            return true;
		}
        catch (IOException e)
		{
            System.out.println("Error saving contact to contacts.txt: " + e.getMessage());
            return false;
		}
	}
    

	
}
