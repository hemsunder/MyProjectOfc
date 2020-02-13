package com.qc.utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class NewCustomerRegFromConfig {
	WebDriver driver;
	public static String Bo_Code;
	public static Properties prop;
	
	@Test
	public void Reg() throws Exception {
		
			try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:/Selenium WebDriver/QCProject/src/main/java/com/qc/config/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		System.setProperty("webdriver.ie.driver", "C:\\Selenium WebDriver\\Drivers\\IEDriverServer.exe" );
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("localurl"));
		
		driver.findElement(By.xpath(prop.getProperty("username_xpath"))).sendKeys(prop.getProperty("username"));		
		driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath(prop.getProperty("store_xpath"))).sendKeys(prop.getProperty("storeid"));
		driver.findElement(By.xpath(prop.getProperty("submit_btn_xpath"))).click();
		
		driver.switchTo().frame("topFrame");
		driver.findElement(By.xpath(prop.getProperty("borrower_xpath"))).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("mainFrame");
		driver.findElement(By.xpath(prop.getProperty("Registration_xpath"))).click();
		WebElement myframe1=driver.findElement(By.xpath("//iframe[@id='bdyLoad']"));
		driver.switchTo().frame(myframe1);
		
		driver.findElement(By.xpath(prop.getProperty("ssn1_xpath"))).sendKeys(prop.getProperty("ssn1"));
		driver.findElement(By.name(prop.getProperty("ssn2_name"))).sendKeys(prop.getProperty("ssn2"));
		driver.findElement(By.name(prop.getProperty("ssn3_name"))).sendKeys(prop.getProperty("ssn3"));
		driver.findElement(By.name(prop.getProperty("confirm_ssn1_name"))).sendKeys(prop.getProperty("confirm_ssn1"));
		driver.findElement(By.name(prop.getProperty("confirm_ssn2_name"))).sendKeys(prop.getProperty("confirm_ssn2"));
		driver.findElement(By.name(prop.getProperty("confirm_ssn3_name"))).sendKeys(prop.getProperty("confirm_ssn3"));
		driver.findElement(By.name(prop.getProperty("Last_Name_name"))).sendKeys(prop.getProperty("Last_Name"));
		driver.findElement(By.name(prop.getProperty("First_Name_name"))).sendKeys(prop.getProperty("First_Name"));
		driver.findElement(By.name(prop.getProperty("Address_Line_1_name"))).sendKeys(prop.getProperty("Address_Line1"));
		driver.findElement(By.name(prop.getProperty("City_name"))).sendKeys(prop.getProperty("City"));
		
		WebElement ele3=driver.findElement(By.name(prop.getProperty("state_dd_name")));
		Select sel1=new Select(ele3);
		sel1.selectByVisibleText("Kansas");
		
		driver.findElement(By.name(prop.getProperty("Zip_Code_name"))).sendKeys(prop.getProperty("Zip_Code"));
		driver.findElement(By.name(prop.getProperty("Months_at_Address_name"))).sendKeys(prop.getProperty("Months_at_Address"));
		driver.findElement(By.name(prop.getProperty("Primary_Phone1_name"))).sendKeys(prop.getProperty("Primary_Phone1"));
		driver.findElement(By.name(prop.getProperty("Primary_Phone2_name"))).sendKeys(prop.getProperty("Primary_Phone2"));
		driver.findElement(By.name(prop.getProperty("Primary_Phone3_name"))).sendKeys(prop.getProperty("Primary_Phone3"));
		
		WebElement ele4=driver.findElement(By.name(prop.getProperty("phonetype_name")));
		Select sel2=new Select(ele4);
		sel2.selectByVisibleText("Home");
		
		driver.findElement(By.name(prop.getProperty("no_email_checkbox_name"))).click();
		driver.findElement(By.name(prop.getProperty("Photo_ID_Nbr_name"))).sendKeys(prop.getProperty("Photo_ID_Nbr"));
		
		WebElement ele5=driver.findElement(By.name(prop.getProperty("idstate_name")));
		Select sel3=new Select(ele5);
		sel3.selectByVisibleText("Kansas");
		
		driver.findElement(By.name(prop.getProperty("ID_Expiration_month_name"))).sendKeys(prop.getProperty("ID_Expiration_month"));
		driver.findElement(By.name(prop.getProperty("ID_Expiration_date_name"))).sendKeys(prop.getProperty("ID_Expiration_date"));
		driver.findElement(By.name(prop.getProperty("ID_Expiration_year_name"))).sendKeys(prop.getProperty("ID_Expiration_year"));
		
		WebElement ele6=driver.findElement(By.name(prop.getProperty("photoidtye_name")));
		Select sel4=new Select(ele6);
		sel4.selectByVisibleText("Driver License");
		
		driver.findElement(By.name(prop.getProperty("ID_Zip_Code_name"))).sendKeys(prop.getProperty("ID_Zip_Code"));
		
		driver.findElement(By.name(prop.getProperty("Dob_month_name"))).sendKeys(prop.getProperty("Dob_month"));
		driver.findElement(By.name(prop.getProperty("Dob_date_name"))).sendKeys(prop.getProperty("Dob_date"));
		driver.findElement(By.name(prop.getProperty("Dob_year_name"))).sendKeys(prop.getProperty("Dob_year"));
		
		WebElement ele7=driver.findElement(By.name(prop.getProperty("incometype_name")));
		Select sel5=new Select(ele7);
		sel5.selectByVisibleText("Salary");
		
		driver.findElement(By.name(prop.getProperty("Employer_name"))).sendKeys(prop.getProperty("Employer"));
		
		WebElement ele8=driver.findElement(By.name(prop.getProperty("employee_status_name")));
		Select sel6=new Select(ele8);
		sel6.selectByVisibleText("Active");
		
		driver.findElement(By.name(prop.getProperty("Work_Phone1_name"))).sendKeys(prop.getProperty("Work_Phone1"));
		driver.findElement(By.name(prop.getProperty("Work_Phone2_name"))).sendKeys(prop.getProperty("Work_Phone2"));
		driver.findElement(By.name(prop.getProperty("Work_Phone3_name"))).sendKeys(prop.getProperty("Work_Phone3"));
		driver.findElement(By.name(prop.getProperty("Work_Phone_ext_name"))).sendKeys(prop.getProperty("Work_Phone_ext"));
		driver.findElement(By.name(prop.getProperty("Net_Income_Amt_name"))).sendKeys(prop.getProperty("Net_Income_Amt"));
		driver.findElement(By.name(prop.getProperty("Gross_Income_Amt_name"))).sendKeys(prop.getProperty("Gross_Income_Amt"));
		
		WebElement ele9=driver.findElement(By.name(prop.getProperty("pay_frequency_name")));
		Select sel7=new Select(ele9);
		sel7.selectByVisibleText("Monthly");
		
		WebElement ele14=driver.findElement(By.name(prop.getProperty("monthly_date_name")));
		Select sel12=new Select(ele14);
		sel12.selectByIndex(1);
		
		/*driver.findElement(By.name("NPMM")).sendKeys("01");
		driver.findElement(By.name("NPDD")).sendKeys("01");
		driver.findElement(By.name("NPYYYY")).sendKeys("2018");*/
		
		driver.findElement(By.name(prop.getProperty("Pay_Stub_Reviewed_month_name"))).sendKeys(prop.getProperty("Pay_Stub_Reviewed_month"));
		driver.findElement(By.name(prop.getProperty("Pay_Stub_Reviewed_Date_name"))).sendKeys(prop.getProperty("Pay_Stub_Reviewed_Date"));
		driver.findElement(By.name(prop.getProperty("Pay_Stub_Reviewed_year_name"))).sendKeys(prop.getProperty("Pay_Stub_Reviewed_year"));
		
		driver.findElement(By.name(prop.getProperty("Pay_Stub_month_name"))).sendKeys(prop.getProperty("Pay_Stub_month"));
		driver.findElement(By.name(prop.getProperty("Pay_Stub_Date_name"))).sendKeys(prop.getProperty("Pay_Stub_Date"));
		driver.findElement(By.name(prop.getProperty("Pay_Stub_year_name"))).sendKeys(prop.getProperty("Pay_Stub_year"));
		
		driver.findElement(By.name(prop.getProperty("Hire_month_name"))).sendKeys(prop.getProperty("Hire_month"));
		driver.findElement(By.name(prop.getProperty("Hire_Date_name"))).sendKeys(prop.getProperty("Hire_Date"));
		driver.findElement(By.name(prop.getProperty("Hire_year_name"))).sendKeys(prop.getProperty("Hire_year"));
		
		WebElement ele10=driver.findElement(By.name(prop.getProperty("direct_deposit_name")));
		Select sel8=new Select(ele10);
		sel8.selectByVisibleText("No");
		
		driver.findElement(By.name(prop.getProperty("Account_Verification_month_name"))).sendKeys(prop.getProperty("Account_Verification_month"));
		driver.findElement(By.name(prop.getProperty("Account_Verification_Date_name"))).sendKeys(prop.getProperty("Account_Verification_Date"));
		driver.findElement(By.name(prop.getProperty("Account_Verification_year_name"))).sendKeys(prop.getProperty("Account_Verification_year"));
		
		driver.findElement(By.name(prop.getProperty("ABA/Routing_Nbr_name"))).sendKeys(prop.getProperty("ABA/Routing_Nbr"));
		driver.findElement(By.name(prop.getProperty("Confirm_ABA/Routing_Nbr_name"))).sendKeys(prop.getProperty("Confirm_ABA/Routing_Nbr"));
		
		driver.findElement(By.name(prop.getProperty("Chkg_Acct_Nbr_name"))).sendKeys(prop.getProperty("Chkg_Acct_Nbr"));
		driver.findElement(By.name(prop.getProperty("Confirm_Chkg_Acct_Nbr_name"))).sendKeys(prop.getProperty("Confirm_Chkg_Acct_Nbr"));
		
		//String chkngacntnmbr="1267";
		//System.out.println("Chkg Acct Nbr is "+chkngacntnmbr);
		
		driver.findElement(By.name(prop.getProperty("P1_Last_Name_name"))).sendKeys(prop.getProperty("P1_Last_Name"));
		driver.findElement(By.name(prop.getProperty("P1_First_Name_name"))).sendKeys(prop.getProperty("P1_First_Name"));
		
		WebElement ele11=driver.findElement(By.name(prop.getProperty("primary_relationship_name")));
		Select sel9=new Select(ele11);
		sel9.selectByVisibleText("Child");
		
		driver.findElement(By.name(prop.getProperty("P1_Phone_Nbr1_name"))).sendKeys(prop.getProperty("P1_Phone_Nbr1"));
		driver.findElement(By.name(prop.getProperty("P1_Phone_Nbr2_name"))).sendKeys(prop.getProperty("P1_Phone_Nbr2"));
		driver.findElement(By.name(prop.getProperty("P1_Phone_Nbr3_name"))).sendKeys(prop.getProperty("P1_Phone_Nbr3"));
		driver.findElement(By.name(prop.getProperty("P2_Last_Name_name"))).sendKeys(prop.getProperty("P2_Last_Name"));
		driver.findElement(By.name(prop.getProperty("P2_First_Name_name"))).sendKeys(prop.getProperty("P2_First_Name"));
		
		WebElement ele12=driver.findElement(By.name(prop.getProperty("secondary_relationship_name")));
		Select sel10=new Select(ele12);
		sel10.selectByVisibleText("Brother");
		
		driver.findElement(By.name(prop.getProperty("P2_Phone_Nbr1_name"))).sendKeys(prop.getProperty("P2_Phone_Nbr1"));
		driver.findElement(By.name(prop.getProperty("P2_Phone_Nbr2_name"))).sendKeys(prop.getProperty("P2_Phone_Nbr2"));
		driver.findElement(By.name(prop.getProperty("P2_Phone_Nbr3_name"))).sendKeys(prop.getProperty("P2_Phone_Nbr3"));
		
		driver.findElement(By.name(prop.getProperty("add_refer_name"))).click();
		
		WebElement ele13=driver.findElement(By.name(prop.getProperty("bankrupty_name")));
		Select sel11=new Select(ele13);
		sel11.selectByVisibleText("No");
		
		driver.findElement(By.name("Next")).click();
		
		WebElement ele15=driver.findElement(By.xpath("//td[@class='subHeading']//b"));	
		Bo_Code = ele15.getText();
		System.out.println("Test case passed "+Bo_Code);
		
		driver.close();
		
	}

}
