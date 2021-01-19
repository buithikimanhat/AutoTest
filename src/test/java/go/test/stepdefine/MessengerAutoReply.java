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
import go.test.element.ConnectPageElement;
import go.test.element.FBChannelPage;
import go.test.element.FBPage;
import go.test.element.GlobalPage;
import go.test.element.LoginPage;
import go.test.element.MessengerAutoReplyElement;

public class MessengerAutoReply extends Base{
	public MessengerAutoReply(){
		PageFactory.initElements(driver, GlobalPage.class);
		PageFactory.initElements(driver, FBPage.class);
		PageFactory.initElements(driver, FBChannelPage.class);
		PageFactory.initElements(driver, MessengerAutoReplyElement.class);
	}
	String manualmessage ="Tin nhắn daily thủ công từ khách " + java.time.LocalDateTime.now() ;
	String nameCustomer ="Bibong Rainbi";
	String contentMessagePage ="Tin nhắn daily thủ công từ page "+ java.time.LocalDateTime.now() ;
	String autoMessage = "Xin chào bạn, nội dung phản hồi cmt auto cho tất cả bài đăng" + java.time.LocalDate.now();
	String autoCmt = "Xin chào bạn, nội dung bình luận phản hồi auto cho tất cả bài đăng " + java.time.LocalDate.now();
	String nameScriptMessage = "Kịch bản phản hồi cmt auto " + java.time.LocalDate.now();
	String autoMessageKH="Tin nhắn từ khách hàng áp dụng phản hồi tự động "+java.time.LocalDateTime.now();
	
	@When("^I use my personal account on facebook$")
	public void i_use_my_personal_account_on_facebook() throws Throwable {
		openNewTabWindow("https://www.facebook.com/messages/t/105446704660596");
	}

	@When("^I send a message to the page$")
	public void i_send_a_message_to_the_page() throws Throwable {
		Thread.sleep(5000);
//		switchToIframe(MessengerAutoReplyElement.iframeMessage);
		waitElementToSendKeys(MessengerAutoReplyElement.inputMessage,manualmessage);
		Thread.sleep(2000);
		MessengerAutoReplyElement.inputMessage.sendKeys(Keys.ENTER);
	}

	@When("^I open the message I just received in the software$")
	public void i_open_the_message_I_just_received_in_the_software() throws Throwable {
		switchTabWindow(1);
		refresh();
		switchToIframe(MessengerAutoReplyElement.iframeAdmin);
		Thread.sleep(2000);
		assertText(MessengerAutoReplyElement.nameConversation, nameCustomer);	
		click(MessengerAutoReplyElement.fisrtConversation);
	}

	@Then("^I check my messages$")
	public void i_check_my_messages() throws Throwable {
	   //kiểm tra nội dung tin nhắn từ khách 
		assertText(MessengerAutoReplyElement.contentMessenger, manualmessage);
	}

	@Given("^I am on that conversation$")
	public void i_am_on_that_conversation() throws Throwable {
	    assertText(MessengerAutoReplyElement.NameUser, nameCustomer);
	}

	@When("^I enter the message content for the client$")
	public void i_enter_the_message_content_for_the_client() throws Throwable {
	    sendKeys(MessengerAutoReplyElement.inputChat, contentMessagePage);
	}

	@When("^I choose to send a message$")
	public void i_choose_to_send_a_message() throws Throwable {
	    waitElementToClick(MessengerAutoReplyElement.iconSend);
	}

	@Then("^I check my messages on facebook$")
	public void i_check_my_messages_on_facebook() throws Throwable {
	    switchTabWindow(2);
	    refresh();
	    assertText(MessengerAutoReplyElement.listOfElements_Message.get(MessengerAutoReplyElement.listOfElements_Message.size()-1), contentMessagePage);
	}

	@Given("^I enter the tool automatically function$")
	public void i_enter_the_tool_automatically_function() throws Throwable {
	 openNewTabWindow(Const.URL + "/admin/apps/socials-channel/facebook/autoreply");	
		switchToIframe(FBChannelPage.iframeAdmin);
		Thread.sleep(2000);							
	}

	@When("^I create an auto-response script for the message$")
	public void i_create_an_auto_response_script_for_the_message() throws Throwable {
		//them kich ban auto reply binh luan
		waitElementToClick(MessengerAutoReplyElement.btnAddScript);
		Thread.sleep(2000);
		waitElementToClick(MessengerAutoReplyElement.btnAddMessage);
		Thread.sleep(2000);
	}

	@When("^I enter the script name$")
	public void i_enter_the_script_name() throws Throwable {
		waitElementToSendKeys(MessengerAutoReplyElement.NameScriptMessage, nameScriptMessage);
		Thread.sleep(2000);
	}

	@When("^I choose the response time$")
	public void i_choose_the_response_time() throws Throwable {
		waitElementToClick(MessengerAutoReplyElement.optionTime);
		Thread.sleep(2000);
	}

	@When("^I choose the next step$")
	public void i_choose_the_next_step() throws Throwable {
		waitElementToClick(MessengerAutoReplyElement.btnNextStep);
		Thread.sleep(2000);
	}

	@When("^I enter the text to respond to the message$")
	public void i_enter_the_text_to_respond_to_the_message() throws Throwable {
		waitElementToSendKeys(MessengerAutoReplyElement.inputContentTN, autoMessage);
		Thread.sleep(2000);
	}

	@When("^I choose a response time$")
	public void i_choose_a_response_time() throws Throwable {
		clickToPoint(MessengerAutoReplyElement.RadioDelayTime); 
		waitElementToClick(MessengerAutoReplyElement.acceptDelayTime);
		Thread.sleep(1000);
	}

	@When("^I saved and scripted the script$")
	public void i_saved_and_scripted_the_script() throws Throwable {
		click(MessengerAutoReplyElement.btnSubmitScript);
		Thread.sleep(3000);
	}

	@Then("^I check my script$")
	public void i_check_my_script() throws Throwable {
		assertText(MessengerAutoReplyElement.NameScriptMessageAfter,nameScriptMessage );
		assertText(MessengerAutoReplyElement.timeReplyAutoMessage, "Khi làm việc");
		assertValueOfAttribute(MessengerAutoReplyElement.activeScript, "class", "btn btn-toggle active");
		
	}

	@Given("^I use my personal account on facebook again$")
	public void i_use_my_personal_account_on_facebook_again() throws Throwable {
	    switchTabWindow(2);
	    refresh();
	}

	@When("^I send a new message to the page$")
	public void i_send_a_new_message_to_the_page() throws Throwable {
		waitElementToSendKeys(MessengerAutoReplyElement.inputMessage, autoMessageKH);
		Thread.sleep(2000);
		MessengerAutoReplyElement.inputMessage.sendKeys(Keys.ENTER);
	}

	@When("^I open new coversation$")
	public void i_open_new_coversation() throws Throwable {
	    switchTabWindow(1);
	    refresh();
	    assertText(MessengerAutoReplyElement.nameConversation, nameCustomer);	
		click(MessengerAutoReplyElement.fisrtConversation);
	}

	@When("^I check the messages I receive$")
	public void i_check_the_messages_I_receive() throws Throwable {
		assertText(MessengerAutoReplyElement.contentMessenger, autoMessageKH);
	}

	@Then("^I check the feedback messages for customers$")
	public void i_check_the_feedback_messages_for_customers() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}
