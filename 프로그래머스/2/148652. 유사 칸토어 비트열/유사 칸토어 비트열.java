/*
1. 정답 = r - (l-1)
2. r의 값을 5진수로 바꾼다
3. 앞에서 부터 각 몇번째 블럭에 위치함을 나타내는데, 3은 0으로만 되어있으므로
    3 ->2, 4-> 3이 된다, 
4. 그리고 앞자리에서 2가 나오게 된다면 이후 자리수는 모두 0으로만 이루어져 있음으로 0으로 바꾼다
5. 이를 다시 4진수로 취급하여 10진수로 변환하면 1의개수이다.
*/
import java.util.Arrays;
import java.util.stream.*;

class Solution {  
    public static long get(long loc) {
        String string5 = Long.toString(loc, 5);
        
        System.out.println(string5);
        
        int[] array = Stream.of(string5.split("")).mapToInt(Integer::parseInt).toArray();
        
        Boolean isThird = false;
        
        for(int i = 0 ; i < array.length; i++){
            if(isThird){
                array[i] = 0;
                continue;
            }
            int cur = array[i];
            if(cur == 2){
                isThird = true;
                continue;
            }else if(cur >= 3){
                cur--;
                array[i] = cur;
            }
        }
        
        Long four = 1L;
        Long sum = 0L;
        
        for(int i = array.length-1 ; i >= 0; i--){
            Long cur = Long.valueOf(array[i]);
            sum += cur * four;
            four = four * 4L;
        }
    
        
        /*String string4 = Arrays.toString(array).replace("[","").replace("]","").replace(",","").replace(" ","");
        
        System.out.println(string4);*/
        
        return sum;
    }
    
    public Long solution(int n, long l, long r) {
        Long answer =  get(r) - get(l-1);

       
        
        return answer;
    }
}