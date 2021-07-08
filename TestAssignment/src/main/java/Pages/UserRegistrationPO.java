package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserRegistrationPO {

	private WebDriver driver;

	// Page Elements
	private By logo = By.xpath("//*[@class='logo']/a/img");
	private By langSelectBox = By.xpath("//*[@id='language']");
	private By langEng = By.xpath("//*[contains(text(),'English')]");
	private By langDutch = By.xpath("//*[contains(text(),'Dutch')]");
	private By headingCreateAccount = By.xpath("//h2[contains(text(),'Create Your Account')]");
	private By userIconField = By.xpath("//*[@class='glyphicon glyphicon-user']");
	private By userNameTextField = By.xpath("//*[@id='name']");
	private By orgIconField = By.xpath("//*[@class='glyphicon glyphicon-briefcase']");
	private By orgNnameTextField = By.xpath("//*[@id='orgName']");
	private By emailIconField = By.xpath("//*[@class='glyphicon glyphicon-envelope']");
	private By emailTextField = By.xpath("//*[@id='singUpEmail']");
	private By agreeCheckbox = By.xpath("//*[@class='black-color ng-binding']");
	private By termAndCondition = By.xpath("//*[contains(text(),'Terms and Conditions')]");
	private By getStartedButton = By.xpath("//button[contains(text(),'Get Started')]");
	private By successMessage = By
			.xpath("//*[contains(text(),' A welcome email has been sent. Please check your email. ')]");

	//
	public UserRegistrationPO(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void verifyLogo() {
		try {
			driver.findElement(logo).isDisplayed();
		} catch (NoSuchElementException ex) {
			System.out.println(ex);
		}
	}

	public void languageSelector(List<String> lan) {
		try {
			if (driver.findElement(langSelectBox).isDisplayed()) {
				driver.findElement(langSelectBox).click();

				List<WebElement> language_list = driver.findElements(langSelectBox);

				for (WebElement language : language_list) {
					if (language.getText().contains(lan.get(0)))
						System.out.println(lan.get(0) + " Language is Verified ");
					if (language.getText().contains(lan.get(1))) {
						System.out.println(lan.get(1) + " Language is Verified ");
					}
				}

			} else {
				System.out.println("Languale Selecter dropdown not present");
			}
		} catch (NoSuchElementException ex) {
			System.out.println(ex);
		}
	}

	public void enterUserName(String name) {
		try {
			if (driver.findElement(headingCreateAccount).isDisplayed()) {
				driver.findElement(userIconField).isDisplayed();
				driver.findElement(userNameTextField).sendKeys(name);
			} else {
				System.out.println("Registration page not available");
			}
		} catch (NoSuchElementException ex) {
			System.out.println(ex);
		}
	}

	public void enterOrgName(String org) {
		try {
			driver.findElement(orgIconField).isDisplayed();
			driver.findElement(orgNnameTextField).sendKeys(org);
		} catch (NoSuchElementException ex) {
			System.out.println(ex);
		}
	}

	public void userEmail(String email) {
		try {
			driver.findElement(emailIconField).isDisplayed();
			driver.findElement(emailTextField).sendKeys(email);
		} catch (NoSuchElementException ex) {
			System.out.println(ex);
		}
	}

	public void selectTerms() {
		driver.findElement(agreeCheckbox).click();
		driver.findElement(termAndCondition).isDisplayed();
	}

	public void getStarted() {
		if (driver.findElement(getStartedButton).isEnabled()) {
			driver.findElement(getStartedButton).click();
		} else {
			System.out.println("Error");
		}
	}

	public void successMessage() {
		try {
			if (driver.findElement(successMessage).isDisplayed()) {
				System.out.println("User Registration Successfull");
			} else {
				System.out.println("Please try again");
			}
		} catch (NoSuchElementException ex) {
			System.out.println(ex);
		}
	}
}
