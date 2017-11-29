package scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import generics.BaseTest;
import generics.Basepage;
import generics.Excel;
import generics.genericUtils;
import pom.HomePage;

public class TestScripts extends BaseTest{
	@Test(enabled=true)
	public void testCreateEmployee() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		HomePage pi=new HomePage(driver);
		pi.setUserName(Excel.readData("Sheet1", 0, 1));
		pi.setPwd(Excel.readData("Sheet1", 1, 1));
		pi.clickLogin();
		Basepage.verifyTitle("OrangeHRM");
		pi.clickPim_Menu();
		Thread.sleep(2000);
		pi.clickAddEmp_Menu();
		Thread.sleep(3000);
		pi.setFirstName("Pratibha");
		pi.setLastName("m");
		Thread.sleep(2000);
		pi.clickSaveBtn();
		pi.verifyFirstName("Pratibha");
	}
	// To delete an employee
	@Test(enabled=false)
	public void testDeleteEmployee() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		HomePage pi=new HomePage(driver);
		pi.setUserName(Excel.readData("Sheet1", 0, 1));
		pi.setPwd(Excel.readData("Sheet1", 1, 1));
		pi.clickLogin();
		Basepage.verifyTitle("OrangeHRM");
		pi.clickPim_Menu();
		pi.clickAddEmpList();
		Thread.sleep(3000);
		pi.clickEmpCheckBox("Pratibha");
		Thread.sleep(3000);
		pi.clickDelete();
		pi.clickOK();
		pi.verifyEmpIsNotPresent("Pratibha");
	}

	// To sort the listbox
	@Test(enabled=false)
	public void testSortListBox() throws InterruptedException{
		HomePage pi=new HomePage(driver);
		pi.setUserName("Admin");
		pi.setPwd("admin");
		pi.clickLogin();
		Basepage.verifyTitle("OrangeHRM");
		pi.clickPim_Menu();
		Thread.sleep(2000);
		pi.clickAddEmpList();
		Thread.sleep(2000);
		genericUtils.sortListBox(driver.findElement(By.xpath("//select[@id='empsearch_job_title']")));
	}
}
