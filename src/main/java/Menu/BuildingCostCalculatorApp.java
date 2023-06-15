package Menu;

import com.sun.tools.javac.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class BuildingCostCalculatorApp {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            logger.info("======================================");
            logger.info("|         Building Cost Calculator     |");
            logger.info("======================================");
            logger.info("| Options:                           |");
            logger.info("|    1. Residential Building          |");
            logger.info("|    2. Commercial Building           |");
            logger.info("|    3. Industrial Building           |");
            logger.info("|    4. Exit                          |");
            logger.info("======================================");
            logger.info("Enter the building type (1-4): ");
            String userInput = scanner.nextLine();

            int buildingOption;
            try {
                buildingOption = Integer.parseInt(userInput);

                if (buildingOption < 1 || buildingOption > 4) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                logger.info("Invalid input. Please enter a number between 1 and 4.");
                continue;
            }

            if (buildingOption == 4) {
                logger.info("Exiting Building Cost Calculator. Goodbye!");
                exit = true;
                continue;
            }

            String buildingType;
            double floorArea;

            switch (buildingOption) {
                case 1:
                    buildingType = "Residential";
                    break;
                case 2:
                    buildingType = "Commercial";
                    break;
                case 3:
                    buildingType = "Industrial";
                    break;
                default:
                    buildingType = "Unknown Building Type";
                    break;
            }

            System.out.print("Enter the floor area (in square meters): ");
            userInput = scanner.nextLine();

            try {
                floorArea = Double.parseDouble(userInput);
            } catch (NumberFormatException e) {
                logger.info("Invalid input. Please enter a valid number for floor area.");
                continue;
            }

            double cost = BuildingCostCalculator.calculateCost(buildingType, floorArea);
            int time = BuildingCostCalculator.calculateTime(buildingType, floorArea);

            logger.info("===============================");
            logger.info("|    Building Information       |");
            logger.info("===============================");
            logger.info("| Building Type:    " + buildingType);
            logger.info("| Floor Area:       " + floorArea + " sqm");
            logger.info("| Cost:             $" + cost);
            logger.info("| Time:             " + time + " months");
            logger.info("===============================");

            System.out.print("Do you want to perform another calculation? (yes/no): ");
            userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("no")) {
                logger.info("Exiting Building Cost Calculator. Goodbye!");
                exit = true;
            }
        }
    }
}
