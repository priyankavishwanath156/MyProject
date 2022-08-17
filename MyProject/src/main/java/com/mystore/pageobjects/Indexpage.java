package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class Indexpage extends BaseClass {
	
	
	@FindBy(xpath ="//a[@class='login']") 
	WebElement SignInBtn;
	
	@FindBy(xpath ="//img[@class='logo img-responsive']") 
	WebElement MyprojectLogo;
	
	@FindBy(xpath ="//input[@id='search_query_top']") 
	WebElement SearchBox;
	
	@FindBy(xpath ="//button[@name='submit_search']") 
	WebElement SearchBtn;
	
	public Indexpage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public LoginPage ClickOnSign() {
		Action.click(getDriver(), SignInBtn);
		return new LoginPage();
	}
	
	public boolean ValidateLogo() {
		return Action.isDisplayed(getDriver(), MyprojectLogo);
	}
	
	public String getMyProjectTitle() {
		String MyProjectTitle = getDriver().getTitle();
		return MyProjectTitle;
	}
	
	public SearchResultPage SearchProduct(String productname) {
		Action.type(SearchBox, productname);
		Action.click(getDriver(), SearchBtn);
		return new SearchResultPage();
	}
	

}
