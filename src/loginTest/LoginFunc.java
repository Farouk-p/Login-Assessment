package loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginFunc {
	
	WebDriver driver;
	
	@BeforeTest
	
	public void SetUp () {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\FAROUK\\eclipse-workspace\\InterviewTest\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void LogInUser () throws InterruptedException {
				
		//Expand browser window
		driver.manage().window().maximize();
		
		//Navigate to TestUrl
		driver.get("https://selfcare.spectranet.com.ng/login");
		
		//Enter UserID
		driver.findElement(By.id("userid")).sendKeys("16113650");
		
		//Enter Password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
		
		//Click on Login button
		WebElement login = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[4]/div[2]/div[1]/form/div[4]/button[1]"));
		login.click();
		
		//Hold page for 5seconds
		Thread.sleep(5000);
		
		//Print welcome message
		WebElement welcomeMessage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[1]/div[1]/h6"));
		String welcomeText = welcomeMessage.getText();
		System.out.println(welcomeText);
	    }
		
		
		@AfterTest
		public void TearDown () {
			
		//Close browser
		driver.quit();
		}
		
}
