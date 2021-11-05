// SquidyP
//COS-111-OL009
// BinarySearch

/* 1. Modify the “BinarySearch” program given in the textbook (program 4.2.3)
so that if the search key is in the array, it returns the largest index i for
which a[i] is equal to key, but, otherwise, returns –i where i is the largest
index such that a[i] is less than key. It should also be modified to deal with
integer arrays rather than string arrays. [MO5.2, MO5.3]

Note: The program should take two command-line arguments, (1) an input file that
contains a sorted integer array; and (2) an integer to search for in that array.

Sample runs would be as follows.

>more input.txt
2 3 4 5 6 6 6 7 8 9 11

>java BinarySearch input.txt 10
-9

>java BinarySearch input.txt 6
6
*/
import java.io.File;
import java.util.Scanner;

public class BinarySearch{ //start of class
  public static int search(String key, int[] a){//start of function
    return search(key, a, 0, a.length);
  }// end of function

  public static int search(String key, int[] a, int lo, int hi){//start of function
    //Search for a key in a[lo, hi).
    if(hi <= lo) return -1;
    int mid = lo + (hi - lo) / 2;
    int intKey = Integer.parseInt(key); // converts key to int for comparison
    int cmp = 0; // variable to hold comparison
    // following ifs slip the array and compare looking for the key
    if(a[mid] > intKey){cmp = 1;} 
    if(a[mid] < intKey){cmp = -1;}
    if(a[mid] == intKey){cmp = 0;}
    if (cmp > 0) return search(key, a, lo, mid);
    else if (cmp < 0) return search(key, a, mid+1, hi);
    else return mid;// returns 0 if key is found and -1 if not found
  }//end of function

  public static void main(String[] args) throws java.io.FileNotFoundException {//start of main
    //Print keys from standard input that do not appear in file args[0].
    File in = new File(args[0]);
    Scanner scan = new Scanner(in);
    int size = 0;
    while(scan.hasNextInt()){ //start of size while loop
      size ++;
      scan.nextInt();
    } // end of size while loop
    int[] a = new int[size];
    Scanner scan2 = new Scanner(in); // second scanner -because I don't know how to use the same scanner twice
    for(int i= 0; i < a.length; i++){//start of for loop
      a[i]=scan2.nextInt(); // scans the file into the array
    }//end of for loop
      int largestIndex = 0; //variable to hold largest index
      String key = args[1];
      int b = Integer.parseInt(key); // convert key from string to int
      if(search(key, a) == -1){ // passes key and array to "search" function
        // iterate over array to find largest index
        for(int j = 0; j < a.length; j++){
          if(a[j] < b) largestIndex = a[j];
        }
        System.out.println("-"+largestIndex);
      } else System.out.println(key);

  }//end of main
}// end of class
