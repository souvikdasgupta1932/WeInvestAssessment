package com.weinvest.stepdefinition;

import org.testng.Assert;

import com.weinvest.PageObjects.AllWeatherStrategyPage;
import com.weinvest.base.DriverBaseClass;

import cucumber.api.java.en.Then;

public class AllWeatherStrategySD {
	
	AllWeatherStrategyPage page;
	
	@Then("^the user verify \"([^\"]*)\" page$")
	public void the_user_verify_page(String value) throws Throwable {
	    page = new AllWeatherStrategyPage(DriverBaseClass.getDriver());
	    String pageText = page.verifyPage();
	    Assert.assertEquals(value, pageText);
	    
	}
	
	@Then("^the user click on \"([^\"]*)\" button$")
	public void the_user_click_on_button(String text) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    page.clickButton();
	}

}
