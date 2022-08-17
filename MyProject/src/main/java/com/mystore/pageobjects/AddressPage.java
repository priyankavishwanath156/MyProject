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
public class AddressPage extends BaseClass{
        @FindBy(xpath="(//span[contains(text(),'Proceed to checkout')])[2]")
        WebElement procedtocheckout;
        
        
        public AddressPage() {
    		PageFactory.initElements(getDriver(), this);
    		
    	}
        
        
        public ShippingPage checkout() {
        	Action.click(getDriver(), procedtocheckout);
        	return new ShippingPage();
        }
}
