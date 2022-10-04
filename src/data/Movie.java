package data;

/**
 * This Movie Object class stores info pertaining to an individual movie.
 * @author Patrick Lindsay
 * @version 1.0
 */
public class Movie {

    // Fields
    private String title;
    private String genre;
    private String studio;
    private int audienceScore;
    private double profitability;
    private int rtScore;
    private double worldGross;
    private int year;

    /**
     * Constructor for a movie object. Stores given movie data.
     * @param title of the movie
     * @param genre of Movie
     * @param studio where the movie was produced
     * @param audienceScore of the movie
     * @param profit how profitable the movie was
     * @param rtScore Movie's score on Rotten Tomatoes
     * @param worldGross Worldwide gross profit
     * @param year movie was released
     */
    public Movie(String title, String genre, String studio, int audienceScore, double profit, int rtScore,
                 double worldGross, int year) {
        this.title = title;
        this.genre = genre;
        this.studio = studio;
        this.audienceScore = audienceScore;
        this.profitability = profit;
        this.rtScore = rtScore;
        this.worldGross = worldGross;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", studio='" + studio + '\'' +
                ", audienceScore=" + audienceScore +
                ", profitability=" + profitability +
                ", rtScore=" + rtScore +
                ", worldGross=" + worldGross +
                ", year=" + year +
                '}';
    }
}
