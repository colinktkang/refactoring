package refactoring.martinfowler.ch01phase190refactoringcleaned.moviecategory;

import refactoring.martinfowler.ch01phase190refactoringcleaned.Movie;
import refactoring.martinfowler.ch01phase190refactoringcleaned.MoviePrice;

public class MovieRegularPrice extends MoviePrice {
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double calculateRentalAmount(int daysOfRented) {
        double resultAmount = 0;

        // 일반영화 대여 가격은 2000 원
        resultAmount += 2000;
        /// 기본 대여 기간이 2일 대여 가능하나 2일 초과하면 초과일수 만큰 가격은 1500원 추가
        if (daysOfRented > 2)
            resultAmount += (daysOfRented -2) * 1500;

        return resultAmount;
    }

    @Override
    public int getPromotionPoint(int daysOfRented) {
        int resultPoint = 0;
        return resultPoint;
    }
}
