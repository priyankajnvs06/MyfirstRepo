package thisTest;

public class Prime {

	public static void main(String[] args) 
	{
	 int a=2;
	 boolean flag=true;
	 if(a==1)
	 {System.out.println("1 is not prime number");
	 }
	 else
	 {
	  for(int i=2;i<=a/2;i++)
	  {
		   if(a%i==0){ 
	       flag=false;
	       break;
		   }
		   
	  }
	  if(flag==false)
	  {
		  System.out.println("Number "+a+" is not prime number");
	  }
	  
	  else{System.out.println("Number "+a+" is prime number");}
	 
	 }
	}
	 

}
