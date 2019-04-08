import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_3EditEmp 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver dri=new FirefoxDriver();
		//////// open hrm home page
		dri.get("http://apps.qaplanet.in/qahrm/login.php");
		WebDriverWait wait=new WebDriverWait(dri,60);
		wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		//verify home page
		if(dri.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Home page is dispalyed with title");
		}
        //wait for presence of element
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
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
        //..................click on add employee
        Actions act=new Actions(dri);
        WebElement pim=dri.findElement(By.id("pim"));
        act.moveToElement(pim).perform();//to move the mouse
        WebElement addEmp=dri.findElement(By.xpath("/html/body/div[4]/ul/li[2]/ul/li[2]/a/span"));
        addEmp.click();//To click on add emp
        Thread.sleep(3000);
        //switch to frame
        dri.switchTo().frame("rightMenu");
        String lstnm="Planet";
        String frstnm="Qa";
       //Enter last name and first name, click save 
        WebElement lastname=dri.findElement(By.id("txtEmpLastName"));
        lastname.sendKeys(lstnm);
        WebElement frstname=dri.findElement(By.name("txtEmpFirstName"));
        frstname.sendKeys(frstnm);
        WebElement save=dri.findElement(By.xpath("//input[@id='btnEdit']"));//find save
        save.click();
        ///way1.................
        Thread.sleep(2002);
        String EmpDe=dri.findElement(By.xpath("/html/body/form/div[2]/div[1]/div[2]/div[1]/h2")).getText();
        if(EmpDe.equals("Personal Details"))
        {
        	System.out.println("Personal detail page is verified");
        }
        WebElement we1=dri.findElement(By.name("EditMain"));
        we1.click();//click on Edit
        //working with checkbox.............
        dri.findElement(By.xpath("/html/body/form/div[2]/div[1]/div[2]/label[12]")).click();
        dri.findElement(By.id("gender2")).click();//select female
	
	
      //Ethenic race checkbox..........
      WebElement we2=dri.findElement(By.id("cmbEthnicRace"));
      Select sel=new Select(we2);
      int sofethrace=sel.getOptions().size();//size of race dropdown
    
      for(int j=0;j<sofethrace;j++)
      {
    	  System.out.println(sofethrace);	
      }
        WebElement edfirstname=dri.findElement(By.name("txtEmpFirstName"));
      	edfirstname.clear();//clear the first name
		edfirstname.sendKeys("Gita");//enter first name again
		WebElement edlastNmae=dri.findElement(By.name("txtEmpLastName"));
		edlastNmae.clear();//clear the last name
		edlastNmae.sendKeys("Sharma");//enter last name
		///////
			dri.findElement(By.id("btnEditPers")).click();//click on save
	
	      dri.switchTo().parentFrame();
	      dri.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	      wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
	      //verify home page
	      if(dri.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Home page is dispalyed with title");
		}
	      dri.close();

}}
