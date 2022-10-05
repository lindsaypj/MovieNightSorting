package comparators;

import data.Movie;

import java.util.Comparator;

/**
 * Comparator used to sort movies based on their Rotten Tomatoes Scores.
 * @author Patrick Lindsay
 * @version 1.0
 */
public class RTComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie movie1, Movie movie2) {
        return movie1.getRTScore() - movie2.getRTScore();
    }
}
