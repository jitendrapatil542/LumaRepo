package com.qa.luma.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.luma.utils.ElementUtils;

public class CustomerHomePage {

	private ElementUtils elementUtils;
	private WebDriver driver;
	
	//Default constructor-----------------------------------------
	public CustomerHomePage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}
	
	
	//Object repository for customer login page(Locators)---------
	private By customerManu = By.xpath("(//button[@data-action = 'customer-menu-toggle'])[1]");
	private By customerManu_myaccount = By.linkText("My Account");
	private By customerManu_myWishList = By.linkText("My Wish List ");
	private By customerManu_signOut = By.linkText("Sign Out ");
	private By promotionalProducts = By.xpath("//div[@class ='blocks-promo']//a");
	private By hotSellersProduct = By.xpath("//h2[text()='Hot Sellers']//parent::div//following::div[@class='block widget block-products-list grid']//img");
	private By mainCategories = By.xpath("//ul[@id='ui-id-2']/li");
	private By whatsNew = By.linkText("What's New");
	private By womenCategories = By.id("ui-id-4");
	private By women_tops = By.id("ui-id-9");
	private By women_tops_jackets = By.id("ui-id-11");
	private By menCategories = By.linkText("Men");
	private By gearCategories = By.linkText("Gear");
	private By trainingCategories = By.linkText("Training");
	private By saleCategories = By.linkText("Sale");
	private By loginAcc = By.xpath("(//li[@class='greet welcome'])[1]/span");
	
	//Page actions------------------------------------------------
	public String getLoginAccName() throws InterruptedException {
		Thread.sleep(6000);
		return elementUtils.doGetText(loginAcc);
	}
	
	public String getPageTitle() {
		return elementUtils.getPageTitle();
	}
	
	public MyAccountPage homePageToMyAccountPage() {
		elementUtils.doClick(customerManu);
		elementUtils.doClick(customerManu_myaccount);
		return new MyAccountPage(driver);
	}
	
	public MyWishListPage homePageToMyWishListPage() {
		elementUtils.doClick(customerManu);
		elementUtils.doClick(customerManu_myWishList);
		return new MyWishListPage(driver);
	}
	
	public MainPage logOut() {
		elementUtils.doClick(customerManu);
		elementUtils.doClick(customerManu_signOut);
		return new MainPage(driver);
	}
	
	public List<WebElement> getPromotionalProductList() {
		return elementUtils.getElements(promotionalProducts);
	}
	
	public List<WebElement> getHotSellersList() {
		return elementUtils.getElements(hotSellersProduct);
	}
	
	public ProductsPage nevigateToWomen_top_jackets_ProductsPage() {
		elementUtils.doMoveToElement(womenCategories);
		elementUtils.doMoveToElement(women_tops);
		elementUtils.doMoveToElementAndClick(women_tops_jackets);
		return new ProductsPage(driver);
	}
}


