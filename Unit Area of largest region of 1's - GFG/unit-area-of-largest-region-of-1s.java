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
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    class Pair{
        int row;
        int col;
        Pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] visited = new boolean[n][m];
        int area = Integer.MIN_VALUE;
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int tempArea = 0;
                    Pair st = new Pair(i , j);
                    visited[i][j] = true;
                    q.add(st);
                    while(!q.isEmpty()){
                        Pair temp = q.poll();
                        tempArea++;
                        int row = temp.row;
                        int col = temp.col;
                        //up
                        if(row > 0 && !visited[row-1][col] && grid[row-1][col] == 1){
                            Pair item = new Pair(row-1 , col);
                            q.add(item);
                            visited[row-1][col] = true;
                        }
                        //up right
                        if(row > 0 && col < m-1 && !visited[row-1][col+1] && grid[row-1][col+1] == 1){
                            Pair item = new Pair(row-1 , col+1);
                            q.add(item);
                            visited[row-1][col+1] = true;
                        }
                        //right
                        if(col < m-1 && !visited[row][col+1] && grid[row][col+1] == 1){
                            Pair item = new Pair(row , col+1);
                            q.add(item);
                            visited[row][col+1] = true;
                        }
                        //down right
                        if(row < n-1 && col < m-1 && !visited[row+1][col+1] && grid[row+1][col+1] == 1){
                            Pair item = new Pair(row+1 , col+1);
                            q.add(item);
                            visited[row+1][col+1] = true;
                        }
                        //down
                        if(row < n-1 && !visited[row+1][col] && grid[row+1][col] == 1){
                            Pair item = new Pair(row+1 , col);
                            q.add(item);
                            visited[row+1][col] = true;
                        }
                        //down left
                        if(row < n-1 && col > 0 && !visited[row+1][col-1] && grid[row+1][col-1] == 1){
                            Pair item = new Pair(row+1 , col-1);
                            q.add(item);
                            visited[row+1][col-1] = true;
                        }
                        //left
                        if(col > 0 && !visited[row][col-1] && grid[row][col-1] == 1){
                            Pair item = new Pair(row , col-1);
                            q.add(item);
                            visited[row][col-1] = true;
                        }
                        //up left
                        if(row > 0 && col > 0 && !visited[row-1][col-1] && grid[row-1][col-1] == 1){
                            Pair item = new Pair(row-1 , col-1);
                            q.add(item);
                            visited[row-1][col-1] = true;
                        }
                        
                    }
                    area = Math.max(area , tempArea);
                }
            }
        }
        if(area == Integer.MIN_VALUE){
            return 0;
        }
        return area;
    }
}