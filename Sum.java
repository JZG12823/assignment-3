import java.util.*;
import java.io.*;
public class Sum {

   private static boolean isValidInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int lrg_math(String path){
         int c = 0;       
         int[] sum = new int[25];
         int carry = 0;
         try {
            Scanner input = new Scanner(new File(path));
            
               while(input.hasNextLine()){
                  boolean flip = false;
                  String sumary = "";
                  int[] numA = new int[25]; 
                  int[] numB = new int[25];
                  String nums = input.nextLine();
                  String[] numbers = nums.split(" ");
                  for(int i = 0; i < (numbers.length - 1); i++){
                     boolean ff = false;
                     System.out.print(numbers[i]);
                     String[] Snumbers = numbers[i].split("");
                     for(int b = 0; b < (25 - Snumbers.length); b++){
                           numA[b] = 0;
                        }
                        int r = 0;
                        for(int e = (25 - Snumbers.length); e < 25; e++){
                           if (isValidInteger(Snumbers[r])) {
                              numA[e] = Integer.parseInt(Snumbers[r]);
                              r++;
                              ff = true;
                           
                           }
                           
                        }
                        for(int q = 0; q < (numA.length - 1); q++){
                        
                           //System.out.print(numA[q]);
                        
                        }
                        //System.out.print(numA[numA.length - 1]);
                        if(ff == true){
                           System.out.print(" + ");
                        }
                        for(int w = 24; w > 0; w--){
                        
                           if((numB[w] + numA[w]) > 10){
                              numB[w] = (numB[w] + numA[w]) - 10 + carry;
                              carry = 1;
                           }else{
                              numB[w] = numB[w] + numA[w] + carry;
                              carry = 0;
                           }
                           
                        }
                        
                  }
                  System.out.print(numbers[numbers.length - 1]);
                  String[] Snumbers = numbers[numbers.length - 1].split("");
                  for(int b = 0; b < (25 - Snumbers.length); b++){
                           numA[b] = 0;
                        }
                        int r = 0;
                        for(int e = (25 - Snumbers.length); e < 25; e++){
                           if (isValidInteger(Snumbers[r])) {
                              numA[e] = Integer.parseInt(Snumbers[r]);
                              r++;
                           
                           }
                           
                        }
                        for(int q = 0; q < (numA.length - 1); q++){
                        
                           //System.out.print(numA[q]);
                        
                        }
                        //System.out.print(numA[numA.length - 1]);
                        for(int w = 24; w > 0; w--){
                        
                           if((numB[w] + numA[w]) >= 10){
                              numB[w] = (numB[w] + numA[w]) - 10 + carry;
                              carry = 1;
                           }else{
                              numB[w] = numB[w] + numA[w] + carry;
                              carry = 0;
                           }
                           
                        }
                        for(int u = 0; u < numB.length; u++){
                             if(numB[u] > 0 || flip == true){
                               sumary = sumary + numB[u];
                               flip = true;
                             }                        
                        }
                  System.out.print(" = ");
                  System.out.print(sumary);
                  System.out.println();
                  c++;
               }
            
            }
            
         catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
         }
         System.out.println();
         return(c);
    
    }
    
    public static void main(String[] args) {
         System.out.println("Total lines = " + lrg_math("sum.txt"));
    }
}
