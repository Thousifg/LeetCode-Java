//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            List<Integer> ans = obj.maxCombinations(n, k, a, b);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find maximum K combinations of elements from arrays A and B
    public static List<Integer> maxCombinations(int N, int K, int[] A, int[] B) {
        // Sort both arrays in ascending order
        Arrays.sort(A);
        Arrays.sort(B);

        // Initialize left and right pointers for binary search
        int left = 0;
        int right = 20000;

        // Perform binary search to find the maximum target sum
        while (left <= right) {
            int mid = (left + right) / 2;
            // Check if the count of combinations with sum >= mid is greater than or equal to K
            if (isCountGreaterThanOrEqualToK(mid, K, A, B)) {
                left = mid + 1; // Adjust left pointer
            } else {
                right = mid - 1; // Adjust right pointer
            }
        }

        // The maximum target sum is left - 1
        int targetSum = left - 1;

        // Initialize a list to store the result
        List<Integer> resultList = new ArrayList<>();

        // Iterate through elements in array A
        for (int a : A) {
            int complement = targetSum - a; // Calculate the complement to reach the target sum
            int bIndex = Arrays.binarySearch(B, complement); // Search for complement in array B
            if (bIndex >= 0) {
                // Complement found, add all possible combinations to the result
                for (int j = bIndex; j < B.length; j++) {
                    resultList.add(B[j] + a);
                }
            } else {
                // Complement not found, calculate the insertion point for complement
                bIndex = -(bIndex + 1);
                // Add all possible combinations to the result
                for (int j = bIndex; j < B.length; j++) {
                    resultList.add(B[j] + a);
                }
            }
        }

        // Sort the result in descending order
        resultList.sort((x, y) -> Integer.compare(y, x));

        // Ensure the result list contains at most K elements
        while (resultList.size() > K) {
            resultList.remove(resultList.size() - 1);
        }

        return resultList; // Return the maximum K combinations
    }

    // Function to check if the count of combinations with sum >= targetSum is greater than or equal to K
    private static boolean isCountGreaterThanOrEqualToK(int targetSum, int K, int[] A, int[] B) {
        int count = 0;
        // Iterate through elements in array A
        for (int a : A) {
            int complement = targetSum - a; // Calculate the complement to reach the target sum
            int bIndex = Arrays.binarySearch(B, complement); // Search for complement in array B
            if (bIndex >= 0) {
                // Complement found, increment the count by the number of remaining elements in array B
                count += B.length - bIndex;
            } else {
                // Complement not found, calculate the insertion point for complement
                bIndex = -(bIndex + 1);
                // Increment the count by the number of remaining elements in array B
                count += B.length - bIndex;
            }
        }
        // Return true if the count is greater than or equal to K, indicating there are enough combinations
        return count >= K;
    }
}

