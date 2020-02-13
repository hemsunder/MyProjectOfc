package com.qc.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import com.aventstack.extentreports.ExtentReports;

public class TestBase {
	public static ExtentReports extent;
	public static Properties prop;
	public static WebDriver driver;
	public static Excel TestData;
	
	public TestBase() {
		try {
			prop=new Properties();
			
			FileInputStream fis= new FileInputStream("C:/Selenium/QCProject/src/main/java/com/qc/config/config.properties");
			//FileInputStream fis= new FileInputStream("C:/MyProjects/QCProject/src/main/java/com/qc/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("File not found. Please update file path");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File not found. Please update file path");
			e.printStackTrace();
		} 
		
		try {
			TestData = new Excel("C:/MyProjects/QCProject/src/main/java/com/qc/testdata/Registration1.xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void initialization(){
		
		
		String browsername=prop.getProperty("browser");
		String Mode=prop.getProperty("browserMode");
		
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Selenium WebDriver/Drivers/ChromeDriver78/chromedriver.exe");
			if(Mode.equals("headless")){
				ChromeOptions options = new ChromeOptions();
				options.addArguments("window-size=1400,800");
				options.addArguments("headless");
				driver=new ChromeDriver(options);
			}
			else {
				driver=new ChromeDriver();
			}
			
			
		} else if(browsername.equals("ie")){
			System.setProperty("webdriver.ie.driver", "C:/Selenium WebDriver/Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		else if(browsername.equals("htmlunit")){
			HtmlUnitDriver driver = new HtmlUnitDriver();
			driver.setJavascriptEnabled(true);
		}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//driver.get(prop.getProperty("url"));
	}
	
	
}
