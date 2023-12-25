import java.util.*;
import java.text.*;
import java.io.*;


public class AddressBook {

int mode=2;	
int page=10;
boolean So=true;
boolean Na=true;
boolean Nu=true;
boolean E=true;
boolean Bi=true;
boolean Cat=true;

ArrayList<String> read=new ArrayList<String>();	
ArrayList<String> type=new ArrayList<String>();	

ArrayList<Book> myList=new ArrayList<Book>();		
ArrayList<Book> myList2=new ArrayList<Book>();

ArrayList<Integer> order=new ArrayList<Integer>();		


	public static void main(String args[])
	{
		
		AddressBook demo=new AddressBook();
	  	
	 	demo.init();
		demo.book();
		//demo.login();
		 demo.welcome();
	}
	
	public void init()
	{
		//mode
		Scanner mo_w=null;
		//Book data=null;
		try {
			
		  mo_w=new Scanner(new FileInputStream("mode.txt"));	
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not exists");
			System.exit(0);	
		}
		int a=mo_w.nextInt();
		mode=a;
		mo_w.close();
		//page
		Scanner pa_w=null;
		//Book data=null;
		try {
			
		  pa_w=new Scanner(new FileInputStream("page.txt"));	
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not exists");
			System.exit(0);	
		}
		int pa=pa_w.nextInt();
		page=pa;
		pa_w.close();
		///
		Scanner set_w=null;
		
   		try {
			  set_w=new Scanner(new FileInputStream("set.txt"));	
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not exists");
				System.exit(0);	
			}
		String ss=null;
		ss=set_w.next();
		if(ss.equals("Y"))
		{
		So=true;	
		}
		else
		{
		So=false;
		}
		ss=set_w.next();
		if(ss.equals("Y"))
		{
		Na=true;	
		}
		else
		{
		Na=false;
		}
		ss=set_w.next();
		if(ss.equals("Y"))
		{
		Bi=true;	
		}
		else
		{
		Bi=false;
		}
		ss=set_w.next();
		if(ss.equals("Y"))
		{
		Nu=true;	
		}
		else
		{
		Nu=false;
		}
		ss=set_w.next();
		if(ss.equals("Y"))
		{
		Cat=true;	
		}
		else
		{
		Cat=false;
		}
		ss=set_w.next();
		if(ss.equals("Y"))
		{
		E=true;	
		}
		else
		{
		E=false;
		}
		set_w.close();
		///////
        Scanner cat_w=null;
		
   		try {
			  cat_w=new Scanner(new FileInputStream("set.txt"));	
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not exists");
				System.exit(0);	
			}
		type.add("friend");
		type.add("family");
		while(cat_w.hasNext())
		{
			type.add( cat_w.next() );
			
		}
		cat_w.close();
				
	}
	
		
	public void welcome()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("please input the function");
		System.out.println("A.administrator B.user C.leave");
		String s1=sc.next();
		
		while(true)
		{
			if(s1.equalsIgnoreCase("A"))
			{
			    adm();
				
			}
			else if(s1.equalsIgnoreCase("B"))
			{
				user();
			}
			else if(s1.equalsIgnoreCase("C"))
			{
				System.exit(0);
			}			
			else
			{
				System.out.println("Error!please input the function");
				System.out.println("A.administrator B.user C.leave");
			     s1=sc.next();			
			}
		}
			
	}
	
	
	
	
	
	public void login()
	{
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Identification function");
		boolean cor=false;
while(cor==false)
{
	
		if(mode==1)
		{ 
			cor=true;
			int[] a=new int[3];
			int[] b=new int[3];
			
			for(int i=0; i<3;i++)
			{
				a[i]=(int)(Math.random()*100)+1;
			}
			int tmp=0;
			for(int i=0;i<=1;i++)
			{
				for(int j=0;j<=1-i;j++)
				{
					if(a[j] >a[j+1])
					{
						tmp=a[j];
						a[j]=a[j+1];
					    a[j+1]=tmp;
					}	
				}
			}
			System.out.println("Input the numnber in ascending order");
			for(int i=0; i<3;i++)
			{
				System.out.print(a[i]+" ");
			}
			System.out.println();
			for(int i=0; i<3;i++)
			{
				b[i]=sc.nextInt();
			}
		
			for(int i=0; i<3;i++)
			{
				if(a[i]!=b[i])
				{
					cor=false;
					System.out.println("Input error");
				}
			}
					
		}
		else if( mode==2)
		{
			cor=true;
			int x,y,l;
			int ans=0;
			
			x=(int)(Math.random()*10)+1;
			y=(int)(Math.random()*10)+1;
			l=(int)(Math.random()*3)+1;
			if(l==1)
			{
				System.out.println("Input "+x+"+"+y);
				ans=sc.nextInt();
				if( ans!=(x+y) )
				{
					cor=false;
					System.out.println("Input error");
					
				}
							
			}
			else if(l==2)
			{
				System.out.println("Input "+x+"-"+y);
				ans=sc.nextInt();
				if( ans!=(x-y) )
				{
					cor=false;
					System.out.println("Input error");	
				}							
			}
			else if(l==3)
			{
				System.out.println("Input "+x+"*"+y);
				ans=sc.nextInt();
				if( ans!=(x*y) )
				{
					cor=false;
					System.out.println("Input error");
					
				}				
			}	
		}
				
}		
				
		Scanner load=null;
		try {
			
		  load=new Scanner(new FileInputStream("code.txt"));	
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not exists");
			System.exit(0);	
		}
		String account=load.next();
		String password=load.next();
		
		String ss1=null;
		String ss2=null;
		System.out.println("Input account");
		ss1=sc.next();
		System.out.println("Input password");
		ss2=sc.next();
		
		if(ss1.equals(account) && ss2.equals(password))
		{
			System.out.println("Login success");
		}	
		else
		{
			System.out.println("Login fail! try again ");
		    login();
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	public void book()
	{
		Scanner sc=null;
		Book data=null;
		
		try {
			
		  sc=new Scanner(new FileInputStream("book.txt"));	
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not exists");
			System.exit(0);	
		}
		
		
		String s1=null,s2=null;
		s1=sc.nextLine();
		s1=sc.nextLine();
		
		
		while( sc.hasNext())
		{
			s2=sc.nextLine();
			Scanner sc1=new Scanner(s2);
			
			int count=0;
			
			while(sc1.hasNext())
			{
				read.add(sc1.next());
				count++;			
			}
			count=count-5;
			String n=null,b=null,nu=null,ca=null,e=null;
			int k=0;
			for(k=0;k<=count;k++)
			{
				if(k==0)
				{
					n=read.get(k);			
				}
				else
				{
					n=n+read.get(k);	
				}
				
				n=n+" ";
			}
			n=n.trim();
			b=read.get(k++);
			nu=read.get(k++);
			ca=read.get(k++);
			e=read.get(k);
			read.clear();
			data=new Book(n,b,nu,ca,e);
			myList.add(data);
			
					
		}
		
		sc.close();		
	}
	
	
	
	public  void  display_all_title()
	{
		System.out.println("Sorting     Name                Birthday      Number        Category Email");		
		System.out.println("---------------------------------------------------------------------------");		
	}
	public  void  display_title()
	{
		
		if(So)
		{	
		System.out.print("Sorting     ");
		}
		if(Na)
		{	
		System.out.print(" Name                ");
		}
		if(Bi)
		{
		System.out.print("Birthday      ");
		}
		if(Nu)
		{
			System.out.print("Number      ");	
		}
		if(Cat)
		{
			System.out.print("Category ");	
		}
		if(E)
		{
			System.out.print("E-mail               ");	
		}
		System.out.println("---------------------------------------------------------------------------");		
	}
	
	
	public  void display_elements(int i)
	{
	   if(So)
	   System.out.print( (i+1)+"          ");	
	   if(Na)
	   System.out.printf("%-20s",myList.get(i).getN());
	   if(Bi)
	   System.out.printf("%-14s",myList.get(i).getB());
	   if(Nu)
	   System.out.printf("%-14s",myList.get(i).getNu());
	   if(Cat)
	   System.out.printf("%-9s",myList.get(i).getCat());
	   if(E)
	   System.out.printf("%-21s",myList.get(i).getE());
	   System.out.println();
	}
	
	public  void display_all_elements(int i)
	{
	   System.out.print( (i+1)+"          ");	
       System.out.printf("%-20s",myList.get(i).getN());
       System.out.printf("%-14s",myList.get(i).getB());
       System.out.printf("%-14s",myList.get(i).getNu());
       System.out.printf("%-9s",myList.get(i).getCat());
       System.out.printf("%-21s",myList.get(i).getE());
       System.out.println();
	}
	
	
	
	
	
	public void display_all()
	{
		String s1=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("please input the function");
		System.out.println("A.ascending(Birthsay) all B.descending(Birthday) C.last page ");
		s1=sc.next();	
		while(true)
		{
			if(s1.equalsIgnoreCase("A"))
			{
		        sort_data3();	    
				break;
			}
			else if(s1.equalsIgnoreCase("B"))
			{
				sort_data4();
			}
			else if(s1.equalsIgnoreCase("C"))
			{
				display();
			}					
			else	
			{
				System.out.println("Error!please input the function");
				System.out.println("A.ascending(Birthsay) all B.descending(Birthday) C.last page ");
				s1=sc.next();	
			}
		}		
		display_all_title();
		int count=0;
		
		for(int i=0;i<myList.size();i++)
		{
			display_all_elements(order.get(i));
			count++;
			
			if(count%page==0)
			{
				System.out.println("please input the function");
				System.out.println("A.nextpage all B.leave ");
				s1=sc.next();	

				while(true)
				{
					if(s1.equalsIgnoreCase("A"))
					{
						break;
					}
					else if(s1.equalsIgnoreCase("B"))
					{
						user();						
					}
					else
					{
						System.out.println("Error!please input the function");
						System.out.println("A.nextpage all B.leave ");
						s1=sc.next();							
					}			
				}
				
				
			}
			
			
			
			
		}
		
	}
		
	public void user()
	{
				Scanner sc=new Scanner(System.in);
		System.out.println("please input the function");
		System.out.println("A.add data B.search C.modify D.delete E.display F.last page ");
		String s1=sc.next();	
		while(true)
		{
			if(s1.equalsIgnoreCase("A"))
			{
			    //	add_book();
				
			}
			else if(s1.equalsIgnoreCase("B"))
			{
				//  search();
			}
			else if(s1.equalsIgnoreCase("C"))
			{
				// edit();
			}			
			else if(s1.equalsIgnoreCase("D"))
			{
				// delete();
			}	
			else if(s1.equalsIgnoreCase("E"))
			{
				display();
			}	
			else if(s1.equalsIgnoreCase("F"))
			{
				welcome();
			}			
			else	
			{
				System.out.println("Error!please input the function");
				System.out.println("A.add data B.search C.modify D.delete E.display F.last page ");
			     s1=sc.next();			
			}
		}	
	}
	public void display()
	{
				Scanner sc=new Scanner(System.in);
		System.out.println("please input the function");
		System.out.println("A.display all B.display catogory C.last page ");
		String s1=sc.next();	
		while(true)
		{
			if(s1.equalsIgnoreCase("A"))
			{
			    display_all();
				user();
			}
			else if(s1.equalsIgnoreCase("B"))
			{
				//display_tupe();
			}
			else if(s1.equalsIgnoreCase("C"))
			{
				user();
			}					
			else	
			{
				System.out.println("Error!please input the function");
				System.out.println("A.display all B.display catogory C.last page ");
			     s1=sc.next();			
			}
		}		
	}
	
	
	
	void sort_data1()
	{
		for(int i=0; i<=myList.size()-2; i++)
		{
			for(int j=0;j<=myList.size()-2-i;j++)
			{
	                  if( myList.get(j).getm() > myList.get(j+1).getm())			
	                  {
	                	  Collections.swap(myList, j, j+1);
	                  }
	                  else if( (myList.get(j).getm() ==  myList.get(j+1).getm() )   && (myList.get(j).getd() > myList.get(j+1).getd()))    
	                  {
	                	  Collections.swap(myList, j, j+1);
	                  }
			}       
			
		}
		
	}
	
	void sort_data2()
	{
		sort_data1();
		Collections.reverse(myList);		
	}
	
	
	void sort_data3()
	{
		order.clear();
		myList2.clear();
		
		for(int i=0;i<myList.size();i++)
		{
			order.add(i);
		}
		for(int i=0;i<myList.size();i++)
		{
			myList2.add(myList.get(i));
		}
		
		
		for(int i=0; i<=myList2.size()-2; i++)
		{
			for(int j=0;j<=myList2.size()-2-i;j++)
			{
	                  if( myList2.get(j).getm() > myList2.get(j+1).getm())			
	                  {
	                	  Collections.swap(myList2, j, j+1);
	                	  Collections.swap(order, j, j+1);
	                  }
	                  else if( (myList2.get(j).getm() ==  myList2.get(j+1).getm() )   && (myList2.get(j).getd() > myList2.get(j+1).getd()))    
	                  {
	                	  Collections.swap(myList2, j, j+1);
	                	  Collections.swap(order, j, j+1);
	                  }
			}       
			
		}
		
	}
	
	void sort_data4()
	{
		sort_data1();
		Collections.reverse(order);		
	}
	
	public void adm()
	{
				Scanner sc=new Scanner(System.in);
		System.out.println("please input the function");
		System.out.println("A.set Catogory B.set page C.add new catogory D.resshuflfle data E.identificatiob F.last page ");
		String s1=sc.next();	
		while(true)
		{
			if(s1.equalsIgnoreCase("A"))
			{
			    set_cat();	
				adm();
			}
			else if(s1.equalsIgnoreCase("B"))
			{
				setpage();
				adm();
			}
			else if(s1.equalsIgnoreCase("C"))
			{
				new_cat();
				adm();
			}			
			else if(s1.equalsIgnoreCase("D"))
			{
				store_book();
				adm();
			}	
			else if(s1.equalsIgnoreCase("E"))
			{
				setmode();
				adm();
			}	
			else if(s1.equalsIgnoreCase("F"))
			{
				welcome();
			}			
			else	
			{
				System.out.println("Error!please input the function");
				System.out.println("A.set Catogory B.set page C.add new catogory D.resshuflfle data E.identificatiob F.last page ");
			     s1=sc.next();			
			}
		}	
	}
	
	public void set_cat()
	{
	
	   PrintWriter set_w=null;
		
		try {
			
		  set_w=new PrintWriter(new FileOutputStream("set.txt"));	
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not exists");
			System.exit(0);	
		}		
	
		Scanner sc=new Scanner(System.in);
		System.out.println("please input Sorting(Y/N)");
		String s1=sc.next();	
		while(true)
		{
			if(s1.equalsIgnoreCase("Y"))
			{
	            So=true;
	            set_w.print("Y"+" ");
	            break;
			}
			else if(s1.equalsIgnoreCase("N"))
			{
				So=false;
	            set_w.print("N"+" ");
	            break;
			}
			else
			{
				System.out.println("Error!please input Sorting(Y/N)");
				s1=sc.next();			
			}			
		}
		
		System.out.println("please input Name(Y/N)");
		s1=sc.next();	
		while(true)
		{
			if(s1.equalsIgnoreCase("Y"))
			{
	            Na=true;
	            set_w.print("Y"+" ");
	            break;
			}
			else if(s1.equalsIgnoreCase("N"))
			{
				Na=false;
	            set_w.print("N"+" ");
	            break;
			}
			else
			{
				System.out.println("Error!please input Name(Y/N)");
				s1=sc.next();			
			}			
		}
		//
		System.out.println("please input Birthday(Y/N)");
		s1=sc.next();	
		while(true)
		{
			if(s1.equalsIgnoreCase("Y"))
			{
	            Bi=true;
	            set_w.print("Y"+" ");
	            break;
			}
			else if(s1.equalsIgnoreCase("N"))
			{
				Bi=false;
	            set_w.print("N"+" ");
	            break;
			}
			else
			{
				System.out.println("Error!please input Birthdat(Y/N)");
				s1=sc.next();			
			}			
		}
		//
		System.out.println("please input Number(Y/N)");
		s1=sc.next();	
		while(true)
		{
			if(s1.equalsIgnoreCase("Y"))
			{
	            Nu=true;
	            set_w.print("Y"+" ");
	            break;
			}
			else if(s1.equalsIgnoreCase("N"))
			{
				Nu=false;
	            set_w.print("N"+" ");
	            break;
			}
			else
			{
				System.out.println("Error!please input Number(Y/N)");
				s1=sc.next();			
			}			
		}
		//
		System.out.println("please input Catogory(Y/N)");
		s1=sc.next();	
		while(true)
		{
			if(s1.equalsIgnoreCase("Y"))
			{
	            Cat=true;
	            set_w.print("Y"+" ");
	            break;
			}
			else if(s1.equalsIgnoreCase("N"))
			{
				Cat=false;
	            set_w.print("N"+" ");
	            break;
			}
			else
			{
				System.out.println("Error!please input type(Y/N)");
				s1=sc.next();			
			}			
		}
		//
		System.out.println("please input E-mail(Y/N)");
		s1=sc.next();	
		while(true)
		{
			if(s1.equalsIgnoreCase("Y"))
			{
	            E=true;
	            set_w.print("Y"+" ");
	            break;
			}
			else if(s1.equalsIgnoreCase("N"))
			{
				E=false;
	            set_w.print("N"+" ");
	            break;
			}
			else
			{
				System.out.println("Error!please input e-mail(Y/N)");
				s1=sc.next();			
			}			
		}
		
		set_w.close();	
	}
	
	 public void store_book()
	 {
	      
		 String s1=null;
			Scanner sc=new Scanner(System.in);
			System.out.println("please input the function");
			System.out.println("A.ascending(Birthsay) all B.descending(Birthday) C.last page ");
			s1=sc.next();	
			while(true)
			{
				if(s1.equalsIgnoreCase("A"))
				{
			        sort_data1();	    
					break;
				}
				else if(s1.equalsIgnoreCase("B"))
				{
					sort_data2();
				}
				else if(s1.equalsIgnoreCase("C"))
				{
					display();
				}					
				else	
				{
					System.out.println("Error!please input the function");
					System.out.println("A.ascending(Birthsay) all B.descending(Birthday) C.last page ");
					s1=sc.next();	
				}
			}			 
		 PrintWriter b_w=null;
   		 try {
				
			  b_w=new PrintWriter(new FileOutputStream("bbbk.txt"));	
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not exists");
				System.exit(0);	
			}		
		    b_w.println("Sorting     Name                Birthday      Number        Category Email");		
			b_w.println("---------------------------------------------------------------------------");		
			for(int i=0;i<myList.size();i++)
			{	
			b_w.print( (i+1)+"          ");	
		    b_w.printf("%-20s",myList.get(i).getN());
		    b_w.printf("%-14s",myList.get(i).getB());
		    b_w.printf("%-14s",myList.get(i).getNu());
		    b_w.printf("%-9s",myList.get(i).getCat());
		    b_w.printf("%-21s",myList.get(i).getE());
		    b_w.println();
			}
			b_w.close(); 
	 }
		
	public void new_cat()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("please input new catogory");
		String s1=sc.next();	
		type.add(s1);
		
		
		PrintWriter cat_w=null;
		
		try {
			
		  cat_w=new PrintWriter(new FileOutputStream("cat.txt",true));	
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not exists");
			System.exit(0);	
		}
		
		cat_w.print(" "+s1);
		cat_w.close();	
	}
	
	public void setpage()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("please input the page");
		int s1=sc.nextInt();	
		page=s1;
		
		
		PrintWriter pa_w=null;
		
		try {
			
		  pa_w=new PrintWriter(new FileOutputStream("page.txt"));	
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not exists");
			System.exit(0);	
		}
		
		pa_w.print(s1);
		pa_w.close();	
	}
	

	public void setmode()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("please input the mode");
		System.out.println("A.mode1  B.mode2");
		String s1=sc.next();	
		
		
		while(true)
		{
			if(s1.equalsIgnoreCase("A"))
			{
		      mode=1;		
		      break;
			}
			else if(s1.equalsIgnoreCase("B"))
			{
				mode=2;
				break;
			}
			else
			{
				System.out.println("please input the mode");
				System.out.println("A.mode1  B.mode2");
				s1=sc.next();
			}			
		}
		
			
		PrintWriter m_w=null;
		
		try {
			
		  m_w=new PrintWriter(new FileOutputStream("page.txt"));	
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not exists");
			System.exit(0);	
		}
		
		m_w.print(mode);
		m_w.close();	
	}
	
	
	
	
	
	
	
	
	
}
