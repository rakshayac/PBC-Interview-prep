1.Naive Approach
For each element, count its frequency using a nested loop.
If any count > n/2, return that element.
Time: O(n²), Space: O(1).
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) count++;
            }
            if (count > n / 2) return nums[i];
        }
        return -1; // never happens because problem guarantees a majority
    }
}
2. Better Approach (HashMap)
Use a HashMap to store frequencies.
Traverse and find element with count > n/2.
Time: O(n), Space: O(n).
👉 Java code:
import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) return num;
        }
        return -1;
    }
}

Optimal Approach (Boyer–Moore Voting Algorithm)

Maintain a candidate and a count.

Traverse array:

If count = 0 → set candidate = current element.

If current = candidate → count++.

Else → count--.

At the end, candidate is the majority element.

Time: O(n), Space: O(1).

👉 Java code:

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}

4. Edge Cases
Majority element always exists (per problem statement).
If input is [3,3,4] → 3 is majority.
If input is [2,2,1,1,1,2,2] → 2 is majority.