package Pages;

import Pages.AddContentPages.AllCommentsPage;
import Pages.AddContentPages.AllPagesPage;
import Pages.AddContentPages.AllPostsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

  private By allPostLocator = By.xpath("//li/a[@href=\"edit.php\"]");
  private By adminNameLocator = By.xpath("//span[@class=\"display-name\"]");
  private By allPagesLocator = By.xpath("//li/a[@href=\"edit.php?post_type=page\"]");
  private By toSiteButtonLocator = By.xpath("//*[@id=\"wp-admin-bar-site-name\"]");
  private By allCommentsLocator = By.xpath("//li[@id=\"menu-comments\"]");

  private WebDriver driver;

  public MainPage(WebDriver driver) {
    this.driver = driver;
  }

  public AllPostsPage toAllPostsPage() {
    driver.findElement(allPostLocator).click();
    return new AllPostsPage(driver);
  }

  public AllPagesPage toAllPagesPage() {
    driver.findElement(allPagesLocator).click();
    return new AllPagesPage(driver);
  }

  public StartPage toSite(){
    driver.findElement(toSiteButtonLocator).click();
    return new StartPage(driver);
  }

  public AllCommentsPage toAllCommentsPage(){
    driver.findElement(allCommentsLocator).click();
    return new AllCommentsPage(driver);
  }
  public String getAdminName(){
    return driver.findElement(adminNameLocator).getText();
  }
}
