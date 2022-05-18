package addcategoryTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCategoryPage;
import page.DashboardPage;
import util.BrowserFactory;

public class AddCategoryTest {

	WebDriver driver;
	String CategoryName = "Bikal";
@Test
	public void Test1() {

		driver = BrowserFactory.init();

		AddCategoryPage addcategory = PageFactory.initElements(driver, AddCategoryPage.class);
		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.VerifyDashboardHeader();

		for (int i = 0; i < 1; i++) {

			addcategory.AddingCategory(CategoryName);
			addcategory.Add();
		}
	}

	@Test
	private void Test2() {
		driver = BrowserFactory.init();
		AddCategoryPage addcategory = PageFactory.initElements(driver, AddCategoryPage.class);
		addcategory.duplicateItem();

	}


	public void Test3() {
		driver = BrowserFactory.init();
		AddCategoryPage addcategory = PageFactory.initElements(driver, AddCategoryPage.class);
		addcategory.DropDown();
		

	}
}