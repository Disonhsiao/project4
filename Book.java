import java.util.*;
import java.text.*;
import java.io.*;


public class Book {

	private String Name;
	private String Birth;
	private String Number;
	private String Cat;
	private String  Email;
	int mo;
	int da;
	
	
	public Book()
	{
       Name=null;
	   Birth=null;
	   Number=null;
	   Cat=null;
	   Email=null;		
	}
		
	public Book(String s1,String s2,String s3,String s4,String s5)
	{
       setN(s1);
	   setB(s2);
	   setNu(s3);
	   setCat(s4);
	   setE(s5);		
	}
	//Name
	public boolean setN(String s)
	{
		if( !s.equals(null)  )
		{
			Name=s;
			return true;
		}
		else
		{
		  System.out.println("Input again name");	
		  return false;
		}		
	}
	
	public String getN()
	{
		return Name;
	}
	///Birth
	public boolean setB(String s)
	{
		if( !s.equals(null)  )
		{
			if( s.length() != 4)
			{
				 System.out.println("Input again birth");	
				  return false;
			}
			else if(  Character.isDigit( s.charAt(0))  &&  Character.isDigit( s.charAt(1)) && Character.isDigit( s.charAt(2)) && Character.isDigit( s.charAt(3)))
			{
				int n1=Integer.valueOf( s.substring(0,2) );
				int n2=Integer.valueOf( s.substring(2,4) );		
				if(n1>=1 && n1<=12 &&  n2>=1 && n2<=31)
				{
				  mo=n1;	
				  da=n2;
				  Birth=s;
				  return true;
				}
				else 
				{
					 System.out.println("Input again birth");	
					  return false;
				}
			}
			else
			{
				 System.out.println("Input again birth");	
				  return false;
			}
						
		}
		else
		{
		  System.out.println("Input again birth");	
		  return false;
		}		
	}
	public String getB()
	{
		return Birth;
	}
	/////Number
	public boolean setNu(String s)
	{
		if( !s.equals(null)  )
		{			
			if(  Character.isDigit( s.charAt(0))  &&  Character.isDigit( s.charAt(1)) && Character.isDigit( s.charAt(2)) && Character.isDigit( s.charAt(3)) && s.charAt(4)=='-' && Character.isDigit( s.charAt(5))&& Character.isDigit( s.charAt(6))&&Character.isDigit( s.charAt(7)) && Character.isDigit( s.charAt(8))  && Character.isDigit( s.charAt(9)) &&Character.isDigit( s.charAt(10)) )
			{
				Number=s;
				  return true;			
			}
			else
			{
				 System.out.println("Input again Nu");	
				  return false;
			}						
		}
		else
		{
		  System.out.println("Input again nu");	
		  return false;
		}		
	}
	public String getNu()
	{
		return Number;
	}
	////cat
	public boolean setCat(String s)
	{
		if( !s.equals(null)  )
		{
			Cat=s;
			return true;
		}
		else
		{
		  System.out.println("Input again cat");	
		  return false;
		}		
	}
	
	public String getCat()
	{
		return Cat;
	}
	///////E
	public boolean setE(String s)
	{
		if( !s.equals(null)  )
		{			
			boolean cor=false;
		   int i=0;
			for(i=0;i<s.length();i++)
			{
				if( s.charAt(i)=='@'  )
				{
					cor=true;
					break;
				}		
				
			}
			
			 if(cor==true)
			 {
				 cor=false;
				for(int j=i+1;j<s.length();j++) 
				{
					if( s.charAt(j)=='.'  )
					{
						cor=true;
						break;
					}							
				}				 
			 }
			
			 if(cor==true)
			 {
				 Email=s;
				 return true;
			 }
			 else
			 {
				 System.out.println("Input again E");	
				  return false;
				 
			 }
						
		}
		else
		{
		  System.out.println("Input again E");	
		  return false;
		}		
	}
	public String getE()
	{
		return Email;
	}
	
	public int getm()
	{
		return mo;
	}
	public int getd()
	{
		return da;
	}
	
	
	
	
	
	
	
}
