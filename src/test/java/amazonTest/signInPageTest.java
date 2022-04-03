package amazonTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amazonBaseClass.BaseClass;
import amazonPages.AmazonHomePage;
import amazonPages.AmazonSignInPage;
import junit.framework.Assert;

public class signInPageTest extends BaseClass {
	AmazonHomePage Homepage;
	AmazonSignInPage SignIn;
	
	public signInPageTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		Homepage= new AmazonHomePage();
		SignIn = Homepage.goToSignIn();
		
		
	}
	
	@Test(priority=1)
	public void verifyBlankEmailTest() {
		SignIn.verifyEmailId(prop.getProperty("BlankEmailId"));
		String actErr = SignIn.blankEmailErr();
		String expErr = "Enter your e-mail address or mobile phone number";
		Assert.assertTrue((actErr).contains(actErr));
		
	}
	
	@Test(priority=2)
	public void verifyWrongEmailTest() {
		SignIn.verifyEmailId(prop.getProperty("WrongEmailId"));
		String actErr = SignIn.wrongEmailErr();
		String expErr = "We cannot find an account with that e-mail address";
		Assert.assertTrue((actErr).contains(actErr));
		
	}
	
	@Test(priority=3)
	public void verifyCorrectEmailTest() throws Exception {
		SignIn.verifyEmailId(prop.getProperty("username"));
		SignIn.verifyPassword(prop.getProperty("password"));
		
		String act = driver.getTitle();
		Assert.assertEquals(act, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items");
		
	}
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}

}
