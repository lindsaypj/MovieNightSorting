package driver;

import comparators.*;
import data.HeapSort;
import data.Movie;
import data.MoviesIO;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class starts and manages the runtime of the Movie Night Sorting program.
 * @author Patrick Lindsay
 * @version 1.0
 */
public class ConsoleApp {

    // Static Constants
    private static final String MOVIES_FILE = "./src/data/movies.csv";
    private static final AudienceComparator AUDIENCE_COMPARATOR = new AudienceComparator();
    private static final FilmComparator FILM_COMPARATOR = new FilmComparator();
    private static final GenreComparator GENRE_COMPARATOR = new GenreComparator();
    private static final ProfitComparator PROFIT_COMPARATOR = new ProfitComparator();
    private static final RTComparator RT_COMPARATOR = new RTComparator();
    private static final StudioComparator STUDIO_COMPARATOR = new StudioComparator();
    private static final WorldGrossComparator WORLD_GROSS_COMPARATOR = new WorldGrossComparator();
    private static final YearComparator YEAR_COMPARATOR = new YearComparator();

    /**
     * This is the driver for the program.
     * @param args command line arguments
     */
    public static void main(String[] args) {

        // Start the program
        startMessage();

        // Get and parse Movie data
        ArrayList<Movie> movies = new MoviesIO(MOVIES_FILE).getMovies();

        // Create scanner to get user responses
        Scanner userInput = null;
        try {
            userInput = new Scanner(System.in);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        // Only run if Scanner was initialized
        boolean run = userInput != null;
        while(run) {
            // Print options to the user
            printOptions();

            // Get their response
            switch (userInput.nextLine()) {
                case "1" -> printMovies(movies); // Show all Movies
                case "2" -> printRandom(movies); // Show a random movie
                case "3" -> { // Resort movies
                    // Display Movie sort options
                    printSortOptions();

                    // Sort according to user choice
                    sortMovies(movies, userInput.nextLine());
                }
                case "4" -> run = false; // Exit
                default -> { // Input not recognised
                    System.out.println();
                    System.out.println("Option not recognised...");
                }
            }
        }
    }

    // Function to print the welcome message
    private static void startMessage() {
        System.out.println("*******************************************");
        System.out.println("Welcome to the Movie Night Application ");
        System.out.println();
        System.out.println("This program will display movie suggestions");
        System.out.println("and allow you to sort movies in different");
        System.out.println("ways");
        System.out.println("*******************************************");
    }

    // Function to print the users primary program options
    private static void printOptions() {
        System.out.println();
        System.out.println("Pick from the following:");
        System.out.println("1. Show all movies");
        System.out.println("2. Show a random movie");
        System.out.println("3. Sort movies");
        System.out.println("4. Exit");
    }

    // Function to print the movies in their current order
    private static void printMovies(ArrayList<Movie> movies) {
        System.out.printf("\n%-30s %-12s %-25s %-12s %-14s %-20s %-25s %-5s \n",
                "FILM", "GENRE", "STUDIO", "AUDIENCE", "PROFIT", "ROTTEN TOMATOES", "WORLDWIDE GROSS PROFIT", "YEAR");
        for (Movie movie : movies) {
            System.out.printf("%-30s %-12s %-25s %-12s %-14s %-20s %-25s %-5s \n",
                    movie.getTitle(), movie.getGenre(), movie.getStudio(), movie.getAudienceScore(),
                    movie.getProfitability(), movie.getRTScore(), movie.getWorldGross(), movie.getYear());
        }
    }

    // Function to randomly select a movie and print it.
    private static void printRandom(ArrayList<Movie> movies) {
        // Get random movie
        ArrayList<Movie> randomMovie = new ArrayList<>();
        randomMovie.add(movies.get((int) (Math.random() * movies.size())));

        // Print random movie
        printMovies(randomMovie);
    }

    // Function to print the movie sorting options
    private static void printSortOptions() {
        System.out.println();
        System.out.println("Enter a comparator:");
        System.out.println("1. By Film");
        System.out.println("2. By Genre");
        System.out.println("3. By Studio");
        System.out.println("4. By Audience Score");
        System.out.println("4. By Profitability");
        System.out.println("4. By Rotten Tomatoes Score");
        System.out.println("4. By World Gross");
        System.out.println("4. By Year");
        System.out.println("9. CANCEL ");
    }

    // Function to sort the movies by given option, using a HeapSort
    private static void sortMovies(ArrayList<Movie> movies, String option) {
        HeapSort sorter = new HeapSort(movies);

        switch(option) {
            case "1" -> sorter.sort(FILM_COMPARATOR);
            case "2" -> sorter.sort(GENRE_COMPARATOR);
            case "3" -> sorter.sort(STUDIO_COMPARATOR);
            case "4" -> sorter.sort(AUDIENCE_COMPARATOR);
            case "5" -> sorter.sort(PROFIT_COMPARATOR);
            case "6" -> sorter.sort(RT_COMPARATOR);
            case "7" -> sorter.sort(WORLD_GROSS_COMPARATOR);
            case "8" -> sorter.sort(YEAR_COMPARATOR);
            case "9" -> {} // CANCEL
            default -> { // Unrecognised Input
                System.out.println("Option Not recognised...");
                System.out.println();
            }
        }
    }
}
