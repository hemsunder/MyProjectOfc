package com.qc.tlp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qc.base.TestBase;
import com.qc.utilities.Utilities;

public class VoidRescindTLP extends TestBase {
	
	Utilities utilities;
	
	String transactions=TestData.getCellData("Transactions", "TransactionType", 4);
	String tendertype=TestData.getCellData("Transactions", "TenderType", 2);
	
	@FindBy(xpath="//td[text()='Title Loans']/following::input[@value='Go']")
	WebElement GoBtn;
	
	@FindBy(name="transactionList")
	WebElement transactionList_dd;
	
	@FindBy(id="go_Button")
	WebElement go_btn;
	
	@FindBy(name="tenderType")
	WebElement tenderType_dd;
	
	@FindBy(name="requestBean.password")
	WebElement pwd_txtbox;
	
	@FindBy(xpath="//input[@value='Finish Void Title Loan']")
	WebElement finish_void_btn;
	
	@FindBy(xpath="//input[@value='Finish Rescind']")
	WebElement finish_rescind_btn;
	
	@FindBy(xpath="//input[@value='Yes']")
	WebElement final_yes_btn;
	
	@FindBy(xpath="//input[@value='Ok']")
	WebElement final_ok_btn;
	
	public VoidRescindTLP(){
		PageFactory.initElements(driver, this);
	}
	
	public void voidtlp(){
		utilities=new Utilities();
		utilities.transactionsinitialization();
		GoBtn.click();
		if(transactions.equals("Void")){
			Select trans=new Select(transactionList_dd);
			trans.selectByVisibleText(transactions);
			go_btn.click();
			
			if(tendertype.equals("Original Tender")){
				Select ttype=new Select(tenderType_dd);
				ttype.selectByVisibleText(tendertype);
				pwd_txtbox.sendKeys(prop.getProperty("transactions_password"));
				finish_void_btn.click();
				driver.switchTo().alert().accept();
				final_ok_btn.click();
			}
			
			else if(tendertype.equals("Cash")){
				Select ttypee=new Select(tenderType_dd);
				ttypee.selectByVisibleText(tendertype);
				pwd_txtbox.sendKeys(prop.getProperty("transactions_password"));
				finish_void_btn.click();
				driver.switchTo().alert().accept();
				final_ok_btn.click();
			}
		}
		
		else if(transactions.equals("Rescind")){
			Select trans=new Select(transactionList_dd);
			trans.selectByVisibleText(transactions);
			go_btn.click();
		}
		
		if(tendertype.equals("Original Tender")){
			Select ttype=new Select(tenderType_dd);
			ttype.selectByVisibleText(tendertype);
			pwd_txtbox.sendKeys(prop.getProperty("transactions_password"));
			finish_rescind_btn.click();
			driver.switchTo().alert().accept();
			final_ok_btn.click();
		}
		
		else if(tendertype.equals("Cash")){
			Select ttypee=new Select(tenderType_dd);
			ttypee.selectByVisibleText(tendertype);
			pwd_txtbox.sendKeys(prop.getProperty("transactions_password"));
			finish_rescind_btn.click();
			driver.switchTo().alert().accept();
			final_ok_btn.click();
		}
		
		
	}
}
