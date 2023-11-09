package assignment_week4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator & Accept the Alert
	     * 
		 * 13. Verify the title of the page*/
		
		ChromeOptions Os=new ChromeOptions();
		Os.addArguments("--disable-notifications"); 
		ChromeDriver driver= new ChromeDriver(Os);
		
		driver.get("http://leaftaps.com/opentaps/control/main");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager"); 
		driver.findElement(By.id("password")).sendKeys("crmsfa"); 
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
		Thread.sleep(1000);
		Set<String> child = driver.getWindowHandles();
		List<String> allLinks=new ArrayList<String>(child);
		driver.switchTo().window(allLinks.get(1));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]//a")).click();
		
		driver.switchTo().window(allLinks.get(0));
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		
		Thread.sleep(1000);
		Set<String> child2 = driver.getWindowHandles();
		List<String> allLink=new ArrayList<String>(child2);
		driver.switchTo().window(allLink.get(1));
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-col-partyId')])[2]//a")).click();
		driver.switchTo().window(allLink.get(0));
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Thread.sleep(1000);
		Alert pop = driver.switchTo().alert();
		pop.accept();
		Thread.sleep(1000);
		String A = "Merge Contacts | opentaps CRM";
		String title = driver.getTitle();
		System.out.println(title);
		
		if (title.equalsIgnoreCase(A)) {
			System.out.println("The title is verified");
		}
		else {
			System.out.println("The title is not verified");
		}
		Thread.sleep(1000);
		driver.quit();
	}

}
