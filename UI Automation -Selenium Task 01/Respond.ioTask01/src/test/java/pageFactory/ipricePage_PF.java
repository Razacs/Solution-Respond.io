package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ipricePage_PF {
	
	@FindBy(xpath = "//title[contains(text(),'Save Money with iPrice – Malaysia’s #1 Price Compa')]")
	WebElement txt_TitleOfPage;
	
	@FindBy(xpath = "//h1[contains(text(),'Latest Laptops in Malaysia Price List for November')]")
	WebElement txt_LatestLaptops;
	
	@FindBy(xpath = "//a[normalize-space()='Dell']")
	WebElement btn_DellBrand;
	
	@FindBy(xpath = "//h1[contains(text(),'Dell Laptops in Malaysia Price List for November, ')]")
	WebElement txt_HeaderLaptopPage;
	
	@FindBy(xpath = "//a[@href='https://iprice.my/computing/laptops/']")
	WebElement Filter_Dellbtn;
	
	@FindBy(xpath = "//h3[normalize-space()='Dell Inspiron 15 3000']")
	WebElement DellLaptop_Header;
	
	
	@FindBy(xpath = "//h1[normalize-space()='Dresses Price List in Malaysia 2022']")
	WebElement txt_HeaderDressesPage;
	
	@FindBy(xpath = "//*[@id=\"sort-option\"]/div/a[3]/i")
	WebElement btn_Price;
	
	@FindBy(xpath = "//input[@id='term-desktop']")
	WebElement txt_Search;
	
	@FindBy(xpath = "//i[@class='sprite-icons cI i-search-orange-desk']")
	WebElement btn_search;
	
	@FindBy(xpath = "//h1[normalize-space()='iphone 14']")
	WebElement text_headeriphone;
	

	
	WebDriver driver;
	public ipricePage_PF(WebDriver driver) { //constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyPageHeader() {
		txt_LatestLaptops.isDisplayed();
		return true;
		
	}
	
	public void ClickDellButton() {
		btn_DellBrand.click();
	}
	
	public String verifyHeaderText() {
		String HeaderLaptopPageText = txt_HeaderLaptopPage.getText();
		return HeaderLaptopPageText;
	}
	
	public boolean verifyDellFilterButton() {
		Filter_Dellbtn.isDisplayed();
		return true;
		
	}
	
	public String verifyDellLaptopHeaderText() {
		String DellLaptopText_First = DellLaptop_Header.getText();
		return DellLaptopText_First;
	}
	
	public boolean verifyDressPageHeader() {
		txt_HeaderDressesPage.isDisplayed();
		return true;
		
	}
	
	public void ClickPriceButton() {
		btn_Price.click();
	}
	
	public void SearchIphoneItem(String item) {
		
		txt_Search.sendKeys(item);
	}
	
	public void SearchButton() {
		btn_search.click();
	}
	
	public String verifyIphonePageHeaderText() {
		String IphonePage_header = text_headeriphone.getText();
		return IphonePage_header;
	}
}
