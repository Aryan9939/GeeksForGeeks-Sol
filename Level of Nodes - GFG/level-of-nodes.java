//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    private class Pair{
        int node;
        int level;
        Pair(int node , int level){
            this.node = node;
            this.level = level;
        }
    }
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0 , 0));
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int node = temp.node;
            int level = temp.level;
            if(node == X){
                return level;
            }
            for(int item : adj.get(node)){
                if(!visited.contains(item)){
                    q.add(new Pair(item , level+1));
                    visited.add(item);
                }
            }
        }
        return -1;
    }
}