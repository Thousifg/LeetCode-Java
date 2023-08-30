class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long operations = 0;

        // Initialize the previous element with the last element of the array
        int previousElement = nums[n - 1];

        // Traverse the array from the second-to-last element to the first element
        for (int i = n - 2; i >= 0; i--) {
            
            // Check if the current element is greater than the previous element
            if (nums[i] > previousElement) {
                
                // Calculate how many times the current element is greater than the previous element
                int factor = (int) Math.ceil(nums[i] / (double) previousElement);

                // Add the required operations to the total
                operations += factor - 1;

                // Update the previous element based on the factor
                previousElement = nums[i] / factor;
            } else {
                
                // If the current element is not greater, update the previous element
                previousElement = nums[i];
            }
        }
        
        // Return the total operations needed
        return operations;
    }
}