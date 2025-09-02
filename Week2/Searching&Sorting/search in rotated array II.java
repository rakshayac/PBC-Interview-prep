class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) return true;

            // Duplicate case
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            }
            // Left half sorted
            else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
nput: nums = [2,5,6,0,0,1,2], target = 3

low=0, high=6 → mid=3 → nums[3]=0 ≠ 3

left half sorted (nums[0]=2 ≤ nums[3]=0 ❌) → right half sorted

nums[3]=0 < 3 ≤ nums[6]=2 ❌ → go left

low=0, high=2 → mid=1 → nums[1]=5 ≠ 3

left half sorted → nums[0]=2 ≤ 3 < nums[1]=5 ✅ → go left

low=0, high=0 → mid=0 → nums[0]=2 ≠ 3 → loop end → return false