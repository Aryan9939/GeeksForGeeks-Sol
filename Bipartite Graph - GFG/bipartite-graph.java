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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[V];
        for(int i = 1 ; i < V ; i++){
            color[i] = -1;
        }
        color[0] = 0;
        boolean [] visited = new boolean[V];
        for(int i = 0 ; i < V ; i++){
            if(!visited[i]){
                q.add(i);
                while(!q.isEmpty()){
                    int temp = q.poll();
                    int Tcolor = color[temp];
                    visited[temp] = true;
                    for(int item : adj.get(temp)){
                        // color nhi h
                        if(color[item] == -1){
                            if(Tcolor == 1){
                                color[item] = 0;
                            }
                            else{
                                color[item] = 1;
                            }
                            q.add(item);
                        }
                        // same color h
                        else if(color[item] == Tcolor){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}