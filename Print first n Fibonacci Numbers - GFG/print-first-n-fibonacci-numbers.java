//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    //taking total number of elements
		    int n=sc.nextInt();
		    
		    //calling printFibb() method
		    long[] res = new Solution().printFibb(n);
		    
		    //printing the elements of the array
		    for (int i = 0; i < res.length; i++)
		        System.out.print (res[i]+" ");
		    System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) 
    {
        //Your code here
        // Create an array to store the Fibonacci numbers.
        long[] fibonacciNumbers = new long[n];

        // Initialize the first two Fibonacci numbers.
        fibonacciNumbers[0] = 1;
        if (n == 1) {
            // If n is 1, return the array with just the first Fibonacci number.
            return fibonacciNumbers;
        }
        fibonacciNumbers[1] = 1;

        // Generate the remaining Fibonacci numbers.
        for (int i = 2; i < n; ++i) {
            // Calculate the current Fibonacci number by adding the previous two numbers.
            fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
        }

        // Return the array containing the first n Fibonacci numbers.
        return fibonacciNumbers;
    }
}