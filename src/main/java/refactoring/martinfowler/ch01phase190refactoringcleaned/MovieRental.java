package refactoring.martinfowler.ch01phase190refactoringcleaned;

public class MovieRental {

    private Movie movie;
    private int daysOfRented;

    public MovieRental(Movie movie, int daysOfRented) {
        this.movie = movie;
        this.daysOfRented = daysOfRented;
    }

    public int getDaysOfRented() {
        return daysOfRented;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public double calculateRentalAmount() {
        return movie.calculateRentalAmount(this.daysOfRented);
    }

    public int calculateRentalPoint() {
        return movie.getDefaultPoint() + movie.getPromotionPoint(daysOfRented);
    }

}
