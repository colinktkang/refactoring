package refactoring.martinfowler.ch01phase190refactoringcleaned;

public class ShopService {

    public static void main(String[] args) {

        // video 가게 오너 판매 가능 비디오 등록 0 : 일반 영화, 1 : 신규 영화., 2 : 어린이용
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

        String movieRentalStatement = rentalCustomerA.buildStatement();

        System.out.println(movieRentalStatement);

        String movieRentalHtmlStatement = rentalCustomerA.buildHtmlStatement();

        System.out.println(movieRentalHtmlStatement);

    }
}
