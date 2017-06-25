package Pages;

import Pages.AddContentPages.*;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PostPage {

  private By commentsEditLocator = By.className("comment-edit-link");
  private By inputCommentBoxLocator = By.id("comment");
  private By commentButtonLocator = By.id("submit");
  private By commentsListLocator = By.xpath("//*[@class=\"comment-body\"]");
  private By postsEditButtonLocator = By.xpath("//footer/span/a");
  private By postTitleLocator = By.xpath("//div[@class=\"entry-content\"]");
  private By commentTextLocator = By.className("comment-content");

  private WebDriver driver;

  public PostPage(WebDriver driver) {
    this.driver = driver;
  }

  public void putComment(String comment) {
    driver.findElement(inputCommentBoxLocator).sendKeys(comment);
    driver.findElement(commentButtonLocator).click();
  }

  private List<WebElement> getCommentsList() {
    return driver.findElements(commentsListLocator);
  }

  public EditPostPage editPost() {
    driver.findElement(postsEditButtonLocator).click();
    return new EditPostPage(driver);
  }

  /*public List<WebElement> getCommentEditList() {
    return driver.findElements(commentsEditLocator);
  }

  public EditCommentPage getLastComment() {
    getCommentEditList().get(getCommentEditList().size() - 1).click();
    return new EditCommentPage(driver);
  }*/

  public EditCommentPage editCommentByText(String commentText) {
    for (WebElement element : getCommentsList()) {
      if (element.findElement(commentTextLocator).getText().equals(commentText)) {
        element.findElement(commentsEditLocator).click();
        break;
      }
    }
    return new EditCommentPage(driver);
  }

  public String getPostsText() {
    return driver.findElement(postTitleLocator).getText();
  }
}
