package marathon_03;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public RemoteWebDriver driver;
	public String sheetdata;
	
    
	@DataProvider(name="fetchdata")
    public String[][] getdata() throws IOException {
    	return ReadXLdata.ReadXL(sheetdata);
	}

	@Parameters({"browser","url","username","password"})
	
	@BeforeMethod
	public void Precondition(String browser, String url ,String uname,String pwd) throws InterruptedException {
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options =new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver= new ChromeDriver(options);
			
		}else if(browser.equalsIgnoreCase("edge")){
			EdgeOptions options =new EdgeOptions();
			options.addArguments("--disable-notifications");
			driver= new EdgeDriver(options);
		}
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(url);
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
			driver.findElement(By.xpath("//input[contains(@class,'button')]")).click();
            driver.findElement(By.className("slds-icon-waffle")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[text()='View All']")).click();
            
	}
	
	@AfterMethod
	
	public void postCondition() {
	//	driver.close();
	}
	
}
