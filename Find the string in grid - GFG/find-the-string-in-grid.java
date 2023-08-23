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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[][] searchWord(char[][] grid, String targetWord)
    {
        // Code here
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] result = new int[0][0];
        
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == targetWord.charAt(0)) {
                    for (int dir = 0; dir < 8; ++dir) {
                        int x = i, y = j;
                        int k;
                        for (k = 0; k < targetWord.length(); ++k) {
                            if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] != targetWord.charAt(k)) {
                                break;
                            }
                            x += dx[dir];
                            y += dy[dir];
                        }
                        if (k == targetWord.length()) {
                            // Found the word, update the result
                            int[][] newResult = new int[result.length + 1][2];
                            for (int idx = 0; idx < result.length; ++idx) {
                                newResult[idx] = result[idx];
                            }
                            newResult[result.length] = new int[] { i, j };
                            result = newResult;
                            break;
                        }
                    }
                }
            }
        }
        
        return result;
    }
}