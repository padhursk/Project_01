package actionClass;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Resizable {


		public static void main(String[] args) throws InterruptedException {
			ChromeDriver driver= new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://jqueryui.com/resizable");
		    driver.manage().window().maximize();
		    
		    driver.switchTo().frame(0);
		    
		    WebElement element = driver.findElement(By.xpath("//div[@id='resizable']//div[3]"));
		    Actions op=new Actions(driver);
		    Thread.sleep(1000);
		    
		    op.dragAndDropBy(element, 300, 50).build().perform();
		    Thread.sleep(5000);
		    driver.close();
		    

		  /*  Action dragAndDrop = builder.clickAndHold(someElement)
		       .moveToElement(otherElement)
		       .release(otherElement)
		       .build();

		    dragAndDrop.perform();*/
		    
	}

}
