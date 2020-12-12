package refacroring.martinfowler.ch01phase190refactoring;

import junit.framework.TestCase;
import org.junit.Test;
import refactoring.martinfowler.ch01phase190refactoring.RentalCustomer;

public class RentalCustomerTest extends TestCase {

    @Test
    public void testBuildStatement() {

        RentalCustomer rentalCustomer = CustomerData.getRentalCustomer김지수();

        String movieRentalStatement = rentalCustomer.buildStatement();

        System.out.println("RESULT : " + movieRentalStatement);

        String expectedRentalStatement = CustomerData.getRentalCustomer김지수ExpectedResult();

        assertEquals(movieRentalStatement, expectedRentalStatement);

    }

}