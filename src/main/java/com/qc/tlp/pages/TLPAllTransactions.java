package com.qc.tlp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qc.base.TestBase;
import com.qc.utilities.Utilities;

public class TLPAllTransactions extends TestBase {
	
	Utilities util;
	public static String VoidTenderType=prop.getProperty("VoidTenderType");
	public static String RepayFlag=prop.getProperty("RepayFlag");
	public static String cardtype=prop.getProperty("cardtypeee");
	public static String ILPPaymentTenderType=prop.getProperty("paymnt_type");
	public static String payment_amnt=prop.getProperty("payment_amnt");
	String vehtype=TestData.getCellData("CollateralTypes", "vehicleType", 4);
	String vin=TestData.getCellData("CollateralTypes", "VINNum", 2);
	String licensenum=TestData.getCellData("CollateralTypes", "Licensenum", 2);
	String extclr=TestData.getCellData("CollateralTypes", "exteriorclr", 2);
	String vehigr=TestData.getCellData("CollateralTypes", "vehiclegrade", 2);
	String insurancetype=TestData.getCellData("CollateralTypes", "InsuranceCoverage", 4);
	String collateraltype=TestData.getCellData("CollateralTypes", "CollateralType", 10);
	String disbtye=TestData.getCellData("CollateralTypes", "DisbType", 3);
	String crtsycallcnsnt=TestData.getCellData("CollateralTypes", "CourtesyCallConsent", 3);
	String checkcount=TestData.getCellData("CollateralTypes", "NoOfChecks", 2);
	String keygiven=TestData.getCellData("CollateralTypes", "Key", 2);
	
	double b=0;
	double c=0;
	
	@FindBy(id="vehicleType_dd")
	WebElement vehicletype_dd;
	
	@FindBy(id="vinDD")
	WebElement vindd;
	
	@FindBy(name="newVinNbr")
	WebElement newVinnbr_txtbox;
	
	@FindBy(name="miles")
	WebElement miles_txtbox;
	
	@FindBy(name="bbHit_Button")
	WebElement bbHit_button;
	
	@FindBy(xpath="//table[@id='tableWid11']//td//b//input")
	WebElement Term1;
	
	@FindBy(xpath="//table[@id='tableWid14']//td//b//input")
	WebElement TLPTerm1;
	
	@FindBy(xpath="//table[@id='tableWid12']//td//b//input")
	WebElement Term2;
	
	@FindBy(xpath="//input[@value='New Loan']")
	WebElement newLoan_btn;
	
	@FindBy(name="requestBean.titleNumber")
	WebElement titlenum_txtbox;
	
	@FindBy(xpath="//input[@name='button1']")
	WebElement update_btn1;
	
	@FindBy(name="requestBean.licensePltNbr")
	WebElement licenseplatenum_txtbox;
	
	@FindBy(name="requestBean.extClr")
	WebElement exteriorclr_dd;
	
	@FindBy(name="requestBean.vehicleGrade")
	WebElement vehiclegrade_dd;
	
	@FindBy(name="requestBean.coverageType")
	WebElement insurance_dd;
	
	@FindBy(name="button2")
	WebElement update_btn2;
	
	@FindBy(name="process")
	WebElement processloan_btn;
	
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
	
	@FindBy(xpath="//input[@name='requestBean.siilBean.advAmt']")
	WebElement loanamt;
	
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
	
	@FindBy(xpath="//input[@value='Ok']")
	WebElement final_ok_btnn;
	
	@FindBy(xpath="//input[@value='Add Card']")
	WebElement addcard_btn;
	
	@FindBy(name="vehicleKey")
	WebElement vehicleKey_dd;

	
	public TLPAllTransactions() {
		PageFactory.initElements(driver, this);
	}
	
	public void Term1TLPByACH() throws Exception{
		
		util=new Utilities();
		util.LogintoApplication();
		util.newloaninitialization();
		util.tlploanprepage1();
		List<WebElement> tablelist= driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"));
		int countt=tablelist.size();
		for(int i=2; i<=countt; i++){
			String productname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();
			if(productname.equalsIgnoreCase("MO Multi Title"))
			{
			driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input")).click();	
			break;
			}
		}
		newLoan_btn.click();
		util.tlploanprepage2();
			Thread.sleep(5000);
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
				coll.selectByVisibleText("ACH");
								
				Select disb=new Select(disbtype_dd1);
				disb.selectByVisibleText("Cash");
				disbamt_txtbox1.sendKeys(cash_amt);
				
				Select disb2=new Select(disbtype_dd2);
				disb2.selectByVisibleText("Check");
				disbamt_txtbox2.sendKeys(check_amt);
			
				Select vehkey=new Select(vehicleKey_dd);
				vehkey.selectByVisibleText("No");
					
				Select ccdd1=new Select(ctsycalls_dd);
				ccdd1.selectByVisibleText("No");
			
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
			
	@FindBy(xpath="//select[@name='cardNmbr']")
	WebElement selectcard_dd;
	
	@FindBy(xpath="//input[@value='Skip']")
	WebElement skip_btn;
	
	public void Term1TLPByDebitCard() throws Exception{
		
		util=new Utilities();
		util.LogintoApplication();
		util.newloaninitialization();
		util.tlploanprepage1();
		List<WebElement> tablelist= driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"));
		int countt=tablelist.size();
		for(int i=2; i<=countt; i++){
			String productname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();
			if(productname.equalsIgnoreCase("MO Multi Title"))
			{
			driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input")).click();	
			break;
			}
		}
		newLoan_btn.click();
		util.tlploanprepage2();
			
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
				coll.selectByVisibleText("DEBIT CARD");
				
				if(RepayFlag.equalsIgnoreCase("Disabled")){
					util.debitcardfilling();
					addcard_btn.click();
					util.invisible(driver, addcard_btn, 30);
			}
				else if(RepayFlag.equalsIgnoreCase("Enabled")){
					Select selcard_dd = new Select(selectcard_dd);
					List<WebElement> list = selcard_dd.getOptions();
					int count = list.size();
					for (int i = 0; i < count; i++) {
						String name = list.get(i).getText();
						System.out.println(name);
						if (name.equalsIgnoreCase(cardtype)) {
							list.get(i).click();
							util.Updateddebitcardfilling();
							break;
						}
		
						else if (name.contains(cardtype)) {
							list.get(2).click();
							Thread.sleep(3000);
							skip_btn.click();
							break;
						}
					}
				}
				
				
				Select disb=new Select(disbtype_dd1);
				disb.selectByVisibleText("Cash");
				disbamt_txtbox1.sendKeys(cash_amt);
				
				Select disb2=new Select(disbtype_dd2);
				disb2.selectByVisibleText("Check");
				disbamt_txtbox2.sendKeys(check_amt);
			
				Select vehkey=new Select(vehicleKey_dd);
				vehkey.selectByVisibleText("No");
					
				Select ccdd1=new Select(ctsycalls_dd);
				ccdd1.selectByVisibleText("No");
			
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
	
	public void Term1TLPBySignature(){
		
		util=new Utilities();
		util.LogintoApplication();
		util.newloaninitialization();
		util.tlploanprepage1();
		List<WebElement> tablelist= driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"));
		int countt=tablelist.size();
		for(int i=2; i<=countt; i++){
			String productname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();
			if(productname.equalsIgnoreCase("MO Multi Title"))
			{
			driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input")).click();	
			break;
			}
		}
		newLoan_btn.click();
		util.tlploanprepage2();
			
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
			
				Select vehkey=new Select(vehicleKey_dd);
				vehkey.selectByVisibleText("No");
					
				Select ccdd1=new Select(ctsycalls_dd);
				ccdd1.selectByVisibleText("No");
			
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

	public void Term2TLPByACH(String CourtesyCall, String key){
		
		util=new Utilities();
		util.LogintoApplication();
		util.newloaninitialization();
		util.tlploanprepage1();
		Term2.click();
		newLoan_btn.click();
		util.tlploanprepage2();
			
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
				coll.selectByVisibleText("ACH");
								
				Select disb=new Select(disbtype_dd1);
				disb.selectByVisibleText("Cash");
				disbamt_txtbox1.sendKeys(cash_amt);
				
				Select disb2=new Select(disbtype_dd2);
				disb2.selectByVisibleText("Check");
				disbamt_txtbox2.sendKeys(check_amt);
			
				Select vehkey=new Select(vehicleKey_dd);
				vehkey.selectByVisibleText(key);
					
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
			
	public void Term2TLPByDebitCard(String CourtesyCall, String key){
		
		util=new Utilities();
		util.LogintoApplication();
		util.newloaninitialization();
		util.tlploanprepage1();
		Term2.click();
		newLoan_btn.click();
		util.tlploanprepage2();
			
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
				coll.selectByVisibleText("DEBIT CARD");
				//utilities.debitcardfilling();
				addcard_btn.click();
				util.invisible(driver, addcard_btn, 30);
								
				Select disb=new Select(disbtype_dd1);
				disb.selectByVisibleText("Cash");
				disbamt_txtbox1.sendKeys(cash_amt);
				
				Select disb2=new Select(disbtype_dd2);
				disb2.selectByVisibleText("Check");
				disbamt_txtbox2.sendKeys(check_amt);
			
				Select vehkey=new Select(vehicleKey_dd);
				vehkey.selectByVisibleText(key);
					
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
	
	public void Term2TLPBySignature(){
		
		util=new Utilities();
		util.LogintoApplication();
		util.newloaninitialization();
		util.tlploanprepage1();
		Term2.click();
		newLoan_btn.click();
		util.tlploanprepage2();
			
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
			
				Select vehkey=new Select(vehicleKey_dd);
				vehkey.selectByVisibleText("No");
					
				Select ccdd1=new Select(ctsycalls_dd);
				ccdd1.selectByVisibleText("No");
			
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
	
	@FindBy(xpath="//td[text()='Title Loans']//parent::tr//following-sibling::tr[2]//td//input[@value='Go']")
	WebElement Go_btn;
	
	@FindBy(xpath="//select[@name='transactionList']")
	WebElement transactionList;
	
	@FindBy(id="go_Button")
	WebElement go_Button;
	
	@FindBy(xpath="//select[@name='tenderType']")
	WebElement tenderTypedd;
	
	@FindBy(xpath="//input[@name='requestBean.password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='finish']")
	WebElement Finish_Btn;
	
	@FindBy(xpath="//input[@name='Ok']")
	WebElement Yes;
	
	public void VoidLoan(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_btn.click();
		Select transactiondd=new Select(transactionList);
		transactiondd.selectByVisibleText("Void");
		go_Button.click();
		Select tenderTyped=new Select(tenderTypedd);
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
		password.sendKeys("1234");
		Finish_Btn.click();
		driver.switchTo().alert().accept();
		Yes.click();
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
		Select tenderTyped=new Select(tenderTypedd);
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
		password.sendKeys("1234");
		FinishRescind.click();
		driver.switchTo().alert().accept();
		Yes.click();
	}
	
	@FindBy(id="PD4")
	WebElement PayInstAmount;
	
	@FindBy(xpath="//input[@name='requestBean.siilBean.payAmt']")
	WebElement payAmt;
	
	@FindBy(xpath="//select[@name='requestBean.siilBean.tenderTypeFirst']")
	WebElement tenderType;
	
	@FindBy(xpath="//input[@name='requestBean.siilBean.tenderAmtFirst']")
	WebElement tenderAmt_tb;
	
	@FindBy(xpath="//input[@name='requestBean.siilBean.ccmoNbrFirst']")
	WebElement ccmoNbr_tb;
	
	@FindBy(name="requestBean.siilBean.checkNbrFirst")
	WebElement checkNbr_tb;
	
	@FindBy(xpath="//select[@name='crditNbrFirst']")
	WebElement crditNbr_tb;
	
	@FindBy(xpath="//input[@value='Finish']")
	WebElement Finish_payment;
	
	public void PayInstPayment() throws Exception{
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_btn.click();
		Select transactiondd=new Select(transactionList);
		transactiondd.selectByVisibleText("Payment");
		go_Button.click();
		Thread.sleep(8000);
		PayInstAmount.click();
		String payment_amount=payAmt.getAttribute("value");
		Select tenTypedd=new Select(tenderType);
		tenTypedd.selectByVisibleText(ILPPaymentTenderType);
		if(ILPPaymentTenderType.equals("Cash")){
			tenderAmt_tb.sendKeys(payment_amount);
		}
		
		else if (ILPPaymentTenderType.equals("Cashiers Check")){
			ccmoNbr_tb.sendKeys("123456");
			tenderAmt_tb.sendKeys(payment_amount);
		}
		
		else if (ILPPaymentTenderType.equals("Money Order")){
			ccmoNbr_tb.sendKeys("123456");
			tenderAmt_tb.sendKeys(payment_amount);
		}
		
		else if (ILPPaymentTenderType.equals("Check")){
			checkNbr_tb.sendKeys("123456");
			tenderAmt_tb.sendKeys(payment_amount);
		}
		
		else {
			tenderAmt_tb.sendKeys(payment_amount);
			Select selcard=new Select(crditNbr_tb);
			List<WebElement> list=selcard.getOptions();
			int count=list.size();
			for(int i=0;i<count;i++){
				String name=list.get(i).getText();
				System.out.println(name);
				if(name.equalsIgnoreCase(cardtype)){
					list.get(i).click();
					Thread.sleep(10000);
					util.Updateddebitcardfillingforpayments();	
					Thread.sleep(5000);
				}
				
				else if(name.contains(cardtype)){
					list.get(2).click();
					Thread.sleep(3000);
					skip_btn.click();
					break;
				}
			}
		}
		
		pwd_txtbox.sendKeys("1234");
		Finish_payment.click();
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		final_ok_btnn.click();
	}
	
	@FindBy(xpath="//input[@value='Void Payment']")
	WebElement VoidPayment;
	
	public void PayInstPaymentVoid(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_btn.click();
		Select transactiondd=new Select(transactionList);
		transactiondd.selectByVisibleText("Void");
		go_Button.click();
		Select transdd=new Select(disbtype_dd1);
		transdd.selectByVisibleText(VoidTenderType);
		pwd_txtbox.sendKeys("1234");
		VoidPayment.click();
		final_ok_btnn.click();
	}
	
	@FindBy(id="PD3")
	WebElement Payoff_btn;
	
	@FindBy(name="finish")
	WebElement finish_btn;
	
	public void Payoff() throws Exception{
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_btn.click();
		Select transactiondd=new Select(transactionList);
		transactiondd.selectByVisibleText("Payment");
		go_Button.click();
		Thread.sleep(8000);
		Payoff_btn.click();
		String payment_amount=payAmt.getAttribute("value");
		Select tenTypedd=new Select(tenderType);
		tenTypedd.selectByVisibleText(ILPPaymentTenderType);
		if(ILPPaymentTenderType.equals("Cash")){
			tenderAmt_tb.sendKeys(payment_amount);
		}
		
		else if (ILPPaymentTenderType.equals("Cashiers Check")){
			ccmoNbr_tb.sendKeys("123456");
			tenderAmt_tb.sendKeys(payment_amount);
		}
		
		else if (ILPPaymentTenderType.equals("Money Order")){
			ccmoNbr_tb.sendKeys("123456");
			tenderAmt_tb.sendKeys(payment_amount);
		}
		
		else if (ILPPaymentTenderType.equals("Check")){
			checkNbr_tb.sendKeys("123456");
			tenderAmt_tb.sendKeys(payment_amount);
		}
		
		else {
			tenderAmt_tb.sendKeys(payment_amount);
			Select selcard=new Select(crditNbr_tb);
			List<WebElement> list=selcard.getOptions();
			int count=list.size();
			for(int i=0;i<count;i++){
				String name=list.get(i).getText();
				System.out.println(name);
				if(name.equalsIgnoreCase(cardtype)){
					list.get(i).click();
					Thread.sleep(10000);
					util.Updateddebitcardfillingforpayments();	
					Thread.sleep(5000);
					break;
				}
				
				else if(name.contains(cardtype)){
					list.get(2).click();
					Thread.sleep(3000);
					skip_btn.click();
					break;
				}
			}
		}
		
		pwd_txtbox.sendKeys("1234");
		finish_btn.click();
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Yes.click();
	}
	
	@FindBy(xpath="//td[text()='Title Loans']//parent::tr//following-sibling::tr[3]//td//input[@value='Go']")
	WebElement Go_btn_ForVoidOnly;
	
	public void PayoffVoid(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_btn_ForVoidOnly.click();
		Select transactiondd=new Select(transactionList);
		transactiondd.selectByVisibleText("Void");
		go_Button.click();
		Select transdd=new Select(disbtype_dd1);
		transdd.selectByVisibleText(VoidTenderType);
		pwd_txtbox.sendKeys("1234");
		finish_btn.click();
		Yes.click();
	}
	
	@FindBy(id="PD5")
	WebElement Payanyotheramouont_btn;
	
	public void PayanyotherAmount() throws Exception{
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_btn.click();
		Select transactiondd=new Select(transactionList);
		transactiondd.selectByVisibleText("Payment");
		go_Button.click();
		Thread.sleep(8000);
		Payanyotheramouont_btn.click();
		payAmt.sendKeys(payment_amnt);
		Select tenTypedd=new Select(tenderType);
		tenTypedd.selectByVisibleText(ILPPaymentTenderType);
		if(ILPPaymentTenderType.equals("Cash")){
			tenderAmt_tb.sendKeys(payment_amnt);
		}
		
		else if (ILPPaymentTenderType.equals("Cashiers Check")){
			ccmoNbr_tb.sendKeys("123456");
			tenderAmt_tb.sendKeys(payment_amnt);
		}
		
		else if (ILPPaymentTenderType.equals("Money Order")){
			ccmoNbr_tb.sendKeys("123456");
			tenderAmt_tb.sendKeys(payment_amnt);
		}
		
		else if (ILPPaymentTenderType.equals("Check")){
			checkNbr_tb.sendKeys("123456");
			tenderAmt_tb.sendKeys(payment_amnt);
		}
		
		else {
			tenderAmt_tb.sendKeys(payment_amnt);
			Select selcard=new Select(crditNbr_tb);
			List<WebElement> list=selcard.getOptions();
			int count=list.size();
			for(int i=0;i<count;i++){
				String name=list.get(i).getText();
				System.out.println(name);
				if(name.equalsIgnoreCase(cardtype)){
					list.get(i).click();
					Thread.sleep(10000);
					util.Updateddebitcardfillingforpayments();	
					Thread.sleep(5000);
					break;
				}
				
				else if(name.contains(cardtype)){
					list.get(2).click();
					Thread.sleep(3000);
					skip_btn.click();
					break;
				}
			}
		}
		
		pwd_txtbox.sendKeys("1234");
		finish_btn.click();
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Yes.click();
	}
	@FindBy(xpath="//input[@value='Finish TLP Debit Card Deposit']")
	WebElement Finish_ILPDebitCardDeposit;
	
	public void DCDeposit(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_btn.click();
		Select transactiondd=new Select(transactionList);
		transactiondd.selectByVisibleText("Debit Card Deposit");
		go_Button.click();
		Finish_ILPDebitCardDeposit.click();
		Yes.click();
	}
	
	public void DCDepositVoid(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_btn.click();
		Select transactiondd=new Select(transactionList);
		transactiondd.selectByVisibleText("Void");
		go_Button.click();
		Select transdd=new Select(disbtype_dd1);
		transdd.selectByVisibleText("Original Tender");
		pwd_txtbox.sendKeys("1234");
		finish_btn.click();
		Yes.click();
	}
	
	@FindBy(xpath="//input[@value='DC Revoke']")
	WebElement dcrevoke;
	
	public void DCRevoke(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_btn.click();
		Select Transactionsdd = new Select(transactionList);
		Transactionsdd.selectByVisibleText("DC Revoke");
		go_Button.click();
		driver.switchTo().alert().accept();
		dcrevoke.click();
		final_yes_btn.click();
	}
	
	@FindBy(xpath="//input[@value='Chargeback']")
	WebElement chargeback;
	
	public void chargeback(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_btn.click();
		Select Transactionsdd = new Select(transactionList);
		Transactionsdd.selectByVisibleText("History");
		go_Button.click();
		List<WebElement> list=driver.findElements(By.xpath("//input[@name='rad']"));
		int count=list.size();
		System.out.println(count);
		list.get(count-1).click();
		chargeback.click();
		driver.switchTo().alert().accept();
		
	}
	
	@FindBy(xpath="//input[@value='Finish TLP ACH Deposit']")
	WebElement Finish_TLPACHDeposit;
	
	public void ACHDeposit(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_btn.click();
		Select Transactionsdd = new Select(transactionList);
		Transactionsdd.selectByVisibleText("ACH Deposit");
		go_Button.click();
		Finish_TLPACHDeposit.click();
		Yes.click();
	}
		
	public void ACHDepositVoid(){
		util=new Utilities();
		util.LogintoApplication();
		util.transactionsinitialization();
		Go_btn.click();
		Select Transactionsdd = new Select(transactionList);
		Transactionsdd.selectByVisibleText("Void");
		go_Button.click();
		Finish_Btn.click();
		Yes.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
