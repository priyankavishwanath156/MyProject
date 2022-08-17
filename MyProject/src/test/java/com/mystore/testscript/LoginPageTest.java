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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.Indexpage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * @author Priyanka M
 *
 */
public class LoginPageTest extends BaseClass {
	Indexpage indexPage;
	LoginPage loginPage;
	HomePage  homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser){
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown(){
		getDriver().quit();
	}
	
	@Test(groups = {"Smoke","Sanity"})
	public void loginTest() {
		Log.startTestCase("loginTest");
		indexPage = new Indexpage();
		Log.info("user is going to click on SignIn");
		loginPage = indexPage.ClickOnSign();
		Log.info("enter Username and Password");
		homePage = loginPage.login(property.getProperty("username"),property.getProperty("password"));
		String actualURL = homePage.getcurrURL();
		String expectURL = "http://automationpractice.com/index.php?controller=my-account";
		Log.info("verifying is user is able to login");
		Assert.assertEquals(actualURL, expectURL);
		Log.info("Login is success");
		Log.endTestCase("loginTest");
	}

}
