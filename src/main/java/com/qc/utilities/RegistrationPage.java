package com.qc.utilities;


import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qc.base.TestBase;

public class RegistrationPage extends TestBase{
	Utilities utilities;
	
	@FindBy(linkText="Borrower")
	WebElement Borrower;
	
	@FindBy(linkText="Registration")
	WebElement Registration;
	
	@FindBy(name="ssn1")
	WebElement ssn1;
	
	@FindBy(name="ssn2")
	WebElement ssn2;
	
	@FindBy(name="ssn3")
	WebElement ssn3;
	
	@FindBy(name="ssn4")
	WebElement ssn4;
	
	@FindBy(name="ssn5")
	WebElement ssn5;
	
	@FindBy(name="ssn6")
	WebElement ssn6;
	
	@FindBy(name="customerBean.lastNm")
	WebElement lastname;
	
	@FindBy(name="customerBean.firstNm")
	WebElement firstname;
	
	@FindBy(name="customerBean.addressLn")
	WebElement address;
	
	@FindBy(name="customerBean.city")
	WebElement city;
	
	@FindBy(name="customerBean.stateCd")
	WebElement state_dd;
	
	@FindBy(name="customerBean.postalCd")
	WebElement postalID;
	
	@FindBy(name="customerBean.monthsAtAddress")
	WebElement months_at;
	
	@FindBy(name="phoneNbr1")
	WebElement phoneNbr1;
	
	@FindBy(name="phoneNbr2")
	WebElement phoneNbr2;
	
	@FindBy(name="phoneNbr3")
	WebElement phoneNbr3;
	
	@FindBy(name="customerBean.phoneCd")
	WebElement phone_dd;
	
	@FindBy(name="customerBean.isCustomerEmailQuest")
	WebElement email_check;
	
	@FindBy(name="customerBean.driversLicNbr")
	WebElement photoid;
	
	@FindBy(name="customerBean.driversLicSt")
	WebElement IDState_dd;
	
	@FindBy(name="dlexpiry1")
	WebElement dlexpiry1;
	
	@FindBy(name="dlexpiry2")
	WebElement dlexpiry2;
	
	@FindBy(name="dlexpiry3")
	WebElement dlexpiry3;
	
	@FindBy(name="customerBean.photoIdType")
	WebElement photoTye_dd;
	
	@FindBy(name="customerBean.drivingZipcode")
	WebElement ZipCode;
	
	@FindBy(name="dob1")
	WebElement dob1;
	
	@FindBy(name="dob2")
	WebElement dob2;
	
	@FindBy(name="dob3")
	WebElement dob3;
	
	@FindBy(name="customerBean.incomeCdDisp")
	WebElement income_dd;
	
	@FindBy(name="customerBean.payrollDed")
	WebElement payroll_ded;
	
	@FindBy(name="customerBean.empNmDisp")
	WebElement employer;
	
	@FindBy(name="customerBean.roomEmpStatus")
	WebElement empstatus_dd;
	
	@FindBy(name="workPhoneNbrDisp1")
	WebElement workPhoneNbrDisp1;
	
	@FindBy(name="workPhoneNbrDisp2")
	WebElement workPhoneNbrDisp2;
	
	@FindBy(name="workPhoneNbrDisp3")
	WebElement workPhoneNbrDisp3;
	
	@FindBy(name="customerBean.incomeAmtDisp")
	WebElement net_income;
	
	@FindBy(name="customerBean.grossAmtDisp")
	WebElement gross_income;
	
	@FindBy(name="customerBean.payFreqCdDisp")
	WebElement pay_freq;
	
	@FindBy(name="customerBean.monthlyDate")
	WebElement monthlyDate;
	
	@FindBy(name="rad_semi")
	WebElement rad_semi;
	
	@FindBy(xpath="//input[@value='5' and @id='rad_wk6']")
	WebElement friday;
	
	@FindBy(name="payStubReviewed1")
	WebElement payStubReviewed1;
	
	@FindBy(name="payStubReviewed2")
	WebElement payStubReviewed2;
	
	@FindBy(name="payStubReviewed3")
	WebElement payStubReviewed3;
	
	@FindBy(name="payStubDate1")
	WebElement payStubDate1;
	
	@FindBy(name="payStubDate2")
	WebElement payStubDate2;
	
	@FindBy(name="payStubDate3")
	WebElement payStubDate3;
	
	@FindBy(name="hireDate1")
	WebElement hireDate1;
	
	@FindBy(name="hireDate2")
	WebElement hireDate2;
	
	@FindBy(name="hireDate3")
	WebElement hireDate3;
	
	@FindBy(name="customerBean.directDeposit")
	WebElement directDeposit;
	
	@FindBy(name="statementEndDtDisp1")
	WebElement statementEndDtDisp1;
	
	@FindBy(name="statementEndDtDisp2")
	WebElement statementEndDtDisp2;
	
	@FindBy(name="statementEndDtDisp3")
	WebElement statementEndDtDisp3;
	
	@FindBy(name="customerBean.abaNbrDisp")
	WebElement abaNbrDisp;
	
	@FindBy(name="checkAbaNbrDisp")
	WebElement checkAbaNbrDisp;
	
	@FindBy(name="customerBean.accountNbrDisp")
	WebElement accountNbrDisp;
	
	@FindBy(name="checkAccountNbrDisp")
	WebElement checkAccountNbrDisp;
	
	@FindBy(name="customerBean.contName")
	WebElement ref1lastname;
	
	@FindBy(name="customerBean.contactFirstName")
	WebElement ref1firstname;
	
	@FindBy(name="customerBean.contactrelationDisp")
	WebElement ref1relationship_dd;
	
	@FindBy(name="cphoneNbrDisp1")
	WebElement cphoneNbrDisp1;
	
	@FindBy(name="cphoneNbrDisp2")
	WebElement cphoneNbrDisp2;
	
	@FindBy(name="cphoneNbrDisp3")
	WebElement cphoneNbrDisp3;
	
	@FindBy(name="customerBean.nameDispSummary")
	WebElement ref2lastname;
	
	@FindBy(name="customerBean.referenceFirstNameSummary")
	WebElement ref2firstname;
	
	@FindBy(name="customerBean.relationDispSummary")
	WebElement ref2relationship_dd;
	
	@FindBy(name="refPhoneNbr1")
	WebElement refPhoneNbr1;
	
	@FindBy(name="refPhoneNbr2")
	WebElement refPhoneNbr2;
	
	@FindBy(name="refPhoneNbr3")
	WebElement refPhoneNbr3;
	
	@FindBy(name="bt_Reference")
	WebElement bt_Reference;
	
	@FindBy(name="customerBean.bankrupty")
	WebElement bankrupty_dd;
	
	@FindBy(xpath="//input[@value='Save & Next > ']")
	WebElement save_next_btn;
	
	@FindBy(xpath="//td[@class='subHeading']/b")
	WebElement Customer_num;
	
	@FindBy(xpath="//iframe[@id='bdyLoad']")
	WebElement frame;
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void Registration(){
		utilities=new Utilities();
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:/Selenium WebDriver/QCProject/Reports/RegressionTesting.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("Registration Test");
		utilities.LogintoApplication();
		logger.log(Status.INFO, "Logged into Application");
		String state = prop.getProperty("state_dd");
		String pay_frequency = prop.getProperty("pay_freq");
		
		System.out.println("======== Customer Registration has started ==============");
		driver.switchTo().frame("topFrame");
		logger.log(Status.INFO, "Switched to top frame");
		Borrower.click();
		logger.log(Status.INFO, "Clicked on Borrower");
		driver.switchTo().defaultContent();
		logger.log(Status.INFO, "Came out from Top frame");
		driver.switchTo().frame("mainFrame");
		logger.log(Status.INFO, "Switched to Main frame");
		Registration.click();
		logger.log(Status.INFO, "Clicked on Registration");
		driver.switchTo().frame(frame);
		logger.log(Status.INFO, "Switched to another frame");
		ssn1.sendKeys(prop.getProperty("ssn1"));
		logger.log(Status.INFO, "Entered ssn1");
		ssn2.sendKeys(prop.getProperty("ssn2"));
		logger.log(Status.INFO, "Entered ssn2");
		ssn3.sendKeys(prop.getProperty("ssn3"));
		logger.log(Status.INFO, "Entered ssn3");
		ssn4.sendKeys(prop.getProperty("ssn1"));
		logger.log(Status.INFO, "Confirmed ssn1");
		ssn5.sendKeys(prop.getProperty("ssn2"));
		logger.log(Status.INFO, "Confirmed ssn2");
		ssn6.sendKeys(prop.getProperty("ssn3"));
		logger.log(Status.INFO, "Confirmed ssn3");
		lastname.sendKeys(prop.getProperty("lastname"));
		logger.log(Status.INFO, "Entered last name");
		firstname.sendKeys(prop.getProperty("firstname"));
		logger.log(Status.INFO, "Entered first name");
		address.sendKeys("109 Avenue");
		logger.log(Status.INFO, "Entered address");
		city.sendKeys("Hyd");
		logger.log(Status.INFO, "Entered city");
		Select statedd=new Select(state_dd);
		logger.log(Status.INFO, "Clicked on state_dd");
		statedd.selectByVisibleText(state);
		logger.log(Status.INFO, "Selected state");
		if (state.equalsIgnoreCase("Missouri")) {
			logger.log(Status.INFO, "Selected Missouri");
			postalID.sendKeys("63010");
			logger.log(Status.INFO, "Entered zipcode");
		}		
		else if (state.equalsIgnoreCase("Kansas")) {
			logger.log(Status.INFO, "Selected Kansas");
			postalID.sendKeys("66103");
			logger.log(Status.INFO, "Entered zipcode");
		}
		else if (state.equalsIgnoreCase("Texas")) {
			logger.log(Status.INFO, "Selected Texas");
			postalID.sendKeys("75457");
			logger.log(Status.INFO, "Entered zipcode");
		}
		else if (state.equalsIgnoreCase("Nevada")) {
			logger.log(Status.INFO, "Selected Nevada");
			postalID.sendKeys("89148");
			logger.log(Status.INFO, "Entered zipcode");
		}
		else if (state.equalsIgnoreCase("Illinois")) {
			logger.log(Status.INFO, "Selected Illinois");
			postalID.sendKeys("62462");
			logger.log(Status.INFO, "Entered zipcode");
		}
		else if (state.equalsIgnoreCase("Idaho")) {
			logger.log(Status.INFO, "Selected Idaho");
			postalID.sendKeys("83211");
			logger.log(Status.INFO, "Entered zipcode");
		}
		else if (state.equalsIgnoreCase("Nebraska")) {
			postalID.sendKeys("68106");
		}
		else if (state.equalsIgnoreCase("Louisiana")) {
			postalID.sendKeys("71109");
		}
		else if (state.equalsIgnoreCase("New Mexico")) {
			postalID.sendKeys("87110");
		}
		months_at.sendKeys("15");
		logger.log(Status.INFO, "Entered Months");
		phoneNbr1.sendKeys("300");
		logger.log(Status.INFO, "Entered phoneNbr1");
		phoneNbr2.sendKeys("312");
		logger.log(Status.INFO, "Entered phoneNbr2");
		phoneNbr3.sendKeys("3123");
		logger.log(Status.INFO, "Entered phoneNbr3");
		Select phonedd=new Select(phone_dd);
		logger.log(Status.INFO, "Clicked on phone_dd");
		phonedd.selectByVisibleText("Home");
		logger.log(Status.INFO, "Selected Home");
		email_check.click();
		logger.log(Status.INFO, "Clicked on 'don't have email address' check box");
		photoid.sendKeys(prop.getProperty("photoid"));
		logger.log(Status.INFO, "Entered photoid number");
		Select IDStatedd=new Select(IDState_dd);
		logger.log(Status.INFO, "Clicked on IDState_dd");
		IDStatedd.selectByVisibleText(state);
		logger.log(Status.INFO, "Selected state");
		dlexpiry1.sendKeys("01");
		logger.log(Status.INFO, "Entered ID Expiry date");
		dlexpiry2.sendKeys("01");
		logger.log(Status.INFO, "Entered ID Expiry month");
		dlexpiry3.sendKeys("2030");
		logger.log(Status.INFO, "Entered ID Expiry Year");
		Select photoTyedd=new Select(photoTye_dd);
		logger.log(Status.INFO, "Clicked on photoTye_dd");
		photoTyedd.selectByVisibleText("Driver License");
		logger.log(Status.INFO, "Selected Driver License as ID Proof");
		if (state.equalsIgnoreCase("Missouri")) {
			ZipCode.sendKeys("63010");
		}		
		else if (state.equalsIgnoreCase("Kansas")) {
			ZipCode.sendKeys("66103");
		}
		else if (state.equalsIgnoreCase("Texas")) {
			ZipCode.sendKeys("75457");
		}
		else if (state.equalsIgnoreCase("Nevada")) {
			ZipCode.sendKeys("89148");
		}
		else if (state.equalsIgnoreCase("Illinois")) {
			ZipCode.sendKeys("62462");
		}
		else if (state.equalsIgnoreCase("Idaho")) {
			ZipCode.sendKeys("83211");
		}
		else if (state.equalsIgnoreCase("Nebraska")) {
			ZipCode.sendKeys("68106");
		}
		else if (state.equalsIgnoreCase("Louisiana")) {
			ZipCode.sendKeys("71109");
		}
		else if (state.equalsIgnoreCase("New Mexico")) {
			ZipCode.sendKeys("87110");
		}
		dob1.sendKeys("01");
		logger.log(Status.INFO, "Entered DOB-Date");
		dob2.sendKeys("01");
		logger.log(Status.INFO, "Entered DOB-Month");
		dob3.sendKeys("1980");
		logger.log(Status.INFO, "Entered DOB-Year");
		Select incomedd=new Select(income_dd);
		logger.log(Status.INFO, "Clicked on income_dd");
		incomedd.selectByVisibleText("Salary");
		logger.log(Status.INFO, "Selected Salary as income");
		
		if(payroll_ded.isDisplayed()){
			Select payroll=new Select(payroll_ded);
			payroll.selectByVisibleText("No");
		}
		else{
			System.out.println("Payroll deduction dropdown button is not available for this state..");
		}
		
		/*try {
			Select payroll=new Select(payroll_ded);
			payroll.selectByVisibleText("No");
		} catch (NoSuchElementException e) {
			System.out.println("Payroll deduction dropdown button is not available for this state..");
			e.printStackTrace();
		}*/
		employer.sendKeys("VTL");
		logger.log(Status.INFO, "Entered Employer name");
		Select empstatusdd=new Select(empstatus_dd);
		logger.log(Status.INFO, "Clicked on empstatus_dd");
		empstatusdd.selectByVisibleText("Active");
		logger.log(Status.INFO, "Selected Active as status");
		workPhoneNbrDisp1.sendKeys("523");
		logger.log(Status.INFO, "Entered work phonenumber");
		workPhoneNbrDisp2.sendKeys("564");
		logger.log(Status.INFO, "Entered work phonenumber");
		workPhoneNbrDisp3.sendKeys("7686");
		logger.log(Status.INFO, "Entered work phonenumber");
		net_income.sendKeys(prop.getProperty("net_income"));
		logger.log(Status.INFO, "Entered net_income");
		gross_income.sendKeys(prop.getProperty("gross_income"));
		logger.log(Status.INFO, "Entered gross_income");
		Select payfreq=new Select(pay_freq);
		logger.log(Status.INFO, "Clicked on pay_freq dd");
		payfreq.selectByVisibleText(pay_frequency);
		logger.log(Status.INFO, "Selected pay_frequency");
		if (pay_frequency.equalsIgnoreCase("Monthly")) {
			logger.log(Status.INFO, "Selected Monthly");
			Select monthlyDatedd=new Select(monthlyDate);
			logger.log(Status.INFO, "Clicekd on monthlyDate");
			monthlyDatedd.selectByVisibleText("Last Day");	
			logger.log(Status.INFO, "Selected Last Day");
		}
		else if (pay_frequency.equalsIgnoreCase("Semi-Monthly")){
			logger.log(Status.INFO, "Selected Semi-Monthly");
			rad_semi.click();	
			logger.log(Status.INFO, "Selected pay_frequency cycle");
		}
		else if (pay_frequency.equalsIgnoreCase("Weekly")) {
			logger.log(Status.INFO, "Selected Weekly");
			friday.click();
			logger.log(Status.INFO, "Selected friday");
		}
		else {
			friday.click();
			logger.log(Status.INFO, "Selected friday");
		}
		
		payStubReviewed1.sendKeys("01");
		logger.log(Status.INFO, "Entered payStubReviewed date");
		payStubReviewed2.sendKeys("01");
		logger.log(Status.INFO, "Entered payStubReviewed month");
		payStubReviewed3.sendKeys("2020");
		logger.log(Status.INFO, "Entered payStubReviewed year");
		payStubDate1.sendKeys("01");
		logger.log(Status.INFO, "Entered payStub date");
		payStubDate2.sendKeys("01");
		logger.log(Status.INFO, "Entered payStub month");
		payStubDate3.sendKeys("2020");
		logger.log(Status.INFO, "Entered payStub year");
		hireDate1.sendKeys("01");
		logger.log(Status.INFO, "Entered hire date");
		hireDate2.sendKeys("01");
		logger.log(Status.INFO, "Entered hire month");
		hireDate3.sendKeys("2020");	
		logger.log(Status.INFO, "Entered hire year");
		Select directDepositdd=new Select(directDeposit);
		logger.log(Status.INFO, "Clicked on directDeposit dd");
		directDepositdd.selectByVisibleText("Yes");
		logger.log(Status.INFO, "Selected Yes");
		statementEndDtDisp1.sendKeys("01");
		logger.log(Status.INFO, "Entered statementEnd date");
		statementEndDtDisp2.sendKeys("01");
		logger.log(Status.INFO, "Entered statementEnd month");
		statementEndDtDisp3.sendKeys("2020");
		logger.log(Status.INFO, "Entered statementEnd year");
		abaNbrDisp.sendKeys("111111118");
		logger.log(Status.INFO, "Entered abaNbr");
		checkAbaNbrDisp.sendKeys("111111118");
		logger.log(Status.INFO, "Confirmed abaNbr");
		accountNbrDisp.sendKeys(prop.getProperty("accountNbr"));
		logger.log(Status.INFO, "Entered accountNbr");
		checkAccountNbrDisp.sendKeys(prop.getProperty("accountNbr"));
		logger.log(Status.INFO, "Confirmed accountNbr");
		ref1lastname.sendKeys("Rajni");
		logger.log(Status.INFO, "Entered ref1lastname");
		ref1firstname.sendKeys("Kanth");
		logger.log(Status.INFO, "Entered ref1firstname");
		Select ref1relationshipdd=new Select(ref1relationship_dd);
		logger.log(Status.INFO, "Clicked on ref1relationship_dd");
		ref1relationshipdd.selectByVisibleText("Other");
		logger.log(Status.INFO, "Selected Other");
		cphoneNbrDisp1.sendKeys("321");
		logger.log(Status.INFO, "Entered cphoneNbr");
		cphoneNbrDisp2.sendKeys("546");
		logger.log(Status.INFO, "Entered cphoneNbr");
		cphoneNbrDisp3.sendKeys("8745");
		logger.log(Status.INFO, "Entered cphoneNbr");
		ref2lastname.sendKeys("James");
		logger.log(Status.INFO, "Entered ref2lastname");
		ref2firstname.sendKeys("Watson");
		logger.log(Status.INFO, "Entered ref2firstname");
		Select ref2relationshipdd=new Select(ref2relationship_dd);
		logger.log(Status.INFO, "Clicked on ref2relationship_dd");
		ref2relationshipdd.selectByVisibleText("Other");
		logger.log(Status.INFO, "Selected Other");
		refPhoneNbr1.sendKeys("909");
		logger.log(Status.INFO, "Entered refPhoneNbr1");
		refPhoneNbr2.sendKeys("546");
		logger.log(Status.INFO, "Entered refPhoneNbr2");
		refPhoneNbr3.sendKeys("8721");
		logger.log(Status.INFO, "Entered refPhoneNbr3");
		bt_Reference.click();
		logger.log(Status.INFO, "Clicked on bt_Reference");
		Select bankruptydd=new Select(bankrupty_dd);
		logger.log(Status.INFO, "Clicked on bankrupty_dd");
		bankruptydd.selectByVisibleText("No");
		logger.log(Status.INFO, "Selected No");
		//Operational Services
		driver.findElement(By.id("oprRadioEmailOptOut")).click();
		driver.findElement(By.id("oprRadioAutoCallOptOut")).click();
		//Marketing Services
		driver.findElement(By.id("marRadioEmailOptOut")).click();
		driver.findElement(By.id("marRadioSmsOptOut")).click();
		driver.findElement(By.id("marRadioAutoCallOut")).click();
		driver.findElement(By.id("marRadioMailOptOut")).click();
		
		save_next_btn.click();
		logger.log(Status.INFO, "Clicked on save_next_btn");
		try {
			driver.switchTo().alert().accept();
		} catch (Exception NoAlertPresentException) {
			System.out.println("offo..Alert is not available");
		}
		System.out.println(Customer_num.getText());
		System.out.println("======== Customer Registration has ended ==============");
		logger.log(Status.INFO, "Customer number has printed");
		//extent.flush();
	}

}
