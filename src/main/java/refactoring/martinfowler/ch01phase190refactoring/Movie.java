package refactoring.martinfowler.ch01phase190refactoring;


public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private MoviePrice movePrice;

    public Movie(String title, int priceCode) {
        this.title = title;
        //
        //this.priceCode = priceCode;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return movePrice.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        // 2차 리팰토링 대
        //this.priceCode = priceCode;상
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

    /*
    public double calculateRentalAmount(int daysOfRented) {
        //double thisAmount = 0;
        double resultAmount = 0;
        // 비디오 카테고리별 대여로 계산
        switch (getPriceCode()) {
            case Movie.REGULAR :
                // 일반영화 대여 가격은 2000 원
                resultAmount += 2000;
                /// 기본 대여 기간이 2일 대여 가능하나 2일 초과하면 초과일수 만큰 가격은 1500원 추가
                if (daysOfRented > 2)
                    resultAmount += (daysOfRented -2) * 1500;
                break;
            case Movie.NEW_RELEASE :
                // 신규 영화 대여 가격은 하루 3000 원
                resultAmount += daysOfRented * 3000;
                break;
            case Movie.CHILDREN :
                // 어린이 영화 대여 가격은 1500 원
                resultAmount += 1500;
                // 기본 대여 기간이 3일 대여 가능하나 3일 초과하면 초과일수 만큰 가격은 1000원 추가
                if (daysOfRented > 3) {
                    resultAmount += (daysOfRented - 3 ) * 1000;
                }
                break;
        }
        return resultAmount;
    }
     */

    public double calculateRentalAmount(int daysOfRented) {
        return movePrice.calculateRentalAmount(daysOfRented);
    }

    public int getDefaultPoint() {
        // 2차 리팩토링
        //return 1;
        return movePrice.getDefaultPoint();
    }

    public int getPromotionPoint(int daysOfRented) {
        /*
        int resultPoint =0;
        if (getPriceCode() == Movie.NEW_RELEASE && daysOfRented > 1) {
            resultPoint = 1;
        }
        return resultPoint;
         */
        return movePrice.getPromotionPoint(daysOfRented);
    }
}
