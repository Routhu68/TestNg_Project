package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	@BeforeTest(alwaysRun=true)
	public void Method4() {
		
		System.out.println("Before Test method");
	}
	
	@AfterTest(alwaysRun=true)
	public void Method5() {
		
		System.out.println("After Test method");
	
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public void method1() {

		System.out.println("Before inside method");
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void method2() {
		
		System.out.println("after inside method");

}
}