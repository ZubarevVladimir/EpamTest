package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Contains mailbox's page elements for Chrome browser.
 */
public class MailboxPage {

  private By mailBoxLocator = By.id("b-letters");

  private WebDriver driver;

  public MailboxPage(WebDriver driver) {
    this.driver = driver;
  }
  /**
   * Find element, which means correct login.
   *
   * @return WebElement means correct login.
   */
  public WebElement getMailBox() {
    return driver.findElement(mailBoxLocator);
  }
}
