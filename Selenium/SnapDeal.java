package assignment_week4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
	/*	SnapDeal Assignment
		=========================
	*/
		ChromeOptions Options=new ChromeOptions();
		Options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		//Go to Mens Fashion
		driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]")).click();
		//Go to Sports Shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		
		// Get the count of the sports shoes
		String text = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[2]")).getText();
		System.out.println("The total count of the sports shoes are :"+text);
		//5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		//6. Sort by Low to High
		Thread.sleep(500);
		driver.findElement(By.className("sort-selected")).click();
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		
		//7. Check if the items displayed are sorted correctly
		List<WebElement> SortedPrice = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		
		boolean isSorted = true;
		for (int i = 1; i < SortedPrice.size(); i++) {
		Thread.sleep(2000);
		//to relocate the element since it throws stale element exception. we are locating it again
		List<WebElement> currentPriceElements = driver.findElements(By.className("product-price"));
			String CurrentPrice = currentPriceElements.get(i-1).getText().replaceAll("[^0-9]", "");
			//System.out.println(CurrentPrice);
			String nextPrice = currentPriceElements.get(i).getText().replaceAll("[^0-9]", "");
			
			int firstnum = Integer.parseInt(CurrentPrice);
			int secondnum = Integer.parseInt(nextPrice);
			
			/*if (firstnum<secondnum) {
				System.out.println("sorted correctly");
			} else {
				System.out.println("not sorted correctly");
			}*/
				
			if (firstnum > secondnum) {
		        isSorted = false;
		        break;
		   }	}
		   System.out.println(isSorted ? "Items are sorted correctly by Price Low to High." : "Items are not sorted correctly.");
	       
		   //8.Select the price range (600-1000)
	        WebElement PriceRange1 = driver.findElement(By.xpath("(//input[@class='input-filter'])[1]"));
	        PriceRange1.clear();
	        PriceRange1.sendKeys("550");
	        
	        WebElement PriceRange2 = driver.findElement(By.xpath("(//input[@class='input-filter'])[2]"));
	        PriceRange2.clear();
	        PriceRange2.sendKeys("850");
	        
	        driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
	
	    //  9.Filter with color Navy 
	       // WebElement jselement = driver.findElement(By.xpath("//p[contains(text(),'Navy Blue')]"));
	      //  driver.executeScript("arguments[0].click();", jselement);
	        
	        
	    //    10 verify the all applied filters 
	        String pricefilter = driver.findElement(By.xpath("//a[@data-key='Price|Price']")).getText();
	        System.out.println(pricefilter);
	        
	        if (pricefilter.equals("Rs. 550 - Rs. 850")) {
	        	System.out.println("applied correctly");
				
			}else {
				System.out.println("Filters are NOT applied Correctly");
			}
	        
	  //  	11. Mouse Hover on first resulting Training shoes
  
	        WebElement firstresult = driver.findElement(By.xpath("//a[@class='dp-widget-link noUdLine hashAdded']"));
	        Actions firstObj= new Actions(driver);
	        firstObj.moveToElement(firstresult).perform();

	  // 12. click QuickView button  
	        driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
	        
	  // 13. Print the cost and the discount percentage
	        
	        System.out.println("Cost of the first resulting product is Rs:"+driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText());
	        System.out.println("Cost of the first resulting product is Rs:"+driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText());
      //14. Take the snapshot of the shoes.
	        File scr = driver.getScreenshotAs(OutputType.FILE);
	        File des = new File ("./snap/Snapdealimg001.png");
	        FileUtils.copyFile(scr, des);
	        
	   //   15. Close the current window  
	        driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
	        driver.quit();
/*
			
			16. Close the main window*/
	        //driver.close();
	
	}}
