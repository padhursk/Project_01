package assignment_week4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learnwindowhandles {
	
/*Window handles Assignment
=========================*/


	public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf$1234");
		driver.findElement(By.xpath("//input[contains(@class,'button')]")).click();
	    Thread.sleep(2000);
	    
	    //click on the learn more option in the Mobile publisher
	    driver.findElement(By.xpath("//span[text()='Learn More']")).click();
	     
	    //Switch to the next window using Windowhandles. 
	    Set<String> wh = driver.getWindowHandles();
	    // System.out.println(wh);
	    
	    List<String> child=new ArrayList<String>(wh);
	    driver.switchTo().window(child.get(1));
	    
	    //click on the confirm button in the redirecting page
	    driver.findElement(By.xpath("//button[text()='Confirm']")).click();
	    
	    Thread.sleep(500);
	    
	    //get the title
	    String title = driver.getTitle();
	    System.out.println("title of the parent window"+title);
	    
	    Thread.sleep(500);	  
	    //Get back to the parent window
	    driver.switchTo().window(child.get(0));
	    
	    //close the browser
	    driver.quit();
       // driver.close();
        
        
        
	}

}
