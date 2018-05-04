package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResult {
	WebDriver driver;
	
	@FindBy(css="meta[property='og:title']")
	WebElement SearchResultTitle;
	
	public SearchResult(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getSearchResultTitle() {
		return SearchResultTitle.getAttribute("content");
	}
	
	public void clickProductXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
}
