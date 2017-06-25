package TWMFramework.Page;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Contain method for getting information and elements from  web page.
 */
public class TestPage {

  private WebDriver driver;

  public TestPage(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Find web element by given link name.
   *
   * @param linkName - link name searched web element.
   * @return WebElement - element with given link name.
   */
  public WebElement getLinkPresentByName(String linkName) {
    WebElement searchElement;
    try {
      searchElement = driver.findElement(By.xpath("//a[text()=\"" + linkName + "\"]"));
    } catch (NoSuchElementException e) {
      searchElement = null;
    }
    return searchElement;
  }

  /**
   * Return page title.
   *
   * @return String - page title.
   */
  public String getPageTitle() {
    return driver.getTitle();
  }

  /**
   * Return page content.
   *
   * @return String - page content.
   */
  public String getPageContent() {
    return driver.getPageSource();
  }

  /**
   * Open web page wth given url.
   *
   * @param url url opened web page.
   * @param timeout waiting time.
   */
  public void open(String url, int timeout) {
    driver.get(url);
    driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
  }

  /**
   * Find error web element.
   *
   * @return WebElement - errror web element.
   */
  public WebElement getErrorElement() {
    WebElement errorElement;
    try {
      errorElement = driver.findElement(By.className("error-code"));
    } catch (NoSuchElementException e) {
      errorElement = null;
    }
    return errorElement;
  }

  /**
   * Find web element by given link href.
   *
   * @param href - link href searched web element.
   * @return WebElement - element with given link href.
   */
  public WebElement getLinkPresentByHref(String href) {
    WebElement searchElement;
    try {
      searchElement = driver.findElement(By.xpath("//a[@href=\"" + href + "\"]"));
    } catch (NoSuchElementException e) {
      searchElement = null;
    }
    return searchElement;
  }

  /**
   * Close WebDriver.
   */
  public void close() {
    driver.close();
  }
}