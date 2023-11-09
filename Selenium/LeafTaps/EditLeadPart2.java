package assignmentWeek2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLeadPart2 {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager"); 
		driver.findElement(By.id("password")).sendKeys("crmsfa"); 
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		Thread.sleep(200);
		
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Padmini");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Padmini']")).click();
		
				
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equalsIgnoreCase("View Lead | opentaps CRM")) {
			System.out.println("The title is verified");
		}
		else {
			System.out.println("The title is not verified");
		}
	   driver.findElement(By.xpath("//a[text()='Edit']")).click();
	   WebElement edit = driver.findElement(By.id("updateLeadForm_companyName"));
	   edit.clear();
	   edit.sendKeys("OLAM");
	   
	   driver.findElement(By.className("smallSubmit")).click();
	   
	   
	   
	   /*String data = "OLAM";
	   String title2 = driver.getTitle();
	   if(title2.equals(data)) {
		   System.out.println("Updated");
		  
	   }
	   else {
		   System.out.println("Failed");}
	   */
	
	
	   Thread.sleep(2000);
	   driver.close();
	   }}
	

	
	


