package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class genericUtils extends BaseTest{
	public  static void gSelectByIndex(WebElement element,int n){
		Select select=new Select(element);
		select.selectByIndex(n);
	}
public static void gSelectByValue(WebElement element,String value){
	Select select=new Select(element);
	select.selectByValue(value);
}
public static void  gSelectByVisibleText(WebElement element,String v){
	Select select=new Select(element);
	select.deselectByVisibleText(v);
}
public static void hover(WebDriver driver,WebElement toElement){
	Actions action=new Actions(driver);
	action.moveToElement(toElement).perform();
}

public  static void sortListBox(WebElement element){
	Select select=new Select(element);
	List<WebElement> li=select.getOptions();
	ArrayList<String> ar=new ArrayList<String>();
	ArrayList<String> arr1=new ArrayList<String>();

//sort the elements
for(int i=1;i<li.size();i++){
	String st = li.get(i).getText();
	ar.add(st);
	arr1.add(st);
}
Collections.sort(ar);
// to compare the elements
for(int i=0;i<ar.size();i++){
	if(!(arr1.get(i).equals(ar.get(i)))){
		Reporter.log("List is not sorted:Fail",true);
	}
}
Reporter.log("list is sorted:Pass",true);
}
}
