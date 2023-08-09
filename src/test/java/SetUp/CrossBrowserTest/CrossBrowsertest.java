package SetUp.CrossBrowserTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowsertest {

	
	WebDriver driver;
	
	@BeforeMethod
	
	@Parameters("browser")
	
	public void setUp(@Optional("edge")String browser) {
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
			
			
		}else if (browser.equalsIgnoreCase("edge")) {
			
			System.setProperty("webdriver.edge.driver", "C:\\Users\\USER\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");
			 driver= new EdgeDriver();
			
			
		}
	}
	
	
	@Test
	
	public void testCrossBrowser(){
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://qa.d1ainun5cjrnni.amplifyapp.com");
		driver.findElement(By.id("email")).sendKeys("mluther@yopmail.com");
		driver.findElement(By.id("password")).sendKeys("Password123*");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	
	@AfterMethod
	
	public void tearDown() {
	
	if(driver !=null) {
		driver.quit();
	}
	
}
}