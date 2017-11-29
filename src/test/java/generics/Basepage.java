package generics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Basepage {
	public static WebDriver driver;
	/*public Basepage(WebDriver driver){
		this.driver=driver;
	}*/
	public Basepage(WebDriver driver) {
		Basepage.driver=driver;	
	}
	public static void verifyTitle(String eTitle){
		try{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleIs(eTitle));
		Reporter.log("Title is matching"+eTitle,true);
	}
		catch(Exception e){
			Reporter.log("title is not matching",true);
		}
	}
	public  static void verifyElementPresent(WebElement element){
		try{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
		Reporter.log("Element is present"+element,true);
		}
		catch(Exception e){
			Reporter.log("ellement not present",true);
		}
	}
	public boolean verifyElementIsPresentOrNot(String xp){
		try{
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xp)));
			return true;
		} catch(Exception e){
			return false;
		}
	}
		

}
