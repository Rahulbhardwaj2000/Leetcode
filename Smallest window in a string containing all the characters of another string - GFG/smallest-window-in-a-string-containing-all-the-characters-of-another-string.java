// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // we won't match the entire map each time
        // rather just keep a track of the count of characters
        // and keep another map to check if all characters are covered
        
        if(p.length() > s.length()) return "-1";
        
        String ans = "";
        int len = s.length()+1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int i=0, j=0;
        int count = p.length(), matchCount = 0;
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        while(j < s.length()){
            char ch = s.charAt(j);
            if(map2.getOrDefault(ch, 0) < map.getOrDefault(ch, 0)){
                matchCount += 1;
            }
            
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
            
            while(matchCount == count){
                if(j-i+1 < len){
                    ans = s.substring(i, j+1);
                    len = j-i+1;
                }
                
                char ch2 = s.charAt(i);
                i += 1;
                map2.put(ch2, map2.get(ch2)-1);
                if(map2.get(ch2) < map.getOrDefault(ch2, 0)){
                    matchCount--;
                    break;
                }
            }
            
            j++;
        }
        
        if(len == s.length()+1) return "-1";
        
        return ans;
    }
}