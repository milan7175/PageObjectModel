package amazonTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazonBaseClass.BaseClass;
import amazonPages.AmazonHomePage;
import amazonPages.AmazonSignInPage;
import amazonPages.MyHomePage;
import junit.framework.Assert;

public class ProfileHomePageTest extends BaseClass {
	
	AmazonHomePage Homepage;
	AmazonSignInPage SignIn;
	MyHomePage Myhome;

	public ProfileHomePageTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		Homepage= new AmazonHomePage();
		SignIn = Homepage.goToSignIn();
		SignIn.verifyEmailId(prop.getProperty("username"));
		Myhome = SignIn.verifyPassword(prop.getProperty("password"));
		}
	
	@Test(priority=1)
	public void verifyProfileNameTest() {
		
		String exp = Myhome.verifyProfileName();
		Assert.assertEquals(exp, "Hello, Milan");
	}
	
	@Test(priority=2)
	public void VerifyLinkTest() {
	 int a = Myhome.verifyLinks();
	
	  Assert.assertEquals(a,31);
	}
	@Test(priority=3)
	public void verifySignoutTest() throws Exception {
		Myhome.verifySignout();
		String act = driver.getTitle();
		Assert.assertEquals(act,"Amazon Sign In");
	}
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}

}
