class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        
        int units = 0;
        
        for(int i=0;i<boxTypes.length;i++){
            int size = boxTypes[i][0];
            if(truckSize - size < 0){
                units += truckSize*boxTypes[i][1];
                break;
            }
            truckSize -= size;
            units += size*boxTypes[i][1];
        }
        
        return units;
    }
}