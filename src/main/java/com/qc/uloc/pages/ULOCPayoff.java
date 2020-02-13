package com.qc.uloc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qc.base.TestBase;
import com.qc.utilities.Utilities;

public class ULOCPayoff extends TestBase{
	Utilities utilities;
	
	@FindBy(xpath="//td[contains(text(),'ULOC Loans')]/parent::tr//following-sibling::tr[3]//td//input[@value='Go']")
	WebElement go_btn;
	
	@FindBy(name="transactionList")
	WebElement trans_dd;
	
	@FindBy(name="button")
	WebElement go_btn2;
	
	@FindBy(name="payOffAmount")
	WebElement payOffAmount_value;
	
	@FindBy(name="tenderType")
	WebElement tendertpe_dd;
	
	@FindBy(name="tenderAmount")
	WebElement tenderAmount_txtbox;
	
	@FindBy(name="password")
	WebElement password_txtbox;
	
	@FindBy(name="Submit22")
	WebElement finishpayment_btn;
	
	@FindBy(name="checkyes")
	WebElement yes_btn;
	
	@FindBy(name="ccmoNbrFirst")
	WebElement ccmo_txtbox;

	public ULOCPayoff(){
		PageFactory.initElements(driver, this);
	}
	
	public void payoffbycash(){
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		utilities.transactionsinitialization();
		go_btn.click();
		Select trandd=new Select(trans_dd);
		trandd.selectByVisibleText("PayOff");
		go_btn2.click();
		String payoff_amnt=payOffAmount_value.getAttribute("value");
		Select tpe=new Select(tendertpe_dd);
		tpe.selectByVisibleText("Cash");
		tenderAmount_txtbox.sendKeys(payoff_amnt);
		password_txtbox.sendKeys(prop.getProperty("transactions_password"));
		finishpayment_btn.click();
		yes_btn.click();
	}
	
	public void payoffbyCCK(){
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		utilities.transactionsinitialization();
		go_btn.click();
		Select trandd=new Select(trans_dd);
		trandd.selectByVisibleText("PayOff");
		go_btn2.click();
		String payoff_amnt=payOffAmount_value.getAttribute("value");
		Select tpe=new Select(tendertpe_dd);
		tpe.selectByVisibleText("Cashiers Check");
		ccmo_txtbox.sendKeys(prop.getProperty("ccmo_num"));
		tenderAmount_txtbox.sendKeys(payoff_amnt);
		password_txtbox.sendKeys(prop.getProperty("transactions_password"));
		finishpayment_btn.click();
		yes_btn.click();
	}
	
	public void payoffbyMO(){
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		utilities.transactionsinitialization();
		go_btn.click();
		Select trandd=new Select(trans_dd);
		trandd.selectByVisibleText("PayOff");
		go_btn2.click();
		String payoff_amnt=payOffAmount_value.getAttribute("value");
		Select tpe=new Select(tendertpe_dd);
		tpe.selectByVisibleText("Money Order");
		ccmo_txtbox.sendKeys(prop.getProperty("ccmo_num"));
		tenderAmount_txtbox.sendKeys(payoff_amnt);
		password_txtbox.sendKeys(prop.getProperty("transactions_password"));
		finishpayment_btn.click();
		yes_btn.click();
	}
	
}
