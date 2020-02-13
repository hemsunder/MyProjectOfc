package com.qc.uloc.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qc.base.TestBase;
import com.qc.utilities.Utilities;

public class ULOCPayment extends TestBase{
	Utilities utilities;
	
	@FindBy(xpath="//td[contains(text(),'ULOC Loans')]/parent::tr//following-sibling::tr[3]//td//input[@value='Go']")
	WebElement go_btn;
	
	@FindBy(name="transactionList")
	WebElement trans_dd;
	
	@FindBy(name="button")
	WebElement go_btn2;
	
	@FindBy(name="requestBean.paymentAmt")
	WebElement payment_txtbox;
	
	@FindBy(name="requestBean.tenderType")
	WebElement tendertype_dd;
	
	@FindBy(name="requestBean.transactionDataBean.ccmoNbrFirst")
	WebElement ccmo_txtbox;
	
	@FindBy(name="requestBean.tenderAmt")
	WebElement tenderamnt_txtbox;
	
	@FindBy(name="password")
	WebElement password_txtbox;
	
	@FindBy(name="Submit22")
	WebElement finishpayment_btn;
	
	@FindBy(name="checkyes")
	WebElement yes_btn;
	
	public ULOCPayment(){
		PageFactory.initElements(driver, this);
	}
	
	public void paymentbyCash(String payamnt){
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		utilities.transactionsinitialization();
		go_btn.click();
		Select trandd=new Select(trans_dd);
		trandd.selectByVisibleText("Payments");
		go_btn2.click();
		payment_txtbox.sendKeys(Keys.CONTROL, "a");
		payment_txtbox.sendKeys(Keys.DELETE, payamnt, Keys.TAB);
		Select tendd=new Select(tendertype_dd);
		tendd.selectByVisibleText("Cash");
		tenderamnt_txtbox.sendKeys(payamnt);
		password_txtbox.sendKeys(prop.getProperty("transactions_password"));
		finishpayment_btn.click();
		yes_btn.click();
	}
	
	public void paymentbyCashiersCheck(String payamnt){
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		utilities.transactionsinitialization();
		go_btn.click();
		Select trandd=new Select(trans_dd);
		trandd.selectByVisibleText("Payments");
		go_btn2.click();
		payment_txtbox.sendKeys(Keys.CONTROL, "a");
		payment_txtbox.sendKeys(Keys.DELETE, payamnt, Keys.TAB);
		Select tendd=new Select(tendertype_dd);
		tendd.selectByVisibleText("Cashiers Check");
		ccmo_txtbox.sendKeys(prop.getProperty("ccmo_num"));
		tenderamnt_txtbox.sendKeys(payamnt);
		password_txtbox.sendKeys(prop.getProperty("transactions_password"));
		finishpayment_btn.click();
		yes_btn.click();
	}
	
	public void paymentbyMoneyOrder(String payamnt){
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		utilities.transactionsinitialization();
		go_btn.click();
		Select trandd=new Select(trans_dd);
		trandd.selectByVisibleText("Payments");
		go_btn2.click();
		payment_txtbox.sendKeys(Keys.CONTROL, "a");
		payment_txtbox.sendKeys(Keys.DELETE, payamnt, Keys.TAB);
		Select tendd=new Select(tendertype_dd);
		tendd.selectByVisibleText("Money Order");
		ccmo_txtbox.sendKeys(prop.getProperty("ccmo_num"));
		tenderamnt_txtbox.sendKeys(payamnt);
		password_txtbox.sendKeys(prop.getProperty("transactions_password"));
		finishpayment_btn.click();
		yes_btn.click();
	}
	
	public void paymentbyDebitCard(String payamnt){
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		utilities.transactionsinitialization();
		go_btn.click();
		Select trandd=new Select(trans_dd);
		trandd.selectByVisibleText("Payments");
		go_btn2.click();
		payment_txtbox.sendKeys(Keys.CONTROL, "a");
		payment_txtbox.sendKeys(Keys.DELETE, payamnt, Keys.TAB);
		Select tendd=new Select(tendertype_dd);
		tendd.selectByVisibleText("Debit Card");
		//utilities.debitcardfillingforpayments();
		tenderamnt_txtbox.sendKeys(payamnt);
		password_txtbox.sendKeys(prop.getProperty("transactions_password"));
		finishpayment_btn.click();
		yes_btn.click();
	}

}
