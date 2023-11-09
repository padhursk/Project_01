package assignmentWeek2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
			
			
			ChromeDriver driver= new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.findElement(By.id("username")).sendKeys("Demosalesmanager"); 
			driver.findElement(By.id("password")).sendKeys("crmsfa"); 
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Find Leads")).click();
			
			driver.findElement(By.xpath("//span[text()='Phone']")).click();
			driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9998242806");
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			driver.findElement(By.xpath("//a[text()='Delete']")).click();
			driver.findElement(By.linkText("Find Leads")).click();    //12925
			driver.findElement(By.xpath("//input[@name='id']")).sendKeys("12925");
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			
			//M1
			WebElement findElement = driver.findElement(By.className("x-paging-info"));
			String outtext = findElement.getText();
			System.out.println(outtext);
			
			//System.out.println(driver.findElement(By.className("x-paging-info")).getText());
			
			//M2
			//WebElement findElement = driver.findElement(By.className("x-paging-info"));
			//System.out.println(findElement.getText());
			
			Thread.sleep(5000);
			driver.close();
			
			
	}

}
