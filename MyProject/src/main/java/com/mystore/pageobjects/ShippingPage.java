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
public class ShippingPage extends BaseClass{
	
	@FindBy(xpath="//input[@id='cgv']")
	WebElement term;
	
	@FindBy(xpath="(//span[contains(text(),'Proceed to checkout')])[2]")
	WebElement procedtocheckout;
	
	 public ShippingPage() {
 		PageFactory.initElements(getDriver(), this);	
 	}
	 
	 public void checktheterm() {
		 Action.click(getDriver(), term);
	 }
	 
	 public PaymentPage checkout() {
		 Action.click(getDriver(), procedtocheckout);
		 return new PaymentPage();
	 }
}
	 

