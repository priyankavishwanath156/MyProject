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
public class PaymentPage extends BaseClass {
	
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	WebElement bankwiremethod;
	
	@FindBy(xpath="//a[@title='Pay by check.']")
	WebElement paybycheckmethod;
	
	 public PaymentPage() {
	 		PageFactory.initElements(getDriver(), this);	
	 	}
	 
	 public OrderSummary clickonpaymentbank() {
		 Action.click(getDriver(), bankwiremethod);
		 return new OrderSummary();
	 }
	 
	 

}
