package testng;
import org.testng.annotations.Test;

public class AnnotationsExample extends BaseClass {
	

	
	@Test(groups = {"sanity"})
	public void test1() {
		
		System.out.println("inside testcase1");
	}
	
	@Test
	public void test2() {
		
		System.out.println("inside testcase2");
	}

}
