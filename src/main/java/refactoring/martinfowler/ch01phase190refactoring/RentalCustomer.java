package refactoring.martinfowler.ch01phase190refactoring;

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

        //double totalAmount = 0;
        //int rentalStarPoint = 0;
        String resultStatement = getName() + " 고객님의 대여 기록\n";

        /*
        // 고객의 렌탈기록을 가지고 전체 금액 계
        for (MovieRental movieRental : movieRentalList) {

            // 비디오 카테고리별 대여로 계산
            // 1차 리팩토링 : 메소드로 분리
            //double thisAmount = amountFor(movieRental);
            // 2차 리팩토링 : 메소드를 호출 변
            double thisAmount = amountForFromRental(movieRental);

            // 적립 별을 1개 증가
            // 1차 리팩토링
            //rentalStarPoint += pointFor(movieRental);
            //rentalStarPoint += pointForFromRental(movieRental);


            // 영화명과 기간, 가격을 명세서에 추가
            resultStatement +=
                    "\t 대여영화 : " + movieRental.getMovie().getTitle() +
                    "\t 대여기간 : " + String.valueOf(movieRental.getDaysOfRented()) + " 일" +
                    "\t 대여가격 : " + String.valueOf(thisAmount) + " 원 \n";

            // 1차 리팩토링
            //totalAmount += thisAmount;
        }

        */

        resultStatement += getEachRentalInfo();

        // 명세서에 전체 대여료 및 적립 포인트 추가
        //resultStatement += "누적 대여료 : " + String.valueOf(totalAmount) + "\n";
        resultStatement += "누적 대여료 : " + String.valueOf(getTotalAmount()) + "\n";
        //resultStatement += "적립 별 : " + String.valueOf(rentalStarPoint) + " 개\n";
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
        // 고객의 렌탈기록을 가지고 전체 금액 계
        for (MovieRental movieRental : movieRentalList) {

            // 비디오 카테고리별 대여로 계산
            // 1차 리팩토링 : 메소드로 분리
            //double thisAmount = amountFor(movieRental);
            // 2차 리팩토링 : 메소드를 호출 변
            double thisAmount = amountForFromRental(movieRental);

            // 적립 별을 1개 증가
            // 1차 리팩토링
            //rentalStarPoint += pointFor(movieRental);
            //rentalStarPoint += pointForFromRental(movieRental);


            // 영화명과 기간, 가격을 명세서에 추가
            result +=
                    "\t 대여영화 : " + movieRental.getMovie().getTitle() +
                            "\t 대여기간 : " + String.valueOf(movieRental.getDaysOfRented()) + " 일" +
                            "\t 대여가격 : " + String.valueOf(thisAmount) + " 원 \n";

            // 1차 리팩토링
            //totalAmount += thisAmount;
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

    private double amountFor(MovieRental movieRental) {
        //double thisAmount = 0;
        double resultAmount = 0;
        // 비디오 카테고리별 대여로 계산
        switch (movieRental.getMovie().getPriceCode()) {
            case Movie.REGULAR :
                // 일반영화 대여 가격은 2000 원
                resultAmount += 2000;
                /// 기본 대여 기간이 2일 대여 가능하나 2일 초과하면 초과일수 만큰 가격은 1500원 추가
                if (movieRental.getDaysOfRented() > 2)
                    resultAmount += (movieRental.getDaysOfRented() -2) * 1500;
                break;
            case Movie.NEW_RELEASE :
                // 신규 영화 대여 가격은 하루 3000 원
                resultAmount += movieRental.getDaysOfRented() * 3000;
                break;
            case Movie.CHILDREN :
                // 어린이 영화 대여 가격은 1500 원
                resultAmount += 1500;
                // 기본 대여 기간이 3일 대여 가능하나 3일 초과하면 초과일수 만큰 가격은 1000원 추가
                if (movieRental.getDaysOfRented() > 3) {
                    resultAmount += (movieRental.getDaysOfRented() - 3 ) * 1000;
                }
                break;
        }
        return resultAmount;
    }

    private double amountForFromRental(MovieRental movieRental) {
        // 2차 리팩토링
        //return movieRental.calculateRentalAmount();
        return movieRental.calculateRentalAmountFromMovie();
    }

    private double pointFor(MovieRental movieRental) {
        double rentalStarPoint = 0;
        rentalStarPoint++;

        // 최신물을 2일 이상 대여하면 별 1개 더 적립
        if (movieRental.getMovie().getPriceCode() == Movie.NEW_RELEASE &&
                movieRental.getDaysOfRented() > 1)
            rentalStarPoint++;
        return rentalStarPoint;
    }

    private int pointForFromRental(MovieRental movieRental) {
        return movieRental.calculateRentalPoint();
    }

}
