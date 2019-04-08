package thisTest;

public class Smallest {

	public static void main(String[] args) 
	{
		/*int a,b,c,d;
		a=-18;
		b=-30;
		c=-100;
		d=-8;
	
		//System.out.println(a<b?a:b);
     if(a<b&&a<c&&a<d)
     	{
    	 System.out.println("min is "+a);
     	}
     else if (b<c&&b<d) 
     {
		System.out.println("min is "+b);
     }
     else if(c<d)
     	{
    	 System.out.println("min is "+c);
    	 } 
     else{System.out.println("min is "+d);}	 
	}
*/ int a[]={5,6,7,4,37,89};
    int i,sum;
    sum=0;
    for(i=0;i<a.length;i++)
    {
    	
    	sum=sum+a[i];
    }
	System.out.println(sum);	
	
	
	
	}
	
}
