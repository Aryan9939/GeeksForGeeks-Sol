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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    private class Tuple{
        int row;
        int col;
        int step;
        Tuple(int row , int col , int step){
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }
    public int minStepToReachTarget(int KnightPos[], int target[], int N)
    {
         Queue<Tuple> q = new LinkedList<>();
        int tarRow = target[1];
        int tarCol = target[0];
        boolean[][]visited = new boolean[N][N];
        visited[KnightPos[1]-1][KnightPos[0]-1] = true;
        int delRow[] = {-1, -1, -2, 2, 1 ,1 , -2 ,2};
        int delCol[] = {2, -2, 1, 1 ,2, -2, -1,-1};
        q.add(new Tuple(KnightPos[1]-1 , KnightPos[0]-1 , 0));
        while(!q.isEmpty()){
            Tuple temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            int step = temp.step;
            if(row+1 == tarRow && col+1 == tarCol){
                return step;
            }
            for(int i = 0 ; i < 8 ; i++){
                int currRow = row+delRow[i];
                int currCol = col+delCol[i];
                if(currRow >= 0 && currCol >= 0 && currRow < N && currCol < N && !visited[currRow][currCol]){
                    q.add(new Tuple(currRow , currCol , step+1));
                    visited[currRow][currCol] = true;
                }
            }
        }
        return -1;
    }
}