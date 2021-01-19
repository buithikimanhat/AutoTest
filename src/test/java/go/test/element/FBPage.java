package go.test.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FBPage {
	// tạo post bên page
				@FindBy(xpath = "//div[contains(@aria-label,'Tạo bài viết')]")
				public static WebElement createPost;
				@FindBy(xpath = "//div[@role='presentation']//div[contains(.,'Viết gì đó cho Thiết bị âm thanh...') and @id]/parent::div/parent::div//div[@role='textbox']")
				public static WebElement contentPost;
				@FindBy(xpath = "//div[@role='button' and contains(.,'Đăng')]")
				public static WebElement btnDang;
	// lấy ID bài post
				//@FindBy(linkText = "Vừa xong")
//				@FindBy(xpath = "//div[@aria-posinset='1']//a[contains(@aria-label,'phút')]")
//				public static WebElement linktextVuaxong;
	// comment bài post

				@FindBy(xpath = "//div[@aria-posinset='1']//button[@aria-label='Nút chọn vai trò']")
				public static WebElement switchUserFB;
				@FindBy(xpath = "//span[contains(.,'Love Kids')]")
				public static WebElement optionUserFB;
				@FindBy(xpath = "//div[@aria-posinset='1']//div[@aria-label='Viết bình luận']")
				public static WebElement clickCMT;
				@FindBy(xpath = "//div[@aria-posinset='1']//div[@aria-label='Bình luận về bài viết']")
				public static WebElement contentComment;
				
				
	// Gửi tin nhắn
				@FindBy(xpath = "//iframe[contains(@src,'https://www.facebook.com/messages/t/113104476716795')]")
				public static WebElement iframeMessage;
			//	@FindBy(xpath = "//div[@role='combobox']/div/div/div")
				@FindBy(xpath = "//div[@aria-label='Nhập tin nhắn...']")
				public static WebElement inputMessage;
				@FindBy(xpath = "//div[@aria-label='Gửi']")
				public static WebElement submitMessage;
				
				
				

}
