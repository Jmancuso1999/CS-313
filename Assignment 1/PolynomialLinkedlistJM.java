/**
 * Student: James Mancuso
 * Professor Wang - T/Th - 5:00 - 6:15pm
 * CS313 A1-DLL/PLL - section 37
 */
public class PolynomialLinkedlistJM{
   private static class PNode{
      private int coe;
      private int exp;
      private PNode next;
      
      public PNode(int c, int e){
	      this(c, e, null);
      }
      public PNode(int c, int e, PNode n){
         coe = c;
         exp = e;
         next = n;
      }
      public void setCoe(int c){ coe = c;}
      public void setExp(int e){ exp = e;}
      public void setNext(PNode n){ next = n;}
      public int getCoe(){ return coe;}
      public int getExp(){ return exp;}
      public PNode getNext(){ return next;}
   }
   private PNode head;
   public PolynomialLinkedlistJM(){
      head = null;
   }
   private void add(int c, int e){
      PNode tempn = new PNode(c, e, head);
      head = tempn;
   }
   public void removeDuplicate(){
      if (head == null) return;
      PNode lookUp, checkPrev;
      lookUp = checkPrev = head;
      while (lookUp.getNext() != null){
	      while (checkPrev.getNext() != null){
	         if (checkPrev.getNext().getExp() == lookUp.getExp()){//found a duplicate
		         //lookUp.coe += checkPrev.next.coe;
		         lookUp.setCoe(lookUp.getCoe() + checkPrev.getNext().getCoe());
		         checkPrev.setNext(checkPrev.getNext().getNext());
	         }
	         else checkPrev = checkPrev.getNext();
	      }
         lookUp = lookUp.getNext();
	      checkPrev = lookUp;
      }	     	     
   }
   public PolynomialLinkedlistJM add(PolynomialLinkedlistJM pl){
      PNode addTerm = this.head;
      PolynomialLinkedlistJM ans = new PolynomialLinkedlistJM();
      for (int i = 0; i < 2; i++){
	      while (addTerm != null){
	         ans.add(addTerm.getCoe(), addTerm.getExp());
	         addTerm = addTerm.next;
	      }
         addTerm = pl.head;
      }
      ans.removeDuplicate();
      return ans;	 
   }
   public PolynomialLinkedlistJM multiply(PolynomialLinkedlistJM pl){
      PNode addTerm = this.head; //head of the 1st 
      PNode secondTerm = pl.head;
      PolynomialLinkedlistJM ans = new PolynomialLinkedlistJM();
      while(addTerm != null) {
         while(secondTerm != null) {
            ans.add(addTerm.getCoe() * secondTerm.getCoe(), addTerm.getExp() + secondTerm.getExp());
            secondTerm = secondTerm.next;
         }
         addTerm = addTerm.next;
         secondTerm = pl.head; 
      }
      ans.removeDuplicate();
      return ans;	 
   }
   public void print(){
      if (head == null){
         System.out.println();
         return;
      }
      removeDuplicate();
      PNode temp = head;
      while (temp.getNext() != null){
         if (temp.getCoe() != 0){
	         System.out.print("(" + temp.getCoe() + ")");
	         if (temp.getExp() != 0){
	            System.out.print("X^" + temp.exp);
	         }
	         System.out.print(" + ");
  	      }
	   temp = temp.next;
      }
      if (temp != null){
         System.out.print(temp.coe);
	   if (temp.exp != 0) System.out.print("X^" + temp.exp);
         System.out.println();
      }

   }
   public static void main(String argc[]){
      PolynomialLinkedlistJM pn1 = new PolynomialLinkedlistJM();
      PolynomialLinkedlistJM pn2 = new PolynomialLinkedlistJM();
      pn1.add(1, 2);
      pn1.add(2, 3);
      pn2.add(1, 0);
      pn2.add(5, 1);
      pn2.add(-6, 1);
      pn2.add(4, 2);
      System.out.print("Polynomial 1: ");
      pn1.print();
      System.out.print("Polynomial 2: ");
      pn2.print();
      PolynomialLinkedlistJM sum = pn1.add(pn2);
      PolynomialLinkedlistJM prod = pn1.multiply(pn2);
      System.out.print("Sum: ");
      sum.print();   
      System.out.print("Product: ");
      prod.print();   
   }
}