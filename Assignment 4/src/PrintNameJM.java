/**
 * Student: James Mancuso
 * Professor Wang - T/Th - 5:00 - 6:15pm
 * CS313 A1-DLL/PLL - section 37
 * 
 * Assignment #4
 */

import java.io.*;
import java.util.*;

public class PrintNameJM{
   public static List<String> readInFile(String filename){
      List<String> input = new ArrayList<>();
      try (Scanner sin = new Scanner(new FileReader(filename))){
         while (sin.hasNextLine()){
	         input.add(sin.nextLine());
         }
      } catch (FileNotFoundException e){
	         e.printStackTrace();
      }
      return input;
  }
   public static void main(String[] args){
      List<String> namelist1 = readInFile("A4input1.txt");
      List<String> namelist2 = readInFile("A4input2.txt");
      List<String> namelist3 = readInFile("A4input3.txt");

      //Using HashSet because it removes duplicates
      Set<String> names = new HashSet<String>(namelist1);
      names.addAll(namelist2);   //addAll is a set method that allows you to add an entire list to the set
      names.addAll(namelist3);

      System.out.println(names);
   }
}
