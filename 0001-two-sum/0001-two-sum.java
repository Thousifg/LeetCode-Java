class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        for(int i = 0; i < nums.length; i++)
        {
            int num1 = nums[i];

            for(int j = i + 1; j < nums.length; j++)
            {
                int num2 = nums[j];

                int sum = num1 + num2;

                if(sum == target)
                {
                    return new int[] {i , j };
                }
            }
        }
        return null;
    }
}