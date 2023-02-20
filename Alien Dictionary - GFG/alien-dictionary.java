//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        String ans = "";
        //int n = dict.length;
        int[] indeg = new int[26];
        int[] isPresent = new int[26];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i < 26 ; i++){
            indeg[i] = -1;
            isPresent[i] = -1;
            adjList.add(new ArrayList<>());
        }
        for(int i = 0 ; i < N-1 ; i++){
            String str1 = dict[i];
            String str2 = dict[i+1];
            int idx = Math.min(str1.length() , str2.length());
            for(int j = 0 ; j < idx ; j++){
                if(str1.charAt(j) != str2.charAt(j)){
                    isPresent[str1.charAt(j) -'a'] = 1;
                    isPresent[str2.charAt(j) -'a'] = 1;
                    adjList.get(str1.charAt(j)-'a').add(str2.charAt(j)-'a');
                    break;
                }
            }
        }
        for(int i = 0 ; i < 26 ; i++){
            if(isPresent[i] == 1){
                indeg[i] = 0;
            }
        }
        for(int i = 0 ; i < 26 ; i++){
            for(int item : adjList.get(i)){
                indeg[item]++;
            }
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < 26 ; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int temp = q.poll();
            ans = ans + (char)(temp+'a');
            for(int item : adjList.get(temp)){
                indeg[item]--;
                if(indeg[item] == 0){
                    q.add(item);
                }
            }
        }
        return ans;
    }
}