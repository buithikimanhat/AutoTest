package go.test.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GlobalPage {
	@FindBy(xpath="//iframe[@name='app-iframe']")
	public static WebElement iframeApp;	
	
	//Create product Sapo
	
	@FindBy(xpath = "//input[@id='Name']")
	public static WebElement txtNameProduct;

	@FindBy(xpath = "//input[@id='sku']")
	public static WebElement txtSKU;
	
	@FindBy(xpath = "//input[@bind='retail_price_txt']")
	public static WebElement txtRetailPrice;
	
	@FindBy(xpath = "//input[@id='show-inventory']")
	public static WebElement cbShowinventory;
	
	@FindBy(xpath = "//tr[1]//td[2]//input[1]")
	public static WebElement txtInitialStock;
	
	@FindBy(xpath="//div[@class='product-footer w-100']//a[contains(., 'Lưu')][1]")
	public static WebElement btnSave;
	//End Create product Sapo
	
	//Kiem hang Sapo
	
	@FindBy(xpath="//input[@id='search-product']")
	public static WebElement txtSearch;
	
	@FindBy(xpath="//div[@class='dropdown-filter']/div/div")
	public static WebElement product01;
	
	
	@FindBy(xpath="//div[@class='input-wrap']/input[1]")
	public static WebElement txtAfter_Quantity;
	
	@FindBy(xpath="//div[@class='ui-title-top-bar']//a[contains(., 'Tạo phiếu kiểm hàng')]")
	public static WebElement btnCreate_stock_adjustments;
	
	
	@FindBy(xpath="//div[@class='adjustment-create--left']//a[contains( ., 'Cân bằng kho')]")
	public static WebElement btnCan_bang_kho;
	// End Kiem hang Sapo
	
	//Delete product Sapo
	
	@FindBy(xpath="//a[contains(., 'Xóa sản phẩm')]")
	public static WebElement btnDelete_product;
	
	@FindBy(xpath="//div[@class='action-btn clearfix']/button[1]")
	public static WebElement btnConfirm_delete_product;
	
	
	
	
	
	
	
	
	
	

}
