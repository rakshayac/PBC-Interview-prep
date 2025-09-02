Input: arr[] = [1, 2, 3] 
Output: 20
Explanation: All subarray sums are: [1] = 1, [2] = 2, [3] = 3, [1, 2] = 3, [2, 3] = 5, [1, 2, 3] = 6. Thus total sum is 1 + 2 + 3 + 3 + 5 + 6 = 20.

Algorithm (Better Approach O(n²))
int n = arr.length();
int total = 0;

for (int i = 0; i < n; i++) {
    int sum = 0;   // subarray sum starting at i
    for (int j = i; j < n; j++) {
        sum += arr[j];   // புதிய element மட்டும் சேர்க்கிறோம்
        total += sum;    // அந்த subarray sum-ஐ total-க்கு add பண்ணுறோம்
    }
}

Optimal Approach (O(n))

👉 Contribution Technique பயன்படுத்துறோம்.

arr[i] எத்தனை subarray-ல வரும்?

Start position = (i+1) choices

End position = (n-i) choices

Total = (i+1) * (n-i) subarray-களில் வரும்

Contribution = arr[i] * (i+1) * (n-i)

class Solution {
    public int subarraySum(int[] arr) 
    {
        // code here
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
             sum+=arr[i]*(i+1)*(n-i);     
        }
        return sum;
}    
}



⏱️ Time Complexity → O(n) ✅ சிறந்தது
📦 Space Complexity → O(1)

🔹 Dry Run (arr = [1,2,3], n=3)

i=0 → 1 * (0+1) * (3-0) = 1*1*3 = 3

i=1 → 2 * (1+1) * (3-1) = 2*2*2 = 8

i=2 → 3 * (2+1) * (3-2) = 3*3*1 = 9

👉 Total = 3 + 8 + 9 = 20 ✅