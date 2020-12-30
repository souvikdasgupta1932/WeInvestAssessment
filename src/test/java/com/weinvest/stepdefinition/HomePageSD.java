package com.weinvest.stepdefinition;

import com.cucumber.listener.Reporter;
import com.weinvest.PageObjects.HomePage;
import com.weinvest.base.DriverBaseClass;
import com.weinvest.utility.Utility;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class HomePageSD {
	
	HomePage hp;
	Utility utl;
	
	@Given("^I am on the \"([^\"]*)\" page$")
	public void i_am_on_the_page(String title) throws Throwable {
		hp = new HomePage(DriverBaseClass.getDriver());
		Assert.assertEquals(title, hp.getTitle());
		
	}

	@Given("^the user verify text \"([^\"]*)\" is present in the tab$")
	public void the_user_verify_text_is_present_in_the_tab(String value) throws Throwable {
		
		String str = hp.getSelectedModelText(value);
		if(str.trim().contains(value.trim())) {
			Reporter.addStepLog("The displayed message is \n" + str);
			Assert.assertTrue(true);
			
		}
		else {
			Reporter.addStepLog("The displayed message is \n" + str);
			Assert.assertTrue(false);
		}
	    
	}

	@Then("^the user resize the window to \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_resize_the_winow_to_and(String width, String height) throws Throwable {
	   hp.resizeWindow(Integer.parseInt(width), Integer.parseInt(height));
	}

	

	@Then("^the user verify if the count displayed for \"([^\"]*)\" same as \"([^\"]*)\" before resizing$")
	public void the_user_verify_if_the_count_displayed_for_same_as_before_resizing(String value1, String value2) throws Throwable {
	    utl = new Utility();
		String str_beforeResizing = hp.getSelectedModelText(value1);
		String getCount_beforeResizing = utl.getCount(str_beforeResizing);
		String str_afterResizing = hp.getSelectedModelText(value2);
		String getCount_afterResizing = utl.getCount(str_beforeResizing);
		Reporter.addStepLog("Tab Message before re-sizing - "+str_beforeResizing+"\n");
		Reporter.addStepLog("Tab Message after re-sizing - "+str_afterResizing+"\n");
		Assert.assertEquals(getCount_beforeResizing, getCount_afterResizing);
	}
	
	@Then("^the user clicks on \"([^\"]*)\" under \"([^\"]*)\"$")
	public void the_user_clicks_on_under(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    hp.clickXploreideas();
	}
}
