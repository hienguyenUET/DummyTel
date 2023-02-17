import java.util.Date;

public class Main {
    public static void main(String[] args) {

        PhoneCall phoneCall = new PhoneCall(new Date(), 158);
        double fee = phoneCall.feeCalculator();
        System.out.println(fee);
    }
}