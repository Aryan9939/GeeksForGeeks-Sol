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
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    private class Triplet{
        int row;
        int col;
        int time;
        Triplet(int row , int col , int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        int timer = 0;
        Queue<Triplet> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    Triplet temp = new Triplet(i , j , 0);
                    q.add(temp);
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            Triplet temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            int time = temp.time;
            // up
            if(row > 0 && !visited[row-1][col] && grid[row-1][col] == 1){
                visited[row-1][col] = true;
                Triplet t = new Triplet(row-1 , col , time+1);
                q.add(t);
            }
            //right
            if(col < m-1 && !visited[row][col+1] && grid[row][col+1] == 1){
                visited[row][col+1] = true;
                Triplet t = new Triplet(row , col+1 , time+1);
                q.add(t);
            }
            // down
            if(row < n-1 && !visited[row+1][col] && grid[row+1][col] == 1){
                visited[row+1][col] = true;
                Triplet t = new Triplet(row+1 , col , time+1);
                q.add(t);
            }
            //left
            if(col > 0 && !visited[row][col-1] && grid[row][col-1] == 1){
                visited[row][col-1] = true;
                Triplet t = new Triplet(row , col-1 , time+1);
                q.add(t);
            }
            timer = Math.max(timer , time);
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    return -1;
                }
            }
        }
        return timer;
    }
}