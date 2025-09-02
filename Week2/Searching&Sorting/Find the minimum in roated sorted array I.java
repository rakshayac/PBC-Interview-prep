class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1; // minimum right sideல இருக்கு
            } else {
                high = mid; // minimum left side including mid
            }
        }
        return nums[low];
    }
}
Dry Run Example

Input: nums = [4,5,6,7,0,1,2]

low=0, high=6 → mid=3 → nums[3]=7 > nums[6]=2 → low=4

low=4, high=6 → mid=5 → nums[5]=1 ≤ nums[6]=2 → high=5

low=4, high=5 → mid=4 → nums[4]=0 ≤ nums[5]=1 → high=4

loop end → low=4 → nums[4]=0 → minimum

Output = 0

Time & Space Complexity

⏳ Time: O(log n)

📦 Space: O(1)
