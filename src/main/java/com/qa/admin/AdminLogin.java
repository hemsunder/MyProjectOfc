package com.qa.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qc.base.TestBase;

public class AdminLogin extends TestBase{
	
	@FindBy(name="loginRequestBean.userId")
	WebElement username;
	
	@FindBy(name="loginRequestBean.password")
	WebElement password;
	
	@FindBy(name="login")
	WebElement loginbtn;
	
	public AdminLogin(){
		PageFactory.initElements(driver, this);
	}
	
	public void loginpage(){
		username.sendKeys("admin");
		password.sendKeys("1234");
		loginbtn.click();
	}
	
	

}
