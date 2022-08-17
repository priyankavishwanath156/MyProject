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
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.Indexpage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

/**
 * @author Priyanka M
 *
 */
public class EndToEndTest extends BaseClass {
	Indexpage indexPage;
	SearchResultPage searchProduct;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummary orderSummary;
	OrderConfirmationPage orderConfirmationPage;
	
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
	public void endtoendtest() {
		indexPage = new Indexpage();
		searchProduct = indexPage.SearchProduct("t-shirt");	
		addToCartPage = searchProduct.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectsize("M");
		addToCartPage.clickonAddToCart();
		orderPage = addToCartPage.clickoncheckOut();
		loginPage = orderPage.ckeckout();
	    addressPage = loginPage.login1(property.getProperty("username"),property.getProperty("password"));
	    shippingPage = addressPage.checkout();
	    shippingPage.checktheterm();
	    paymentPage = shippingPage.checkout();
	    orderSummary = paymentPage.clickonpaymentbank();
	    orderConfirmationPage = orderSummary.clickonConformation();
	    String actualmsg = orderConfirmationPage.validateconfirmationmsg();
	    String expectMsg = "Your order on My Store is complete.";
	    Assert.assertEquals(actualmsg, expectMsg);
	    
	}

}
