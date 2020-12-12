package refactoring.martinfowler.ch01phase190refactoring;

public class MovieChildrenPrice extends MoviePrice {
    public int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    public double calculateRentalAmount(int daysOfRented) {
        double resultAmount = 0;

        // 어린이 영화 대여 가격은 1500 원
        resultAmount += 1500;
        // 기본 대여 기간이 3일 대여 가능하나 3일 초과하면 초과일수 만큰 가격은 1000원 추가
        if (daysOfRented > 3) {
            resultAmount += (daysOfRented - 3 ) * 1000;
        }

        return resultAmount;
    }

    /*
    @Override
    public int getDefaultPoint() {
        return 1;
    }

     */

    @Override
    public int getPromotionPoint(int daysOfRented) {
        int resultPoint =0;
        if (getPriceCode() == Movie.NEW_RELEASE && daysOfRented > 1) {
            resultPoint = 1;
        }
        return resultPoint;
    }
}
