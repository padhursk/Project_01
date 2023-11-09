package assignment_week4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class CountNoOfRowscolumns {

	public static void main(String[] args) {
		// Get the count of number of rows
		// Get the count of number of columns
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		List<WebElement> Row = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr"));
		int count = Row.size();
		System.out.println(count);
		
		List<WebElement> cell = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr[1]/td"));
		int cellcount = cell.size();
		System.out.println(cellcount);
		
		
		List<WebElement> Row2 = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr"));
		int count2 = Row2.size();
		System.out.println(count2);
		
		List<WebElement> cell2 = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr[2]/td"));
		int cellcount2 = cell2.size();
		System.out.println(cellcount2);
		
		
		
		
	}

}
