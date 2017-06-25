package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Contains login's page elements for Chrome browser.
 */
public class LoginPage {

  private By loginLocator = By.xpath("//input[@id=\"user_login\"]");
  private By passwordLocator = By.xpath("//input[@id=\"user_pass\"]");
  private By loginButtonLocator = By.xpath("//input[@id=\"wp-submit\"]");
  private By errorElementLocator = By.xpath("//div[@id=\"login_error\"]");

  private WebDriver driver;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Set in login field given string.
   *
   * @param login string contains set login.
   * @return WorkPages.LoginPage - page with set login.
   */
  public void typeLogin(String login) {
    driver.findElement(loginLocator).sendKeys(login);
  }

  /**
   * Set in password field given string.
   *
   * @param password string contains set password.
   * @return WorkPages.LoginPage - page with set password.
   */
  public void typePassword(String password) {
    driver.findElement(passwordLocator).sendKeys(password);
  }

  private MainPage submitLogin() {
    driver.findElement(loginButtonLocator).submit();
    return new MainPage(driver);
  }

  /**
   * Login to mail with given data.
   *
   * @param login inputs login.
   * @param password inputs password.
   * @return MailboxPage - mailbox page after login.
   */
  public MainPage loginAs(String login, String password) {
    //try {
      typeLogin(login);
      //TimeUnit.SECONDS.sleep(1);
      typePassword(password);
     // TimeUnit.SECONDS.sleep(1);
    //} catch (InterruptedException ex){}
    return submitLogin();
  }

  public LoginPage failureLoginAs(String login, String password) {
    //try {
      typeLogin(login);
      //TimeUnit.SECONDS.sleep(1);
      typePassword(password);
      //TimeUnit.SECONDS.sleep(1);
      driver.findElement(loginButtonLocator).click();
      //TimeUnit.SECONDS.sleep(1);
    //} catch (InterruptedException ex) {
     // System.out.println("Interupt ex");
    //}
    return new LoginPage(driver);
  }

  public WebElement getErrorElement() {
    return driver.findElement(errorElementLocator);
  }
}
