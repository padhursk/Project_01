package assignmentWeek2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LeadCreation2 {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager"); 
		driver.findElement(By.id("password")).sendKeys("crmsfa"); 
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Padmini");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");

		WebElement pick = driver.findElement(By.id("createLeadForm_dataSourceId"));
	    Select op=new Select(pick);
		op.selectByVisibleText("Employee");
		
	    WebElement market = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select obj=new Select(market);
		obj.selectByValue("9001");
		
		WebElement own = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select owner=new Select(own);
		owner.selectByIndex(5);
		
		Thread.sleep(200);
		
		WebElement count = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select country=new Select(count);
		country.selectByValue("IND");
		Thread.sleep(200);
		
		driver.findElement(By.name("submitButton")).click();
		
		Thread.sleep(2000);
		
		String data="View Lead | opentaps CRM";
		String title = driver.getTitle();
		if(title.equals(data)) {
	    System.out.println("verified");
		}
	      
		
		
	}

}
