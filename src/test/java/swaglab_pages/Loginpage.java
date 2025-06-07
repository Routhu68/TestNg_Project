package swaglab_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swaglab_test.BaseClass;

public class Loginpage {
	
	WebDriver driver=BaseClass.driver;
	
	// ====================== Locators =========================

		@FindBy(xpath = "//input[@id='user-name']")
		WebElement UserName;

		@FindBy(xpath = "//input[@id='password']")
		WebElement Password;

		@FindBy(xpath = "//input[@id='login-button']")
		WebElement Loginbutton;

		// ======================= Methods ======================
		
		
		// constructor to initialize all the web elements 
		public Loginpage() {
			
			PageFactory.initElements(driver, this);

		}



	
	public void loginFunction(String ursernameval, String Passwordval) {
		
		
		//WebElement UserName = driver.findElement(By.xpath("//input[@id='user-name']"));
		//WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		//WebElement Loginbutton = driver.findElement(By.xpath("//input[@id='login-button']"));
		
		
		UserName.sendKeys(ursernameval);
		Password.sendKeys(Passwordval);
		Loginbutton.click();
		
		
		
	}

}
