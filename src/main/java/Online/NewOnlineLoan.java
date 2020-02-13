package Online;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.qc.base.TestBase;
import com.qc.utilities.Utilities;


public class NewOnlineLoan extends TestBase {
	Utilities utilities;
	//String name;
	
	@FindBy(xpath="//a[text()='QA']")
	WebElement QA_Btn;
	
	@FindBy(xpath="//a[text()='Pre-Prod']")
	WebElement Preprod_Btn;
	
	@FindBy(xpath="//a[text()='UAT']")
	WebElement UAT_btn;
	
	@FindBy(xpath="//select[@class='form-control']")
	WebElement selectstate_dd;
	
	@FindBy(xpath="//button[@onclick='StateConfirmation.RedirectToState()']")
	WebElement Continue_btn;
	
	@FindBy(xpath="//div[@class='logInMenu']")
	WebElement Login_menu;
	
	@FindBy(xpath="//a[text()='Store Customer Setup']")
	WebElement customer_setup_link;
	
	@FindBy(xpath="//a[text()='START LOAN APPLICATION ']")
	WebElement startloan;
	
	@FindBy(id="applyEmail")
	WebElement email_txtbox;
	
	@FindBy(id="applyEmail1")
	WebElement confirmemail_txtbox;
	
	@FindBy(id="passId")
	WebElement password_txtbox;
	
	@FindBy(id="confirmPassword")
	WebElement confirmPassword_txtbox;
	
	@FindBy(id="SSN1")
	WebElement SSN1_txtbox;
	
	@FindBy(id="SSN2")
	WebElement SSN2_txtbox;
	
	@FindBy(id="SSN3")
	WebElement SSN3_txtbox;
	
	@FindBy(id="question0")
	WebElement question0_dd;
	
	@FindBy(id="question1")
	WebElement question1_dd;
	
	@FindBy(id="question2")
	WebElement question2_dd;
	
	@FindBy(id="answer0")
	WebElement answer0_txtbox;
	
	@FindBy(id="answer1")
	WebElement answer1_txtbox;
	
	@FindBy(id="answer2")
	WebElement answer2_txtbox;
	
	@FindBy(xpath="//button[@value='next']")
	WebElement next_btn;
	
	@FindBy(id="pFirstName")
	WebElement FirstName_txtbox;
	
	@FindBy(id="pMiddleInitial")
	WebElement MiddleInitial_txtbox;
	
	@FindBy(id="pLastName")
	WebElement LastName_txtbox;
	
	@FindBy(id="optionMilitary_1")
	WebElement optionMilitary_1_radiobtn;
	
	@FindBy(id="pPhone")
	WebElement pPhone_txtbox;
	
	@FindBy(id="pPrimaryPhone")
	WebElement pPrimaryPhone_dd;
	
	@FindBy(id="chk2_mk_n")
	WebElement chk2_radiobtn;
	
	@FindBy(id="pAddress")
	WebElement pAddress_txtbox;
	
	@FindBy(id="pCity")
	WebElement pCity_txtbox;
	
	@FindBy(id="pStateName")
	WebElement pStateName_dd;
	
	@FindBy(id="pPostalCode")
	WebElement pPostalCode_txtbox;
	
	@FindBy(id="pHomeType")
	WebElement pHomeType_dd;
	
	@FindBy(id="pTimeAtAddress")
	WebElement pTimeAtAddress_dd;
	
	@FindBy(name="pDateOfBirthMonth")
	WebElement pDateOfBirthMonth_tb;
	
	@FindBy(name="pDateOfBirthDay")
	WebElement pDateOfBirthDay_tb;
	
	@FindBy(name="pDateOfBirthYear")
	WebElement pDateOfBirthYear_tb;
	
	@FindBy(name="pidentification")
	WebElement pidentification_dd;
	
	@FindBy(name="pId")
	WebElement pId_dd;
	
	@FindBy(name="garnishDateMonth")
	WebElement garnishDateMonth_td;
	
	@FindBy(name="garnishDateDay")
	WebElement garnishDateDay_td;
	
	@FindBy(name="garnishDateYear")
	WebElement garnishDateYear_td;
	
	@FindBy(name="fname")
	WebElement fname_td;
	
	@FindBy(name="lname")
	WebElement lname_td;
	
	@FindBy(id="relation1")
	WebElement relation1_dd;
	
	@FindBy(name="phone")
	WebElement phone_td;
	
	@FindBy(name="firstName")
	WebElement firstName_td;
	
	@FindBy(name="lastName")
	WebElement lastName_td;
	
	@FindBy(name="relation2")
	WebElement relation2_dd;
	
	@FindBy(name="phone1")
	WebElement phone1_td;
	
	@FindBy(name="chk3")
	WebElement chk3_td;
	
	@FindBy(name="chk4")
	WebElement chk4_td;
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement continue_btn;
	
	@FindBy(name="iIncomeType")
	WebElement iIncomeType_dd;
	
	@FindBy(name="iEmployerName")
	WebElement iEmployerName_tb;
	
	@FindBy(name="iIndustryType")
	WebElement iIndustryType_dd;
	
	@FindBy(name="iEmployerPhone")
	WebElement iEmployerPhone_tb;
	
	@FindBy(name="iSelectedTimeAtEmployer")
	WebElement iSelectedTimeAtEmployer_dd;
	
	@FindBy(name="iPayPeriodType")
	WebElement iPayPeriodType_dd;
	
	@FindBy(name="iPayMethodType")
	WebElement iPayMethodType_dd;
	
	@FindBy(xpath="//div[@class='col-sm-2 col-md-2 col-lg-1']//input")
	WebElement incomeRadio10;
	
	@FindBy(name="income1st0")
	WebElement income1st0_dd;
	
	@FindBy(name="iGrossPay")
	WebElement iGrossPay_tb;
	
	@FindBy(name="iNetPay")
	WebElement iNetPay_tb;
	
	@FindBy(id="addInc")
	WebElement addInc_btn;
	
	@FindBy(name="disbType")
	WebElement disbType_dd;
	
	@FindBy(name="fAccountType")
	WebElement fAccountType_dd;
	
	@FindBy(name="fRoutingNumber")
	WebElement fRoutingNumber_tb;
	
	@FindBy(name="fAccountNumber")
	WebElement fAccountNumber_tb;
	
	@FindBy(name="fAccountNumberConfirm")
	WebElement fAccountNumberConfirm_tb;
	
	@FindBy(id="incomeSubmitBtn")
	WebElement incomeSubmitBtn_btn;
	
	@FindBy(xpath="//div[@id='scrollDiv1']")
	WebElement end;
	
	@FindBy(xpath="//span[@id='licenName2']")
	WebElement table1scroll;
	
	@FindBy(xpath="//div[@id='scrollDiv2']")
	WebElement end2;
	
	@FindBy(xpath="//td[text()='Joint Marketing']")
	WebElement table2scroll;
		
	@FindBy(name="rRepaymentMethodType")
	WebElement RepaymentMethod_dd;
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement Continuee_btn;
	
	@FindBy(id="rad1")
	WebElement PaydayLoanamnt_rdbtn;
	
	@FindBy(xpath="//button[@id='productSelectBtn']")
	WebElement next_btnn;
	
	/*@FindBy(id="custDocRadio")
	WebElement YouCanEmailTheInformation_rbtn;*/
	
	@FindBy(xpath="//div//input[@value='3']")
	WebElement YouCanEmailTheInformation_rbtn;
	
	@FindBy(name="aEmailVerificationCode")
	WebElement EmailVerificationCode;
	
	@FindBy(id="confirm")
	WebElement confirm_btn;
	
	@FindBy(name="SignatureRequired7")
	WebElement SignatureRequired7;
	
	/*@FindBy(xpath="//input[@id='confirm']")
	WebElement text;*/
	
	@FindBy(name="SignatureRequired8")
	WebElement SignatureRequired8;
	
	@FindBy(id="productSubmitBtn")
	WebElement productSubmitBtn;
	
	@FindBy(name="SignatureRequired0")
	WebElement esignname1;
	
	@FindBy(name="SignatureRequired1")
	WebElement esignname2;
	
	@FindBy(xpath="//span[@id='appNo']")
	WebElement loangenerated;
	
	@FindBy(id="getLoanNowButton")
	WebElement GetLoanNow;
	
	public NewOnlineLoan(){
		PageFactory.initElements(driver, this);
	}
	
	public void newloanforMO() throws Exception {
		utilities=new Utilities();
		driver.get(prop.getProperty("url"));
		//QA_Btn.click();
		//Preprod_Btn.click();
		Thread.sleep(5000);
		UAT_btn.click();
		Select statedd=new Select(selectstate_dd);
		statedd.selectByVisibleText("Missouri");
		Continue_btn.click();
		//Login_menu.click();
		//customer_setup_link.click();
		startloan.click();
		email_txtbox.sendKeys(prop.getProperty("email_id"));
		confirmemail_txtbox.sendKeys(prop.getProperty("email_id"));
		password_txtbox.sendKeys(prop.getProperty("online_password"));
		confirmPassword_txtbox.sendKeys(prop.getProperty("online_password"));
		SSN1_txtbox.sendKeys(prop.getProperty("ssn1"));
		SSN2_txtbox.sendKeys(prop.getProperty("ssn2"));
		SSN3_txtbox.sendKeys(prop.getProperty("ssn3"));
		String firstlastname = prop.getProperty("firstname") + prop.getProperty("lastname");
		System.out.println(firstlastname);
		
		Select q0=new Select(question0_dd);
		q0.selectByIndex(1);
		answer0_txtbox.sendKeys(prop.getProperty("security_answer0"));
		Select q1=new Select(question1_dd);
		q1.selectByIndex(2);
		answer1_txtbox.sendKeys(prop.getProperty("security_answer1"));
		Select q2=new Select(question2_dd);
		q2.selectByIndex(3);
		answer2_txtbox.sendKeys(prop.getProperty("security_answer2"));
		next_btn.click();
		
		FirstName_txtbox.sendKeys(prop.getProperty("firstname"));
		LastName_txtbox.sendKeys(prop.getProperty("lastname"));
		optionMilitary_1_radiobtn.click();
		pPhone_txtbox.sendKeys(prop.getProperty("pPhone"));
		Select phndd=new Select(pPrimaryPhone_dd);
		phndd.selectByVisibleText("Home");
		chk2_radiobtn.click();
		pAddress_txtbox.sendKeys("109 avenue");
		pCity_txtbox.sendKeys("hyd");
		Select stdd=new Select(pStateName_dd);
		stdd.selectByVisibleText("Missouri");
		pPostalCode_txtbox.sendKeys("63010");
		Select hometypdd=new Select(pHomeType_dd);
		hometypdd.selectByVisibleText("Own");
		Select timeatpdd=new Select(pTimeAtAddress_dd);
		timeatpdd.selectByValue("24");
		pDateOfBirthMonth_tb.sendKeys("01");
		pDateOfBirthDay_tb.sendKeys("01");
		pDateOfBirthYear_tb.sendKeys("1980");
		Select iddd=new Select(pidentification_dd);
		iddd.selectByVisibleText("Driver License");
		pId_dd.sendKeys(prop.getProperty("photoid"));
		garnishDateMonth_td.sendKeys("01");
		garnishDateDay_td.sendKeys("01");
		garnishDateYear_td.sendKeys("2030");
		fname_td.sendKeys("rajni");
		lname_td.sendKeys("kanth");
		Select relationdd=new Select(relation1_dd);
		relationdd.selectByValue("OTH");
		phone_td.sendKeys("2050205021");
		firstName_td.sendKeys("virat");
		lastName_td.sendKeys("kohli");
		Select relation2dd=new Select(relation2_dd);
		relation2dd.selectByValue("OTH");
		phone1_td.sendKeys("8495875498");
		end.click();
		utilities.scrollintoview(driver, table1scroll);
		chk3_td.click();
		end2.click();
		utilities.scrollintoview(driver, table2scroll);
		chk4_td.click();
		continue_btn.click();
		Select incomedd=new Select(iIncomeType_dd);
		incomedd.selectByVisibleText("Salary");
		iEmployerName_tb.sendKeys("VTL");
		Select industrydd=new Select(iIndustryType_dd);
		industrydd.selectByVisibleText("IT/Software/Systems/Engineering");
		iEmployerPhone_tb.sendKeys("3265987845");
		Select timeatempdd=new Select(iSelectedTimeAtEmployer_dd);
		timeatempdd.selectByValue("9");
		Select payfreqdd=new Select(iPayPeriodType_dd);
		payfreqdd.selectByValue("MON");
		Select paymethoddd=new Select(iPayMethodType_dd);
		paymethoddd.selectByValue("1");
		Thread.sleep(2000);
		incomeRadio10.click();
		Select income1st0dd=new Select(income1st0_dd);
		income1st0dd.selectByValue("99");
		iGrossPay_tb.sendKeys(prop.getProperty("gross_income"));
		iNetPay_tb.sendKeys(prop.getProperty("net_income"));
		addInc_btn.click();
		Select disbTypedd=new Select(disbType_dd);
		disbTypedd.selectByVisibleText("ACH / Electronic Bank Transfer");
		Select fAccountTypedd=new Select(fAccountType_dd);
		fAccountTypedd.selectByVisibleText("Savings");
		fRoutingNumber_tb.sendKeys("111111118");
		fAccountNumber_tb.sendKeys(prop.getProperty("accountNbr"));
		fAccountNumberConfirm_tb.sendKeys(prop.getProperty("accountNbr"));
		incomeSubmitBtn_btn.click();
		Select RepaymentMethoddd=new Select(RepaymentMethod_dd);
		//RepaymentMethoddd.selectByVisibleText("DEBIT CARD");
		Thread.sleep(2000);
		RepaymentMethoddd.selectByVisibleText("ACH");
		utilities.clickon(driver, fAccountNumberConfirm_tb, 30);
		Continuee_btn.click();
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		PaydayLoanamnt_rdbtn.click();
		next_btnn.click();
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Thread.sleep(40000);
		YouCanEmailTheInformation_rbtn.click();
		String url="jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1";
		String username="QCHPROD_050819";
		String password="QCHPROD_050819";
		String query="SELECT PASS_CODE FROM BO_PASSCODE WHERE EMAIL_ID='james6015@gmail.com'";
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection(url, username, password);
		Statement st=con.createStatement();
		ResultSet rs= st.executeQuery(query);
		while(rs.next()){
		String code=rs.getString(1);
		System.out.println(code);
		EmailVerificationCode.sendKeys(code);
		}
		st.close();
		con.close();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		confirm_btn.click();
		SignatureRequired7.click();
		Thread.sleep(5000);
		SignatureRequired8.click();
		Thread.sleep(5000);
		productSubmitBtn.click();
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		Thread.sleep(30000);
		List<WebElement> list = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int i=0; i<list.size(); i++){
			list.get(i).click();
		}
		esignname1.sendKeys(firstlastname);
		esignname2.sendKeys(firstlastname);
		GetLoanNow.click();
		String loan_num = loangenerated.getText();
		System.out.println(loan_num);
		driver.findElement(By.xpath("//a[@id='das' and @class='hide-menu']")).click();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
	
	@FindBy(name="Username")
	WebElement username_tb;
	
	@FindBy(name="Password")
	WebElement password_tb;
	
	@FindBy(id="loginbtn")
	WebElement loginbtn;
	
	public void OnlineLogin(){
		utilities=new Utilities();
		
		Preprod_Btn.click();
		Select statedd=new Select(selectstate_dd);
		statedd.selectByVisibleText("Missouri");
		Continue_btn.click();
		Login_menu.click();
		customer_setup_link.click();
		Login_menu.click();
		username_tb.sendKeys(prop.getProperty("email_id"));
		password_tb.sendKeys(prop.getProperty("online_password"));
		loginbtn.click();
		
	}
	
	@FindBy(name="FirstName1")
	WebElement FirstName1;
	
	@FindBy(name="LastName1")
	WebElement LastName1;
	
	@FindBy(id="pSSN1")
	WebElement pSSN1;
	
	@FindBy(id="pSSN2")
	WebElement pSSN2;
	
	@FindBy(id="pSSN3")
	WebElement pSSN3;
	
	@FindBy(id="pdob1")
	WebElement pdob1;
	
	@FindBy(id="pdob2")
	WebElement pdob2;
	
	@FindBy(id="pdob3")
	WebElement pdob3;
	
	@FindBy(name="ZipCode")
	WebElement ZipCode;
	
	@FindBy(name="EmailAddress")
	WebElement EmailAddress;
	
	@FindBy(name="PasswordVal")
	WebElement PasswordVal;
	
	@FindBy(name="PasswordConfirmation")
	WebElement PasswordConfirmation;
	
	@FindBy(id="submitOnBoarding")
	WebElement subbmitt;
	
	public void StoreSetup() throws Exception{
		utilities=new Utilities();
		driver.get("https://qclnlocal.qfund.net:8090/");
		Preprod_Btn.click();
		Select statedd=new Select(selectstate_dd);
		statedd.selectByVisibleText("Missouri");
		Continue_btn.click();
		Login_menu.click();
		customer_setup_link.click();
		FirstName1.sendKeys(prop.getProperty("firstname"));
		LastName1.sendKeys(prop.getProperty("lastname"));
		pSSN1.sendKeys(prop.getProperty("ssn1"));
		pSSN2.sendKeys(prop.getProperty("ssn2"));
		pSSN3.sendKeys(prop.getProperty("ssn3"));
		pdob1.sendKeys("01");
		pdob2.sendKeys("01");
		pdob1.sendKeys("1980");
		ZipCode.sendKeys("63010");
		EmailAddress.sendKeys(prop.getProperty("email_id"));
		PasswordVal.sendKeys("Qfund@123");
		PasswordConfirmation.sendKeys("Qfund@123");
		Select q0=new Select(question0_dd);
		q0.selectByIndex(1);
		answer0_txtbox.sendKeys(prop.getProperty("security_answer0"));
		Select q1=new Select(question1_dd);
		q1.selectByIndex(2);
		answer1_txtbox.sendKeys(prop.getProperty("security_answer1"));
		Select q2=new Select(question2_dd);
		q2.selectByIndex(3);
		answer2_txtbox.sendKeys(prop.getProperty("security_answer2"));
		subbmitt.click();
		Thread.sleep(5000);
		subbmitt.click();
		
		
		
	}
	
	
}
