import Menu.BuildingCostCalculatorApp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        //ConnectionPool connectionPool = null;
        try {
            //connectionPool = new ConnectionPool();


            // Run the Building Cost Calculator App
            BuildingCostCalculatorApp.run();


        } catch (Exception e) {
            logger.error("An error occurred.", e);
        } finally {
           // if (connectionPool != null) {
            //    ConnectionPool.shutdown();
           // }
        }
    }
}