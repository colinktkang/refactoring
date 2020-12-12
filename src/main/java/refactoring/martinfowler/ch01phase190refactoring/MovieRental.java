package refactoring.martinfowler.ch01phase190refactoring;

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

    /*
    public double calculateRentalAmount() {
        //double thisAmount = 0;
        double resultAmount = 0;
        // 비디오 카테고리별 대여로 계산
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR :
                // 일반영화 대여 가격은 2000 원
                resultAmount += 2000;
                /// 기본 대여 기간이 2일 대여 가능하나 2일 초과하면 초과일수 만큰 가격은 1500원 추가
                if (getDaysOfRented() > 2)
                    resultAmount += (getDaysOfRented() -2) * 1500;
                break;
            case Movie.NEW_RELEASE :
                // 신규 영화 대여 가격은 하루 3000 원
                resultAmount += getDaysOfRented() * 3000;
                break;
            case Movie.CHILDREN :
                // 어린이 영화 대여 가격은 1500 원
                resultAmount += 1500;
                // 기본 대여 기간이 3일 대여 가능하나 3일 초과하면 초과일수 만큰 가격은 1000원 추가
                if (getDaysOfRented() > 3) {
                    resultAmount += (getDaysOfRented() - 3 ) * 1000;
                }
                break;
        }
        return resultAmount;
    }

    */

    public double calculateRentalAmountFromMovie() {
        return movie.calculateRentalAmount(this.daysOfRented);
    }

    public int calculateRentalPoint() {
        int rentalStarPoint = 0;
        //rentalStarPoint++;
        //rentalStarPoint += getDefaultPoint() + getPromotionPoint();

        // 최신물을 2일 이상 대여하면 별 1개 더 적립
        //if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysOfRented() > 1)
        //    rentalStarPoint++;


        // 리팩토링
        //return rentalStarPoint;

        // 리팩토
        //return getDefaultPoint() + getPromotionPoint();
        return movie.getDefaultPoint() + movie.getPromotionPoint(daysOfRented);
    }

    /*
    private int getDefaultPoint() {
        return 1;
    }
     */

    /*
    private int getPromotionPoint() {
        int resultPoint =0;
        if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysOfRented() > 1) {
            resultPoint = 1;
        }
        return resultPoint;
    }
    */

}
