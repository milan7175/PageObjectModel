package amazonPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazonBaseClass.BaseClass;

public class AmazonHomePage<WebElements> extends BaseClass {
	
	
	@FindBy(id="nav-logo-sprites")
	WebElement amazonLogo;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(xpath="//span[text()='Hello, Sign in']")
	WebElement signIn;
	
	@FindBy(className="nav-action-inner")
	WebElement login;
	
	@FindBy(xpath="//div[@class='autocomplete-results-container']/div")
	List<WebElement> searchList;
	
	public  AmazonHomePage() throws Exception {
		super();
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyLogo() {
		return amazonLogo.isDisplayed();
	}
	
	public void search(String a) {
	 	searchBox.sendKeys(a);
	}

	public int searchListSize() {
		return searchList.size();
		}
	
	public AmazonSignInPage goToSignIn() throws Exception {
		Actions builder = new Actions(driver);
		builder.moveToElement(signIn).build().perform();
		
		signIn.click();
		return new AmazonSignInPage();
	}
}
