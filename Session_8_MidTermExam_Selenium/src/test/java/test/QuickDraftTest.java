package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.LoginPage;
import page.QuicDraftPage;
import util.BrowserFactory;

public class QuickDraftTest {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		driver = BrowserFactory.startBrowser();

	}

	@Test
	public void userShouldBeAbleToPostDraft() throws InterruptedException {
//	Go to site
		driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");

//  Calling LoginPage Class or Activate
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

// Validate you went to the right site
		String expectedTitle = "Log In ‹ opensourcecms — WordPress";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Wrong Page!!!");

// Call the login method from the LoginPage Class
		loginPage.login("opensourcecms", "opensourcecms");

// Validate page show up using the Explicit Wait
		QuicDraftPage quickDraftPage = PageFactory.initElements(driver, QuicDraftPage.class); // Object Reference
		quickDraftPage.waitForPage();

		// Create a quick draft ( Method would take the title, content, and click on
		// Save Draft) -- Consider using random
		quickDraftPage.createQuickDraft("Test draft", "Test Content");

		// Validate the post appeared below under "Your recent Drafts"
		quickDraftPage.isPosted();

//	Click on the Posts Menu, click on All Posts
		quickDraftPage.postButton();

//	Validate the post appeared in the table

	}

	/*
	 * @AfterMethod public void close() { driver.close(); driver.quit();
	 */
}
