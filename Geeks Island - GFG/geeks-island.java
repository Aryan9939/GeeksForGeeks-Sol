//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int [][] mat = new int[N][M];
			for(int i = 0; i < N; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < M; j++) {
					mat[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			out.println(obj.water_flow(mat, N, M));
		}
		out.close();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    private class Pair{
        int val;
        int row;
        int col;
        Pair(int val , int row , int col){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
	int water_flow(int [][] mat, int N, int M) {
	    int n = mat.length;
	    int m = mat[0].length;
		Queue<Pair> q = new LinkedList<>();
		boolean isInd[][] = new boolean[n][m];
		boolean isArab[][] = new boolean[n][m];
		for(int i = 0 ; i < n ; i++){
		    if(!isInd[i][0]){
		        q.add(new Pair(mat[i][0] , i , 0));
		        isInd[i][0] = true;
		    }
		}
		for(int i = 0 ; i < m ; i++){
		    if(!isInd[0][i]){
		        q.add(new Pair(mat[0][i] , 0 , i));
		        isInd[0][i] = true;
		    }
		}
		while(!q.isEmpty()){
		    Pair temp = q.poll();
		    int row = temp.row;
		    int col = temp.col;
		    int val = temp.val;
		    //up
		    if(row > 0 && !isInd[row-1][col] && mat[row-1][col] >= val){
		        q.add(new Pair(mat[row-1][col] , row-1 , col));
		        isInd[row-1][col] = true;
		    }
		    //right
		    if(col < m-1 && !isInd[row][col+1] && mat[row][col+1] >= val){
		        q.add(new Pair(mat[row][col+1] , row , col+1));
		        isInd[row][col+1] = true;
		    }
		    //down
		    if(row < n-1 && !isInd[row+1][col] && mat[row+1][col] >= val){
		        q.add(new Pair(mat[row+1][col] , row+1 , col));
		        isInd[row+1][col] = true;
		    }
		    //left
		    if(col > 0 && !isInd[row][col-1] && mat[row][col-1] >= val){
		        q.add(new Pair(mat[row][col-1] , row , col-1));
		        isInd[row][col-1] = true;
		    }
		}
		for(int i = 0 ; i < n ; i++){
		    if(!isArab[i][m-1]){
		        q.add(new Pair(mat[i][m-1] , i , m-1));
		        isArab[i][m-1] = true;
		    }
		}
		for(int i = 0 ; i < m ; i++){
		    if(!isArab[n-1][i]){
		        q.add(new Pair(mat[n-1][i] , n-1 , i));
		        isArab[n-1][i] = true;
		    }
		}
		while(!q.isEmpty()){
		    Pair temp = q.poll();
		    int row = temp.row;
		    int col = temp.col;
		    int val = temp.val;
		    //up
		    if(row > 0 && !isArab[row-1][col] && mat[row-1][col] >= val){
		        q.add(new Pair(mat[row-1][col] , row-1 , col));
		        isArab[row-1][col] = true;
		    }
		    //right
		    if(col < m-1 && !isArab[row][col+1] && mat[row][col+1] >= val){
		        q.add(new Pair(mat[row][col+1] , row , col+1));
		        isArab[row][col+1] = true;
		    }
		    //down
		    if(row < n-1 && !isArab[row+1][col] && mat[row+1][col] >= val){
		        q.add(new Pair(mat[row+1][col] , row+1 , col));
		        isArab[row+1][col] = true;
		    }
		    //left
		    if(col > 0 && !isArab[row][col-1] && mat[row][col-1] >= val){
		        q.add(new Pair(mat[row][col-1] , row , col-1));
		        isArab[row][col-1] = true;
		    }
		}
		int ans = 0;
		for(int i = 0 ; i < n ; i++){
		    for(int j = 0 ; j < m ; j++){
		        if(isArab[i][j] && isInd[i][j]){
		            ans++;
		        }
		    }
		}
		return ans;
	}
}


















