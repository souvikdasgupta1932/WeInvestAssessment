package com.weinvest.PageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.weinvest.utility.Utility;

public class HomePage {
	Utility utl;
	
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	
	@FindBy(xpath="//ul[contains(@class,'model-portfolio-navs')]//a[contains(@href,'selected-model-portfolios')]")
	private List<WebElement> selectedModelPortfolio;
	
	@FindBy(xpath="//ul[contains(@class,'model-portfolio-navs')]//a[contains(@href,'remaining-model-portfolios')]")
	private List<WebElement> remainingModelPortfolio;
	
	@FindBy(xpath="//div[contains(text(),'All Weather Strategy')]/"
			+ "following::div/a[contains(text(),'Explore Investment Ideas') and @href='weather_portfolio']")
	private WebElement button_Xploredeas;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver,30);	
		PageFactory.initElements(this.driver, this);
		 js = (JavascriptExecutor)this.driver;
	}
	
	public void clickXploreideas() {
		button_Xploredeas.click();
	}
	
	public String getSelectedModelText(String tab) {
		
		String gettext = null;
		
		if(tab.contains("preferences")) {
			
			gettext = (js.executeScript("return arguments[0].text", selectedModelPortfolio.get(0))).toString();

			return gettext.trim();
		}
		
		if(tab.contains("Recommended")) {
			gettext = (js.executeScript("return arguments[0].text", selectedModelPortfolio.get(1))).toString();
			return gettext.trim();
		}
		
		if(tab.contains("choices")) {
			gettext = (js.executeScript("return arguments[0].text", remainingModelPortfolio.get(0))).toString();
			return gettext.trim();
		}	 
		
		if(tab.contains("Others")) {
			gettext = (js.executeScript("return arguments[0].text", remainingModelPortfolio.get(1))).toString();
			return gettext.trim();
		}
		
			
		return null;
		
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void resizeWindow(int width,int height) {
		utl = new Utility();
		driver.manage().window().setSize(utl.resizingWindowutil(width, height));
		wait.until(ExpectedConditions.visibilityOfAllElements(remainingModelPortfolio.get(1)));
	}
	
	public void gettabValue() {
		
		
		
	}

}
