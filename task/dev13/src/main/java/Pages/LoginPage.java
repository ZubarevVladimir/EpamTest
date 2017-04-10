package Pages;

import Pages.Intarfaces.FailurePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Contains login's page elements for Chrome browser.
 */
public class LoginPage {

  private By loginLocator = By.id("mailbox__login");
  private By passwordLocator = By.id("mailbox__password");
  private By loginButtonLocator = By.id("mailbox__auth__button");

  private WebDriver driver;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Set in login field given string.
   *
   * @param login string contains set login.
   * @return LoginPage - page with set login.
   */
  public LoginPage typeLogin(String login) {
    driver.findElement(loginLocator).sendKeys(login);
    return this;
  }

  /**
   * Set in password field given string.
   *
   * @param password string contains set password.
   * @return LoginPage - page with set password.
   */
  public LoginPage typePassword(String password) {
    driver.findElement(passwordLocator).sendKeys(password);
    return this;
  }

  private MailboxPage submitLogin() {
    driver.findElement(loginButtonLocator).submit();
    return new MailboxPage(driver);
  }

  /**
   * Open failure page.
   *
   * @return FailurePage - failure page for given browser.
   */
  public FailurePage submitFailurePageLogin() {
    driver.findElement(loginButtonLocator).submit();
    if (driver instanceof ChromeDriver) {
      driver.getClass().getSimpleName();
      return new ChromeFailurePage(driver);
    } else if (driver instanceof FirefoxDriver) {
      return new FirefoxFailurePage(driver);
    }
    return null;
  }

  /**
   * Login to mail with given data.
   *
   * @param login inputs login.
   * @param password inputs password.
   * @return MailboxPage - mailbox page after login.
   */
  public MailboxPage loginAs(String login, String password) {
    typeLogin(login);
    typePassword(password);
    return submitLogin();
  }
}
