package go.test.auto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Captcha {
	public static String timeCurrent()
	{
		DateFormat dateFormat = new SimpleDateFormat("HHmmssddMMYYYY");
		Calendar cal = Calendar.getInstance();
		String currentDateTime = dateFormat.format(cal.getTime());
	    return currentDateTime;
	}
	
	/*@Test
	public void registerNotToken()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		int dem = 0;
		//for(int i= 0; i<100; i++)
		//{
			driver.get("https://store-test-dev.bizwebvietnam.net/account/register");
			driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("ha");
			driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("luong");
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("haltb"+timeCurrent()+"@sapo.vn");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
			//driver.findElement(By.xpath("//button[@type='submit']")).click();
			dem = dem+1;
			System.out.println(dem);
		//}
	  }*/
	
	/*@Test
	public void hardloveee211() throws Exception {
		WebDriverManager.chromedriver().setup();		
		final WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		final WebDriverWait wait = new WebDriverWait(driver, 60);	
		driver.get("https://hardlovebee211.bizwebvietnam.net/account/register");
		String token;
		//for(int i= 0; i<10; i++)
		//{			
			//driver.navigate().refresh();
			ExpectedCondition <Boolean> example = new ExpectedCondition <Boolean>(){
				   public Boolean apply(WebDriver args){
				    if(!driver.findElement(By.xpath("//input[@id='Token']")).getAttribute("value").isEmpty())
				    {				    	
				    	return true;
					}
				    else
				    	return false;
				   }
				  };
			wait.until(example);
			Thread.sleep(3000);
			token = driver.findElement(By.xpath("//input[@id='Token']")).getAttribute("value");
			String url = "https://www.google.com/recaptcha/api/siteverify";
			RequestSpecification postRequest = RestAssured.given();
			postRequest.param("secret", "6Ldtu4IUAAAAANDS1mjTEUCDLNzl3vyvTcg0PHNB")
					   .param("response", token);
			Response responePost = postRequest.post(url);
			if (responePost.statusCode() == 200)
		    {                   
				//ResponseBody body = responePost.getBody();  
				JsonPath jsonPathEvaluator = responePost.jsonPath();
				System.out.println(jsonPathEvaluator.get("score"));
		    }
			
			driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("ha");
			driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("luong");
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("haltb"+timeCurrent()+"@sapo.vn");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
			//driver.findElement(By.xpath("//button[@type='summit']")).click();
		//}
		Thread.sleep(5000);		
	}*/
	
	/*@Test
	public void token()
	{
		String token = "03AO9ZY1CNUnGpO_NN_68ZnpI2sfgpy7-lpfacko0t8v5a-l2D3Xo2kXMLNzP8gCI-b52xWmyuEoxQ_e9ZhUo451WYYMtfh7ZETSXQgbz726OUyKo2_fBfqZVCF57YOhNGrHAgISxCCCe7AWiIMzfL3vkqe28dw07hcAY6_8kbXXhGqJbH4IOW_XVbnJQx-Iek5F7VlOnjfdDFclOElC8kgx2SLloXKQP778iM_bSk7amYX4KGwJDIl5suC4dI7kTWSJOMqyMCtdNtEkAytLPv9vT8tD0dLwojYm9liOv06uITyD6Lce8dLd6-aWO9SFZr2E3KlZj4xJM7tMLE-JfYi9hwA4B0XIDgjA";
		String Url = "https://www.google.com/recaptcha/api/siteverify";
		RequestSpecification postRequest = RestAssured.given();
		postRequest.param("secret", "6Ldtu4IUAAAAANDS1mjTEUCDLNzl3vyvTcg0PHNB")
				   .param("response", token);
		Response responePost = postRequest.post(Url);
		if (responePost.statusCode() == 200)
	    {                   
			//ResponseBody body = responePost.getBody();  
			JsonPath jsonPathEvaluator = responePost.jsonPath();
			System.out.println(jsonPathEvaluator.get("score"));
	    }
	}*/
	
	@Test
	public void storedev() throws Exception {
		WebDriverManager.chromedriver().setup();		
		final WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		final WebDriverWait wait = new WebDriverWait(driver, 60);	
		driver.get("https://hardlovebee211.bizwebvietnam.net/account/register");
		//driver.get("https://store-test-dev.bizwebvietnam.net/contact");
		//driver.get("https://hieuvv-test.herokuapp.com/");
		String token;
			ExpectedCondition <Boolean> example = new ExpectedCondition <Boolean>(){
				   public Boolean apply(WebDriver args){
				    if(!driver.findElement(By.xpath("//input[@id='Token']")).getAttribute("value").isEmpty())
				    {				    	
				    	return true;
					}
				    else
				    	return false;
				   }
				  };
			wait.until(example);
			Thread.sleep(3000);
			/*driver.findElement(By.xpath("//button[@id='test']")).click();
			Thread.sleep(5000);
			token = driver.findElement(By.xpath("//pre[@id='token']")).getText();*/
			token = driver.findElement(By.xpath("//input[@id='Token']")).getAttribute("value");
			String Url = "https://www.google.com/recaptcha/api/siteverify";
			RequestSpecification postRequest = RestAssured.given();
			/*postRequest.param("secret", "6LdwJoMUAAAAAN6Ne-pAaaK682wsT07EAoiMGRAK")
			   .param("response", token);*/
			postRequest.param("secret", "6Ldtu4IUAAAAANDS1mjTEUCDLNzl3vyvTcg0PHNB")
					   .param("response", token);
			Response responePost = postRequest.post(Url);
			if (responePost.statusCode() == 200)
		    {                   
				//ResponseBody body = responePost.getBody();  
				JsonPath jsonPathEvaluator = responePost.jsonPath();
				System.out.println(jsonPathEvaluator.<String>get("score"));
		    }
			driver.navigate().refresh();
			
			/*driver.findElement(By.xpath("//input[@name='contact[Name]']")).sendKeys("ha");
			driver.findElement(By.xpath("//input[@name='contact[email]']")).sendKeys("haltb"+timeCurrent()+"@sapo.vn");
			driver.findElement(By.xpath("//textarea[@name='contact[Body]']")).sendKeys("test");
			driver.findElement(By.xpath("//button[@type='submit']")).click();*/
			
			driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("ha");
			driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("luong");
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("haltb"+timeCurrent()+"@sapo.vn");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
	
		Thread.sleep(5000);		
	}
}
