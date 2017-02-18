package dev4.AddText;

/**
 * Contains method for adding string to other string.
 */
public class AddText {

  /**
   * Add string to other string.
   *
   * @param addedText - string which need to add.
   * @param text - string to which tou add string.
   * @return String - combined string.
   */
  public String addText(String addedText, String text) {
    StringBuffer string = new StringBuffer();
    string.append(text);
    string.append(" ");
    string.append(addedText);
    return string.toString();
  }
}
