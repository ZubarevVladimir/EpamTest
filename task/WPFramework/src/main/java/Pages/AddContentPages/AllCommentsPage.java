package Pages.AddContentPages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Владимир on 22.06.2017.
 */
public class AllCommentsPage {

  private By allButtonLocator = By.xpath("//li[@class=\"all\"]");
  private By trashButtonLocator = By.xpath("//li[@class=\"trash\"]");
  private By listCommentsLocator = By.xpath("//td[2]/p");

  private WebDriver driver;

  public AllCommentsPage(WebDriver driver) {
    this.driver = driver;
  }

  public AllCommentsPage toDeleteComments() {
    driver.findElement(trashButtonLocator).click();
    return this;
  }

  public AllCommentsPage toAllComments() {
    driver.findElement(allButtonLocator).click();
    return this;
  }

  public List<WebElement> getCommentsTextList(){
    return driver.findElements(listCommentsLocator);
  }

}
