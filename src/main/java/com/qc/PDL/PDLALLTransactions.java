package com.qc.PDL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qc.base.TestBase;
import com.qc.utilities.Utilities;

public class PDLALLTransactions extends TestBase{
	
	public static String loan_amount;
	public static String payment_amt=prop.getProperty("payment_amnt");
	public static String payment_type=prop.getProperty("paymnt_type");
	public static String cardtype=prop.getProperty("cardtypeee");
	Utilities util;
	
	@FindBy(xpath="//td[contains(text(),'Payday Loan')]//parent::tr//td//input")
	WebElement MO_PDL;
	
	@FindBy(xpath="//input[@value='New Loan']")
	WebElement NewLoan_btn;
	
	@FindBy(name="advanceRequestBean.collateralTypeId")
	WebElement collateralType_dd;
	
	@FindBy(name="advanceRequestBean.chkgAcctNbr")
	WebElement chkgAcctNbr_tb;
	
	@FindBy(name="advanceRequestBean.disbursementType")
	WebElement disbursementType_dd;
	
	@FindBy(name="advanceRequestBean.courtesyCallFlag")
	WebElement courtesyCallFlag_dd;
	
	@FindBy(name="advanceRequestBean.loggedUserPassword")
	WebElement Password_tb;
	
	@FindBy(xpath="//input[@value='Finish Loan']")
	WebElement FinishLoan_btn;
	
	@FindBy(xpath="//input[@value='Yes']")
	WebElement yes_btn;
	
	@FindBy(xpath="//input[@value=' Ok ']")
	WebElement ok_btn;
	
	@FindBy(name="transactionDataBean.cardIssuerId")
	WebElement card_type;
	
	@FindBy(id="ccnumber")
	WebElement ccnumber;
	
	@FindBy(name="expmonth")
	WebElement expmonth;
	
	@FindBy(name="expyear")
	WebElement expyear;
	
	@FindBy(id="cvvnumber")
	WebElement cvvnumber;
	
	@FindBy(name="ccname")
	WebElement ccname;
	
	@FindBy(xpath="//td[text()='Payday Loans']//parent::tr//following-sibling::tr//td//input[@value='Go']")
	WebElement Go_Btn;
	
	
	public PDLALLTransactions(){
		PageFactory.initElements(driver, this);
	}
	
	public void NewPDLByACH(String loanamount, String Collateraltype, String disbtytpe) throws Exception{
		
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/NewPDLByACHReport.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("PDLALLTransactions");
		util=new Utilities();
		util.LogintoApplication();
		util.newloaninitialization();
		MO_PDL.click();
		logger.log(Status.INFO, "Selected MO_PDL Product");
		NewLoan_btn.click();
		Thread.sleep(8000);
		logger.log(Status.INFO, "Clicked on NewLoan button");
		Select collateralTypedd = new Select(collateralType_dd);
		logger.log(Status.INFO, "Clicked on collateralType_dd");
		collateralTypedd.selectByVisibleText(Collateraltype);
		logger.log(Status.INFO, "Selected ACH collateral");
		String chkgAcctNbr = prop.getProperty("accountNbr");
		String acntnbr = chkgAcctNbr.substring(3);
		chkgAcctNbr_tb.sendKeys(acntnbr);
		logger.log(Status.INFO, "Entered checking account number in chkgAcctNbr_tb");
		Select disbursementTypedd = new Select(disbursementType_dd);
		logger.log(Status.INFO, "Clicked on disbursementType_dd");
		disbursementTypedd.selectByVisibleText(disbtytpe);
		logger.log(Status.INFO, "Selected Cash as disbursement");
		Select courtesyCallFlagdd = new Select(courtesyCallFlag_dd);
		logger.log(Status.INFO, "Clicked on courtesyCallFlag_dd");
		courtesyCallFlagdd.selectByVisibleText("No");
		logger.log(Status.INFO, "Selected NO Option");
		Password_tb.sendKeys("1234");
		logger.log(Status.INFO, "Entered 1234 in Password_tb");
		FinishLoan_btn.click();
		logger.log(Status.INFO, "Clicked on FinishLoan_btn");
		Alert alt = driver.switchTo().alert();
		alt.accept();
		logger.log(Status.INFO, "Accepted Alert");
		yes_btn.click();
		logger.log(Status.INFO, "Clicked on yes_btn");
		ok_btn.click();
		logger.log(Status.INFO, "Clicked on ok_btn");
		extent.flush();
	}
	
	
	@FindBy(name="requestBean.noOfChecks")
	WebElement noOfChecks_dd;
	
	@FindBy(name="chkNbr0")
	WebElement checknbr_tb;
	
	public void NewPDLByCheck(String loanamount){
		util=new Utilities();
		util.LogintoApplication();
		util.newloaninitialization();
		MO_PDL.click();
		NewLoan_btn.click();
		Select collateralTypedd = new Select(collateralType_dd);
		collateralTypedd.selectByVisibleText("CHECK");
		String chkgAcctNbr = prop.getProperty("accountNbr");
		String acntnbr = chkgAcctNbr.substring(3);
		chkgAcctNbr_tb.sendKeys(acntnbr);
		Select disbursementTypedd = new Select(disbursementType_dd);
		disbursementTypedd.selectByVisibleText("Cash");
		Select courtesyCallFlagdd = new Select(courtesyCallFlag_dd);
		courtesyCallFlagdd.selectByVisibleText("No");
		Select noOfChecksdd = new Select(noOfChecks_dd);
		noOfChecksdd.selectByValue("1");
		checknbr_tb.sendKeys(prop.getProperty("checknbr"));
		Password_tb.sendKeys("1234");
		FinishLoan_btn.click();
		Alert alt = driver.switchTo().alert();
		alt.accept();
		yes_btn.click();
		ok_btn.click();
		
	}
	
	@FindBy(xpath="//input[@value='Add Card']")
	WebElement AddCard_btn;
	
	@FindBy(name="crditNbrFirst")
	WebElement selectcarddd;
	
	@FindBy(name="cardNmbr")
	WebElement selectcarddddd;
	
	@FindBy(xpath="//input[@value='Skip']")
	WebElement skip_btn;
	
	public void NewPDLByDC(String loanamount) throws Exception{
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/RegressionTesting.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("NewPDLByDCTest");
		util=new Utilities();
		util.LogintoApplication();
		logger.log(Status.INFO, "Logged into application");
		util.newloaninitialization();
		logger.log(Status.INFO, "NewPDLByDC transaction has initiated");
		MO_PDL.click();
		logger.log(Status.INFO, "Selected MO PDL Product");
		NewLoan_btn.click();
		logger.log(Status.INFO, "Clicked on New Loan button");
		Thread.sleep(10000);
		Select collateralTypedd = new Select(collateralType_dd);
		logger.log(Status.INFO, "Clicked on collateral type drop down button");
		collateralTypedd.selectByVisibleText("DEBIT CARD");
		logger.log(Status.INFO, "Selected Debit card as collateral type");
		Select selcard=new Select(selectcarddddd);
		List<WebElement> list=selcard.getOptions();
		int count=list.size();
		for(int i=0;i<count;i++){
			String name=list.get(i).getText();
			System.out.println(name);
			if(name.equalsIgnoreCase("NEW CARD")){
				list.get(i).click();
				util.Updateddebitcardfilling();	
			}
			
			else if(name.contains(cardtype)){
				list.get(2).click();
				Thread.sleep(3000);
				skip_btn.click();
				break;
			}
		}
		
		logger.log(Status.INFO, "Filled card details successfully");
		Select disbursementTypedd = new Select(disbursementType_dd);
		logger.log(Status.INFO, "Clicked on disbursementType_dd");
		disbursementTypedd.selectByVisibleText("Cash");
		logger.log(Status.INFO, "Selected cash");
		Select courtesyCallFlagdd = new Select(courtesyCallFlag_dd);
		logger.log(Status.INFO, "Clicked on courtesyCallFlag_dd");
		courtesyCallFlagdd.selectByVisibleText("No");
		logger.log(Status.INFO, "Selected Cash option");
		Password_tb.sendKeys("1234");
		logger.log(Status.INFO, "Entered Password");
		FinishLoan_btn.click();
		logger.log(Status.INFO, "Clicked on FinishLoan_btn");
		Alert alt = driver.switchTo().alert();
		logger.log(Status.INFO, "Switched to alert");
		alt.accept();
		logger.log(Status.INFO, "Accepted alert");
		yes_btn.click();
		logger.log(Status.INFO, "Clicked on yes_btn");
		ok_btn.click();
		logger.log(Status.INFO, "Clicked on ok_btn");
		extent.flush();
	}
	
	@FindBy(xpath="//td[text()='Payday Loans']//parent::tr//following-sibling::tr[2]//td//input[@value='Go']")
	WebElement go_btn;
	
	@FindBy(xpath="//span[text()='showMore>>']")
	WebElement showMore_btn;
	
	@FindBy(name="transactionList")
	WebElement Transactions_dd;
	
	@FindBy(id="go_Button")
	WebElement go_Button;
	
	@FindBy(name="transactionDataBean.tenderTypeFirst")
	WebElement tenderTypeFirst;
	
	@FindBy(name="transactionDataBean.tenderAmtFirst")
	WebElement tenderamnt;
	
	@FindBy(name="advanceRequestBean.advanceAmt")
	WebElement advanceAmt;
	
	@FindBy(name="transactionDataBean.password")
	WebElement pwd_tb;
	
	@FindBy(xpath="//input[@value='Finish Void Advance']")
	WebElement FinishVoidAdvance;
	
	@FindBy(xpath="//input[@value='Finish Rescind']")
	WebElement FinishRescind;
	
	@FindBy(xpath="//tr[@class='level2']//td[1]")
	WebElement loan_balance;
	
	public void PDLVoid(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		go_btn.click();
		Select Transactionsdd = new Select(Transactions_dd);
		Transactionsdd.selectByVisibleText("Void");
		go_Button.click();
		Select tenderTypeFirstdd = new Select(tenderTypeFirst);
		tenderTypeFirstdd.selectByVisibleText("Cash");
		String balance=loan_balance.getText();
		tenderamnt.sendKeys(balance);
		pwd_tb.sendKeys("1234");
		FinishVoidAdvance.click();
		try {
			Alert alt = driver.switchTo().alert();
			alt.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		yes_btn.click();		
	}
	
	public void RescindPDL(){
		
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		go_btn.click();
		Select Transactionsdd = new Select(Transactions_dd);
		Transactionsdd.selectByVisibleText("Rescind");
		go_Button.click();
		Select tenderTypeFirstdd = new Select(tenderTypeFirst);
		tenderTypeFirstdd.selectByVisibleText("Cash");
		String balance=loan_balance.getText();
		tenderamnt.sendKeys(balance);
		pwd_tb.sendKeys("1234");
		FinishRescind.click();
		try {
			Alert alt = driver.switchTo().alert();
			alt.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		yes_btn.click();	
		
	}
	
	
	@FindBy(name="transactionDataBean.paymentAmt")
	WebElement paymentAmt_tb;
	
	@FindBy(name="transactionDataBean.tenderTypeFirst")
	WebElement tenderType_dd;	
	
	@FindBy(name="transactionDataBean.tenderAmtFirst")
	WebElement tenderAmt_tb;
	
	@FindBy(xpath="//input[@value='Finish Partial Payment']")
	WebElement Finish_Partial_Payment;
	
	@FindBy(name="transactionDataBean.ccmoNbrFirst")
	WebElement cc_nbr;
	
	@FindBy(name="transactionDataBean.ccmoNbrFirst")
	WebElement mo_nbr;	
	
	public void PartialPayment(String payment) throws Exception{
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/RegressionTesting.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("Partial Payment Test");
		util=new Utilities();
		util.LogintoApplication();
		logger.log(Status.INFO, "Logged in to application");
		util.transactionsinitialization();
		logger.log(Status.INFO, "Opened customer account");
		Go_Btn.click();
		logger.log(Status.INFO, "Clicekd on GO button");
		Select Transactionsdd = new Select(Transactions_dd);
		logger.log(Status.INFO, "Clicekd on Transactions_dd");
		Transactionsdd.selectByVisibleText("Partial Payment");
		logger.log(Status.INFO, "Selected Partial payment");
		go_Button.click();
		logger.log(Status.INFO, "Clicekd on go_Button");
		Thread.sleep(10000);
		paymentAmt_tb.sendKeys(payment_amt);
		logger.log(Status.INFO, "Entered payment amount in payment text box");
		Select tenderTypedd = new Select(tenderType_dd);
		logger.log(Status.INFO, "Selected tenderType_dd");
		tenderTypedd.selectByVisibleText(payment_type);
		logger.log(Status.INFO, "Selected payment type");
		if(payment_type.equals("Cash"))
		{
			tenderAmt_tb.sendKeys(payment_amt);
			pwd_tb.sendKeys("1234");
			Finish_Partial_Payment.click();
			try {
				Alert alt = driver.switchTo().alert();
				alt.accept();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			yes_btn.click();
		}
		
		else if(payment_type.equals("Cashiers Check"))
		{
			cc_nbr.sendKeys(prop.getProperty("ccmo_num"));
			tenderAmt_tb.sendKeys(payment_amt);
			pwd_tb.sendKeys("1234");
			Finish_Partial_Payment.click();		
			yes_btn.click();
		}
		
		else if(payment_type.equals("Money Order"))
		{
			mo_nbr.sendKeys(prop.getProperty("ccmo_num"));
			tenderAmt_tb.sendKeys(payment_amt);
			pwd_tb.sendKeys("1234");
			Finish_Partial_Payment.click();		
			yes_btn.click();
		}
		else {
			tenderAmt_tb.sendKeys(payment_amt);
			logger.log(Status.INFO, "Entered payment_amt");
			Select selcard=new Select(selectcarddd);
			List<WebElement> list=selcard.getOptions();
			int count=list.size();
			for(int i=0;i<count;i++){
				String name=list.get(i).getText();
				System.out.println(name);
				if(name.equalsIgnoreCase(cardtype)){
					list.get(i).click();
					Thread.sleep(10000);
					util.Updateddebitcardfillingforpayments();	
					logger.log(Status.INFO, "Filled card details successfully");
					Thread.sleep(5000);
					pwd_tb.sendKeys("1234");
					logger.log(Status.INFO, "Entered password");
					Finish_Partial_Payment.click();	
					logger.log(Status.INFO, "Clicekd on Finish_Partial_Payment");
					yes_btn.click();
					logger.log(Status.INFO, "Clicekd on yes_btn");
					extent.flush();
				}
				
				else if(name.contains(cardtype)){
					list.get(2).click();
					Thread.sleep(3000);
					skip_btn.click();
					break;
				}
			}
			//util.debitcardfilling();
			logger.log(Status.INFO, "Filled card details successfully");
			Thread.sleep(10000);
			pwd_tb.sendKeys("1234");
			logger.log(Status.INFO, "Entered password");
			Finish_Partial_Payment.click();	
			logger.log(Status.INFO, "Clicekd on Finish_Partial_Payment");
			yes_btn.click();
			logger.log(Status.INFO, "Clicekd on yes_btn");
			//extent.flush();
			/*ExtentTest logger2=extent.createTest("Partial Payment Void Test");
			logger2.log(Status.INFO, "Combination is good");
			extent.flush();*/
			}
	}
		
	public void DebitcardFillingforPayments(){
		Select cardtype = new Select(card_type);
		cardtype.selectByVisibleText("Visa");
		ccnumber.sendKeys("4000051292780678");
		Select expmonthh = new Select(expmonth);
		expmonthh.selectByVisibleText("December");
		Select expyeary = new Select(expyear);
		expyeary.selectByVisibleText("2026");
		cvvnumber.sendKeys("457");
		ccname.sendKeys("james");
	}
	
	
	@FindBy(name="transactionDataBean.disbursementType")
	WebElement disbursementType;
	
	@FindBy(xpath="//input[@value='Finish Void Partial Payment']")
	WebElement FinishVoidPartialPayment;
	
	public void PartialPaymentVoid(){
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/RegressionTesting.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger2=extent.createTest("Partial Payment Void Test");
		util=new Utilities();
		util.LogintoApplication();
		logger2.log(Status.INFO, "Logged into application");
		util.transactionsinitialization();
		logger2.log(Status.INFO, "Transaction has initialized");
		Go_Btn.click();
		logger2.log(Status.INFO, "Clicked on Go_Btn");
		Select Transactionsdd = new Select(Transactions_dd);
		logger2.log(Status.INFO, "Clicked on Transactions_dd");
		Transactionsdd.selectByVisibleText("Void");
		logger2.log(Status.INFO, "Selected Void Option");
		go_Button.click();
		logger2.log(Status.INFO, "Clicked on go_Button");
		Select disbursementTypee = new Select(disbursementType);
		logger2.log(Status.INFO, "Clicked on disbursementType_dd");
		disbursementTypee.selectByVisibleText(prop.getProperty("disbursementType"));
		logger2.log(Status.INFO, "Selected disbursementType");
		pwd_tb.sendKeys("1234");
		logger2.log(Status.INFO, "Entered password");
		FinishVoidPartialPayment.click();
		logger2.log(Status.INFO, "Clicked on FinishVoidPartialPayment btn");
		yes_btn.click();	
		logger2.log(Status.INFO, "Clicked on yes_btn");
		extent.flush();
	}
	

	@FindBy(xpath="//input[@value='Finish Buy Back ']")
	WebElement FinishBuyBack;
	
	@FindBy(name="payAmt")
	WebElement payAmt;
	
	public void BuyBack() throws Exception{
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/RegressionTesting.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("BuyBack Test");
		util=new Utilities();
		util.LogintoApplication();
		logger.log(Status.INFO, "Logged into application");
		util.transactionsinitialization();
		logger.log(Status.INFO, "Transaction has initialized");
		Go_Btn.click();
		logger.log(Status.INFO, "Clicked on Go_Btn");
		Select Transactionsdd = new Select(Transactions_dd);
		logger.log(Status.INFO, "Clicked on Transactions_dd");
		Transactionsdd.selectByVisibleText("Buy Back");
		logger.log(Status.INFO, "Selected BuyBack Option");
		go_Button.click();
		logger.log(Status.INFO, "Clicked on go_Button");
		Thread.sleep(8000);
		String payoff_amnt=paymentAmt_tb.getAttribute("value");
		logger.log(Status.INFO, "Copied payoff amount");
		String payment_type=prop.getProperty("paymnt_type");
		Select tenderTypedd = new Select(tenderType_dd);
		logger.log(Status.INFO, "Clicked on tenderType_dd");
		tenderTypedd.selectByVisibleText(payment_type);
		logger.log(Status.INFO, "Selected payment_type");
		if(payment_type.equals("Cash"))
		{
			tenderAmt_tb.sendKeys(payoff_amnt);
			pwd_tb.sendKeys("1234");
			FinishBuyBack.click();
			try {
				Alert alt = driver.switchTo().alert();
				alt.accept();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			yes_btn.click();
		}
		
		else if(payment_type.equals("Cashiers Check"))
		{
			cc_nbr.sendKeys(prop.getProperty("ccmo_num"));
			tenderAmt_tb.sendKeys(payoff_amnt);
			pwd_tb.sendKeys("1234");
			FinishBuyBack.click();		
			yes_btn.click();
		}
		
		else if(payment_type.equals("Money Order"))
		{
			mo_nbr.sendKeys(prop.getProperty("ccmo_num"));
			tenderAmt_tb.sendKeys(payoff_amnt);
			pwd_tb.sendKeys("1234");
			FinishBuyBack.click();		
			yes_btn.click();
		}
		else {
			tenderAmt_tb.sendKeys(payoff_amnt);
			logger.log(Status.INFO, "Entered payoff_amnt");
			Select selcard=new Select(selectcarddd);
			logger.log(Status.INFO, "Clicked on selectcard dropdown");
			List<WebElement> list=selcard.getOptions();
			int count=list.size();
			for(int i=0;i<count;i++){
				String name=list.get(i).getText();
				System.out.println(name);
				if(name.equalsIgnoreCase(cardtype)){
					list.get(i).click();
					Thread.sleep(10000);
					util.Updateddebitcardfillingforpayments();	
					pwd_tb.sendKeys("1234");
					logger.log(Status.INFO, "Entered password");
					FinishBuyBack.click();		
					logger.log(Status.INFO, "Clicked on FinishBuyBack");
					yes_btn.click();
					logger.log(Status.INFO, "Clicked on yes_btn");
					extent.flush();
				}
				
				else if(name.contains(cardtype)){
					list.get(2).click();
					logger.log(Status.INFO, "Selected existed card");
					Thread.sleep(3000);
					skip_btn.click();
					logger.log(Status.INFO, "Clicked on SKIP button");
					break;
				}
			}
			//util.debitcardfilling();
			pwd_tb.sendKeys("1234");
			logger.log(Status.INFO, "Entered password");
			FinishBuyBack.click();		
			logger.log(Status.INFO, "Clicked on FinishBuyBack");
			yes_btn.click();
			logger.log(Status.INFO, "Clicked on yes_btn");
			extent.flush();
			}	
	}
	
	@FindBy(xpath="//input[@value='Finish Void Buy Back']")
	WebElement FinishVoidBuyBack;
	
	public void BuyBackVoid(){
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/RegressionTesting.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("BuyBackVoid Test");
		util=new Utilities();
		util.LogintoApplication();
		logger.log(Status.INFO, "Logged into application");
		util.transactionsinitialization();
		logger.log(Status.INFO, "Transaction has initiated");
		driver.findElement(By.xpath("//td[text()='Payday Loans']//parent::tr//following-sibling::tr//td//input[@value='Go']")).click();
		logger.log(Status.INFO, "Clicked on GO button");
		Select Transactionsdd = new Select(Transactions_dd);
		logger.log(Status.INFO, "Clicked on Transactions_dd");
		Transactionsdd.selectByVisibleText("Void");
		logger.log(Status.INFO, "Selected Void Optioon");
		go_Button.click();
		logger.log(Status.INFO, "Clicked on go_Button");
		Select disbursementTypee = new Select(disbursementType);
		logger.log(Status.INFO, "Clicked on disbursementTypee");
		disbursementTypee.selectByVisibleText(prop.getProperty("disbursementType"));
		logger.log(Status.INFO, "Selected disbursementType");
		pwd_tb.sendKeys("1234");
		logger.log(Status.INFO, "Entered password");
		FinishVoidBuyBack.click();
		logger.log(Status.INFO, "Clicked on FinishVoidBuyBack");
		yes_btn.click();	
		logger.log(Status.INFO, "Clicked on yes_btn");
		extent.flush();
	}
	
	@FindBy(name="paymentPlanFreq")
	WebElement paymentPlanFreq;
	
	@FindBy(xpath="//input[@value='Next']")
	WebElement NEXT;
	
	@FindBy(name="chkgAcctNbr")
	WebElement chkgAcctNbr2;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Finish Extended Payment Plan']")
	WebElement FinishExtendedPaymentPlan;
	
	public void EPP() throws Exception{
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/RegressionTesting.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("EPP Test");
		util=new Utilities();
		util.LogintoApplication();
		logger.log(Status.INFO, "Logged into application");
		util.transactionsinitialization();
		logger.log(Status.INFO, "EPP Transaction has initiated");
		Go_Btn.click();
		logger.log(Status.INFO, "Loan has opened by clicking on Go button");
		Select Transactionsdd = new Select(Transactions_dd);
		logger.log(Status.INFO, "Clicked on Transactions_dd");
		Transactionsdd.selectByVisibleText("EPP");
		logger.log(Status.INFO, "Selected EPP Option to Perform EPP Transaction");
		go_Button.click();
		logger.log(Status.INFO, "Clicked on go_Button");
		Alert alt=driver.switchTo().alert();
		alt.accept();
		logger.log(Status.INFO, "EPP confirmation Alert has accepted");
		Select paymentPlanFreqf = new Select(paymentPlanFreq);
		logger.log(Status.INFO, "Clicked on paymentPlanFrequency dropdown button");
		paymentPlanFreqf.selectByIndex(1);
		logger.log(Status.INFO, "Selected frequency type");
		NEXT.click();
		logger.log(Status.INFO, "Clicked on NEXT button");
		Thread.sleep(8000);
		/*try {
			String chkgAcctNbr = prop.getProperty("accountNbr");
			String acntnbr = chkgAcctNbr.substring(3);
			chkgAcctNbr2.sendKeys(acntnbr);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		Select selcard=new Select(selectcarddddd);
		logger.log(Status.INFO, "Selected card type");
		List<WebElement> list=selcard.getOptions();
		int count=list.size();
		for(int i=0;i<count;i++){
			String name=list.get(i).getText();
			System.out.println(name);
			if(name.equalsIgnoreCase(cardtype)){
				list.get(i).click();
				Thread.sleep(10000);
				util.Updateddebitcardfillingforpayments();	
				password.sendKeys("1234");
				logger.log(Status.INFO, "Entered password");
				FinishExtendedPaymentPlan.click();
				logger.log(Status.INFO, "Clicked on FinishExtendedPaymentPlan");
				yes_btn.click();
				logger.log(Status.INFO, "Clicked on yes_btn");
				extent.flush();
			}
			
			else if(name.contains(cardtype)){
				list.get(2).click();
				logger.log(Status.INFO, "Selected existed card");
				Thread.sleep(3000);
				skip_btn.click();
				logger.log(Status.INFO, "Clicked on SKIP Button");
				break;
			}
		}
		
		//util.debitcardfilling();
		password.sendKeys("1234");
		logger.log(Status.INFO, "Entered password");
		FinishExtendedPaymentPlan.click();
		logger.log(Status.INFO, "Clicked on FinishExtendedPaymentPlan");
		yes_btn.click();
		logger.log(Status.INFO, "Clicked on yes_btn");
		extent.flush();
	}
	
	@FindBy(xpath="//input[@value='Void Payment Plan']")
	WebElement VoidPaymentPlan;
	
	public void EPPVoid(){
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/RegressionTesting.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("EPPVoid Test");
		util=new Utilities();
		util.LogintoApplication();
		logger.log(Status.INFO, "Logged into application");
		util.transactionsinitialization();
		logger.log(Status.INFO, "EPPVoid transaction has initiated");
		Go_Btn.click();
		logger.log(Status.INFO, "Clicked on Go_Btn");
		Select Transactionsdd = new Select(Transactions_dd);
		logger.log(Status.INFO, "Clicked on Transactions_dd");
		Transactionsdd.selectByVisibleText("Void");
		logger.log(Status.INFO, "Selected Void Option");
		go_Button.click();
		logger.log(Status.INFO, "Clicked on go_Button");
		pwd_tb.sendKeys("1234");
		logger.log(Status.INFO, "Entered password");
		VoidPaymentPlan.click();
		logger.log(Status.INFO, "Clicked on VoidPaymentPlan button");
		yes_btn.click();
		logger.log(Status.INFO, "Clicked on yes_btn");
		extent.flush();
	}
	
	@FindBy(name="transactionDataBean.paymentAmt")
	WebElement epppayment_amnt_tb;
	
	@FindBy(xpath="//input[@value='Finish Payment Plan Payment']")
	WebElement Finish_Payment_Plan_Payment;

	public void EPPPayment() throws Exception{
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/RegressionTesting.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("EPPPayment Test");
		util=new Utilities();
		util.LogintoApplication();
		logger.log(Status.INFO, "Logged into application");
		util.transactionsinitialization();
		logger.log(Status.INFO, "EPP Payment transaction has initiated");
		Go_Btn.click();
		logger.log(Status.INFO, "Loan has opened by clicking on Go button");
		Select Transactionsdd = new Select(Transactions_dd);
		logger.log(Status.INFO, "Clicked on Transactions dd");
		Transactionsdd.selectByVisibleText("EPP Payment");
		logger.log(Status.INFO, "Selected 'EPP Payment' from dropdown");
		go_Button.click();
		logger.log(Status.INFO, "Clicked on go_Button");
		Thread.sleep(8000);
		String epppay=epppayment_amnt_tb.getAttribute("value");
		Select tenderTypedd = new Select(tenderType_dd);
		logger.log(Status.INFO, "Clicked on tenderType_dd");
		tenderTypedd.selectByVisibleText(payment_type);
		logger.log(Status.INFO, "Selected payment_type");
		if(payment_type.equals("Cash"))
		{
			tenderAmt_tb.sendKeys(epppay);
			password.sendKeys("1234");
			Finish_Payment_Plan_Payment.click();
			try {
				Alert alt = driver.switchTo().alert();
				alt.accept();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			yes_btn.click();
		}
		
		else if(payment_type.equals("Cashiers Check"))
		{
			cc_nbr.sendKeys(prop.getProperty("ccmo_num"));
			tenderAmt_tb.sendKeys(epppay);
			password.sendKeys("1234");
			Finish_Payment_Plan_Payment.click();		
			yes_btn.click();
		}
		
		else if(payment_type.equals("Money Order"))
		{
			mo_nbr.sendKeys(prop.getProperty("ccmo_num"));
			tenderAmt_tb.sendKeys(epppay);
			password.sendKeys("1234");
			Finish_Payment_Plan_Payment.click();		
			yes_btn.click();
		}
		else {
			Thread.sleep(5000);
			Select selcard=new Select(selectcarddd);
			List<WebElement> list=selcard.getOptions();
			int count=list.size();
			for(int i=0;i<count;i++){
				String name=list.get(i).getText();
				System.out.println(name);
				if(name.equalsIgnoreCase(cardtype)){
					list.get(i).click();
					util.Updateddebitcardfillingforpayments();	
					tenderAmt_tb.sendKeys(epppay);
					logger.log(Status.INFO, "Entered epppay amount");
					password.sendKeys("1234");
					logger.log(Status.INFO, "Entered password");
					Finish_Payment_Plan_Payment.click();	
					logger.log(Status.INFO, "Clicked on Finish_Payment_Plan_Payment button");
					yes_btn.click();
					logger.log(Status.INFO, "Clicked on yes_btn");
					extent.flush();
				}
				
				else if(name.contains(cardtype)){
					list.get(2).click();
					logger.log(Status.INFO, "Selected Existed card");
					Thread.sleep(3000);
					skip_btn.click();
					logger.log(Status.INFO, "Clicked on skip_btn");
					break;
				}
			}
			//util.debitcardfilling();
			tenderAmt_tb.sendKeys(epppay);
			logger.log(Status.INFO, "Entered epppay amount");
			password.sendKeys("1234");
			logger.log(Status.INFO, "Entered password");
			Finish_Payment_Plan_Payment.click();	
			logger.log(Status.INFO, "Clicked on Finish_Payment_Plan_Payment button");
			yes_btn.click();
			logger.log(Status.INFO, "Clicked on yes_btn");
			extent.flush();
			}
	}
	
	@FindBy(xpath="//input[@value='Finish Void Payment Plan Payment']")
	WebElement Finish_Void_Payment_Plan_Payment;
	
	public void EPPPaymentVoid(){
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/RegressionTesting.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("EPPPaymentVoid Test");
		util=new Utilities();
		util.LogintoApplication();
		logger.log(Status.INFO, "Logged into application");
		util.transactionsinitialization();
		logger.log(Status.INFO, "EPPPaymentVoid transaction has initiated");
		Go_Btn.click();
		logger.log(Status.INFO, "Clicked on Go_Btn");
		Select Transactionsdd = new Select(Transactions_dd);
		logger.log(Status.INFO, "Clicked on Transactions_dd");
		Transactionsdd.selectByVisibleText("Void");
		logger.log(Status.INFO, "Selected Void Option");
		go_Button.click();
		logger.log(Status.INFO, "Clicked on go_Button");
		Select disbursementTyped = new Select(disbursementType);
		logger.log(Status.INFO, "Clicked on disbursementType");
		disbursementTyped.selectByVisibleText("Original Tender");
		logger.log(Status.INFO, "Selected Original Tender type");
		pwd_tb.sendKeys("1234");
		logger.log(Status.INFO, "Entered password");
		Finish_Void_Payment_Plan_Payment.click();
		logger.log(Status.INFO, "Clicked on Finish_Void_Payment_Plan_Payment button");
		yes_btn.click();
		logger.log(Status.INFO, "Clicked on yes_btn");
		extent.flush();
	}
	
	@FindBy(name="requestBean.chkName")
	WebElement checkbox;
	
	@FindBy(name="CmdReturnPosting")
	WebElement nxt_btn;
	
	@FindBy(xpath="//input[@value='Finish ACH Deposit']")
	WebElement FinishACHDeposit;
	
	public void ACHDeposit(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_Btn.click();
		Select Transactionsdd = new Select(Transactions_dd);
		Transactionsdd.selectByVisibleText("ACH Deposit");
		go_Button.click();
		checkbox.click();
		nxt_btn.click();
		pwd_tb.sendKeys("1234");
		FinishACHDeposit.click();
		yes_btn.click();
	}
	
	public void ACHDepositVoid(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_Btn.click();
		Select Transactionsdd = new Select(Transactions_dd);
		Transactionsdd.selectByVisibleText("Void");
		go_Button.click();
		checkbox.click();
		nxt_btn.click();
		yes_btn.click();
	}
	
	public void DCDeposit(){
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/RegressionTesting.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("DCDeposit Test");
		util=new Utilities();
		util.LogintoApplication();
		logger.log(Status.INFO, "Logged into application");
		util.transactionsinitialization();
		logger.log(Status.INFO, "DCDeposit Transaction has initiated");
		Go_Btn.click();
		logger.log(Status.INFO, "Clicked on Go_Btn");
		Select Transactionsdd = new Select(Transactions_dd);
		logger.log(Status.INFO, "Clicked on Transactions_dd");
		Transactionsdd.selectByVisibleText("DebitCard Deposit");
		logger.log(Status.INFO, "Selected DebitCard Deposit Option");
		go_Button.click();
		logger.log(Status.INFO, "Clicked on go_Button");
		Finish_btnn.click();
		logger.log(Status.INFO, "Clicked on Finish_btnn");
		yes_btn.click();
		logger.log(Status.INFO, "Clicked on yes_btn");
		extent.flush();
	}
	
	@FindBy(xpath="//input[@value='Finish Void DC Deposit']")
	WebElement Finish_Void_DC_Deposit;
	
	public void DCDepositVoid(){
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/RegressionTesting.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("DCDepositVoid Test");
		util=new Utilities();
		util.LogintoApplication();
		logger.log(Status.INFO, "Logged into application");
		util.transactionsinitialization();
		logger.log(Status.INFO, "DCDepositVoid transaction has initiated");
		Go_Btn.click();
		logger.log(Status.INFO, "Clicked on Go_Btn");
		Select Transactionsdd = new Select(Transactions_dd);
		logger.log(Status.INFO, "Clicked on Transactions_dd");
		Transactionsdd.selectByVisibleText("Void");
		logger.log(Status.INFO, "Selected Void option");
		go_Button.click();
		logger.log(Status.INFO, "Clicked on go_Button");
		Select disbursem = new Select(disbursementType);
		logger.log(Status.INFO, "Clicked on disbursementType");
		disbursem.selectByVisibleText("Original Tender");
		logger.log(Status.INFO, "Selected Original Tender type");
		pwd_tb.sendKeys("1234");
		logger.log(Status.INFO, "Entered password");
		Finish_Void_DC_Deposit.click();
		logger.log(Status.INFO, "Clicked on Finish_Void_DC_Deposit button");
		yes_btn.click();
		logger.log(Status.INFO, "Clicked on yes_btn");
		extent.flush();
	}
	
	
	public void ACHClear(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_Btn.click();
		Select Transactionsdd = new Select(Transactions_dd);
		Transactionsdd.selectByVisibleText("ACH Clear");
		go_Button.click();
		checkbox.click();
		nxt_btn.click();
		yes_btn.click();
	}
	
	public void ACHClearVoid(){
		
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_Btn.click();
		Select Transactionsdd = new Select(Transactions_dd);
		Transactionsdd.selectByVisibleText("Void");
		go_Button.click();
		checkbox.click();
		nxt_btn.click();
		yes_btn.click();
	}
	
	@FindBy(name="requestBean.password")
	WebElement password2;
	
	@FindBy(xpath="//input[@value='Finish ACH Pre-Payment']")
	WebElement FinishACHPrePayment;
	
	public void ACHPrePayment() throws Exception{
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_Btn.click();
		Select Transactionsdd = new Select(Transactions_dd);
		Transactionsdd.selectByVisibleText("ACH Pre-Payment");
		go_Button.click();
		Thread.sleep(8000);
		String prepayment_amnt=paymentAmt_tb.getAttribute("value");
		Select tenderTypedd = new Select(tenderType_dd);
		tenderTypedd.selectByVisibleText(payment_type);
		if(payment_type.equals("Cash"))
		{
			tenderAmt_tb.sendKeys(prepayment_amnt);
			password2.sendKeys("1234");
			FinishACHPrePayment.click();
			try {
				Alert alt = driver.switchTo().alert();
				alt.accept();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			yes_btn.click();
		}
		
		else if(payment_type.equals("Cashiers Check"))
		{
			cc_nbr.sendKeys(prop.getProperty("ccmo_num"));
			tenderAmt_tb.sendKeys(prepayment_amnt);
			password2.sendKeys("1234");
			FinishACHPrePayment.click();		
			yes_btn.click();
		}
		
		else if(payment_type.equals("Money Order"))
		{
			mo_nbr.sendKeys(prop.getProperty("ccmo_num"));
			tenderAmt_tb.sendKeys(prepayment_amnt);
			password2.sendKeys("1234");
			FinishACHPrePayment.click();		
			yes_btn.click();
		}
		else {
			/*tenderAmt_tb.sendKeys(prepayment_amnt);
			DebitcardFillingforPayments();	
			password2.sendKeys("1234");
			FinishACHPrePayment.click();		
			yes_btn.click();*/
			
			tenderAmt_tb.sendKeys(payment_amt);
			Select selcard=new Select(selectcarddd);
			List<WebElement> list=selcard.getOptions();
			int count=list.size();
			for(int i=0;i<count;i++){
				String name=list.get(i).getText();
				System.out.println(name);
				if(name.equalsIgnoreCase(cardtype)){
					list.get(i).click();
					Thread.sleep(10000);
					util.Updateddebitcardfillingforpayments();	
					Thread.sleep(5000);
					pwd_tb.sendKeys("1234");
					Finish_Partial_Payment.click();	
					yes_btn.click();
					extent.flush();
				}
				
				else if(name.contains(cardtype)){
					list.get(2).click();
					Thread.sleep(3000);
					skip_btn.click();
					break;
				}
			}
			//util.debitcardfilling();
			Thread.sleep(10000);
			pwd_tb.sendKeys("1234");
			Finish_Partial_Payment.click();	
			yes_btn.click();

			}	
	}
	
	@FindBy(xpath="//input[@value='Finish Void ACH Pre-Payment']")
	WebElement FinishVoidACHPrePayment;
	
	public void ACHPrePaymentVoid(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_Btn.click();
		Select Transactionsdd = new Select(Transactions_dd);
		Transactionsdd.selectByVisibleText("Void");
		go_Button.click();
		Select disbursementTypee = new Select(disbursementType);
		disbursementTypee.selectByVisibleText(prop.getProperty("disbursementType"));
		pwd_tb.sendKeys("1234");
		FinishVoidACHPrePayment.click();
		yes_btn.click();
	}

	@FindBy(xpath="//input[@value='Finish NSF Payment']")
	WebElement FinishNSFPayment;
	
	public void NSFPayment(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_Btn.click();
		Select Transactionsdd = new Select(Transactions_dd);
		Transactionsdd.selectByVisibleText("NSF Payment");
		go_Button.click();
		String NSFamnt=paymentAmt_tb.getAttribute("value");
		Select tenderTypedd = new Select(tenderType_dd);
		tenderTypedd.selectByVisibleText(payment_type);
		if(payment_type.equals("Cash"))
		{
			tenderAmt_tb.sendKeys(NSFamnt);
			password2.sendKeys("1234");
			FinishNSFPayment.click();
			try {
				Alert alt = driver.switchTo().alert();
				alt.accept();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			yes_btn.click();
		}
		
		else if(payment_type.equals("Cashiers Check"))
		{
			cc_nbr.sendKeys(prop.getProperty("ccmo_num"));
			tenderAmt_tb.sendKeys(NSFamnt);
			password2.sendKeys("1234");
			FinishNSFPayment.click();		
			yes_btn.click();
		}
		
		else if(payment_type.equals("Money Order"))
		{
			mo_nbr.sendKeys(prop.getProperty("ccmo_num"));
			tenderAmt_tb.sendKeys(NSFamnt);
			password2.sendKeys("1234");
			FinishNSFPayment.click();		
			yes_btn.click();
		}
		else {
			tenderAmt_tb.sendKeys(NSFamnt);
			DebitcardFillingforPayments();	
			password2.sendKeys("1234");
			FinishNSFPayment.click();		
			yes_btn.click();
			}
	}	
	
	@FindBy(xpath="//input[@value='Finish Void NSF Payment']")
	WebElement FinishVoidNSFPayment;
	
	public void NSFPaymentVoid(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_Btn.click();
		Select Transactionsdd = new Select(Transactions_dd);
		Transactionsdd.selectByVisibleText("Void");
		go_Button.click();
		Select disbursementTypee = new Select(disbursementType);
		disbursementTypee.selectByVisibleText(prop.getProperty("disbursementType"));
		pwd_tb.sendKeys("1234");
		FinishVoidNSFPayment.click();
		yes_btn.click();
	}
	
	
	@FindBy(name="transactionDataBean.paymentBalAmt")
	WebElement default_balance;
	
	@FindBy(xpath="//input[@value='Finish']")
	WebElement Finish_btnn;
	
	@FindBy(name="password")
	WebElement password_tb;
	
	@FindBy(xpath="//select[@name='cardType']")
	WebElement debit_dd;
	
	public void DefaultPayment(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_Btn.click();
		Select Transactionsdd = new Select(Transactions_dd);
		Transactionsdd.selectByVisibleText("Default Payment");
		go_Button.click();
		String def_amnt=default_balance.getAttribute("value");
		paymentAmt_tb.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
		paymentAmt_tb.sendKeys(def_amnt);
		Select tenderTypeFirstdd = new Select(tenderTypeFirst);
		tenderTypeFirstdd.selectByVisibleText(payment_type);
		if(payment_type.equals("Cash"))
		{
			tenderAmt_tb.sendKeys(def_amnt);
			password_tb.sendKeys("1234");
			Finish_btnn.click();
			try {
				Alert alt = driver.switchTo().alert();
				alt.accept();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			yes_btn.click();
		}
		
		else if(payment_type.equals("Cashiers Check"))
		{
			cc_nbr.sendKeys(prop.getProperty("ccmo_num"));
			tenderAmt_tb.sendKeys(def_amnt);
			password_tb.sendKeys("1234");
			Finish_btnn.click();	
			try {
				Alert alt = driver.switchTo().alert();
				alt.accept();
			} catch (Exception e) {
				e.printStackTrace();
			}
			yes_btn.click();
		}
		
		else if(payment_type.equals("Money Order"))
		{
			mo_nbr.sendKeys(prop.getProperty("ccmo_num"));
			tenderAmt_tb.sendKeys(def_amnt);
			password_tb.sendKeys("1234");
			Finish_btnn.click();	
			try {
				Alert alt = driver.switchTo().alert();
				alt.accept();
			} catch (Exception e) {
				e.printStackTrace();
			}
			yes_btn.click();
		}
		else {
			
			Select cardtype = new Select(debit_dd);
			cardtype.selectByVisibleText("Visa");
			ccnumber.sendKeys("4000051292780678");
			Select expmonthh = new Select(expmonth);
			expmonthh.selectByVisibleText("December");
			Select expyeary = new Select(expyear);
			expyeary.selectByVisibleText("2026");
			ccname.sendKeys("james");
			cvvnumber.sendKeys("457");
			tenderAmt_tb.sendKeys(def_amnt);
			password_tb.sendKeys("1234");
			Finish_btnn.click();
			yes_btn.click();
			}
	}
	
	
	@FindBy(xpath="//input[@value='Finish Void Default Payment']")
	WebElement FinishVoidDefaultPayment;
	
	public void DefaultPaymentVoid(){
		
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_Btn.click();
		Select Transactionsdd = new Select(Transactions_dd);
		Transactionsdd.selectByVisibleText("Void");
		go_Button.click();
		Select disbursementTypee = new Select(disbursementType);
		disbursementTypee.selectByVisibleText(prop.getProperty("disbursementType"));
		pwd_tb.sendKeys("1234");
		FinishVoidDefaultPayment.click();
		yes_btn.click();	
		
	}
	
	@FindBy(xpath="//input[@value='Finish Write Off Recovery']")
	WebElement FinishWriteOffRecovery;
	
	public void WriteOffRecovery(){
		
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_Btn.click();
		Select Transactionsdd = new Select(Transactions_dd);
		Transactionsdd.selectByVisibleText("WO Recovery");
		go_Button.click();
		String WOPay=paymentAmt_tb.getAttribute("value");
		Select tenderTypeFirstdd = new Select(tenderTypeFirst);
		tenderTypeFirstdd.selectByVisibleText(payment_type);
		if(payment_type.equals("Cash"))
		{
			tenderAmt_tb.sendKeys(WOPay);
			password2.sendKeys("1234");
			FinishWriteOffRecovery.click();
			try {
				Alert alt = driver.switchTo().alert();
				alt.accept();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			yes_btn.click();
		}
		
		else if(payment_type.equals("Cashiers Check"))
		{
			cc_nbr.sendKeys(prop.getProperty("ccmo_num"));
			tenderAmt_tb.sendKeys(WOPay);
			password2.sendKeys("1234");
			FinishWriteOffRecovery.click();	
			yes_btn.click();
		}
		
		else if(payment_type.equals("Money Order"))
		{
			mo_nbr.sendKeys(prop.getProperty("ccmo_num"));
			tenderAmt_tb.sendKeys(WOPay);
			password2.sendKeys("1234");
			FinishWriteOffRecovery.click();	
			yes_btn.click();
		}
		else {
			
			Select cardtype = new Select(card_type);
			cardtype.selectByVisibleText("Visa");
			ccnumber.sendKeys("4000051292780678");
			Select expmonthh = new Select(expmonth);
			expmonthh.selectByVisibleText("December");
			Select expyeary = new Select(expyear);
			expyeary.selectByVisibleText("2026");
			cvvnumber.sendKeys("457");
			ccname.sendKeys("james");
			tenderAmt_tb.sendKeys(WOPay);
			password2.sendKeys("1234");
			FinishWriteOffRecovery.click();
			yes_btn.click();
			}
	}
	
	
	@FindBy(xpath="//input[@value='Finish Void Write Off Recovery']")
	WebElement FinishVoidWriteOffRecovery;
	
	public void WriteOffRecoveryVoid(){
		
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_Btn.click();
		Select Transactionsdd = new Select(Transactions_dd);
		Transactionsdd.selectByVisibleText("Void");
		go_Button.click();
		Select disbursementTypee = new Select(disbursementType);
		disbursementTypee.selectByVisibleText(prop.getProperty("disbursementType"));
		pwd_tb.sendKeys("1234");
		FinishVoidWriteOffRecovery.click();
		yes_btn.click();	
		
	}
	
	
	@FindBy(xpath="//input[@value='Finish Refund']")
	WebElement FinishRefund;
	
	public void Refund(){
		
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_Btn.click();
		Select Transactionsdd = new Select(Transactions_dd);
		Transactionsdd.selectByVisibleText("CustomerRefund");
		go_Button.click();
		Select tenderTypeFirstdd = new Select(tenderTypeFirst);
		tenderTypeFirstdd.selectByVisibleText("Cash");
		FinishRefund.click();
		yes_btn.click();
	}
	
	@FindBy(xpath="//input[@value='Finish Void Refund']")
	WebElement FinishVoidRefund;
	
	public void RefundVoid(){
		
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_Btn.click();
		Select Transactionsdd = new Select(Transactions_dd);
		Transactionsdd.selectByVisibleText("Void");
		go_Button.click();
		Select tenderTypeFirstdd = new Select(tenderTypeFirst);
		tenderTypeFirstdd.selectByVisibleText("Cash");
		FinishVoidRefund.click();
		yes_btn.click();
	}
	
	public void getdbdata() throws Exception{
		
		String url="jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1";
		String username="QCHPROD_050819";
		String password="QCHPROD_050819";
		String query="select * from st_lo_master where LOAN_STATUS_ID='OPN' AND ST_CODE=521  AND TOTAL_DUE=600 ORDER BY 1 DESC";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
		Connection con=DriverManager.getConnection(url, username, password);
		Statement st=con.createStatement();
		ResultSet rs= st.executeQuery(query);
		while(rs.next()){
		String name=rs.getString(1);
		System.out.println(name);
		}
		st.close();
		con.close();
	}
	
	@FindBy(xpath="//input[@value='DC Revoke']")
	WebElement dcrevoke;

	public void DCRevoke(){
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/RegressionTesting.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("DCRevoke Test");
		util=new Utilities();
		util.LogintoApplication();
		logger.log(Status.INFO, "Logged into application");
		util.transactionsinitialization();
		logger.log(Status.INFO, "DCRevoke transaction has initiated");
		Go_Btn.click();
		logger.log(Status.INFO, "Clicked on Go_Btn");
		Select Transactionsdd = new Select(Transactions_dd);
		logger.log(Status.INFO, "Clicked on Transactions_dd");
		Transactionsdd.selectByVisibleText("DC Revoke");
		logger.log(Status.INFO, "Selected DC Revoke option");
		go_Button.click();
		logger.log(Status.INFO, "Clicked on go_Button");
		driver.switchTo().alert().accept();
		logger.log(Status.INFO, "DC Revoke alert has accepted");
		dcrevoke.click();
		logger.log(Status.INFO, "Clicked on dcrevoke button");
		yes_btn.click();
		logger.log(Status.INFO, "Clicked on yes_btn");
		extent.flush();
	}
	
	@FindBy(xpath="//input[@value='Chargeback']")
	WebElement chargeback;
	
	public void chargeback(){
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/RegressionTesting.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("chargeback Test");
		util=new Utilities();
		util.LogintoApplication();
		logger.log(Status.INFO, "Logged into application");
		util.transactionsinitialization();
		logger.log(Status.INFO, "Chargeback transaction has initiated");
		Go_Btn.click();
		logger.log(Status.INFO, "Clicked on Go_Btn");
		Select Transactionsdd = new Select(Transactions_dd);
		logger.log(Status.INFO, "Clicked on Transactions_dd");
		Transactionsdd.selectByVisibleText("History");
		logger.log(Status.INFO, "Selected History option");
		go_Button.click();
		logger.log(Status.INFO, "Clicked on go_Button");
		List<WebElement> list=driver.findElements(By.xpath("//input[@id='rad1']"));
		int count=list.size();
		System.out.println(count);
		list.get(count-1).click();
		logger.log(Status.INFO, "Selected DC payment/DC Deposit transaction");
		chargeback.click();
		logger.log(Status.INFO, "Clicked on chargeback button");
		driver.switchTo().alert().accept();
		logger.log(Status.INFO, "Chargeback alert has been accepted");
		extent.flush();
		
	}
	
	@FindBy(xpath="//input[@value='Qualify']")
	WebElement Qualify_btn;
	
	@FindBy(name="transactionDataBean.courtesyCallFlag")
	WebElement collat_dd;
	
	@FindBy(xpath="//input[@value='Finish Refinance']")
	WebElement Finish_Refinance;
	
	@FindBy(xpath="//div[@id='cardsList']//select[@name='cardNmbr']")
	WebElement select_car_dd;
	
	public void Refinance() throws Exception{
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_Btn.click();
		Select Transactionsdd = new Select(Transactions_dd);
		Transactionsdd.selectByVisibleText("Refinance");
		go_Button.click();
		Thread.sleep(10000);
		//util.clickon(driver, Qualify_btn, 60);
		Qualify_btn.click();
		Thread.sleep(10000);
		Select collat_ddd = new Select(collat_dd);
		collat_ddd.selectByVisibleText("No");
		
		Select selcard=new Select(selectcarddddd);
		List<WebElement> list=selcard.getOptions();
		int count=list.size();
		for(int i=0;i<count;i++){
			String name=list.get(i).getText();
			System.out.println(name);
			if(name.equalsIgnoreCase(cardtype)){
				list.get(i).click();
				util.Updateddebitcardfilling();	
			}
			
			else if(name.contains(cardtype)){
				list.get(2).click();
				Thread.sleep(3000);
				skip_btn.click();
				break;
			}
		}
		
		Select tenderTypeFirstt=new Select(tenderTypeFirst);
		tenderTypeFirstt.selectByVisibleText("Debit Card");
		Select selcardf=new Select(select_car_dd);
		List<WebElement> listt=selcardf.getOptions();
		int countt=list.size();
		for(int i=0;i<countt;i++){
			String namee=listt.get(i).getText();
			System.out.println(namee);
			if(namee.equalsIgnoreCase(cardtype)){
				listt.get(i).click();
				util.Updateddebitcardfilling();	
			}
			
			else if(namee.contains(cardtype)){
				listt.get(2).click();
				Thread.sleep(3000);
				skip_btn.click();
				break;
			}
		}
		
		paymentAmt_tb.getAttribute("value");
		String cab_amnt=paymentAmt_tb.getAttribute("value");
		tenderamnt.sendKeys(cab_amnt);
		password2.sendKeys("1234");
		Finish_Refinance.click();
		yes_btn.click();
		Thread.sleep(2000);
		yes_btn.click();
	}
}
