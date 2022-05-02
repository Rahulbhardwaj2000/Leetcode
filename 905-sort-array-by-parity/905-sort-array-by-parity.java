class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int i=0,j=0;
        
        while(i<arr.length){
            if(arr[i]%2==0){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
                j++;
            }else{
                i++;
            }
        }
        
        return arr;
    }
}