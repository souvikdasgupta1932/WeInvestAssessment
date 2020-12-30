package com.weinvest.stepdefinition;

import com.weinvest.PageObjects.PortfolioPage;
import com.weinvest.base.DriverBaseClass;

import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class PortfolioSD {
	
	PortfolioPage pf;
	
	@Then("^the user is on the \"([^\"]*)\" page$")
	public void the_user_is_on_the_page(String header) throws Throwable {
	   pf = new PortfolioPage(DriverBaseClass.getDriver());
	   Assert.assertEquals(header, pf.verifyPage().trim());
	}
	
	@Then("^the user click on \"([^\"]*)\" button on Portfolio Page$")
	public void the_user_click_on_button_on_Portfolio_Page(String buttonName) throws Throwable {
	    pf.clickButton(buttonName);
	}
	
	@Then("^verify \"([^\"]*)\" text changes to \"([^\"]*)\" button$")
	public void verify_text_changes_to_button(String existingName, String updateName) throws Throwable {
	    boolean exName = pf.CheckButtonName(existingName);
	    Assert.assertFalse(exName);
	    boolean upName = pf.CheckButtonName(updateName);
	    Assert.assertTrue(upName);
	}
	
	@Then("^click on \"([^\"]*)\" under \"([^\"]*)\"$")
	public void click_on_under(String addStock, String equityType) throws Throwable {
	    pf.clickonAddStockBasedOnEquity(addStock, equityType);
	}
	
	@Then("^add \"([^\"]*)\"$")
	public void add(String policyName) throws Throwable {
		pf.addPolicy(policyName);
	}

	@Then("^click on \"([^\"]*)\" button$")
	public void click_on_button(String arg1) throws Throwable {
	    pf.clickDoneButton();
	}

	@Then("^verify \"([^\"]*)\" added to \"([^\"]*)\"$")
	public void verify_added_to(String ploicyName, String portfolio) throws Throwable {
	  boolean bool = pf.policyAddedToPage(ploicyName, portfolio);
	  Assert.assertTrue(bool);
	  
	}
	
	

}
