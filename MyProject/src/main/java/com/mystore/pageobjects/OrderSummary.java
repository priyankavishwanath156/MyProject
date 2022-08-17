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
public class OrderSummary  extends BaseClass{
	
	@FindBy(xpath="//span[normalize-space()='I confirm my order']")
	WebElement conformmyOrder;
	
	public OrderSummary() {
 		PageFactory.initElements(getDriver(), this);	
 	}
	
	public OrderConfirmationPage clickonConformation(){
		Action.click(getDriver(), conformmyOrder);
		return new OrderConfirmationPage();
	}

}
