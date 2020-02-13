package com.qc.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qc.ILP.ILPALLTransactions;
import com.qc.PDL.PDLALLTransactions;
import com.qc.base.TestBase;
import com.qc.misctrans.MiscTransactions;
import com.qc.tlp.pages.TLPAllTransactions;
import com.qc.uloc.pages.ULOCALLTransactions;
import com.qc.utilities.RegistrationPage;
import com.qc.utilities.Utilities;

import Online.NewOnlineLoan;


@Listeners({com.qc.ExtentReportListener.ExtentReporterNG.class, com.qa.Listeners.MyTransformer.class})

public class QCTestCases extends TestBase{
	 
	 Utilities utilities;
	 RegistrationPage custreg;
	 PDLALLTransactions pdlall;
	 ULOCALLTransactions ulocall;
	 ILPALLTransactions ilpall;
	 MiscTransactions misctrans;
	 NewOnlineLoan online;
	 TLPAllTransactions tlpall;
	 
	public QCTestCases(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		 initialization();
		 utilities=new Utilities();
		 custreg=new RegistrationPage();
		 pdlall=new PDLALLTransactions();
		 ulocall=new ULOCALLTransactions();
		 ilpall=new ILPALLTransactions();
		 misctrans=new MiscTransactions();
		 online=new NewOnlineLoan();
		 tlpall=new TLPAllTransactions();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
		
	@Test(priority=1,  enabled=true)
	public void RegistrationTest() throws Exception{	
		custreg.Registration();
		//online.newloanforMO();
	}
	
	@Test(priority=2,  enabled=false)
	public void InsightCardWithdrawalTest() throws Exception{
		misctrans.InsightWithdraw();
	}
		
	@Test(priority=2,  enabled=false)
	public void newloantest() throws Exception{
		//pdlall.NewPDLByACH(null);
		//pdlall.NewPDLByDC(null);
		//ilpall.Term1ILPByACH();
		tlpall.Term1TLPByACH();
		//tlpall.Term1TLPBySignature();
		//tlpall.Term1TLPByDebitCard(); 
		//ilpall.Term2ILPByCHECK();
		//ilpall.Term1ILPByDEBITCARD();
		//ulocall.NewLoanByACH("ACH");
	}
	
	@Test(priority=3,  enabled=false)
	public void LoanVoidTest(){
		//pdlall.PDLVoid();
		//tlpall.VoidLoan();
		//ilpall.VoidLoan();
		ulocall.VoidLoan();
	}
	
	@Test(priority=4,  enabled=false)
		public void LoanRescindTest(){
			//pdlall.RescindPDL();
			//ilpall.RescindLoan();
			tlpall.RescindLoan();
	}

	@Test(priority=3, enabled=false)
	public void PartialPaymentTest() throws Exception{
		//tlpall.PayInstPayment();
		//pdlall.PartialPayment(null);
		ilpall.PayInstPayment();
		//ilpall.PayanyotherAmount();
		//tlpall.PayanyotherAmount();
	}
	
	@Test(priority=4, enabled=false)
	public void PartialPaymentVoidTest() {
		//pdlall.PartialPaymentVoid();
		//ilpall.PayInstPaymentVoid();
		tlpall.PayInstPaymentVoid();
	}
	
	@Test(priority=5, enabled=false)
	public void BuyBackTest() throws Exception {
		//pdlall.BuyBack();
		//ilpall.Payoff();
		tlpall.Payoff();
	
	}
	
	@Test(priority=6, enabled=false)
	public void BuyBackVoidTest() {
		//pdlall.BuyBackVoid();
		//ilpall.PayoffVoid();
		tlpall.PayoffVoid();
	}
	
	@Test(priority=7, retryAnalyzer=com.qa.Listeners.RetryAnalyzer.class, enabled=false)
	public void EPPTest() throws Exception {
		pdlall.EPP();
	}
	
	@Test(priority=8, retryAnalyzer=com.qa.Listeners.RetryAnalyzer.class, enabled=false)
	public void EPPPaymentTest() throws Exception {
		pdlall.EPPPayment();
	}
	
	@Test(priority=9, retryAnalyzer=com.qa.Listeners.RetryAnalyzer.class, enabled=false)
	public void EPPPaymentVoidTest() {
		pdlall.EPPPaymentVoid();
	}
	
	@Test(priority=10, retryAnalyzer=com.qa.Listeners.RetryAnalyzer.class, enabled=false)
	public void EPPVoidTest() {
		pdlall.EPPVoid();
	}
	
	@Test(priority=11, enabled=false)
	public void ACHDepositTest() {
		//pdlall.ACHDeposit();
		ilpall.ACHDeposit();
		//tlpall.ACHDeposit();
	}
	
	@Test(priority=12, enabled=false)
	public void ACHPrePaymentTest() throws Exception {
		pdlall.ACHPrePayment();
	}
	
	@Test(priority=13, enabled=false)
	public void ACHPrePaymentVoidTest() {
		pdlall.ACHPrePaymentVoid();
	}
	
	@Test(priority=14, enabled=false)
	public void ACHDepositVoidTest() {
		//pdlall.ACHDepositVoid();
		ilpall.ACHDepositVoid();
		//tlpall.ACHDepositVoid();
	}
	
	@Test(priority=19, enabled=false)
	public void ChargebackTest() throws Exception {
		//pdlall.chargeback();
		//ilpall.chargeback();
		tlpall.chargeback();
	}
	
	@Test(priority=16, enabled=false)
	public void DCDepositTest() throws Exception {
		//pdlall.DCDeposit();
		//ilpall.DCDeposit();
		tlpall.DCDeposit();
	}
	
	@Test(priority=17, enabled=false)
	public void DCDepositVoidTest() throws Exception {
		//pdlall.DCDepositVoid();
		//ilpall.DCDepositVoid();
		tlpall.DCDepositVoid();
	}
	
	@Test(priority=20,  enabled=false)
	public void DCRevokeTest() throws Exception {
		//pdlall.DCRevoke();
		//ilpall.DCRevoke();
		tlpall.DCRevoke();
	}
	
	@Test(priority=18, retryAnalyzer=com.qa.Listeners.RetryAnalyzer.class, enabled=false)
	public void DCDepositTest2() throws Exception {
		pdlall.DCDeposit();
	}
	
	@Test(priority=21, retryAnalyzer=com.qa.Listeners.RetryAnalyzer.class, enabled=false)
	public void RefinanceTest() throws Exception {
		pdlall.Refinance();
	}	
	
	
	
}
