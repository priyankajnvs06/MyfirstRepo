package thisTest;

public class ConstructorTest 
{ 
		int rollno;
		int age;
		String name;
		ConstructorTest(int rollno,int age, String name)
		{
			this.rollno=rollno;
			this.age=age;
			this.name=name;
		}
	void display()
	{ 
		System.out.println(rollno+" "+age+" "+name);
	}

	public static void main(String[] args)
	{
		ConstructorTest ct= new ConstructorTest(25,10,"priyanka");
		ct.display();
	}

}
