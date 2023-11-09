package marathon_02;

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

import io.github.sukgu.Shadow;

public class Administrator_certifications {

	public static void main(String[] args) throws InterruptedException, IOException {
		/*Testcase-1: Administrator Certifications
               ==============================
     1. Launch Salesforce application https://login.salesforce.com/
     2. Login with username as "hari.radhakrishnan@qeagle.com" 
    and password as "Leaf$1234"
     3. Click on Learn More link in Mobile Publisher
     4. Click confirm on Confirm redirect
     5. Click Learning 
     6. And mouse hover on Learning On Trailhead
     7. Clilck on Salesforce Certifications
     8. Click on first resulting Ceritificate
     9. verify - Administrator Overview page
     10.Print the Certifications available for Administrator Certifications (List)
     11.Take a Snapshot of Certifications.
*/
		ChromeOptions Os=new ChromeOptions();
		Os.addArguments("--disable-notifications"); 
		ChromeDriver driver= new ChromeDriver(Os);
		
		driver.get("https://login.salesforce.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
	    driver.findElement(By.id("password")).sendKeys("Leaf$1234");
	    driver.findElement(By.id("Login")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[text()='Learn More']")).click();
	   
	    Set<String> wh = driver.getWindowHandles();
	    System.out.println(wh);
	    
	    List<String> child=new ArrayList<String>(wh);
	    driver.switchTo().window(child.get(1));
	    driver.findElement(By.xpath("//button[text()='Confirm']")).click();
	    //learning
	    
        Shadow root=new Shadow(driver);
        root.findElementByXPath("//span[text()='Learning']").click();
        
        //mouse hover on Learning On Trailhead
        WebElement hover = root.findElementByXPath("//span[text()='Learning on Trailhead']");
        Actions obj= new Actions(driver);
        obj.moveToElement(hover).perform();
        
       // Clilck on Salesforce Certifications
        WebElement js = root.findElementByXPath("//a[text()='Salesforce Certification']");
        driver.executeScript("arguments[0].click();",js);
        
        //click on 1st resulting
        driver.findElement(By.xpath("//div[@class='roleMenu-item_text'][1]")).click();
        
        //verify - Administrator Overview page
        String title0= "Certification - Administrator Overview";
        
        String title = driver.getTitle();
        System.out.println(title);
        
        if (title.equalsIgnoreCase(title0)) {
			System.out.println("Title is verified");
		}
        else {
        	System.out.println("Title is not verified");
        }
        
        //Print the Certifications available for Administrator Certifications (List)
        
        List<WebElement> allCer = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
        System.out.println(allCer.size());
        for (int i = 0; i < allCer.size(); i++) {
        	String datas = allCer.get(i).getText();
        	System.out.println(datas);
			
		}
        
        //snapshot
        File snaps = driver.getScreenshotAs(OutputType.FILE);
        File folder1 =new File("./snap/img/png");
        FileUtils.copyFile(snaps, folder1);
	}

}
