// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	Stack<Integer> stack = new Stack<>();
    	for(int i=0;i<n;i++) stack.push(i);
    	
    	while(stack.size() > 1){
    	    int v1 = stack.pop();
    	    int v2 = stack.pop();
    	    if(M[v1][v2] == 1){
    	        // if v1 knows v2, then v1 is not celebrity
    	        // so put v2 back as it is a potential celebrity
    	        stack.push(v2);
    	    }else{
    	        stack.push(v1);
    	    }
    	}
    	
    	int p = stack.pop();
    	for(int i=0;i<n;i++){
    	    if(i == p) continue;
    	    if(M[p][i] == 1 || M[i][p] == 0) return -1;
    	}
    	
    	return p;
    }
}