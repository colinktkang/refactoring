package refacroring.martinfowler.ch01phase190refactoringcleaned;

import refactoring.martinfowler.ch01phase190refactoringcleaned.Movie;
import refactoring.martinfowler.ch01phase190refactoringcleaned.MovieRental;
import refactoring.martinfowler.ch01phase190refactoringcleaned.RentalCustomer;

public class CustomerData {

    public static RentalCustomer getRentalCustomer김지수() {
        Movie movieForRegular = new Movie("머니볼", 0);
        Movie movieForNew = new Movie("찬실이는 복도 많지", 1);
        Movie movieForChild = new Movie("해리포터와 마법사의 돌", 2);

        RentalCustomer rentalCustomerA = new RentalCustomer("김지수");

        MovieRental movieRentalForRegular = new MovieRental(movieForRegular, 1);
        MovieRental movieRentalForNew = new MovieRental(movieForNew, 3);
        MovieRental movieRentalForChild = new MovieRental(movieForChild, 1);

        rentalCustomerA.addRental(movieRentalForRegular);
        rentalCustomerA.addRental(movieRentalForNew);
        rentalCustomerA.addRental(movieRentalForChild);

        return rentalCustomerA;
    }

    public static String getRentalCustomer김지수ExpectedResult() {
        String expectedRentalStatement =
                "김지수 고객님의 대여 기록\n" +
                        "\t 대여영화 : 머니볼\t 대여기간 : 1 일\t 대여가격 : 2000.0 원 \n" +
                        "\t 대여영화 : 찬실이는 복도 많지\t 대여기간 : 3 일\t 대여가격 : 9000.0 원 \n" +
                        "\t 대여영화 : 해리포터와 마법사의 돌\t 대여기간 : 1 일\t 대여가격 : 1500.0 원 \n" +
                        "누적 대여료 : 12500.0\n" +
                        "적립 별 : 4 개\n";

        return expectedRentalStatement;
    }
}
