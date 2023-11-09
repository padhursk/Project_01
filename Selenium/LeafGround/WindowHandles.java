package assignment_week4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		//Leafground Window handles

    //url : 
		  ChromeDriver driver=new ChromeDriver();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	      driver.get("https://leafground.com/window.xhtml;jsessionid=node0ohpw87cjok1dz9p1fgudvj6l12019.node0");
	      driver.manage().window().maximize();
		  driver.findElement(By.xpath("//span[text()='Open']")).click();
		  
		  Set<String> WH = driver.getWindowHandles();
		  List<String> child=new ArrayList<String>(WH);
		  driver.switchTo().window(child.get(1));
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mini@gnail.com");
		  driver.close();
		  driver.switchTo().window(child.get(0));
		  
		  driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		  
		  
		  Set<String> tab = driver.getWindowHandles();
		  System.out.println(tab);
		  Thread.sleep(2000);
		  
		  List<String> ch=new ArrayList<String>(tab);
		  driver.switchTo().window(ch.get(2));
		  Thread.sleep(3000);
		  
		  driver.findElement(By.xpath("//input[@id='form:j_idt89:globalFilter']")).sendKeys("mini");
		  Thread.sleep(3000);
		  driver.close();
		 
		  
		  driver.switchTo().window(ch.get(1));
		  Thread.sleep(3000);
		  driver.close();
		  
		  
		  //switching parent window
		  driver.switchTo().window(ch.get(0));
		  
		  
		  //close window 
		 
		  driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		  Set<String> tabs = driver.getWindowHandles();
		  System.out.println(tabs);
		  Thread.sleep(2000);
		
		  List<String> abc=new ArrayList<String>(tabs);
		  driver.switchTo().window(abc.get(3));
		  Thread.sleep(3000);
		  driver.close();
		  
		  driver.switchTo().window(abc.get(2));
		  Thread.sleep(3000);
		  driver.close();
		  
		  driver.switchTo().window(abc.get(1));
		  Thread.sleep(3000);
		  driver.close();
		  
		//switching parent window
		  driver.switchTo().window(ch.get(0));
		  
		  
		  //Open with delay
		  driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		  
		  Set<String> WH3 = driver.getWindowHandles();
		  
		  Thread.sleep(2000);
		
		  List<String> delay=new ArrayList<String>(WH3);
		  driver.switchTo().window(delay.get(1));
		  driver.close();
		  
		  Thread.sleep(3000);
		  
		  driver.switchTo().window(delay.get(2));
		
		  driver.close();
		  
		  Thread.sleep(3000);
		  driver.quit();
		  
	}
	
	

}
