import java.util.Scanner;
/*

Title: Histogram

Abstract: Creates a histogram of values.

Author: Reece Whitelaw

Date: 9/10/2021
 */
public class Histogram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxnumbers;
        System.out.println("How many input values [max: 30]?");
        maxnumbers = in.nextInt();
        int inputvalues[] = new int [maxnumbers];
        int frequencytable[] = new int [10];
        System.out.println("Enter " + maxnumbers + " numbers.");
        for (int i = 0; i < maxnumbers; i++){
            inputvalues[i] = in.nextInt();
        }
        System.out.print("\n");
        //This array searches for the amount of instances of a number in the inputvalues array.
        for(int i = 0; i < 10; i++){
            for(int c = 0; c < maxnumbers; c++){
                if (inputvalues[c] == i){
                    frequencytable[i]+= 1;
                }
            }
        }
        System.out.print("Number    Occurrence\n");
        //The following loop checks if the occurences for a number (which is equal to array) is greater than 0. If it is, it prints.
        for (int i = 0; i < 10; i++){
            if (frequencytable[i] > 0){
                System.out.print(i +   "        " + frequencytable[i]+ "\n");
            }
        }
        //Finding the highest value occurrence
        int highestfrequency = 0;
        for (int i = 0; i < 10; i++){
            if( frequencytable[i] > highestfrequency){
                highestfrequency = frequencytable[i];
            }
        }

        //Moving on to print formatting for the histogram
        System.out.println("========= Vertical Bar ========");
        for (int i = maxnumbers; i > -1; i--){
            if(highestfrequency > 0){
                System.out.print("| " + highestfrequency + " |  ");
                for (int p = 0; p < 10; p++){
                    if(frequencytable[p] >= highestfrequency){
                        System.out.print("* ");
                    }else{
                        System.out.print("  ");
                    }
                }
                System.out.println("");
                highestfrequency-=1;
            }

        }
        //This starts once we've gone through all the frequencies and made our histogram
        System.out.println("===============================");
        System.out.println("| N |  0 1 2 3 4 5 6 7 8 9");
        System.out.println("===============================");
    }
}