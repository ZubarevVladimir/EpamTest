package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Владимир on 20.06.2017.
 */
public class HomePage {

  private By errorElementLocator = By.xpath("//div[@id=\"login_error\"]");
  private By mainPageLocator = By.xpath("//li[@id=\"wp-admin-bar-wp-logo\"]");


  private WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Set in login field given string.
   *
   * @param login string contains set login.
   * @return WorkPages.LoginPage - page with set login.
   */
  public void typeLogin(String login) {

  }

  public MainPage getMainPage(){
    driver.findElement(mainPageLocator).click();
    return new MainPage(driver);
  }
}
