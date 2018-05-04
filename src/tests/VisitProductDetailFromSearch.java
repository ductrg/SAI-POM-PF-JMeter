package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import pages.HomePage;
import pages.SearchResult;
import pages.ProductDetails;

public class VisitProductDetailFromSearch {
	WebDriver driver;
	HomePage objHomePage;
	SearchResult objSearchResult;
	ProductDetails objProductDetails;
	
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://www.lazada.vn/");
	}

	public void visitProductDetail() {
		objHomePage = new HomePage(driver);
		String HomeTitle = objHomePage.getHomePageTitle();
		Assert.assertTrue(HomeTitle.equals("Shopping online - Buy online on Lazada.vn"));
		
		//search for iphone keyword and click submit
		objHomePage.search("iphone");
		
		//verify search result redirection
		objSearchResult = new SearchResult(driver);
		String SearchResultTitle = objSearchResult.getSearchResultTitle();
		Assert.assertTrue(SearchResultTitle.contains("Apple - Mua Apple"));
		
		//click an iphone 8 product and direct to its detail page
		objSearchResult.clickProductXpath("//a[@title='Apple iPhone 8 64GB Space Grey']");
		
		//verify product detail redirection
		objProductDetails = new ProductDetails(driver);
		String ProductDetailsTitle = objProductDetails.getProductDetailsTitle();
		Assert.assertTrue(ProductDetailsTitle.equals("Apple iPhone 8 64GB Space Grey"));
	}
	
	public static void main(String[] args) {		
		VisitProductDetailFromSearch testVisit = new VisitProductDetailFromSearch();
		testVisit.setUp();
		testVisit.visitProductDetail();
		System.out.println("passed");
	}
}
