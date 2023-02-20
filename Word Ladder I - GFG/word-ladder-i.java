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
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    private class Pair{
        String str;
        int step;
        Pair(String str , int step){
            this.str = str;
            this.step = step;
        }
    }
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Set<String> word = new HashSet<>();
        int n = wordList.length;
        for(int i = 0 ; i < n ; i++){
            word.add(wordList[i]);
        }
        Set<String> visited = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord , 0));
        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Pair temp = q.poll();
            String str = temp.str;
            visited.add(str);
            int step = temp.step;
            if(str.equals(targetWord)){
                ans = Math.min(ans , step);
            }
            int size = str.length();
            for(int i = 0 ; i < size ; i++){
                String tempStr = "";
                for(int j = 0 ; j < 26 ; j++){
                    tempStr = str.substring(0,i) + (char)('a' + j) + str.substring(i+1 , size);
                    if(!visited.contains(tempStr) && word.contains(tempStr)){
                        q.add(new Pair(tempStr , step+1));
                    }
                }
            }
        }
        if(ans == Integer.MAX_VALUE){
            return 0;
        }
        return ans+1;
    }
}