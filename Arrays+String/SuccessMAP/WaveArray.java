4. Edge Cases
n = 1 → Already wave [a].
n = 2 → Just swap if needed → [2,1].
All elements same → [1,1,1,...] stays the same.
Already in wave form → Our method will not break it since array is sorted initially.
Examples:
Input: arr[] = [1, 2, 3, 4, 5]
Output: [2, 1, 4, 3, 5]
Explanation: Array elements after sorting it in the waveform are 2, 1, 4, 3, 5.
Input: arr[] = [2, 4, 7, 8, 9, 10]
Output: [4, 2, 8, 7, 10, 9]
Explanation: Array elements after sorting it in the waveform are 4, 2, 8, 7, 10, 9.
Input: arr[] = [1]
Output: [1]

class WaveArray {
    public static void convertToWave(int[] arr) {
        int n = arr.length;
        // Traverse the array in steps of 2
        for (int i = 0; i < n - 1; i += 2) {
            // Swap adjacent elements
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        
        convertToWave(arr);
        
        // Print result
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Output: 2 1 4 3 5
    }
}
tc:O(n) sc:O(1)
