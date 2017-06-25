package Pages.AddContentPages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Владимир on 20.06.2017.
 */
public class AllPagesPage {

  private By addPageLocator = By.xpath("//*[@id=\"wpbody-content\"]/div[3]/a");
  private By pagesListLocator = By.xpath("//a[@class=\"row-title\"]");
  private By deleteMessageLocator = By.xpath("//div[@id=\"message\"]");

  private WebDriver driver;

  public AllPagesPage(WebDriver driver) {
    this.driver = driver;
  }

  public EditPagePage addPage() {
    driver.findElement(addPageLocator).click();
    return new EditPagePage(driver);
  }
  public WebElement getMessageDelete(){
    return driver.findElement(deleteMessageLocator);
  }

  public List<WebElement> getPostsList() {
    return driver.findElements(pagesListLocator);
  }

  public EditPagePage openByTitle(String title) {
    for (WebElement element : getPostsList()) {
      if (element.getText().equals(title)) {
        element.click();
        break;
      }
    }
    return new EditPagePage(driver);
  }
}
