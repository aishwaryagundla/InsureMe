import org.testng.annotations.Test;

import com.project.staragile.insureme.Policy;
import com.project.staragile.insureme.PolicyService;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class InsureMeTest {
    WebDriver driver ;

	@Test
    public void f() {
	   String baseUrl = "https://www.staragile.com/";
	   System.out.println("Launching Google Chrome browser"); 
	   driver = new ChromeDriver();
	   driver.get(baseUrl);
	   String testTitle = "Free QA Automation Tools For Everyone";
	   String originalTitle = driver.getTitle();
	   Assert.assertEquals(originalTitle, testTitle);
   }
	
   @BeforeMethod
    public void beforeMethod() {
	System.out.println("Starting Test On Chrome Browser");
    }
	
    @AfterMethod
     public void afterMethod() {
	 driver.close();
	 System.out.println("Finished Test On Chrome Browser");
    }
	@Test
	public void testCreatePolicy() {
		Policy policy = new Policy(1, "Shubham", "Individual" , 10000, "10-Sep-2021", "10-Sep-2022");
		PolicyService pService = new PolicyService();
		//Policy outputPolicy = pService.CreatePolicy();
		assertEquals(policy.getPolicyId(), pService.generateDummyPolicy().getPolicyId());
		
	}
	
	@Test
	public void testSearchPolicy() {
		PolicyService pService = new PolicyService();
		assertEquals(null,pService.searchPolicy());
	}

}
