package testCases;

// modified something....

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	@Test(groups= {"sanity","master"})
	public void test_Login()
	{
		logger.info("Starting TC_002_LoginTest.....");
		
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
			
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		Assert.assertEquals(targetPage,true);
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		logger.info("Finishing TC_002_LoginTest.....");
	}
}
