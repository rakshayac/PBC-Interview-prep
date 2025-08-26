Binary Search Week Schedule (7 Days)

📅 Day 1 – Basics (7 Qs)
    
1. Binary Search (Basic)
class BinarySearchBasic {
    public static int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // safe mid
            
            if (arr[mid] == target) {
                return mid; 
            } else if (arr[mid] < target) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 8, 10};
        int target = 6;
        System.out.println(search(arr, target)); // Output: 3
    }
}


2.Lower Bound
class LowerBound {
    public static int lowerBound(int[] arr, int target) {
        int low = 0;                  
        int high = arr.length - 1;    
        int ans = arr.length;   // 👈 initially answer array end ஆக வைத்துக்கிறோம்

        // 👇 Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2; // safe mid calculation
            
            // 👇 arr[mid] >= target என்றால் இந்த index valid candidate
            // ஆனா first occurrence தேவை → so high = mid-1 போறோம்
            if (arr[mid] >= target) {
                ans = mid;       // possible answer save பண்ணிக்கலாம்
                high = mid - 1;  // left sideல இன்னும் இருக்கா check பண்ணுவோம்
            } 
            // 👇 arr[mid] < target என்றால் target right sideல இருக்கும்
            else {
                low = mid + 1;
            }
        }
        
        return ans; // 👈 target கிடைக்கலானாலும் next greater element index கிடைக்கும்
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        int target = 5;
        System.out.println(lowerBound(arr, target)); // Output: 2
    }
}
📊 Example

arr = [2, 4, 6, 8, 10]
target = 5
👉 Lower Bound = 2 (because arr[2] = 6 → 5க்கு மேல் வரும் first element)

🔎 Step by Step (Tamil Dry Run)
low = 0, high = 4, ans = n (default n=5, because answer இல்லனா array end)

1st mid = (0+4)//2 = 2 → arr[2] = 6 → இது 5க்கு மேல் தான் → ans=2, high=1

Next mid = (0+1)//2 = 0 → arr[0] = 2 → இது 5க்கு குறைவு → so low=1

Next mid = (1+1)//2 = 1 → arr[1] = 4 → இது 5க்கு குறைவு → so low=2

இப்போ loop முடிஞ்சது → ans=2 → return 2

3.Upper Bound

Floor of a Number

Ceil of a Number

First and Last Occurrence of Element

Count of Element in Sorted Array

📅 Day 2 – Rotated & Special Search (6 Qs)
Search in Rotated Sorted Array – I

Search in Rotated Sorted Array – II (duplicates)

Find Minimum in Rotated Sorted Array

Find Peak Element (1D)

Find Square Root (integer)

Single Element in Sorted Array

📅 Day 3 – Infinite & 2D (4 Qs)
Find in Infinite Sorted Array

Find Index of First 1 in Infinite Binary Array

Search in 2D Matrix (Leetcode 74)

Find Nth Root of a Number

📅 Day 4 – Allocation Type (6 Qs)
Find Median of Two Sorted Arrays

Allocate Minimum Number of Pages

Aggressive Cows

Painter’s Partition Problem

Capacity to Ship Packages Within D Days

Koko Eating Bananas

📅 Day 5 – Advanced Allocation / Matrix (6 Qs)
Split Array Largest Sum

Minimize Maximum Distance to Gas Station

Median in a Row-Wise Sorted Matrix

Find Peak Element in 2D Matrix

Wood Cutting Problem (Eko SPOJ)

Magnetic Force Between Two Balls

📅 Day 6 – Hard / High-Frequency (6 Qs)
Find Smallest Divisor Given Threshold

Ugly Number III

Kth Smallest Pair Distance

Search in Bitonic Array

Search in Mountain Array

Kth Smallest Element in Multiplication Table
