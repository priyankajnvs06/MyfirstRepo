package thisTest;

public class ThisConstructor 
{
	int rollno;
	String name;
	boolean t;
	
	void m2(String name,int rollno,boolean t)
	{
		name=name;
		rollno=rollno;
		t=t;
		
		System.out.println(rollno+" "+name+" "+t);
		
	}
	/*ThisConstructor(int a,int b)
	{
		System.out.println("Hello World");
		System.out.println(a+b);
	}
	ThisConstructor(int x)
	{
		//this(10,20);
		System.out.println(x);
	}*/

	public static void main(String[] args) 
	{  
		ThisConstructor tc2= new ThisConstructor();
		ThisConstructor tc3= new ThisConstructor();
		
		tc2.m2("Priyanka",25,false);
		tc3.m2("kumari",26,true);

	}

}
