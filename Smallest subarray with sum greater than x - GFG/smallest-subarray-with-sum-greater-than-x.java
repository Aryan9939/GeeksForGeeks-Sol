//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.smallestSubWithSum(a, n, m));
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int smallestSubWithSum(int a[], int n, int x) {
        // yaha sum ko first element se start karge
        int sum = a[0];
        // yaha ans ko n+1 isliye rakhe taki last me check kar sake ki ans update huwa h ki nhi nhi toh zero return karna h
        int ans = n+1;
        int i = 0 , j = 0;
        while(i < n){
            // agar sum given number se kam h toh ek index aage badhege aur add karge
            if(sum <= x){
                i++;
                if(i < n){
                    sum = sum + a[i];
                }
            }
            // aur agar sum bada ho jata h index se tab aur j bhi kam rhega i se tab phice se ele ko hata kar dekhenge
            else if(sum > x && j <= i){
                ans = Math.min(ans , i-j+1);
                sum = sum - a[j];
                j++;
            }
            
        }
        // aur agar last tak ans update nhi hota h tab return zero nhi toh return ans
        if(ans == n+1){
            return 0;
        }
        return ans;
    }
}

