package com.qc.misctrans;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qc.base.TestBase;
import com.qc.utilities.Utilities;

public class MiscTransactions extends TestBase{
	Utilities util;
	
	@FindBy(xpath="//a[text()='Misc Transactions']")
	WebElement Misc_Transactions;
	
	@FindBy(xpath="//a[text()='Misc Disbursement']")
	WebElement Misc_Disbursement;
	
	@FindBy(xpath="//li[@id='9881909224']//a")
	WebElement Insight_Withdrawal;
	
	@FindBy(name="ssn1")
	WebElement ss1_txtbox;
	
	@FindBy(name="ssn2")
	WebElement ss2_txtbox;
	
	@FindBy(name="ssn3")
	WebElement ss3_txtbox;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submit_btn;
	
	@FindBy(xpath="//input[@value='Go']")
	WebElement ggo_btn;
	
	@FindBy(id="crdNo")
	WebElement crdNo_tb;
	
	@FindBy(id="confcard")
	WebElement confcard_tb;
	
	@FindBy(name="personBean.amount")
	WebElement disbamnt_tb;
	
	@FindBy(name="password")
	WebElement password_tb;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement Submit_btn;
	
	@FindBy(xpath="//input[@value='OK']")
	WebElement OK_btn;
	
	@FindBy(name="personBean.identification_issued_on1")
	WebElement IDIssuedDate1;
	
	@FindBy(name="personBean.identification_issued_on2")
	WebElement IDIssuedDate2;
	
	@FindBy(name="personBean.identification_issued_on3")
	WebElement IDIssuedDate3;
	
	@FindBy(name="personBean.security_question_1_answer")
	WebElement SecurityAnswer_tb;
	
	public MiscTransactions(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void InsightWithdraw() throws Exception{
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/InsightTrans.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("InsightWithdrawTest");
		util=new Utilities();
		util.LogintoApplication();
		logger.log(Status.INFO, "Logged in to application");
		driver.switchTo().frame("topFrame");
		Misc_Transactions.click();
		logger.log(Status.INFO, "Clicked on Misc_Transactions button");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		Misc_Disbursement.click();
		logger.log(Status.INFO, "Selected Misc_Disbursement");
		Insight_Withdrawal.click();
		logger.log(Status.INFO, "Clicked on Insight_Withdrawal button");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='main']")));
		ss1_txtbox.sendKeys(prop.getProperty("ssn1"));
		logger.log(Status.INFO, "Entered ssn1");
		ss2_txtbox.sendKeys(prop.getProperty("ssn2"));
		logger.log(Status.INFO, "Entered ssn2");
		ss3_txtbox.sendKeys(prop.getProperty("ssn3"));
		logger.log(Status.INFO, "Entered ssn3");
		submit_btn.click();	
		logger.log(Status.INFO, "Clicked on submit_btn");
		ggo_btn.click();
		logger.log(Status.INFO, "Clicked on ggo_btn");
		IDIssuedDate1.sendKeys("01");
		IDIssuedDate2.sendKeys("01");
		IDIssuedDate3.sendKeys("2019");
		logger.log(Status.INFO, "Entered ID Issued Date");
		SecurityAnswer_tb.sendKeys("Hyth");
		logger.log(Status.INFO, "Security answer given");
		crdNo_tb.sendKeys(prop.getProperty("insight_card_no"));
		logger.log(Status.INFO, "Entered insight_card_no");
		confcard_tb.sendKeys(prop.getProperty("insight_card_no"));
		logger.log(Status.INFO, "Entered insight_card_no for confirmation");
		disbamnt_tb.sendKeys(prop.getProperty("insight_dib_amnt"));
		logger.log(Status.INFO, "Given insight_dib_amnt");
		password_tb.sendKeys("1234");
		logger.log(Status.INFO, "Entered password to complete the transaction");
		Submit_btn.click();
		logger.log(Status.INFO, "Clicekd on Submit button");
		OK_btn.click();
		logger.log(Status.INFO, "Clicked on OK button");
	}

}
