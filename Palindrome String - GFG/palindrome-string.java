//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S) {
        // code here
        
        // Here is the two-pointer approach and it is preferred for its efficiency and 
        // memory-friendly nature when checking for palindromes in a string.

        int i = 0, j = S.length() - 1;
        int ans = 1;
        while (i < j) {
            if (S.charAt(i) != S.charAt(j)) {
                ans = 0;
                break;
            }
            i++;
            j--;
        }
        return ans;
        
        
        
        // we can do in this method too
        // here  using the StringBuilder approach
        
        // String b = S;
        // StringBuilder reversed = new StringBuilder(S);
        // reversed.reverse();
        // return reversed.toString().equals(b) ? 1 : 0;
        
    }
};