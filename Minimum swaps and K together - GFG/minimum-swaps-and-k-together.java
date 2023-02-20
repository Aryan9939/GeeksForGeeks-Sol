//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    int K = Integer.parseInt(br.readLine());
		    
		    Complete obj = new Complete();
		    int ans = obj.minSwap(arr, sizeOfArray, K);
		    System.out.println(ans);
		}
	}
}

// } Driver Code Ends


//User function Template for Java



class Complete{
    
   
    // Function for finding maximum and value pair
    public static int minSwap (int arr[], int n, int k) {
        int lessThanK = 0;
        int ans = 0;
        // isme window size nikal rhe h ki kitna element chota h k se
        for(int i = 0 ; i < n ; i++){
            if(arr[i] <= k){
                lessThanK++;
            }
        }
        // isme sabse phele ek window bana rhe h taki usko mantain kar sake
        for(int i = 0 ; i < lessThanK ; i++){
            if(arr[i] > k){
                ans++;
            }
        }
        if(ans != 0){
            int temp = ans;
            int j = 0;
            // isme us window size ko maintain karte huwe aage badh rhe h aur dusra sub array us window size ka dekh rhe h 
            for(int i = lessThanK ; i < n ; i++){
                /* isme agar jo element window se bhar ho gaya 
                wo agar chota h aur window me add hone wala element
                bada h tab temp++ ho jayega kyu ki ek bada element add
                ho rha h aur chota remove ho rha h*/
                if(arr[j] <= k && arr[i] > k){
                    temp++;
                }
                /* isme agar jo element nikal rha h wo agar bada h
                aur add hone wala element bada h tab temp -- karge
                kyu ki bada element hat rha h aur chota element add ho rha h*/
                else if(arr[j] > k && arr[i] <= k){
                    temp--;
                }
                // aur agar wo chota mil gaya tab min nikal lege
                ans = Math.min(ans , temp);
                j++;
            }
        }
        return ans;
    }
}
