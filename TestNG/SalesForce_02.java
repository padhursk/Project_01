package marathon_03;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesForce_02 extends BaseClass {
	
	@BeforeTest
	public void setdata() {
	sheetdata="Opportunity";
	}
	@Test (dataProvider = "fetchdata")
	public void runTC02(String Opp, String num) throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Sales",Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(By.xpath("//mark[text()='Sales']")).click();
		WebElement element = driver.findElement(By.xpath("//a[@title='Key Deals Trigger']"));
		driver.executeScript("arguments[0].click();", element);
        
		driver.findElement(By.xpath("//a[@title='Private']")).click();
		WebElement element2 = driver.findElement(By.xpath("(//span[@class='viewAllLabel'])[4]"));
		driver.executeScript("arguments[0].click();", element2);
        
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		//Set<String> set = driver.getWindowHandles();
		//System.out.println(set);
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys(Opp);
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(num);
		Thread.sleep(500);
		WebElement element3 = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[2]"));
		driver.executeScript("arguments[0].click();", element3);
		driver.findElement(By.xpath("//span[@title='New Customer']")).click();
		
		WebElement element4 = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]"));
		driver.executeScript("arguments[0].click();", element4);
		driver.findElement(By.xpath("//span[@title='Partner Referral']")).click();
		
		WebElement element5 = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]"));
		driver.executeScript("arguments[0].click();", element5);
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		
		
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//td[@data-value='2023-08-25']")).click();
		
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		
		
		
		
		
		
		
	}

}
