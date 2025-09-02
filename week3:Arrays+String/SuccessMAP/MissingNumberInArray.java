Input: arr[] = [1, 2, 3, 5]
Output: 4
Explanation: All the numbers from 1 to 5 are present except 4.
Input: arr[] = [8, 2, 4, 5, 3, 7, 1]
Output: 6
Explanation: All the numbers from 1 to 8 are present except 6.
Input: arr[] = [1]
Output: 2
Explanation: Only 1 is present so the missing element is 2.

class Solution {
    int missingNum(int arr[]) {
        int n = arr.length + 1; // because one number is missing
        int total = (n * (n + 1)) / 2; // sum of 1..n

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return total - sum; // missing number
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 4, 5};  // Missing 3
        System.out.println(sol.missingNum(arr)); // Output: 3
    }
}
Dry Run with arr = [1, 2, 4, 5]

n = arr.length + 1 = 5

total = (5*6)/2 = 15

sum = 1+2+4+5 = 12

missing = 15 - 12 = 3 ✅

class Solution {
    int missingNum(int arr[]) {
        int n = arr.length + 1; 
        int xor = 0;

        // Step 1: XOR all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        // Step 2: XOR with all elements of array
        for (int num : arr) {
            xor ^= num;
        }

        // Final answer = missing number
        return xor;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 4, 5};
        System.out.println(sol.missingNum(arr)); // Output: 3
    }
}
📝 Step-by-step Dry Run
Step 1: XOR from 1 to n

Here n = arr.length + 1 = 5

So compute:

xor = 1 ^ 2 ^ 3 ^ 4 ^ 5


Let’s simplify:

1 ^ 2 = 3

3 ^ 3 = 0

0 ^ 4 = 4

4 ^ 5 = 1

So after this loop → xor = 1

Step 2: XOR with array elements [1, 2, 4, 5]

Now do:

xor = 1 ^ 1 ^ 2 ^ 4 ^ 5


1 ^ 1 = 0

0 ^ 2 = 2

2 ^ 4 = 6

6 ^ 5 = 3

So final xor = 3

✅ Answer

The missing number = 3

🌟 Why it works?

XOR has two key properties:

a ^ a = 0

a ^ 0 = a

If we XOR all numbers 1..n and XOR with all numbers in the array, 
all present numbers cancel out, leaving only the missing one.

If you mean bitwise XOR (Java’s ^):
6 ^ 5 = 3 because
6 = 110₂, 5 = 101₂, 110 ^ 101 = 011₂ = 3.