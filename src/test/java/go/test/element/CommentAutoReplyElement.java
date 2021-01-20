package go.test.element;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;


public class CommentAutoReplyElement {
	// tạo post bên page
	@FindBy(xpath = "//div[contains(@aria-label,'Tạo bài viết')]")
	public static WebElement createPost;
	@FindBy(xpath = "//div[@role='presentation']//div[contains(.,'Viết gì đó cho ANHBTK_test...') and @id]/parent::div/parent::div//div[@role='textbox']")
	public static WebElement contentPost;
	@FindBy(xpath = "//div[@role='button' and contains(.,'Đăng')]")
	public static WebElement btnDang;
	@FindBy(xpath = "//div[@aria-posinset='1']//a[contains(@aria-label,'phút')]")
	public static WebElement linktextVuaxong;
	@FindBy(xpath = "//div[@aria-posinset='1']//button[@aria-label='Nút chọn vai trò']")
	public static WebElement switchUserFB;
	@FindBy(xpath = "//div[@role='menuitemradio']//span[contains(.,'Bibong Rainbi')]")
	public static WebElement optionUserFB;
	@FindBy(xpath = "//div[@aria-label='Viết bình luận' and @role='button']")
	public static WebElement clickCMT;
	@FindBy(xpath = "//form//div[@aria-label='Viết bình luận']")
	public static WebElement contentComment;
	
	//kiem tra tren phan mem
	@FindBy(xpath = "//iframe[@class='app-iframe app-iframe--admin']")
	public static WebElement iframeAdmin;
	@FindBy(xpath = "//div[@class = 'd-flex conversation-item conversation-unread'][1]//span[@class='sender']")
	public static WebElement nameConversation;
	@FindBy(xpath = "//div[@class = 'd-flex conversation-item conversation-active'][1]//span[@class='sender']")
	public static WebElement nameConversationChoosed;
	@FindBy(xpath = "//div[@class = 'd-flex conversation-item conversation-unread'][1]")
	public static WebElement fisrtConversation;
	@FindBy(xpath = "//div[@class = 'd-flex conversation-item conversation-active'][1]")
	public static WebElement fisrtConversationChoosed;
	@FindBy(xpath = "//div[@class='d-flex conversation-item conversation-active']//div[@class='conversation-content']/span/span")
	public static WebElement contentCmt;
	@FindBy(xpath = "//textarea[@placeholder]")
	public static WebElement inputChat;
	@FindBy(xpath = "//div[@class='send-icon-wrapper']")
	public static WebElement iconSend;
	
	// kiem tra phan hoi cua page
	@FindBy(xpath = "//span/span[contains(.,'1 phản hồi')]")
	public static WebElement seeReplyPage;
	@FindBy(xpath = "//div[@style='text-align: start;']")
	public static WebElement contentCMTFB;
	
	// tao kich ban phan hoi tu dong cho binh luan
	@FindBy(xpath = "//button[@class='btn btn-primary dropdown-toggle']")
	public static WebElement btnAddScript;
	@FindBy(xpath = "//a[@href='/facebook/autoreply-add-cmt']/li")
	public static WebElement btnAddCMT;
	@FindBy(xpath = "//input[@placeholder='Nhập tên kịch bản phản hồi tự động']")
	public static WebElement nameScriptComment;
	@FindBy(xpath = "//div[@class='form-group']/div[@class='checkbox'][2]/label")
	public static WebElement optionTime;
	@FindBy(xpath = "//div[@class='setting-nextAuto']/div")
	public static WebElement btnNextStepCMT;
	@FindBy(xpath = "//textarea[@placeholder='Nhập nội dung bình luận phản hồi']")
	public static WebElement inputContentCMT;
	@FindBy(xpath = "//div[@class='radio-delay-time']/input[@id='radio-time-1']")
	public static WebElement RadioDelayTime;
	@FindBy(xpath = "//div[@class='modal-footer']/button[2]")
	public static WebElement acceptDelayTime;
	@FindBy(xpath = "//button[@class='btn btn-primary'][2]")
	public static WebElement btnSubmitScript;
	
	//kiem tra sau khi tao kich ban
	@FindBy(xpath = "//tr//div[@class='div_name_set']/span")
	public static WebElement nameScriptCMTAfter;
	@FindBy(xpath = "//tr//div[@data-for='actived0']/button")
	public static WebElement activeScript;
	// xoa kich ban auto reply cho binh luan
	@FindBy(xpath = "//div[@class = 'checkboxabc' ]//label[@title='Chọn']")
	public static WebElement clickCheckbox;
	@FindBy(xpath = "//button[@id='dropdownMenu1']")
	public static WebElement selectOption;
	@FindBy(xpath = "//ul[@class='dropdown-menu show']/li[3]")
	public static WebElement selectOptionDelete;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	public static WebElement acceptDelete;

}
