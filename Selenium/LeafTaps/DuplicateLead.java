package assignmentWeek2;


		import java.time.Duration;

		import org.openqa.selenium.By;
		import org.openqa.selenium.chrome.ChromeDriver;
		public class DuplicateLead {
	

			public static void main(String[] args) throws InterruptedException {
				
				ChromeDriver driver= new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				driver.get("http://leaftaps.com/opentaps/control/login");
				driver.findElement(By.id("username")).sendKeys("Demosalesmanager"); 
				driver.findElement(By.id("password")).sendKeys("crmsfa"); 
				driver.findElement(By.className("decorativeSubmit")).click();
				driver.findElement(By.linkText("CRM/SFA")).click();
				driver.findElement(By.linkText("Leads")).click();
				driver.findElement(By.linkText("Create Lead")).click();
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Zoho");
				driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Padmini");
				driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
				driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Mini");
				driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
				driver.findElement(By.id("createLeadForm_description")).sendKeys("Automationtesting");
				driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("mini@gmail.com");
				driver.findElement(By.name("submitButton")).click();
				
				String title = driver.getTitle();
				System.out.println(title);
				
				driver.findElement(By.linkText("Duplicate Lead")).click();
				driver.findElement(By.id("createLeadForm_companyName")).clear();
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys("OLAM");
				driver.findElement(By.id("createLeadForm_firstName")).clear();
				driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Padhu");
				driver.findElement(By.className("smallSubmit")).click();
				
				Thread.sleep(3000);
				driver.close();
				
		  
			}

		

	}


