//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private static Set<Integer> visited;
    private static ArrayList<ArrayList<Integer>> adjList;
    private static void makeList(ArrayList<ArrayList<Integer>> adj , int n){
        for(int i = 0 ; i < n ; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(adj.get(i).get(j) == 1){
                    adjList.get(i).add(j);
                }
            }
        }
    }
    private static void bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited.add(node);
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int item : adjList.get(temp)){
                if(!visited.contains(item)){
                    q.add(item);
                    visited.add(item);
                }
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        visited  = new HashSet<>();
        adjList = new ArrayList<>();
        int ans = 0;
        makeList(adj , V);
        for(int i = 0 ; i < V ; i++){
            if(!visited.contains(i)){
                bfs(i);
                ans++;
            }
        }
        return ans;
    }
};