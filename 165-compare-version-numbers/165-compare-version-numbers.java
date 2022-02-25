class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = split(version1);
        String[] v2 = split(version2);
        
        int i=0;
        int min = Math.min(v1.length, v2.length);
       
        while(i<min){
            
            int n1 = Integer.parseInt(v1[i]);
            int n2 = Integer.parseInt(v2[i]);
            if(n1 < n2) return -1;
            else if(n1 > n2) return 1;
            
            i++;
        }
        
        while(i<v1.length){
            int n1 = Integer.parseInt(v1[i]);
            if(n1 > 0) return 1;
            
            i++;
        }
        
        while(i<v2.length){
            int n2 = Integer.parseInt(v2[i]);
            if(n2 > 0) return -1;
            
            i++;
        }
        
        return 0;
    }
    
    public String[] split(String s){
        ArrayList<String> list = new ArrayList<>();
        int i=0, j=0;
        while(j<s.length()){
            char ch = s.charAt(j);
            if(ch == '.'){
                list.add(s.substring(i, j));
                i=j+1;
            }
            j++;
        }
        list.add(s.substring(i,j));
        
        String[] arr = new String[list.size()];
        for(int k=0;k<arr.length;k++) arr[k] = list.get(k);
        
        return arr;
    }
}