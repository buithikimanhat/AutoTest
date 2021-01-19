package go.test.element;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import go.test.stepdefine.FBDefine;

public class FBChannelPage {
	
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
			
	//
			
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
			@FindBy(xpath = "//div[@aria-label = 'Tiếp tục dưới tên Love Kids']")
			public static WebElement btntieptuc;
			
			
			@FindBy(xpath = "//button[@type='submit' and @name='login']")
			public static WebElement btnLogin;
			@FindBy(xpath = "//input[@type='submit']")
			public static WebElement btnLoginTwo;
			@FindBy(xpath = "//input[@id='login']")
			public static WebElement txtemailSapo;
			@FindBy(xpath = "//input[@id='Password']")
			public static WebElement txtpassSapo;
			@FindBy(xpath = "//button[@type='submit']")
			public static WebElement btnLoginSapo;
			
			
			// kết nối và chọn page 
			@FindBy(xpath = "//iframe[@class='app-iframe app-iframe--admin']")
			public static WebElement iframeAdmin;
			@FindBy(xpath = "//div[contains(., 'Thiết bị âm thanh') and @class='info']")
			public static WebElement divChoosepage;
			
			//tắt popup cap nhat moi
			@FindBy(xpath = "//button[@class='close']")
			public static WebElement closePopupUpdate;
			@FindBy(xpath = "//div[@class='btn-close']")
			public static WebElement closeTooltip;
			@FindBy(xpath = "//div[@class='btn btn-primary']")
			public static WebElement closeTooltipAccept;
			
			
			
			
			// chuyển đổi giao diện hội thoại
			@FindBy(xpath = "//div[@class='change-version-body old-version']//button[@class='btn btn-primary']")
			public static WebElement switchNewVersion;
			@FindBy(xpath = "//div[@class='change-version-body new-version']//button[@class='btn btn-primary']")
			public static WebElement swithNewVersion2;
			
			// kiểm tra khi có tin nhắn vê	
			@FindBys(@FindBy(xpath = "//div[@class = 'd-flex conversation-item"))			
			public static List<WebElement> listOfElements_conversation;
			@FindBy(xpath = "//div[@class = 'd-flex conversation-item conversation-unread'][1]")
			public static WebElement fisrtConversation;
			//@FindBy(xpath = "//div[@class = 'd-flex conversation-item conversation-unread'][1]//div[@class='conversation-item-content']/div/span")
			@FindBy(xpath = "//div[@class = 'd-flex conversation-item conversation-unread'][1]//div[@class='conversation-item-content']/div/span")
			public static WebElement nameConversation;
			@FindBy(xpath = "//div[@class = 'd-flex conversation-item conversation-unread'][1]//div[@class='conversation-item-content']//div[@class='conversation-content']/span/span")
			public static WebElement snippetConversation;
			@FindBy(xpath = "//span[@class = 'dialogue-text-content']")
			public static WebElement DetailcmtConversation;
			//@FindBys(@FindBy(xpath = "//span[@class = 'dialogue-text-content']"))			
			@FindBys(@FindBy(xpath = "//div[@class='d-flex']//span[@class = 'dialogue-text-content']"))
			public static List<WebElement> listOfElements_left  ;
			@FindBys(@FindBy(xpath = "//div[@class='d-flex float-right']//div[@class='clear-fix content-item content-text message']//span[@class = 'dialogue-text-content']"))			
			public static List<WebElement> listOfElements_right;
			// tin nhắn/ cmt bên phải
			
			
			
			
			
//			static String detail = "//span[contains(.,'"+ FBDefine.manualcmt  + "') and @class = 'dialogue-text-content']";
//			@FindBy(xpath = detail )
//			//span[contains(., 'hihe') and@class = 'dialogue-text-content']
//			public static WebElement detailMessage;
			
			
			
			
			
			
			
//Tạo kịch bản auto reply
			@FindBy(xpath = "//button[@class='btn btn-primary dropdown-toggle']")
			public static WebElement btnAddScript;
			@FindBy(xpath = "//a[@href='/facebook/autoreply-add-cmt']/button")
			public static WebElement btnAddComment1;
			@FindBy(xpath = "//a[@href='/facebook/autoreply-add-cmt']/li")
			public static WebElement btnAddComment;
			@FindBy(xpath = "//input[@placeholder='Nhập tên kịch bản phản hồi tự động']")
			public static WebElement NameScriptComment;
			@FindBy(xpath = "//div[@class='form-group']/div[@class='checkbox'][2]/label")
			public static WebElement optionTime;
			@FindBy(xpath = "//div[@class='setting-nextAuto']/div")
			public static WebElement btnNextStepCMT;
			@FindBy(xpath = "//textarea[@placeholder='Nhập nội dung bình luận phản hồi']")
			public static WebElement inputContentCMT;
			@FindBy(xpath = "//label[@for='mess_setting']")
			public static WebElement activeContentTN;
			@FindBy(xpath = "//textarea[@placeholder='Nhập nội dung tin nhắn phản hồi']")
			public static WebElement inputContentTN;
			@FindBy(xpath = "//div[@class='radio-delay-time']/input[@id='radio-time-1']")
			public static WebElement RadioDelayTime;
			@FindBy(xpath = "//div[@class='modal-footer']/button[2]")
			public static WebElement acceptDelayTime;
			@FindBy(xpath = "//button[@class='btn btn-primary'][2]")
			public static WebElement btnSubmitScript;
			
			//Xóa kịch bản auto reply 
			//@FindBy(xpath = "//label[@title='Chọn']")
			@FindBy(xpath = "//div[@class = 'checkboxabc' ]//label[@title='Chọn']")
			public static WebElement clickCheckbox;
			@FindBy(xpath = "//button[@id='dropdownMenu1']")
			public static WebElement selectOption;
			@FindBy(xpath = "//ul[@class='dropdown-menu show']/li[3]")
			public static WebElement selectOptionDelete;
			@FindBy(xpath = "//button[@class='btn btn-danger']")
			public static WebElement acceptDelete;
			
//			tạo kịch bản auto order
					@FindBy(xpath = "//div[@class='btn_add_new_order']")
					public static WebElement addAutoOrder;
					@FindBy(xpath = "//div[@id='auto_order_scroll_key_variant'] //button")
					public static WebElement addKeys;
					@FindBy(xpath = "//div[@id='div_form_products'] //input")
					public static WebElement focusInputProduct;
					@FindBy(xpath = "//div[@class='item itemSearch'][1]")
					public static WebElement selectFirstProduct;
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
					
		// Xóa sản phẩm bên core
					
					@FindBy(xpath = "//div[@class='group-input-query']//input[@placeholder='Tìm kiếm sản phẩm']")
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
					
					
			//tao don hang
					// chon 1 hoi thoai
					@FindBy(xpath = "//div[@class='d-flex conversation-item'][1]")
					public static WebElement chooseConversation;
					
					@FindBy(xpath = "//div[@id='btn-create-new-order']")
					public static WebElement createOrder;
					@FindBy(xpath = "//input[@placeholder='Tìm kiếm sản phẩm']")
					public static WebElement searchProduct;
					@FindBy(xpath = "//div[@class='d-flex product-form-item selected ']")
					public static WebElement chooseProduct;
					@FindBy(xpath = "//div[@id='btn-submit-select-product']")
					public static WebElement acceptChooseProduct;
					
					@FindBy(xpath = "//div[@class='total-price']")
					public static WebElement priceProduct;
					
					//them dich vu
					@FindBy(xpath = "//span[contains(.,'Thêm dịch vụ khác (F9)')]")
					public static WebElement addService;
					@FindBy(xpath = "//input[@placeholder='Tên dịch vụ']")
					public static WebElement nameService;
					@FindBy(xpath = "//div[@class='d-flex product-line-item'][2]//div[@id='div-price-product-1']")
					public static WebElement priceService;
					@FindBy(xpath = "//input[@id='inp-price-1']")
					public static WebElement inputPriceService;
					@FindBy(xpath = "//textarea[@class='txt-content-note']")
					public static WebElement orderNote;
					
					
					// them phuong thuc thanh toan
					@FindBy(xpath = "//span[@class='order-prepayment-header-action']")
					public static WebElement addPrepayment;
					@FindBy(xpath = "//button[@class='btn-select-option']")
					public static WebElement dropdownPrepayment;
					@FindBy(xpath = "//a[contains(.,'Chuyển khoản')]")
					public static WebElement optionTransfer;
					@FindBy(xpath = "//div[@id='order-prepayment-datetime']//input")
					public static WebElement timePrepayment;
					@FindBy(xpath = "//input[@id='input-money']")
					public static WebElement moneyPay;
					@FindBy(xpath = "//button[@id='btn-create-prepayment']")
					public static WebElement acceptPay;
					
					//check lai khi tao phuong thuc thanh toan
					@FindBy(xpath = "//div[@class='prepayment-name']")
					public static WebElement namePrepayment;
					@FindBy(xpath = "//span[@class='prepayment-field-value-bold']")
					public static WebElement valuePrepayment;
					@FindBy(xpath = "//span[@class='prepayment-field-value']")
					public static WebElement TimeCreatePrepayment;
					
					
					// tao don
					@FindBy(xpath = "//div[@class='button-create-new-order']")
					public static WebElement createNewOrder;
					@FindBy(xpath = "//button[contains(.,'Xác nhận tạo đơn và thanh toán')]")
					public static WebElement AcceptCreateOrder;
					
					//xac nhan thanh toan voi don tao thanh cong
					@FindBy(xpath = "//button[@class='btn btn-text-blue btn-3']")
					public static WebElement otherAction;
					@FindBy(xpath = "//span[@data-for='confirm-payment-tt']")
					public static WebElement acceptPayOder;
					@FindBy(xpath = "//a[contains(.,'Tiền mặt')]")
					public static WebElement optionMoney;
			
					//kiem tra san pham don hang
					@FindBy(xpath = "//div[@class='wrapper-product-info'][1]//img")
					public static WebElement imgageProductOrder;
					@FindBy(xpath = "//div[@class='wrapper-product-info'][1]//p[@class='sku-product text-ellipsis']/span")
					public static WebElement SKUProductOrder;
					@FindBy(xpath = "//div[@class='wrapper-product-info'][1]//div[@class='total-price-product']")
					public static WebElement priceProductOrder;
					@FindBy(xpath = "//div[@class='wrapper-product-info'][2]//img")
					public static WebElement imgService;
					@FindBy(xpath = "//div[@class='wrapper-product-info'][2]//p[@class='name-product text-ellipsis']/span")
					public static WebElement nameServiceOrder;
					@FindBy(xpath = "//div[@class='wrapper-product-info'][2]//div[@class='total-price-product']")
					public static WebElement priceServiceOrder;
					@FindBy(xpath = "//div[@class='total-price text-row d-flex']/div[@class='value']")
					public static WebElement TotalPrice;
					
					
					//kiem tra xac nhan thanh toan
					@FindBy(xpath = "//div[@class='transfer color-row'][1]//span")
					public static WebElement nameOptionTranfer;
					@FindBy(xpath = "//div[@class='transfer color-row'][1]//div[@class='value']")
					public static WebElement moneyTranfer;
					@FindBy(xpath = "//div[@class='transfer color-row'][2]//span")
					public static WebElement nameOptionMoney;
					@FindBy(xpath = "//div[@class='transfer color-row'][2]//div[@class='value']")
					public static WebElement payMoney;
					
					//Giao hang
					@FindBy(xpath = "//button[contains(.,'Giao hàng')]")
					public static WebElement shipOrder;
					@FindBy(xpath = "//div[@class='type-shipping'][3]")
					public static WebElement takeOnStore;
					@FindBy(xpath = "//div[@role='document']//h3/span")
					public static WebElement CodeOrder;
					
					//kiem tra don ben Core
					@FindBy(xpath = "//div[@class='item-info-money']//span[@bind='formatMoney(totalMoneyOrder())']")
					public static WebElement totalPriceOrder;
					@FindBy(xpath = "//span[@bind='formatMoney(totalAmountPaymentedInOrder())']")
					public static WebElement moneyPayed;
					@FindBy(xpath = "//span[contains(.,'Nhận tại cửa hàng')]")
					public static WebElement paymentMethod;
					@FindBy(xpath = "//span[@bind='formatMoney(totalAmountCustomerPayment())']")
					public static WebElement mustPay;
					
					//kiểm tra tin nhắn gửi hóa đơn
					@FindBy(xpath = "//button[@class='btn-close-ship']")
					public static WebElement closeShip;
					@FindBy(xpath = "//div[@class='d-flex float-right']//div[@class='clear-fix content-item content-platform']//span[@class='title']")
					public static Object listOfElements_FlatformRight;
					
}
