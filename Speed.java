public class Speed extends Measurement{
    /*
Title: Speed
Abstract: Calculate speed in kph and mph
Author: Reece Whitelaw
Date: 10/18/2021
 */
    private static final String UNIT = "kph";
    private static final String USUNIT = "mph";

    public Speed(double value){
        super(value, UNIT, USUNIT);
    }

    @Override
    public double getUsValue() {
        return (getValue() * 0.6214);
    }

}
