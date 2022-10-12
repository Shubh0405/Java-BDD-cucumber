package com.example.definitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageDefinition {
	
	static ChromeDriver driver = new ChromeDriver();
	
//	@Before
//	public void setup() {
//		driver.manage().window().maximize();
//		driver.get("https://www.flipkart.com");
//		System.out.println("Browser Opened!");
//	}
	
	@Given("launch chrome browser")
	public void OpenBrowser() {
		driver.manage().window().maximize();
		System.out.println("Browser Opened!");
	}
	
	@When("Flipkart home page opens")
	public void OpenFlipkart() {
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@When("Close login dialog")
	public void CloseLoginDialog() {
		
		try {
			
			WebElement close_button = driver.findElement(By.xpath("//button[text()='✕']"));
			close_button.click();
			assert true;
			
		}catch(NoSuchElementException e) {
			System.out.println("Login Button Not found!");
			assert false;
		}
		
	}
	
	@Then("Verify Login Text is Present")
	public void VerifyLoginText() {
		try {
			WebElement login_text = driver.findElement(By.className("_36KMOx")).findElement(By.tagName("span"));   
			
//			if(login_text.getText().equals("Login")) {
//				System.out.println("Login test passed!");
//			}else {
//				takess(driver, "Screenshots/login_test_failed.png");
//
//				System.out.println("Login test failed");
//			}
			
			assert login_text.getText().equals("Login");
			
		}catch(NoSuchElementException e) {
			System.out.println("Login Text Not found!");
			assert false;
		}

	}
	
	@Then("Verify Username field is Present")
	public void VerifyUsernameField() {
		try {
			
			WebElement username_field = driver.findElement(By.xpath("//span[text()='Enter Email/Mobile number']"));
			System.out.println("Username check passed");
			assert true;
			
		}catch(NoSuchElementException e) {
			System.out.println("Username Field not found!");
			assert false;
		}
	}
	
	@Then("Verify Password field is Present")
	public void VerifyPasswordField() {
		
		try {
			
			WebElement password_field = driver.findElement(By.xpath("//span[text()='Enter Password']"));
			System.out.println("Password check passed");
			assert true;
			
		}catch(NoSuchElementException e) {
			System.out.println("Username Field not found!");
			assert false;
		}
		
	}
	
	@Then("Verify Top Categories is present")
	public void VerifyTopCategories() {
		WebElement top_category_text = driver.findElement(By.className("_37M3Pb"));
		List<WebElement> top_Category_list = top_category_text.findElements(By.xpath("//div/a/div[2]"));
		assert top_Category_list.size() > 0;
	}
	
	@Then("Click Mobile Category")
	public void ClickMobileCategory() {
		try {
			WebElement mobile_category = driver.findElement(By.className("_37M3Pb")).findElement(By.xpath("//div[2]/a/div[2][text()='Mobiles & Tablets']"));
			mobile_category.click();
			System.out.println("Mobile Category clicked!");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			assert true;
		}catch(NoSuchElementException e) {
			System.out.println("Mobile Category not found!");
			assert false;
		}
	}
	
	@Then("Click First phone")
	public void ClickFirstPhone() {
		
		try {
			WebElement first_phone = driver.findElement(By.className("_6t1WkM")).findElement(By.xpath("//div[4]/div/div[1]/a"));
			first_phone.click();
			System.out.println("First phone clicked!");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			assert true;
		}catch(NoSuchElementException e) {
			System.out.println("First phone element not found!");
			assert false;
		}
	}
	
	@Then("Verify Filter text on left navbar")
	public void CheckFilterTitle() {
		try {
			WebElement title_filter = driver.findElement(By.xpath("//section/div/div/span"));
			assert title_filter.getText().equals("Filters");
		}catch(NoSuchElementException e) {
			System.out.println("Filter title not found!");
			assert false;
		}
	}
	
	@Then("Set price filter to 20000")
	public void set_price() {
		try {
			
			Select objSelect =new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div/div[1]/div/section[2]/div[4]/div[3]/select")));
			objSelect.selectByVisibleText("₹20000");
			System.out.println("Price field changed!");
			assert true;
			
		}catch(NoSuchElementException e) {
			System.out.println("Price field not found!");
			assert false;
		}
	}

	
	@Then("Close Browser")
	public void CloseBrowser() {
		driver.quit();
	}
	
}
