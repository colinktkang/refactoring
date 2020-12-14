package refactoring.martinfowler.ch01phase190refactoringcleaned.moviecategory;

import refactoring.martinfowler.ch01phase190refactoringcleaned.Movie;
import refactoring.martinfowler.ch01phase190refactoringcleaned.MoviePrice;

public class MovieNewReleasePrice extends MoviePrice {
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double calculateRentalAmount(int daysOfRented) {
        double resultAmount = 0;

        // 신규 영화 대여 가격은 하루 3000 원
        resultAmount += daysOfRented * 3000;

        return resultAmount;
    }

    @Override
    public int getDefaultPoint() {
        return 1;
    }

    @Override
    public int getPromotionPoint(int daysOfRented) {
        int resultPoint =0;
        if (daysOfRented > 1) {
            resultPoint = 1;
        }
        return resultPoint;
    }

}
