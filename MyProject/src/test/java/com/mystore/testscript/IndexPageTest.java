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
import com.mystore.pageobjects.Indexpage;

/**
 * @author Priyanka M
 *
 */
public class IndexPageTest extends BaseClass {
	Indexpage indexPage;
	
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
    public void verifyLogo() {
    	indexPage = new Indexpage();
    	boolean result = indexPage.ValidateLogo();
    	Assert.assertTrue(result); 
       }
	
	@Test(groups = "Smoke")
	public void verifyTitle(){
		String actTitle = indexPage.getMyProjectTitle();
		Assert.assertEquals(actTitle, "My Store");
	}

}
