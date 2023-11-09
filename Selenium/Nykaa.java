package assignment_week4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions Options=new ChromeOptions();
		Options.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.nykaa.com/");
		
		WebElement element = driver.findElement(By.xpath("(//div[@class='css-1yqek2e']//ul)[2]"));
		Actions as=new Actions(driver);
		as.moveToElement(element).perform();
		
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oréal Paris"+Keys.ENTER);
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[text()=\"L'Oréal Paris\"]")).click();
		Thread.sleep(1500);
		
		String title = driver.getTitle();
		System.out.println(title);

        driver.findElement(By.className("sort-name")).click();
        driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
        driver.findElement(By.xpath("(//div[@class='filter-open css-1gdff5r']/span)[2]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath(" //div[@class=' css-1nozswx']/span[text()='Hair']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@class=' css-1nozswx']/span[text()='Hair Care']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//label[@class='control control-checkbox']//span[text()='Shampoo']")).click();
		
        //to click concern and color protection
        driver.findElement(By.xpath("//span[text()='Concern']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[text()='Colour Protection']")).click();
        
        //to check whether filter applied with shampoo
        
        System.out.println(driver.findElement(By.xpath("(//div[@class='css-rtde4j']/div)[2]")).getText());
		driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();
		
		//GO to the new window and select size as 175ml
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>child=new ArrayList<String>(windowHandles);
		driver.switchTo().window(child.get(1));
		Thread.sleep(500);
		
		driver.findElement(By.xpath(" //button[@class=' css-1r0ze8m']/span")).click();
		System.out.println("Price of the product- MRP: "+driver.findElement(By.xpath("//div[@class='css-1d0jf8e']/span[@class='css-1jczs19']")).getText());
        
		driver.findElement(By.xpath("//div[@class='css-vp18r8']//span")).click();
		driver.findElement(By.xpath("//button[@class='css-aesrxy']")).click();
		Thread.sleep(500);
		driver.switchTo().frame(0);
		
		String text = driver.findElement(By.xpath("//span[@class='css-1um1mkq e171rb9k3']")).getText();
		System.out.println("Grand total of the selected product in the bag is :"+text);
		
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		//driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//div[@class='css-1e2js32 emgron30']")).click();
		String text2 = driver.findElement(By.xpath("//p[@class='css-1e59vjt eka6zu20']")).getText();
	    System.out.println(text2);
	    
	    //verify grandtotal and final value
	    
	    if (text.equals(text2)) {
	    	System.out.println("both are equal");
		} else {
			System.out.println("Not Matched");

			
		}
	     driver.close();
	      driver.quit();
	}

}
