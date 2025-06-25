package Entities;
import java.lang.*;
import java.util.*;
import java.io.*;
import Frames.*;

public class Account
{
	private String usrname;
    private String pass;

    private File file;
    private FileWriter fwrite;
    private Scanner sc;
    
    public Account()
	{
	}
	

    public Account(String usrname,String pass)
	{
        this.usrname=usrname;
        this.pass=pass;
    }

    public void setUserName(String usrname)
	{
        this.usrname=usrname;
    }

    public void setUserPass(String pass)
	{
        this.pass=pass;
    }

    public String getUserName()
	{
        return usrname;
    }

    public String getUserPass()
	{
        return pass;
    }

    
    public boolean createAccount(String usrname,String pass,String email)
	{
        try
		{
			file=new File("./Data.txt");
            file.createNewFile();

            Scanner sc=new Scanner(file);
            while (sc.hasNextLine())
			
            
			{
                String line=sc.nextLine();
                String[]value=line.split("\t");
                if (value[0].equals(usrname))
				{
                    sc.close();
                    return false; 
                }
            }
            sc.close();

          
            FileWriter fwrite=new FileWriter(file, true);
            fwrite.write(usrname+"\t"+pass+"\t"+email+"\n"); 
            fwrite.flush();
            fwrite.close();
            return true;
        } 
		catch (IOException ioe)
		{
            ioe.printStackTrace();
            return false;
        }
    }

    public boolean getAccount(String usrname, String pass)
	{
        boolean flag=false;
        try 
		{
            file=new File("./Data.txt");
            sc=new Scanner(file);

            while (sc.hasNextLine())
			{
                String line=sc.nextLine();
                String[]value=line.split("\t");
                if (value.length>=2 && value[0].equals(usrname) && value[1].equals(pass))
				{
                    flag=true;
                    break;
                }
            }
			
           sc.close();
        } 
		catch (IOException ioe)
		{
            ioe.printStackTrace();
        }
        return flag;
    }
}
