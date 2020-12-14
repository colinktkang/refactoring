package refactoring.martinfowler.ch01phase190refactoringcleaned;


import refactoring.martinfowler.ch01phase190refactoringcleaned.moviecategory.MovieChildrenPrice;
import refactoring.martinfowler.ch01phase190refactoringcleaned.moviecategory.MovieNewReleasePrice;
import refactoring.martinfowler.ch01phase190refactoringcleaned.moviecategory.MovieRegularPrice;

public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private MoviePrice movePrice;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return movePrice.getPriceCode();
    }

    protected void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR :
                movePrice = new MovieRegularPrice();
                break;
            case NEW_RELEASE :
                movePrice = new MovieNewReleasePrice();
                break;
            case CHILDREN :
                movePrice = new MovieChildrenPrice();
                break;
        }
    }

    public String getTitle() {
        return title;
    }

    public double calculateRentalAmount(int daysOfRented) {
        return movePrice.calculateRentalAmount(daysOfRented);
    }

    public int getDefaultPoint() {
        return movePrice.getDefaultPoint();
    }

    public int getPromotionPoint(int daysOfRented) {
        return movePrice.getPromotionPoint(daysOfRented);
    }
}
