package com.qc.uloc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.qc.base.TestBase;
import com.qc.utilities.Utilities;

public class NewULOC extends TestBase {
	Utilities utilities;
	double b=0;
	double c=0;
	
	@FindBy(xpath="//td[contains(text(),'Line of Credit')]/following-sibling::td//input[@name='prodSel']")
	WebElement KSLineofCredit;
	
	@FindBy(id="LoanButtonId")
	WebElement newloan_btn;
	
	@FindBy(name="advanceRequestBean.loanAmount")
	WebElement locamt_txtbox;
	
	@FindBy(name="advanceRequestBean.paymentCollateralType")
	WebElement paymentcolltype_dd;
	
	@FindBy(name="advanceRequestBean.disbursementType")
	WebElement disbtype_dd1;
	
	@FindBy(name="advanceRequestBean.disbAmtFirst")
	WebElement disbamt_txtbox1;
	
	@FindBy(name="advanceRequestBean.disbursementTypeSecond")
	WebElement disbtype_dd2;
	
	@FindBy(name="advanceRequestBean.disbAmtSecond")
	WebElement disbamt_txtbox2;
	
	@FindBy(name="advanceRequestBean.courtesyCallFlag")
	WebElement courtesycall_dd;
	
	@FindBy(name="advanceRequestBean.checkopt")
	WebElement noofchecks_dd;
	
	@FindBy(name="advanceRequestBean.isCustCheck1")
	WebElement check_chckbox;
	
	@FindBy(name="advanceRequestBean.checkAmt1")
	WebElement checkamnt_txtbox;
	
	@FindBy(name="requestBean.password")
	WebElement pwd_txtbox;
	
	@FindBy(name="finishadvance")
	WebElement finish_btn;
	
	@FindBy(name="advanceRequestBean.advanceAmt")
	WebElement LOC_btn;
	
	@FindBy(xpath="//input[@value='Yes']")
	WebElement finalyes_btn;
	
	@FindBy(xpath="//input[@value='OK']")
	WebElement finalok_btn;
	
	@FindBy(xpath="//input[@value='Add Card']")
	WebElement addcard_btn;
	
	public NewULOC(){
		PageFactory.initElements(driver, this);
	}

	
	public void NewULOCByACH(String loanamt){
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		utilities.newloaninitialization();
		KSLineofCredit.click();
		newloan_btn.click();
		
		double a=Double.parseDouble(loanamt);
		b=a/2;
		c=a-b;
		String cash_amt=Double.toString(b);
		String check_amnt=Double.toString(c);
		locamt_txtbox.sendKeys(Keys.CONTROL , "a");
		locamt_txtbox.sendKeys(Keys.DELETE, loanamt, Keys.TAB );
		utilities.clickon(driver, paymentcolltype_dd, 20);
		Select paycolldd=new Select(paymentcolltype_dd);
		paycolldd.selectByVisibleText("ACH");
		Select disb1=new Select(disbtype_dd1);
		disb1.selectByVisibleText("Cash");
		disbamt_txtbox1.sendKeys(cash_amt);
		Select disb2=new Select(disbtype_dd2);
		disb2.selectByVisibleText("Check");
		disbamt_txtbox2.sendKeys(check_amnt);
		Select ccall=new Select(courtesycall_dd);
		ccall.selectByVisibleText("No");
		Select nocheck=new Select(noofchecks_dd);
		nocheck.selectByVisibleText("1");
		check_chckbox.click();
		checkamnt_txtbox.sendKeys(check_amnt);
		pwd_txtbox.sendKeys(prop.getProperty("transactions_password"));
		finish_btn.click();
		finalyes_btn.click();
		finalok_btn.click();
	}
	
	public void NewULOCByDebitCard(String loanamt){
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		utilities.newloaninitialization();
		KSLineofCredit.click();
		newloan_btn.click();
		
		double a=Double.parseDouble(loanamt);
		b=a/2;
		c=a-b;
		String cash_amt=Double.toString(b);
		String check_amnt=Double.toString(c);
		locamt_txtbox.sendKeys(Keys.CONTROL , "a");
		locamt_txtbox.sendKeys(Keys.DELETE, loanamt, Keys.TAB );
		utilities.clickon(driver, paymentcolltype_dd, 20);
		Select paycolldd=new Select(paymentcolltype_dd);
		paycolldd.selectByVisibleText("DEBIT CARD");
		//utilities.debitcardfilling();
		addcard_btn.click();
		utilities.invisible(driver, addcard_btn, 30);
		Select disb1=new Select(disbtype_dd1);
		disb1.selectByVisibleText("Cash");
		disbamt_txtbox1.sendKeys(cash_amt);
		Select disb2=new Select(disbtype_dd2);
		disb2.selectByVisibleText("Check");
		disbamt_txtbox2.sendKeys(check_amnt);
		Select ccall=new Select(courtesycall_dd);
		ccall.selectByVisibleText("No");
		Select nocheck=new Select(noofchecks_dd);
		nocheck.selectByVisibleText("1");
		check_chckbox.click();
		checkamnt_txtbox.sendKeys(check_amnt);
		pwd_txtbox.sendKeys(prop.getProperty("transactions_password"));
		finish_btn.click();
		finalyes_btn.click();
		finalok_btn.click();
	}
	
	public void NewULOCByACH(){
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		utilities.newloaninitialization();
		KSLineofCredit.click();
		newloan_btn.click();
		
		String loan_amnt=LOC_btn.getAttribute("value");
		double a=Double.parseDouble(loan_amnt);
		b=a/2;
		c=a-b;
		String cash_amt=Double.toString(b);
		String check_amnt=Double.toString(c);
		
		Select paycolldd=new Select(paymentcolltype_dd);
		paycolldd.selectByVisibleText("ACH");
		Select disb1=new Select(disbtype_dd1);
		disb1.selectByVisibleText("Cash");
		disbamt_txtbox1.sendKeys(cash_amt);
		Select disb2=new Select(disbtype_dd2);
		disb2.selectByVisibleText("Check");
		disbamt_txtbox2.sendKeys(check_amnt);
		Select ccall=new Select(courtesycall_dd);
		ccall.selectByVisibleText("No");
		Select nocheck=new Select(noofchecks_dd);
		nocheck.selectByVisibleText("1");
		check_chckbox.click();
		checkamnt_txtbox.sendKeys(check_amnt);
		pwd_txtbox.sendKeys(prop.getProperty("transactions_password"));
		finish_btn.click();
		finalyes_btn.click();
		finalok_btn.click();
	}
	
	
	public void NewULOCByDebitCard() throws Exception{
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		utilities.newloaninitialization();
		KSLineofCredit.click();
		newloan_btn.click();
		String loan_amnt=LOC_btn.getAttribute("value");
		double a=Double.parseDouble(loan_amnt);
		b=a/2;
		c=a-b;
		String cash_amt=Double.toString(b);
		String check_amnt=Double.toString(c);
		
		Select paycolldd=new Select(paymentcolltype_dd);
		paycolldd.selectByVisibleText("DEBIT CARD");
		utilities.debitcardfilling();
		addcard_btn.click();
		utilities.invisible(driver, addcard_btn, 30);
		Select disb1=new Select(disbtype_dd1);
		disb1.selectByVisibleText("Cash");
		disbamt_txtbox1.sendKeys(cash_amt);
		Select disb2=new Select(disbtype_dd2);
		disb2.selectByVisibleText("Check");
		disbamt_txtbox2.sendKeys(check_amnt);
		Select ccall=new Select(courtesycall_dd);
		ccall.selectByVisibleText("No");
		Select nocheck=new Select(noofchecks_dd);
		nocheck.selectByVisibleText("1");
		check_chckbox.click();
		checkamnt_txtbox.sendKeys(check_amnt);
		pwd_txtbox.sendKeys(prop.getProperty("transactions_password"));
		finish_btn.click();
		finalyes_btn.click();
		finalok_btn.click();
	}
	
}
