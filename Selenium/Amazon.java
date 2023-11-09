package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bags");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()=' for boys']")).click();
		
        WebElement total = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String abc=total.getText();
        System.out.println("The number of results is "+ abc);  
        
        Thread.sleep(2000);
        //note //h2[@class='TravelAgntNm ng-binding']
        
        driver.findElement(By.xpath("//div[@id='brandsRefinements']//i[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='American Tourister']")).click();
        
        Thread.sleep(4000);
        
        driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).click();
        
        Thread.sleep(5000);
        
        driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
        
        Thread.sleep(6000);
       // System.out.println(driver.findElement(By.xpath("(//span[@class='a-price']")).getText());
        
        System.out.println(driver.findElement(By.xpath("//div[contains(@class,'a-row a-size-base a-color-base')]//following::span")).getText());
        
        String title = driver.getTitle();
        System.out.println("The title of the page is "+title);
        driver.close();
        
         
        
	}

}
