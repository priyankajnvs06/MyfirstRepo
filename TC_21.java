

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TC_21 
{
   public static void main(String[] args)throws InterruptedException {
	

	//ChromeDriver Driver=new ChromeDriver();
	   System.setProperty("webdriver.chrome.driver", "E:\\PRIYANKA\\Drivers\\chromedriver.exe");
	WebDriver Driver=new ChromeDriver();
	//Maximize browser

	//-------------------------------------------
	//wait object
	WebDriverWait wait=new WebDriverWait(Driver, 60);
	//Action class object
	Actions Act=new Actions(Driver);
	//----------------------------------------------
	//Open application
	Driver.get("http://apps.qaplanet.in/hrm/login.php");
	//wait forhome page
	wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
	//Verify home page displayed or not
	if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
	{
		System.out.println("Home Page Displayed");
	}
	else
	{
		System.out.println("Failed to display");
	}
	//--------------------------------------------------------------
	//Create webelement
	WebElement objUN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
	WebElement objPWD=Driver.findElement(By.name("txtPassword"));
	WebElement objLogin=Driver.findElement(By.name("Submit"));
	WebElement objClear=Driver.findElement(By.name("clear"));
	//------------------------------------------------------------
	//Verify user name
	if(objUN.isDisplayed())
	{
		System.out.println("User name displayed");
	}
	//Verify password
	if(objPWD.isDisplayed())
	{
		System.out.println("Password displayed");
	}
	//Verify login and clear
	if(objLogin.isDisplayed() && objClear.isDisplayed())
	{
		System.out.println("Login and clear buttons are displayed");
	}
	//------------------------------------------------------------------
	String sUN="qaplanet1";
	String sPWD="lab1";
	//----------------------Login to orangeHRM-------------------------------------------
	//Enter user name
	objUN.clear();
	objUN.sendKeys(sUN);
	//Enter password
	objPWD.clear();
	objPWD.sendKeys(sPWD);
	//Click on login
	objLogin.click();
	//wait for orangehrm page
	wait.until(ExpectedConditions.titleIs("OrangeHRM"));
	//Verify orangeHRM page
	if(Driver.getTitle().equals("OrangeHRM"))
	{
		System.out.println("OrangeHRM displayed");
	}
	else
	{
		System.out.println("Failed to login");
	}
	//Get welecome text
	String sWelText=Driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
	//Verify welcome text
	if(sWelText.equals("Welcome "+sUN))
	{
		System.out.println("Welcome "+sUN+" displayed");
	}
	//way 2 : verify only user name
	String[] Arr=sWelText.split(" ");
	if(Arr[1].equals(sUN))
	{
		System.out.println(sUN+" displayed");
	}
	//-----------------------------------------------------------------------
	WebElement objCP=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Change Password")));
	WebElement objLogout=Driver.findElement(By.linkText("Logout"));
	if(objCP.isDisplayed() && objLogout.isDisplayed())
	{
		System.out.println("Change Password and Logout displayed");
	}
	//-----------------------------------------------------------------------------
	//Create webelement for PIM
	WebElement objPIM=Driver.findElement(By.id("pim"));
	//Mouse over on pim
	Act.moveToElement(objPIM).perform();
	//Click on add employee
	Driver.findElement(By.linkText("Add Employee")).click();
	//wait 2 sec
	Thread.sleep(2000);
	//switch to frame
	Driver.switchTo().frame("rightMenu");
	//-------------------------------------------------------------------
	//Verify PIM : Add Employee text
	if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("PIM : Add Employee"))
	{
		System.out.println("PIM : Add Employee displayed");
	}
	//-----------------------------------------------------------------
	String sFN="QA";
	String sLN="Planet";
	//-----------------------------------------------------------------
	//Get employee code
	String sEmpCode=Driver.findElement(By.name("txtEmployeeId")).getAttribute("value");
	//Create object for Save
	WebElement objSave=Driver.findElement(By.id("btnEdit"));
	//Click on save
	objSave.click();
	//wait for Last Name Empty! alert 
	Alert A1=wait.until(ExpectedConditions.alertIsPresent());
	//Verify alert message
	if(A1.getText().equals("Last Name Empty!"))
	{
		System.out.println("Last Name Empty! displayed");
		A1.accept();
	}
	//Enter last name
	Driver.findElement(By.name("txtEmpLastName")).sendKeys(sLN);
	//-----------------------------------------------------------------
	//Click on save
	objSave.click();
	//wait for First Name Empty! alert 
	Alert A2=wait.until(ExpectedConditions.alertIsPresent());
	//Verify alert message
	if(A2.getText().equals("First Name Empty!"))
	{
		System.out.println("First Name Empty! displayed");
		A2.accept();
	}		
	//Enter first name
	Driver.findElement(By.name("txtEmpFirstName")).sendKeys(sFN);
	//Click on save
	objSave.click();
	//-------------------------------------------------------
	//wait and verify Personal Details text
	if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"), "Personal Details")))
	{
		System.out.println("Personal Details displayed");
	}
	//switch to parent frame
	Driver.switchTo().parentFrame();
	//-------------------------------------------------------------		
	//Mouse over on pim
	Act.moveToElement(objPIM).perform();
	//Click on Employee List
	Driver.findElement(By.linkText("Employee List")).click();
	//wait 2 sec
	Thread.sleep(2000);
	//switch to frame
	Driver.switchTo().frame("rightMenu");
	//-------------------------------------------------------------------
	//Verify Employee Information text
	if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Employee Information"))
	{
		System.out.println("Employee Information displayed");
	}		
	//Get row count
	int rc=Driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
	System.out.println(rc);
	//.................................................................
	int i;
	for(i=1;i<=rc;i++)
	{
		//Get second column data
		String sEmpID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
		//Get third coulmn data
		String sEmpName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
		

			System.out.println(sEmpID+" ,"+sEmpName+" , displayed at: "+i);
	}
	//switch to default content
	Driver.switchTo().defaultContent();		
	//----------------------------------------------------------------------
	//Click on logout
	objLogout.click();
	//wait 2 sec
	Thread.sleep(2000);
	//Verify home page displayed or not
	if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
	{
		System.out.println("Signoff successfull & Home Page Displayed");
	}
	else
	{
		System.out.println("Failed to Signoff");
	}		
	//-----------------------------------------
	Driver.close();
	
}
}
