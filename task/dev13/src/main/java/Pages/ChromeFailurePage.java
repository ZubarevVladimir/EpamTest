package Pages;

import Pages.Intarfaces.FailurePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Contains fail's page elements for Chrome browser.
 */
public class ChromeFailurePage implements FailurePage {

  private By loginErrorsLocator = By.className("b-login__errors");

  private WebDriver driver;

  public ChromeFailurePage(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Find element, which means incorrect login in Chrome browser.
   *
   * @return WebElement means incorrect login.
   */
  public WebElement getLoginErrorBox(){
    return driver.findElement(loginErrorsLocator);
  }
}
