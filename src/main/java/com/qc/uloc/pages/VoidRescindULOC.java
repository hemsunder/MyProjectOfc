package com.qc.uloc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.qc.base.TestBase;
import com.qc.utilities.Utilities;

public class VoidRescindULOC extends TestBase{
	
	Utilities utilities;
		
	@FindBy(xpath="//td[contains(text(),'ULOC Loans')]/parent::tr//following-sibling::tr[3]//td//input[@value='Go']")
	WebElement go_btn;
	
	@FindBy(name="transactionList")
	WebElement trans_dd;
	
	@FindBy(name="button")
	WebElement go_btn2;
	
	@FindBy(name="htmlPayAmt")
	WebElement lnamnt;
	
	@FindBy(name="transactionDataBean.tenderAmtFirst")
	WebElement tenderamnt_txtbox;
	
	@FindBy(name="transactionDataBean.tenderTypeFirst")
	WebElement tendertype_dd;
	
	@FindBy(name="password")
	WebElement password_txtbox;
	
	@FindBy(name="Submit22")
	WebElement voiloan_btn;
	
	@FindBy(xpath="//input[@value='Ok']")
	WebElement finalok_btn;
	
	public VoidRescindULOC(){
		PageFactory.initElements(driver, this);
	}
	
	public void voidulocbyOriginaltender(){
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		utilities.transactionsinitialization();
		go_btn.click();
		Select trandd=new Select(trans_dd);
		trandd.selectByVisibleText("Void");
		go_btn2.click();
		Select ttpe=new Select(tendertype_dd);
		ttpe.selectByVisibleText("Original Tender");
		password_txtbox.sendKeys(prop.getProperty("transactions_password"));
		voiloan_btn.click();
		finalok_btn.click();
	}
	
	public void voidulocbycash(){
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		utilities.transactionsinitialization();
		go_btn.click();
		Select trandd=new Select(trans_dd);
		trandd.selectByVisibleText("Void");
		go_btn2.click();
		Select ttpe=new Select(tendertype_dd);
		ttpe.selectByVisibleText("Cash");
		String amnt=lnamnt.getAttribute("Value");
		tenderamnt_txtbox.sendKeys(amnt);
		password_txtbox.sendKeys(prop.getProperty("transactions_password"));
		voiloan_btn.click();
		finalok_btn.click();
	}
	
	
	public void rescindulocbyOriginalTender(){
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		utilities.transactionsinitialization();
		go_btn.click();
		Select trandd=new Select(trans_dd);
		trandd.selectByVisibleText("Rescind");
		go_btn2.click();
		Select ttpe=new Select(tendertype_dd);
		ttpe.selectByVisibleText("Original Tender");
		password_txtbox.sendKeys(prop.getProperty("transactions_password"));
		voiloan_btn.click();
		finalok_btn.click();
	}
	
	
		public void rescindulocbyCash(){
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		utilities.transactionsinitialization();
		go_btn.click();
		Select trandd=new Select(trans_dd);
		trandd.selectByVisibleText("Rescind");
		go_btn2.click();
		Select ttpe=new Select(tendertype_dd);
		ttpe.selectByVisibleText("Cash");
		String amnt=lnamnt.getAttribute("Value");
		tenderamnt_txtbox.sendKeys(amnt);
		password_txtbox.sendKeys(prop.getProperty("transactions_password"));
		voiloan_btn.click();
		finalok_btn.click();
	}
		
}
