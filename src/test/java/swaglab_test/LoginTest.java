package swaglab_test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import swaglab_pages.Loginpage;

@Listeners(Listener.class)

public class LoginTest extends BaseClass {

	@Test(priority = 0)
	public void LoginSuccessTest() {

		Loginpage lp = new Loginpage();

		lp.loginFunction("standard_user", "secret_sauce");

		// driver.close();

		WebElement Title = driver.findElement(By.className("title"));
		Assert.assertEquals(Title.getText(), "Products");

	}

	@Test(priority = 1)
	public void LoginFailureTest() {

		Loginpage lp = new Loginpage();

		lp.loginFunction("standard_user", "secret_sauce1");

		WebElement Error = driver.findElement(By.tagName("h3"));

		Assert.assertEquals(Error.getText(),
				"Epic sadface: Username and password do not match any user in this service");

	}

	@Test
	public void LockedUserLoginFailureTest() {

		Loginpage lp = new Loginpage();
		lp.loginFunction("locked_out_user", "secret_sauce");

		WebElement ErrorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
		Assert.assertEquals(ErrorMsg.getText(), "Epic sadface: Sorry, this user has been locked out.");

	}

	@Test
	public void LoginFailureTestFromExcel() {

		String UserNameVal = Sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = Sheet.getRow(1).getCell(1).getStringCellValue();

		Loginpage lp = new Loginpage();
		lp.loginFunction(UserNameVal, PasswordVal);

		WebElement ErrorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
		Assert.assertEquals(ErrorMsg.getText(),
				"Epic sadface: Username and password do not match any user in this service");

		int rowNum = 0;
		Sheet.getRow(rowNum).createCell(2).setCellValue("DONE");

	}

	@Test
	public void LoginFailureTestFromProperties() throws IOException {

		FileReader reader = new FileReader("data.properties");
		Properties prop = new Properties();
		prop.load(reader);

		String UserNameVal = prop.getProperty("UserName");
		String PasswordVal = prop.getProperty("Password");

		Loginpage lp = new Loginpage();
		lp.loginFunction(UserNameVal, PasswordVal);

		WebElement ErrorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
		Assert.assertEquals(ErrorMsg.getText(),"Epic sadface: Username and password do not match any user in this service");

		// Sheet.getRow(1).createCell(2).setCellValue("Completed");

	}

}
