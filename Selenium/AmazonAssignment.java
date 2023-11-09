package assignment_week4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonAssignment {

	public static void main(String[] args) throws IOException, InterruptedException {
	
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
      ChromeDriver driver=new ChromeDriver(options);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      driver.get("https://www.amazon.in/");
      driver.manage().window().maximize();
      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
      
      System.out.println("The price of first listed product is :"+driver.findElement(By.xpath("//span[text()='43,199']")).getText());
      Thread.sleep(1000);
      System.out.println("The number of customer ratings for the first displayed product is :"+driver.findElement(By.xpath("//span[text()='(6)']")).getText());
      
      // WebElement text2 = driver.findElement(By.xpath("//span[text()='6']"));
	  //  String ratings = text2.getText(); // System.out.println(ratings);
	  Thread.sleep(3000);
      //driver.findElement(By.xpath("//span[contains(text(),' (Pine Green, 12GB RAM, 256GB Storage)')]")).click();
	  driver.findElement(By.xpath("//span[contains(text(),' (Morning Mist, 12GB RAM, 256GB Storage)')]")).click();
      Set<String> newpage = driver.getWindowHandles();
      
      List<String> alllinks=new ArrayList<String>(newpage);
      driver.switchTo().window(alllinks.get(1));
      
      //snaps
      File snapshot = driver.getScreenshotAs(OutputType.FILE);
      File des=new File("./snapshot/img0/png");
      FileUtils.copyFile(snapshot, des);
      
      Thread.sleep(3000);
      driver.findElement(By.id("submit.add-to-cart")).click();
      Thread.sleep(3000);
      
      //System.out.println(driver.findElement(By.xpath("//span[contains(@class,'a-size-base-plus a-color-price a-text-bold')]")).getText());
      
     /* WebElement a = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
       String cart=a.getText();
      System.out.println(cart); //
      
      String  A= "43,599";
      if(cart.equalsIgnoreCase(A)) {
    	  System.out.println("The subtotal is verified");
      }
      else {
    	  System.out.println("The subtotal is not verified");
      }*/
     
       WebElement total = driver.findElement(By.xpath("//span[text()='43,199']"));
	    String cart = total.getText();
	    System.out.println(cart);
	    Thread.sleep(1000);
	    boolean isVisible = total.isDisplayed();
	    System.out.println(isVisible); 
	    
	    
      driver.close();
      driver.quit();
}
}