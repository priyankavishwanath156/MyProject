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

/**
 * @author Priyanka M
 *
 */
public class HomePageTest extends BaseClass{
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
	
	@Test(groups = "Smoke")
	public void wishListTest(){
		indexPage = new Indexpage();
		loginPage = indexPage.ClickOnSign();
		homePage = loginPage.login(property.getProperty("username"),property.getProperty("password"));
		boolean result = homePage.validateMyWishList();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "Smoke")
	public void orderhistorydetail(){
		indexPage = new Indexpage();
		loginPage = indexPage.ClickOnSign();
		homePage = loginPage.login(property.getProperty("username"),property.getProperty("password"));
		boolean result = homePage.validateMyOrderHistory();
		Assert.assertTrue(false);
	}

}
