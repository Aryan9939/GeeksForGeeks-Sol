//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int n = nums.length;
        int temp[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int count = 0;
        Map<Integer , Integer> trackIdx = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            trackIdx.put(nums[i] , i);
        }
        for(int i = 0 ; i < n ; i++){
            if(nums[i] != temp[i]){
                count++;
                //geting idx of element which is at wrong place
                //it's right place is at i
                int idx = trackIdx.get(temp[i]);
                trackIdx.put(temp[i] , i);
                trackIdx.put(nums[i] , idx);
                // swap
                int t = nums[i];
                nums[i] = nums[idx];
                nums[idx] = t;
            }
        }
        return count;
    }
}