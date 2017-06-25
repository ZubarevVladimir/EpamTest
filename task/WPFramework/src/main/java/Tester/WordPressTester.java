package Tester;

import Pages.*;
import Pages.AddContentPages.AllPagesPage;
import Pages.AddContentPages.AllPostsPage;
import Pages.AddContentPages.EditCommentPage;
import Pages.AddContentPages.EditPagePage;
import Pages.AddContentPages.EditPostPage;
import Results.ResultContainer;
import Results.TestResult;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contains methods fot test WordPress.
 */
public class WordPressTester {

  private ResultContainer container = ResultContainer.getInstance();
  private static WordPressTester tester = WordPressTester.getInstance();
  private static String AUTHORIZATION_NAME = "Authorization test";
  private static String INCORRECT_AUTHORIZATION_NAME = "Incorrect authorization test";
  private static String CREATE_POST_NAME = "Create post test";
  private static String CREATE_PAGE_NAME = "Create page test";
  private static String DELETE_POST_NAME = "Delete post test";
  private static String DELETE_PAGE_NAME = "Delete page test";
  private static String CREATE_COMMENT_NAME = "Create comment test";
  private static String DELETE_COMMENT_NAME = "Delete comment test";
  private final String hostString = "localhost:8080";
  private final String adminLogin = "admin";
  private final String adminPassword = "12345";
  private final String PASSWORD = "Password: ";
  private final String LOGIN = "Login: ";
  private final String TITLE = "Title: ";
  private final String TEXT = "Text: ";
  private final int maxIncorrectTestsCounter = 3;

  private WordPressTester() {
  }

  public static synchronized WordPressTester getInstance() {
    if (tester == null) {
      tester = new WordPressTester();
    }
    return tester;
  }

  /**
   * Set WebDriver's parameters.
   *
   * @return WebDriver - driver with started parameters.
   */
  private WebDriver setDriver() {
    System.setProperty("webdriver.chrome.driver",
        "src\\main\\resources\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(hostString);
    return driver;
  }

  /**
   * Do starts steps for admin's log in.
   *
   * @param driver - initialized driver with started started.
   * @return MainPage - pge which open after authorization.
   */
  private MainPage authorizeAdmin(WebDriver driver) {
    StartPage startPage = new StartPage(driver);
    LoginPage loginPage = startPage.getLoginPage();
    loginPage.failureLoginAs(adminLogin, adminPassword);
    return new MainPage(driver);
  }

  /**
   * Check correct admin authorization. Test's result add to ResultContainer.
   *
   * @param login - string, contains tested login.
   * @param password - string, contains tested password.
   */
  public void checkCorrectAuthorization(String login, String password) {
    long startTime = System.currentTimeMillis();
    String parameter = LOGIN + "\"" + login + "\", " + PASSWORD + "\"" + password + "\"";
    int incorrectTestsCounter = 0;
    while (true) {
      WebDriver driver = setDriver();
      try {
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = startPage.getLoginPage();
        MainPage mainPage = loginPage.loginAs(login, password);
        boolean status = (mainPage.getAdminName().equals(login));
        container.addResult(new TestResult(status, AUTHORIZATION_NAME, parameter,
            System.currentTimeMillis() - startTime, incorrectTestsCounter));
        break;
      } catch (Exception ex) {
        incorrectTestsCounter++;
        if (incorrectTestsCounter == maxIncorrectTestsCounter) {
          container.addResult(new TestResult(false, AUTHORIZATION_NAME, parameter,
              System.currentTimeMillis() - startTime, incorrectTestsCounter));
          break;
        }
      } finally {
        driver.close();
      }
    }
  }

  /**
   * Check incorrect admin authorization. Test's result add to ResultContainer.
   *
   * @param login - string, contains tested login.
   * @param password - string, contains tested password.
   */
  public void checkIncorrectAuthorization(String login, String password) {
    long startTime = System.currentTimeMillis();
    String parameter = LOGIN + "\"" + login + "\", " + PASSWORD + "\"" + password + "\"";
    int incorrectTestsCounter = 0;
    while (true) {
      WebDriver driver = setDriver();
      try {
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = startPage.getLoginPage();
        loginPage.failureLoginAs(login, password);
        boolean status = (loginPage.getErrorElement() != null);
        container.addResult(new TestResult(status, INCORRECT_AUTHORIZATION_NAME, parameter,
            System.currentTimeMillis() - startTime, incorrectTestsCounter));
        break;
      } catch (Exception ex) {
        incorrectTestsCounter++;
        if (incorrectTestsCounter == maxIncorrectTestsCounter) {
          container.addResult(new TestResult(false, INCORRECT_AUTHORIZATION_NAME, parameter,
              System.currentTimeMillis() - startTime, incorrectTestsCounter));
          break;
        }
      } finally {
        driver.close();
      }
    }
  }

  /**
   * Check create post. Test's result add to ResultContainer.
   *
   * @param title - string, contains tested title.
   * @param text - string, contains tested text.
   */
  public void checkCreatePost(String title, String text) {
    long startTime = System.currentTimeMillis();
    String parameter = TITLE + "\"" + title + "\", " + TEXT + "\"" + text + "\"";
    int incorrectTestsCounter = 0;
    while (true) {
      WebDriver driver = setDriver();
      try {
        MainPage mainPage = authorizeAdmin(driver);
        AllPostsPage allPostsPage = mainPage.toAllPostsPage();
        EditPostPage addPostPage = allPostsPage.addPost();
        addPostPage.publicPost(title, text);
        StartPage startPage = mainPage.toSite();
        boolean status = (startPage.openByTitle(title).getPostsText().trim().equals(text));
        container.addResult(new TestResult(status, CREATE_POST_NAME, parameter,
            System.currentTimeMillis() - startTime, incorrectTestsCounter));
        break;
      } catch (Exception ex) {
        incorrectTestsCounter++;
        if (incorrectTestsCounter == maxIncorrectTestsCounter) {
          container.addResult(new TestResult(false, CREATE_POST_NAME, parameter,
              System.currentTimeMillis() - startTime, incorrectTestsCounter));
          break;
        }
      } finally {
        driver.close();
      }
    }
  }

  /**
   * Check delete post by title. Test's result add to ResultContainer.
   *
   * @param title - string, contains tested title.
   */
  public void checkDeletePost(String title) {
    long startTime = System.currentTimeMillis();
    String parameter = TITLE + "\"" + title + "\"";
    int incorrectTestsCounter = 0;
    while (true) {
      WebDriver driver = setDriver();
      try {
        MainPage mainPage = authorizeAdmin(driver);
        StartPage startPage = mainPage.toSite();
        startPage.openByTitle(title).editPost().deletePost();
        AllPostsPage allPostsPage = new AllPostsPage(driver);
        boolean status = (allPostsPage.getMessageDelete() != null);
        container.addResult(new TestResult(status, DELETE_POST_NAME, parameter,
            System.currentTimeMillis() - startTime, incorrectTestsCounter));
        break;
      } catch (Exception ex) {
        incorrectTestsCounter++;
        if (incorrectTestsCounter == maxIncorrectTestsCounter) {
          container.addResult(new TestResult(false, DELETE_POST_NAME, parameter,
              System.currentTimeMillis() - startTime, incorrectTestsCounter));
          break;
        }
      } finally {
        driver.close();
      }
    }
  }

  /**
   * Check create page. Test's result add to ResultContainer.
   *
   * @param title - string, contains tested title.
   * @param text - string, contains tested text.
   */
  public void checkCreatePage(String title, String text) {
    long startTime = System.currentTimeMillis();
    String parameter = TITLE + "\"" + title + "\", " + TEXT + "\"" + text + "\"";
    int incorrectTestsCounter = 0;
    while (true) {
      WebDriver driver = setDriver();
      try {
        MainPage mainPage = authorizeAdmin(driver);
        AllPagesPage allPagesPage = mainPage.toAllPagesPage();
        EditPagePage editPagePage = allPagesPage.addPage();
        editPagePage.publicPage(title, text);
        boolean status = (allPagesPage.openByTitle(title).getEditLabelText() != null);
        container.addResult(new TestResult(status, CREATE_PAGE_NAME, parameter,
            System.currentTimeMillis() - startTime, incorrectTestsCounter));
        break;
      } catch (Exception ex) {
        incorrectTestsCounter++;
        if (incorrectTestsCounter == maxIncorrectTestsCounter) {
          container.addResult(new TestResult(false, CREATE_PAGE_NAME, parameter,
              System.currentTimeMillis() - startTime, incorrectTestsCounter));
          break;
        }
      } finally {
        driver.close();
      }
    }
  }

  /**
   * Check delete page. Test's result add to ResultContainer.
   *
   * @param title - string, contains tested title.
   */
  public void checkDeletePage(String title) {
    long startTime = System.currentTimeMillis();
    String parameter = TITLE + "\"" + title + "\"";
    int incorrectTestsCounter = 0;
    while (true) {
      WebDriver driver = setDriver();
      try {
        MainPage mainPage = authorizeAdmin(driver);
        AllPagesPage allPagesPage = mainPage.toAllPagesPage();
        EditPagePage editPagePage = allPagesPage.openByTitle(title);
        editPagePage.deletePage();
        boolean status = (allPagesPage.getMessageDelete() != null);
        container.addResult(new TestResult(status, DELETE_PAGE_NAME, parameter,
            System.currentTimeMillis() - startTime, incorrectTestsCounter));
        break;
      } catch (Exception ex) {
        incorrectTestsCounter++;
        if (incorrectTestsCounter == maxIncorrectTestsCounter) {
          container.addResult(new TestResult(false, DELETE_PAGE_NAME, parameter,
              System.currentTimeMillis() - startTime, incorrectTestsCounter));
          break;
        }
      } finally {
        driver.close();
      }
    }
  }

  /**
   * Check create comment. Test's result add to ResultContainer.
   *
   * @param postTitle - string, contains tested post title.
   * @param commentText - string, contains tested comment text.
   */
  public void checkCreateComment(String postTitle, String commentText) {
    long startTime = System.currentTimeMillis();
    String parameter = TITLE + "\"" + postTitle + "\", " + TEXT + "\"" + commentText + "\"";
    int incorrectTestsCounter = 0;
    while (true) {
      WebDriver driver = setDriver();
      try {
        MainPage mainPage = authorizeAdmin(driver);
        StartPage startPage = mainPage.toSite();
        PostPage postPage = startPage.openByTitle(postTitle);
        postPage.putComment(commentText);
        driver.get(hostString);
        boolean status = false;
        for (WebElement element : startPage.toMainPage().toAllCommentsPage()
            .getCommentsTextList()) {
          if (element.getText().equals(commentText)) {
            status = true;
            break;
          } else {
            status = false;
          }
        }
        container.addResult(new TestResult(status, CREATE_COMMENT_NAME, parameter,
            System.currentTimeMillis() - startTime, incorrectTestsCounter));
        break;
      } catch (Exception ex) {
        incorrectTestsCounter++;
        if (incorrectTestsCounter == maxIncorrectTestsCounter) {
          container.addResult(new TestResult(false, CREATE_COMMENT_NAME, parameter,
              System.currentTimeMillis() - startTime, incorrectTestsCounter));
          break;
        }
      } finally {
        driver.close();
      }
    }
  }

  /**
   * Check delete comment. Test's result add to ResultContainer.
   *
   * @param postTitle - string, contains tested post title.
   * @param commentText - string, contains tested comment text.
   */
  public void checkDeleteComment(String postTitle, String commentText) {
    long startTime = System.currentTimeMillis();
    String parameter = TITLE + "\"" + postTitle + "\", " + TEXT + "\"" + commentText + "\"";
    int incorrectTestsCounter = 0;
    while (true) {
      WebDriver driver = setDriver();
      try {
        MainPage mainPage = authorizeAdmin(driver);
        StartPage startPage = mainPage.toSite();
        PostPage postPage = startPage.openByTitle(postTitle);
        EditCommentPage editCommentPage = postPage.editCommentByText(commentText);
        editCommentPage.deleteComment();
        driver.get(hostString);
        boolean status = false;
        for (WebElement element : startPage.toMainPage().toAllCommentsPage().toDeleteComments()
            .getCommentsTextList()) {
          if (element.getText().equals(commentText)) {
            status = true;
            break;
          } else {
            status = false;
          }
        }
        container.addResult(new TestResult(status, DELETE_COMMENT_NAME, parameter,
            System.currentTimeMillis() - startTime, incorrectTestsCounter));
        break;
      } catch (Exception ex) {
        incorrectTestsCounter++;
        if (incorrectTestsCounter == maxIncorrectTestsCounter) {
          container.addResult(new TestResult(false, DELETE_COMMENT_NAME, parameter,
              System.currentTimeMillis() - startTime, incorrectTestsCounter));
          break;
        }
      } finally {
        driver.close();
      }
    }
  }
}
