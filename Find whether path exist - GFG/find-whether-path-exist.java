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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
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
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        int r = -1 , c = -1;
        //Pair des;
        int n = grid.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    r = i;
                    c = j;
                }
                // if(grid[i][j] == 2){
                //     des = new Pair(i,j);
                // }
            }
        }
        Queue<Pair> q = new LinkedList<>();
        Pair src = new Pair(r,c);
        q.add(src);
        boolean [][] visited = new boolean[n][n];
        visited[src.row][src.col] = true;
        boolean isPathExist = false;
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            //up
            if(row > 0 && !visited[row-1][col]){
                if(grid[row-1][col] == 2){
                    return true;
                }
                else if(grid[row-1][col] == 3){
                    Pair item = new Pair(row-1 , col);
                    visited[row-1][col] = true;
                    q.add(item);
                }
            }
            //right
            if(col < n-1 && !visited[row][col+1]){
                if(grid[row][col+1] == 2){
                    return true;
                }
                else if(grid[row][col+1] == 3){
                    Pair item = new Pair(row , col+1);
                    visited[row][col+1] = true;
                    q.add(item);
                }
            }
            //down
            if(row < n-1 && !visited[row+1][col]){
                if(grid[row+1][col] == 2){
                    return true;
                }
                else if(grid[row+1][col] == 3){
                    Pair item = new Pair(row+1 , col);
                    visited[row+1][col] = true;
                    q.add(item);
                }
            }
            //left
            if(col > 0 && !visited[row][col-1]){
                if(grid[row][col-1] == 2){
                    return true;
                }
                else if(grid[row][col-1] == 3){
                    Pair item = new Pair(row , col-1);
                    visited[row][col-1] = true;
                    q.add(item);
                }
            }
        }
        return false;
    }
}

















