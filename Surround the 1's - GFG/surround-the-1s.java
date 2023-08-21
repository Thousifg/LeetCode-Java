//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] matrix)
    {
        // code here
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int evenSurroundedCount = 0;

        int[] dx = {1, 0, 0, -1, 1, 1, -1, -1};
        int[] dy = {0, 1, -1, 0, 1, -1, -1, 1};

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                int surroundedByZeroCount = 0;
                if (matrix[row][col] == 0) continue;
                for (int k = 0; k < 8; k++) {
                    int newRow = dx[k] + row;
                    int newCol = dy[k] + col;
                    if (newRow >= 0 && newRow < rowCount && newCol >= 0 && newCol < colCount &&
                        matrix[newRow][newCol] == 0) {
                        surroundedByZeroCount++;
                    }
                }
                if (surroundedByZeroCount % 2 == 0 && surroundedByZeroCount > 0) {
                    evenSurroundedCount++;
                }
            }
        }
        return evenSurroundedCount;
    }
}