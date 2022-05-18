package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCategoryPage extends BasePage {

	public AddCategoryPage(WebDriver driver) {
		this.driver = driver;

	}

	WebDriver driver;

	@FindBy(how = How.NAME, using = "categorydata")
	WebElement CATEGORY_NAME;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/input[2]")
	WebElement ADD_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/select[3]")
	WebElement DATE_DROPDOWN;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/select[1]")
	WebElement CATEGORY_DROPDOWN;
	@FindBy(how = How.XPATH, using = "//span[text()='BIKAL']")
	WebElement duplicateitem;
	public void AddingCategory(String ItemName) {

		int generatedNum = generateRandomNumber(9999);
		CATEGORY_NAME.sendKeys(ItemName +generatedNum);

	}

	public void Add() {

		ADD_BUTTON.click();

	}
//verifying dropdown element
	public void DropDown() {
		Select sel = new Select(DATE_DROPDOWN);
		List<String> actuallist = new ArrayList<String>();
		List<WebElement> dropdown = sel.getOptions();
		int i = 1;
		for (WebElement q : dropdown) {
			String date = q.getText();
			actuallist.add(date);
			System.out.println(i + "." + q.getText());
			i++;
		}

		List<String> temp = new ArrayList<String>();
		temp.addAll(actuallist);
		Assert.assertTrue(actuallist.equals(temp));

	}
	
	public void duplicateItem() {

		CATEGORY_NAME.sendKeys("KALAIYA");
		ADD_BUTTON.click();
		driver.navigate().back();
		if(duplicateitem.isDisplayed()){
			System.out.println("The category u want to add already exists");
		}else {
			System.out.println("not duplicated");
		}
}}
