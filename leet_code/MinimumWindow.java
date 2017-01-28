// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".
// Note:
// If there is no such window in S that covers all characters in T, return the empty string "".
// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.


public class MinimumWindow 
{
    public String minWindow(String s, String t) 
    {
        // hash map for each ascii character
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < 128; i++)
            map.put((char) i, 0);
            
        // change the occurrences of characters in t
        for (int i = 0; i < t.length(); i++)
        {
            char c = t.charAt(i);
            map.put(c, map.get(c) + 1);
        }
        
        // the idea is to use two pointers to find a valid substring, and then move the left pointer 
        // to minimize the length
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int done = t.length();
        
        // while we can still move the right pointers 
        while (right < s.length())
        {
            char c = s.charAt(right);
            // find a character in t
            if (map.containsKey(c) && map.get(c) > 0)
                done --;
            
            // move the right pointer
            map.put(c, map.get(c) - 1);
            right ++;

            // found a valid substring
            while (done == 0)
            {
                // update the min
                if (right - left < min)
                {
                    start = left;
                    min = right - left;
                }
                
                // move the left pointer until the substring is no longer valid
                char d = s.charAt(left);
                if (map.containsKey(d) && map.get(d) == 0)
                    done ++;
                
                // invalidate the substring, and continue moving the right pointer
                map.put(d, map.get(d) + 1);
                left ++;
            }
        }
        
        // return the result
        return min == Integer.MIN_VALUE ? "" : s.substring(start,start + min);
    }
}
