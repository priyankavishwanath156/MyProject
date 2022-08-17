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
public class OrderPage extends BaseClass {
	
	@FindBy(xpath="//span[contains(text(),'$16.51')]")
	WebElement unitprice;
	
	@FindBy(xpath="//span[@id='total_price']")
	WebElement Totalprice;
	
	@FindBy(xpath="(//span[contains(text(),'Proceed to checkout')])[2]")
	WebElement procedtocheckout;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public double getunitprice() {
		String unitprice1 = unitprice.getText();
		String unit = unitprice1.replaceAll("[^a-zA-Z0-9]", "");
		double Finalunitprice = Double.parseDouble(unit);
		return Finalunitprice/100;
	}
	
	public double gettotalprice() {
		String price1 = Totalprice.getText();
		String totalprice = price1.replaceAll("[^a-zA-Z0-9]", "");
		double FinalTotalprice = Double.parseDouble(totalprice);
		return FinalTotalprice/100;
	}
	
	public LoginPage ckeckout() {
		Action.click(getDriver(), procedtocheckout);
		return new LoginPage();
	}
	
	

}
