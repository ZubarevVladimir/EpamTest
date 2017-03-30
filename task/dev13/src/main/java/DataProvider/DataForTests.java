package DataProvider;

import org.testng.annotations.DataProvider;

/**
 * Contains methods for getting test's data.
 */
public class DataForTests {

  /**
   * Present test's data for correct login.
   *
   * @return Object[][] - array contains objects for test.
   */
  @DataProvider(name = "getDataCorrectLogin")
  public static Object[][] getCorrectData() {
    return new String[][]{
        {"tat-dev13", "23.03.2017"},
        {"Tat-dev13", "23.03.2017"},
    };
  }

  /**
   * Present negative test's data.
   *
   * @return Object[][] - array contains objects for test.
   */
  @DataProvider(name = "getDataNegativeTest")
  public static Object[][] getIncorrectData() {
    return new String[][]{
        {"tat-dev13", ""},
        {"", "23.03.2017"},
        {"tat-dev13", "1"},
        {"1", "23.03.2017"},
        {"!@#$%", "23.03.2017"},
        {"tat-dev13", "!@#$%"},
        {"tatdev13", "23032017"},
        {"tat-dev13", "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddde"},
        {"aaaaaaaaaabbbbbbbbbbccccccccccdd", "23.03.2017"},
        {"aaaaaaaaaabbbbbbbbbbccccccccccdd", "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddde"},
    };
  }

}
