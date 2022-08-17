package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.w3c.dom.DOMConfiguration;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties property;
	//public static WebDriver driver;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
	public void Config() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		 
	}
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void readConfig() {
		try {
			property = new Properties();
			 FileInputStream Fs= new FileInputStream(System.getProperty("user.dir")+"/Configuration/Config.properties");
			
				property.load(Fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void launchApp(String browsername) {
		
		//String browsername = property.getProperty("browser");
		
	  if (browsername.contains("Chrome")) {
		  WebDriverManager.chromedriver().setup();
		  //driver = new ChromeDriver();
		  driver.set(new ChromeDriver());
	  }else if(browsername.contains("Firefox")) {
		  WebDriverManager.firefoxdriver().setup();
		  driver.set(new FirefoxDriver());
		  //driver = new FirefoxDriver();
	  }else if(browsername.contains("IE")) {
		  WebDriverManager.iedriver().setup();
		 // driver = new InternetExplorerDriver();
		  driver.set(new InternetExplorerDriver());
		
	}
	  Action.implicitWait(getDriver(), 10);
	  Action.pageLoadTimeOut(getDriver(), 30);
	  
	  getDriver().get(property.getProperty("url"));


	}
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
	
	
	
}
