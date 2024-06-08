package com.qa.luma.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.luma.utils.ElementUtils;

public class ProductPage {
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	//Default constructor-----------------------------------------
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver); 
	}
	
	//Object repository for customer login page(Locators)---------
	private By prodcutName = By.xpath("//span[@itemprop='name']");
	private By prodcutSKU = By.xpath("//div[@itemprop='sku']");
	private By prodcutPrice = By.xpath("//div[@class='product-info-main']//span[@class='price']");
	private By prodcutSize = By.xpath("//div[@attribute-code='size']/div/div");
	private By prodcutColor = By.xpath("//div[@attribute-code='color']/div/div");
	private By prodcutImg = By.xpath("//div[@class='fotorama__nav__shaft']//img");
	private By AddToCartBtn = By.id("product-addtocart-button");
	private By message = By.xpath("(//div[@role='alert']//div)[2]");
	private By cartBtn = By.xpath("//a[@class='action showcart']");
	private By viewCartLink = By.className("viewcart");
	
	//Page actions------------------------------------------------
	public String getPageTitle() {
		return elementUtils.getPageTitle();
	}
	
	public String getproductName() {
		return elementUtils.doGetText(prodcutName);
	}
	
	public String getProductPrice() {
		return elementUtils.doGetText(prodcutPrice);
	}
	
	public String getProductSKU() {
		return elementUtils.doGetText(prodcutSKU);
	}
	
	public List<WebElement> getProductSize() {
		return elementUtils.getElements(prodcutSize);
	}
	
	public List<WebElement> getProductColor() {
		return elementUtils.getElements(prodcutColor);
	}
	
	public boolean addToCartProduct() {
		elementUtils.doClick(prodcutSize);
		elementUtils.doClick(prodcutColor);
		elementUtils.doClick(AddToCartBtn);
		String msg = elementUtils.doGetText(message);
		if (msg.contains("You added")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public CartPage nevigateToCart() {
		elementUtils.doClick(cartBtn);
		elementUtils.doClick(viewCartLink);
		return new CartPage(driver);
	}
	

}
