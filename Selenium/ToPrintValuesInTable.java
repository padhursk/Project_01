package assignment_week4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToPrintValuesInTable {

	public static void main(String[] args) {
		/*/ Print values in the table Assignment 
		=====================================shortcut to import the statement ctrl+shft+o
				1. Launch the URL https://html.com/tags/table/
				2. You have to print the respective values based on given Library
				(hint: if the library was absolute usage, then print all its value)*/
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
        driver.get("https://html.com/tags/table/");
        
        List<WebElement> row = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr"));
        int rowsize = row.size();
        
        List<WebElement> col = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr[1]/td"));
        int colsize = col.size();
        
        for (int i = 1; i <= rowsize; i++) {
        	for (int j = 1; j <=colsize; j++) {
        		String value = driver.findElement(By.xpath("//div[@class='render']/table/tbody/tr["+i+"]/td["+j+"]")).getText();	
        		System.out.println(value);
    		}
		}
        
        
        
		
		
		
		
	}

}
