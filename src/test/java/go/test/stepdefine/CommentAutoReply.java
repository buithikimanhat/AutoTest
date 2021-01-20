package go.test.stepdefine;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
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
import go.test.element.CommentAutoReplyElement;
import go.test.element.ConnectPageElement;
import go.test.element.GlobalPage;
import go.test.element.LoginPage;
import go.test.element.MessengerAutoReplyElement;

public class CommentAutoReply extends Base {
	public CommentAutoReply(){
		PageFactory.initElements(driver, GlobalPage.class);
		PageFactory.initElements(driver, CommentAutoReplyElement.class);
	}
	
	String manualcmt = "Nội dung bình luận thủ công" ;
	String autoCmt="Nội dung bình luận áp dụng cho kịch bản tự động" ;
	String nameCustomer ="Bibong Rainbi";
	String contentCMTPage ="Phản hồi bình luận khách hàng" + java.time.LocalDateTime.now();
	String nameScriptCMT= "Kịch bản phản hồi cmt auto" + java.time.LocalDate.now();
	String contentCMTReply ="Xin chào bạn, nội dung bình luận phản hồi auto cho tất cả bài đăng " + java.time.LocalDate.now();
	
	@When("^I open the homepage of the facebook page$")
	public void i_open_the_homepage_of_the_facebook_page() throws Throwable {
		closeMultilTab();
		openNewTabWindow("https://www.facebook.com/ANHBTK_test-105446704660596/");
	    Thread.sleep(4000);
	}

	@When("^I create a post for the facebook page$")
	public void i_create_a_post_for_the_facebook_page() throws Throwable {
		waitElementToClick(CommentAutoReplyElement.createPost);
		Thread.sleep(6000);
		waitElementToClick(CommentAutoReplyElement.contentPost);
		waitElementToSendKeys(CommentAutoReplyElement.contentPost,"Bài viết daily " + java.time.LocalDateTime.now() );
		// tắt sự kiện load lại của trình duyệt - đặt trước button
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.onbeforeunload = null;");
		click(CommentAutoReplyElement.btnDang);	
		Thread.sleep(5000);
		refresh();
		Thread.sleep(5000);
	}

	@When("^I comment on that article on my personal facebook account$")
	public void i_comment_on_that_article_on_my_personal_facebook_account() throws Throwable {
		scroll(0,400);
		waitElementToClick(CommentAutoReplyElement.linktextVuaxong);
		Thread.sleep(2000);
		waitElementToClick(CommentAutoReplyElement.switchUserFB );
		Thread.sleep(1000);
		clickToPoint(CommentAutoReplyElement.optionUserFB);
		Thread.sleep(3000);
		waitElementToClick(CommentAutoReplyElement.clickCMT);
		waitElementToSendKeys(CommentAutoReplyElement.contentComment,manualcmt);
		CommentAutoReplyElement.contentComment.sendKeys(Keys.ENTER);	
		Thread.sleep(5000);
	}

	@Then("^I check the comment at the software interface$")
	public void i_check_the_comment_at_the_software_interface() throws Throwable {
		openNewTabWindow( "https://anhbtk-gotest6.mysapo.vn/admin/apps/socials-channel");
		switchToIframe(CommentAutoReplyElement.iframeAdmin);
		Thread.sleep(2000);
	}

	@Given("^I open that conversation$")
	public void i_open_that_conversation() throws Throwable {
		Thread.sleep(2000);
		assertText(CommentAutoReplyElement.nameConversation, nameCustomer);	
		Thread.sleep(2000);
		click(CommentAutoReplyElement.fisrtConversation);
		Thread.sleep(2000);
		assertText(CommentAutoReplyElement.contentCmt, manualcmt); 
	}

	@When("^I enter the comment content for the client$")
	public void i_enter_the_comment_content_for_the_client() throws Throwable {
	    sendKeys(CommentAutoReplyElement.inputChat, contentCMTPage);
	}

	@When("^I choose to send a comment$")
	public void i_choose_to_send_a_comment() throws Throwable {
	    waitElementToClick(CommentAutoReplyElement.iconSend);
	    Thread.sleep(5000);
	}

	@Then("^I check my comment on facebook$")
	public void i_check_my_comment_on_facebook() throws Throwable {
	   switchTabWindow(1);
	   refresh();
	   waitElementToClick(CommentAutoReplyElement.seeReplyPage); 
	   assertText(CommentAutoReplyElement.contentCMTFB, contentCMTPage);
	   
	}

	@Given("^I enter the tool automatically function for comment$")
	public void i_enter_the_tool_automatically_function_for_comment() throws Throwable {
		openNewTabWindow(Const.URL + "/admin/apps/socials-channel/facebook/autoreply");	
		switchToIframe(CommentAutoReplyElement.iframeAdmin);
		Thread.sleep(2000);
	}

	@When("^I create an auto-response script for the comment$")
	public void i_create_an_auto_response_script_for_the_comment() throws Throwable {
		//them kich ban auto reply binh luan
				waitElementToClick(CommentAutoReplyElement.btnAddScript);
				Thread.sleep(2000);
				waitElementToClick(CommentAutoReplyElement.btnAddCMT);
				Thread.sleep(2000);
	}

	@When("^I enter the script name for the response scenario$")
	public void i_enter_the_script_name_for_the_response_scenario() throws Throwable {
		waitElementToSendKeys(CommentAutoReplyElement.nameScriptComment, nameScriptCMT);
	}

	@When("^I choose the response time for the response scenario$")
	public void i_choose_the_response_time_for_the_response_scenario() throws Throwable {
		waitElementToClick(CommentAutoReplyElement.optionTime);
		Thread.sleep(2000);
	}

	@When("^I choose the next step for the response scenario$")
	public void i_choose_the_next_step_for_the_response_scenario() throws Throwable {
		waitElementToClick(CommentAutoReplyElement.btnNextStepCMT);
		Thread.sleep(2000);
	}

	@When("^I enter the text to respond to the comment$")
	public void i_enter_the_text_to_respond_to_the_comment() throws Throwable {
		waitElementToSendKeys(CommentAutoReplyElement.inputContentCMT, contentCMTReply);
	}

	@When("^I choose a response time for the response scenario$")
	public void i_choose_a_response_time_for_the_response_scenario() throws Throwable {
		clickToPoint(CommentAutoReplyElement.RadioDelayTime); 
		waitElementToClick(CommentAutoReplyElement.acceptDelayTime);
		Thread.sleep(1000);
	}

	@When("^I saved and scripted the script for the response scenario$")
	public void i_saved_and_scripted_the_script_for_the_response_scenario() throws Throwable {
		click(CommentAutoReplyElement.btnSubmitScript);
		Thread.sleep(3000);
	}

	@Then("^I check my script on the list$")
	public void i_check_my_script_on_the_list() throws Throwable {
		assertText(CommentAutoReplyElement.nameScriptCMTAfter ,nameScriptCMT );
		assertValueOfAttribute(CommentAutoReplyElement.activeScript, "class", "btn btn-toggle active");
		
	}

	@Given("^I use my personal account on facebook to comment the post$")
	public void i_use_my_personal_account_on_facebook_to_comment_the_post() throws Throwable {
	    switchTabWindow(1);
	    waitElementToClick(CommentAutoReplyElement.switchUserFB );
		Thread.sleep(1000);
		clickToPoint(CommentAutoReplyElement.optionUserFB);
		Thread.sleep(3000);
		waitElementToClick(CommentAutoReplyElement.clickCMT);
	}

	@When("^I send a new comment$")
	public void i_send_a_new_comment() throws Throwable {
		waitElementToSendKeys(CommentAutoReplyElement.contentComment, autoCmt);
		CommentAutoReplyElement.contentComment.sendKeys(Keys.ENTER);	
		Thread.sleep(5000);
	}

	@When("^I open new coversation comment$")
	public void i_open_new_coversation_comment() throws Throwable {
		switchTabWindow(2);
	    refresh();
	    switchToIframe(CommentAutoReplyElement.iframeAdmin); 
	}

	@When("^I check the comment I receive$")
	public void i_check_the_comment_I_receive() throws Throwable {
		assertText(CommentAutoReplyElement.nameConversationChoosed, nameCustomer);	
		click(CommentAutoReplyElement.fisrtConversationChoosed);	
	}

	@Then("^I check the feedback comment for customers$")
	public void i_check_the_feedback_comment_for_customers() throws Throwable {
		assertText(CommentAutoReplyElement.contentCmt, " ANHBTK_test: "+ contentCMTReply);
		switchTabWindow(3);
		switchToIframe(CommentAutoReplyElement.iframeAdmin);
		waitElementToClick(CommentAutoReplyElement.clickCheckbox);
		waitElementToClick(CommentAutoReplyElement.selectOption);
		waitElementToClick(CommentAutoReplyElement.selectOptionDelete);
		waitElementToClick(CommentAutoReplyElement.acceptDelete);
		Thread.sleep(3000);
		closeMultilTab();
	}

}
