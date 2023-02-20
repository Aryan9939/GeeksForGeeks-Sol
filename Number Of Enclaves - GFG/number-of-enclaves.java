//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private class Pair{
        int row;
        int col;
        Pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }

    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(grid[i][0] == 1 && !visited[i][0]){
                q.add(new Pair(i , 0));
                visited[i][0] = true;
            }
            if(grid[i][m-1] == 1 && !visited[i][m-1]){
                q.add(new Pair(i ,m-1));
                visited[i][m-1] = true;
            }
        }
        for(int i = 0 ; i < m ; i++){
            if(grid[0][i] == 1 && !visited[0][i]){
                q.add(new Pair(0 , i));
                visited[0][i] = true;
            }
            if(grid[n-1][i] == 1 && !visited[n-1][i]){
                q.add(new Pair(n-1 , i));
                visited[n-1][i] = true;
            }
        }
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            //up
            if(row > 0 && grid[row-1][col] == 1 && !visited[row-1][col]){
                q.add(new Pair(row-1 , col));
                visited[row-1][col] = true;
            }
            //right
            if(col < m-1 && grid[row][col+1] == 1 && !visited[row][col+1]){
                q.add(new Pair(row , col+1));
                visited[row][col+1] = true;
            }
            //down
            if(row < n-1 && grid[row+1][col] == 1 && !visited[row+1][col]){
                q.add(new Pair(row+1 , col));
                visited[row+1][col] = true;
            }
            //left
            if(col > 0 && grid[row][col-1] == 1 && !visited[row][col-1]){
                q.add(new Pair(row , col-1));
                visited[row][col-1] = true;
            }
        }
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}