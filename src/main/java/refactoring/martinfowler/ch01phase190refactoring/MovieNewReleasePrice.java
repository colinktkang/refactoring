package refactoring.martinfowler.ch01phase190refactoring;

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
        return 2;
    }

    @Override
    public int getPromotionPoint(int daysOfRented) {
        int resultPoint =0;
        if (getPriceCode() == Movie.NEW_RELEASE && daysOfRented > 1) {
            resultPoint = 1;
        }
        return resultPoint;
    }

}
