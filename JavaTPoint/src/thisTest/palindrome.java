package thisTest;

public class palindrome 
{
 public static void main(String[] args)
 {
	 char s[]={'a','b','c','b','o'};
  int i,j; int flag=0;
  for(i=0;i<s.length;i++)
  {
	
		for(j=s.length-1;j>=i;j--) 
		{
		 if(s[i]==s[j])
		 { 
			 flag=1;
			 break;
			
		 }
		 
		 System.out.println(s[i]+"= "+s[j]);
		System.out.println("string is palindrone"); 
		 
		
		}
  }
}
}