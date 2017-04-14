package Notebook.Notebook;

/**
 * Contains method for getting unique note id.
 */
public class IDGenerator {

  private static IDGenerator generator;
  private int id;

  private IDGenerator() {
  }

  /**
   * Singleton method for getting exemplar IDGenerator class.
   *
   * @return IDGenerator singleton exemplar.
   */
  public static IDGenerator getIDGenerator() {
    if (generator == null) {
      generator = new IDGenerator();
    }
    return generator;
  }

  /**
   * Method for getting unique note id.
   *
   * @return int unique note id.
   */
  public int getID() {
    return ++id;
  }
}
