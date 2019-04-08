import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_5AddLoc
{

	public static void main(String[] args) throws InterruptedException
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
		//...........On Second Page........................
		Actions act=new Actions(dri);
		WebElement admin=dri.findElement(By.xpath("//li[@id='admin']"));
		act.moveToElement(admin).perform();
		//to verify the  
		List<WebElement> li=dri.findElements(By.xpath("//ul[@id='nav']/li/ul/li/a/span"));
		System.out.println(li.size());
		for(WebElement dropitem:li)
		{
			
			switch(dropitem.getText())
			{
			 case "Company Info":
				 System.out.println("Company info is displayed");
				 break;
			 case "Job":
				 System.out.println("job is displayed");
				 break;
			 case "Qualification":
				 System.out.println("Qualification");
				 break;
			 case "Skills":
				 System.out.println("Skills");
				 break;
			 case "Memberships":
				 System.out.println("Memberships");
				 break;
			 case "Nationality & Race":
				 System.out.println("Nationality & Race");
				 break;
			 case "Users":
				 System.out.println("Users");
				 break;
			 case "Email Notifications":
				 System.out.println("Email Notifications");
				 break;
			 case "Project Info":
				 System.out.println("Project Info");
				 break;
			 case "Data Import/Export":
				 System.out.println("Data Import/Export");
				 break;
			 case "Custom Fields" :
				 System.out.println("Custom Fields");
				 break;
			 default :
					 System.out.println("nothing to display");
				 
				 }
			
		}
		
		act.moveToElement(dri.findElement(By.xpath("//span[contains(text(),'Company Info')]"))).perform();
		List<WebElement> ligen=dri.findElements(By.xpath("//ul[@id='nav']/li/ul/li/ul/li/a/span"));
		for(WebElement dropitem:ligen)
		{
		
			System.out.println(dropitem.getText());
		}
		WebElement loc=dri.findElement(By.xpath("//ul[@id='nav']/li/ul/li/ul/li[2]/a"));
		act.moveToElement(loc).perform();
		loc.click();
		Thread.sleep(1000);
		///swith frame
		dri.switchTo().frame("rightMenu");
		//to verify location page is displayed
		String locEl=dri.findElement(By.xpath("//form[@name='standardView']/div/h2")).getText();
		if(locEl.equals("Company Info : Locations"))
			{
			System.out.println("location page is dispalyed");
			}
		String si=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form/div[@class='mainHeading']/h2"))).getText();
		if(si.equals("Company Info : Locations"))
		{
			System.out.println("Company Info : Locations is displayed");
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionbuttons']/input")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='actionbuttons']/input[2]")));
		//to add locations...click on add
		dri.findElement(By.xpath("//form/div/div/input")).click();
		if(dri.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Company Info : Locations"))
		{
			System.out.println("Company Info page is displayed");
		}
		//keep all field blank and click on save
		WebElement save=dri.findElement(By.id("editBtn"));
		save.click();
		//handle alert
		Alert a=wait.until(ExpectedConditions.alertIsPresent());
		a.accept();
		//enter name and click save
		dri.findElement(By.id("txtLocDescription")).sendKeys("huderabad");
		save.click();
		Alert b=wait.until(ExpectedConditions.alertIsPresent());
		b.accept();
		//enter country and click save
		WebElement lis=dri.findElement(By.id("cmbCountry"));
		Select sel=new Select(lis);
		sel.selectByVisibleText("India");
		save.click();
		Alert c=wait.until(ExpectedConditions.alertIsPresent());
		c.accept();
		//to enter address
		dri.findElement(By.id("txtAddress")).sendKeys("yfeedyceksj");
		save.click();
		Alert d=wait.until(ExpectedConditions.alertIsPresent());
		d.accept();
		//to enter zip
		dri.findElement(By.id("txtZIP")).sendKeys("546467378");
		save.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='messagebar']")));
		
		//go to logout..........................................................
		dri.switchTo().parentFrame();
	      dri.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	      wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
	      //verify home page
	      if(dri.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Home page is dispalyed with title");
		}
	    
		dri.close();
		
	}

}
