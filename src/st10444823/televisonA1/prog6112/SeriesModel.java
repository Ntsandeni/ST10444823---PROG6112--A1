package st10444823.televisonA1.prog6112;

import java.util.ArrayList;
import java.util.Scanner;

public class SeriesModel {

    String seriesId;
    String seriesName;
    String seriesGenre;
    String seriesAge;
    String seriesNumberOfEpisodes;

    public static ArrayList<SeriesModel> seriesList = new ArrayList<>();

    public SeriesModel(String seriesId, String seriesName, String seriesGenre, String seriesAge, String seriesNumberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesGenre = seriesGenre;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    // Getters
    public String getSeriesId() { return seriesId; }
    public String getSeriesName() { return seriesName; }
    public String getSeriesGenre() { return seriesGenre; }
    public String getSeriesAge() { return seriesAge; }
    public String getSeriesNumberOfEpisodes() { return seriesNumberOfEpisodes; }
    public static ArrayList<SeriesModel> getSeriesList() { return seriesList; }

    // Setters
    public void setSeriesName(String seriesName) { this.seriesName = seriesName; }
    public void setSeriesAge(String seriesAge) { this.seriesAge = seriesAge; }
    public void setSeriesNumberOfEpisodes(String seriesNumberOfEpisodes) { this.seriesNumberOfEpisodes = seriesNumberOfEpisodes; }

    // Method for user interaction (called from main)
    public static void captureSeries(Scanner scanner) {
        System.out.println("CAPTURE A NEW SERIES\n****************************");
        System.out.print("Enter the series id: ");
        String seriesId = scanner.nextLine();
        System.out.print("Enter the series name: ");
        String seriesName = scanner.nextLine();
        System.out.print("Enter the series genre: ");
        String seriesGenre = scanner.nextLine();
        String seriesAge;
        while (true) {
            System.out.print("Enter the series age restriction: ");
            seriesAge = scanner.nextLine();
            if (validateAge(seriesAge)) {
                break;
            }
            System.out.println("You have entered an incorrect series age!!!\n"
                    + "Please re-enter the series age >>");
        }
        System.out.print("Enter the number of episodes for " + seriesName + ": ");
        String seriesNumberOfEpisodes = scanner.nextLine();
        addSeries(seriesId, seriesName, seriesGenre, seriesAge, seriesNumberOfEpisodes);
        System.out.println("Series processed successfully!!!");
    }

    // Method to search for a specific series using the ID
    public static SeriesModel searchSeries(String id) {
        for (SeriesModel s : seriesList) {
            if (s.seriesId.equals(id)) {
                return s;
            }
        }
        return null;
    }

    public static void searchSeries(Scanner scanner) {
        System.out.print("Enter the series id to search: ");
        String id = scanner.nextLine();
        SeriesModel foundSeries = searchSeries(id);
        if (foundSeries != null) {
            System.out.println("Series found!\n\n" + foundSeries.toString());
        } else {
            System.out.println("Series with ID " + id + " not found.");
        }
    }

    // Method to update a series
    public static void updateSeries(Scanner scanner) {
        System.out.print("Enter the series id to update: ");
        String updateId = scanner.nextLine();
        SeriesModel s = searchSeries(updateId);
        if (s != null) {
            System.out.print("Enter the new series name: ");
            String newName = scanner.nextLine();
            String newAge;
            while (true) {
                System.out.print("Enter the new age restriction: ");
                newAge = scanner.nextLine();
                if (validateAge(newAge)) {
                    break;
                }
                System.out.println("You have entered an incorrect series age!!!\n" + "Please re-enter the series age >>");
            }
            System.out.print("Enter the new number of episodes: ");
            String newEpisodes = scanner.nextLine();
            s.setSeriesName(newName);
            s.setSeriesAge(newAge);
            s.setSeriesNumberOfEpisodes(newEpisodes);
            System.out.println("Series " + s.getSeriesName() + " has been successfully updated!");
        } else {
            System.out.println("Series with ID: " + updateId + " was not found.");
        }
    }
    
    // Method used to search for and delete a series (called from main)
    public static void deleteSeries(Scanner scanner) {
        System.out.print("Enter the series id to delete: ");
        String id = scanner.nextLine();
        SeriesModel toRemove = searchSeries(id);
        if (toRemove != null) {
            System.out.print("Are you sure you want to delete series " + toRemove.getSeriesId() + " from the system? Yes (y) to delete: ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                seriesList.remove(toRemove);
                System.out.println("Series with Series Id: " + id + " WAS deleted!");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Series not found.");
        }
    }
    
    // Test helper method to simplify deletion in tests
    public static void deleteSeries(String id) {
        SeriesModel toRemove = searchSeries(id);
        if (toRemove != null) {
            seriesList.remove(toRemove);
        }
    }
    
    // Method used to display all the series recorded
    public static void printReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
            return;
        }
        StringBuilder report = new StringBuilder("Series Report - 2025\n=================\n");
        for (SeriesModel s : seriesList) {
            report.append(s.toString()).append("\n-----------------\n");
        }
        System.out.println(report.toString());
    }
    
    // Method to validate age restriction
    public static boolean validateAge(String age) {
        try {
            int ageNum = Integer.parseInt(age);
            return ageNum >= 2 && ageNum <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    // Helper method for unit tests
    public static void addSeries(String id, String name, String genre, String age, String episodes) {
        seriesList.add(new SeriesModel(id, name, genre, age, episodes));
    }
    
    @Override
    public String toString() {
        return "Series ID: " + seriesId +
                "\nName: " + seriesName +
                "\nGenre: " + seriesGenre +
                "\nAge Restriction: " + seriesAge +
                "\nEpisodes: " + seriesNumberOfEpisodes;
    }
}