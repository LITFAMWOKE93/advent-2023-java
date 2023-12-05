// String manipulation
// Need to strip away everything but the first and last digit in a string.
// Need to read the text file puzzle

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day1Trebuchet {
    // highly coupled, but I'm still learning

    public static int readFile(int sum, String filename){
        try {
            File puzzleText = new File(filename);
            Scanner scnr = new Scanner(puzzleText);

            while(scnr.hasNextLine()) {
                String line = scnr.nextLine();
                
                // perform string manipulation and start storing array of digits to summate
                int digits = stringToInt(line);
                sum += digits;
                

            }

            scnr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error Occurred");
            e.printStackTrace();
        }
        return sum;
    }

    public static int stringToInt(String input){
        // Send to primitive array
        char[] chArray = input.toCharArray();

        
        // Store in a wrapped array to perform digit checks
        ArrayList<Character> wrapArray = new ArrayList<Character>();

        for (char ch : chArray) {
            Character chWrap = Character.valueOf(ch);

            // If the character is a digit, add it to the array.
            if (Character.isDigit(chWrap)) {
                wrapArray.add(chWrap);
            }            

        }
        
         // Now only keep the first and last elements
        while (wrapArray.size() > 2) {
            
                wrapArray.remove(1);

            }
        // If the array is only 1 digit, add a copy to the end so that there is always two-digit number
         if (wrapArray.size() < 2) {
                    Character lastDigit = wrapArray.get(0);
                    wrapArray.add(lastDigit);
                    System.out.println(wrapArray);
                }
        
        String stringDigit = "";
        // Now that the array is clean, convert to integer and add to sum
        for ( Character ch : wrapArray) {
           stringDigit = stringDigit + Character.toString(ch);
           
        }

        
        System.out.println(stringDigit);
        int digits = Integer.parseInt(stringDigit);
        
        
        

        

        return digits;
    }


    public static void main(String []args) {
        int sum = 0;
        int num = readFile(sum, "day_1_trebuchet.txt");

        System.out.println("The trebuchet calibration sum is: " + num);


    }
    
}
