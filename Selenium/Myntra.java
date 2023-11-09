package assignment_week4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions Os=new ChromeOptions();
		Os.addArguments("--disable-notifications"); 
		ChromeDriver driver= new ChromeDriver(Os);
		
		driver.get("https://www.myntra.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    
	    WebElement element = driver.findElement(By.xpath("//a[text()='Men']"));
	    Actions op=new Actions(driver);
	    op.moveToElement(element).perform();
	    
	    driver.findElement(By.xpath("//a[text()='Jackets']")).click();
	    //System.out.println("The total count of item is :"+driver.findElement(By.xpath("//div[@class='title-container']//span")).getText());
	    String total = driver.findElement(By.xpath("//div[@class='title-container']//span")).getText();
	    String find = total.replaceAll("[^0-9]", "");
	    System.out.println("The total count of item is :"+find);
	    int int3 = Integer.parseInt(find);
	    
        WebElement element2 = driver.findElement(By.xpath("//ul[@class='categories-list']//span"));
        String jacket =element2.getText();
        //System.out.println(jacket);
       
        WebElement element3 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]"));
        String Rainjacket =element3.getText();
        //System.out.println(Rainjacket);
        
        String newdata0 = jacket.replaceAll("[()]", "");
        System.out.println(newdata0);
        
        String newdata1 = Rainjacket.replaceAll("[()]", "");
        System.out.println(newdata1);
        
        int int1 = Integer.parseInt(newdata0);
        int int2 = Integer.parseInt(newdata1);
        int sum=int1+int2;
        System.out.println("lhs"+int3);
        System.out.println("addtion of two filters"+sum);
        
        if (int3==(sum)) {
			System.out.println("total items and category sum is validated");
        }
        else {
        	System.out.println("total items and category sum is not validated");
        }
        
        //String stringWithoutParenthesesA = a.replace("(", "").replace(")", "");
        driver.findElement(By.xpath("//div[@class='common-checkboxIndicator']")).click();
        driver.findElement(By.className("brand-more")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("Duke");
        driver.findElement(By.xpath("//label[@class=' common-customCheckbox']//div")).click();
        driver.findElement(By.xpath("//span[contains(@class,'FilterDirectory-close sprites-remove')] ")).click();
        
        List<WebElement> brand = driver.findElements(By.xpath("//h3[text()='Duke']"));
       
        
        String searchelement= "Duke";
        //int size = brand.size();
        //System.out.println(size);
       // for (int i = 0; i <= size; i++) {
			
		
        for (WebElement data : brand) {
            if (data.getText().contains(searchelement)) {
                System.out.println("This brand is Duke: " + data.getText());
            } 
            else {
                System.out.println("This brand is not Duke: " + data.getText());
    		
        }
       
        }
       driver.findElement(By.className("sort-sortBy")).click();
       driver.findElement(By.xpath("//ul[@class='sort-list']/li[4]/label")).click();
       Thread.sleep(2000);    
      // Find the price of first displayed item
       
       System.out.println("Discounted price of first product is :"+driver.findElement(By.className("product-discountedPrice")).getText());
       driver.findElement(By.xpath("//h4[text()='Men Solid Nylon Bomber Jacket']")).click();
       
       
       Set<String> We = driver.getWindowHandles();
       List<String> page =new ArrayList<String>(We);
       driver.switchTo().window(page.get(1));
       Thread.sleep(1000);   
       File file1 = driver.getScreenshotAs(OutputType.FILE);
       File source = new File("./snapshot/img3/png");
       FileUtils.copyFile(file1, source);
       Thread.sleep(1000);    
       driver.findElement(By.xpath("//div[contains(@class,'pdp-add-to-wishlist')]//following::span")).click();
       
       driver.close();
       driver.switchTo().window(page.get(0));
       driver.quit();
	}

}
