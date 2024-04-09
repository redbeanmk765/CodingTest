/*
1. A와 B를 내림차순으로 한다
2. A를 기준으로 순회하되, B의 index를 증가시키며 순회. 
> A보다 B가 크다면 answer증가 , 아니라면 B의 인덱스는 그대로 두고 다음 순회
3. A의 순회를 마치면 끝
*/
import java.util.Arrays;

class Solution {
    public static void reverse(int[] arr){
        Arrays.sort(arr);
        
        for(int i = 0 ; i < arr.length / 2 ; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        
    }
    
    public static int getScore(int[] A, int[] B){
        int count = 0;
        int b = 0;
        for(int i = 0 ; i < A.length ; i++){
            //System.out.println(A[i] + " " +  B[b]);
            if(A[i] < B[b]){
                count++;
                b++;
                continue;
            }else{
                continue;
            }
        }
        return count;
    }
    public int solution(int[] A, int[] B) {
        int answer = -1;
        
        reverse(A);
        reverse(B);
        
        answer = getScore(A,B);
        
        return answer;
    }
}