// Given an array of integers, return indices of the two numbers such that they add up to 
// a specific target. You may assume that each input would have exactly one solution.


public class TwoSum 
{
    public int[] twoSum(int[] nums, int target) 
    {
        // create a hashmap for examined values
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] result = new int[2];
        
        // loop through the array
        for (int i = 0; i < nums.length; i++)
        {
            // found a solution
            if (map.containsKey(nums[i]))
            {
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            }
            // put the examined value in hashmap
            else
                map.put(target - nums[i], i);
        }
        
        // guaranteed found a result
        return result;
        
    }
}
