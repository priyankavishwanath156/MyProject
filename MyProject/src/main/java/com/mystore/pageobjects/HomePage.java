/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Priyanka M
 *
 */
public class HomePage extends BaseClass {
	
	@FindBy(xpath = "//span[normalize-space()='My wishlists']")
	WebElement MyWishList;
	
	@FindBy(xpath = "//span[normalize-space()='Order history and details']")
	WebElement OrderHistory;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public boolean validateMyWishList() {
		return Action.isDisplayed(getDriver(), MyWishList);
	}
	
	public boolean validateMyOrderHistory() {
		return Action.isDisplayed(getDriver(), OrderHistory);
	}
	
	public String getcurrURL() {
		String homePageURL = getDriver().getCurrentUrl();
		return homePageURL;
	}

}
