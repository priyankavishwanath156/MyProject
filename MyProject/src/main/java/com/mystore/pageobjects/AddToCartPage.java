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
public class AddToCartPage extends BaseClass {
	
	@FindBy(id="quantity_wanted") 
	WebElement Quantity;
	
	@FindBy(name ="group_1") 
	WebElement size;
	
	@FindBy(xpath ="//span[text()='Add to cart']") 
	WebElement addtocartbtn;
	
	@FindBy(xpath ="//h2[normalize-space()='Product successfully added to your shopping cart']") 
	WebElement addtocartmessage;
	
	@FindBy(xpath ="//span[normalize-space()='Proceed to checkout']") 
	WebElement checkout;
	
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public void enterQuantity(String quantity) {
		Action.type(Quantity, quantity);
	}
	
	public void selectsize(String Size) {
		Action.selectByVisibleText(Size, size);
	}
	
	public void clickonAddToCart() {
		Action.click(getDriver(), addtocartbtn);
	}
	
	public boolean validatemessage() {
		Action.fluentWait(getDriver(), addtocartmessage, 10);
		return Action.isDisplayed(getDriver(), addtocartmessage);
	}
	
	public OrderPage clickoncheckOut() {
		Action.fluentWait(getDriver(), checkout, 10);
		Action.JSClick(getDriver(), checkout);
		return new OrderPage();
	}
	
	

}
