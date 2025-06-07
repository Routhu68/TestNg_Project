package swaglab_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import swaglab_test.BaseClass;

public class ProductsPage extends BaseClass {
	
	WebDriver driver= BaseClass.driver;
	
	public void AddToCart(String ProductName) {
		
		String ProductXpath = "//div[text()='" + ProductName + "']//following::button[1]";
		
		WebElement  AddtoCart = driver.findElement(By.xpath(ProductXpath));
		
		AddtoCart.click();
		

	}

}
