package go.test.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ConnectPageElement {
	@FindBy(xpath = "//iframe[@name='app-iframe']")
	public static WebElement iframeSocial;
	
// 3 bước hướng dẫn kết nối
	@FindBy(xpath = "//button[@data-step = '1']")
	public static WebElement btnStep1;
	@FindBy(xpath = "//button[@data-step = '2']")
	public static WebElement btnStep2;
	@FindBy(xpath = "//button[@data-step = '3']")
	public static WebElement btnStep3;
	@FindBy(xpath = "//button[@type='button']")
	public static WebElement btnConnect;
	
// login facebook và check xác nhận tài khoản
	@FindBy(xpath = "//input[@id='email']")
	public static WebElement txtemail;
	@FindBy(xpath = "//input[@id='pass']")
	public static WebElement txtpass;
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement btnLoginFb;
	
//Xac thuc tai khoan FB
	@FindBy(xpath = "//*[@id=\"platformDialogForm\"]/div/div/div/div/div/div[3]/div[1]/div[1]/div[2]/div/div[1]")
	public static WebElement connectFb;
	@FindBy(xpath = "//div[@data-for='pageList5c9d7ec30a2b1f000138311c']/parent::div//button[@type='button']")
	public static WebElement firstPage;
	@FindBy(xpath = "//div[@class='_x5o']/div[2]")
	public static WebElement btnLoginConfirmEmail;
	@FindBy(xpath = "//button[@id='checkpointSubmitButton']")
	public static WebElement btnSubmitConfirm;
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement btnSubmitEmail;
	@FindBy(xpath = "//input[@type='email']")
	public static WebElement txtemailGoogle;
	@FindBy(xpath = "//div[@class='qhFLie']/div/div/span")
	public static WebElement btnUsenameEmail;
	@FindBy(xpath = "//input[@type='password']")
	public static WebElement txtpassGoogle;
	@FindBy(xpath = "//input[@type='submit']")
	public static WebElement btnLoginFb2;
	@FindBy(xpath = "//div[@class='generic_dialog pop_dialog generic_dialog_modal']//input[@type='button'and @name='ok']")
	public static WebElement btnLoginFb3;
	@FindBy(xpath = "//button[@id='checkpointSubmitButton']")
	public static WebElement btnTieptuc;
	
// tiếp tục dưới tên facebook			
	@FindBy(xpath = "//div[@aria-label = 'Tiếp tục dưới tên Bibong Rainbi']")
	public static WebElement btntieptuc;
	
// kiểm tra tài khỏan fb sau đăng nhập 
	@FindBy(xpath = "//span[@class='name text-ellipsis']")
	public static WebElement nameUserFB;
	@FindBy(xpath = "//img[@alt='avatar']")
	public static WebElement avtUserFB;
	
// kết nối và chọn page 
	@FindBy(xpath = "//iframe[@class='app-iframe app-iframe--admin']")
	public static WebElement iframeAdmin;
	@FindBy(xpath = "//div[@class='checkbox-circle-content ']")
	public static WebElement choosePage;
	@FindBy(xpath = "//button[@class='btn btn-primary btn-connect ']")
	public static WebElement buttonConnect;
	
//tắt popup cap nhat moi
	@FindBy(xpath = "//div[@class='modal-footer']/button[@class='btn btn-primary']")
	public static WebElement closePopupNoti;
	@FindBy(xpath = "//button[@class='close']")
	public static WebElement closePopupUpdate;
	@FindBy(xpath = "//div[@class='btn-close']")
	public static WebElement closeTooltip;
	@FindBy(xpath = "//div[@class='btn btn-primary']")
	public static WebElement closeTooltipAccept;
	@FindBy(xpath = "//button[contains(., 'Tôi đã hiểu') ]")
	public static WebElement closeNoti;
	
// chuyển đổi giao diện hội thoại
	@FindBy(xpath = "//div[@class='change-version-body old-version']//button[@class='btn btn-primary']")
	public static WebElement switchNewVersion;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	public static WebElement swithNewVersion2;
//kiểm tra giao diện hiện tại 
	@FindBy(xpath ="//div[@class='topbar-title']")
	public static WebElement titleUI;



}
