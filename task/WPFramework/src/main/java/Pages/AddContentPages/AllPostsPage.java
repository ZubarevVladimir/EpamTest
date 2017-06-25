package Pages.AddContentPages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Владимир on 20.06.2017.
 */
public class AllPostsPage {

  private By addPostLocator = By.xpath("//*[@id=\"wpbody-content\"]/div[3]/a");
  private By deleteMessageLocator = By.xpath("//div[@id=\"message\"]");

  private WebDriver driver;

  public AllPostsPage(WebDriver driver) {
    this.driver = driver;
  }

  public EditPostPage addPost() {
    driver.findElement(addPostLocator).click();
    return new EditPostPage(driver);
  }

  public WebElement getMessageDelete(){
    return driver.findElement(deleteMessageLocator);
  }

}

