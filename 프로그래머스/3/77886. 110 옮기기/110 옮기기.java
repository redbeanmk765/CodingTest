import java.lang.StringBuilder;
import java.util.Stack;
import java.util.Collections;

class Solution {
    public static int count;
    
    public String delete(String str){
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0 ; i < str.length() ; i++ ){
            if(stack.size() < 2){
                stack.push(str.charAt(i));
                continue;
            }
            
            if(str.charAt(i) == '0'){
                char before = stack.pop();
                
                if(before == '1' && stack.peek() == '1'){
                    stack.pop();
                    count++;
                    continue;
                    
                }else{
                    stack.push(before);
                }
            }
            
            stack.push(str.charAt(i));
            
        }
        
        Collections.reverse(stack);
        
        StringBuilder sb = new StringBuilder();
        
        int lastZero = -1;
        int index = 0;
        while (!stack.isEmpty()) {
            char tmp = stack.pop();
            if(tmp == '0'){
                lastZero = index;
            }
            sb.append(tmp);
            index++;
        }
         //System.out.println(lastZero);
        if(lastZero != -1){
            lastZero++;
        }else{
            lastZero = 0;
        }
        
        for(int i = 0 ; i < count ; i++){
            sb.insert(lastZero,"110");
        }
 
        String returnStr = sb.toString();
        //System.out.println(returnStr);
        
        return returnStr;
    }
    
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        int i = 0;
        for(String str : s){
            
            count = 0;
            str = delete(str);
            answer[i] = str;
            i++;
            
        }
        
        
        return answer;
    }
}