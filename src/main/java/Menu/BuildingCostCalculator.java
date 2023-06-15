package Menu;

import com.sun.tools.javac.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class BuildingCostCalculator {

    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        logger.info("======================================");
        logger.info("|         Building Cost Calculator     |");
        logger.info("======================================");

        System.out.print("Enter the building type: ");
        String buildingType = scanner.nextLine();

        System.out.print("Enter the floor area (in square meters): ");
        double floorArea = scanner.nextDouble();

        double cost = calculateCost(buildingType, floorArea);
        int time = calculateTime(buildingType, floorArea);

        logger.info("======================================");
        logger.info("|        Building Information         |");
        logger.info("======================================");
        logger.info("| Building Type:    " + buildingType);
        logger.info("| Floor Area:       " + floorArea + " sqm");
        logger.info("| Cost:             $" + cost);
        logger.info("| Time:             " + time + " months");
        logger.info("======================================");
    }

    public static double calculateCost(String buildingType, double floorArea) {
        // Calculate the cost based on the building type and floor area
        double costPerSqm;

        if (buildingType.equalsIgnoreCase("Residential")) {
            costPerSqm = 1000;
        } else if (buildingType.equalsIgnoreCase("Commercial")) {
            costPerSqm = 2000;
        } else if (buildingType.equalsIgnoreCase("Industrial")) {
            costPerSqm = 3000;
        } else {
            costPerSqm = 0;
        }

        return costPerSqm * floorArea;
    }

    public static int calculateTime(String buildingType, double floorArea) {
        int timePerSqm;

        if (buildingType.equalsIgnoreCase("Residential")) {
            timePerSqm = 2;
        } else if (buildingType.equalsIgnoreCase("Commercial")) {
            timePerSqm = 3;
        } else if (buildingType.equalsIgnoreCase("Industrial")) {
            timePerSqm = 4;
        } else {
            timePerSqm = 0;
        }

        return (int) (timePerSqm * Math.ceil(floorArea / 100)); // Assuming 100 square meters per month
    }
}