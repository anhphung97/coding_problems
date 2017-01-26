// Given a digit string, return all possible letter combinations that the number could represent.
// A mapping of digit to letters (just like on the telephone buttons) is given below.
// Input: Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


public class LetterCombinationPhone 
{
    public List<String> letterCombinations(String digits) 
    {
        // use backtracking technique, similar to subset problems
        List<String> result = new LinkedList<String>();
        if (digits.length() == 0)
            return result;
            
        char[] digit = digits.toCharArray();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(result, digit, 0, mapping);
        
        // return result
        return result;
    }
    
    public void backtrack(List<String> result, char[] digits, int current, String[] mapping)
    {
        // we have transformed all digits
        if (current == digits.length)
        {
            result.add(new String(digits));
            return;
        }
        
        // current digit to transform
        int value = Integer.parseInt(Character.toString(digits[current]));
        
        // invalid digit
        if (value < 2)
            return;
        else 
        {
            // try a possible mapping then backtrack
            char old = digits[current];
            for (int i = 0; i < mapping[value].length(); i++)
            {
                digits[current] = mapping[value].charAt(i);
                backtrack(result, digits, current + 1, mapping);
                digits[current] = old;
            }
        }
        
    }
}
