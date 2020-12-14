package refactoring.martinfowler.ch01phase190refactoringcleaned;

public abstract class MoviePrice {
    protected abstract int getPriceCode();
    protected abstract double calculateRentalAmount(int daysOfRented);
    protected int getDefaultPoint() {
        return 1;
    }
    protected abstract int getPromotionPoint(int daysOfRented);
}
