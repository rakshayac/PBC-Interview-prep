Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.
Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
class Solution {
    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }
    private void helper(char[] s, int left, int right) {
        if (left >= right) return;  // base case
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        helper(s, left + 1, right - 1);  // recursive step
    }//recurision ,two pointer, inplaced
}//Optimal recursion → swap in-place → O(n), O(1) extra space (but O(n) recursion stack)$
. Optimal Approach (Two-Pointer Swap) ✅
👉 Use two pointers (left, right) and swap until they meet.
TC = O(n)
SC = O(1) (in-place)

class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
. Better Approach (Use Stack)
👉 Push all characters into a stack, then pop back.
TC = O(n)
SC = O(n)
import java.util.Stack;
class Solution {
    public void reverseString(char[] s) {
        Stack<Character> st = new Stack<>();
        for (char c : s) {
            st.push(c);            // push all
        }
        for (int i = 0; i < s.length; i++) {
            s[i] = st.pop();       // pop back
        }
    }
}