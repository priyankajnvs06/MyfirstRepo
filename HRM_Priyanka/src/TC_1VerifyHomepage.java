import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_1VerifyHomepage 
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver dri=new FirefoxDriver();
		
		dri.get("http://apps.qaplanet.in/qahrm/login.php");
		WebDriverWait wait=new WebDriverWait(dri,60);
		wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		
		if(dri.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Home page is dispalyed with title");
		}

		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
		//.................................
		Thread.sleep(2000);
		
		WebElement un=dri.findElement(By.name("txtUserName"));
		WebElement pa=dri.findElement(By.name("txtPassword"));
		WebElement lo=dri.findElement(By.name("Submit"));
		WebElement cl=dri.findElement(By.name("clear"));
		//..check user ,pass,login and clear displayed
		if(un.isDisplayed()&&pa.isDisplayed()&&lo.isDisplayed()&&cl.isDisplayed())
		{
			System.out.println("HOme page is displayed");
		}
	
		un.sendKeys("qaplanet1");
		pa.sendKeys("lab1");
		lo.click();
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
		
		   Logout.click();
		   wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		   
		   if(dri.getTitle().equals("OrangeHRM - New Level of HR Management"))
			{
				System.out.println("Home page is dispalyed with title");
			}
		   
	}

}
