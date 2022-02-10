import java.lang.Math;
/*
Title: Temperature
Abstract: Display temperature as both celsius and fahrenheit
Author: Reece Whitelaw
Date: 10/18/2021
*/
public class Temperature extends Measurement{
    private static final String UNIT = "C";
    private static final String USUNIT = "F";
    private double temperature;


    public Temperature(){
        super(((int)(Math.random() * 20) + 0), UNIT, USUNIT);

    }

    public Temperature(Temperature pm, Windlevel windlevel, Precipitation precipitation){
        super(pm.getValue(), UNIT, USUNIT);
        temperature = pm.getValue();
        temperature = (temperature - precipitation.getTemperatureChange() + windlevel.getTemperatureChange());
        midmorn = true;
    }

    public Temperature(Temperature am, CloudLevel clouds){
        super(am.getValue(), UNIT, USUNIT);
        temperature = am.getValue();
        temperature = (temperature - clouds.getTemperatureChange());
        midmorn = false;
    }


    @Override
    public String toString() {
        String day = "";
        if (midmorn == true){
            day = "Morning";
        }else{
            day = "Midday";
        }
        return (day + " Temperature: " + temperature + " " + getUnit() + "/" + getUsValue() + " " + getUsUnit());
    }

    @Override
    public double getUsValue() {
        //If celsius equals 0 than Fahrenheit equals 33, so we must facilitate that.
        if(getValue() == 0){
            return(32);
        }else{
            return((temperature * 9/5) + 32);
        }
    }

}