/*
 * Student: James Mancuso
 * Class: CS313 - section 37 - T/Th 5:00pm - 6:15pm
 * Assignment #4 - Part A #4
 * Due: Tuesday, December 10th
 */

 public class mergeSortJM {
    public static void mergeSort(int[] a, int l, int h){
        if (l >= h) return;
        int mid = (h + l) / 2;
        mergeSort(a, l, mid); 
        mergeSort(a, mid + 1, h);
        merge(a, l, mid + 1, h); 
     }

    public static void merge(int [] a, int low, int mid, int high) {
       
        int [] unsortA = new int[a.length];

        //Index's for both the left and right half's of the array
        int left = low, right = mid, it = low;
        
        //Take an unsorted array and directly sorted into user inputted array
        for(int i = low; i <= high; i++) unsortA[i] = a[i];

        // traverse both arrays and in each iteration add smaller of both elements in temp 
        while(it <= high) {
            //All of the left side already ordered, just add the remaining RIGHT unordered values
            if(left > mid - 1) {
                a[it] = unsortA[right];
                right++;
            }
            //All of the right side already ordered, just add the remaining LEFT unordered values
            else if (right > high) {
                a[it] = unsortA[left];
                left++;
            }
            //If left side value is less than right side
            else if (unsortA[left] < unsortA[right]) {
                a[it] = unsortA[left];
                left++;
            }
            //If right side value is less than left side
            else {
                a[it] = unsortA[right];
                right++;
            }
            it++;
        } 
    }
    public static void main(String[] args){
        int[] a = {3,2,7,5,1,6,4,8,9};
        System.out.println("mergeSort a: ");
        long time, nextTime;
        time = System.nanoTime();
        mergeSort(a, 0, a.length - 1);
        nextTime = System.nanoTime();
        System.out.println("\tTime used: " + (nextTime - time) + " nseconds");
        for (int i = 0; i < a.length; i++) System.out.print(a[i] + ",");
        System.out.println();
     }
}

