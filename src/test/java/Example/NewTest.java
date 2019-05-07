package Example;
import POMPack.GoogleHomePOM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NewTest {
  WebDriver driver;
  GoogleHomePOM objgooglehome;
  
  @BeforeTest
  public void beforeTest() { 
	  System.setProperty("webdriver.chrome.driver","C:\\SeleniumDrivers\\chromedriver.exe");
      driver = new ChromeDriver();
      //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      
      driver.get("https://www.google.com/");
  }
@Test
   public void funcSearch() throws Exception {
	objgooglehome = new GoogleHomePOM(driver);
	objgooglehome.setSearchString("Adaptavist");
	objgooglehome.clickbtn();
	System.out.println("Adaptavist searched successfully");
	objgooglehome.fetchAdaptavistLink();
	
	driver.get("https://www.google.com/");
	objgooglehome.setSearchString("Atlassian");
	objgooglehome.clickbtn();
	System.out.println("Atlassian searched successfully");
	objgooglehome.fetchAtlassianLink();
	
  }
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
