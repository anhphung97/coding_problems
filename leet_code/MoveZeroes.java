// Given an array nums, write a function to move all 0's to the end of it 
// while maintaining the relative order of the non-zero elements.

public class MoveZeroes 
{
    public void moveZeroes(int[] nums) 
    {
        // two pointers
        int leftZero = 0;
        int current = 0;
        
        // move the two pointers
        for (int i = 0; i < nums.length; i++)
        {
            // move the non-zero to the leftmost zero
            if (nums[current] != 0)
            {
                if (current != leftZero)
                {
                    int temp = nums[current];
                    nums[current] = nums[leftZero];
                    nums[lastZero] = temp;
                }
                leftZero ++;
            }
            current ++;
        }
    }
}
