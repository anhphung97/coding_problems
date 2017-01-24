// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
// Find all unique triplets in the array which gives the sum of zero.
// Note: The solution set must not contain duplicate triplets.


public class 3Sum
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        // sort the array
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        
        // fix the first element
        for (int i = 0; i < nums.length - 2; i++)
        {
            // repeated elements
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            
            // two pointers
            int left = i+1; 
            int right = nums.length - 1;
            
            // move the pointers accordingly
            while (left < right)
            {
                // current sum
                int sum = nums[i] + nums[left] + nums[right];
                
                // sum is zero
                if (sum == 0)
                {
                    // found a solution
                    List<Integer> list = new LinkedList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    
                    // move left pointer past repeated element
                    left ++;
                    while (left < nums.length && nums[left] == nums[left-1])
                        left ++;
                    
                    // move right pointer past repeated element
                    right --;
                    while (right > i + 1 && nums[right] == nums[right+1])
                        right --;
                }
                // sum too small
                else if (sum < 0)
                {
                    // move left pointer past repeated element
                    left ++;
                    while (left < nums.length && nums[left] == nums[left-1])
                        left ++;
                }
                // sum too large
                else
                {
                    // move right pointer past repeated element
                    right --;
                    while (right > i + 1 && nums[right] == nums[right+1])
                        right --;
                }
            }
            
        }
        
        return result;
    }
}
