package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	 public static WebDriver driver;
	 public static Properties properties;
	 
	 public TestBase() {
		 String path = System.getProperty("user.dir")+"//src//test//resources//Configuration//Config.properties";
		 FileInputStream fin;
		 properties = new Properties();
		 try {
			fin = new FileInputStream(path);
			properties.load(fin);
		}
		 catch (Exception e) {
			e.printStackTrace();
		} 
	 }
	
	public static void initialize() {
		
		String browserName = properties.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(properties.getProperty("url"));
	}
	
	public static void waitTime(int num) {
		try {
			Thread.sleep(num *1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
