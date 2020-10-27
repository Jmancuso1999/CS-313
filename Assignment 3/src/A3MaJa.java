/*
 * Student: James Mancuso
 * Class: CS313 - section 37 - T/Th 5:00pm - 6:15pm
 * Assignment #3 - Part A #3 
 * Due: Saturday, November 16th
 */

import java.io.*;
import java.util.*;

public class A3MaJa{
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
        List<String> names = readInFile("A3input.txt");

        //Part A - #3
        Map <Integer, List<String>> map = new TreeMap<Integer, List<String>>();

        int iterator = 0;

        while(iterator < names.size()) {
            int mapKey = names.get(iterator).length(); //Use the LENGTH as a map key 
            List <String> addN = map.get(mapKey);
            //Checking for pre-existing list,if not, create a list for that key
            if(addN == null) { 
                addN = new ArrayList<String>();
                addN.add(names.get(iterator)); 
                map.put(mapKey, addN); //add list to the specified key(length of name)
            }
            else { //If list exists at that value, add name to list
                addN.add(names.get(iterator));
            }
            iterator++;
        } //end of while loop

        StringBuilder sb = new StringBuilder();

        //Puts each set of names into the string builder - based on length of name
        //For each loop that iterates each map set (values (list)) until all entries are iterated
        //Check Java Oracle for Map - forEach

        for(Map.Entry<Integer, List<String>> m: map.entrySet()) {
            //If there's an empty amount of characters at that specified length - DONT print
            if(m.getValue() != null) sb.append(m.getValue() + "\n");
        }
        
        System.out.println(sb);
   }
}
