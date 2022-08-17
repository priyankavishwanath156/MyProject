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
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.Indexpage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author Priyanka M
 *
 */
public class AddToCartPageTest extends BaseClass {
	Indexpage indexPage;
	SearchResultPage searchProduct;
	AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser){
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown(){
		getDriver().quit();
	}
	
	@Test(groups = {"Regression","Sanity"})
	public void addToCartPage() {
		indexPage = new Indexpage();
		searchProduct = indexPage.SearchProduct("t-shirt");	
		addToCartPage = searchProduct.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectsize("S");
		addToCartPage.clickonAddToCart();
		boolean result = addToCartPage.validatemessage();
		Assert.assertTrue(result);
		}
}
