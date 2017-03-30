import static org.testng.Assert.*;

import DataProvider.DataForTests;
import Pages.Intarfaces.FailurePage;
import Pages.MailboxPage;
import Pages.LoginPage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MailRuTest {

  private WebDriver driver;
  private LoginPage loginPage;

  @Parameters({"propertyKey", "propertyValue", "driver"})
  @BeforeMethod
  public void setUp(String propertyKey, String propertyValue, String strDriver) throws Exception {
    System.setProperty(propertyKey, propertyValue);
    switch (strDriver) {
      case ("chrome"):
        this.driver = new ChromeDriver();
        break;
      case ("firefox"):
        this.driver = new FirefoxDriver();
        break;
    }
    driver.get("http://www.mail.ru");
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    loginPage = new LoginPage(driver);
  }

  @Test(dataProvider = "getDataCorrectLogin", dataProviderClass = DataForTests.class)
  public void correctPasswordTest(String login, String password) {
    MailboxPage mailBoxPage = loginPage.loginAs(login, password);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    assertNotNull(mailBoxPage.getMailBox());
  }

  @Test(dataProvider = "getDataNegativeTest", dataProviderClass = DataForTests.class)
  public void testNegativeLogin(String login, String password) {
    loginPage.typeLogin(login);
    loginPage.typePassword(password);
    FailurePage failurePage = loginPage.submitFailurePageLogin();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    assertNotNull(failurePage.getLoginErrorBox());
  }

  @AfterMethod
  public void tearDown() throws Exception {
    driver.quit();
  }
}