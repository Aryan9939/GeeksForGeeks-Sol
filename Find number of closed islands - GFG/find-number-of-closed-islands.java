//{ Driver Code Starts
//Initial Template for Java

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
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

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
    private boolean[][] visited;
    private void bfs(int i , int  j , int [][] grid){
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i , j));
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            //up
            if(row > 0 && !visited[row-1][col] && grid[row-1][col] == 1){
                q.add(new Pair(row-1 , col));
                visited[row-1][col] = true;
            }
            //right
            if(col < m-1 && !visited[row][col+1] && grid[row][col+1] == 1){
                q.add(new Pair(row , col+1));
                visited[row][col+1] = true;
            }
            //down
            if(row < n-1 && !visited[row+1][col] && grid[row+1][col] == 1){
                q.add(new Pair(row+1 , col));
                visited[row+1][col] = true;
            }
            //left
            if(col > 0 && !visited[row][col-1] && grid[row][col-1] == 1){
                q.add(new Pair(row , col-1));
                visited[row][col-1] = true;
            }
        }
    }
    public int closedIslands(int[][] matrix, int N, int M)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        visited = new boolean[n][m];
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            if(!visited[i][0] && matrix[i][0] == 1){
                visited[i][0] = true;
                bfs( i , 0 , matrix);
            }
            if(!visited[i][m-1] && matrix[i][m-1] == 1){
                visited[i][m-1] = true;
                bfs(i , m-1 , matrix);
            }
        }
        for(int i = 0 ; i < m ; i++){
            if(!visited[0][i] && matrix[0][i] == 1){
                visited[0][i] = true;
                bfs(0 , i , matrix);
            }
            if(!visited[n-1][i] && matrix[n-1][i] == 1){
                visited[n-1][i] = true;
                bfs(n-1 , i , matrix);
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && matrix[i][j] == 1){
                    ans++;
                    visited[i][j] = true;
                    bfs(i , j , matrix);
                }
            }
        }
        return ans;
    }
}