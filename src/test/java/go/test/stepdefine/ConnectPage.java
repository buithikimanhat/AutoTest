package go.test.stepdefine;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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
import go.test.element.ConnectPageElement;
import go.test.element.GlobalPage;
import go.test.element.LoginPage;

public class ConnectPage extends Base{
	public ConnectPage(){
		PageFactory.initElements(driver, GlobalPage.class);
		PageFactory.initElements(driver, ConnectPageElement.class);
	}
	@When("^I close guideline login acount facebook$")
	public void i_close_guideline_login_acount_facebook() throws Throwable {
		openNewTabWindow( "https://anhbtk-gotest6.mysapo.vn/admin/apps/socials-channel");		
		// 3 step hướng dẫn
		switchToIframe(ConnectPageElement.iframeSocial);
		waitElementToClick(ConnectPageElement.btnStep1);Thread.sleep(1000);
		waitElementToClick(ConnectPageElement.btnStep2);Thread.sleep(1000);
		waitElementToClick(ConnectPageElement.btnStep3);Thread.sleep(1000);
		waitElementToClick(ConnectPageElement.btnConnect);
	}

	@When("^enter a valid username and password facebook$")
	public void enter_a_valid_username_and_password_facebook() throws Throwable {
		switchToNewWindow();
		if(!driver.findElements(By.xpath("//input[@id='email']")).isEmpty()){
		 	waitElementToSendKeys(ConnectPageElement.txtemail, "rainbibongbi@gmail.com");
			sendKeys(ConnectPageElement.txtpass, "123456789a@");
			click(ConnectPageElement.btnLoginFb2);
			switchToNewWindow();
			if(!driver.findElements(By.xpath("//button[@id='checkpointSubmitButton']")).isEmpty()){
					waitElementToClick(ConnectPageElement.btnLoginFb);
					Thread.sleep(2000);
					// Chon xac thuc email
					waitElementToClick(ConnectPageElement.btnLoginConfirmEmail);
					click(ConnectPageElement.btnSubmitConfirm);
					Thread.sleep(2000);
					waitElementToClick(ConnectPageElement.btnSubmitEmail);
					Thread.sleep(2000);
					// dang nhap mail
					switchToNewWindow();
					// Nhap ten tai khoan email
					waitElementToSendKeys(ConnectPageElement.txtemailGoogle, "rainbibongbi@gmail.com");
					click(ConnectPageElement.btnUsenameEmail);
					// nhap pass
					Thread.sleep(3000);
					waitElementToSendKeys(ConnectPageElement.txtpassGoogle, "123456789a@");
					click(ConnectPageElement.btnUsenameEmail);
					Thread.sleep(5000);
					switchTabWindow(2);
					waitElementToClick(ConnectPageElement.btnLoginFb3);
					waitElementToClick(ConnectPageElement.btnTieptuc);
					}
				}		
		
	}

	@When("^enter login$")
	public void enter_login() throws Throwable {
		Thread.sleep(1000);
		waitElementToClick(ConnectPageElement.btntieptuc);
	}

	@Then("^I see successful login$")
	public void i_see_successful_login() throws Throwable {
		Thread.sleep(2000);
		switchTabWindow(1);
		switchToIframe(ConnectPageElement.iframeAdmin);
	}
	@Given("^I login acount facebook sucessfully$")
	public void i_login_acount_facebook_sucessfully() throws Throwable {
		// kiểm tra tài khoản sau khi đăng nhập
		assertText(ConnectPageElement.nameUserFB,"Bibong Rainbi");
		assertValueOfAttribute(ConnectPageElement.avtUserFB, "src", "https://graph.facebook.com/102589838467987/picture?width=200&height=200");
	}

	@When("^I connect a page$")
	public void i_connect_a_page() throws Throwable {
		waitElementToClick(ConnectPageElement.choosePage);
		waitElementToClick(ConnectPageElement.buttonConnect);
		
	}

	@When("^I close popups noti$")
	public void i_close_popups_noti() throws Throwable {
//		//tắt popup thông báo
//		Thread.sleep(3000);
//		waitElementToClick(ConnectPageElement.closePopupNoti);
		
		// tắt pop up chuyen đổi giao diện
		Thread.sleep(3000);
		waitElementToClick(ConnectPageElement.switchNewVersion);

		//tắt popup cập nhật mới 
		Thread.sleep(2000);
//		waitElementToClick(ConnectPageElement.closeNoti);
		waitElementToClick(ConnectPageElement.closePopupUpdate);
		Thread.sleep(2000);
		waitElementToClick(ConnectPageElement.swithNewVersion2);
		
		// tooltip hướng dẫn 
		Thread.sleep(1000);
//		waitElementToClick(ConnectPageElement.swithNewVersion2);
		waitElementToClick(ConnectPageElement.closeTooltip);
		Thread.sleep(1000);
		waitElementToClick(ConnectPageElement.closeTooltipAccept);
	    
	}

	@Then("^I see list conversation$")
	public void i_see_list_conversation() throws Throwable {
		assertText(ConnectPageElement.titleUI, "Hội thoại");
		closeMultilTab();
	}


}
