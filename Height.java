public class Height extends Measurement{
    /*
Title: Height
Abstract: Measure height differences in cm and in
Author: Reece Whitelaw
Date: 10/18/2021
*/

    private static final String UNIT = "cm";
    private static final String USUNIT = "in";

    public Height(double value){
        super(value, UNIT, USUNIT);
    }

    @Override
    public double getUsValue() {
        return(getValue()/2.54);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}