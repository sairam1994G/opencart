package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	@Test(groups= {"regression","master"})
	public void test_accountRegistration()
	{
		logger.info("******* starting TC_001_AccountRegistrationTest *******");
		
		HomePage hp=new HomePage(driver);
		logger.info("Clicking on MyAccount link");
		hp.clickMyAccount();
		
		logger.info("Clicking on register link");
		hp.clickRegister();
		
		logger.info("Providing customers details");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
		logger.info("Registration successful...");
		Assert.assertTrue(true);
		}
		else
		{
			logger.error("Registration failed");
				Assert.fail();
		}
		logger.info("******* Finished TC_001_AccountRegistrationTest *******");
	}
		
	
}

