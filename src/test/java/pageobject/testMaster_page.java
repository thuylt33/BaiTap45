package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class testMaster_page {
	private WebDriver driver;
	
	
	@FindBy(xpath="//div[@class='footer']//input")
	public WebElement txtEmail;
	@FindBy(xpath="//div[@class='footer']//button")
	public WebElement btnGuiMail;
	
	@FindBy(xpath="//div[@class='footer']//span")
	public WebElement mailErr;
	
	////Form thong tin mo
	@FindBy(xpath="//div[@class='modal fade popover-dialog form extra-subscription-form in']//p/input")
	public WebElement txtHoten;
	
	@FindBy(xpath="//div[@class='modal fade popover-dialog form extra-subscription-form in']//button[@id='ddlGender']/span[1]")
	public WebElement lbGioiTinhMD;
	
	@FindBy(xpath="//div[@class='modal fade popover-dialog form extra-subscription-form in']//button[@id='ddlNewsType']/span[1]")
	public WebElement lbLoaiTinMD;
	
	public testMaster_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
