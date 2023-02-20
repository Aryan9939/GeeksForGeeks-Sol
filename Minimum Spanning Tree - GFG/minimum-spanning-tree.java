//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    private static class Pair implements Comparable<Pair>{
        int node;
        int wt;
        Pair(int node , int wt){
            this.node = node;
            this.wt = wt;
        }
        public int compareTo(Pair p){
            return this.wt - p.wt;
        }
    }
	static int spanningTree(int V, int E, int edges[][]){
	    ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
	    for(int i = 0 ; i < V ; i++){
	        adjList.add(new ArrayList<>());
	    }
	    for(int i = 0 ; i < E ; i++){
	        int u = edges[i][0];
	        int v = edges[i][1];
	        int wt = edges[i][2];
	        adjList.get(u).add(new Pair(v , wt));
	        adjList.get(v).add(new Pair(u , wt));
	    }
	    int ans = 0;
	    PriorityQueue<Pair> pq = new PriorityQueue<>();
	    boolean[] visited = new boolean[V];
        for(int i = 0 ; i < V ; i++){
            if(!visited[i]){
                pq.add(new Pair(i , 0));
                while(!pq.isEmpty()){
                    Pair temp = pq.poll();
                    int node = temp.node;
                    int wt = temp.wt;
                    if(visited[node]){
                        continue;
                    }
                    ans = ans + wt;
                    visited[node] = true;
                    for(Pair item : adjList.get(node)){
                        if(!visited[item.node]){
                            pq.add(item);
                        }
                    }
                }
            }
        }
        return ans;
	}
}