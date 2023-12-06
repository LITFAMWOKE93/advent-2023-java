// String manipulation
// Need to strip away everything but the first and last digit in a string.
// Need to read the text file puzzle
//Part 2: Parse out the the written "digits" as valid numbers

// LESSON LEARNED: Carefully read prompt requirements, it's very easy to start coding a solution for the wrong problem.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Day1Trebuchet {
    // highly coupled, but I'm still learning

    public static int readFileDigits(int sum, String filename){
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



   
/* Part 2 defeated me, thanks to u/TiltSword for the answer
 * I need to do some regex studying, this was pretty clever swapping out
 * the numeral digits to contain a digit to allow for stripping out the 
 * numerics and then youre left with all digits in the correct order,
 * after that you place the first index with the second subtracting the ASCII value of the char type
 */
    public static void main(String[] args){
    long sum=0;
    try{
        BufferedReader br=new BufferedReader(new FileReader("day_1_trebuchet.txt"));
        sum=br.lines().map(s->s.replaceAll("one","o1ne").replaceAll("two","t2wo")
                        .replaceAll("three","t3hree").replaceAll("four","f4our").replaceAll("five","f5ive")
                        .replaceAll("six","s6ix").replaceAll("seven","s7even").replaceAll("eight","e8ight")
                        .replaceAll("nine","n9ine").replaceAll("[a-z]",""))
                .mapToInt(s->(s.charAt(0)-'0')*10+s.charAt(s.length()-1)-'0').sum();
        br.close();
    }catch(Exception e){System.out.println(e.toString());}
    System.out.println(sum);
}
    
}
