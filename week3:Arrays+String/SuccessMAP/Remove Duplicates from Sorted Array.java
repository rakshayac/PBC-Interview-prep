Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).


Two Pointers Approach
Intuition:
In a sorted array, duplicates occur consecutively. To remove duplicates, 
we can maintain two pointers - one (i) to track the location for the next unique element, 
and another (j) to traverse through the array checking for duplicates. For each unique element found, 
we place it at the i-th index and increment i. This ensures that all unique elements are moved to the front of the array, 
while any remaining elements beyond the
 i-th position are irrelevant as they are duplicates or unevaluated.

 public class Solution {
    public int removeDuplicates(int[] nums) {
        // Check if the array is empty. If it is, return 0 as there are no elements to process.
        if (nums.length == 0) return 0;

        // Initialize i to point to the index where we should place the next unique element.
        int i = 0; 

        // Iterate through the array starting from the first element.
        for (int j = 1; j < nums.length; j++) {
            // Check if the current element nums[j] is different from nums[i].
            // If so, it indicates a new unique element.
            if (nums[j] != nums[i]) {
                // Increment i to reserve the next position for the new unique element.
                i++;
                // Place the new unique element found at nums[j] into the position at nums[i].
                nums[i] = nums[j];
            }
        }
        // Return the length of the array containing unique elements,
        // this is i + 1 because i is the index of the last unique element found.
        return i + 1;
    }
}

Complexity Analysis:
Time Complexity: O(n), where n is the number of elements in the array. We traverse the array with a single pass using the two pointers.
Space Complexity: O(1), as we are using extra space only for the pointers and directly modifying the input array.