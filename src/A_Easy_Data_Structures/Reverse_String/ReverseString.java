package z_questions;

public class ReverseString_LC_Easy {
    /*
    344. Reverse String
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.



Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]



Constraints:

    1 <= s.getLength <= 105
    s[i] is a printable ascii character.
     */

    public void reverseString(char[] s) {
        for (int i = 0, j = s.length-1; i < s.length/2; i++, j--) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
        }
    }


}
