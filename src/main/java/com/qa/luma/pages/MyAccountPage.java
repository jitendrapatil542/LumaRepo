package com.qa.luma.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.luma.utils.ElementUtils;

public class MyAccountPage {
	private WebDriver driver;
	public ElementUtils elementUtils;
	
	//Default constructor-----------------------------------------
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	
	
	//Object repository for customer login page(Locators)---------
	private By loginAcc = By.xpath("(//li[@class='greet welcome'])[1]/span");
	private By Title = By.xpath("//h1/span");
	private	By navPanel = By.xpath("//ul[@class='nav items']//a");
	private By navPaneldelimiter = By.xpath("//ul[@class='nav items']/li[@class='delimiter']");
	private By myOrderslink = By.linkText("My Orders");
	private By myDownloadebleProductslink = By.linkText("My Downloadable Products");
	private By myWishListlink = By.linkText("My Wish List");
	private By addressBooklink = By.linkText("Address Book");
	private By accountInformationlink = By.linkText("Account Information");
	private By storedPaymentMethodPage = By.xpath("Stored Payment Methods']");
	private By myProductReviewsPage = By.xpath("//a[text()='My Product Reviews']");
	private By contactInfoName = By.xpath("//span[text()='Contact Information']/../following::div/p");
	private By contactInfoEmail = By.xpath("//span[text()='Contact Information']/../following::div/p/br");
	private By billingAddress = By.xpath("//div[@class='box box-billing-address']//address");
	private By shippingAddress = By.xpath("//div[@class='box box-shipping-address']//address");
	
	
	//Page actions------------------------------------------------
	public String getLoginAccName() {
		return elementUtils.doGetText(loginAcc);
	}
	
	public String getTitle() {
		return elementUtils.doGetText(Title);
	}
	
	public String getPageTitle() {
		return elementUtils.getPageTitle();
	}
	
	public List<WebElement> getNavigationPanelLinks() {
		List <WebElement> elementsList =  elementUtils.getElements(navPanel);
		return elementsList;
	}
	
	public Map<String, String> getContactinformation() throws InterruptedException {
		Map<String, String> contactInfo = new HashMap<String, String>();
		Thread.sleep(3000);
		contactInfo.put("Name", elementUtils.doGetText(contactInfoName));
		contactInfo.put("Email", elementUtils.doGetText(contactInfoEmail));
		Thread.sleep(3000);
		System.out.println(contactInfo.get("Name"));
		System.out.println(contactInfo.get("Email"));
		return contactInfo;
	}
	
	public String getBillingAddress() {
		String html = elementUtils.doGetAttribute(billingAddress, "innerHTML");
		String[] lines = html.split("<br>");
		String line = "";
		for (String e: lines) {
			line = line + e.trim() + ",";
		}
		return line;
	}
	
	public String getShippingAddress() {
		String html = elementUtils.doGetAttribute(shippingAddress, "innerHTML");
		String[] lines = html.split("<br>");
		String line = "";
		for (String e: lines) {
			line = line + "," + e.trim();
		}
		return line;
	}
	
	public MyOrderPage navigateToMyOrdersPage() {
		elementUtils.doClick(myOrderslink);
		return  new MyOrderPage(driver);
	}
	
	public MyDownloadebleProductsPage navigateToMyDownloadebleProductsPage() {
		elementUtils.doClick(myDownloadebleProductslink);
		return  new MyDownloadebleProductsPage(driver);
	}
	
	public MyWishListPage navigateToMyWishListlPage() {
		elementUtils.doClick(myWishListlink);
		return  new MyWishListPage(driver);
	}
	
	public AddressBookPage navigateToAddressBookPage() {
		elementUtils.doClick(addressBooklink);
		return  new AddressBookPage(driver);
	}
	
	public AccountInformationPage navigateToAccountInformationPage() {
		elementUtils.doClick(accountInformationlink);
		return  new AccountInformationPage(driver);
	}
	
}
