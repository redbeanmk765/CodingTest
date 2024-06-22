import java.util.Set;
import java.util.HashSet;

class Solution {
    public static int[][] array;
    public static void getArray(int[] topping){
        int max = topping.length;
        array = new int[max][2];
        
        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>();
        
        for(int i = 0 ; i < max ; i ++) {
            left.add(topping[i]);
            right.add(topping[max - i - 1]);
            
            array[i][0] = left.size();
            array[max - i - 1][1] = right.size();            
        }
        
    }
    
    public static int getAnswer() {
        int max = 0;
        int count = 0;
        for(int i = 0 ; i < array.length - 1; i ++) {
            if(array[i][0] == array[i+1][1]){
                if(array[i][0] > max){
                    max = array[i][0];
                    count = 1;
                }else if(array[i][0] == max){
                    count++;
                }
            }
        }
        
        return count;
    }
    public int solution(int[] topping) {
        int answer = 0;
        
        getArray(topping);
        answer = getAnswer();
        
        return answer;
    }
}