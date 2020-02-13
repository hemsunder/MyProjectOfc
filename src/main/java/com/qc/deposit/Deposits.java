package com.qc.deposit;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qc.base.TestBase;
import com.qc.utilities.Utilities;

public class Deposits extends TestBase{
	Utilities utilities;
	
	@FindBy(xpath="//a[text()='Cash Management']")
	WebElement Cash_Management;
	
	@FindBy(xpath="//a[text()='Safe']")
	WebElement safe;
	
	@FindBy(xpath="//a[text()='Deposit ']")
	WebElement Deposit;
	
	@FindBy(xpath="//tr[@class='trodd']//td[1]")
	WebElement customer1;
	
	@FindBy(xpath="//td[text()=' LOC Collateral ACH ']//parent::tr//following-sibling::tr[@class='trodd']//td")
	WebElement customers;	
	
	@FindBy(xpath="//tr[@class='trodd']//input")
	WebElement customer1_chkbox;
	
	@FindBy(xpath="//td[text()=' LOC Collateral ACH ']//parent::tr//following-sibling::tr//td//input")
	WebElement customer_chkboxes;
	
	@FindBy(xpath="//input[@name='safeDepositRequestBean.password']")
	WebElement Banker_PIN;
	
	@FindBy(xpath="//iframe[@id='bdyLoad']")
	WebElement frame;
	
	@FindBy(xpath="//input[@value='Finish Deposit']")
	WebElement Finish_Deposit;
	
	@FindBy(xpath="//input[@value='Finish Deposit']")
	WebElement Finish_Deposit_btn;
	
	@FindBy(xpath="//input[@value='Ok']")
	WebElement ok_btn;
	
	public Deposits(){
		PageFactory.initElements(driver, this);
	}
	
	public void DepositOneCustomerFromMidDay(){
		utilities=new Utilities();
		utilities.LogintoApplication();
		driver.switchTo().frame("topFrame");
		Cash_Management.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		safe.click();
		Deposit.click();
		driver.switchTo().frame(frame);
		String actual_name=prop.getProperty("Last_Name") + ","+ " "+prop.getProperty("First_Name");
		System.out.println(actual_name);
		List<WebElement> list=driver.findElements(By.xpath("//td[text()=' LOC Collateral ACH ']//"
				+ "parent::tr//following-sibling::tr[@class='trodd']//td"));
		int count=list.size();
		for(int i=0;i<=count;i++){
			String expected_name=list.get(i).getText();
			System.out.println(expected_name);
			if(actual_name.equalsIgnoreCase(expected_name)){
				//customer1_chkbox.click();
				customer_chkboxes.click();
				list.get(i).click();
			}
		}
		
		Banker_PIN.sendKeys("1234");
		Finish_Deposit.click();
		try {
			Alert alt = driver.switchTo().alert();
			alt.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Finish_Deposit_btn.click();
		ok_btn.click();
	}
	
	
	public void BulkMidDayDeposit(){
		utilities=new Utilities();
		utilities.LogintoApplication();
		driver.switchTo().frame("topFrame");
		Cash_Management.click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		safe.click();
		Deposit.click();
		driver.switchTo().frame(frame);
		List<WebElement> list=driver.findElements(By.xpath("//input[@type='checkbox']"));
		int count=list.size();
		for(int i=0;i<count;i++){
				list.get(i).click();
		}
		
		Banker_PIN.sendKeys("1234");
		Finish_Deposit.click();
		try {
			Alert alt = driver.switchTo().alert();
			alt.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Finish_Deposit_btn.click();
		ok_btn.click();
		
	}

}
