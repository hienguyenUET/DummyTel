import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeeCalculatorTest {

    private final Date startDate = new Date();

    @Test
    void testTimeDiscounted() {

        DummyTel dummyTel = new DummyTel(startDate, 360);
        double expectedResult = 1.5;
        double actualResult = dummyTel.feeCalculator();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testTimeNotDiscounted() {

        DummyTel dummyTel = new DummyTel(startDate, 3601);
        double expectedResult = 23.01;
        double actualResult = dummyTel.feeCalculator();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testLongDuration() {

        DummyTel dummyTel = new DummyTel(startDate, 3800);

        double expectedResult = 0.12;
        double actualResult = dummyTel.feeCalculator();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testShortDuration() {

        DummyTel dummyTel = new DummyTel(startDate, 158);

        double expectedResult = 0.03;
        double actualResult = dummyTel.feeCalculator();

        assertEquals(expectedResult, actualResult);
    }
}
