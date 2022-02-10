public abstract class Measurement {
    /*
Title: Measurement
Abstract: Parent class for values in all forms of measurements
Author: Reece Whitelaw
Date: 10/18/2021
*/
    private double value;
    private String unit;
    private String usUnit;
    //False means it's morning and true means its midday.
    static boolean midmorn;

    public boolean getmidmorn() {
        return midmorn;
    }

    Measurement(double value, String unit, String usUnit) {
        this.value = value;
        this.unit = unit;
        this.usUnit = usUnit;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return String.format("%d %s/%d %s",
                Math.round(this.value),
                this.unit,
                Math.round(this.getUsValue()),
                this.getUsUnit());
    }

    public abstract double getUsValue();

    public String getUsUnit() {
        return this.usUnit;
    }

}
