package Pages;

import Pages.Intarfaces.FailurePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Contains fail's page elements for Firefox browser.
 */
public class FirefoxFailurePage implements FailurePage {

  private By loginErrorsLocator = By.className("mailbox__authfail");

  private WebDriver driver;

  public FirefoxFailurePage(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Find element, which means incorrect login in Firefox browser.
   *
   * @return WebElement means incorrect login.
   */
  public WebElement getLoginErrorBox() {
    return driver.findElement(loginErrorsLocator);
  }


}
