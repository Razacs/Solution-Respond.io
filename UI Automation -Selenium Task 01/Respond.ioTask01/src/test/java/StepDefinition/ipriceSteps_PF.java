package StepDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.ipricePage_PF;

public class ipriceSteps_PF {
	
	WebDriver driver;
	
	ipricePage_PF homePage_PF; 
	
	//attendanywherePage attndPage; 
	
	@Given("browser is open")
	public void browser_is_open() {
		
		System.out.println("===I am inside iPriceSteps_PF File ====");
	    
		String ProjectPath = System.getProperty("user.dir");
		System.out.println("Project Path is"+ ProjectPath);
		System.setProperty("webdriver.chrome.driver", ProjectPath+"\\src\\main\\resources\\driver\\chromedriver.exe");
		
		//Create prefs map to store all preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();

		//Put this into prefs map to switch off browser notification
		prefs.put("profile.default_content_setting_values.notifications", 2);

		//Create chrome options to set this prefs
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);	
		
		System.out.println("Browser Open");

		
	}

	@And("user is on iprice home page and validate it")
	public void user_is_on_iprice_page() throws InterruptedException {
		homePage_PF = new ipricePage_PF(driver);
		
	   
		driver.navigate().to("https://iprice.my/");
		System.out.println("iprice Home Page");
//		Thread.sleep(5000);
		
		String expectedURL="https://iprice.my/";
		String redirectURL=driver.getCurrentUrl();
		Assert.assertEquals(redirectURL,expectedURL);
		System.out.println("Successfull Verified");
	}
	
	
	@When("user navigate to laptops page and validate it")
	public void user_navigate_to_laptops_page() {
	   
		driver.navigate().to("https://iprice.my/computing/laptops/");
		System.out.println("Latest Laptops");
		
		
		
		//For Page Header Assertion
		boolean pageheaderValue= homePage_PF.verifyPageHeader();
		Assert.assertTrue(pageheaderValue);	
		System.out.println("Verified Page Header is Correct");
		
	}
	
	@Then("user select the brand value to be Dell")
	public void user_validate_result() throws InterruptedException {
		homePage_PF.ClickDellButton();
		Thread.sleep(2000);
		
	}

	@Then("validate result based on selected filter")
	public void user_select_Dell_Brand() throws InterruptedException {
		
		
		//Assert the Heading
		String ActualHeader= "Dell Laptops in Malaysia Price List for November, 2022";
		String ExpectedHeader= homePage_PF.verifyHeaderText();
		Assert.assertEquals(ActualHeader, ExpectedHeader);
				
		System.out.println("Heade Text is Verified");	
		
		//Verify Dell Filter is display and Selected
		boolean FilterValue= homePage_PF.verifyDellFilterButton();
		Assert.assertTrue(FilterValue);	
		System.out.println("Verified Page Header is Correct");
		
		//Scrolling to the Element and Validate
		WebElement element = driver.findElement(By.xpath("(//div[@class='uZ cN qt kR vG ei kF'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
		
		//Verify Items display based on Dell Selected filters
		String ActualHeaderOfDellItem= "Dell Inspiron 15 3000 ";
		String ExpectedHeaderOfDelleItem= homePage_PF.verifyDellLaptopHeaderText();
		Assert.assertEquals(ActualHeader, ExpectedHeader);
		
	}
	
	
	@Then("user navigate to dresses page")
	public void user_navigate_to_dress_page() {
		
		driver.navigate().to("https://iprice.my/clothing/dresses/");
		System.out.println("Verified Dress Page Header is Correct");
	}
	
	@And("user click on Price sorting until the indicator indicates")
	public void user_click_Dress_Price() {
		
		homePage_PF.ClickPriceButton(); //Click on Sorting Price button
	
		homePage_PF.ClickPriceButton(); //Click again on Sorting Price button
		
		System.out.println("Price Button Click");
	}
	
	@Then("Validate that the results are sorted in descending order of Price")
	public void validate_result_Sorted() {
		
		//Verify user are able to filter desc option and item display
		String expectedURL="https://iprice.my/clothing/dresses/?sort=price.net_desc";
		String redirectURL=driver.getCurrentUrl();
		Assert.assertEquals(redirectURL,expectedURL);
		System.out.println("Successfull Verified");
	}
	

	@Then("user navigate to home page")
	public void navigate_home_page() {
		
		driver.navigate().to("https://iprice.my/");
		
	}
	
	@And("^user Search for (.*)$")
	public void user_search_item(String item) {
		
		homePage_PF.SearchIphoneItem(item);
		
	}
	
	@And("user click on Search button")
	public void Click_Search_button() {
		
		homePage_PF.SearchButton();
		
	}
	
	@Then("Validate that the result matches the search criteria")
	public void Search_result() throws InterruptedException {
		
		//Verify Items display based on Iphone 14 Search
		String ActualHeaderIphoneSearc= "iphone 14";
		String ExpectedHeaderIphoneSearch= homePage_PF.verifyIphonePageHeaderText();
		Assert.assertEquals(ActualHeaderIphoneSearc, ExpectedHeaderIphoneSearch);
		
		//Verify URL has Search paramter
		String expectedURL="https://iprice.my/search/?term=iphone+14";
		String redirectURL=driver.getCurrentUrl();
		Assert.assertEquals(redirectURL,expectedURL);
		System.out.println("Successfull Verified URL Searched");
		
		
		//Scrolling to the Element and Validate
		WebElement element = driver.findElement(By.xpath("(//div[@class='uZ cN qt kR vG ei kF'])[11]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
		
	}



}
