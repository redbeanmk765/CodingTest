import java.util.Set;
import java.util.HashSet;

class Solution {
    public static Set<Integer> set = new HashSet<>();
    public static int[] array;
    public static int[] elementsCopy;
    
    public static void getAnswer(int length){
        for(int l = 0 ; l < length - 1 ; l++){
            for(int i = 0 ; i < array.length ; i++){
                set.add(getSum(i, l));
            }
        }
        
        int sum = array[0] + elementsCopy[length - 1];
        set.add(sum);
    }          
    public static int getSum(int index, int length){
        int max = array.length;
        int pos = index + length;
        
        if(pos >= max){
            pos = pos - max;
        }
        
        array[index] = array[index] + elementsCopy[pos];
        //System.out.println(index + " " + length + " " + array[index]);
        
        return array[index];
    }
    
    public int solution(int[] elements) {
        elementsCopy = elements;       
        array = new int[elements.length];
        
        getAnswer(elements.length);
        
        
        
        return set.size();
    }
}