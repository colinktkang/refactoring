package refactoring.martinfowler.ch01phase190refactoring;

public abstract class MoviePrice {
    abstract int getPriceCode();
    abstract double calculateRentalAmount(int daysOfRented);
    // 2차 리팩토링
    //abstract int getDefaultPoint();
    public int getDefaultPoint() {
        return 1;
    }
    abstract int getPromotionPoint(int daysOfRented);
}
