//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    private boolean topoSort(int node ,ArrayList<ArrayList<Integer>> adj , int n){
        int [] inDegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int temp1 : adj.get(i)){
                inDegree[temp1]++;
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int temp = q.poll();
            count++;
            for(int item : adj.get(temp)){
                if(--inDegree[item] == 0){
                    q.add(item);
                }
            }
        }
        if(count != n){
            return true;
        }
        return false;
        
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       return topoSort( 0 , adj , V);
    }
}