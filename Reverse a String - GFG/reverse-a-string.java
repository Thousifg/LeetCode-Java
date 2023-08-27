//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- >0)
        {
            String str = read.readLine();
            System.out.println(new Reverse().reverseWord(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        // Convert the input string to a character array for easier manipulation
        char[] charArray = str.toCharArray();
        
        // Initialize two pointers, one at the beginning and one at the end of the charArray
        int left = 0;
        int right = charArray.length - 1;
        
        // Swap characters from both ends towards the center
        while (left < right) {
            // Swap characters at left and right pointers
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            
            // Move the pointers towards the center
            left++;
            right--;
        }
        
        // Convert the reversed character array back to a string and return
        return new String(charArray);
    }
}