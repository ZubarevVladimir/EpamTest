package Pages.AddContentPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Владимир on 20.06.2017.
 */
public class EditCommentPage {

  private By trashButtonLocator = By.xpath("//*[@id=\"delete-action\"]/a");

  private WebDriver driver;

  public EditCommentPage(WebDriver driver) {
    this.driver = driver;
  }

  public void deleteComment(){
    driver.findElement(trashButtonLocator).click();
  }
}
