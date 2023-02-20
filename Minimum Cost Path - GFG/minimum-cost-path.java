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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //dijkstra algo
    private class Tuple implements Comparable<Tuple>{
        int row;
        int col;
        int wt;
        Tuple(int row , int col , int wt){
            this.row = row;
            this.col = col;
            this.wt = wt;
        }
        public int compareTo(Tuple t){
            return this.wt - t.wt;
        }
    }
    public int minimumCostPath(int[][] grid)
    {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int n = grid.length;
        int m = grid[0].length;
        int [][]cost = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        cost[0][0] = grid[0][0];
        pq.add(new Tuple(0 , 0 , grid[0][0]));
        int ans = 0;
        int []delRow = {-1 , 0 , 1 , 0};
        int []delCol = {0 , 1 , 0 , -1};
        while(!pq.isEmpty()){
            Tuple temp = pq.poll();
            int row = temp.row;
            int col = temp.col;
            int wt = temp.wt;
            for(int i = 0 ; i < 4 ; i++){
                int currRow = row + delRow[i];
                int currCol = col + delCol[i];
                if(currRow <= n-1 && currCol <= n-1 && currRow >= 0 
                && currCol >= 0){
                    if(wt + grid[currRow][currCol] < cost[currRow][currCol]){
                        cost[currRow][currCol] = wt + grid[currRow][currCol];
                        pq.add(new Tuple(currRow , currCol , cost[currRow][currCol]));
                    }
                }
            }
        }
        return cost[n-1][n-1];
    }
}
















