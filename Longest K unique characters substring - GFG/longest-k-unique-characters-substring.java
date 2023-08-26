//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
         HashMap<Character, Integer> charCount = new HashMap<>();
        int start = 0, end = 0, uniqueChars = 0, maxLength = -1;

        for (end = 0; end < s.length(); ++end) {
            char currentChar = s.charAt(end);
            
            if (!charCount.containsKey(currentChar) || charCount.get(currentChar) == 0)
                ++uniqueChars;

            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);

            while (uniqueChars > k && start <= end) {
                char startChar = s.charAt(start);
                charCount.put(startChar, charCount.get(startChar) - 1);
                if (charCount.get(startChar) == 0)
                    --uniqueChars;
                ++start;
            }

            if (uniqueChars == k)
                maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}