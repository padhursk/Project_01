package assignment_week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LeafGroundDragNdrop {

	public static void main(String[] args) throws InterruptedException {
		//drag assignment
		
		ChromeDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://leafground.com/drag.xhtml");
	    driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//span[@class='ui-panel-title']"));
        Actions a = new Actions(driver);
        a.dragAndDropBy(element, 110, 90).perform();
        Thread.sleep(1000);
        driver.close();
        
       
	}

}
