package st10444823.televisonA1.prog6112;

import java.util.Scanner;

public class ST10444823TelevisonA1PROG6112 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String initialChoice;

        // Initial menu prompt
        //Joyce Farrel - Java Programming 9th Edition
        System.out.println("LATEST SERIES - 2025\n****************************");
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        initialChoice = scanner.nextLine();

        if (!initialChoice.equals("1")) {
            System.out.println("Exiting Application... Goodbye!");
            scanner.close();
            return;
        }

        // Main application loop
        // Assisted by Microsoft Copilot (AI)
        //Joyce Farrel - Java Programming 9th Edition
        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series");
            System.out.println("(2) Search for a series");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application.");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("6")) {
                System.out.println("Exiting Application... Goodbye!");
                break;
            }

            //Java switch ⬇【4 minutes】by Bro Code - https://www.youtube.com/watch?v=Om3qzMoaIUo
            switch (choice) {
                case "1":
                    SeriesModel.captureSeries(scanner);
                    break;
                case "2":
                    SeriesModel.searchSeries(scanner);
                    break;
                case "3":
                    SeriesModel.updateSeries(scanner);
                    break;
                case "4":
                    SeriesModel.deleteSeries(scanner);
                    break;
                case "5":
                    SeriesModel.printReport();
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}
