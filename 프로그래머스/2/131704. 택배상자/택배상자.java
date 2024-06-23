import java.util.Stack;

class Solution {
    public static Stack<Integer> main = new Stack<>();
    public static Stack<Integer> sub = new Stack<>();   
    public static int subBox = -1;
    public static int mainBox = -1;
    
    public static Boolean getBox(int order){
        if(!sub.isEmpty()){
            subBox = sub.peek();
        }
        if(!main.isEmpty()){
            mainBox = main.peek();
        }
        
        if(subBox == order){
            sub.pop();
            return true;
        }else{
            if(mainBox == order){
                main.pop();
                return true;
            }else if(mainBox < order){
                for(int i = 0 ; i < order - mainBox ; i++){
                    sub.add(main.pop());
                }
                main.pop();
                return true;                
            }
        }
        
        
        return false;
    }
    
    
    public int solution(int[] order) {
        int answer = 0;
        
        for(int i = order.length ; i >= 1  ; i--) {
            main.add(i);
        }
        
        for(int num : order){
            if(getBox(num)){
                answer++;
            }else{
                break;
            }
        }
        
        
        return answer;
    }
}