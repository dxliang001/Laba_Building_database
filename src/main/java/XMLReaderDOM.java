import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class XMLReaderDOM {

    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/resources/xml/company.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            document.getDocumentElement().normalize();


            NodeList employees = document.getElementsByTagName("employee");
            for (int i = 0; i < employees.getLength(); i++) {
                Node employeeNode = employees.item(i);
                if (employeeNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element employeeElement = (Element) employeeNode;
                    logger.info("Employee ID: " + employeeElement.getElementsByTagName("emp_id").item(0).getTextContent());
                    logger.info("Employee First Name: " + employeeElement.getElementsByTagName("first_name").item(0).getTextContent());
                    logger.info("Employee Last Name: " + employeeElement.getElementsByTagName("last_name").item(0).getTextContent());
                    logger.info("Employee Email: " + employeeElement.getElementsByTagName("email").item(0).getTextContent());

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
