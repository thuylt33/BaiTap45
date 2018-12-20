package testmaster.seleniumdemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		System.setProperty("webdriver.chrome.driver", "D:\\Setup\\Eclipse\\chromedriver.exe");
		driver = new ChromeDriver();
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
	// Bai1-1 1. Thông báo email không hợp lệ cho các trường hợp người dùng ko nhập
	// Email hoặc nhập nội dung ko phải là email.
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
	// bai1-2. Thông báo email đã tồn tại nếu dùng một email đã được sử dụng
	public void Check_MailTonTai() throws InterruptedException {

		mailPage.txtEmail.clear();
		mailPage.txtEmail.sendKeys("thuy2011ptit@gmail.com");
		mailPage.btnGuiMail.click();
		Thread.sleep(4000);
		String s1 = mailPage.mailTonTaiMess.getText();
		System.out.println(s1);
		assertEquals("E-mail thuy2011ptit@gmail.com đã được sử dụng, bạn hãy chọn một E-mail khác", s1);
	}

	//@Test
	// Bai 1-3. Mở form extra information nếu email là hợp lệ và chưa dc sử dụng
	public void Check_MoFormThongTin() throws InterruptedException {
		Date today = new Date();

		// formatting date in Java using SimpleDateFormat
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("ddMMyyHHmmSS");
		String date = DATE_FORMAT.format(today);
		System.out.println("Today in ddMMyyHHmmSS format : " + date);

		String s = date + "@gmail.com";
		Thread.sleep(4000);
		System.out.println("Today in ddMMyyHHmmSS format : " + date + "nhap s  " + s);

		mailPage.txtEmail.clear();
		mailPage.txtEmail.sendKeys(s);
		mailPage.btnGuiMail.click();
		Thread.sleep(4000);
		String s1 = mailPage.statusNewSus.getText();
		Assert.assertEquals("Để phục vụ bạn được tốt hơn, bạn vui lòng cung cấp thêm các thông tin bên dưới.", s1);

	}
	/// bai2 - check hop le 

//@Test 

//Bai 2-1.	Họ và tên là bắt buộc, giới tính có giá trị mặc định là Không xác định, loại tin đăng ký có giá trị mặc định là Tất cả các loại tin
	public void Check_FormThongTin() throws InterruptedException {
	Check_MoFormThongTin();
		mailPage.txtHoten.clear();
		mailPage.btnDongY.click();
		Thread.sleep(3000);
		String txtMessHoTenRequired = mailPage.txtMessHoTenRequired.getText();
		Assert.assertEquals(txtMessHoTenRequired, "This is required field");

		String lbGioiTinhMD = mailPage.lbGioiTinhMD.getText();
		Assert.assertEquals(lbGioiTinhMD, "Không xác định");

		String lbLoaiTinMD = mailPage.lbLoaiTinMD.getText();
		Assert.assertEquals(lbLoaiTinMD, "Nhận tất cả các loại tin");

	}

//Bai 2-2.	Người dùng ko thể đăng ký nếu không nhập Họ và tên hợp lệ (không được chdứa số và ký tự đặc biệt).
	public void CheckHoTenKoHopLe() throws InterruptedException {
		Check_MoFormThongTin();
		mailPage.txtHoten.clear();
		mailPage.txtHoten.sendKeys("1234#$%");
		mailPage.btnDongY.click();
		
		Assert.assertEquals(mailPage.MessValidateHoTen.getText(), "");
	}
	@Test
//3.	Thông báo người dùng đã đăng ký thành công và cần check Email để kích hoạt
	public void CheckHoTenHopLe() throws InterruptedException  {
		Check_MoFormThongTin();
		mailPage.txtHoten.clear();
		mailPage.txtHoten.sendKeys("thuyle");
		mailPage.btnDongY.click();
		// Get a handle to the open alert, prompt or confirmation
		Alert alert = driver.switchTo().alert();
		// Get the text of the alert or prompt
		alert.getText(); 
		System.out.println(alert.getText());
		// And acknowledge the alert (equivalent to clicking "OK")
		//alert.accept();
		
		//Assert.assertEquals(mailPage.MessValidateHoTen.getText(), "");
	}
//4.	Kiểm tra link kích hoạt gửi vào Email có hoạt động hay không (kỹ năng nâng cao, cần biết thao tác với mailbox để lấy email về và tách link từ Email content)
	
	

}
