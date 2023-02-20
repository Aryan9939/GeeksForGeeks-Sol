//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while(t-- > 0)
        {
            
            
            int R = sc.nextInt();
            
            int C = sc.nextInt();
            
           
            
            int hospital[][] = new int[R][C];
            
            int cnt=0;
            for(int i = 0; i < R; i++)
                {
                    for(int j=0; j < C; j++)
                {
                    hospital[i][j] = sc.nextInt();
                }
                    
                }
            
            Solution ob = new Solution();
            System.out.println(ob.helpaterp(hospital));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    class Tuple{
        int row;
        int col;
        int time;
        Tuple(int row , int col , int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
     public int helpaterp(int[][] hospital) {
         Queue<Tuple> q = new LinkedList<>();
         int n = hospital.length;
         int m = hospital[0].length;
         boolean [][] visited = new boolean[n][m];
         for(int i = 0 ; i < n ; i++){
             for(int j = 0 ; j < m ; j++){
                 if(!visited[i][j] && hospital[i][j] == 2){
                     q.add(new Tuple(i , j , 0));
                     visited[i][j] = true;
                 }
             }
         }
         int ans = 0;
         while(!q.isEmpty()){
             Tuple temp = q.poll();
             int row = temp.row;
             int col = temp.col;
             int time = temp.time;
             ans = Math.max(ans , time);
             //up
             if(row > 0 && !visited[row-1][col] && hospital[row-1][col] == 1){
                 q.add(new Tuple(row-1 , col , time+1));
                 visited[row-1][col] = true;
             }
             //right
             if(col < m-1 && !visited[row][col+1] && hospital[row][col+1] == 1){
                 q.add(new Tuple(row , col+1 , time+1));
                 visited[row][col+1] = true;
             }
             //down
             if(row < n-1 && !visited[row+1][col] && hospital[row+1][col] == 1){
                 q.add(new Tuple(row+1 , col , time+1));
                 visited[row+1][col] = true;
             }
             //left
             if(col > 0 && !visited[row][col-1] && hospital[row][col-1] == 1){
                 q.add(new Tuple(row , col-1 , time+1));
                 visited[row][col-1] = true;
             }
         }
         for(int i = 0 ; i < n ; i++){
             for(int j = 0 ; j < m ; j++){
                 if(!visited[i][j] && hospital[i][j] == 1){
                     return -1;
                 }
             }
         }
         return ans;
    }
}