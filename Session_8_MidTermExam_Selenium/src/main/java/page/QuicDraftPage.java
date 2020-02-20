package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class QuicDraftPage extends BasePage {
	
	WebDriver driver; // Global

	// Every Page must have a constructor to invite the driver
	public QuicDraftPage(WebDriver driver) {
	this.driver = driver;
	}
	
	// Element Library
			@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Dashboard')]")
			WebElement PageTitle;
			@FindBy(how = How.ID,using = "title")
			WebElement DraftTitle;
			@FindBy(how = How.ID,using = "content")
			WebElement DraftContent;
			@FindBy(how = How.ID,using = "save-post")
			WebElement SaveDraft;
			
			@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Your Recent Drafts')]/parent::div/descendant::a")
			WebElement PostedTitle;
			@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Your Recent Drafts')]/parent::div/descendant::p")
			WebElement PostedContent;
			
			@FindBy(how = How.XPATH, using = "//div[@class='wp-menu-image dashicons-before dashicons-admin-post']")
			WebElement PostButton;
			
			@FindBy(how = How.LINK_TEXT,using = "All Posts")
			WebElement AllPostButton;
			
		
			
			// Methods to interact with the elements
			public void waitForPage() {
				waitForElement(PageTitle, driver);
			}
			
			public void createQuickDraft(String title,String content) {
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("scroll(0,2000)");
				DraftTitle.sendKeys(title);
				DraftContent.sendKeys(content);
				SaveDraft.click();
				
			}
			
			// Methods to validate draft was posted
			public boolean isPosted() {
				PostedTitle.isDisplayed();
				return PostedTitle.isDisplayed();
				
			}
			
			public void postButton() {
				PostButton.click();
				AllPostButton.click();
				
			}
			
			
			
				
}
