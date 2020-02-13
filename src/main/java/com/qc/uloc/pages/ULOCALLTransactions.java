package com.qc.uloc.pages;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.qc.base.TestBase;
import com.qc.utilities.Utilities;

public class ULOCALLTransactions extends TestBase {

	Utilities util;
	public static String VoidTenderType=prop.getProperty("VoidTenderType");
	public static String LoanAmt=prop.getProperty("LoanAmt");
	int b=0;
	int c=0;
	
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
	
	@FindBy(xpath="//td[contains(text(),'ULOC Loans')]/parent::tr//following-sibling::tr[3]//td//input[@value='Go']")
	WebElement go_btn;
	
	@FindBy(name="transactionList")
	WebElement transactionList;
	
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
	
	@FindBy(name="requestBean.paymentAmt")
	WebElement payment_txtbox;
	
	@FindBy(name="requestBean.tenderType")
	WebElement tendertpe_dd;
	
	@FindBy(name="requestBean.transactionDataBean.ccmoNbrFirst")
	WebElement ccmo_txtbox;
	
	@FindBy(name="requestBean.tenderAmt")
	WebElement tenderamt_txtbox;
	
	@FindBy(name="Submit22")
	WebElement finishpayment_btn;
	
	@FindBy(name="checkyes")
	WebElement yes_btn;
	
	@FindBy(name="payOffAmount")
	WebElement payOffAmount_value;
	
	@FindBy(name="tenderAmount")
	WebElement tenderAmount_txtbox;
	
	@FindBy(name="transactionDataBean.tenderType")
	WebElement disbtype_dd;
	
	@FindBy(name="Submit22")
	WebElement finishpaymentvoid_btn;
	
	
	public ULOCALLTransactions(){
		PageFactory.initElements(driver, this);
	}

	
	public void NewLoanByACH(String LoanAmt){
		
		//double a=Double.parseDouble(LoanAmt);
		int a = Integer.parseInt(LoanAmt);
		if(a==100){
			 b=a/2;
			 c=a-b;
		}
		else if (a>100){
			 b=100;
			 c=a-b;
		}
		
		else if (a>2500){
			System.out.println("Loan amount should not be greater than 2500");
			driver.close();
		}
		
		else if (a<100){
			System.out.println("Loan amount should not be less than 100");
			driver.close();
		}
		
		String cash_amt=Integer.toString(b);
		String check_amt=Integer.toString(c);
		
		util=new Utilities();
		util.LogintoApplication();
		util.newloaninitialization();	
		List<WebElement> listt=driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]"
				+ "/td/table/tbody/tr"));
		int count=listt.size();
		for (int i=2;i<=count;i++){
			String productname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]"
					+ "/td/table/tbody/tr["+i+"]/td[2]")).getText();
			if(productname.contains("KS Line of Credit")){
				driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/"
						+ "tr[3]/td[2]/input")).click();
			}
		}
		
		newloan_btn.click();
		locamt_txtbox.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		locamt_txtbox.sendKeys(LoanAmt);
		util.clickon(driver, paymentcolltype_dd, 120);
		Select paymentcoltypdd=new Select(paymentcolltype_dd);
		paymentcoltypdd.selectByVisibleText("ACH");
		
		Select disbtypedd1=new Select(disbtype_dd1);
		disbtypedd1.selectByVisibleText("Cash");
		disbamt_txtbox1.sendKeys(cash_amt);
		Select disbtypedd2=new Select(disbtype_dd2);
		disbtypedd2.selectByVisibleText("Check");
		disbamt_txtbox1.sendKeys(check_amt);
		
		Select courtesycalldd=new Select(courtesycall_dd);
		courtesycalldd.selectByVisibleText("No");
		
		Select noofchecksdd=new Select(noofchecks_dd);
		noofchecksdd.selectByIndex(1);
		check_chckbox.click();
		checkamnt_txtbox.sendKeys(check_amt);
		pwd_txtbox.sendKeys("1234");
		finish_btn.click();
		finalyes_btn.click();
		finalok_btn.click();
	}
	
	
	@FindBy(xpath="//td[text()='ULOC Loans']//parent::tr//following-sibling::tr[3]//td//input[@value='Go']")
	WebElement Go_btn;
	
	@FindBy(xpath="//input[@value='Go']")
	WebElement go_Button;
	
	public void VoidLoan(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_btn.click();
		Select transactiondd=new Select(transactionList);
		transactiondd.selectByVisibleText("Void");
		go_Button.click();
		Select tenderTyped=new Select(tendertype_dd);
		List<WebElement> list=tenderTyped.getOptions();
		int count=list.size();
		for(int i=0;i<count;i++){
			String name=list.get(i).getText();
			System.out.println(name);
			if(name.equalsIgnoreCase(VoidTenderType)){
				list.get(i).click();
				break;
			}
		}
		pwd_txtbox.sendKeys("1234");
		voiloan_btn.click();
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finalok_btn.click();
	}
	
	@FindBy(xpath="//input[@value='Finish Rescind']")
	WebElement FinishRescind;
	
	public void RescindLoan(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_btn.click();
		Select transactiondd=new Select(transactionList);
		transactiondd.selectByVisibleText("Rescind");
		go_Button.click();
		Select tenderTyped=new Select(transactionList);
		List<WebElement> list=tenderTyped.getOptions();
		int count=list.size();
		for(int i=0;i<count;i++){
			String name=list.get(i).getText();
			System.out.println(name);
			if(name.equalsIgnoreCase(VoidTenderType)){
				list.get(i).click();
				break;
			}
		}
		pwd_txtbox.sendKeys("1234");
		FinishRescind.click();
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finalok_btn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}