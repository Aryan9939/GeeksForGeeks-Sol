//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            String arr = read.readLine().trim();

            Solution ob = new Solution();
            out.println(ob.appleSequence(N, M, arr));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution{
    public static int appleSequence(int n, int m, String arr){
        int i = 0;
        int j = 0;
        int ans = 0;
        int countO = 0;
        int countA = 0;
        while(j < n){
            char c = arr.charAt(j);
            if(countO <= m){
                if(c == 'O'){
                    countO++;
                }
                else{
                    countA++;
                }
                j++;
            }
            if(countO > m){
                char k = arr.charAt(i);
                if(k == 'A'){
                    countA--;
                }
                else{
                    countO--;
                }
                i++;
            }
            ans = Math.max(ans , (j - i));
        }
        if(ans == 0){
            return n;
        }
        return ans;
    }
}


//{ Driver Code Starts.

// } Driver Code Ends