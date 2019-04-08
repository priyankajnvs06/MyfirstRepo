import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleBrowser 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver dri=new FirefoxDriver();
		dri.get("http://qaplanet.in");
		Thread.sleep(4000);
		WebDriverWait wait=new WebDriverWait(dri,2000);
		WebElement x=dri.findElement(By.xpath("/html/body/div[2]/div/button"));
		x.click();
		System.out.println("....................");
		
		WebElement we=dri.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/ul/li[5]/a/img"));
		System.out.println("....................");
		we.click();
		Set<String> id=dri.getWindowHandles();
		for(String ids: id)
		{
			System.out.println("id");
		}

		Iterator<String> itr=id.iterator();
		String first_id=itr.next();
		String sec_id=itr.next();
		dri.switchTo().window(sec_id);
		
		dri.findElement(By.id("h_login"));
		dri.close();
		

	}

}
