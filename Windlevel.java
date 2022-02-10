public class Windlevel{
        /*
Title: Windlevel
Abstract: Display speeds and temperature change of wind
Author: Reece Whitelaw
Date: 10/18/2021
 */

    private static final Speed speed = new Speed((double)(Math.random() * 20) + 0);
    private static final double direction = ((double)(Math.random() * 2) + 1);


    public Windlevel(){
    }

    public String toString() {
        return("Winds: " + getSpeed() + " kph/" + speed.getUsValue() + " MPH");
    }

    public static Speed getSpeed() {
        return speed;
    }

    public double getTemperatureChange(){
        if(direction == 1){
            return (0.5 * speed.getValue());
        }else{
            return(0.65 * speed.getValue());
        }
    }
}
