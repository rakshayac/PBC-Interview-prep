class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1; 
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                high--; // duplicate case
            }
        }
        return nums[low];
    }
}
Dry Run Example

Input: nums = [2,2,2,0,1]

low=0, high=4 → mid=2 → nums[2]=2 > nums[4]=1 → low=3

low=3, high=4 → mid=3 → nums[3]=0 < nums[4]=1 → high=3

loop end → low=3 → nums[3]=0 → minimum

Output = 0

Time & Space Complexity

⏳ Time: O(log n) (worst case duplicates அதிகமா இருந்தா → O(n))

📦 Space: O(1)
