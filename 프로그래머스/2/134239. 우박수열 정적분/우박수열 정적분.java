import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Double> list;
    public static List<Double> dlist;
    public static double[] answer;
    
    public static void getList(int k){
        list = new ArrayList<>();
        dlist = new ArrayList<>();
        double num = (double) k;
        
        list.add(num);
        
        while(num != 1){
            if((num % 2) == 0){
                num = num / 2;
                list.add(num);
                continue;
            }else{
                num = (num * 3) + 1;
                list.add(num);
                continue;
            }
        }
        
        for(int i = 0 ; i < list.size() - 1 ; i++){
            double tmp = (list.get(i) + list.get(i+1)) / 2 ;
            dlist.add(tmp);
        }
    }
    
    public static double getResult(int[] range){
        int start = range[0];
        int end = list.size() + range[1] - 1;
        if(end < start){
            return -1;
        }
        
        double tmp = 0;
        
        for(int i = start ; i < end ; i++){
            tmp += dlist.get(i);
        }
        
        return tmp;
    }
    
    public double[] solution(int k, int[][] ranges) {
        
        getList(k);
        
        answer = new double[ranges.length];
        
        for(int i = 0 ; i < ranges.length ; i++){
            answer[i] = getResult(ranges[i]);
        }
        
       
        
        return answer;
    }
}