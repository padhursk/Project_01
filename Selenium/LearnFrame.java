package assignment_week4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFrame {

	public static void main(String[] args) throws InterruptedException {
		//Frame Assignment
		
		ChromeDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://leafground.com/frame.xhtml;jsessionid=node05us3gij8ed091h38fieurov685953.node0");
	    driver.manage().window().maximize();
	    
	    
	    List<WebElement> list1 = driver.findElements(By.tagName("iframe"));
	    System.out.println(list1.size());
	    
	    driver.switchTo().frame(0);
	    driver.findElement(By.xpath("//button[@id='Click']")).click();
	    System.out.println(driver.findElement(By.xpath("//button[text()='Hurray! You Clicked Me.']")).getText());
	    driver.switchTo().defaultContent();
	    Thread.sleep(2000);
	    
	    driver.switchTo().frame(2);
	    driver.switchTo().frame("frame2");
	    
	    driver.findElement(By.xpath("//button[text()='Click Me']")).click();
	    Thread.sleep(2000);
	    System.out.println(driver.findElement(By.xpath("//button[text()='Hurray! You Clicked Me.']")).getText());
	    driver.switchTo().defaultContent();
	    
	    
        driver.close();
        
        

	}

}
