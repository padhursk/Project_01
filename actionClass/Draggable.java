package actionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Draggable {

	public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/draggable");
	    driver.manage().window().maximize();
	    
	    driver.switchTo().frame(0);
	    WebElement ment = driver.findElement(By.xpath("//div[@id='draggable']"));
	    
	    Actions op=new Actions(driver);
	    op.dragAndDropBy(ment, 125, 50).perform();
        Thread.sleep(2000);
	    driver.close();
	}

}
