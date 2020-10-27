/**
 * Student: James Mancuso
 * Professor Wang - T/Th - 5:00 - 6:15pm
 * CS313 A1-DLL/PLL - section 37
 */

import java.util.*;

public class TreeJM{
   private static class TNode{
      private int data;
      private TNode parent;
      private List<TNode> children;
      public TNode(){
         this(0, null);
      }
      public TNode(int e){
         this(e, null);
      }
      public TNode(int e, TNode p){
         data = e;
	      parent = p;
	      children = new ArrayList<TNode>();
      }
      public int getData(){
	      return data;
      }
      public TNode getParent(){
         return parent;
      }
      public List<TNode> getChildren(){
         return children;
      }
   }
   private TNode root;
   private int size;
   TreeJM(){
      root = null;
      size = 0;
   }
   public TNode createNode(int e, TNode p){
      return new TNode(e, p);
   }
   public TNode addChild(TNode n, int e){
	   TNode temp = createNode(e, n);
      n.children.add(temp);
      size++;
      return temp;
   }
   public TNode addRoot(int e) throws IllegalArgumentException{
      if (root != null) throw new IllegalArgumentException("Root is full");
      root = createNode(e, null);
      size++;
      return root;
   }

   //Part A - #2a
   public void levelOrder(){
      List<TNode> queue = new LinkedList<>();
      //create queue, add root to queue
      queue.add(root); //Add's root to the queue so when the List is called in the other method, it has a starting point
      levelOrderPrint(queue);
      System.out.println();
   }

   //Part A - #2b
   private void levelOrderPrint(List<TNode> l){
      if(l.isEmpty()) return;
      while(l.size() > 0) {
         TNode child = l.get(0); //Gets the FIRST element in the queue
         for(TNode cn: child.getChildren()) { //Add's children at that "child" variable as TNode's and puts them into the queue
            l.add(cn);
         }
         System.out.print(l.get(0).getData() + " ");
         l.remove(0); //Removes elements of queue.
         size--;
      }

   }

   public void preOrder(){
      preOrderPrint(root);
      System.out.println();
   }


   private void preOrderPrint(TNode n){
      if (n == null) return;
      System.out.print(n.getData() + " ");
      for (TNode cn: n.getChildren())
         preOrderPrint(cn);
   }

   public void postOrder(){
       postOrderPrint(root);
       System.out.println();
   }

   //Part A - #3
   private void postOrderPrint(TNode n){
      if(n == null) return;
      for (TNode cn: n.getChildren())
         postOrderPrint(cn);
      System.out.print(n.getData() + " ");

   }
   public boolean isSubTree(TNode tn){
      return true;
   }
   public void makeTree(){
      TNode rt = addRoot(0);
      buildTree(rt, 3);
   }
   public void makeTree2(){
      TNode rt = addRoot(0);
      buildTree(rt, 1);
   }
   public TNode getRoot(){
      return root;
   }
   public int height(){
      if(root == null) return -1;
      return height(root);
   }

   //Part A - #4
   private int height(TNode tn){
      if(tn.getChildren().size() < 0) return 0; //If there are no children then return 0.
      int maxC = 0;
      List <TNode> child = tn.getChildren();
      for(TNode cn: child) {  //goes through ALL of the children and assigns them to cn as individual TNode's because it's iterating through the children.
         int childHeight = height(cn); //each child is checked to see if they have more children through recursion and if so, the iteration continues.
         if(childHeight > maxC) maxC = childHeight; //if the checked child's height is > then the current max, then the checked child is the new max
      }
     
      return maxC + 1;
   }
   private void buildTree(TNode n, int i){
      if (i <= 0) return;
      TNode fc = addChild(n, size);
      TNode sc = addChild(n, size);
      TNode tc = addChild(n, size);
      buildTree(fc, i - 1);
      buildTree(sc, i - 2);
      if (i % 2 == 0)
         buildTree(tc, i - 1);
   }

   public static void main(String[] args){
      TreeJM t = new TreeJM();
      TreeJM t2 = new TreeJM();
      t.makeTree();
      System.out.println("Level: ");
      t.levelOrder();
      System.out.println("Pre: ");
      t.preOrder();
      System.out.println("Post: ");
      t.postOrder();
      //System.out.println("Height: ");
      //System.out.println(t.height());
      TNode subT = t.getRoot().getChildren().get(1);
      t.isSubTree(subT);
      t2.makeTree2();
      System.out.println("Level: ");
      t2.levelOrder();
      System.out.println("Pre: ");
      t2.preOrder();
      System.out.println("Post: ");
      t2.postOrder();
      t2.isSubTree(subT);
      t.isSubTree(t2.getRoot());
   }

}