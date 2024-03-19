class Solution {
    public static int[] left;
    public static int[] right;
    public static int maxSum;
    
    public void sumInit(int[] cookie){
        maxSum = 0;
        int max = cookie.length-1;
        left = new int[max+1];
        right = new int[max+1];
        
        left[0] = cookie[0];
        right[max] = cookie[max];
        
        for(int i = 1 ; i <= max ; i++){
            left[i] = left[i-1] + cookie[i];
            right[max-i] = right[max-i+1] + cookie[max-i];
        }
    }
    
    public void getMax(int[] cookie){
        int max = cookie.length-1;
        
        if(max == 1){
            if(cookie[0] == cookie[1]){
                maxSum = cookie[0];
                return;
            }
        }
        
        for(int i = 0 ; i < max ; i++){
            findEqual(cookie, i);
        }
    }
    
    public void findEqual(int[] cookie, int index){
        int leftSum = left[index];
        int rightSum = right[index+1];
        
        int leftIndex = 0;
        int rightIndex = cookie.length - 1;
        
        while(true){
            if(leftSum < maxSum || rightSum < maxSum) return;
            
            if(leftSum == rightSum){
                if(leftSum > maxSum) maxSum = leftSum;
                return;
            }
            else if(leftSum > rightSum){
                leftSum = leftSum - cookie[leftIndex];
                leftIndex++;
                if(leftIndex > index) return;
            }
            else{
                rightSum = rightSum - cookie[rightIndex];
                rightIndex--;
                if(rightIndex < index+1) return;
            }
        }
    }
    
    public int solution(int[] cookie) {
        sumInit(cookie);
        getMax(cookie);

        
        return maxSum;
    }
}