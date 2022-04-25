class Solution {
    int mod = 1000000007;
    public int threeSumMulti(int[] arr, int target) {
        long count = 0L;
        for(int i=0;i<arr.length;i++){
            int t = target - arr[i];
            HashMap<Integer, Integer> map = new HashMap<>(); // number, freq
            for(int j=i+1;j<arr.length;j++){
                int left = t - arr[j];
                if(map.containsKey(left)){
                    long c = count;
                    count = (count + map.get(left))%mod;
                    //System.out.println(arr[i] + ", " + arr[j] + ", " + left + " Count: "+(count-c));
                }
                
                map.put(arr[j], map.getOrDefault(arr[j], 0)+1);
            }
        }
        
        return (int)count;
    }
}