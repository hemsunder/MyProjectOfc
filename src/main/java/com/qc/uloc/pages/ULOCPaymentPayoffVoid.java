package com.qc.uloc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qc.base.TestBase;
import com.qc.utilities.Utilities;

public class ULOCPaymentPayoffVoid extends TestBase{
	
	Utilities utilities;
	
	@FindBy(xpath="//td[contains(text(),'ULOC Loans')]/parent::tr//following-sibling::tr[3]//td//input[@value='Go']")
	WebElement go_btn;
	
	@FindBy(name="transactionList")
	WebElement trans_dd;
	
	@FindBy(name="button")
	WebElement go_btn2;
	
	@FindBy(name="transactionDataBean.tenderType")
	WebElement disbtype_dd;
	
	@FindBy(name="password")
	WebElement password_txtbox;
	
	@FindBy(name="Submit22")
	WebElement finishpaymentvoid_btn;
	
	@FindBy(name="checkyes")
	WebElement yes_btn;
	
	public ULOCPaymentPayoffVoid(){
		PageFactory.initElements(driver, this);
	}
	
	public void paymentvoidbyOriginalTender(){
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		utilities.transactionsinitialization();
		go_btn.click();
		Select trandd=new Select(trans_dd);
		trandd.selectByVisibleText("Void");
		go_btn2.click();
		Select disbdd=new Select(disbtype_dd);
		disbdd.selectByVisibleText("Original Tender");
		password_txtbox.sendKeys(prop.getProperty("transactions_password"));
		finishpaymentvoid_btn.click();
		yes_btn.click();
	}

	
	public void paymentvoidbyCash(){
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		utilities.transactionsinitialization();
		go_btn.click();
		Select trandd=new Select(trans_dd);
		trandd.selectByVisibleText("Void");
		go_btn2.click();
		Select disbdd=new Select(disbtype_dd);
		disbdd.selectByVisibleText("Cash");
		password_txtbox.sendKeys(prop.getProperty("transactions_password"));
		finishpaymentvoid_btn.click();
		yes_btn.click();
	}
}
