package assignmentWeek2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager"); 
		driver.findElement(By.id("password")).sendKeys("crmsfa"); 
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Zoho");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Padmini");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Mini");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Automationtesting");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("mini@gmail.com");
		WebElement drop = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select op=new Select(drop);
		op.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Mandatory");
		driver.findElement(By.className("smallSubmit")).click();
		
	}

}
