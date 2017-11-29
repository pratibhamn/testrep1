package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.Basepage;
import junit.framework.Assert;

public class HomePage extends Basepage{
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="txtUsername")
	private WebElement userTxtBox;
	@FindBy(id="txtPassword")
	private WebElement pwdTxtBox;
	@FindBy(id="btnLogin")
	private WebElement loginBtn;
	@FindBy(id="menu_pim_viewPimModule")
	private WebElement pim_Menu;
	@FindBy(id="menu_pim_addEmployee")
	private WebElement addEmp_Menu;
	@FindBy(id="firstName")
	private WebElement firstName;
	@FindBy(id="lastName")
	private WebElement lastName;
	@FindBy(id="btnSave")
	private WebElement saveBtn;
	@FindBy(id="personal_txtEmpFirstName")
	private WebElement firstName1;
	
	public void setUserName(String un){
		userTxtBox.sendKeys(un);
	}
	public void setPwd(String pwd){
		 pwdTxtBox.sendKeys(pwd);
	}
	public void clickLogin(){
		loginBtn.click();
	}
	public void clickPim_Menu(){
		pim_Menu.click();
	}
	public void clickAddEmp_Menu(){
		addEmp_Menu.click();
	}
	public void setFirstName(String un){
		firstName.sendKeys(un);
	}
	public void setLastName(String un){
		lastName.sendKeys(un);
	}
	public void clickSaveBtn(){
		saveBtn.click();
	}
	public void verifyFirstName(String eFn){
		String aFn = firstName1.getAttribute("value");
		Assert.assertEquals(aFn, eFn);
	}
	// To Delete An employee
	@FindBy(id="menu_pim_viewEmployeeList")
	private WebElement addEmpList_Btn;
	@FindBy(id="btnDelete")
	private WebElement btnDelete ;
	@FindBy(id="dialogDeleteBtn")
	private WebElement btnOK ;
	
	public void clickAddEmpList(){
		addEmpList_Btn.click();
	}
	public void clickEmpCheckBox(String name){
		String xp = "//a[text()='"+name+"']/../../td[1]//input";
		driver.findElement(By.xpath(xp)).click();
	}
	public void clickDelete(){
		btnDelete.click();
	}
	public void clickOK(){
		btnOK .click();
	}
	public void verifyEmpIsNotPresent(String name){
		String xp = "//a[text()='"+name+"']";
		boolean present=verifyElementIsPresentOrNot(xp);
		Assert.assertFalse(present);
	}
}

