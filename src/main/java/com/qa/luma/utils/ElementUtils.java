package com.qa.luma.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementUtils {
	private WebDriver driver;
	private Actions act;
	
	
	//Default constructor-----------------------------------------
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		act = new Actions(this.driver);
	}
	
	
	
	//**********************General WebDriver Actions*******************************
	public WebElement getElement(By Locator) {
		return driver.findElement(Locator);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public List<WebElement> getElements(By Locator) {
		return driver.findElements(Locator);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String doGetAttribute(By locator, String attribute) {
		return attribute = getElement(locator).getAttribute(attribute);
	}
	
	public void doSendkeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public String doGetText(By locator) {
		String value = getElement(locator).getText();
		return value;
	}

	public boolean isDisplay(By locator) {
		boolean value = getElement(locator).isDisplayed();
		return value;
	}
	
	public boolean isEnable(By locator) {
		boolean value = getElement(locator).isEnabled();
		return value;
	}
	
	public boolean isSelected(By locator) {
		boolean value = getElement(locator).isSelected();
		return value;
	}
	
	public List<String> getListOfElements(By locator) {
		List<WebElement> elements = getElements(locator);
		List<String> elementsValue = new ArrayList<String>() ;
		for (WebElement e : elements) {
			elementsValue.add(e.getText());
		}
		return elementsValue;
	}
	
	//**********************Drop-down Actions*******************************
	public void doSelectByValue(By locator, String value) {
		WebElement dropDown = getElement(locator);
		Select option = new Select(dropDown);
		option.selectByValue(value);
	}
	
	public void doSelectByIndex(By locator, int value) {
		WebElement dropDown = getElement(locator);
		Select option = new Select(dropDown);
		option.selectByIndex(value);;
	}
	
	public void doSelectByVisibleText(By locator, String value) {
		WebElement dropDown = getElement(locator);
		Select option = new Select(dropDown);
		option.selectByVisibleText(value);;
	}
	
	
	//**********************Actions Class Methods*******************************
	public void doMoveToElement(By locator) {
		act.moveToElement(getElement(locator)).perform();
	}
	
	public void doMoveToElementAndClick(By locator) {
		act.moveToElement(getElement(locator)).click().perform();
	}
	

}
