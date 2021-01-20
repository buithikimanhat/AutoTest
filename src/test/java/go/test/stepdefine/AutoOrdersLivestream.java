package go.test.stepdefine;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import go.test.actions.Base;
import go.test.actions.Const;
import go.test.element.AutoOrdersLivestreamElement;
import go.test.element.ConnectPageElement;
import go.test.element.GlobalPage;
import go.test.element.LoginPage;


public class AutoOrdersLivestream extends Base {
	
	public AutoOrdersLivestream(){
		PageFactory.initElements(driver, GlobalPage.class);
		PageFactory.initElements(driver, AutoOrdersLivestreamElement.class);
	}
	String nameProduct = "Sản phẩm kênh fb test auto order";
	@When("^I enter the livestream sales function$")
	public void i_enter_the_livestream_sales_function() throws Throwable {
		openNewTabWindow("https://anhbtk-gotest6.mysapo.vn/admin/apps/socials-channel/facebook/autoOrder");
		Thread.sleep(4000);
	    switchToIframe(AutoOrdersLivestreamElement.iframeAdmin);
	}

	@When("^I choose to add a new script for the livestream post$")
	public void i_choose_to_add_a_new_script_for_the_livestream_post() throws Throwable {
		click(AutoOrdersLivestreamElement.addAutoOrder);
	    Thread.sleep(5000);
	}

	@When("^I choose to add a keyword template for the product$")
	public void i_choose_to_add_a_keyword_template_for_the_product() throws Throwable {
		 scroll(0, 400); 
	    //them mẫu nội dung
	    waitElementToClick(AutoOrdersLivestreamElement.addKeys); 
	   
	}

	@When("^I choose a product$")
	public void i_choose_a_product() throws Throwable {
		waitElementToSendKeys(AutoOrdersLivestreamElement.searchProduct, "Auto123");
		Thread.sleep(3000);
	    waitElementToClick(AutoOrdersLivestreamElement.selectFirstProduct); 
	    Thread.sleep(3000);
	}

	@When("^I add a new product$")
	public void i_add_a_new_product() throws Throwable {
		waitElementToClick(AutoOrdersLivestreamElement.addProduct); 
	    sendKeys(AutoOrdersLivestreamElement.ProductName, nameProduct);
	    clear(AutoOrdersLivestreamElement.ProductPrice);
	    sendKeys(AutoOrdersLivestreamElement.ProductPrice, "20");
	    Thread.sleep(2000);
	   
	}

	@When("^I save the content template just created$")
	public void i_save_the_content_template_just_created() throws Throwable {
		sendKeys(AutoOrdersLivestreamElement.keyword, "key"+java.time.LocalDate.now());
	    waitElementToClick(AutoOrdersLivestreamElement.saveKeyword);
	    Thread.sleep(3000);
	}

	@When("^I check the newly added product$")
	public void i_check_the_newly_added_product() throws Throwable {
		//kiem tra san pham moi tao
	    assertValueOfAttribute(AutoOrdersLivestreamElement.imageNewProduct, "src", "https://socials.sapoapps.vn/images/no-image-post.png");
	    assertTextNode(AutoOrdersLivestreamElement.nameNewProduct, nameProduct);
	    assertValueOfAttribute(AutoOrdersLivestreamElement.priceNewProduct, "value", "20");
    
	}

	@When("^I choose the order creation condition for the scenario$")
	public void i_choose_the_order_creation_condition_for_the_scenario() throws Throwable {
		 clickToPoint(AutoOrdersLivestreamElement.phoneCondition);
		    clickToPoint(AutoOrdersLivestreamElement.replyCorectCMT);
		    clickToPoint(AutoOrdersLivestreamElement.replyIncorrectCMT);
		    clickToPoint(AutoOrdersLivestreamElement.sendLinkOrder);
		    clickToPoint(AutoOrdersLivestreamElement.sendLinkProduct);
	}

	@Then("^I choose to save the script$")
	public void i_choose_to_save_the_script() throws Throwable {
		waitElementToClick(AutoOrdersLivestreamElement.saveScript);
	    Thread.sleep(5000);
	    waitElementToClick(AutoOrdersLivestreamElement.closePopupPost); 
	}

	@When("^I delete the script just created$")
	public void i_delete_the_script_just_created() throws Throwable {
		//xóa kịch bản livstream
		waitElementToClick(AutoOrdersLivestreamElement.checkboxchoose);
		waitElementToClick(AutoOrdersLivestreamElement.selectOption);
		waitElementToClick(AutoOrdersLivestreamElement.selectOptionDeletelive);
		waitElementToClick(AutoOrdersLivestreamElement.acceptDelete);
		Thread.sleep(3000);
	}

	@When("^I open the site's product list$")
	public void i_open_the_site_s_product_list() throws Throwable {
		switchTabWindow(0);
		open(Const.URL + "/admin/products");
	    Thread.sleep(2000);
	}

	@When("^I check the product I just created$")
	public void i_check_the_product_I_just_created() throws Throwable {
		waitElementToSendKeys(AutoOrdersLivestreamElement.inputtimkiem,nameProduct);
		AutoOrdersLivestreamElement.inputtimkiem.sendKeys(Keys.ENTER);
	    Thread.sleep(3000);
	}

	@Then("^I confirm deletion of the product$")
	public void i_confirm_deletion_of_the_product() throws Throwable {
		Thread.sleep(3000);
	    clickToPoint(AutoOrdersLivestreamElement.clickCheckboxProduct);
	    Thread.sleep(2000);
	    clickToPoint(AutoOrdersLivestreamElement.selectOptionProduct);
	    Thread.sleep(2000);
	    clickToPoint(AutoOrdersLivestreamElement.selectOptionDeleteProduct);
	    Thread.sleep(2000);
	    clickToPoint(AutoOrdersLivestreamElement.acceptDeleteProduct);
		Thread.sleep(4000);
		waitElementToClick(AutoOrdersLivestreamElement.acceptDeleteProduct2);
		Thread.sleep(3000);
	}

}
