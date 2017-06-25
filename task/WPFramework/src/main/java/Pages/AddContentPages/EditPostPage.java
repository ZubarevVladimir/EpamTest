package Pages.AddContentPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Владимир on 20.06.2017.
 */
public class EditPostPage {

  private By addTitleLocator = By.xpath("//*[@id=\"title\"]");
  private By addTextLocator = By.xpath("//*[@id=\"content\"]");
  private By buttonTextLocator = By.xpath("//*[@id=\"content-html\"]");
  private By buttonVisualLocator = By.xpath("//*[@id=\"wp-content-editor-tools\"]/div[2]");
  private By publishButtonLocator = By.xpath("//input[@id=\"publish\"]");
  private By trashButtonLocator = By.xpath("//*[@id=\"delete-action\"]/a");

  private WebDriver driver;

  public EditPostPage(WebDriver driver) {
    this.driver = driver;
  }

  public void addTitle(String title) {
    driver.findElement(addTitleLocator).sendKeys(title);
  }

  public void addText(String text) {
    driver.findElement(addTextLocator).sendKeys(text);
  }

  public void publish() {
    driver.findElement(publishButtonLocator).click();
  }

  public void switchToText() {
    driver.findElement(buttonTextLocator).click();
  }

  public void switchToVisual() {
    driver.findElement(buttonVisualLocator).click();
  }

  public void publicPost(String title, String text) {
    switchToText();
    addTitle(title);
    addText(text);
    publish();
  }

  public void deletePost() {
    driver.findElement(trashButtonLocator).click();
  }
}
