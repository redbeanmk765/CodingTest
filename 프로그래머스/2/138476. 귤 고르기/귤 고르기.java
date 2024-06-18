/*
1.귤의 크기는 연속적이지 않을수 있다. MAP을 사용하자
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public static Map<Integer,Integer> map = new HashMap<>();
    
    public static void enroll(int size) {
        if(!map.containsKey(size)){
            map.put(size,0);
        }
        map.put(size, (map.get(size)+1));
    }
    
    public static int getMin(int k) {
        int max = map.keySet().size();
        
        int[] array = new int[max];
        
        int j = 0;
        for(int key : map.keySet()){
            array[j] = map.get(key);
            j++;
        }
        
        Arrays.sort(array);
        
        int sum = 0;
        
        for(int i = max -1 ; i >=0 ; i--){
            sum += array[i];
            if(k <= sum){
                return max - i;
            }
        }
        
        return k;
    }
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        for(int size : tangerine){
            enroll(size);
        }
        
        answer = getMin(k);
        
        
        return answer;
    }
}