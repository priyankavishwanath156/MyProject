package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	
	@FindBy(xpath="//strong[normalize-space()='Your order on My Store is complete.']")
	WebElement orderconfmsg;
	
	public OrderConfirmationPage() {
 		PageFactory.initElements(getDriver(), this);	
 	}
	
	public String validateconfirmationmsg() {
		String confirmmsg = orderconfmsg.getText();
		return confirmmsg;
	}

}
