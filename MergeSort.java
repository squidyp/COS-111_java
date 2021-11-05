//SquidyP
//COS-111-OL009
//MergeSort

/* 2. Modify the MergeSort program given in the textbook (program 4.2.6) to
support searching subarrays. [MO5.2, MO5.3]

Note: The user would give an unsorted list of words as command-line arguments
along with the starting and ending index of the subarray that should be sorted.
The program should print out a list where the strings between the given indexes
are sorted alphabetically.

Sample runs would be as follows.

>java MergeSort 2 4 toy apply sand bay cat dog fish
toy apply bay cat sand dog fish

>java MergeSort 0 3 was had him and you his the but
and had him was you his the but
*/

import java.util.Scanner;

public class MergeSort{ //start of class
  public static void sort(Comparable[] a){ //start of function
    Comparable[] aux =new Comparable[a.length];
    sort(a, aux, 0, a.length);
  } //end of function

  private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){ //start of private function
    // Sort a[lo, hi).
    if(hi - lo <= 1) return;
    int mid = lo +(hi-lo)/2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid, hi);
    int i = lo, j = mid;
    for(int k = lo; k < hi; k++)
      if (i==mid) aux[k] = a[j++];
      else if (j == hi) aux[k] = a[i++];
      else if (a[j].compareTo(a[i]) < 0) aux[k] = a[j++];
      else aux[k] = a[i++];
    for (int k = lo; k < hi; k++)
      a[k] = aux[k];
  } //end of private function

  public static void main(String[] args) throws java.io.FileNotFoundException{ //start of main
    //Read strings from standard input, sort them, and print.
    int startIndex = Integer.parseInt(args[0]); //variable for starting index
    int endIndex = Integer.parseInt(args[1]); //variable for ending index

    // initiate size of string array
    int size = 1;
    int l = startIndex;
    do{ size ++; l ++; } while(l != endIndex);
    String[] allTheStrings = new String[args.length-2]; //array of args strings
    String[] a = new String[size]; // string array to be sorted

    //all of the string arguments in one array
    for(int m = 0; m < allTheStrings.length; m++){
      allTheStrings[m] = args[m+2];
    }

    // populates array to be sorted
    for(int n = 0; n < a.length; n++){
      a[n] = allTheStrings[startIndex];
      startIndex++;
    }

    startIndex = Integer.parseInt(args[0]); //re-initize starting index
    String[] leftOversF = new String[startIndex]; //sets the size of arrays of what string are leftover
    String[] leftOversB = new String[(allTheStrings.length-endIndex)-1]; //sets the size of arrays of what string are leftover

    //prints string not use before starting index
    for(int i = 0; i < leftOversF.length; i++){
      if(a[i] != allTheStrings[i]) leftOversF[i] = allTheStrings[i];
      System.out.print(leftOversF[i]+" ");
    }
    // sort strings alphabetically
    sort(a);
    for(int i = 0; i < a.length; i++)
      System.out.print(a[i]+" ");

      //prints string not used in after ending index
    for(int i = 0; i < leftOversB.length; i++){
      leftOversB[i]=allTheStrings[i+endIndex+1];
      System.out.println(leftOversB[i]+ " ");
    }

      System.out.println();
  } //end of main
} //end of class
