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
import go.test.element.GlobalPage;
import go.test.element.OrderElement;

public class Order extends Base {
	
	public Order(){
		PageFactory.initElements(driver, GlobalPage.class);
		PageFactory.initElements(driver, OrderElement.class);
	}
	String nameService = "Sản phẩm dịch vụ test auto";
	String priceService = "30";
//	String priceProduct;
//	int totalPrice;
//	int mustPay;
	String moneyTransfer="20";
	String moneyPay="5";
//	int totalPay = Integer.parseInt(moneyTransfer) + Integer.parseInt(moneyPay) ;
//	String totalPayedString =String.valueOf(totalPay);
	
	@When("^I choose to create an order function$")
	public void i_choose_to_create_an_order_function() throws Throwable {
		closeMultilTab();
		openNewTabWindow( "https://anhbtk-gotest6.mysapo.vn/admin/apps/socials-channel");
		switchToIframe(OrderElement.iframeAdmin);
		Thread.sleep(2000);
		waitElementToClick(OrderElement.fisrtConversation);
	}

	@When("^I choose the product to put in the order$")
	public void i_choose_the_product_to_put_in_the_order() throws Throwable {
		waitElementToClick(OrderElement.createOrder);
		waitElementToSendKeys(OrderElement.searchProduct, "Auto123");
		Thread.sleep(3000);
		waitElementToClick(OrderElement.chooseProduct);
		Thread.sleep(4000);
		waitElementToClick(OrderElement.acceptChooseProduct);
		Thread.sleep(4000);
//		priceProduct = getValueOfAttribute(OrderElement.priceProduct, "title");
		
	}

	@When("^I choose to add another service to the order$")
	public void i_choose_to_add_another_service_to_the_order() throws Throwable {
		waitElementToClick(OrderElement.addService);
		waitElementToSendKeys(OrderElement.nameService, nameService);
		waitElementToClick(OrderElement.priceService);
		Thread.sleep(2000);
		waitElementToSendKeys(OrderElement.inputPriceService, priceService);
		Thread.sleep(2000);
	}

	@When("^I add notes to the order$")
	public void i_add_notes_to_the_order() throws Throwable {
		waitElementToSendKeys(OrderElement.orderNote, "Ghi chú đơn hàng tạo auto");
		Thread.sleep(2000);
	}

	@When("^I add payment confirmation$")
	public void i_add_payment_confirmation() throws Throwable {
		//them xac nhan thanh toan trong khi tao don
		waitElementToClick(OrderElement.addPrepayment);
		Thread.sleep(2000);
		waitElementToClick(OrderElement.dropdownPrepayment);
		Thread.sleep(2000);
		waitElementToClick(OrderElement.optionTransfer);
		Thread.sleep(2000);
		clear(OrderElement.moneyPay);
		waitElementToSendKeys(OrderElement.moneyPay, moneyTransfer);
		waitElementToClick(OrderElement.acceptPay);
		Thread.sleep(2000);
	}

	@When("^I check to add the payment successfully$")
	public void i_check_to_add_the_payment_successfully() throws Throwable {
		assertText(OrderElement.namePrepayment, "Chuyển khoản");
		assertTextNode(OrderElement.valuePrepayment, moneyTransfer + " đ");
		Thread.sleep(2000);
	}

	@Then("^I do create an order$")
	public void i_do_create_an_order() throws Throwable {
		waitElementToClick(OrderElement.createNewOrder);
		Thread.sleep(2000);
		waitElementToClick(OrderElement.AcceptCreateOrder);
	}

	@When("^I check the products in the order$")
	public void i_check_the_products_in_the_order() throws Throwable {
		//san pham
		assertText(OrderElement.SKUProductOrder, "Auto123");
		assertText(OrderElement.priceProductOrder, "20");
		//dich vu
		assertText(OrderElement.nameServiceOrder, nameService);
		assertText(OrderElement.priceServiceOrder, priceService);
	}

	@When("^I check the total value of the order$")
	public void i_check_the_total_value_of_the_order() throws Throwable {
		//tong tien
//		totalPrice = Integer.parseInt(priceProduct) + Integer.parseInt(priceService) ;
//		String total=String.valueOf(totalPrice);
		assertText(OrderElement.TotalPrice, "50");
	}

	@When("^I do the second payment confirmation$")
	public void i_do_the_second_payment_confirmation() throws Throwable {
		//xac nhan thanh toan
		waitElementToClick(OrderElement.otherAction);
		Thread.sleep(2000);
		waitElementToClick(OrderElement.acceptPayOder);
		Thread.sleep(2000);
		waitElementToClick(OrderElement.dropdownPrepayment);
		Thread.sleep(2000);
		waitElementToClick(OrderElement.optionMoney);
		Thread.sleep(2000);
		clear(OrderElement.moneyPay);
		waitElementToSendKeys(OrderElement.moneyPay, moneyPay);
		waitElementToClick(OrderElement.acceptPay);
		Thread.sleep(2000);
	}

	@When("^I check the payment confirmation of the application$")
	public void i_check_the_payment_confirmation_of_the_application() throws Throwable {
		// kiểm tra xác nhận thanh toán đơn nháp
		assertText(OrderElement.nameOptionTranfer, "Chuyển khoản");
		assertText(OrderElement.moneyTranfer, moneyTransfer);
		assertText(OrderElement.nameOptionMoney, "Tiền mặt");
		assertText(OrderElement.payMoney, moneyPay);

//		mustPay = totalPrice - totalPay;
//		String mustPayString =String.valueOf(mustPay);
	}

	@When("^I choose packing and delivery for the order$")
	public void i_choose_packing_and_delivery_for_the_order() throws Throwable {
		//giao hang
		waitElementToClick(OrderElement.shipOrder);
		Thread.sleep(1000);
		waitElementToClick(OrderElement.takeOnStore);
		Thread.sleep(1000);
	}

	@Then("^I check the order in the system$")
	public void i_check_the_order_in_the_system() throws Throwable {
		waitElementToClick(OrderElement.CodeOrder);
		Thread.sleep(3000);
		switchToNewWindow();
		Thread.sleep(3000);
		scroll(0, 200);
		assertText(OrderElement.totalPriceOrder, "50");
		scroll(0, 300);
		assertText(OrderElement.moneyPayed, "25");
		assertText(OrderElement.mustPay, "25");
		assertText(OrderElement.paymentMethod, "Nhận tại cửa hàng");
	}



}
