public class Rain extends Precipitation{
    /*
Title: Rain
Abstract: Measure temperature change during rain
Author: Reece Whitelaw
Date: 10/18/2021
*/
    private static final Height amount= new Height(0);
    private static final String type = "Rain";

    public Rain(Height amount, String type){
        super(amount, type);

        amount = new Height((((int)(Math.random()*4)+0)));
    }

    @Override
    public double getTemperatureChange(){
        return(amount.getValue() * .9);
    }
    @Override
    public String toString() {
        return("Precipitation: " + amount.getValue() + " " + amount.getUnit() + "/" + amount.getUsValue() + " " + amount.getUsUnit() + "of " + type);
    }
}
