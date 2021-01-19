package go.test.auto;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import go.test.actions.Base;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(	
				features = {
						//"src/test/resources/Features"
						"src/test/resources/Features/AALoginSapo.feature",
						"src/test/resources/Features/ABConnectPage.feature",
						"src/test/resources/Features/ACMessengerAndAutoReply.feature",
						"src/test/resources/Features/ADCommentAutoReply.feature",
						"src/test/resources/Features/AEOrders.feature",
						"src/test/resources/Features/AFAutoOrderLivestream.feature"
						},
					format = {"pretty", "json:target/cucumber.json"},
					glue = "go.test.stepdefine"
				)

public class RunTest extends Base {
	@BeforeClass
	public static void startUp(){
		System.out.println("Opening Chrome Browser ...");
		String headlessProp = System.getProperty("headless");
		ChromeDriverManager.getInstance(ChromeDriver.class).setup();
		ChromeOptions options = new ChromeOptions();
		if (headlessProp != null) {
			options.addArguments("--headless --window-size=1366,768");
		}
		options.addArguments("--disable-notifications");
		options.addArguments("start-maximized");
		options.addArguments("--disable-features=VizDisplayCompositor");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public static void tearDown() throws InterruptedException {
		Thread.sleep(3000);
	//	driver.quit();
	}
}

