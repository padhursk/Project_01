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

public class Architect_certifications {

	public static void main(String[] args) throws InterruptedException, IOException {
		/*
          8. Get the Text(Summary) of Salesforce Architect 
          9. Get the List of Salesforce Architect Certifications Available
          10.Click on Application Architect 
          11.Get the List of Certifications available
          12.Take a Snapshot of Certifications.*/
          
		ChromeOptions Os=new ChromeOptions();
		Os.addArguments("--disable-notifications"); 
		ChromeDriver driver= new ChromeDriver(Os);
		//Launch Salesforce application https://login.salesforce.com/
		driver.get("https://login.salesforce.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    
	    //Login with Provided Credentials
	    driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
	    driver.findElement(By.id("password")).sendKeys("Leaf$1234");
	    driver.findElement(By.id("Login")).click();
	    Thread.sleep(2000);
	    
	    // Click on Learn More link in Mobile Publisher
	    driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		   
	    Set<String> wh = driver.getWindowHandles();
	    System.out.println(wh);
	    //Click  On Learning
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
        
        WebElement js = root.findElementByXPath("//a[text()='Salesforce Certification']");
        driver.executeScript("arguments[0].click();",js);
        
        // Choose Your Role as Salesforce Architect
        driver.findElement(By.xpath("//div[text()='Architect']")).click();
        
        String para = driver.findElement(By.xpath("//div[contains(@class,'slds-p-bottom--large')]")).getText();
        System.out.println("salesforce architect has a summary as follows"+para);
        
        Thread.sleep(2000);
        List<WebElement> datas = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
        System.out.println(datas.size());
        for (int i = 0; i < datas.size(); i++) {
            
        	String text = datas.get(i).getText();
        	System.out.println(text);
        }
        	//click on appl architect
        driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
        
        List<WebElement> app2 = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
        System.out.println(app2.size());
        for (int j = 0; j < app2.size(); j++) {
        	String text2 = app2.get(j).getText();
        	System.out.println(text2);
        	
        	File snaps = driver.getScreenshotAs(OutputType.FILE);
            File folder =new File("./snap/img1/png");
            FileUtils.copyFile(snaps, folder);
        
	}

}}

