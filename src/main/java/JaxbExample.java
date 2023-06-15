import models.ClientsList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
public class JaxbExample {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/xml/clients.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(ClientsList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            ClientsList clientsList = (ClientsList) jaxbUnmarshaller.unmarshal(file);
            logger.info(clientsList);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
