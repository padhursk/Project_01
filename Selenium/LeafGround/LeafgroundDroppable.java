package assignment_week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LeafgroundDroppable {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://leafground.com/drag.xhtml");
	    driver.manage().window().maximize();
	    WebElement source = driver.findElement(By.id("form:drag_content"));
	    WebElement target = driver.findElement(By.id("form:drop_header"));
	    Actions op=new Actions(driver);
	    op.dragAndDrop(source, target).perform();
        Thread.sleep(1000);
        
        System.out.println("status of element is "+driver.findElement(By.id("form:drop_content")).getText());
        
	    driver.close();
	    
	}

}
