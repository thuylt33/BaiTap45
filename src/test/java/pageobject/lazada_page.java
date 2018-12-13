package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class lazada_page {
	private WebDriver driver;
	
	@FindBy(xpath="//div/input[@id='q']")
	public WebElement txtTimKiem;
	@FindBy(xpath="//div/div[@class='suggest-list--3Tm8']/a")
	public List<WebElement> txtsuggestions;
	////
	@FindBy(xpath="//div/button[@class='search-box__button--1oH7']")
	public WebElement bntTimKiem;
	
	@FindBy(xpath="//div[@data-qa-locator='product-item']//div[2]/div/a")
	public List<WebElement> listResults;
	@FindBy(xpath="//div[@id='root']//div//li[@title='Next Page']")
	public WebElement btnNextPage;
	
	
	
	public lazada_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
