class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;

            // Left half sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // target left-ல இருக்கு
                } else {
                    low = mid + 1; // target right-ல
                }
            }
            // Right half sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1; // target right-ல இருக்கு
                } else {
                    high = mid - 1; // target left-ல
                }
            }
        }
        return -1;
    }
}

