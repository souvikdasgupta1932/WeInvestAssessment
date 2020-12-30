package com.weinvest.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverBaseClass {

	private WebDriver driver;

	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	public static void setDriver(WebDriver driver) {

		dr.set(driver);

	}

	public static WebDriver getDriver() {
		return dr.get();
	}

	public void setDriver(String url, String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			setDriver(driver);
		}
		
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(url);
			setDriver(driver);
		}
	}

}
