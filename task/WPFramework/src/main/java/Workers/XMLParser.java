package Workers;

import Results.ResultPresenter;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Parse tests results to XML.
 */
public class XMLParser {

  private Marshaller jaxbMarshaller;
  private File file;
  private String pathName = "log-file.xml";//"D:/untitled/task/WPFramework/instructions.txt"

  /**
   * Start parsing resuls to XML.
   */
  public void startParseResults() {
    file = new File(pathName);
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(ResultPresenter.class);
      jaxbMarshaller = jaxbContext.createMarshaller();
    } catch (JAXBException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
  }

  /**
   * Stop parsing object to XML and write to file.
   *
   * @param presenter - object, which need parse.
   */
  public void stopParseResults(ResultPresenter presenter) {
    try {
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(presenter, file);
    } catch (JAXBException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
  }

}
