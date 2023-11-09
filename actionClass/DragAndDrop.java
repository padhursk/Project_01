package actionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/droppable");
	    driver.manage().window().maximize();
	    
	    driver.switchTo().frame(0);
	    
	    WebElement element = driver.findElement(By.xpath("//div[@id='draggable']"));
	    WebElement element2 = driver.findElement(By.xpath("//div[@id='droppable']"));
	    Thread.sleep(1000);
	    Actions op=new Actions(driver);
	    op.dragAndDrop(element, element2).perform();
        Thread.sleep(1000);
        
        System.out.println(driver.findElement(By.xpath("//div[@id='droppable']")).getText());
        
	    driver.close();
	    

	}

}
