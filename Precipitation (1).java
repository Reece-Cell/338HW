public class Precipitation{
    /*
Title: Precipitation
Abstract: Measure snow or rain amounts for temperature change
Author: Reece Whitelaw
Date: 10/18/2021
 */

    private Height amount = new Height(0);
    private String type;


    public Precipitation(Height amount, String type){
        this.amount = amount;
        this.type = type;
    }

    public Height getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        if (amount.getmidmorn() == true) {
            if (amount.getUsValue() < 32) {
                Snow snow = new Snow(amount, type);
                return(snow.toString());
            }
        }
        Rain rain = new Rain(amount, type);
        return(rain.toString());
    }

    public double getTemperatureChange() {
        if (amount.getmidmorn() == true) {
            if (amount.getUsValue() < 32) {
                Snow snow = new Snow(amount, type);
                return(snow.getTemperatureChange());
            }
        }
        Rain rain = new Rain(amount, type);
        return(rain.getTemperatureChange());
    }
}