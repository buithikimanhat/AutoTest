package go.test.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class AutoOrdersLivestreamElement {
	@FindBy(xpath = "//iframe[@class='app-iframe app-iframe--admin']")
	public static WebElement iframeAdmin;
//	tạo kịch bản auto order
	@FindBy(xpath = "//div[@class='btn_add_new_order']")
	public static WebElement addAutoOrder;
	@FindBy(xpath = "//div[@id='auto_order_scroll_key_variant'] //button")
	public static WebElement addKeys;
	@FindBy(xpath = "//div[@id='div_form_products'] //input")
	public static WebElement focusInputProduct;
	@FindBy(xpath = "//div[@class='item itemSearch'][1]")
	public static WebElement selectFirstProduct;
	@FindBy(xpath = "//input[@placeholder='Tìm kiếm sản phẩm']")
	public static WebElement searchProduct;
//tạo sản phẩm
	@FindBy(xpath = "//span[@class='add-more-product']")
	public static WebElement addProduct;
	@FindBy(xpath = "//input[@placeholder='Nhập tên sản phẩm']")
	public static WebElement ProductName;
	@FindBy(xpath = "//input[@placeholder='Nhập tên sản phẩm']//parent::div//parent::div//input[@autocomplete='off']")
	public static WebElement ProductPrice;
	@FindBy(xpath = "//input[@class='keyword']")
	public static WebElement keyword;
	@FindBy(xpath = "//div[@class='modal-footer']/button[contains(.,'Lưu & Đóng')]")
	public static WebElement saveKeyword;
	//kiem tra san pham moi tao
	@FindBy(xpath = "//div[@class='content-variant']/div[2]//span[@data-for='variant-name-1-0']")
	public static WebElement nameNewProduct;
	@FindBy(xpath = "//div[@class='content-variant']/div[2]//input[@value='20']")
	public static WebElement priceNewProduct;
	@FindBy(xpath = "//div[@class='content-variant']/div[2]//img[@src='/images/no-image-post.png']")
	public static WebElement imageNewProduct;
	
// xét điều kiện tạo đơn và nội dung phản hồi
	
	@FindBy(xpath = "//div[contains(., 'Số điện thoại') and @class='checkboxabc']")
	public static WebElement phoneCondition;
	@FindBy(xpath = "//div[@class='d-flex list-setting valid-reply-status']//button[@class='btn btn-toggle ']")
	public static WebElement replyCorectCMT;
	@FindBy(xpath = "//div[@class='d-flex list-setting invalid-reply-status']//button")
	public static WebElement replyIncorrectCMT;
	@FindBy(xpath = "//div[@class='reply_component'][1]//input[@type='checkbox']")
	public static WebElement sendLinkOrder;
	@FindBy(xpath = "//div[@class='reply_component'][2]//input[@type='checkbox']")
	public static WebElement sendLinkProduct;
	@FindBy(xpath = "//div[@class='div-action div-edit-auto-reply']//button[@class='btn btn-primary'][2]")
	public static WebElement saveScript;
	@FindBy(xpath = "//button[@class='btn btn-default']")
	public static WebElement closePopupPost;
	
// xóa kịch bản
	@FindBy(xpath = "//tbody[@class='fea-body-content']//div[@class = 'checkboxabc' ]")
	public static WebElement checkboxchoose;
	@FindBy(xpath = "//ul[@class='dropdown-menu show']/li[2]")
	public static WebElement selectOptionDeletelive;
	@FindBy(xpath = "//button[@id='dropdownMenu1']")
	public static WebElement selectOption;
	@FindBy(xpath = "//ul[@class='dropdown-menu show']/li[3]")
	public static WebElement selectOptionDelete;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	public static WebElement acceptDelete;
	
// Xóa sản phẩm bên core
	
	@FindBy(xpath = "//input[@placeholder='Tìm kiếm theo mã sản phẩm, tên sản phẩm, barcode']")
	public static WebElement inputtimkiem;
	@FindBy(xpath = "//tbody/tr[1]//input[@type='checkbox']")
	public static WebElement clickCheckboxProduct;
	@FindBy(xpath = "//a[@class='btn bulk-actions__btn-dropdown']")
	public static WebElement selectOptionProduct;
	@FindBy(xpath = "//div[@class='popover-body']/ul[@class='popover-list-item']/li[5]")
	public static WebElement selectOptionDeleteProduct;
	@FindBy(xpath = "//button[@class='btn sapo-btn-red pull-right']")
	public static WebElement acceptDeleteProduct;
	@FindBy(xpath = "//button[@class='close-modal btn margin-left-5 sapo-btn-default pull-right']")
	public static WebElement acceptDeleteProduct2;
	
	

}
