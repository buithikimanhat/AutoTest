package go.test.element;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class MessengerAutoReplyElement {

// Gửi tin nhắn
	@FindBy(xpath = "//iframe[contains(@src,'https://www.facebook.com/messages/t/113104476716795')]")
	public static WebElement iframeMessage;
//	@FindBy(xpath = "//div[@role='combobox']/div/div/div")
	@FindBy(xpath = "//div[@contenteditable='true']")
	public static WebElement inputMessage;
	@FindBy(xpath = "//div[@aria-label='Nhấn Enter để gửi']")
	public static WebElement submitMessage;
//Kiểm tra tin nhắn về
	@FindBy(xpath = "//iframe[@class='app-iframe app-iframe--admin']")
	public static WebElement iframeAdmin;
	@FindBy(xpath = "//div[@class = 'd-flex conversation-item conversation-active'][1]//span[@class='sender']")
	public static WebElement nameConversation;
	@FindBy(xpath = "//div[@class = 'd-flex conversation-item conversation-active'][1]")
	public static WebElement fisrtConversation;
	@FindBy(xpath = "//div[@class='d-flex conversation-item conversation-active']//div[@class='conversation-content']/span/span")
	public static WebElement contentMessenger;
	@FindBy(xpath = "//span[@class='user-name']")
	public static WebElement NameUser;
	@FindBy(xpath = "//textarea[@placeholder]")
	public static WebElement inputChat;
	@FindBy(xpath = "//div[@class='send-icon-wrapper']")
	public static WebElement iconSend;
	
// kiểm tra tin nhắn đến khách hàng 
//	@FindBy(xpath = "//div[@data-testid='incoming_group']//div[@dir='auto']")
//	public static WebElement contentMessage;
	@FindBys(@FindBy(xpath = "//div[@data-testid='incoming_group']//div[@dir='auto']"))			
	public static List<WebElement> listOfElements_Message;
	
//Tạo kịch bản auto reply
	@FindBy(xpath = "//button[@class='btn btn-primary dropdown-toggle']")
	public static WebElement btnAddScript;
	@FindBy(xpath = "//a[@href='/facebook/autoreply-add-message']/li")
	public static WebElement btnAddMessage;
	@FindBy(xpath = "//input[@placeholder='Nhập tên kịch bản phản hồi tin nhắn tự động']")
	public static WebElement NameScriptMessage;
	@FindBy(xpath = "//label[@for='radio3']")
	public static WebElement optionTime;
	@FindBy(xpath = "//div[@class='setting-nextAuto']/div")
	public static WebElement btnNextStep;
	@FindBy(xpath = "//textarea[@placeholder='Nhập nội dung tin nhắn phản hồi']")
	public static WebElement inputContentTN;
	@FindBy(xpath = "//div[@class='radio-delay-time']/input[@id='radio-time-1']")
	public static WebElement RadioDelayTime;
	@FindBy(xpath = "//div[@class='modal-footer']/button[2]")
	public static WebElement acceptDelayTime;
	@FindBy(xpath = "//button[@type='button'][2]")
	public static WebElement btnSubmitScript;
// kiem tra kich ban sau khi luu
	@FindBy(xpath = "//tr//div[@class='div_name_set']/span")
	public static WebElement NameScriptMessageAfter;
	@FindBy(xpath = "//tr//div[@class='on-time']")
	public static WebElement timeReplyAutoMessage;
	@FindBy(xpath = "//tr//div[@data-for='actived0']/button")
	public static WebElement activeScript;
}
