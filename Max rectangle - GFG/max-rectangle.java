//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    private int[] prevSmall(int[] heights){
        int [] next = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i = 0 ; i < heights.length ; i++){
            int curr = heights[i];
            while(st.peek() != -1 && heights[st.peek()] >= curr){
                st.pop();
            }
            next[i] = st.peek();
            st.push(i);
        }
        return next;
    }
    private int[] nextSmall(int[] heights){
        int [] next = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i = heights.length-1 ; i >= 0 ; i--){
            int curr = heights[i];
            while(st.peek() != -1 && heights[st.peek()] >= curr){
                st.pop();
            }
            next[i] = st.peek();
            st.push(i);
        }
        return next;
    }
    private int maxAreaUtil(int[] heights) {
        int area = 0;
        // yaha hmlog next me jo small h usse nikal rhe h
        int[] next = nextSmall(heights);
        // yaha jo prev me small h usko nikal rhe h taki area calculate easy ho
        int prev[] = prevSmall(heights);
        
        for(int i = 0 ; i < heights.length ; i++){
           
            int h = heights[i];
            // yaha agar same height ka h tab hoga
            
            if(next[i] == -1){
                next[i] = heights.length;
            }
            
            int w = next[i] - prev[i] - 1;
            int newarea = w*h;
            area = Math.max(newarea , area);
        } 
        
        return area;
    }
    public int maxArea(int M[][], int n, int m) {
        // yaha hmlog start row se area mikal rhe h
        int area = maxAreaUtil(M[0]);
        for(int i = 1 ; i < M.length ; i++){
            for(int j = 0 ; j < M[0].length ; j++){
                // isme agar base zero then us pure col me uska area zero ho jayege
                // nahi toh ussa add hoga
                if(M[i][j] != 0){
                    M[i][j] = M[i][j] + M[i-1][j];
                }
            }
            // phir uska pure row ka area nikal rhe h aur max nikal rhe h
            int newarea = maxAreaUtil(M[i]);
            area = Math.max(newarea , area);
        }
        return area;
    }
}