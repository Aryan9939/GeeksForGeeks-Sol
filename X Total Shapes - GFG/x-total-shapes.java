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
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            Solution obj = new Solution();
            int ans = obj.xShape(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




class Solution
{
    private class Pair{
        int row;
        int col;
        Pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }
    //Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        boolean [][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && grid[i][j] == 'X'){
                    ans++;
                    q.add(new Pair(i , j));
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        Pair temp = q.poll();
                        int row = temp.row;
                        int col = temp.col;
                        //up
                        if(row > 0 && !visited[row-1][col] && grid[row-1][col] == 'X'){
                            q.add(new Pair(row-1 , col));
                            visited[row-1][col] = true;
                        }
                        //right
                        if(col < m-1 && !visited[row][col+1] && grid[row][col+1] == 'X'){
                            q.add(new Pair(row, col+1));
                            visited[row][col+1] = true;
                        }
                        //down
                        if(row < n-1 && !visited[row+1][col] && grid[row+1][col] == 'X'){
                            q.add(new Pair(row+1 , col));
                            visited[row+1][col] = true;
                        }
                        //left
                        if(col > 0 && !visited[row][col-1] && grid[row][col-1] == 'X'){
                            q.add(new Pair(row , col-1));
                            visited[row][col-1] = true;
                        }
                    }
                }
            }
        }
        return ans;
    }
}