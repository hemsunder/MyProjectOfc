package com.qc.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qc.PDL.PDLALLTransactions;
import com.qc.base.TestBase;


public class Utilities extends TestBase {
	public static WebDriver driver2;
	//String cardtpe=TestData.getCellData("CollateralTypes", "LoanAmt", 5);
	String cardtpe=prop.getProperty("cardtype");
	String cardnum=TestData.getCellData("CollateralTypes", "CheckingAcntNum", 5);
	String vehtype=TestData.getCellData("CollateralTypes", "vehicleType", 4);
	//String vin=TestData.getCellData("CollateralTypes", "VINNum", 2);
	String vin=prop.getProperty("VIN");
	String licensenum=TestData.getCellData("CollateralTypes", "Licensenum", 2);
	String extclr=TestData.getCellData("CollateralTypes", "exteriorclr", 2);
	String vehigr=TestData.getCellData("CollateralTypes", "vehiclegrade", 2);
	String insurancetype=TestData.getCellData("CollateralTypes", "InsuranceCoverage", 4);
	
	@FindBy(xpath="//h2")
	WebElement loginlogo;
	
	@FindBy(name="loginRequestBean.userId")
	WebElement username;
	
	@FindBy(name="loginRequestBean.password")
	WebElement password;
	
	@FindBy(name="loginRequestBean.locNbr")
	WebElement storeid;
	
	@FindBy(name="login")
	WebElement loginbtn;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submitt;
	
	@FindBy(xpath="//a[text()='Loan Transactions']")
	WebElement loantransactions;
	
	@FindBy(xpath="//a[text()='New Loan']")
	WebElement newloan;
	
	@FindBy(name="requestBean.cusNbr")
	WebElement customernum;
	
	@FindBy(name="ssn1")
	WebElement ss1_txtbox;
	
	@FindBy(name="ssn2")
	WebElement ss2_txtbox;
	
	@FindBy(name="ssn3")
	WebElement ss3_txtbox;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submit_btn_in_ApplicantSearch_page;
	
	@FindBy(name="button")
	WebElement gobtn_in_searchpage;
	
	@FindBy(xpath="//a[text()='Transactions']")
	WebElement transactions;
	
	@FindBy(xpath="//td[text()='Payday Loans']/following::input[@value='Go']")
	WebElement pdl_GoBtn;
	
	@FindBy(name="transactionList")
	WebElement Transaction_Selection_dd;
	
	@FindBy(id="go_Button")
	WebElement go_Button;
	
	@FindBy(name="cardNmbr")
	WebElement selectcard_dd;
	
	@FindBy(name="cardType")
	WebElement cardtype_dd;
	
	@FindBy(id="ccnumber")
	WebElement cardnbr_txtbox;
	
	@FindBy(name="expmonth")
	WebElement expmnth_dd;
	
	@FindBy(name="expyear")
	WebElement expyear_dd;
	
	@FindBy(id="cvvnumber")
	WebElement cvv_txtbox;
	
	@FindBy(id="ccname")
	WebElement ccname_txtbox;
	
	@FindBy(id="vehicleType_dd")
	WebElement vehicletype_dd;
	
	@FindBy(id="vinDD")
	WebElement vindd;
	
	@FindBy(name="newVinNbr")
	WebElement newVinnbr_txtbox;
	
	@FindBy(name="miles")
	WebElement miles_txtbox;
	
	@FindBy(name="bbHit_Button")
	WebElement bbHit_button;
	
	/*@FindBy(xpath="//table[@id='tableWid11']//td//b//input")
	WebElement Term1;*/
	
	@FindBy(xpath="//table[@id='tableWid14']//td//b//input")
	WebElement Term1;
		
	@FindBy(name="requestBean.titleNumber")
	WebElement titlenum_txtbox;
	
	@FindBy(xpath="//input[@name='button1']")
	WebElement update_btn1;
	
	@FindBy(name="requestBean.licensePltNbr")
	WebElement licenseplatenum_txtbox;
	
	@FindBy(name="requestBean.extClr")
	WebElement exteriorclr_dd;
	
	@FindBy(name="requestBean.vehicleGrade")
	WebElement vehiclegrade_dd;
	
	@FindBy(name="requestBean.coverageType")
	WebElement insurance_dd;
	
	@FindBy(name="button2")
	WebElement update_btn2;
	
	@FindBy(name="process")
	WebElement processloan_btn;
		
	public Utilities(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLoginLogo(){
		return loginlogo.isDisplayed();
	}
	
	public String verifyLoginPageTitle(){
		String title=driver.getTitle();
		System.out.println("The title of the page is "+title);
		return title;
	}
	
	public void verifyLoginPage(String un, String pwd, String stid){
		
		username.sendKeys(un);
		System.out.println("6498"+un);
		password.sendKeys(pwd);
		System.out.println("8498"+pwd);
		storeid.sendKeys(stid);
		System.out.println("5490"+stid);
		loginbtn.click();
	}
	
	public void LogintoApplication(){
		
		String url222=prop.getProperty("url");
		System.out.println(url222);
		driver.get(prop.getProperty("url"));
		System.out.println("Title of the page before login ==> "+driver.getTitle());
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		storeid.sendKeys(prop.getProperty("storeid"));
		loginbtn.click();
		System.out.println("Title of the page after login ==> "+driver.getTitle());
	}
	
	@FindBy(xpath="//a[text()='Employee']")
	WebElement Employee_btn;
	
	@FindBy(xpath="//a[text()='Encryption Key']")
	WebElement Encryption_Key;
	
	@FindBy(xpath="//a[text()='Encryption']")
	WebElement Encryption;
		
	public void get_encryptionkey(){
		driver2=new InternetExplorerDriver();
		driver2.get(prop.getProperty("adminurl"));
		driver2.findElement(By.name("loginRequestBean.userId")).sendKeys(prop.getProperty("username"));
		driver2.findElement(By.name("loginRequestBean.password")).sendKeys(prop.getProperty("password"));
		driver2.findElement(By.name("login")).click();
		driver2.switchTo().frame("topFrame");
		driver2.findElement(By.xpath("//a[text()='Employee']")).click();
		driver2.switchTo().defaultContent();
		driver2.switchTo().frame("mainFrame");
		/*Actions act=new Actions(driver2);
		act.moveToElement(Encryption_Key).build().perform();*/
		driver2.findElement(By.xpath("//a[text()='Encryption Key']")).click();
		driver2.findElement(By.xpath("//a[text()='Encryption']")).click();
		driver2.switchTo().frame("bdyLoad");
			
	}
	
	public void newloaninitialization(){
		
		driver.switchTo().frame("topFrame");
		loantransactions.click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("mainFrame");
		newloan.click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='main']")));
		//customernum.sendKeys(prop.getProperty("bo_code"));
		ss1_txtbox.sendKeys(prop.getProperty("ssn1"));
		ss2_txtbox.sendKeys(prop.getProperty("ssn2"));
		ss3_txtbox.sendKeys(prop.getProperty("ssn3"));
		submit_btn_in_ApplicantSearch_page.click();
		gobtn_in_searchpage.click();
	}
	
	public void transactionsinitialization(){
		
		driver.switchTo().frame("topFrame");
		loantransactions.click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("mainFrame");
		transactions.click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='main']")));
		//customernum.sendKeys(prop.getProperty("bo_code"));
		ss1_txtbox.sendKeys(prop.getProperty("ssn1"));
		ss2_txtbox.sendKeys(prop.getProperty("ssn2"));
		ss3_txtbox.sendKeys(prop.getProperty("ssn3"));
		submit_btn_in_ApplicantSearch_page.click();	
		gobtn_in_searchpage.click();
	}
	
	
	
	public void pdl_transaction_dd_selection(String option){
		pdl_GoBtn.click();
		Select transactiondd=new Select(Transaction_Selection_dd);
		transactiondd.selectByVisibleText(option);
		go_Button.click();
	}
	
	@FindBy(id="repayIFrame")
	WebElement newframe;
	
	@FindBy(name="cardholder_name")
	WebElement holdername;
	
	@FindBy(name="card_number")
	WebElement card_number;
	
	@FindBy(name="card_cvc")
	WebElement card_cvc;
	
	@FindBy(name="card_expiration_month")
	WebElement card_expiration_month;
	
	@FindBy(name="card_expiration_year")
	WebElement card_expiration_year;
	
	@FindBy(name="address_zip")
	WebElement address_zip;
	
	@FindBy(xpath="//div//button[text()='Save Card']")
	WebElement SaveCard;
	
	@FindBy(xpath="//input[@name='Finish']")
	WebElement Finish;
	
	@FindBy(xpath="//iframe[@id='bdyLoad']")
	WebElement frame;
	
	public void Updateddebitcardfilling() throws Exception{
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/Updateddebitcardfilling.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("Updateddebitcardfilling");
		
		Thread.sleep(3000);
		Select selcard=new Select(selectcard_dd);
		logger.log(Status.INFO, "Clicked on selectcard_dd");
		selcard.selectByVisibleText("NEW CARD");
		logger.log(Status.INFO, "Selected New Card");
		driver.switchTo().frame(newframe);
		logger.log(Status.INFO, "Switched to newframe");
		Thread.sleep(5000);
		holdername.sendKeys("Customername");
		logger.log(Status.INFO, "Entered Customername");
		card_number.sendKeys(prop.getProperty("cardnumber"));
		logger.log(Status.INFO, "Entered cardnumber");
		Select expmnth=new Select(card_expiration_month);
		logger.log(Status.INFO, "Clicked on card_expiration_month dd");
		expmnth.selectByVisibleText("12");
		logger.log(Status.INFO, "Entered expiration month");
		Select expyear=new Select(card_expiration_year);
		logger.log(Status.INFO, "Clicked on card_expiration_year");
		expyear.selectByVisibleText("22");
		logger.log(Status.INFO, "Entered expire year");
		card_cvc.sendKeys("166");
		logger.log(Status.INFO, "Entered CVV number");
		address_zip.sendKeys("12346");
		logger.log(Status.INFO, "Entered Zipcode");
		SaveCard.click();
		logger.log(Status.INFO, "Clicked on Save Card");
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame(frame);
		Finish.click();
		logger.log(Status.INFO, "Clicked on Finish_btn");
		extent.flush();
		Thread.sleep(5000);
	}
	
	
	@FindBy(name="crditNbrFirst")
	WebElement selectcarddd;
	
	public void Updateddebitcardfillingforpayments() throws Exception{
		
		/*Thread.sleep(3000);
		Select selcard=new Select(selectcarddd);
		selcard.selectByVisibleText("NEW CARD");*/
		driver.switchTo().frame(newframe);
		Thread.sleep(5000);
		holdername.sendKeys("Customername");
		card_number.sendKeys(prop.getProperty("cardnumber"));
		Select expmnth=new Select(card_expiration_month);
		expmnth.selectByVisibleText("12");
		Select expyear=new Select(card_expiration_year);
		expyear.selectByVisibleText("25");
		card_cvc.sendKeys("999");
		address_zip.sendKeys("12346");
		SaveCard.click();
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame(frame);
		Finish.click();
		Thread.sleep(5000);
	}
	
	@FindBy(xpath="//select[@name='cardNmbr']")
	WebElement selectcardd;
	
	public void debitcardfilling() throws Exception{
		
		Select selcard=new Select(selectcardd);
		selcard.selectByVisibleText("NEW CARD");
		cardnbr_txtbox.sendKeys(cardnum);
		if(cardtpe.equals("Visa")){
			Select card=new Select(cardtype_dd);
			card.selectByVisibleText(cardtpe);
			cardnbr_txtbox.sendKeys(cardnum);
			
			Select expmnth=new Select(expmnth_dd);
			expmnth.selectByVisibleText("December");
			
			Select expyr=new Select(expyear_dd);
			expyr.selectByValue("30");
			cvv_txtbox.sendKeys("123");
			ccname_txtbox.sendKeys("James");
		}
		
		else if (cardtpe.equals("MasterCard")){
			Select card=new Select(cardtype_dd);
			card.selectByVisibleText(cardtpe);
			cardnbr_txtbox.sendKeys(cardnum);
			
			Select expmnth=new Select(expmnth_dd);
			expmnth.selectByVisibleText("December");
			
			Select expyr=new Select(expyear_dd);
			expyr.selectByVisibleText("2030");
			
			cvv_txtbox.sendKeys("321");
			ccname_txtbox.sendKeys("camaroon");
		}
	}
	
	public void invisible(WebDriver driver, WebElement element, int timeout){
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).
		until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void clickon(WebDriver driver, WebElement element, int timeout){
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).
		until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void elementvisible(WebDriver driver, WebElement element, int timeout){
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).
		until(ExpectedConditions.visibilityOf(element));
	}
	
	public void tlploanprepage1(){
		
		if(vehtype.equals("Auto")){
			Select vehtpe=new Select(vehicletype_dd);
			vehtpe.selectByVisibleText(vehtype);
			Select vin_dd=new Select(vindd);
			vin_dd.selectByVisibleText("New");
			newVinnbr_txtbox.sendKeys(vin);
			miles_txtbox.sendKeys("300");
			bbHit_button.click();
			clickon(driver, Term1, 60);
		}
	}
	
	public void tlploanprepage2(){
		
		titlenum_txtbox.sendKeys("1234");
		update_btn1.click();
		clickon(driver, licenseplatenum_txtbox, 30);
		licenseplatenum_txtbox.sendKeys(licensenum);
		Select extrclr=new Select(exteriorclr_dd);
		extrclr.selectByVisibleText(extclr);
		Select vehgr=new Select(vehiclegrade_dd);
		vehgr.selectByVisibleText(vehigr);
		Select insurdd=new Select(insurance_dd);
		insurdd.selectByVisibleText(insurancetype);
		update_btn2.click();
		clickon(driver, processloan_btn, 30);
		processloan_btn.click();
	}
	
	public void debitcardfillingforpayments() throws Exception{
		Thread.sleep(3000);
		Select selcard=new Select(selectcard_dd);
		selcard.selectByVisibleText("NEW CARD");
		driver.switchTo().frame(newframe);
		Thread.sleep(5000);
		holdername.sendKeys("Customername");
		card_number.sendKeys(prop.getProperty("cardnumber"));
		card_cvc.sendKeys("999");
		Select expmnth=new Select(card_expiration_month);
		expmnth.selectByVisibleText("12");
		Select expyear=new Select(card_expiration_year);
		expyear.selectByVisibleText("25");
		address_zip.sendKeys("12346");
		SaveCard.click();
		Thread.sleep(9000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame(frame);
		Finish.click();
		Thread.sleep(5000);
		
			/*cardnbr_txtbox.sendKeys(cardnum);
			Select card=new Select(cardtype_dd);
			card.selectByVisibleText("Visa");
			Select expmnth=new Select(expmnth_dd);
			expmnth.selectByVisibleText("April");
			Select expyr=new Select(expyear_dd);
			expyr.selectByValue("30");
			cvv_txtbox.sendKeys("123");
			ccname_txtbox.sendKeys("James");*/
		}
	public void scrollintoview(WebDriver driver, WebElement element){
		JavascriptExecutor je=((JavascriptExecutor)driver);
		je.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	/*public void Reports(String classname){
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/NewPDLByACHReport.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest(classname);
	}*/

}
