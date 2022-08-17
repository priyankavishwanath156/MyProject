/**
 * 
 */
package com.mystore.testscript;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.Indexpage;
import com.mystore.pageobjects.LoginPage;

/**
 * @author Priyanka M
 *
 */
public class AccountCreationPageTest extends BaseClass {
	Indexpage indexPage;
	LoginPage loginPage;
	HomePage  homePage;
	AccountCreationPage accountCreationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser){
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown(){
		getDriver().quit();
	}	
	
	@Test(groups = "Sanity")
	public void varifyAccountCreationPage() {
		indexPage = new Indexpage();
		loginPage = indexPage.ClickOnSign();
	    accountCreationPage = loginPage.CreateNewEmail("xyz@xyz.com");
	    boolean result = accountCreationPage.validateAccountCreationPage();
	    Assert.assertTrue(result);
	    
		
	}
}
