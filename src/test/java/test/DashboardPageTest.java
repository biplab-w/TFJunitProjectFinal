package test;

import static org.junit.Assert.*;

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
	DashboardPage dashboardPage;
	String categoryName;
	String itemName;
	
	@Before
	public void initializeBrowser() {
		driver = BrowserFactory.init();
		dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		categoryName = "Furniture" + generateRandomNumber();
	}
	
	@Test
	public void checkAllCheckBoxes() {
		 
//		Test 1: Validate when the toggle all check box is CHECKED, 
//      all check boxes for list items are also CHECKED ON.

		//Add some items -- since the list might be empty at first
		for(int i=0; i<4; i++) {
			itemAddHelperMethod();
		}
		dashboardPage.clickOnAllCheckBox();
		
		//assert all checkboxes are selected if the checkboxes are of length more than 1
		if((dashboardPage.getListItemsCheckboxes()).size() !=0) {
		for(WebElement item : dashboardPage.getListItemsCheckboxes()) {
			assertTrue(item.isSelected());
		}
		}
	}
	
	
//	Test 2: Validate that a single list item could be removed using the
//	remove button when a single checkbox is selected.
	@Test
	public void checkSingleItemRemoved() {
		
		//Add the item first and remove the same item
		//Randomize the category name everytime fill the field
		dashboardPage.insertIntoCategoryField(categoryName);
		dashboardPage.clickOnAddCategoryButton();
		
		//Add items using helper method
		String itemN = itemAddHelperMethod();
		
		//Validate the item name has been added correctly
		assertTrue(dashboardPage.validateSingleItemHasBeenAdded(itemName));
		
		//select single list Item and remove it
		assertEquals(dashboardPage.removeSingleItemAndValidate(itemName), itemN);
		
		
	}
	
//	Test 3: Validate that all list item could be removed using the 
//    remove button and when "Toggle All" functionality is on.
	
	public String itemAddHelperMethod() {
		itemName = "Couch" + generateRandomNumber();
		dashboardPage.insertIntoItemNameField(itemName);
		dashboardPage.clickAddItemButton();
		return itemName;
	}
	
}
