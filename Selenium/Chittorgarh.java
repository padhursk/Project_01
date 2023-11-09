package assignment_week4;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chittorgarh {

	public static void main(String[] args) {
		/*chittorgarh Assignment
========================
1. Launch the URL https://www.chittorgarh.com/
2. Click on stock market
3. Click on NSE bulk Deals
4. Get all the Security names
5. Ensure whether there are duplicate Security names */


		ChromeOptions Options=new ChromeOptions();
		Options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		//String row = driver.findElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr")).getText();
		//System.out.println(row);
		List<WebElement> colsize = driver.findElements(By.xpath("//div[@class='table-responsive']/table/tbody/tr"));
		int sizeofCol = colsize.size();
		System.out.println(sizeofCol);
		for (int i = 1; i < sizeofCol; i++) {
			String coldata = driver.findElement(By.xpath("//div[@class='table-responsive']/table/tbody/tr["+i+"]/td")).getText();
			System.out.println(coldata);
		}
	}

}
