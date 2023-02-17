import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.Date;

public class PhoneCall {

    private Date startPhoneCall;
    private double fee;
    private long duration;
    private Calendar fromSixteenth;
    private Calendar toTwentyThree;
    private Calendar fromZero;
    private Calendar toEight;
    private final double TAX = 0.05;
    private final double SPECIFIC_HOUR_DISCOUNT = 0.5;
    private final double LONG_DURATION_DISCOUNT = 0.15;
    private final double FEE = 0.50;
    private final Logger log = LogManager.getLogger();


    protected double feeCalculator() {

        if (fromSixteenth == null) {
            log.error("{} is null", fromSixteenth);
            throw new NullPointerException("Time to check is null: + " + fromSixteenth);

        }
        if (toEight == null) {
            log.error("{} is null", toEight);
            throw new NullPointerException("Time to check is null: " + toEight);
        }
        if (fromZero == null) {
            log.error("{} is null", toEight);
            throw new NullPointerException("Time to check is null: " + fromZero);
        }
        if (toTwentyThree == null) {
            log.error("{} is null", toTwentyThree);
            throw new NullPointerException("Time to check is null: " + toTwentyThree);
        }

        boolean firstTimeCondition = startPhoneCall.compareTo(fromSixteenth.getTime()) == 1 && startPhoneCall.compareTo(toTwentyThree.getTime()) == -1;
        boolean secondTimeCondition = startPhoneCall.compareTo(fromZero.getTime()) == 1 && startPhoneCall.compareTo(toEight.getTime()) == -1;

        fee = duration * (FEE / 60);
        log.info("Calling time: {}, Duration: {}, total fee: {}", startPhoneCall, duration, fee);

        if (firstTimeCondition || secondTimeCondition) {
            fee = fee * SPECIFIC_HOUR_DISCOUNT;
            log.info("Calling satisfied discount condition. Fee: {}", fee);
        }
        if (duration > 3600) {
            fee = fee * LONG_DURATION_DISCOUNT;
            log.info("Duration longer than 60 minutes, after being discount: {}", fee);
        }
        double feeAfterTax = (double) Math.round(fee * TAX * 100) / 100;

        log.info("Fee to pay: {}", feeAfterTax);
        return feeAfterTax;
    }

    public PhoneCall(Date startPhoneCall, long duration) {

        if (fromSixteenth == null) {
            fromSixteenth = Calendar.getInstance();
            fromSixteenth.set(Calendar.HOUR_OF_DAY, 18);
            fromSixteenth.set(Calendar.MINUTE, 0);
            fromSixteenth.set(Calendar.SECOND, 0);
        }

        if (toTwentyThree == null) {
            toTwentyThree = Calendar.getInstance();
            toTwentyThree.set(Calendar.HOUR_OF_DAY, 23);
            toTwentyThree.set(Calendar.MINUTE, 59);
            toTwentyThree.set(Calendar.SECOND, 59);
        }

        if (fromZero == null) {
            fromZero = Calendar.getInstance();
            fromZero.set(Calendar.HOUR_OF_DAY, 23);
            fromZero.set(Calendar.MINUTE, 59);
            fromZero.set(Calendar.SECOND, 59);
        }

        if (toEight == null) {
            toEight = Calendar.getInstance();
            toEight.set(Calendar.HOUR_OF_DAY, 8);
            toEight.set(Calendar.MINUTE, 0);
            toEight.set(Calendar.SECOND, 0);
        }


        this.startPhoneCall = startPhoneCall;
        this.duration = duration;
    }

    public Date getStartPhoneCall() {
        return startPhoneCall;
    }

    public void setStartPhoneCall(Date startPhoneCall) {
        this.startPhoneCall = startPhoneCall;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "PhoneCall{" +
                "\n" + "startPhoneCall= " + startPhoneCall + "" +
                "\nfee= " + fee +
                "\nduration= " + duration +
                "\n}";
    }
}


