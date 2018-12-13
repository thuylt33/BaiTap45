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

import pageobject.lazada_page;
import pageobject.testMaster_page;

/**
 * Unit test for simple App.
 */
public class TimKiemLazada {
	WebDriver driver;
	lazada_page TimKiemLazadaPage;

	@Before
	public void InitTest() {
		driver = new FirefoxDriver();
		driver.get("https://www.lazada.vn/#");
		driver.manage().window().maximize();
		this.TimKiemLazadaPage = new lazada_page(this.driver);
	}

	@After
	public void CloseTest() {
		this.driver.close();
	}

	@Ignore
	@Test
	//Bai3-1.	Top 10 sản phẩm phù hợp với từ khóa sẽ hiển thị lên suggestion box khi người dùng nhập nội dung
	public void check_dispplay_10_suggest() {
		
		TimKiemLazadaPage.txtTimKiem.clear();
		TimKiemLazadaPage.txtTimKiem.sendKeys("áo");
		TimKiemLazadaPage.bntTimKiem.click();
		
		int i=TimKiemLazadaPage.txtsuggestions.size();

	//	check dispplay 10 suggest
      Assert.assertEquals(10, i);

	}

	
	@Test
	//bai 3- 2.	Khi thực hiện tìm kiếm hãy chắc chắn rằng tất cả các kết quả phải có chứa từ khóa
	public void Check_MailTonTai() throws InterruptedException {
        String keyTimKiem = "Áo thun trơn nữ form rộng phong cách hàn quốc vải dày mịn Thời trang (xám)"   ;
		TimKiemLazadaPage.txtTimKiem.sendKeys(keyTimKiem);
		TimKiemLazadaPage.bntTimKiem.click();
		   int k = 0;
		   do {
			   Thread.sleep(9000);
               System.out.println(TimKiemLazadaPage.btnNextPage.getAttribute ("aria-disabled"));
               Thread.sleep(9000);
               
               System.out.println("cho doi11222erwer"+TimKiemLazadaPage.listResults.size());


               for (WebElement listResult : TimKiemLazadaPage.listResults) {


                   k++;
                   System.out.println(k + "STT   " + listResult.getText());

                   listResult.getText().contentEquals(keyTimKiem);

               }
//Click nexxt page

               Thread.sleep(1000);
               System.out.println("heee");
               ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, (document.body.scrollHeight)*14/16)");
          
                 Thread.sleep(1000);
                 TimKiemLazadaPage.btnNextPage.click();
      


           }

       while(TimKiemLazadaPage.btnNextPage.getAttribute ("aria-disabled").equals("false"));


   }   
		   
		   
		   
		   
		

	

}
