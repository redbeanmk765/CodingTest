/*
1. a의 길이는 50만. 단순하게 모든 경우를 고려할수는 없다.
2. 모든 집합은 교집합이 1개 이상 있어야함
>특정 정수가 1개가 최대로 배열을 만들수 있을때가 최선.
3. 각 수마다 몇개있는지를 hashMap으로 기록.
4. 정수의 수 x 수열의 길이 2중 for문 부분수열 발견시 i증가로 중복 제거
5. 만약 기존에 더 큰 값이 구해졌다면(정수의 수보다 큰) 다음 정수
*/

import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public static int max;
    public static HashMap<Integer, Integer> map;
    
    public static void getNumMap(int[] a){
        map = new HashMap<Integer, Integer>();
        for(int num : a){
            if(map.containsKey(num)){
                int tmp = map.get(num);
                map.put(num,tmp+1);
            }else{
                map.put(num,1);
            }
        }
    }
    
    public static void getMax(int[] a){
        for(Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            
            if(max >= value) continue;
            
            int count = 0;
            for(int i = 0 ; i < a.length-1 ; i++){
                if(a[i] != key && a[i+1] != key) continue;
                if(a[i] == a[i+1]) continue;
                
                count++;
                i++;
            }
            
            if(max < count) max = count;
        }
    }
    public int solution(int[] a) {
        getNumMap(a);
        
        getMax(a);
        
        return max * 2;
    }
}