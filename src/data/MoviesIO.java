package data;

import comparators.FilmComparator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class takes a file containing movie data and parses the data into
 * Movie Objects.
 * @author Patrick Lindsay
 * @version 1.0
 */
public class MoviesIO {

    // Instance Fields
    private String filePath;
    private ArrayList<Movie> movies;

    /**
     * This is the constructor for the MovieIO object.
     * Parses data from given file into a list of Movie Objects.
     * @param filePath path to file with movie data.
     */
    public MoviesIO(String filePath) {
        // Instantiate Fields
        this.filePath = filePath;
        this.movies = new ArrayList<>();

        // Try to parse data into movie objects
        try {
            Scanner movieScan = new Scanner(new File(filePath)); // Create scanner to parse data
            movieScan.nextLine();                               // Remove/Ignore first line (column headers)

            // Loop over all records (Entries are separated by line)
            while (movieScan.hasNextLine()) {
                String movieEntry = movieScan.nextLine();   // Store next entry
                movies.add(parse(movieEntry));             // Parse and store data in new Movie Object
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        movies.sort(new FilmComparator()); // Run default sort on the data by Title
    }

    // Method to parse data in movie entry from file into a Movie Object
    private static Movie parse(String entry) {

        // Separate data (delimited by commas)
        String[] data = entry.split(",");

        // Cast raw data from strings to appropriate data-types
        int audienceScore = Integer.parseInt(data[3]);
        double profit = Double.parseDouble(data[4]);
        int rtScore = Integer.parseInt(data[5]);
        double worldGross = Double.parseDouble(data[6]);
        int year = Integer.parseInt(data[7]);

        // Film,Genre,Lead Studio,Audience score %,Profitability,Rotten Tomatoes %,Worldwide Gross,Year
        return new Movie(data[0], data[1], data[2], audienceScore, profit, rtScore, worldGross, year);
    }


    /**
     * Method to get the list of movies parsed from the file.
     * @return an ArrayList of Movie Objects
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "MoviesIO: " + filePath;
    }
}
