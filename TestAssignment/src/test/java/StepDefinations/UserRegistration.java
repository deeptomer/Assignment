package StepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import Driver.DriverFactory;
import Pages.UserRegistrationPO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistration {
	DriverFactory driverFactory = new DriverFactory();
	WebDriver driver = driverFactory.init_driver("Chrome");
	UserRegistrationPO ureg = new UserRegistrationPO(driver);

	@Given("User Launch Site {string}")
	public void user_launch_site(String expectedpageTitle) throws Throwable {

		driver.get("http://jt-dev.azurewebsites.net/#/SignUp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ureg.verifyLogo();
		Assert.assertTrue(driver.getTitle().contains(expectedpageTitle));

	}

	@Given("Validate Language Selector")
	public void validate_language_selector(DataTable langData) throws Throwable {
		List<String> lang = langData.asList(String.class);

		ureg.languageSelector(lang);

	}

	@When("User enter Registration Details")
	public void user_enter_registration_details(DataTable userDetails) throws Throwable {
		List<String> details = userDetails.asList(String.class);
		ureg.enterUserName(details.get(0));
		ureg.enterOrgName(details.get(1));
		ureg.userEmail(details.get(2));

	}

	@When("Select Terms and Conditions")
	public void select_terms_and_conditions() throws Throwable {
		ureg.selectTerms();

	}

	@When("Click Get Started button")
	public void click_get_started_button() throws Throwable {
		ureg.getStarted();

	}

	@Then("Registration is Successfull")
	public void Registration_is_successfull() throws Throwable {
		ureg.successMessage();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Then("User close Browser")
	public void User_close_Browser() {
		driver.close();
	}

}
