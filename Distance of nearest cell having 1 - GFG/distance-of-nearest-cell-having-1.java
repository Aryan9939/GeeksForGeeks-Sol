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
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    private class Tuple{
        int row;
        int col;
        int dis;
        Tuple(int row , int col , int dis){
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int [][] ans = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<Tuple> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                ans[i][j] = Integer.MAX_VALUE;
                if(grid[i][j] == 1){
                    q.add(new Tuple(i , j , 0));
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            Tuple temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            int dis = temp.dis;
            ans[row][col] = Math.min(ans[row][col] , dis);
            //up
            if(row > 0 && grid[row-1][col] == 0 && !visited[row-1][col]){
                q.add(new Tuple(row-1 , col , dis+1));
                visited[row-1][col] = true;
            }
            //right
            if(col < m-1 && grid[row][col+1] == 0 && !visited[row][col+1]){
                q.add(new Tuple(row , col+1 , dis+1));
                visited[row][col+1] = true;
            }
            //down
            if(row < n-1 && grid[row+1][col] == 0 && !visited[row+1][col]){
                q.add(new Tuple(row+1 , col , dis+1));
                visited[row+1][col] = true;
            }
            //left
            if(col > 0 && grid[row][col-1] == 0 && !visited[row][col-1]){
                q.add(new Tuple(row , col-1 , dis+1));
            }
        }
        return ans;
    }
}