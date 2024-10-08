package testCICD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Allure;

public class loginTest {

	 WebDriver driver;
	 long startTime;

	    @BeforeMethod
	    public void setUp() {
	        // Khởi tạo driver cho trình duyệt Chrome
	    	System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("http://125.212.254.240:8080/FeedbackOnlineOne/login.jsp");
	        startTime = System.currentTimeMillis(); // Lấy thời gian bắt đầu
	    }

	    @Test(description = "Test login form with valid credentials")
	    public void testLogin() {
	        Allure.step("Enter username");
	        driver.findElement(By.name("username")).sendKeys("admin");

	        Allure.step("Enter password");
	        driver.findElement(By.name("password")).sendKeys("12345");

	        Allure.step("Click login button");
	        driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/button")).click();

	        // Thêm các bước kiểm tra kết quả
	        // ...
	    }
	    
	    @Test(description = "Test login form with invalid credentials")
	    public void testInvalidLogin() {
	        Allure.step("Enter username");
	        driver.findElement(By.name("username")).sendKeys("invalidUser");

	        Allure.step("Enter password");
	        driver.findElement(By.name("password")).sendKeys("wrongPassword");

	        Allure.step("Click login button");
	        driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/button")).click();

	        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/div/p"));
	        String messageText = errorMessage.getText();
	        System.out.println("Thông báo lỗi: " + messageText);
	        
//	        Assert.assertEquals(messageText, "Expected error message", "Thông báo lỗi không đúng!"); // Thay đổi "Expected error message" thành thông báo lỗi mong đợi thực tế
	    
	    }

	    @AfterMethod
	    public void tearDown() {
	        long endTime = System.currentTimeMillis();
	        long duration = endTime - startTime;
	        Allure.step("Test started at: " + startTime);
	        Allure.step("Test duration: " + duration + " ms");
	        
//	        driver.quit();
	    }
	
}
