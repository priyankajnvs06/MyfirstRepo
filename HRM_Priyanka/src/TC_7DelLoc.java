import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_7DelLoc {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","E:\\PRIYANKA\\Drivers\\chromedriver.exe");
		WebDriver dri=new ChromeDriver();
		dri.get("http://apps.qaplanet.in/qahrm/login.php");
		WebDriverWait wait=new WebDriverWait(dri,60);
		wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		
		
		//Enter user name and password
		dri.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
		dri.findElement(By.name("txtPassword")).sendKeys("lab1");
		dri.findElement(By.xpath("//input[@name='Submit']")).click();
		wait.until(ExpectedConditions.titleIs("OrangeHRM"));
		//move to admin
		Actions act=new Actions(dri);
		WebElement admin=dri.findElement(By.xpath("//li[@id='admin']"));
		act.moveToElement(admin).perform();
		//move to company info
		act.moveToElement(dri.findElement(By.xpath("//span[contains(text(),'Company Info')]"))).perform();
		//to move on locatiopn and add location
		WebElement loc=dri.findElement(By.xpath("//ul[@id='nav']/li/ul/li/ul/li[2]/a"));
		act.moveToElement(loc).perform();
		loc.click();
		dri.switchTo().frame("rightMenu");
		//find delete and click delete
		dri.findElement(By.xpath("//div[@class='actionbar']/div[@class='actionbuttons']/input[2]")).click();
		Alert alert1=wait.until(ExpectedConditions.alertIsPresent());
		if(alert1.getText().equals("Select at least one record to delete"))
		{
			System.out.println("alert is displayed");
			alert1.accept();
		}
		dri.findElement(By.xpath("/html/body/div/div[2]/form/table/tbody/tr[8]/td[1]/input")).click();
		dri.findElement(By.xpath("//div[@class='actionbar']/div[@class='actionbuttons']/input[2]")).click();
		wait.until(ExpectedConditions.alertIsPresent()).accept();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='messagebar']")));
		dri.switchTo().parentFrame();
	      dri.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	      wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
	      //verify home page
	      if(dri.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Home page is dispalyed with title");
		}
	    
	}

}
