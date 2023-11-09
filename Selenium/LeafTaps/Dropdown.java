package assignmentWeek2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://www.leafground.com/select.xhtml ");
		
		driver.manage().window().maximize();
		 
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement tool = driver.findElement(By.className("ui-selectonemenu"));
		Select obj=new Select(tool);
		obj.selectByVisibleText("Selenium");
		
		driver.findElement(By.xpath("//label[text()='Select Country']")).click();
		driver.findElement(By.xpath("//li[text()='India']")).click();
		
		Thread.sleep(6000);
		
		
		driver.findElement(By.xpath("//label[text()='Select City']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[text()='Chennai']")).click();

		driver.findElement(By.xpath("//button[contains(@class,'ui-autocomplete-dropdown')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//li[text()='Selenium WebDriver']")).click();
		
	
		
		driver.findElement(By.xpath("//label[text()='Select Language']")).click();
		driver.findElement(By.xpath("//li[text()='English']")).click();
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//label[text()='Select Values']")).click();
		driver.findElement(By.xpath("//li[text()='Two']")).click();
		
		
		Thread.sleep(2000);
		driver.close();
		
		
		
		

	}

}
