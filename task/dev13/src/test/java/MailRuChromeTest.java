import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MailRuChromeTest {

  private WebDriver driver;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("http://www.mail.ru");
  }

  @Test
  public void correctPasswordTest() {
    WebElement login = driver.findElement(By.id("mailbox__login"));
    login.sendKeys("tat-dev13");
    WebElement pasword = driver.findElement(By.id("mailbox__password"));
    pasword.sendKeys("23.03.2017");
    driver.findElement(By.id("mailbox__auth__button")).click();
    driver.findElement(By.className("b-datalist__body"));
    driver.close();

  }

  @Test
  public void incorrectPasswordTest() {
    WebElement login = driver.findElement(By.id("mailbox__login"));
    login.sendKeys("tat-dev13");
    WebElement pasword = driver.findElement(By.id("mailbox__password"));
    pasword.sendKeys("23032017");
    driver.findElement(By.id("mailbox__auth__button")).click();
    driver.findElement(By.className("b-login__errors"));
    driver.close();
  }

  @Test
  public void incorrectLoginTest() {
    WebElement login = driver.findElement(By.id("mailbox__login"));
    login.sendKeys("tatdev13");
    WebElement pasword = driver.findElement(By.id("mailbox__password"));
    pasword.sendKeys("23.03.2017");
    driver.findElement(By.id("mailbox__auth__button")).click();
    driver.findElement(By.className("b-login__errors"));
    driver.close();
  }

  @Test
  public void incorrectLoginUnresolvedSymbolsTest() {
    WebElement login = driver.findElement(By.id("mailbox__login"));
    login.sendKeys("+*/!@#$%^&*(");
    WebElement pasword = driver.findElement(By.id("mailbox__password"));
    pasword.sendKeys("23.03.2017");
    driver.findElement(By.id("mailbox__auth__button")).click();
    driver.findElement(By.className("b-login__errors"));
    driver.close();
  }

  @Test
  public void incorrectLoginMoreThan32SymbolsTest() {
    WebElement login = driver.findElement(By.id("mailbox__login"));
    login.sendKeys("aaaaaaaaaabbbbbbbbbbccccccccccdd");
    WebElement pasword = driver.findElement(By.id("mailbox__password"));
    pasword.sendKeys("23.03.2017");
    driver.findElement(By.id("mailbox__auth__button")).click();
    driver.findElement(By.className("b-login__errors"));
    driver.close();
  }

  @Test
  public void incorrectPasswordMoreThan40SymbolsTest() {
    WebElement login = driver.findElement(By.id("mailbox__login"));
    login.sendKeys("tat-dev13");
    WebElement pasword = driver.findElement(By.id("mailbox__password"));
    pasword.sendKeys("aaaaaaaaaabbbbbbbbbbccccccccccddddddddddde");
    driver.findElement(By.id("mailbox__auth__button")).click();
    driver.findElement(By.className("b-login__errors"));
    driver.close();
  }

  @Test
  public void emptyPasswordAndLoginTest() {
    driver.findElement(By.id("mailbox__auth__button")).click();
    driver.findElement(By.className("b-login__errors"));
    driver.close();
  }
}

