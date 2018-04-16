package MyTestCases;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class additem {
	public static WebDriver driver;
	@BeforeTest
	public void openurl()
	{   
		//String Path_Chromedriver =System.getProperty("user.dir") +File.separator+ "chromedriver.exe";
		//System.setProperty("webdriver.chrome.driver", Path_Chromedriver);
		System.setProperty("webdriver.chrome.driver", "/usr/lib/chromium-browser/chromedriver");		
		driver = new ChromeDriver();
		driver.get("http://localhost:80");
	}
	@Test
	public void addlistItem1(){
	WebElement textbox = driver.findElement(By.xpath("//*[@id='root']/div/div/form/input"));
	textbox.click();
	textbox.sendKeys("List Item 1");
	WebElement addbutton = driver.findElement(By.xpath("//*[@id='root']/div/div/form/button"));
	addbutton.click();	
	}
	@Test
	public void addlistItem2(){
	WebElement textbox = driver.findElement(By.xpath("//*[@id='root']/div/div/form/input"));
	textbox.click();
	textbox.sendKeys("List Item 2");
	WebElement addbutton = driver.findElement(By.xpath("//*[@id='root']/div/div/form/button"));
	addbutton.click();	
	}
	@Test
	public void addlistItem3(){
	WebElement textbox = driver.findElement(By.xpath("//*[@id='root']/div/div/form/input"));
	textbox.click();
	textbox.sendKeys("List Item 3");
	WebElement addbutton = driver.findElement(By.xpath("//*[@id='root']/div/div/form/button"));
	addbutton.click();	
	}
	@Test
	public void checkListByDefault(){
		List<WebElement> textbox = driver.findElements(By.xpath("//*[@id='root']/div/ul/li"));
		
		SoftAssert s_assert = new SoftAssert();
        if (textbox.size() == 3){
               s_assert.assertTrue(true,"successfull");
        }else{               
               s_assert.fail("fail");
            }
            
            s_assert.assertAll();		
	}
	@Test
	public void deletelistItem1() throws InterruptedException{
		//*[@id="root"]/div/p/a[2]
		WebElement item = driver.findElement(By.xpath("//*[@id='root']/div/ul/li[1]"));
		item.click();
		Thread.sleep(2000);
		WebElement completed = driver.findElement(By.xpath("//*[@id='root']/div/p/a[2]"));
		completed.click();
		Thread.sleep(2000);
		List<WebElement> totalItem = driver.findElements(By.xpath("//*[@id='root']/div/ul/li"));
		SoftAssert s_assert = new SoftAssert();
        if (totalItem.size() == 1){
               s_assert.assertTrue(true,"successfull");
        }else{               
               s_assert.fail("fail");
            }
            
            s_assert.assertAll();		
	}
	@AfterTest
	public void closeTestRun(){
		driver.quit();
	}
	
}

