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
public class LoginPage extends BaseClass {
	
	
	@FindBy(id ="email") 
	WebElement username;
	
	@FindBy(name ="passwd") 
	WebElement password;
	
	@FindBy(id ="SubmitLogin") 
	WebElement submitBtn;
	
	@FindBy(name ="email_create") 
	WebElement CreatenewAccount;
	
	@FindBy(xpath ="//button[@id='SubmitCreate']") 
	WebElement CreatenewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public HomePage login(String uname,String pwd) {
		Action.type(username, uname);
		Action.type(password, pwd);
		Action.click(getDriver(), submitBtn);
		return new HomePage();
	}
	
	public AddressPage login1(String uname,String pwd) {
		Action.fluentWait(getDriver(), username, 10);
		Action.type(username, uname);
		Action.type(password, pwd);
		Action.click(getDriver(), submitBtn);
		return new AddressPage();
	}
	
	public AccountCreationPage CreateNewEmail(String newemail) {
		Action.type(CreatenewAccount, newemail);
		Action.click(getDriver(), CreatenewAccountBtn);
		return new AccountCreationPage();
	}

}
