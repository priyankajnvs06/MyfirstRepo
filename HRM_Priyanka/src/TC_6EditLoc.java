import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_6EditLoc {

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
		dri.findElement(By.xpath("//form/div/div/input")).click();
		dri.findElement(By.id("txtLocDescription")).sendKeys("huderabad");
		WebElement lis=dri.findElement(By.id("cmbCountry"));
		Select sel=new Select(lis);
		sel.selectByVisibleText("India");
		dri.findElement(By.id("txtAddress")).sendKeys("yfeedyceksj");
		dri.findElement(By.id("txtZIP")).sendKeys("546467378");
		WebElement save=dri.findElement(By.id("editBtn"));
		save.click();
		
	}

}
