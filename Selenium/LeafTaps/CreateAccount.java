package assignmentWeek2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager"); 
		driver.findElement(By.id("password")).sendKeys("crmsfa"); 
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Accounts']")).click();
		driver.findElement(By.xpath("//a[text()='Create Account']")).click();
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("Debit Limited Account T1");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Automation Tester");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='groupNameLocal']")).sendKeys("Mini");
		driver.findElement(By.xpath("//input[@id='officeSiteName']")).sendKeys("CRM");
		driver.findElement(By.xpath("(//input[@class='inputBox'])[5]")).sendKeys("175000");
		
		Thread.sleep(2000);
		
		WebElement industry = driver.findElement(By.name("industryEnumId"));
		Select obj=new Select(industry);
		obj.selectByValue("IND_SOFTWARE");
		
		WebElement ownership = driver.findElement(By.name("ownershipEnumId"));
		Select op=new Select(ownership);
		op.selectByVisibleText("S-Corporation");
		
		WebElement source = driver.findElement(By.id("dataSourceId"));
		Select one=new Select(source);
		one.selectByValue("LEAD_EMPLOYEE");
		
		
		WebElement market = driver.findElement(By.id("marketingCampaignId"));
		Select ob=new Select(market);
		ob.selectByIndex(7);
		
		WebElement state = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select oj=new Select(state);
		oj.selectByValue("CA");
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		

	}

}
