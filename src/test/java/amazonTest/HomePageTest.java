package amazonTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazonBaseClass.BaseClass;
import amazonPages.AmazonHomePage;


public class HomePageTest extends BaseClass {
	
	AmazonHomePage Homepage;

	public HomePageTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		Homepage= new AmazonHomePage();
	}
	
	@Test(priority=1)
	public void pageTitleTest() {
		String act = Homepage.verifyPageTitle();
		Assert.assertEquals(act, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items");
	}
	
	@Test(priority=3)
	public void logoTest() {
		boolean flag = Homepage.verifyLogo();
		Assert.assertTrue(flag, "wronglogo");
	}
	
	@Test(priority=2)
	public void verifySearchSize() {
		Homepage.search(prop.getProperty("search"));
		int x = Homepage.searchListSize();
		Assert.assertEquals(x, 10);
	}
	
	@Test(priority=4)
	public void signupTest() throws Exception {
		Homepage.goToSignIn();
		String act = driver.getTitle();
		Assert.assertEquals(act, "Amazon Sign In");
	}
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}
	
	

}
