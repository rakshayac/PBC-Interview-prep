1. Naive Approach
Create a new array.
Copy all non-zero elements in order.
Fill the rest with zeroes.
Return the new array.
Time: O(n), Space: O(n).
class Solution {
    public void moveZeroes(int[] nums) {
        int[] temp = new int[nums.length];
        int index = 0;
        
        for (int num : nums) {
            if (num != 0) {
                temp[index++] = num;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}
Optimal Approach (Two-Pointer / Sliding Window Style)

Use two pointers:
j → position for the next non-zero.
Iterate i through array:
If nums[i] != 0, swap nums[i] with nums[j] and increment j.
This keeps all non-zeros in order and pushes zeroes to the end.
Time: O(n), Space: O(1).

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0; // pointer for non-zero placement
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
