package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	//WebElements
	@FindBy(how =How.CSS, using="input[name='allbox']") WebElement allCheckBox;
	@FindBy(how =How.CSS, using="input[name^='todo']") List<WebElement> listItemsCheckboxes;
	@FindBy(how=How.CSS, using="input[name='categorydata']") WebElement categoryField;
	@FindBy(how= How.CSS, using="input[value='Add category']") WebElement addCategoryButton;
	@FindBy(how= How.CSS, using ="input[name='data']") WebElement itemNameField;
	@FindBy(how=How.CSS, using ="input[value='Add']") WebElement itemAddButton;
	@FindBy(how=How.CSS, using ="select[name='category']") WebElement select;
	//Interactable methods
	
	public void clickOnAllCheckBox() {
		allCheckBox.click();
	}
	
	public List<WebElement> getListItemsCheckboxes(){
		
		return listItemsCheckboxes;
	}
	
}
