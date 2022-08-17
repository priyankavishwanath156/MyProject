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
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author Priyanka M
 *
 */
public class SearchResultPageTest extends BaseClass{
	
	Indexpage indexPage;
	SearchResultPage searchProduct;
	
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
	public void productavialabilityTest(){
		indexPage = new Indexpage();
		searchProduct = indexPage.SearchProduct("t-shirt");
		boolean result = searchProduct.isproductAvailable();
		Assert.assertTrue(result);
	}

}
