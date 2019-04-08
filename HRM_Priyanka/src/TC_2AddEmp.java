import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import org.openqa.selenium.*;

public class TC_2AddEmp 
{
	public static void main(String args[]) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\PRIYANKA\\Drivers\\chromedriver.exe");
		WebDriver dri=new ChromeDriver();
		//////// open hrm home page
		dri.get("http://apps.qaplanet.in/hrm/login.php");
		WebDriverWait wait=new WebDriverWait(dri,60);
		wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		//verify home page
		
		if(dri.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Home page is dispalyed with title");
		}
        //wait for presence of element
		/*wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));*/
		//.................................
		Thread.sleep(2000);
		
		WebElement un=dri.findElement(By.name("txtUserName"));//user name
		WebElement pa=dri.findElement(By.name("txtPassword"));//password
		WebElement login=dri.findElement(By.name("Submit"));//login
		WebElement cl=dri.findElement(By.name("clear"));//clear
		
		//..check user ,pass,login and clear field is displayed
		if(un.isDisplayed()&&pa.isDisplayed()&&login.isDisplayed()&&cl.isDisplayed())
		{
			System.out.println("HOme page is displayed");
		}
		
		/////2.Enter usrername and password
		un.sendKeys("qaplanet1");
		pa.sendKeys("lab1");
		login.click();
		wait.until(ExpectedConditions.titleIs("OrangeHRM"));
		
		//...........On Second Page........................
		if(dri.getTitle().equals("OrangeHRM"));
		{
			System.out.println("Orange HRM  page is displayed");
		}
		String str=dri.findElement(By.xpath("/html/body/div[3]/ul/li[1]")).getText();
		if(str.equals("Welcome"+un))
		{
			System.out.println("Welcome text is dispalyed");
		}
		WebElement chapas=dri.findElement(By.linkText("Change Password"));
        WebElement Logout=dri.findElement(By.linkText("Logout"));
        if(chapas.isDisplayed()&&Logout.isDisplayed())
        {
        	System.out.println("change pass and logout is displayed");
        }
        
        //move to mouse and.click on add employee
        Actions act=new Actions(dri);
        WebElement pim=dri.findElement(By.id("pim"));
        act.moveToElement(pim).perform();//to move the mouse
        WebElement addEmp=dri.findElement(By.xpath("/html/body/div[4]/ul/li[2]/ul/li[2]/a"));
        addEmp.click();//To click on add emp
        //switch to frame
        dri.switchTo().frame("rightMenu");
       /* if(dri.findElement(By.xpath("//div[@class='mainHeading']/descendant::h2")).getText().equals("PIM : Add Employee"))
        {
    	   System.out.println(" add employee page verified successfully");
        }
        Thread.sleep(1000);*/
        //.keep all fields blank and click save
       // WebElement save=dri.findElement(By.id("btnEdit"));//find save
        Thread.sleep(1000);
        WebElement save=dri.findElement(By.xpath("//input[@id='btnEdit']"));//find save
        save.click();
        Thread.sleep(1000);
        //Alert a=wait.until(ExpectedConditions.alertIsPresent());
        if(dri.switchTo().alert().getText().equals("Last Name Empty!"))
        {
      	  System.out.println("last name alert messg is checked");
      	  dri.switchTo().alert().accept();
        }
        
        

        WebElement e=dri.findElement(By.xpath("//div[@class='maincontent']/descendant::input"));
        String empcode=e.getAttribute("value");
        System.out.println(empcode+"at line 96");
        String lstnm="Planet";
        String frstnm="Qa";
        
       
       Thread.sleep(1000);
      //Enter last name and click save 
      WebElement lastname=dri.findElement(By.id("txtEmpLastName"));
      lastname.sendKeys(lstnm);
      save.click();
      Thread.sleep(1000);
      //handle alert
      wait.until(ExpectedConditions.alertIsPresent());
      dri.switchTo().alert();
      //verify alert message
      
      // Enter user name and click save.....................................
      //or wait statement
      
      // verify first name alert.................................
      Alert a2=wait.until(ExpectedConditions.alertIsPresent());
      if(dri.switchTo().alert().getText().equals("First Name Empty!"))
      {
  	  System.out.println(" first name alert messg is checked");
  	  dri.switchTo().alert().accept();
      }
      // enter first name and click save.
      WebElement frstname=dri.findElement(By.name("txtEmpFirstName"));
      frstname.sendKeys(frstnm);
      save.click();
      ///way1.................
      Thread.sleep(1002);
      String EmpDe=dri.findElement(By.xpath("/html/body/form/div[2]/div[1]/div[2]/div[1]/h2")).getText();
      if(EmpDe.equals("Personal Details"))
      {
    	  System.out.println("Personal detail page is verified");
      }
     
      
      // way2............... 
      /*wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("/html/body/form/div[2]/div[1]/div[2]/div[1]/h2"),"Personal Details"));
      System.out.println("77777");
      if(wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("/html/body/form/div[2]/div[1]/div[2]/div[1]/h2"),"Personal Details")).equals("Personal Details"))
      {
    	  System.out.println("personal detail page is displayeed");
      }
     */
      Thread.sleep(1000);
     dri.switchTo().defaultContent();
     WebElement pimmain=dri.findElement(By.id("pim"));
     System.out.println(pimmain.getText());
     act.moveToElement(pimmain).perform();
     //dri.findElement(By.xpath("//li[@id='pim']/ul/li/a")).click();
    // dri.findElement(By.xpath("//*[@id='pim']/ul/li[1]/a")).click();
     dri.findElement(By.xpath("//ul[@id='nav']/li[2]/ul/li[1]/a")).click();
     Thread.sleep(1000);
     dri.switchTo().frame("rightMenu");
     //	to find the data of particular empcode
     
     int rc=dri.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
     System.out.println(rc);
     int i;
     for(i=1;i<=rc;i++)
     {
 	        String EmplId=dri.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
 	        String sEmpName=dri.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
 	        System.out.println(sEmpName+" having Employee id is "+EmplId);
     } 
     
     dri.switchTo().parentFrame();
     dri.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
     wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		//verify home page
		if(dri.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("signoff successfully");
			System.out.println("Home page is dispalyed with title");
		}
     dri.close();
}
	}
