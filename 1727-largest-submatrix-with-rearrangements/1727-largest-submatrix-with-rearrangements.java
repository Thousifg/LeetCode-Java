import java.util.Arrays;

public class Solution {
    // Function to find the largest submatrix with all 1's
    public int largestSubmatrix(int[][] matrix) {
        // Get the number of rows and columns in the matrix
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Step 1: Update matrix values to represent the height of consecutive 1's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the current cell is 1, update its value based on the previous row
                matrix[i][j] = (matrix[i][j] == 1) ? (i == 0 ? 1 : matrix[i - 1][j] + 1) : 0;
            }
        }
        
        int maxArea = 0; // Variable to store the maximum submatrix area
        
        // Step 2: Iterate through each row and calculate the maximum rectangle area
        for (int i = 0; i < rows; i++) {
            // Sort the current row in ascending order
            Arrays.sort(matrix[i]);
            
            // Calculate the maximum rectangle area for the current row
            maxArea = Math.max(maxArea, maxRectangleArea(matrix[i]));
        }   
        
        return maxArea; // Return the overall maximum submatrix area
    }
    
    // Helper function to calculate the maximum rectangle area for a given histogram
    private int maxRectangleArea(int heights[]) {
        int maxArea = 0; // Variable to store the maximum rectangle area
        
        // Iterate through each position in the histogram
        for (int pos = 0; pos < heights.length; pos++) {
            // Calculate the area for the current position and update maxArea if needed
            maxArea = Math.max(maxArea, heights[pos] * (heights.length - pos));
        }
        
        return maxArea; // Return the maximum rectangle area for the given histogram
    }
}
