import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fb_page {

	public static void main(String[] args) {
		WebDriver dri=new FirefoxDriver();
		dri.get("https://www.facebook.com");
		WebDriverWait wait=new WebDriverWait(dri,6000);
		WebElement un=dri.findElement(By.id("email"));
		WebElement pwd=dri.findElement(By.id("pass"));
		WebElement login=dri.findElement(By.xpath("//*[@id='u_0_3']"));
		if(un.isDisplayed()&&pwd.isDisplayed()&&pwd.isDisplayed())
		{
			System.out.println("Facebook page is displayed with user name and password field");
		}
		un.sendKeys("Priyanka jnvs");
		pwd.sendKeys("13671409@Mp");
		login.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));
		String str=dri.getTitle();
		if(str.equals("Facebook"))
		{
			System.out.println("Facebook page is displayed");
		}

	}

}
