package com.weinvest.utility;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Utility {
	
	public static String url=null;
	public static String browser = null;
	public static void getUtility() throws Exception {
		FileReader reader = new FileReader("src/test/resources/test.properties");
		Properties p = new Properties();
		p.load(reader);
		url = p.getProperty("URL");
		browser = p.getProperty("Browser");
	}
	
	public Dimension resizingWindowutil(int width,int height) {
		Dimension dm = new Dimension(width,height);
		return dm;
		
	}
	
	public String getCount(String str) {
		
		Pattern pt = Pattern.compile("[0-9]*");
		Matcher mt = pt.matcher(str);
		if(mt.find()) {
			return mt.group();
		}
		
		return null;
		
	}
	
	public File takeScreenshot(String ScreenshotName, WebDriver driver) throws IOException {
		
		File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destinationPath = new File(System.getProperty("user.dir") +
				"/target/reports/" + ScreenshotName + ".png");
		Files.copy(sourcePath, destinationPath);
		
		return destinationPath;
		
	}

}
