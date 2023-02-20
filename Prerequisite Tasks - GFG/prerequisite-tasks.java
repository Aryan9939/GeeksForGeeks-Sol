//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    private int[] inDeg;
    private void makeList(int n , int[][] pre){
        for(int i = 0 ; i < n ; i++){
            adjList.add(new ArrayList<>());
        }
        int e = pre.length;
        for(int i = 0 ; i < e ; i++){
            int u = pre[i][1];
            int v = pre[i][0];
            inDeg[v]++;
            adjList.get(u).add(v);
        }
    }
    private boolean topoSort(int n){
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(inDeg[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int temp = q.poll();
            count++;
            for(int item : adjList.get(temp)){
                if(inDeg[item] -1 == 0){
                    q.add(item);
                    inDeg[item] = -1;
                } 
                else{
                    inDeg[item]--;
                }
            }
        }
        return count==n;
    }
    public boolean isPossible(int N, int[][] prerequisites)
    {
        // Your Code goes here
        inDeg = new int[N];
        makeList(N , prerequisites);
        return topoSort(N);
    }
    
}