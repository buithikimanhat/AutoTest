package go.test.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.jayway.restassured.RestAssured.given;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverAction {
	public static WebDriver driver;
	public WebDriverWait wait = new WebDriverWait (driver, 20);
	public JavascriptExecutor ex = (JavascriptExecutor) driver;

	public void open(String url){
		driver.get(url);
		waitForPageLoad();
	}
	
	public String getCurrentUrl(){
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public void close(){
		driver.close();
	}
	
	public void refresh(){
		driver.navigate().refresh();
		if(isAlertPresent()==true){
			driver.switchTo().alert().dismiss();
		}
	}
	
	public void back(){
		driver.navigate().back();
		if(isAlertPresent()==true){
			driver.switchTo().alert().dismiss();
		}
	}
	
	public void click(By locator, WebDriver driver){
		driver.findElement(locator).click();				
	}

	public void click(WebElement element){
		try{			
			element.click();
		}catch(Exception e)
		{
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
		}				
	}
	
	public void doubleClick(WebElement element){
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	
	public void clickToPoint(WebElement element){
		try{			
			element.click();
		}catch(Exception e)
		{
			ex.executeScript("arguments[0].click();", element);
		}		
	}
	
	public void clear(WebElement element){
		element.clear();
	}
	
	public void sendKeys(WebElement element, String value){
		element.sendKeys(value);
	}
	
	public void sendKeysEachCharacter(WebElement element, String value){
		/*Actions actions = new Actions(driver);
		actions.moveToElement(element).click(element);
		for (int i = 0; i < value.length(); i++){
	        char c = value.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        actions.sendKeys(s).build().perform();
	    }   */
		
		clickToPoint(element);
		for (int i = 0; i < value.length(); i++){
	        char c = value.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        element.sendKeys(s);
	        //ex.executeScript(element, "arguments[0].setAttribute('value', '" + value + "')");
	    }   
		element.sendKeys(Keys.TAB);
	}
	
	public void sendKeysWithIframe(WebElement iframe, WebElement body, String value){
		driver.switchTo().frame(iframe);
		//body.clear();
		body.sendKeys(Keys.CONTROL,"a");
		body.sendKeys(Keys.DELETE);
		sendKeys(body,value);
		driver.switchTo().defaultContent();
	}
	
	public void switchToIframe(WebElement iframe){
		driver.switchTo().frame(iframe);
	}
	
	public void exitIframe(){
		driver.switchTo().defaultContent();
	}
	public void switchToNewWindow(){
		String parentHandle = driver.getWindowHandle(); //get window hiện tại 
		for (String winHandle : driver.getWindowHandles()) { // switch focus vào window mới
		    driver.switchTo().window(winHandle); 
		}
	}
	
	public void scroll(int x, int y){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("window.scrollBy("+ x + ", " + y + ")", "");
		jse.executeScript("scroll("+ x + ", " + y + ");");
	}
	
	public String getText(WebElement element){
		return element.getText();
	}
	
	
	public void assertText(WebElement element, String text){
		waitElement(element);
		Assert.assertEquals(text, element.getText());
	}
	
	public void assertTrue(WebElement element, String text){
		waitElement(element);
		Assert.assertTrue(element.getText().contains(text));
	}	
	
	public void compareString(String actual, String expected){
		Assert.assertTrue(actual.equals(expected));
	}
	
	public void compareStringContainsText(String actual, String expected){
		Assert.assertTrue(actual.contains(expected));
	}
	
	public void checkElementContainsText(WebElement element, String text){
		String actualString = element.getText();
		Assert.assertTrue(actualString.contains(text));
	}
	
	public Boolean verifyElementPresent(By locator){
		if(driver.findElements(locator).size() !=0)
		{
			return true;
		}
		else return false;
//		Assert.assertTrue(driver.findElements(By.xpath(locator)).size() !=0);
	}
	
//	public boolean isElementNotPresent(String locator) {
//	    try {
//	        driver.findElement(By.xpath(locator));
//	        return false;
//	    } catch (org.openqa.selenium.NoSuchElementException e) {
//	        return true;
//	    }
//	}
//	
//	public void checkElementNotPresent(String locator){
//		Assert.assertTrue(isElementNotPresent(locator));
//	}
	
	public void checkElementNotPresent(String locator){
		Assert.assertTrue(driver.findElements(By.xpath(locator)).size() ==0);
	}
	
	public void checkElementPresent(String locator){
		Assert.assertTrue(driver.findElements(By.xpath(locator)).size() !=0);
	}
	
	public String getValueOfAttribute(WebElement element, String attribute){
		String value = element.getAttribute(attribute);
		return value;
	}
	
	public void assertValueOfAttribute(WebElement element, String attribute, String text){
		String value = element.getAttribute(attribute);		
		Assert.assertEquals(text, value);
	}
	
	public void hoverAndClick(WebElement hover, WebElement target){
		Actions action = new Actions(driver);
		action.moveToElement(hover).moveToElement(target).click().build().perform();
	}
	
	public void selectDropbox(final WebElement element, String text){	
		Select select = new Select(element);
		textToBePresentInElement(element, text);
		select.selectByVisibleText(text);
		waitForPageLoad();
		element.sendKeys(Keys.TAB);
	}
	
	public void selectValueDropbox(WebElement element, String text){	
		Select select = new Select(element);
		select.selectByValue(text);
	}
	
	public void selectDropbox(WebElement element, int index){
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void dragAndDrop(WebElement src, WebElement targ){
		Actions action = new Actions(driver);
		Action dragDrop = action.dragAndDrop(src, targ).build();
//		Action dragDrop = action.dragAndDropBy(src, 0 , -100).build();
		dragDrop.perform();
	}
	
	public void checkBox(WebElement element){
		try{
			if (!element.isSelected())
			{
				if(element.isDisplayed())  click(element); 
				else clickToPoint(element);
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void unCheckBox(WebElement element){
		try{
			if (element.isSelected())
			{
				if(element.isDisplayed())  click(element); 
				else clickToPoint(element);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	/*public void checkBox(WebElement element){
		try{
		if (!element.isSelected())
		{
		     element.click();
		}
		else System.out.println("Checkbox was Selected!");
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void unCheckBox(WebElement element){
		try{
			if (element.isSelected())
			{
			    element.click();
			}
			else System.out.println("Checkbox was UnChecked!");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}*/
	
	public void waitElement(WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitElementTobeClickable(WebElement element){
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitListElement(List<WebElement> element){
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	public void waitElementToClick(WebElement element){
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public void waitElementToSendKeys(WebElement element, String value){
		wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(value);
	}
	
	public void waitElementWithText(By locator, String text){
		wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, driver.findElement(locator).getText()));
		Assert.assertEquals(driver.findElement(locator).getText(), text);
	}
	
	public void waitElementContainsText(WebElement element, String text){
		wait.until(ExpectedConditions.visibilityOf(element));
		checkElementContainsText(element, text);
	}
	
	public void textToBePresentInElement(WebElement element, String text)
	{
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public void waitElementWithText(WebElement element, String text){
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
//		String expected_text = element.getText();
//		Assert.assertEquals(element.getText(), text);
	}
	
	public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }
	    catch (Exception e) 
	    { 
	        return false; 
	    }
	}	
	
	public void refreshForWaitElement(final WebElement element){
		ExpectedCondition <Boolean> example = new ExpectedCondition <Boolean>(){ 
			public Boolean apply(WebDriver args){
				driver.navigate().refresh();
				if(isAlertPresent()==true){
					driver.switchTo().alert().dismiss();
				}
				return element.isEnabled();
			}
		};
		wait.until(example);
	}
	
	public void refreshForWaitElementInIframe(final WebElement element, final WebElement iframe){
		  ExpectedCondition <Boolean> example = new ExpectedCondition <Boolean>(){
		   public Boolean apply(WebDriver args){
		    driver.navigate().refresh();
		    if(isAlertPresent()==true){
				driver.switchTo().alert().dismiss();
			}
		    driver.switchTo().frame(iframe);
		    return element.isEnabled();
		   }
		  };
		  wait.until(example);
	}
	
	public Boolean trueEnabled(final WebElement element){
		ExpectedCondition<Boolean> example = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver args) {
				return element.isEnabled();
			}
		};
		return wait.until(example);
	}
	
	public Boolean trueDisplayed(final WebElement element){
		try
		{
			ExpectedCondition<Boolean> example = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver args) {
					return element.isDisplayed();
				}
			};
			return wait.until(example);
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public void isEnabled(WebElement element){
		Assert.assertEquals(true, element.isEnabled());
	}
	
	public void isDisplayed(WebElement element){
		Assert.assertEquals(true, element.isDisplayed());
	}
	
	public void waitElementIsInvisible(String locator){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	}
	
	public Boolean checkElementExist(WebElement element){
		try{
		if(element.isDisplayed())
			return true;
			else return false;
		}
		catch (Exception e){
			return false;
		}
	}
	
	public void isDisabled(WebElement element){
		Assert.assertEquals(false, checkElementExist(element));
	}
	
	public void openNewTabWindow(String url){
		((JavascriptExecutor)driver).executeScript("window.open()");		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());   
		   driver.switchTo().window(tabs.get(tabs.size()-1)); 
		   driver.get(url);
	}
	
	public void closeTabWindow(String title){	   
		   Set<String> allWindows = driver.getWindowHandles();
		   if(!allWindows.isEmpty()) {
		   for (String windowId : allWindows){
		   try {
			   if(driver.switchTo().window(windowId).getTitle().equals(title)) 
			   {
				   driver.close();
				   break;
			   } 
		   }
		   catch(NoSuchWindowException e) {
			   e.printStackTrace();
		   } } }
	}
	
	public void checkCloseTab()
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		for(int i = driver.getWindowHandles().size() -1 ; i > 0 ; i--)
		{
	        String winHandle = driver.getWindowHandles().toArray()[i].toString();
	        driver.switchTo().window(winHandle);
	        driver.close();
		}
		driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
	}
	
	public void closeTabWindow(int index){
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		   try {
			   if(driver.switchTo().window(tabs.get(index)) != null) 
			   {
				   driver.close();
			   } 
		   }
		   catch(NoSuchWindowException e) {
			   e.printStackTrace();
		   }
	}
	
	public void switchTabWindow(int tab_number){
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());   
		   try {
			   	driver.switchTo().window(tabs.get(tab_number));
			   	waitForPageLoad();
			   }
		   catch(NoSuchWindowException e) {
		   e.printStackTrace();
		   }
	}
	
	public void uploadFile(String path, String idInput){
		/*try{
		  StringSelection string = new StringSelection(path);
	      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string, null);
	      
	      Thread.sleep(5000);
	      Robot robot = new Robot();
	      robot.keyPress(KeyEvent.VK_CONTROL);
	      robot.keyPress(KeyEvent.VK_V);
	      robot.keyRelease(KeyEvent.VK_V);
	      robot.keyRelease(KeyEvent.VK_CONTROL);
	      robot.keyPress(KeyEvent.VK_ENTER);
	      robot.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e)
		{
			System.out.println("CÓ LỖI KHI UPLOAD FILE" + e.getMessage());
		}*/
		
		checkElementExist(By.id(""+ idInput +""), true);
		if(driver.findElement(By.id(""+ idInput +"")).getAttribute("style") == "none")
			ex.executeScript("document.getElementById('"+idInput+"').style.display = 'block';");
		driver.findElement(By.id(""+idInput+"")).sendKeys(path);
  	//ex.executeScript("document.getElementById('"+idInput+"').style.display = 'none';");
	}
	
	public void verifyPrintDialog(){
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		((JavascriptExecutor)driver).executeScript(
			    "var callback = arguments[1];" +
			    "window.print = function(){callback();};");	
	}
	
	public void clickPrintAndVerifyPrintDialog(WebElement element){
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		((JavascriptExecutor)driver).executeScript(
			    "var callback = arguments[1];" +
			    "window.print = function(){callback();};" +
			    "arguments[0].click();"
			    , element);
	}
	
	public void closePrintDialog() throws InterruptedException{
		Thread.sleep(5000);
		Robot r;
		try {
			r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		catch (Exception e){
			System.out.println("Không đóng được Dialog!");
		}
	}
	
//	public void printDialog(){
//		Robot r;
//		try {
//			r = new Robot();
//			r.keyPress(KeyEvent.VK_ENTER) ;
//	        r.keyRelease(KeyEvent.VK_ENTER) ;
//		} catch (AWTException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	
	public void waitForPageLoad() 
    {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
            	 return ((JavascriptExecutor)driver)
            			.executeScript("return document.readyState")
            			.equals("complete");            	
            }
        };
        wait.until(expectation);
    }
	
	public void waitForPageLoad(final By element) 
    {
		ExpectedCondition<Boolean> loading = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
            	 if(!driver.findElements(element).isEmpty())
					   return true;
				 else
					   return false;
            }
        };
        
        ExpectedCondition<Boolean> noloading = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
            	 if(driver.findElements(element).isEmpty())
					   return true;
				 else
					   return false;
            }
        };
        //wait.until(loading);
        wait.until(noloading);
    }
	
	public void checkStatusCode(int expected)
	{
		String urlCurrent = driver.getCurrentUrl().toString();
		Assert.assertEquals(expected, given().when().baseUri(urlCurrent).then().get().getStatusCode());
	}
	
	@SuppressWarnings("static-access")
	public Boolean checkElementExist(final By by, Boolean exist) 
	{
		ExpectedCondition<Boolean> isExist = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {				
				if(!driver.findElements(by).isEmpty())
					   return true;
				   else
					   return false;
			}
		};
		
		ExpectedCondition<Boolean> isNotExist = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {				
				if(driver.findElements(by).isEmpty())
					   return true;
				   else
					   return false;
			}
		};
		
		if(exist.equals(true))
			return wait.until(isExist);
		else
			return  wait.until(isNotExist);
		
	}
	
	public void clickElementWithIframe(WebElement iframe, WebElement element){
        driver.switchTo().frame(iframe);
        element.click();
        driver.switchTo().defaultContent();
	}
	
	public static String timeCurrent()
	{
		DateFormat dateFormat = new SimpleDateFormat("HHmmss-dd-MM-YYYY");
		Calendar cal = Calendar.getInstance();
		String currentDateTime = dateFormat.format(cal.getTime());
	    return currentDateTime;
	}
	
	public static String dateTime(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		Calendar cal = Calendar.getInstance();
		String dateTime = dateFormat.format(cal.getTime());
	    return dateTime;
	}
	
	public void capture(){
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenShot\\checkAddToCart"+ timeCurrent() +".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//KA
		public String getTextNode(WebElement element)
		{
		    String text = element.getText().trim();
		    List<WebElement> children = element.findElements(By.xpath("./*"));
		    for (WebElement child : children)
		    {
		        text = text.replaceFirst(child.getText(), "").trim();
		    }
		    return text;
		}
		public void assertTextNode(WebElement element, String text){
			waitElement(element);
			Assert.assertEquals(text, getTextNode(element));
		}
		
		//end KA

}
