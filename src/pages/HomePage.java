package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(css="meta[property='og:title']")
	WebElement HomePageTitle;
	
	@FindBy(name="q")
	WebElement SearchField;
	
	@FindBy(className="search-box__button--1oH7")
	WebElement SearchButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setSearchKeyword(String KeyWord) {
		SearchField.sendKeys(KeyWord);
	}
	
	public void clickSearch() {
		SearchButton.click();
	}
	
	public String getHomePageTitle() {
		return HomePageTitle.getAttribute("content");
	}
	
	public void search(String KeyWord) {
		this.setSearchKeyword(KeyWord);
		this.clickSearch();
	}
}
