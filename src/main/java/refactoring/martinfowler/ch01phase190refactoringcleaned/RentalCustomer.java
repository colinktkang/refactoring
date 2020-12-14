package refactoring.martinfowler.ch01phase190refactoringcleaned;

import java.util.ArrayList;
import java.util.List;

public class RentalCustomer {

    private String name;
    private List<MovieRental> movieRentalList = new ArrayList();

    public RentalCustomer(String name) {
        this.name = name;
    }

    public void addRental(MovieRental movieRental) {
        this.movieRentalList.add(movieRental);
    }

    public String getName() {
        return name;
    }

    // 명세서 만들기
    public String buildStatement() {

        String resultStatement = getName() + " 고객님의 대여 기록\n";
        resultStatement += getEachRentalInfo();
        resultStatement += "누적 대여료 : " + String.valueOf(getTotalAmount()) + "\n";
        resultStatement += "적립 별 : " + String.valueOf(getTotalStarPoint()) + " 개\n";

        return resultStatement;
    }

    public String buildHtmlStatement() {
        String resultHtmlStatement = "<html>";
        resultHtmlStatement += "<body>";
        resultHtmlStatement += "<h1>" + getName() + " 고객님의 대여 기록</h1><br/>";
        resultHtmlStatement += getEachRentalInfo().replace("\n", "<br/>");
        resultHtmlStatement += "누적 대여료 : " + String.valueOf(getTotalAmount()) + "<br/>";
        resultHtmlStatement += "적립 별 : " + String.valueOf(getTotalStarPoint()) + " 개<br/>";
        resultHtmlStatement += "</body>";
        resultHtmlStatement += "</html>";
        return resultHtmlStatement;
    }

    private String getEachRentalInfo() {
        String result = "";

        for (MovieRental movieRental : movieRentalList) {
            result += "\t 대여영화 : " + movieRental.getMovie().getTitle() +
                      "\t 대여기간 : " + String.valueOf(movieRental.getDaysOfRented()) + " 일" +
                      "\t 대여가격 : " + String.valueOf(amountForFromRental(movieRental)) + " 원 \n";

        }
        return result;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        for (MovieRental movieRental : movieRentalList) {
            totalAmount += amountForFromRental(movieRental);
        }
        return totalAmount;
    }

    private int getTotalStarPoint() {
        int rentalStarPoint = 0;
        for (MovieRental movieRental : movieRentalList) {
            rentalStarPoint += pointForFromRental(movieRental);
        }
        return rentalStarPoint;
    }

    private double amountForFromRental(MovieRental movieRental) {
        return movieRental.calculateRentalAmount();
    }

    private int pointForFromRental(MovieRental movieRental) {
        return movieRental.calculateRentalPoint();
    }

}
