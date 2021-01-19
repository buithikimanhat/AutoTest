package go.test.stepdefine;

import org.apache.commons.lang3.ThreadUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import go.test.actions.Base;
import go.test.actions.Const;
import go.test.element.FBChannelPage;
import go.test.element.FBPage;
import go.test.element.GlobalPage;


public class FBDefine extends Base{
	public FBDefine(){
		PageFactory.initElements(driver, GlobalPage.class);
		PageFactory.initElements(driver, FBPage.class);
		PageFactory.initElements(driver, FBChannelPage.class);
	}
	
	String manualmessage ="Tin nhắn daily thủ công " + java.time.LocalDateTime.now() ;
	String manualcmt = "Check bình luận thủ công " + java.time.LocalDateTime.now();
	String autoMessage = "Xin chào Love Kids, nội dung phản hồi cmt auto cho tất cả bài đăng" + java.time.LocalDate.now();
	String autoCmt = "Xin chào Love Kids, nội dung bình luận phản hồi auto cho tất cả bài đăng" + java.time.LocalDate.now();
	String checkautocmt = "Bình luận test auto reply bài post" + java.time.LocalDateTime.now();
	String nameProduct = java.time.LocalTime.now() + " Sản phẩm kênh fb test auto";
	String nameService = "Sản phẩm dịch vụ test auto";
	String priceService = "30";
	String priceProduct;
	int totalPrice;
	int mustPay;
	String moneyTransfer="20";
	String moneyPay="5";
	int totalPay = Integer.parseInt(moneyTransfer) + Integer.parseInt(moneyPay) ;
	String totalPayedString =String.valueOf(totalPay);
	String urlpost;
	
	@When("^I connect facebook account$")
	public void i_connect_facebook_account() throws Exception {
		openNewTabWindow( Const.URL + "/admin/apps/socials-channel");		
		// 3 step hướng dẫn
		switchToIframe(FBChannelPage.iframeSocial);
		waitElementToClick(FBChannelPage.btnStep1);Thread.sleep(1000);
		waitElementToClick(FBChannelPage.btnStep2);Thread.sleep(1000);
		waitElementToClick(FBChannelPage.btnStep3);Thread.sleep(1000);
		waitElementToClick(FBChannelPage.btnConnect);
		// pop up đăng nhập tài khoản facebook
				switchToNewWindow();
				if(!driver.findElements(By.xpath("//input[@id='email']")).isEmpty()){
				 	waitElementToSendKeys(FBChannelPage.txtemail, "nguyenthuha.09b1@gmail.com");
					sendKeys(FBChannelPage.txtpass, "me.luyen.2020");
					click(FBChannelPage.btnLoginFb2);
					switchToNewWindow();
				if(!driver.findElements(By.xpath("//button[@id='checkpointSubmitButton']")).isEmpty()){
						waitElementToClick(FBChannelPage.btnLoginFb);
						Thread.sleep(2000);
						// Chon xac thuc email
						waitElementToClick(FBChannelPage.btnLoginConfirmEmail);
						click(FBChannelPage.btnSubmitConfirm);
						Thread.sleep(2000);
						waitElementToClick(FBChannelPage.btnSubmitEmail);
						Thread.sleep(2000);
						// dang nhap mail
						switchToNewWindow();
						// Nhap ten tai khoan email
						waitElementToSendKeys(FBChannelPage.txtemailGoogle, "nguyenthuha.09b1@gmail.com");
						click(FBChannelPage.btnUsenameEmail);
						// nhap pass
						Thread.sleep(3000);
						waitElementToSendKeys(FBChannelPage.txtpassGoogle, "ha.dim.2014");
						click(FBChannelPage.btnUsenameEmail);
						Thread.sleep(5000);
						switchTabWindow(2);
						waitElementToClick(FBChannelPage.btnLoginFb3);
						waitElementToClick(FBChannelPage.btnTieptuc);
						}
					}								
					Thread.sleep(1000);
					waitElementToClick(FBChannelPage.btntieptuc);
	}

	@When("^Connect facebook page$")
	public void connect_facebook_page() throws Exception {
		Thread.sleep(2000);
		switchTabWindow(1);
		switchToIframe(FBChannelPage.iframeAdmin);
		waitElementToClick(FBChannelPage.divChoosepage);	
		
		
		// tắt pop up chuyen đổi giao diện
		Thread.sleep(3000);
		waitElementToClick(FBChannelPage.switchNewVersion);

		//tắt popup cập nhật mới 
		Thread.sleep(2000);
		waitElementToClick(FBChannelPage.closePopupUpdate);
		Thread.sleep(2000);
		waitElementToClick(FBChannelPage.swithNewVersion2);
		// tooltip hướng dẫn 
		Thread.sleep(1000);
		waitElementToClick(FBChannelPage.closeTooltip);
		Thread.sleep(1000);
		waitElementToClick(FBChannelPage.closeTooltipAccept);
	}

	@When("^I create a post on page$")
	public void i_create_a_post_on_page() throws Exception {
		openNewTabWindow("http://fb.com/113104476716795");	
		Thread.sleep(4000);
		waitElementToClick(FBPage.createPost);
		Thread.sleep(6000);
		waitElementToClick(FBPage.contentPost);
		waitElementToSendKeys(FBPage.contentPost,"Bài viết daily " + java.time.LocalDateTime.now() );
		// tắt sự kiện load lại của trình duyệt - đặt trước button
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.onbeforeunload = null;");
		//

		click(FBPage.btnDang);	
		//open("https://www.facebook.com/pg/Thi%E1%BA%BFt-b%E1%BB%8B-%C3%A2m-thanh-113104476716795/posts/?ref=page_internal");
		Thread.sleep(5000);
		scroll(0,400);	
//		open("http://fb.com/113104476716795");	
//		waitElementToClick(FBPage.linktextVuaxong);
//		urlpost= driver.getCurrentUrl();
		// chuyển vai trò
//		Thread.sleep(5000);
		
		waitElementToClick(FBPage.switchUserFB );
		Thread.sleep(1000);
		clickToPoint(FBPage.optionUserFB);
	}

	@When("^I comment on post$")
	public void i_comment_on_post() throws Exception {
		Thread.sleep(3000);
		waitElementToClick(FBPage.clickCMT);
		waitElementToSendKeys(FBPage.contentComment,manualcmt);
		FBPage.contentComment.sendKeys(Keys.ENTER);	
		Thread.sleep(5000);
	}

	@Then("^In facebookchannel display comment$")
	public void in_facebookchannel_display_comment()  throws Exception {
		switchTabWindow(1);
		switchToIframe(FBChannelPage.iframeAdmin);
		assertText(FBChannelPage.nameConversation, "Love Kids");
	//	assertText(FBChannelPage.snippetConversation, manualcmt);	
		click(FBChannelPage.fisrtConversation);
		Thread.sleep(5000);
		// phải thêm kiểm tra hiển thị nội dung detail bình luận
		assertText(FBChannelPage.DetailcmtConversation, manualcmt);	
		exitIframe();
	}

	@When("^Send Message to page$")
	public void send_Message_to_page()  throws Exception{
		switchTabWindow(2);
		openNewTabWindow("https://www.facebook.com/messages/t/113104476716795");
		Thread.sleep(5000);
		switchToIframe(FBPage.iframeMessage);
		waitElementToSendKeys(FBPage.inputMessage,manualmessage);
		FBPage.inputMessage.sendKeys(Keys.ENTER);
	}

	@Then("^In facebookchannel display Message$")
	
	public void in_facebookchannel_display_Message() throws Exception {
	 
		switchTabWindow(1);
		switchToIframe(FBChannelPage.iframeAdmin);
		Thread.sleep(2000);
		assertText(FBChannelPage.nameConversation, "Love Kids");
	//	assertText(FBChannelPage.snippetConversation, manualmessage);	
		click(FBChannelPage.fisrtConversation);
		// phải thêm kiểm tra hiển thị nội dung tin nhắn
	//	String abc = FBChannelPage.listOfElements.get(FBChannelPage.listOfElements.size()-1).getText();			
	//	assertText(FBChannelPage.listOfElements_left.get(FBChannelPage.listOfElements_left.size()-1), manualmessage);
		Thread.sleep(5000);
		exitIframe();
	}

	@When("^Set up automated responses$")
	public void set_up_automated_responses() throws Exception {
		switchTabWindow(3);
		//Vao man hinh cong cu tu dong
		openNewTabWindow(Const.URL + "/admin/apps/socials-channel/facebook/autoreply");	
		switchToIframe(FBChannelPage.iframeAdmin);
		Thread.sleep(2000);					
		//them kich ban auto reply binh luan
				waitElementToClick(FBChannelPage.btnAddScript);
				Thread.sleep(2000);
				waitElementToClick(FBChannelPage.btnAddComment);
				Thread.sleep(2000);
				waitElementToSendKeys(FBChannelPage.NameScriptComment, "Kịch bản phản hồi cmt auto" + java.time.LocalDate.now());
				waitElementToClick(FBChannelPage.optionTime);
				waitElementToClick(FBChannelPage.btnNextStepCMT);
				Thread.sleep(2000);
				waitElementToSendKeys(FBChannelPage.inputContentCMT, autoCmt);
				click(FBChannelPage.activeContentTN);
				Thread.sleep(1000);
				waitElementToSendKeys(FBChannelPage.inputContentTN, autoMessage);
				clickToPoint(FBChannelPage.RadioDelayTime); 
				waitElementToClick(FBChannelPage.acceptDelayTime);
				Thread.sleep(1000);
				click(FBChannelPage.btnSubmitScript);
				Thread.sleep(3000);
	}

	@When("^Customer comment or Send Message to page$")
	public void customer_comment_or_Send_Message_to_page() throws Exception {
		switchTabWindow(2);
		// gửi bình luận
		Thread.sleep(3000);
		waitElementToSendKeys(FBPage.contentComment,checkautocmt);
		FBPage.contentComment.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
	  
	}

	@Then("^Automated responses are sent instantly$")
	public void automated_responses_are_sent_instantly() throws Exception {
	switchTabWindow(1);

		open("https://sapogo-test.mysapo.vn/admin/apps/socials-channel/facebook/all");
		Thread.sleep(3000);
		switchToIframe(FBChannelPage.iframeAdmin);		
		// check tin nhắn phản hồi
		assertText(FBChannelPage.nameConversation, "Love Kids");
		//assertText(FBChannelPage.snippetConversation, " Love Kids: [Link]"); 
		Thread.sleep(2000);
		click(FBChannelPage.fisrtConversation);
		Thread.sleep(5000);	
		scroll(0, 800);
		assertText(FBChannelPage.listOfElements_right.get(FBChannelPage.listOfElements_right.size()-1), autoMessage);
		Thread.sleep(5000);
		
		// check bình luận phản hồi
		assertText(FBChannelPage.nameConversation, "Love Kids");
	//	assertText(FBChannelPage.snippetConversation,"Thiết bị âm thanh:"+ autoCmt);
		click(FBChannelPage.fisrtConversation);
		Thread.sleep(5000);
		scroll(0, 800);
		//assertText(FBChannelPage.listOfElements_left.get(FBChannelPage.listOfElements_left.size()-1),checkautocmt); //listOfElements_left.size()-1), checkautocmt);
		assertText(FBChannelPage.listOfElements_left.get(FBChannelPage.listOfElements_left.size()-1),autoCmt);
	//	assertText(FBChannelPage.listOfElements_right.get(FBChannelPage.listOfElements_right.size()-1), autoCmt); 
		//xóa kịch bản phản hồi cmt
		switchTabWindow(4);
		switchToIframe(FBChannelPage.iframeAdmin);
		waitElementToClick(FBChannelPage.clickCheckbox);
		waitElementToClick(FBChannelPage.selectOption);
		waitElementToClick(FBChannelPage.selectOptionDelete);
		waitElementToClick(FBChannelPage.acceptDelete);
		Thread.sleep(3000);
	}

	@When("^Set up automated create order$")
	public void set_up_automated_create_order() throws  Exception {
	switchTabWindow(4);
		openNewTabWindow("https://sapogo-test.mysapo.vn/admin/apps/socials-channel/facebook/autoOrder");
	    Thread.sleep(4000);
	    switchToIframe(FBChannelPage.iframeAdmin);
	    click(FBChannelPage.addAutoOrder);
	    Thread.sleep(5000);
	    scroll(0, 400); 
	    
	    //them mẫu nội dung
	    waitElementToClick(FBChannelPage.addKeys); 
	    waitElementToSendKeys(FBChannelPage.searchProduct, "Auto123");
		Thread.sleep(3000);
	    waitElementToClick(FBChannelPage.selectFirstProduct); 
	    Thread.sleep(3000);
	    
	    // tạo sản phẩm
	    waitElementToClick(FBChannelPage.addProduct); 
	    sendKeys(FBChannelPage.ProductName, nameProduct);
	    clear(FBChannelPage.ProductPrice);
	    sendKeys(FBChannelPage.ProductPrice, "20");
	    Thread.sleep(2000);
	    sendKeys(FBChannelPage.keyword, "key"+java.time.LocalDate.now());
	    waitElementToClick(FBChannelPage.saveKeyword);
	    Thread.sleep(3000);
	    //kiem tra san pham moi tao
		    assertValueOfAttribute(FBChannelPage.imageNewProduct, "src", "https://socials.sapoapps.vn/images/no-image-post.png");
		    assertTextNode(FBChannelPage.nameNewProduct, nameProduct);
		    assertValueOfAttribute(FBChannelPage.priceNewProduct, "value", "20");
	    
	    //điều kiện tạo đơn và nội dung phản hồi
	    clickToPoint(FBChannelPage.phoneCondition);
	    clickToPoint(FBChannelPage.replyCorectCMT);
	    clickToPoint(FBChannelPage.replyIncorrectCMT);
	    clickToPoint(FBChannelPage.sendLinkOrder);
	    clickToPoint(FBChannelPage.sendLinkProduct);
	    waitElementToClick(FBChannelPage.saveScript);
	    Thread.sleep(5000);
	    waitElementToClick(FBChannelPage.closePopupPost); 
	
	 
	    
	}

	@Then("^I have a auto order script on List$")
	public void I_have_a_auto_order_script_on_List() throws Exception {
		 //xóa kịch bản livstream
		waitElementToClick(FBChannelPage.checkboxchoose);
		waitElementToClick(FBChannelPage.selectOption);
		waitElementToClick(FBChannelPage.selectOptionDeletelive);
		waitElementToClick(FBChannelPage.acceptDelete);
		Thread.sleep(3000);
	// Xóa sản phẩm 		
		
		switchTabWindow(0);
		open(Const.URL + "/admin/products");
	    Thread.sleep(2000);
	    waitElementToSendKeys(FBChannelPage.inputtimkiem,nameProduct);
	    FBChannelPage.inputtimkiem.sendKeys(Keys.ENTER);
	    Thread.sleep(3000);
	    clickToPoint(FBChannelPage.clickCheckboxProduct);
	    Thread.sleep(2000);
	    clickToPoint(FBChannelPage.selectOptionProduct);
	    Thread.sleep(2000);
	    clickToPoint(FBChannelPage.selectOptionDeleteProduct);
	    Thread.sleep(2000);
	    clickToPoint(FBChannelPage.acceptDeleteProduct);
		Thread.sleep(4000);
		waitElementToClick(FBChannelPage.acceptDeleteProduct2);
		Thread.sleep(3000);
	}


	@When("^Set up a order and create prepayment$")
	public void Set_up_a_order_and_create_prepayment() throws Exception {
		switchTabWindow(1);
		switchToIframe(FBChannelPage.iframeAdmin);
		//chay thu
//		waitElementToClick(FBChannelPage.chooseConversation);
//		Thread.sleep(3000);
		//
		waitElementToClick(FBChannelPage.createOrder);
		waitElementToSendKeys(FBChannelPage.searchProduct, "Auto123");
		Thread.sleep(3000);
		waitElementToClick(FBChannelPage.chooseProduct);
		Thread.sleep(4000);
		waitElementToClick(FBChannelPage.acceptChooseProduct);
		Thread.sleep(4000);
		priceProduct = getValueOfAttribute(FBChannelPage.priceProduct, "title");
		
		waitElementToClick(FBChannelPage.addService);
		waitElementToSendKeys(FBChannelPage.nameService, nameService);
		waitElementToClick(FBChannelPage.priceService);
		Thread.sleep(2000);
		waitElementToSendKeys(FBChannelPage.inputPriceService, priceService);
		Thread.sleep(2000);
		waitElementToSendKeys(FBChannelPage.orderNote, "Ghi chú đơn hàng tạo auto");
		Thread.sleep(2000);
		
		//them xac nhan thanh toan trong khi tao don
		waitElementToClick(FBChannelPage.addPrepayment);
		Thread.sleep(2000);
		waitElementToClick(FBChannelPage.dropdownPrepayment);
		Thread.sleep(2000);
		waitElementToClick(FBChannelPage.optionTransfer);
		Thread.sleep(2000);
		String timePrepayment =getValueOfAttribute(FBChannelPage.timePrepayment, "value");
		clear(FBChannelPage.moneyPay);
		waitElementToSendKeys(FBChannelPage.moneyPay, moneyTransfer);
		waitElementToClick(FBChannelPage.acceptPay);
		Thread.sleep(2000);
		
		//check result create prepayment
		assertText(FBChannelPage.namePrepayment, "Chuyển khoản");
		assertTextNode(FBChannelPage.valuePrepayment, moneyTransfer + " đ");
		assertText(FBChannelPage.TimeCreatePrepayment, timePrepayment);
		Thread.sleep(2000);
		
		//xac nhan tao don
		waitElementToClick(FBChannelPage.createNewOrder);
		Thread.sleep(2000);
		waitElementToClick(FBChannelPage.AcceptCreateOrder);
		
	}
	
	@When("^I see a detail order and choose shipment$")
	public void I_see_a_detail_order_and_choose_shipment() throws Exception {
		Thread.sleep(3000);
		
		//kiem tra sản phẩm trong don hang
			//san pham 
		assertValueOfAttribute(FBChannelPage.imgageProductOrder, "src", "https://sapo.dktcdn.net/thumb/small/100/171/753/variants/fa1f747b-cb24-4eb0-bd1d-bfe65a2edfef.jpg");
		assertText(FBChannelPage.SKUProductOrder, "Auto123");
		assertText(FBChannelPage.priceProductOrder, priceProduct);
		
			//dich vu
		assertValueOfAttribute(FBChannelPage.imgService, "src", "https://socials.sapoapps.vn/images/no-image-post-grey.png");
		assertText(FBChannelPage.nameServiceOrder, nameService);
		assertText(FBChannelPage.priceServiceOrder, priceService);
		
			//tong tien
		totalPrice = Integer.parseInt(priceProduct) + Integer.parseInt(priceService) ;
		String total=String.valueOf(totalPrice);
		assertText(FBChannelPage.TotalPrice, total);
		
		//xac nhan thanh toan
		waitElementToClick(FBChannelPage.otherAction);
		Thread.sleep(2000);
		waitElementToClick(FBChannelPage.acceptPayOder);
		Thread.sleep(2000);
		waitElementToClick(FBChannelPage.dropdownPrepayment);
		Thread.sleep(2000);
		waitElementToClick(FBChannelPage.optionMoney);
		Thread.sleep(2000);
		clear(FBChannelPage.moneyPay);
		waitElementToSendKeys(FBChannelPage.moneyPay, moneyPay);
		waitElementToClick(FBChannelPage.acceptPay);
		Thread.sleep(2000);
		
		// kiểm tra xác nhận thanh toán đơn nháp
		assertText(FBChannelPage.nameOptionTranfer, "Chuyển khoản");
		assertText(FBChannelPage.moneyTranfer, moneyTransfer);
		assertText(FBChannelPage.nameOptionMoney, "Tiền mặt");
		assertText(FBChannelPage.payMoney, moneyPay);

		mustPay = totalPrice - totalPay;
		String mustPayString =String.valueOf(mustPay);
		
		//giao hang
		waitElementToClick(FBChannelPage.shipOrder);
		Thread.sleep(1000);
		waitElementToClick(FBChannelPage.takeOnStore);
		Thread.sleep(1000);
		
		//kiem tra don hang ve Core
		waitElementToClick(FBChannelPage.CodeOrder);
		Thread.sleep(3000);
		switchToNewWindow();
		Thread.sleep(3000);
		scroll(0, 200);
		assertText(FBChannelPage.totalPriceOrder, total);
		scroll(0, 300);
		assertText(FBChannelPage.moneyPayed, totalPayedString);
		assertText(FBChannelPage.mustPay, mustPayString);
		assertText(FBChannelPage.paymentMethod, "Nhận tại cửa hàng");
		
	}
	@Then("^Customer has a order and Automated respones a bill message$")
	public void customer_has_a_order_and_Automated_respones_a_bill_message() throws Throwable {
		switchTabWindow(1);
		switchToIframe(FBChannelPage.iframeAdmin);
		Thread.sleep(2000);
		waitElementToClick(FBChannelPage.closeShip);
		Thread.sleep(1000);
		assertText(FBChannelPage.nameConversation, "Love Kids");
		assertText(FBChannelPage.snippetConversation, " Thiết bị âm thanh: [Đơn hàng]");	
		click(FBChannelPage.fisrtConversation);
	}

}

