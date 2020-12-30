package com.weinvest.base;

import java.io.File;
import java.io.IOException;

import com.cucumber.listener.Reporter;
import com.weinvest.utility.Utility;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	private Utility utl;

	@Before
	public void initialisation() throws Exception {
		//Utility utl = new Utility();
		Utility.getUtility();
		

		DriverBaseClass intiDriverClass = new DriverBaseClass();
		intiDriverClass.setDriver(Utility.url, Utility.browser);
		System.out.println("new");

	}
	
	@After(order = 1)
	public void failedScenario(Scenario scenario) throws IOException {
		
		if(scenario.isFailed()) {
			String screenshotName = scenario.getName().replace(" ", "_");
			utl = new Utility();
			File destination = utl.takeScreenshot(screenshotName, DriverBaseClass.getDriver());
			Reporter.addScreenCaptureFromPath(destination.toString());
		}
		
		
	}

	@After(order =0)
	public void AfterSteps() {
		DriverBaseClass.getDriver().quit();
	}

}
