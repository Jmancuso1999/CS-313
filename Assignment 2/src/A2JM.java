/**
 * Student: James Mancuso
 * Professor Wang - T/Th - 5:00 - 6:15pm
 * CS313 A1-DLL/PLL - section 37
 */
import java.util.*;

/*Part A - #1
   Use a JCF (java collection framework) ArrayDeque or LinkedList as a stack to STORE all OPEN or LEFT parentheses.
   Ignore other characters, just check the () {} []
*/

public class A2JM {
   public static boolean isMatch(String expressionLine) {
      LinkedListStack<Character> st = new LinkedListStack <Character>();

      //Compare's the elements in the stack to check if it's valid (meaning it has a pair). Pop the element off the stack.
      for(int j = 0; j < expressionLine.length(); j++) {
         char posVar = expressionLine.charAt(j);

         //Push the LEFT or OPEN characters onto the stack, remove any NON-related characters, and leave the other characters to compare.
         if(expressionLine.charAt(j) == '(' || expressionLine.charAt(j) == '{' || expressionLine.charAt(j) == '[') st.push(expressionLine.charAt(j));

         if(posVar == ')') {
            if(st.isEmpty()) return false; //Case when there is more CLOSED parenthesis then OPEN parenthesis. OR there is only a CLOSED parenthesis
            else if(st.top() == '(') st.pop();
            else return false;
         }
         else if(posVar == '}') {
            if(st.isEmpty()) return false;
            else if(st.top() == '{') st.pop();
            else return false;
         }
         else if(posVar == ']') {
            if(st.isEmpty()) return false; 
            else if(st.top() == '[') st.pop();
            else return false;
         }
      } //end of for loop

      //If the stack is not empty by the END of the checking, return FALSE.
      return st.isEmpty();
   }
   public static void main (String argc[]) {
      String[] expression = new String[]{"{5*(x+2)+(y-1);}", "32*(20+(x[i]*3)-1","((){([][])})", "({}((0))", "{([]})", "{}())", "{"};
      //                 should return:           T               F                    T               F         F         F      F
      for (String st: expression)
    	  System.out.println(st + " is " + isMatch(st));
   }


   public static class LinkedListStack<E> implements Stack <E> {
      LinkedList <E> data;
      public LinkedListStack() {
         data = new LinkedList<>();
      }
      public void push(E element) {
         data.addFirst(element);
      }
      public E pop() {
         return data.removeFirst();
      }
      public E top() {
         return data.peekFirst();
      }
      public int size() {
         return data.size();
      }
      public boolean isEmpty() {
         return data.isEmpty();
      }
   }
  
   public interface Stack <E> {
	   	public void push(E element);
	      public E pop();
	      public E top();
	      public int size();
	      public boolean isEmpty();
   }
   
} //end of the A2 class