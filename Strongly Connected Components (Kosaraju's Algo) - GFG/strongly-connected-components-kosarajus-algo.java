//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    private boolean[] visited;
    Stack<Integer> st = new Stack<>();
    private void topoSort(int node , ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        for(int item : adj.get(node)){
            if(!visited[item]){
                topoSort(item , adj);
            }
        }
        st.push(node);
    }
    private ArrayList<ArrayList<Integer>> reverseGraph(ArrayList<ArrayList<Integer>> adj , int n){
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            revAdj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n ; i++){
            int u = i;
            for(int item : adj.get(u)){
                revAdj.get(item).add(u);
            }
        }
        return revAdj;
    }
    private void dfs(int node , ArrayList<ArrayList<Integer>> revAdj){
        visited[node] = true;
        for(int item : revAdj.get(node)){
            if(!visited[item]){
                dfs(item , revAdj);
            }
        }
        
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        visited = new boolean[V];
        for(int i = 0 ; i < V ; i++){
            if(!visited[i]){
                topoSort(i , adj);
            }
        }
        for(int i = 0 ; i < V ; i++){
            visited[i] = false;
        }
        ArrayList<ArrayList<Integer>> revAdj = reverseGraph(adj , V);
        int ans = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            if(!visited[node]){
                 ans++;
                dfs(node , revAdj);
            }
        }
        return ans;
    }
}
