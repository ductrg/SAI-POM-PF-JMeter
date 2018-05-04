package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails {
	WebDriver driver;
	
	@FindBy(css="meta[name='og:title']")
	WebElement ProductDetailsTitle;
	
	public ProductDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProductDetailsTitle() {
		return ProductDetailsTitle.getAttribute("content");
	}
}
