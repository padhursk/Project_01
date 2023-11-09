package assignmentWeek2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook_signup {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
	    
	    driver.get("https://en-gb.facebook.com/");
	    
	    driver.manage().window().maximize();
	 
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    
	 	driver.findElement(By.xpath("//a[text()='Create new account']")).click();
	 	
	 	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Padmini");
	 	
	 	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("R");
	 	
	 	driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("5000805461");
	 	
	 	driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("asdfgg1");
	 	
	 	WebElement date = driver.findElement(By.xpath("//select[@id='day']"));
	 	Select obj=new Select(date);
	 	obj.selectByValue("28");
	 	
	 	WebElement month = driver.findElement(By.xpath("//select[@name='birthday_month']"));
	 	Select abc=new Select(month);
	 	abc.selectByValue("6");
	 	
	 	WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
	 	Select bcd=new Select(year);
	 	bcd.selectByVisibleText("2023");
	 	
	 	driver.findElement(By.xpath("//label[text()='Female']")).click();
	 	Thread.sleep(3000);
	 	
	 	driver.close();
	 	

	}

}
