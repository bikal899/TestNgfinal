package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
public class DashboardPage {
	WebDriver driver;

		public DashboardPage(WebDriver driver) {
			this.driver = driver;

		}
		@FindBy(how = How.XPATH, using = "//*[@id=\"label-first\"]/b")
		WebElement DASHBOARDHEADER;
		
		public void VerifyDashboardHeader() {
			WebElement VerifyDB = DASHBOARDHEADER;
			String VDB = VerifyDB.getText();
			Assert.assertEquals("NSS-TODO List v 1.1",VDB,"WrongPage" );
			
		}
}
