package go.test.actions;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.apache.poi.hssf.record.SCLRecord;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

import go.test.element.GlobalPage;

import org.openqa.selenium.WebElement;

public class Base extends WebDriverAction{
	public static WebDriver chromedriver;
	
	public void clearAndSendKeys(WebElement element, String text){
		waitElement(element);
		clear(element);
		waitElementToSendKeys(element, text);
	}
	
	public void closeMultilTab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		try{
			for(int index = 1; index <= tabs.size()-1; index++)
			{
				driver.switchTo().window(tabs.get(index));
				driver.close();
			}
		}
		catch(NoSuchWindowException e) {
			System.out.println("Tabs was closed!");
			   }
		switchTabWindow(0);
		
	}
	public void waitNotification(String locator, String text){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
	    Assert.assertEquals(text, driver.findElement(By.xpath(locator)).getText());
	}
	
	public void openIncognito(String url)
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		chromedriver = new ChromeDriver(capabilities);
		chromedriver.get(url);
	}
	
	public void close()
	{
		chromedriver.quit();
	}
	
	public void saveImageCaptcha(String nameFile) throws Exception
	{
		
		try {
			 String data = (String) ex.executeScript("var cvs = document.createElement('canvas');var image = document.getElementById('img_Captcha');cvs.width = image.width;cvs.height = image.height;var ctx = cvs.getContext('2d');ctx.drawImage(image, 0, 0); return cvs.toDataURL()");
			 System.out.println(data);
			 String base64Image = data.split(",")[1];
			 byte[] imageBytes = Base64.getDecoder().decode(base64Image);
			 BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
			 File outputfile = new File(nameFile);
			 ImageIO.write(img, "png", outputfile);
	    } catch(Exception e) {
	            System.out.println(e.getStackTrace());
	      }
	}
	
	public void deleteProduct() {
		refresh();
		waitElement(GlobalPage.btnDelete_product);
		clickToPoint(GlobalPage.btnDelete_product);
	    waitElement(GlobalPage.btnConfirm_delete_product);
	    click(GlobalPage.btnConfirm_delete_product);
	}
	
}
