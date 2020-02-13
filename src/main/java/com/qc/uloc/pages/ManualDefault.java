package com.qc.uloc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.qc.base.TestBase;
import com.qc.utilities.Utilities;

public class ManualDefault extends TestBase{
	Utilities utilities;
	WebDriver driver2;
	
	@FindBy(xpath="//a[text()='Loan Transactions']")
	WebElement loantransactions;
	
	@FindBy(xpath="//a[text()='Manual Default']")
	WebElement manual_default;
	
	@FindBy(name="requestBean.cusNbr")
	WebElement customer_num;
	
	@FindBy(name="requestBean.loanCode")
	WebElement Loan_num;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement Submit_btn;
	
	@FindBy(name="requestBean.origTranNbr")
	WebElement Encryption_nbr;
	
	@FindBy(name="requestBean.locationNbr")
	WebElement store_num;
	
	@FindBy(name="requestBean.tranNbr")
	WebElement tran_num;
	
	@FindBy(xpath="//select[@name='trancd']")
	WebElement tran_dd;
	
	@FindBy(xpath="//input[@value='Get Key']")
	WebElement get_key;
	
	@FindBy(xpath="//input[@name='EanKey']")
	WebElement en_key;
	
	@FindBy(name="loginRequestBean.userId")
	WebElement username;
	
	@FindBy(name="loginRequestBean.password")
	WebElement password;
	
	@FindBy(name="login")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[text()='Employee']")
	WebElement Employee_btn;
	
	@FindBy(xpath="//a[text()='Encryption Key']")
	WebElement Encryption_Key;
	
	@FindBy(xpath="//a[text()='Encryption']")
	WebElement Encryption;
	
	@FindBy(name="requestBean.encryptionKey")
	WebElement Encryption_tb;
	
	@FindBy(xpath="//input[@value='Finish Manual Default']")
	WebElement Finish_Manual_Default;
	
	@FindBy(xpath="//input[@value='Ok']")
	WebElement oK_btn;
	
	@FindBy(xpath="//iframe[@id='bdyLoad']")
	WebElement frame;
	
	
	public ManualDefault(){
		PageFactory.initElements(driver, this);
	}
	
	public void default_manually(){
		String final_key = null;
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		/*String parent=driver.getWindowHandle();
		System.out.println(parent);*/
		driver.switchTo().frame("topFrame");
		loantransactions.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		manual_default.click();
		driver.switchTo().frame(frame);
		customer_num.sendKeys(prop.getProperty("bo_code"));
		Loan_num.sendKeys(prop.getProperty("loan_code"));
		Submit_btn.click();
		String key=Encryption_nbr.getAttribute("value");
		System.out.println(key);
		WebDriver driver2=new InternetExplorerDriver();
		driver2.get(prop.getProperty("reconadminurl"));
		driver2.findElement(By.name("loginRequestBean.userId")).sendKeys(prop.getProperty("username"));
		driver2.findElement(By.name("loginRequestBean.password")).sendKeys(prop.getProperty("password"));
		driver2.findElement(By.name("login")).click();
		driver2.switchTo().frame("topFrame");
		driver2.findElement(By.xpath("//a[text()='Employee']")).click();
		driver2.switchTo().defaultContent();
		driver2.switchTo().frame("mainFrame");
		driver2.findElement(By.xpath("//a[text()='Encryption Key']")).click();
		driver2.findElement(By.xpath("//a[text()='Encryption']")).click();
		driver2.switchTo().frame("bdyLoad");
		driver2.findElement(By.name("requestBean.locationNbr")).sendKeys(prop.getProperty("storeid"));
		driver2.findElement(By.name("requestBean.tranNbr")).sendKeys(key);
		Select trandd = new Select(driver2.findElement(By.xpath("//select[@name='trancd']")));
		trandd.selectByVisibleText("Manual Default-MNDEF");
		driver2.findElement(By.xpath("//input[@value='Get Key']")).click();
		final_key = driver2.findElement(By.xpath("//input[@name='EanKey']")).getAttribute("value");
		System.out.println(final_key);
		driver2.close();
		Encryption_tb.sendKeys(final_key);
		Finish_Manual_Default.click();	
		oK_btn.click();
	}
	
	
	
	@FindBy(xpath="//a[text()='Void Manual Default']")
	WebElement Void_Manual_Default;
	
	@FindBy(xpath="//input[@value='Finish Void Manual Default']")
	WebElement Finish_Void_Manual_Default;
	
	@FindBy(xpath="//input[@value='Ok']")
	WebElement void_def_okbtn;
	
	public void VoidManualDefault(){
		
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		driver.switchTo().frame("topFrame");
		loantransactions.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		Void_Manual_Default.click();
		driver.switchTo().frame(frame);
		customer_num.sendKeys(prop.getProperty("bo_code"));
		Loan_num.sendKeys(prop.getProperty("loan_code"));
		Submit_btn.click();
		Finish_Void_Manual_Default.click();
		void_def_okbtn.click();
		
	}
	
	
	@FindBy(xpath="//a[text()='Borrower']")
	WebElement Borrower_btn;
	
	@FindBy(xpath="//a[text()='Collections']")
	WebElement Collections_btn;
	
	@FindBy(name="requestBean.installmentType")
	WebElement producytype_dd;
	
	@FindBy(xpath="//input[@value='8' and @type='radio']")
	WebElement customer_radio;
	
	@FindBy(xpath="//select[@name='customerSearch' and @id='ach12']")
	WebElement customer_dd;
	
	@FindBy(xpath="//input[@name='requestBean.loanNo']")
	WebElement loan_no_txtbox;
	
	@FindBy(xpath="//input[@value='Search' and @name='Button3']")
	WebElement search_btn;
	
	@FindBy(xpath="//input[@value='GO']")
	WebElement GO_btn;
	
	@FindBy(xpath="//input[@value='WriteOff']")
	WebElement WriteOff_btn;
	
	@FindBy(name="customerBean.randomNbr1")
	WebElement code;
	
	@FindBy(xpath="//input[@name='customerBean.eanNbr1']")
	WebElement encr_nbr;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement suubmit;
	
	@FindBy(xpath="//input[@name='checkok' and @value='Ok']")
	WebElement ook_btnn;
	
	public void WriteOff() throws Exception{
		String wo_encryption_key=null;
		utilities=new Utilities();
		utilities.verifyLoginPage(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("storeid"));
		driver.switchTo().frame("topFrame");
		Borrower_btn.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		Collections_btn.click();
		driver.switchTo().frame(frame);
		Select producytypedd=new Select (producytype_dd);
		producytypedd.selectByVisibleText("Line of Credit");
		customer_radio.click();
		Select customerdd=new Select (customer_dd);
		customerdd.selectByVisibleText("Loan Nbr");
		loan_no_txtbox.sendKeys(prop.getProperty("loan_code"));
		search_btn.click();
		Thread.sleep(2000);
		GO_btn.click();
		WriteOff_btn.click();
		String tran_nbr=code.getAttribute("value");
		WebDriver driver2=new InternetExplorerDriver();
		driver2.get(prop.getProperty("reconadminurl"));
		driver2.findElement(By.name("loginRequestBean.userId")).sendKeys(prop.getProperty("username"));
		driver2.findElement(By.name("loginRequestBean.password")).sendKeys(prop.getProperty("password"));
		driver2.findElement(By.name("login")).click();
		driver2.switchTo().frame("topFrame");
		driver2.findElement(By.xpath("//a[text()='Employee']")).click();
		driver2.switchTo().defaultContent();
		driver2.switchTo().frame("mainFrame");
		driver2.findElement(By.xpath("//a[text()='Encryption Key']")).click();
		driver2.findElement(By.xpath("//a[text()='Encryption']")).click();
		driver2.switchTo().frame("bdyLoad");
		driver2.findElement(By.name("requestBean.locationNbr")).sendKeys(prop.getProperty("storeid"));
		driver2.findElement(By.name("requestBean.tranNbr")).sendKeys(tran_nbr);
		Select trandd = new Select(driver2.findElement(By.xpath("//select[@name='trancd']")));
		trandd.selectByVisibleText("Write Off Manually-WO");
		driver2.findElement(By.xpath("//input[@value='Get Key']")).click();
		wo_encryption_key = driver2.findElement(By.xpath("//input[@name='EanKey']")).getAttribute("value");
		driver2.close();
		encr_nbr.sendKeys(wo_encryption_key);
		suubmit.click();
		ook_btnn.click();
		
	}

}
