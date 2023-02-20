//{ Driver Code Starts
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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
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
    private int[][] dijkstra(int [][] grid , int [] src){
        Queue<Tuple> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] ansDis = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                ansDis[i][j] = Integer.MAX_VALUE;
            }
        }
        int i = src[0];
        int j = src[1];
        if(grid[i][j] == 1){
            q.add(new Tuple(i , j , 0));
            ansDis[i][j] = 0;
        }
        while(!q.isEmpty()){
            Tuple temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            int dis = temp.dis;
            //up
            if(row > 0 && grid[row-1][col] == 1){
                if(dis+1 < ansDis[row-1][col]){
                    q.add(new Tuple(row-1 , col , dis+1));
                    ansDis[row-1][col] = dis+1;
                }
            }
            //down
            if(row < n-1 && grid[row+1][col] == 1){
                if(dis+1 < ansDis[row+1][col]){
                    q.add(new Tuple(row+1 , col , dis+1));
                    ansDis[row+1][col] = dis+1;
                }
            }
            //right
            if(col < m-1 && grid[row][col+1] == 1){
                if(dis+1 < ansDis[row][col+1]){
                    q.add(new Tuple(row , col+1 , dis+1));
                    ansDis[row][col+1] = dis+1;
                }
            }
            //left
            if(col > 0 && grid[row][col-1] == 1){
                if(dis+1 < ansDis[row][col-1]){
                    q.add(new Tuple(row , col-1 , dis+1));
                    ansDis[row][col-1] = dis+1;
                }
            }
        }
        return ansDis;
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        int [][] ans = dijkstra(grid , source);
        if(ans[destination[0]][destination[1]] == Integer.MAX_VALUE){
            return -1;
        }
        return ans[destination[0]][destination[1]];
    }
}
