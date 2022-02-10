public class CloudLevel {
    /*
Title: Cloud Level
Abstract: Measure and display level of clouds while also calculating their impact on temperature
Author: Reece Whitelaw
Date: 10/18/2021
 */
    private int level;

    public CloudLevel(){
//Level0-3 equals no clouds,light,med,and heavy respectively.
        level=(((int)(Math.random()*3)+0));
    }

    public int getLevel(){
        return level;
    }

    public String getLevelLabel(){
        if(getLevel()==0){
            return("None");
        }
        if(getLevel()==1){
            return("Light");
        }
        if(getLevel() == 2){
            return("Medium");
        }
        return("Heavy");
    }

    @Override
    public String toString() {
        return("Clouds: " + getLevelLabel());
    }

    public double getTemperatureChange(){
        if(getLevel()==0){
            return(6);
        }
        if(getLevel()==1||getLevel()==2){
            return(3);
        }
        return(5);
    }

}
