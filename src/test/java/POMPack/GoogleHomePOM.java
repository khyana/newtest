package POMPack;
import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class GoogleHomePOM {
	WebDriver driver;
    By searchinputbox = By.name("q");
    By searchbutton = By.name("btnK");
    public GoogleHomePOM(WebDriver driver){
        this.driver = driver;
    }
    public void setSearchString(String strSearchString){
        driver.findElement(searchinputbox).sendKeys(strSearchString);
    }
    public void clickbtn(){
    	WebDriverWait wait=new WebDriverWait(driver, 20);
    	WebElement clickBtn;
    	clickBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(searchbutton));
    	clickBtn.click();
    }
    public void fetchAdaptavistLink() throws Exception{
    	String pagesearch = driver.getCurrentUrl();
        List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//a/h3"));
        //System.out.println(findElements.size());
        for(int i=0;i<findElements.size();i++){
            findElements= driver.findElements(By.xpath("//*[@id='rso']//a/h3"));                
            findElements.get(i).click();
            TakesScreenshot scrShot =((TakesScreenshot)driver);
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile=new File("C:\\Users\\prabha\\Desktop\\khyana\\Aptavist\\SS"+i+".png");
            FileUtils.copyFile(SrcFile, DestFile);
            driver.navigate().to(pagesearch);
        }
    }
    public void fetchAtlassianLink() throws Exception{
    	//Get list of web-elements with tagName  - a
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		//Traversing through the list and printing its text along with link address
		for(WebElement link:allLinks){
			String strAttlasian = link.getText();
			if (strAttlasian.contains("Adaptavist"))
			{
				System.out.println("Fail");
				break;
			}
		}
    }
    
}
