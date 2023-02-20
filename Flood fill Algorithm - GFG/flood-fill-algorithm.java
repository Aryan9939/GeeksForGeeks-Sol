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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    class Pair{
        int row;
        int col;
        int color;
        
        Pair(int row , int col , int color){
            this.row = row;
            this.col = col;
            this.color = color;
        }
    }
    int [][] ans;
    private void bfs(int [][] image , int n , int m , int row , int col){
        boolean [][] visited = new boolean[n][m];
        visited[row][col] = true;
        Pair pair = new Pair(row , col , image[row][col]);
        Queue<Pair> q = new LinkedList<>();
        q.add(pair);
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int temp_row = temp.row;
            int temp_col = temp.col;
            int temp_color = temp.color;
            //up
            if(temp_row > 0 && !visited[temp_row-1][temp_col] && image[temp_row-1][temp_col] == temp_color){
                Pair p = new Pair(temp_row-1 , temp_col , temp_color);
                q.add(p);
                visited[temp_row-1][temp_col] = true;
                ans[temp_row-1][temp_col] = -1;
            }
            //right
            if(temp_col < m-1 && !visited[temp_row][temp_col+1] && image[temp_row][temp_col+1] == temp_color){
                Pair p = new Pair(temp_row , temp_col+1 , temp_color);
                q.add(p);
                visited[temp_row][temp_col+1] = true;
                ans[temp_row][temp_col+1] = -1;
                
            }
            //down
            if(temp_row < n-1 && !visited[temp_row+1][temp_col] && image[temp_row+1][temp_col] == temp_color){
                Pair p = new Pair(temp_row+1 , temp_col , temp_color);
                q.add(p);
                visited[temp_row+1][temp_col] = true;
                ans[temp_row+1][temp_col] = -1;
                
            }
            //left
            if(temp_col > 0 && !visited[temp_row][temp_col-1] && image[temp_row][temp_col-1] == temp_color){
                Pair p = new Pair(temp_row , temp_col-1 , temp_color);
                q.add(p);
                visited[temp_row][temp_col-1] = true;
                ans[temp_row][temp_col-1] = -1;
                
            }
            
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int n = image.length;
        int m = image[0].length;
        ans = new int[n][m];
        bfs(image , n , m , sr , sc);
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(ans[i][j] == -1){
                    image[i][j] = newColor;
                }
            }
        }
        image[sr][sc] = newColor;
        return image;
    }
}