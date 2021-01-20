package go.test.element;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class OrderElement {
	@FindBy(xpath = "//iframe[@class='app-iframe app-iframe--admin']")
	public static WebElement iframeAdmin;
	@FindBy(xpath = "//div[@class = 'd-flex conversation-item'][1]")
	public static WebElement fisrtConversation;
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
	

}
