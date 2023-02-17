import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeeCalculator {

    private final PhoneCall phoneCall = new PhoneCall(new Date(), 3600);

    @Test
    void testCall() {

        assertEquals(1.5, phoneCall.feeCalculator());
    }
}
