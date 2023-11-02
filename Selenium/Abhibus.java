package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Abhibus {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.abhibus.com/");
		
		//driver.findElement(By.id("pills-home-tab")).click();
		driver.findElement(By.xpath("//input[@id='source']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//li[text()='Chennai']")).click();
		
		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[text()='Bangalore']")).click();
		
		driver.findElement(By.xpath("//input[@id='datepicker1']")).click();
		driver.findElement(By.xpath("//td[contains(@class,'ui-datepicker-today')]/following-sibling::td/a")).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		WebElement findElement = driver.findElement(By.xpath("//h2[@class='TravelAgntNm ng-binding']"));
		String BusName= findElement.getText();
		System.out.println(BusName);
		
		driver.findElement(By.xpath("//p[text()='SLEEPER']/following-sibling::input")).click();
		
		WebElement findElement2 = driver.findElement(By.xpath("//p[@class='noseats AvailSts ng-binding']"));
		String data= findElement2.getText();
		System.out.println(data);
		
		driver.findElement(By.xpath("//a[@class='btn-seatselect book1']")).click();
		driver.findElement(By.xpath("//a[@id='UO4-1ZZ']")).click();
		
		WebElement findElement3 = driver.findElement(By.xpath("//span[text()='DU2']"));
		String num=findElement3.getText();
		System.out.println(num);
		
		WebElement findElement4 = driver.findElement(By.id("ticketfare"));
		String abc=findElement4.getText();
		System.out.println(abc);
		
		Thread.sleep(4000);
		
		WebElement findElement5 = driver.findElement(By.id("boardingpoint_id"));
		Select efg=new Select(findElement5);
		efg.selectByIndex(2);
		
		WebElement findElement6 = driver.findElement(By.id("droppingpoint_id"));
		Select bce=new Select(findElement6);
		bce.selectByIndex(5);
		
		String title = driver.getTitle();
		System.out.println("The title of the page is "+title);
		
		Thread.sleep(4000);
		driver.close();
	    
	}

}
