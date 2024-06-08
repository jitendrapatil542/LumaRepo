package com.qa.luma.factory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	WebDriver driver;
	Properties prop;
	OptionManager optionManager;
	

	public WebDriver init_Browser(String browser, Properties prop) {
		System.out.println("Opening browser :"+ browser);
		optionManager = new OptionManager(prop);
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().clearDriverCache().setup();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optionManager.getChromeOptions());			
		}
		else if (browser.equalsIgnoreCase("FireFox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver(optionManager.getFirefoxOptions());			
		}
		else if (browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();			
		}
		else {
			System.out.println("Invalid browser name : "+ browser);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://magento.softwaretestingboard.com/");
		return driver;
	}
	
	
	
	
	public Properties init_prop() {
		Properties prop = new Properties();
		FileInputStream ip=null;
		try {
			ip = new FileInputStream("./src/test/resources/config/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
