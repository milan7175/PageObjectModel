package amazonPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazonBaseClass.BaseClass;

public class AmazonSignInPage extends BaseClass{

	public AmazonSignInPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
			}

	@FindBy(id="ap_email")
	WebElement emailBox;
	
	@FindBy(id="continue")
	WebElement enter;
	
	@FindBy(className="a-button-inner")
	WebElement newAccount;
	
	@FindBy(className="a-alert-content")
	WebElement blankErrorMess;
	
	@FindBy(className="a-list-item")
	WebElement wrongErrorMess;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement enterPassword;
	
	
	public void verifyEmailId(String a) {
		emailBox.sendKeys(a);
		enter.click();
	}
	
	public String blankEmailErr() {
		return blankErrorMess.getText();
	}
	
	public String wrongEmailErr() {
		return wrongErrorMess.getText();
	}
	
	public MyHomePage verifyPassword(String b) throws Exception {
		password.sendKeys(b);
		enterPassword.click();
		return new MyHomePage();
		
	}
	
	
	
	
	
	}
