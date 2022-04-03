package amazonPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazonBaseClass.BaseClass;

public class MyHomePage extends BaseClass {

	public MyHomePage() throws Exception {
		super();
		
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement profileName;
	
	@FindBy(xpath="//div[@id='nav-main']/div//a")
	List<WebElement> homePageLinks;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	WebElement signOut;
	
	
	public String verifyProfileName() {
		return profileName.getText();
	}
	
	public int verifyLinks() {
		return homePageLinks.size();
//		for(WebElement a:homePageLinks ) {
//			System.out.println(a.getText());
//		}
	}
	
	public AmazonSignInPage verifySignout() throws Exception {
		Actions builder = new Actions(driver);
		builder.moveToElement(profileName).build().perform();
		Thread.sleep(3000);
		signOut.click();
		return new AmazonSignInPage();
	}
	
}
