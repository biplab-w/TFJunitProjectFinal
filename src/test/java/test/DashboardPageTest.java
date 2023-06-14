package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import pages.DashboardPage;
import util.BasePage;
import util.BrowserFactory;

public class DashboardPageTest extends BasePage{
	WebDriver driver;
	DashboardPage dp;
	String categoryName;
	String itemName;
	@Before
	public void initializeBrowser() {
		driver = BrowserFactory.init();
		dp = PageFactory.initElements(driver, DashboardPage.class);
		categoryName = "Furniture" + generateRandomNumber();
		itemName = "Couch" + generateRandomNumber();
	}
	
	@Test
	public void checkAllCheckBoxes() {
		 
		dp = PageFactory.initElements(driver, DashboardPage.class);
//		Test 1: Validate when the toggle all check box is CHECKED, 
//      all check boxes for list items are also CHECKED ON.
		dp.clickOnAllCheckBox();
		
		//assert all checkboxes are selected
		if((dp.getListItemsCheckboxes()).size() !=0) {
		for(WebElement item : dp.getListItemsCheckboxes()) {
			assertTrue(item.isSelected());
		}
		}
	}
	
	
//	Test 2: Validate that a single list item could be removed using the
//	remove button when a single checkbox is selected.
	@Test
	public void checkSingleItemRemoved() {
		
		//Lets add the item first and remove the same item
		//Lets randomize the category name everytime fill the field
		dp.insertIntoCategoryField(categoryName);
		dp.clickOnAddCategoryButton();
		dp.insertIntoItemNameField(itemName);
		dp.clickAddItemButton();
		
		//Validate the item name has been added correctly
		assertTrue(dp.validateSingleItemHasBeenAdded(itemName));
		
		
	}
	
//	Test 3: Validate that all list item could be removed using the 
//    remove button and when "Toggle All" functionality is on.
	
	
}
