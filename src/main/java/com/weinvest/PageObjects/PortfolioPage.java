package com.weinvest.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortfolioPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private WebElement clickButton;
	private WebElement addStock;
	private List<WebElement> getElement;
	private WebElement policy;
	private List<WebElement> addPolicyPage;
	
	
	@FindBy(xpath="//div[contains(@class,'col-md-12')]//h4")
	WebElement header;
	
	@FindBy(xpath="//a[contains(text(),'Reset')][1]")
	WebElement updateButton;
	
	@FindBy(xpath="(//div[contains(@class,'modal-header') and contains(text(),'Add ETFs')])[1]")
	WebElement selectPolicyHeader;
	
	@FindBy(xpath="(//button[@data-dismiss='modal' and text()='Done'])[1]")
	WebElement doneButton;
	
	
	public PortfolioPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void clickButton(String name) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'"+name+"')][1]")));
		
		clickButton = driver.findElement(By.xpath("//a[contains(text(),'"+name+"')][1]"));
		clickButton.click();
		
	}
	
	public String verifyPage() {
		
		wait.until(ExpectedConditions.visibilityOf(header));
		String headertext = header.getText();
		return headertext;
		
	}
	
	public boolean CheckButtonName(String name) {
			getElement = driver.findElements(By.xpath("//a[contains(text(),'"+name+"')][1]"));
			if(getElement.size()>0) {
				return true;
			}
			return false;
		
		
	}
	
	public void clickonAddStockBasedOnEquity(String buttonName, String equityType) {
		
		addStock = driver.findElement(By.xpath("(//div[contains(text(),'"+equityType+"')]"
				+ "//following::div/a[contains(text(),'"+buttonName+"')])[1]"));
		
		addStock.click();
	}
	
	public void addPolicy(String policyName) {
		
		wait.until(ExpectedConditions.visibilityOf(selectPolicyHeader));
		
		policy = driver.findElement(By.xpath("(//a[contains(text(),'"+policyName+"')]/following::div/button[text()='Add Stock'])[1]"));
		
		policy.click();
	}
	
	public void clickDoneButton() {
		wait.until(ExpectedConditions.visibilityOf(doneButton));
		doneButton.click();
	}
	
	public boolean policyAddedToPage(String policyName, String portfolio) {
		
		addPolicyPage = driver.findElements(By.xpath("(//div[contains(text(),'"+portfolio+"')]/"
				+ "ancestor::div[contains(@class,'col-md')][1]//a[contains(text(),'"+policyName+"')])[2]"));
		if(addPolicyPage.size()==1) {
			return true;
		}
		
		return false;
		
	}

}
