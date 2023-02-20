//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    private class Pair{
        int first;
        int second;
        Pair(int first , int second){
            this.first = first;
            this.second = second;
        }
    }
    private boolean [][] visited;
    private void bfs(Pair pair , char[][] grid){
        Queue<Pair> q = new LinkedList<>();
        q.add(pair);
        int m = grid[0].length;
        int n = grid.length;
        visited[pair.first][pair.second] = true;
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int row = temp.first;
            int col = temp.second;
            //up
            if(row > 0 && !visited[row-1][col] && grid[row-1][col] == '1'){
                Pair item = new Pair(row-1 , col);
                visited[row-1][col] = true;
                q.add(item);
            }
            //up right
            if(row > 0 && col < m-1 && !visited[row-1][col+1] && grid[row-1][col+1] == '1'){
                Pair item = new Pair(row-1 , col+1);
                visited[row-1][col+1] = true;
                q.add(item);
                
            }
            //right
            if(col < m-1 && !visited[row][col+1] && grid[row][col+1] == '1' ){
                Pair item = new Pair(row , col+1);
                visited[row][col+1] = true;
                q.add(item);
            }
            //right down
            if(row < n-1 && col < m-1 && !visited[row+1][col+1] && grid[row+1][col+1] == '1'){
                Pair item = new Pair(row+1 , col+1);
                visited[row+1][col+1] = true;
                q.add(item);
            }
            //down
            if(row < n-1 && !visited[row+1][col] && grid[row+1][col] == '1'){
                Pair item = new Pair(row+1 , col);
                visited[row+1][col] = true;
                q.add(item);
            }
            //left down
            if(row < n-1 && col > 0 && !visited[row+1][col-1] && grid[row+1][col-1] == '1'){
                Pair item = new Pair(row+1 , col-1);
                visited[row+1][col-1] = true;
                q.add(item);
            }
            //left
            if(col > 0 && !visited[row][col-1] && grid[row][col-1] == '1'){
                Pair item = new Pair(row , col-1);
                visited[row][col-1] = true;
                q.add(item);
            }
            //left up
            if(row > 0 && col > 0 && !visited[row-1][col-1] && grid[row-1][col-1] == '1'){
                Pair item = new Pair(row-1 , col-1);
                visited[row-1][col-1] = true;
                q.add(item);
            }
            
        }
    }

    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid[0].length;
        int n = grid.length;
        visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    ans++;
                    Pair pair = new Pair(i , j);
                    bfs(pair , grid);
                }
            }
        }
        return ans;
    }
}