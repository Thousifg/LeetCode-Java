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
    public static List<Integer> maxCombinations(int N, int K, int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int left = 0;
        int right = 20000;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isCountGreaterThanOrEqualToK(mid, K, A, B)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int targetSum = left - 1;

        List<Integer> resultList = new ArrayList<>();
        for (int a : A) {
            int complement = targetSum - a;
            int bIndex = Arrays.binarySearch(B, complement);
            if (bIndex >= 0) {
                for (int j = bIndex; j < B.length; j++) {
                    resultList.add(B[j] + a);
                }
            } else {
                bIndex = -(bIndex + 1);
                for (int j = bIndex; j < B.length; j++) {
                    resultList.add(B[j] + a);
                }
            }
        }

        resultList.sort((x, y) -> Integer.compare(y, x));
        while (resultList.size() > K) {
            resultList.remove(resultList.size() - 1);
        }

        return resultList;
    }

    private static boolean isCountGreaterThanOrEqualToK(int targetSum, int K, int[] A, int[] B) {
        int count = 0;
        for (int a : A) {
            int complement = targetSum - a;
            int bIndex = Arrays.binarySearch(B, complement);
            if (bIndex >= 0) {
                count += B.length - bIndex;
            } else {
                bIndex = -(bIndex + 1);
                count += B.length - bIndex;
            }
        }
        return count >= K;
    }
}
