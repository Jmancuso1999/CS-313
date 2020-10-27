/**
 * Student: James Mancuso
 * Professor Wang - T/Th - 5:00 - 6:15pm
 * CS313 A1-DLL/PLL - section 37
 */

public class DLinkedListJM<E>{
   private static class DNode<E>{
      private E element;
      private DNode<E> prev;
      private DNode<E> next;
      
      public DNode(E e){
	      this(e, null, null);
      }
      public DNode(E e, DNode<E> p, DNode<E> n){
         element = e;
         prev = p;
         next = n;
      }
      public E getE(){
	      return element;
      }
      public DNode<E> getPrev(){
	      return prev;
      }
      public DNode<E> getNext(){
	      return next;
      }
      public void setE(E e){
	      element = e;
      }
      public void setPrev(DNode<E> p){
	      prev = p;
      }
      public void setNext(DNode<E> n){
	      next = n;
      }
   }

   private DNode<E> header;
   private DNode<E> trailer;
   private int size;
   public DLinkedListJM(){  
      header = new DNode<E>(null);
      trailer = new DNode<E>(null, header, null);
      header.setNext(trailer);
      size = 0;
   }
   public void addFirst(E e){
      DNode<E> headerNext = header.getNext();
      DNode<E> tempN = new DNode <E>(e, header, headerNext);
      headerNext.setPrev(tempN);
      header.setNext(tempN);
      size++;
   }
   public void addLast(E e){
      DNode<E> trailerPrev = trailer.getPrev();
      DNode<E> temp = new DNode<E>(e, trailerPrev, trailer);
      trailer.setPrev(temp);
      trailerPrev.setNext(temp);
      size++; 
  }
   public E get(int i) throws Exception{
      //KNOW THE EXCEPTION CASE
      if (i < 0 || i >= size) throw new Exception("Bad Index");
      DNode<E> ansNode = header.getNext();
      
      if (i < size / 2){   //lower end (1st half of the linked list)
	      ansNode = header.getNext();
         //loop - traversal from header
         while(i > 0) {
            ansNode = ansNode.getNext(); //NOTE: We do ansNode.getNext() INSTEAD of temp.getNext() so it CONTINUES the loop and doesnt continue to reiterate the head.
            i--; 
         }
      }
      else {    //higher end (2nd half of the linked list)
 	      ansNode = trailer.getPrev();
         //loop - traversal from trailer
         i++;
         while(i < size) {
            ansNode = ansNode.getPrev(); //NOTE: We do ansNode.getNext() INSTEAD of temp.getNext() so it CONTINUES the loop and doesnt continue to reiterate the trailer.
            i++;
         }
      }
      return ansNode.getE();
   }
   public void print(){
      DNode<E> temp = header.getNext();
      while (temp != trailer){
         System.out.print(temp.getE() + ", ");
	      temp = temp.getNext();
      }
         System.out.println();
   }
   public static void main(String argc[]){
      DLinkedListJM<String> l = new DLinkedListJM<String>();
      l.addFirst("Three");
      l.addLast("Four");
      l.addFirst("Two");
      l.addFirst("One");
      l.addLast("Five");
      l.addFirst("Zero");
      l.print();
      try {
         System.out.println("at 1: " + l.get(1));
         System.out.println("at 2: " + l.get(2));
         System.out.println("at 3: " + l.get(3));

         System.out.println("at 6: " + l.get(6));
      }
      catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }
}