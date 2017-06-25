package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Contains mailbox's page elements for Chrome browser.
 */
public class StartPage {

  private By logInLocator = By.xpath("//*[@id=\"meta-2\"]/ul/li[1]/a");
  private By toSiteButtonLocator = By.xpath("//a[@class=\"ab-item\"]");
  private By postsListLocator = By.xpath("//a[@rel=\"bookmark\"]");

  private WebDriver driver;

  public StartPage(WebDriver driver) {
    this.driver = driver;
  }

  public LoginPage getLoginPage() {
    driver.findElement(logInLocator).click();
    return new LoginPage(driver);
  }

  public MainPage toMainPage() {
    driver.findElement(toSiteButtonLocator).click();
    return new MainPage(driver);
  }

  public List<WebElement> getPostsList() {
    return driver.findElements(postsListLocator);
  }

  public PostPage openByTitle(String title) {
    for (WebElement element : getPostsList()) {
      if (element.getText().equals(title)) {
        element.click();
        break;
      }
    }
    return new PostPage(driver);
  }

}
