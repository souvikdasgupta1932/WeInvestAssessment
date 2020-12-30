package com.weinvest.base;



import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport ="target/reports/index.json",
retryCount=0,detailedReport =true,
detailedAggregatedReport =true,
overviewReport=true,
coverageReport=true,
jsonUsageReports="target/reports/index-usage.json",
usageReport=false,
toPDF=true,		 
outputFolder="target/reports/")
@CucumberOptions(
		features= "src/test/resources/feature",
		glue={"com.weinvest.stepdefinition","com.weinvest.base"},
		tags= {"@Feature"},
		plugin = {"pretty", "json:target/reports/index.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/reports/index.html"}
		
		)

public class CucumberRunner {

}
