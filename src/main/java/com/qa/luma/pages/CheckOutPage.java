package com.qa.luma.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.luma.utils.ElementUtils;

public class CheckOutPage {
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}
	
	private By address1 = By.xpath("//div[@class='shipping-address-items']/div");
	private By nextBtn = By.xpath("//span[text()='Next']");
	private By placeOrderBtn = By.xpath("//span[text()='Place Order']");
	private By orderPlaceSuccessMsg = By.xpath("//span[@class='base']");
	private By orderId = By.xpath("//a[@class='order-number']/strong");
	
	
	public Map<String, String> doCheckOut() {
		Map <String, String> orderdetails = new HashMap<String, String>();
		elementUtils.doClick(address1);
		elementUtils.doClick(nextBtn);
		elementUtils.doClick(placeOrderBtn);
		String msg = elementUtils.doGetText(orderPlaceSuccessMsg);
		String orderid = elementUtils.doGetText(orderId);
		orderdetails.put("Message", msg);
		orderdetails.put("orderid", orderid);
		return orderdetails;
	}
	
}
