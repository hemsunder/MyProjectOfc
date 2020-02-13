package com.qc.silp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qc.base.TestBase;
import com.qc.utilities.Utilities;

public class NewSignatureILP extends TestBase{
	
	Utilities utilities;
	double b=0;
	double c=0;
	
	String checkcount=TestData.getCellData("CollateralTypes", "NoOfChecks", 2);
	
	@FindBy(xpath="//table[@id='tableWid3']//td//b//input")
	WebElement Term1;
	
	@FindBy(xpath="//table[@id='tableWid4']//td//b//input")
	WebElement Term2;
	
	@FindBy(xpath="//input[@value='New Loan']")
	WebElement newLoan_btn;
	
	@FindBy(xpath="//input[@name='requestBean.siilBean.advAmt']")
	WebElement loanamt;
	
	@FindBy(xpath="//select[@name='collateralType']")
	WebElement colltype_dd;
	
	@FindBy(xpath="//select[@name='requestBean.siilBean.disbType']")
	WebElement disbtype_dd1;
	
	@FindBy(name="requestBean.siilBean.disbTypeSecond")
	WebElement disbtype_dd2;	
	
	@FindBy(name="requestBean.siilBean.disbAmtFirst")
	WebElement disbamt_txtbox1;
	
	@FindBy(name="requestBean.siilBean.disbAmtSecond")
	WebElement disbamt_txtbox2;
	
	@FindBy(name="requestBean.siilBean.courtesyCallFlag")
	WebElement ctsycalls_dd;
	
	@FindBy(xpath="//select[@id='checkCount']")
	WebElement checkcount_dd;
	
	@FindBy(id="isCustCheck#1")
	WebElement custcheckbox;
	
	@FindBy(id="checkAmt1")
	WebElement checkamt_txtbox;
	
	@FindBy(name="requestBean.password")
	WebElement pwd_txtbox;
	
	@FindBy(xpath="//input[@value='Finish Loan']")
	WebElement finishloan_btn;
	
	@FindBy(xpath="//input[@value='Yes']")
	WebElement final_yes_btn;
	
	@FindBy(xpath="//input[@value='OK']")
	WebElement final_ok_btn;
	
	public NewSignatureILP () {
		PageFactory.initElements(driver, this);
	}
	
	
	public void Term1SILP(String CourtesyCall, String key){
		
	utilities=new Utilities();
	utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
	utilities.newloaninitialization();	
	Term1.click();
	newLoan_btn.click();
			
			String loannamt=loanamt.getAttribute("value");
			double a=Double.parseDouble(loannamt);
			if(a<=200){
				 b=a/2;
				 c=a-b;
			}
			else if (a>=200){
				 b=200;
				 c=a-b;
			}
			
			String cash_amt=Double.toString(b);
			String check_amt=Double.toString(c);
						
				Select coll=new Select(colltype_dd);
				coll.selectByVisibleText("SIGNATURE");
								
				Select disb=new Select(disbtype_dd1);
				disb.selectByVisibleText("Cash");
				disbamt_txtbox1.sendKeys(cash_amt);
				
				Select disb2=new Select(disbtype_dd2);
				disb2.selectByVisibleText("Check");
				disbamt_txtbox2.sendKeys(check_amt);
			
				Select ccdd1=new Select(ctsycalls_dd);
				ccdd1.selectByVisibleText(CourtesyCall);
			
				if(checkcount.equals("1")){
					Select ccount=new Select(checkcount_dd);
					ccount.selectByValue(checkcount);
					custcheckbox.click();
					checkamt_txtbox.sendKeys(check_amt);
				}
					pwd_txtbox.sendKeys(prop.getProperty("transactions_password"));
					finishloan_btn.click();
					final_yes_btn.click();
					final_ok_btn.click();
			}

	public void Term2SILP(String CourtesyCall, String key){
	
	utilities=new Utilities();
	utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
	utilities.newloaninitialization();	
	Term2.click();
	newLoan_btn.click();
		
		String loannamt=loanamt.getAttribute("value");
		double lnamt=Double.parseDouble(loannamt);
		double dmv =13.50;
		double a=lnamt-dmv;
		
		if(a<=200){
			b=a/2;
			c=a-b;
		}
		else if(a>=200){
			b=200;
			c=a-b;
		}
		
		String cash_amt=Double.toString(b);
		String check_amt=Double.toString(c);
					
			Select coll=new Select(colltype_dd);
			coll.selectByVisibleText("SIGNATURE");
							
			Select disb=new Select(disbtype_dd1);
			disb.selectByVisibleText("Cash");
			disbamt_txtbox1.sendKeys(cash_amt);
			
			Select disb2=new Select(disbtype_dd2);
			disb2.selectByVisibleText("Check");
			disbamt_txtbox2.sendKeys(check_amt);
		
			Select ccdd1=new Select(ctsycalls_dd);
			ccdd1.selectByVisibleText(CourtesyCall);
		
			if(checkcount.equals("1")){
				Select ccount=new Select(checkcount_dd);
				ccount.selectByValue(checkcount);
				custcheckbox.click();
				checkamt_txtbox.sendKeys(check_amt);
			}
				pwd_txtbox.sendKeys(prop.getProperty("transactions_password"));
				finishloan_btn.click();
				final_yes_btn.click();
				final_ok_btn.click();
	}
}
