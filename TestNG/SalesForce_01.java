package marathon_03;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesForce_01 extends BaseClass{
    @BeforeTest
	public void setdata() {
	sheetdata="Chatter";
	}
	
	@Test (dataProvider = "fetchdata")
	public void runSaleForce(String Question, String Ans ) throws InterruptedException {
		    driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Content",Keys.ENTER);
            driver.findElement(By.xpath("//mark[text()='Content']")).click();
            WebElement javaElement = driver.findElement(By.xpath("//a[@title='Chatter']"));
            driver.executeScript("arguments[0].click();", javaElement);
            
            Thread.sleep(500);
            
            String chattertitle = driver.getTitle();
            System.out.println(chattertitle);
            
            if (chattertitle.equalsIgnoreCase("Chatter Home | Salesforce")) {
            	System.out.println("The title is verified");
				
			}else {
				System.out.println("The title is not verified");}
            
            driver.findElement(By.xpath("(//span[@class='title'])[3]")).click();
            driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys(Question);
            driver.findElement(By.xpath(" //div[@role='textbox']")).sendKeys(Ans);
            driver.findElement(By.xpath("//button[@title='Click, or press Ctrl+Enter']")).click();
            String text = driver.findElement(By.xpath("//span[text()='What is testNg']")).getText();
            
            if (text.contains("What is testNg")) {
            	System.out.println("verified");
				
			} else {
				System.out.println("Not verified");
			}
            
            
            

}}
