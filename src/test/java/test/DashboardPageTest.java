package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import pages.DashboardPage;
import util.BrowserFactory;

public class DashboardPageTest {
	WebDriver driver;
	String categoryName = "Furniture";
	String itemName = "couch--sofa";
	
	@Test
	public void checkAllCheckBoxes() {
		 driver = BrowserFactory.init();
		
		DashboardPage dp = PageFactory.initElements(driver, DashboardPage.class);
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
	
	
//	Test 3: Validate that all list item could be removed using the 
//    remove button and when "Toggle All" functionality is on.
	
	
}
