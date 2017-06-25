package TWMFramework.Page;

import TWMFramework.Results.Result;
import TWMFramework.Results.ResultContainer;
import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contains methods fot test web page.
 */
public class PageTester {

  private static PageTester provider;
  private static TestPage page;
  private ResultContainer container = ResultContainer.getContainer();

  private PageTester() {
  }

  /**
   * Return created pageTester, or create it and return.
   *
   * @return PageTester - single exemplar class ResultContainer.
   */
  public static PageTester getPageTester() {
    if (provider == null) {
      provider = new PageTester();
      System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
      page = new TestPage(new ChromeDriver());
    }
    return provider;
  }

  /**
   * Check link present by name and add result in ResultContainer.
   *
   * @param linkName - link name tested web element's.
   */
  public void checkLinkPresentByName(String linkName) {
    long startTime = System.currentTimeMillis();
    String status = page.getLinkPresentByName(linkName) == null ? "!" : "+";
    double time = ((double) (System.currentTimeMillis() - startTime)) / 1000;
    container.addResult(new Result(status, "[checkLinkPresentByName \"" + linkName + "\"]", time));
  }

  /**
   * Check page title and add result in ResultContainer.
   *
   * @param title - expected title.
   */
  public void checkPageTitle(String title) {
    long startTime = System.currentTimeMillis();
    String status = page.getPageTitle().equals(title) ? "+" : "!";
    double time = ((double) (System.currentTimeMillis() - startTime)) / 1000;
    container.addResult(new Result(status, "[checkPageTitle " + "\"" + title + "\"]", time));
  }

  /**
   * Check what page contains given text and add result in ResultContainer.
   *
   * @param text - searched text on page.
   */
  public void checkPageContains(String text) {
    long startTime = System.currentTimeMillis();
    String status = page.getPageContent().contains(text) ? "+" : "!";
    double time = ((double) (System.currentTimeMillis() - startTime)) / 1000;
    container.addResult(new Result(status, "[checkPageContains \"" + text + "\"]", time));
  }

  /**
   * Check open page and add result in ResultsContainer.
   *
   * @param url url opened web page.
   * @param timeout waiting time.
   */
  public void open(String url, int timeout) {
    long startTime = System.currentTimeMillis();
    String status;
    try {
      page.open(url, timeout);
      status = page.getErrorElement() == null ? "+" : "!";
    } catch (Exception ex) {
      status = "!";
    }
    double time = ((double) (System.currentTimeMillis() - startTime)) / 1000;
    container.addResult(
        new Result(status, "[open " + "\"" + url + "\" " + "\"" + timeout + "\"" + "]", time));
  }

  /**
   * Check link present by href and add result in ResultContainer.
   *
   * @param href - link href tested web element's.
   */
  public void checkLinkPresentByHref(String href) {
    long startTime = System.currentTimeMillis();
    String status = page.getLinkPresentByHref(href) == null ? "!" : "+";
    double time = ((double) (System.currentTimeMillis() - startTime)) / 1000;
    container.addResult(new Result(status, "[checkLinkPresentByHref \"" + href + "\"]", time));
  }

  /**
   * Log test's results in file and close tested web page.
   */
  public void close() {
    try (FileWriter fileWriter = new FileWriter("log.txt", false)) {
      for (Result result : container.getResults()) {
        fileWriter.write(result.toString() + "\n");
      }
      fileWriter
          .write("Total tests: " + (container.getNumberCorrectTests() + container
              .getNumberIncorrectTests())
              + "\n");
      fileWriter.write("Passed/Failed: " +
          container.getNumberCorrectTests() + "/" + container.getNumberIncorrectTests() + "\n");
      fileWriter.write("Total time: " + container.getTotalTestTime() + "\n");
      fileWriter.write("Average time: " + container.getAverageTestTime() + "\n");
    } catch (IOException ex) {
      System.out.println("Not found file");
    }
    page.close();
  }
}