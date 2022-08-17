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
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author Priyanka M
 *
 */
public class OrderPageTest extends BaseClass {
	
	Indexpage indexPage;
	SearchResultPage searchProduct;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser){
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void teardown(){
		getDriver().quit();
	}
	
	@Test(groups = "Regression")
	public void verifyTotalPrice() { 
		indexPage = new Indexpage();
		searchProduct = indexPage.SearchProduct("t-shirt");	
		addToCartPage = searchProduct.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectsize("M");
		addToCartPage.clickonAddToCart();
		OrderPage orderPage = addToCartPage.clickoncheckOut();
		Double unitprice = orderPage.getunitprice();
		Double totalprice = orderPage.gettotalprice();
		Double totalExpectprice=(unitprice*2)+2;
		Assert.assertEquals(totalprice, totalExpectprice);
	}

}
