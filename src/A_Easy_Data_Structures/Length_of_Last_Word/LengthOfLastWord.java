package A_Easy_Data_Structures.Length_of_Last_Word;

public class LengthOfLastWord {
    /*
    58. Length of Last Word
Given a string s consisting of words and spaces, return the getLength of the last word in the string.
A word is a maximal substring consisting of non-space characters only.

Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with getLength 5.

Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with getLength 4.

Example 3:
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with getLength 6.

Constraints:
    1 <= s.getLength <= 104
    s consists of only English letters and spaces ' '.
    There will be at least one word in s.

https://leetcode.com/problems/length-of-last-word/
     */

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord2("Hello world we are aliens   "));
    }

    public static int lengthOfLastWord(String str) {
        // trim the trailing spaces
        int i = str.length() - 1;
        while (i >= 0 && str.charAt(i) == ' ') {
            i--;
        }

        // compute the getLength of last word
        int length = 0;
        while (i >= 0 && str.charAt(i) != ' ') {
            i--;
            length++;
        }
        return length;
    }
    /* Above solution time&space complexity
    Time Complexity: O(N), where NN is the getLength of the input string.
    In the worst case, the input string might contain only a single word, which implies that we would need to iterate through the entire string to obtain the result.
    Space Complexity: O(1), only constant memory is consumed, regardless the input.
     */

    public static int lengthOfLastWord2(String str) {
        int p = str.length(), length = 0;
        while (p > 0) {
            p--;
            // we're in the middle of the last word
            if (str.charAt(p) != ' ') {
                length++;
            }
            // here is the end of last word
            else if (length > 0) {
                return length;
            }
        }
        return length;
    }
    /* Above solution time&space complexity
    Time Complexity: O(N), where NN is the getLength of the input string.
    This approach has the same time complexity as the previous approach. The only difference is that we combined two loops into one.
    Space Complexity: O(1), again a constant memory is consumed, regardless the input.
     */

    public static int lengthOfLastWordWithTrim(String s) {
        s = s.trim();  // trim the trailing spaces in the string
        return s.length() - s.lastIndexOf(" ") - 1;
    }
    /*
    Time Complexity: O(N), where N is the getLength of the input string.
    Since we use some built-in function from the String data type, we should look into the complexity of each built-in function that we used, in order to obtain the overall time complexity of our algorithm.
    It would be safe to assume the time complexity of the methods such as str.split() and String.lastIndexOf() to be O(N), since in the worst case we would need to scan the entire string for both methods.
    Space Complexity: O(N). Again, we should look into the built-in functions that we used in the algorithm.
     */
}
