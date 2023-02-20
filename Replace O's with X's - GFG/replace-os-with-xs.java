//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static private class Pair{
        int row;
        int col;
        Pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }
    static char[][] fill(int n, int m, char a[][])
    {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        //horizental
        for(int i = 0 ; i < m ; i++){
            if(a[0][i] == 'O' && !visited[0][i]){
                q.add(new Pair(0 , i));
                visited[0][i] = true;
            }
            if(a[n-1][i] == 'O' && !visited[n-1][i]){
                q.add(new Pair(n-1 , i));
                visited[n-1][i] = true;
            }
        }
        //vertical
        for(int i = 0 ; i < n ; i++){
            if(a[i][0] == 'O' && !visited[i][0]){
                q.add(new Pair(i,0));
                visited[i][0] = true;
            }
            if(a[i][m-1] == 'O' && !visited[i][m-1]){
                q.add(new Pair(i , m-1));
                visited[i][m-1] = true;
            }
        }
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            //up
            if(row > 0 && a[row-1][col] == 'O' && !visited[row-1][col]){
                q.add(new Pair(row-1 , col));
                visited[row-1][col] = true;
            }
            //right
            if(col < m-1 && a[row][col+1] == 'O' && !visited[row][col+1]){
                q.add(new Pair(row , col+1));
                visited[row][col+1] = true;
            }
            //down
            if(row < n-1 && a[row+1][col] == 'O' && !visited[row+1][col]){
                q.add(new Pair(row+1 , col));
                visited[row+1][col] = true;
            }
            //left
            if(col > 0 && a[row][col-1] == 'O' && !visited[row][col-1]){
                q.add(new Pair(row , col-1));
                visited[row][col-1] = true;
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(visited[i][j]){
                    a[i][j] = 'O';
                }
                else{
                    a[i][j] = 'X';
                }
            }
        }
        return a;
    }
}