package Pages.AddContentPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Владимир on 20.06.2017.
 */
public class EditPagePage {

  private By addTitleLocator = By.xpath("//*[@id=\"title\"]");
  private By addTextLocator = By.xpath("//*[@id=\"content\"]");
  private By publishButtonLocator = By.xpath("//input[@id=\"publish\"]");
  private By buttonTextLocator = By.xpath("//*[@id=\"content-html\"]");
  private By buttonVisualLocator = By.xpath("//*[@id=\"wp-content-editor-tools\"]/div[2]");
  private By trashButtonLocator = By.xpath("//*[@id=\"delete-action\"]/a");
  private By editLabelLocator = By.xpath("//h1[@class=\"wp-heading-inline\"]");

  private WebDriver driver;

  public EditPagePage(WebDriver driver) {
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

  public void switchToText(){
    driver.findElement(buttonTextLocator).click();
  }

  public void switchToVisual(){
    driver.findElement(buttonVisualLocator).click();
  }

  public void publicPage(String title, String text){
    switchToText();
    addTitle(title);
    addText(text);
    publish();
  }

  public WebElement getEditLabelText(){
    return driver.findElement(editLabelLocator);
  }
  public void deletePage(){
    driver.findElement(trashButtonLocator).click();
  }
}
