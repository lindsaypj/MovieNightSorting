package comparators;

import data.Movie;

import java.util.Comparator;

/**
 * Comparator used to sort movies based on the studio they were produced in.
 * @author Patrick Lindsay
 * @version 1.0
 */
public class StudioComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie movie1, Movie movie2) {
        return movie1.getStudio().compareTo(movie2.getStudio());
    }
}
