package tr.edu.hacettepe.cs.bil422.lecture05.moviesapp;

/**
 * User: accavdar
 * Date: 14/11/13
 */

public class Movie {

    private String name;

    private int year;

    private boolean isWatched;

    public Movie(String name, int year) {
        this.name = name;
        this.year = year;
        this.isWatched = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isWatched() {
        return isWatched;
    }

    public void setWatched(boolean isWatched) {
        this.isWatched = isWatched;
    }
}
