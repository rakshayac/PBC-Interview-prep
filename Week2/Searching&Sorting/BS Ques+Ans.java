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

    📝 Problem Statement
Sorted array-இல் target number இருக்கும்போது,
👉 target-க்கு சமம் அல்லது அதற்கு மேல் வரும் smallest index return பண்ண வேண்டும்.
இதையே Lower Bound என்பாங்க.

📊 Example 1 (Normal Case)

arr = [2, 4, 6, 8, 10]
target = 5
👉 Answer = 2 (arr[2] = 6 → 5 க்கு மேல் வரும் first element)
    
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
    Problem Statement
Sorted array-இல் ஒரு target கொடுக்கப்பட்டிருக்கும்.
👉 target-க்கு strict-ஆ greater (>) இருக்கும் smallest index return பண்ண வேண்டும்.
இதையே Upper Bound என்பாங்க.

📊 Example 1 (Normal Case)

arr = [2, 4, 6, 8, 10]
target = 6
👉 Answer = 3 (arr[3] = 8 → 6-க்கு மேல் வரும் first element)

🔎 Step by Step Dry Run
low = 0, high = 4, ans = 5

mid = (0+4)//2 = 2 → arr[2]=6 → (NOT >6) → so low=3

mid = (3+4)//2 = 3 → arr[3]=8 (>6) → ans=3, high=2

Loop முடிஞ்சது → ans=3

✅ Output = 3

    class UpperBound {
    public static int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length; // 👈 initially answer = array end

        // 👇 Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // 👇 arr[mid] > target என்றால் இந்த index ஒரு candidate
            if (arr[mid] > target) {
                ans = mid;      // ans update பண்ணிக்கலாம்
                high = mid - 1; // இன்னும் left sideல் small index இருக்கா check பண்ண
            } 
            // 👇 arr[mid] <= target என்றால் right side move பண்ணனும்
            else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 8, 10};
        System.out.println(upperBound(arr1, 6)); // Output: 3

        int[] arr2 = {5, 10, 15};
        System.out.println(upperBound(arr2, 1)); // Output: 0

        int[] arr3 = {3, 5, 7};
        System.out.println(upperBound(arr3, 10)); // Output: 3

        int[] arr4 = {2, 4, 6, 8};
        System.out.println(upperBound(arr4, 4)); // Output: 2 (since 6 > 4)
    }
}

4.Floor of a Number
arr = [2, 4, 6, 8, 10], target = 5
low=0, high=4

mid=2 → arr[2]=6 (>5) → high=1

mid=0 → arr[0]=2 (<5) → floor=2, low=1

mid=1 → arr[1]=4 (<5) → floor=4, low=2

loop முடிஞ்சது
👉 Floor=4
    
    class FloorOnly {
    public static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1; // 👈 initially floor not found

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                // 👇 target கிடைச்சுடுச்சு → இதுவே floor
                return arr[mid];
            }
            else if (arr[mid] < target) {
                // 👇 arr[mid] smaller than target → இது ஒரு floor candidate
                floor = arr[mid];
                low = mid + 1;
            }
            else {
                // 👇 arr[mid] பெரியது → leftக்கு போனோம்னா தான் floor கிடைக்கும்
                high = mid - 1;
            }
        }

        return floor; // 👈 கிடைக்கலன்னா -1
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 8, 10};
        System.out.println(floor(arr1, 5));  // 4

        int[] arr2 = {2, 4, 6, 8};
        System.out.println(floor(arr2, 6));  // 6

        int[] arr3 = {5, 10, 20};
        System.out.println(floor(arr3, 1));  // -1

        int[] arr4 = {3, 5, 7};
        System.out.println(floor(arr4, 10)); // 7
    }
}

5.Ceil of a Number
Example 1

arr = [2, 4, 6, 8, 10]
target = 5
👉 Ceil = 6
arr = [2, 4, 6, 8, 10], target = 5

low=0, high=4

mid=2 → arr[2]=6 (≥ target) → ceil candidate = 6 → high=1

mid=0 → arr[0]=2 (< target) → low=1

mid=1 → arr[1]=4 (< target) → low=2

loop முடிஞ்சது
👉 Ceil=6

    class CeilOnly {
    public static int ceil(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ceil = -1; // 👈 initially ceil not found

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                // 👇 target கிடைச்சா → இதுவே ceil
                return arr[mid];
            }
            else if (arr[mid] < target) {
                // 👇 arr[mid] smaller → ceil right sideல தான் இருக்கும்
                low = mid + 1;
            }
            else {
                // 👇 arr[mid] பெரியது → இது ஒரு ceil candidate
                ceil = arr[mid];
                high = mid - 1;
            }
        }

        return ceil; // 👈 கிடைக்கலன்னா -1
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 8, 10};
        System.out.println(ceil(arr1, 5));  // 6

        int[] arr2 = {2, 4, 6, 8};
        System.out.println(ceil(arr2, 6));  // 6

        int[] arr3 = {5, 10, 20};
        System.out.println(ceil(arr3, 25)); // -1

        int[] arr4 = {3, 5, 7};
        System.out.println(ceil(arr4, 1));  // 3
    }
}


6.First and Last Occurrence of Element
    📝 Problem
ஒரு sorted array கொடுக்கப்பட்டிருக்கும். அதில் ஒரு target number எத்தனை தடவை repeat ஆயிருக்கு என்று கண்டுபிடிக்கணும்.
அதுக்காக நமக்கு First Occurrence (முதல் இடம்) மற்றும் Last Occurrence (கடைசி இடம்) தேவை.

📊 Example 1

arr = [2, 4, 4, 4, 6, 8]
target = 4
👉 First occurrence = index 1
👉 Last occurrence = index 3
👉 Count = (3 - 1 + 1) = 3

Idea (Binary Search Modify)
First Occurrence:

arr[mid] == target ஆனாலும் இன்னும் left-ல இருக்கலாம் → high = mid-1

Last Occurrence:

arr[mid] == target ஆனாலும் இன்னும் right-ல இருக்கலாம் → low = mid+1

    class FirstLastOccurrence {
    public static int firstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int first = -1; // 👈 not found initially

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                first = mid;       // 👈 possible answer
                high = mid - 1;    // 👈 இன்னும் left sideல இருக்கலாம்
            }
            else if (arr[mid] < target) {
                low = mid + 1;     // 👈 rightக்கு போகணும்
            }
            else {
                high = mid - 1;    // 👈 leftக்கு போகணும்
            }
        }
        return first;
    }

    public static int lastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int last = -1; // 👈 not found initially

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                last = mid;        // 👈 possible answer
                low = mid + 1;     // 👈 இன்னும் right sideல இருக்கலாம்
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 4, 4, 6, 8};
        System.out.println("First: " + firstOccurrence(arr1, 4)); // 1
        System.out.println("Last: " + lastOccurrence(arr1, 4));   // 3

        int[] arr2 = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println("First: " + firstOccurrence(arr2, 3)); // 2
        System.out.println("Last: " + lastOccurrence(arr2, 3));   // 5

        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println("First: " + firstOccurrence(arr3, 6)); // -1
        System.out.println("Last: " + lastOccurrence(arr3, 6));   // -1
    }
}


7.Count of Element in Sorted Array
    📝 Problem
ஒரு sorted array இருக்கு. அதில் ஒரு particular target number எத்தனை தடவை வந்திருக்கு என்பதை கண்டுபிடிக்கணும்.

🔎 Idea
First Occurrence & Last Occurrence already கண்டுபிடிச்சுருக்கோம்.

Count = (last - first + 1)

இல்லனா target இல்ல → 0
    Example 2
arr = [1, 2, 3, 3, 3, 3, 4, 5]
target = 3
👉 First = 2, Last = 5
👉 Count = (5 - 2 + 1) = 4

    class CountOfElement {
    public static int firstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, first = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                first = mid;       // 👈 possible answer
                high = mid - 1;    // 👈 இன்னும் left sideல இருக்கலாம்
            }
            else if (arr[mid] < target) {
                low = mid + 1;     // 👈 rightக்கு போகணும்
            }
            else {
                high = mid - 1;    // 👈 leftக்கு போகணும்
            }
        }
        return first;
    }

    public static int lastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                last = mid;        // 👈 possible answer
                low = mid + 1;     // 👈 இன்னும் right sideல இருக்கலாம்
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return last;
    }

    public static int countElement(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        if (first == -1) return 0;   // 👈 element not found

        int last = lastOccurrence(arr, target);
        return last - first + 1;     // 👈 formula
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 4, 4, 6, 8};
        System.out.println(countElement(arr1, 4)); // 3

        int[] arr2 = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(countElement(arr2, 3)); // 4

        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println(countElement(arr3, 6)); // 0
    }
}


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
