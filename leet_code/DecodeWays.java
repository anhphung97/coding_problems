// A message containing letters from A-Z is being encoded to numbers using the following mapping:
// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.

// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
// The number of ways decoding "12" is 2.

public class DecodeWays 
{
    public int numDecodings(String s) 
    {
        // smaller cases
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
        {
            if (s.equals("0"))
                return 0;
            else
                return 1;
        }

        // use dynamic programming
        // cached the result, result[i] is the number of ways to decode 
        // substring from 0 to (i-1)th character
        int[] result = new int[s.length()+1];
        
        // initial value
        result[0] = 1;
        if (s.charAt(0) == '0')
            return 0;
        else
            result[1] = 1;
            
        // update values accordingly
        for (int i = 1; i < s.length(); i++)
        {
            int lastTwo = Integer.parseInt(s.substring(i-1,i+1));
            
            // current digit is zero
            if (s.charAt(i) == '0')
            {
                // no encodings found
                if (s.charAt(i-1) > '2' || s.charAt(i-1) == '0')
                    return 0;
                // one possible encoding using the last two digits
                else
                    result[i+1] = result[i-1];
            }
            // last two digits form a number between 10 and 26
            // so we can use that or the last digit to encode
            else if (lastTwo <= 26 && lastTwo >= 10)
                result[i+1] = result[i] + result[i-1];
            // can only use the last digit to encode
            else
                result[i+1] = result[i];
        }
        
        // return result for input string
        return result[s.length()];
    }
}
