package actionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selectable {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://jqueryui.com/selectable");
	    driver.manage().window().maximize();
	    
	    driver.switchTo().frame(0);	
	    WebElement element = driver.findElement(By.xpath("//li[text()='Item 1']"));
	    WebElement element2 = driver.findElement(By.xpath("//li[text()='Item 4']"));
	    WebElement element0 = driver.findElement(By.xpath("//li[text()='Item 5']"));
	    WebElement element3 = driver.findElement(By.xpath("//li[text()='Item 7']"));
	
	    Actions op=new Actions(driver);
	    Thread.sleep(1000);
	    op.keyDown(Keys.CONTROL).click(element).click(element2).click(element0).click(element3).keyUp(Keys.CONTROL).perform();
	    
	    
	
	}

}
