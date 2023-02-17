import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeeCalculator {

    private final Date startDate = new Date();

    @Test
    void testTimeDiscounted() {

        PhoneCall phoneCall = new PhoneCall(startDate, 360);
        double expectedResult = 1.5;
        double actualResult = phoneCall.feeCalculator();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testTimeNotDiscounted() {

        PhoneCall phoneCall = new PhoneCall(startDate, 3601);
        double expectedResult = 23.01;
        double actualResult = phoneCall.feeCalculator();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testLongDuration() {

        PhoneCall phoneCall = new PhoneCall(startDate, 3800);

        double expectedResult = 0.12;
        double actualResult = phoneCall.feeCalculator();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testShortDuration() {

        PhoneCall phoneCall = new PhoneCall(startDate, 158);

        double expectedResult = 0.03;
        double actualResult = phoneCall.feeCalculator();

        assertEquals(expectedResult, actualResult);
    }
}
