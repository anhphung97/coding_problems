// Given two binary strings, return their sum (also a binary string).
// For example,
// a = "11"
// b = "1"
// Return "100".


public class AddBinary 
{
    public String addBinary(String a, String b) 
    {
        // consider the case that a is longer than b only
        if (b.length() > a.length())
            return addBinary(b,a);
        
        // we will add digit by digit from right to left, so reverse for easier calculation
        StringBuilder result = new StringBuilder();
        StringBuilder a1 = new StringBuilder(a);
        a1 = a1.reverse();
        StringBuilder b1 = new StringBuilder(b);
        b1 = b1.reverse();
        int adder = 0;
        
        // add digit by digit of b1 first
        for (int i = 0; i < b1.length(); i++)
        {
            // result of addition
            int res = Integer.parseInt(a1.substring(i,i+1)) + Integer.parseInt(b1.substring(i,i+1)) + adder;
            
            // result is large, we have to reserve 1 more for the next calculation
            if (res > 1)
            {
                adder = 1;
                result.append(Integer.toString(res-2));
            }
            // result is fine, keep going
            else
            {
                adder = 0;
                result.append(Integer.toString(res));
            }
        }
        
        // do it with the rest of digits of a1
        for (int i = b1.length(); i < a1.length(); i++)
        {
            // result of addition
            int res = Integer.parseInt(a1.substring(i,i+1)) + adder;
            
            // result is large, we have to reserve 1 more for the next calculation
            if (res > 1)
            {
                adder = 1;
                result.append(Integer.toString(res-2));
            }
            // result is fine, keep going
            else
            {
                adder = 0;
                result.append(Integer.toString(res));
            }
        }
        
        // still need to add 1 more
        if (adder == 1)
            result.append("1");
        
        
        // reverse and return the result
        result = result.reverse();
        return result.toString();   
    }
}
