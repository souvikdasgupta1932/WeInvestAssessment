package com.weinvest.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllWeatherStrategyPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="(//div[contains(@class,'row model-portfolio-name')]/div)[1]")
	private WebElement pageHeader;
	
	@FindBy(xpath="//div[contains(@class,'row model-portfolio-btn')]//a[contains(text(),'Customize Portfolio')][1]")
	private WebElement customizedPortfolio;
	
	public AllWeatherStrategyPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,30);
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyPage() {
		return pageHeader.getText().trim();
	}
	
	public void clickButton() {
		customizedPortfolio.click();
	}

}
