class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int i=0;
        ArrayList<int[]> ans = new ArrayList<>();
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i += 1;
        }
        
        while(i<intervals.length && newInterval[0] <= intervals[i][1] && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i += 1;
        }
        
        ans.add(newInterval);
        
        while(i < intervals.length){
            ans.add(intervals[i]);
            i += 1;
        }
        
        int[][] arr = new int[ans.size()][2];
        for(int j=0;j<arr.length;j++){
            arr[j] = ans.get(j);
        }
        
        return arr;
    }

}