/* 
특정수 기준 좌우로 가장 작은 수가 특정 수보다 모두 작다면?
왼쪽에서 작은수 터트리고 오른쪽에서 작은수 터트리기가 불가능
최후에 터트리는것이 불가능
특정수 기준으로 가장 작은수를 2번 순회해서 구하는건 n^2 -> 안됨
min값을 구하면서 list[i][0] 에 담고 
max값을 list[i][1]에 담는다면? 
순회할때 i 를 a[i] 와 a[a.length - i]로 한다면?

*/

class Solution {
    public static int[][] list;
    
    public void initList(int[] a){
        int minL = 1000000001;
        int minR = 1000000001;
        int n = a.length;
        list = new int[n][2];
        
        for(int i = 0 ; i < n ; i++){
            if(a[i] < minL) minL = a[i];
            if(a[n-i-1] < minR) minR = a[n-i-1];
            list[i][0] = minL;
            list[n-i-1][1] = minR;
        }
    }
    
    public int findBalls(int[] a){
        int count = 0;
        for(int i = 1 ; i < a.length - 1 ; i ++){
            int left = list[i-1][0];
            int right = list[i+1][1];
            
            if(left < a[i] && right < a[i]) count++;
                 
        }
        return count;
    }
    
    public int solution(int[] a) {
        int answer = 0;
        
        initList(a);
        answer = a.length - findBalls(a);
        return answer;
    }
}