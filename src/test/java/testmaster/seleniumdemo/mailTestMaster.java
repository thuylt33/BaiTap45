package testmaster.seleniumdemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageobject.testMaster_page;

/**
 * Unit test for simple App.
 */
public class mailTestMaster {
	WebDriver driver;
	testMaster_page mailPage;

	@Before
	public void InitTest() {
		driver = new FirefoxDriver();
		driver.get("http://testmaster.vn/");
		driver.manage().window().maximize();
		this.mailPage = new testMaster_page(this.driver);
	}

	@After
	public void CloseTest() {
		this.driver.close();
	}

	@Ignore
	@Test
	//Bai1-1 1.	Thông báo email không hợp lệ cho các trường hợp người dùng ko nhập Email hoặc nhập nội dung ko phải là email.
	public void Check_Mail_With_Blank_Ivalues() {
		String s = "* Email không đúng định dạng";
		mailPage.txtEmail.clear();
		mailPage.txtEmail.sendKeys("thuy2011ptitgmail.com");
		mailPage.btnGuiMail.click();

		String s1 = mailPage.mailErr.getText();
		assertEquals(s1, s);

	}

	@Ignore
	@Test
	//2.	Thông báo email đã tồn tại nếu dùng một email đã được sử dụng
	public void Check_MailTonTai() {

	}

	@Test 
	//Bai 1-3.	Mở form extra information nếu email là hợp lệ và chưa dc sử dụng
	public void Check_FormThongTin() {
		mailPage.txtHoten.clear();

		String lbGioiTinhMD = mailPage.txtHoten.getText();
		Assert.assertEquals(lbGioiTinhMD, "Không xác định");

		String lbLoaiTinMD = mailPage.lbLoaiTinMD.getText();
		Assert.assertEquals(lbLoaiTinMD, "Nhận tất cả các loại tin");
	}
	
	
	

}
