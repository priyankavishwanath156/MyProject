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
public class AccountCreationPage extends BaseClass {
	
	@FindBy(xpath ="//h1[@class='page-heading']") 
	WebElement FormTitle;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public boolean validateAccountCreationPage() {
		return Action.isDisplayed(getDriver(), FormTitle);
	}
		
	

}
