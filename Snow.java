public class Snow extends Precipitation{
    /*
Title: Snow
Abstract: Measure temperature change during snow
Author: Reece Whitelaw
Date: 10/18/2021
*/
    private static final Height amount= new Height(0);
    private static final String type = "Snow";

    public Snow(Height amount, String type){
        super(amount, type);

        amount = new Height((((int)(Math.random()*40)+0)));
    }

    @Override
    public double getTemperatureChange(){
        return(amount.getValue() * .15);
    }
    @Override
    public String toString() {
        return("Precipitation: " + amount.getValue() + " " + amount.getUnit() + "/" + amount.getUsValue() + " " + amount.getUsUnit() + "of " + type);
    }
}
