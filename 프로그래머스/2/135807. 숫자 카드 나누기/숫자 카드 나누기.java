import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static Boolean isDivisible(int num, int[] array) {
        for(int cur : array){
            if((cur % num) != 0){
                return false;
            }
        }        
        return true;
    }
    
    public static Boolean isNotDivisible(int num, int[] array) {
        for(int cur : array){
            if((cur % num) == 0){
                return false;
            }
        }        
        return true;
    }
    
    public static int getMax(int[] arrayA, int[] arrayB){
        int max = arrayA.length;
        int maxA = arrayA[max-1];
        
        List<Integer> listA = getList(maxA);
        
        for(int num : listA){
            if(isDivisible(num, arrayA) == true){
                if(isNotDivisible(num, arrayB) == true){
                    return num;
                }
            }
        }
        
        return 0;
    }
    
    public static List<Integer> getList(int num) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 2 ; i <= num ; i++){
            if((num % i) != 0){
                continue;
            }else {
                list.add(i);
            }
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        return list;
    }
    
    
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int a = getMax(arrayA, arrayB);
        
        int b = getMax(arrayB, arrayA);
        
        answer = Math.max(a,b);
        
        
        
        
        return answer;
    }
}