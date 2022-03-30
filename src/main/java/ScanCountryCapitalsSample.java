import java.util.*;
import java.io.*;

/**
 * This program shows a demonstration on how to use the Scanner and File classes to gather input
 * from an external .txt file.
 */ 

public class ScanCountryCapitalsSample{
   private static Scanner inFile = null;
   
   /**
    * Map the text file to the scanner; exit if error
    */
   public ScanCountryCapitalsSample(){
      try{
         inFile = new Scanner(new File("CapitalData.txt"));
      }
      catch(Exception e){
         System.out.println("Error in file reading...exiting");
         System.exit(0);
      }
   }
   
   /**
    * Scan each country as a single line, then break up into sections and print.
    */
   public void scanAndPrint(){
      while (inFile.hasNextLine()){
         String country = inFile.nextLine();
         
         //Country, capital and population are separated by ", " on each line.
         //The split method will return an array of substrings using ", " as the delimiter
         String[] data = country.split(", ");
         System.out.println("Country: " + data[0]);
         System.out.println("Capital: " + data[1]);
         System.out.println("Population: " + data[2] + "\n");
      }
   }
   
   public static void main(String[] args){
      ScanCountryCapitalsSample testRun = new ScanCountryCapitalsSample();
      testRun.scanAndPrint();
   }
}