package go.test.stepdefine;

import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import go.test.actions.Base;
import go.test.actions.Const;
import go.test.element.LoginPage;

public class Login extends Base{
	public Login (){
			PageFactory.initElements(driver, LoginPage.class);
	}
	
	@After
	public void embedScreenshot(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException wde) {
				System.err.println(wde.getMessage());
			} catch (ClassCastException cce) {
				cce.printStackTrace();
			}
		}
	}	

	@Given("^I access Admin page and login sucessfully$")
	public void i_access_Admin_page_and_login_sucessfully() throws Throwable {
		open(Const.URL);
		sendKeys(LoginPage.txtEmail, Const.Email);
		sendKeys(LoginPage.txtPass, Const.Pass);
		click(LoginPage.btnLogin);
	   
	}
	
	@Then("^I see the Dashboard$")
	public void i_see_the_Dashboard() throws Throwable {
		waitForPageLoad();
		Assert.assertEquals("Giới thiệu", driver.getTitle());
	    
	}

	@When("^Close survey$")
	public void close_survey() throws Throwable {
		open("https://anhbtk-gotest6.mysapo.vn/admin/products");
		Cookie ck = new Cookie("survey-gizmo", "true"); 
		driver.manage().addCookie(ck);
		refresh();
	}

}
