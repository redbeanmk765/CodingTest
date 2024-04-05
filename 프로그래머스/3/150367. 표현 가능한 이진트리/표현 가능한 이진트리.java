/*
1. 주어진 숫자를 2진수로 변경 -> 10의 15승인데? 충분히 가능한 길이
2. 2진수로의 변환은 string? int[]? vector
>string을 써서 맨앞에 0 추가를 용이하게
3. 이후 루트노드(한가운데수) 부터 좌우로 나누어 자식노드 탐색
4. 부모노드가 0일때 자식중에 1이 존재한다? false 반환

-> 오류발생
이진포화트리로 만드는법?
left 또는 right의 개수가 이진포화의 수
이진포화의 수가 아니라면 0은 어떻게? 
1 3 7 15 == 2의 n승 -1 
*/

class Solution {
    public static int check(String str){
        
        if(str.length() == 1){
            return 1;
        }
        
        int parent = (str.length() / 2);
        
        String left = str.substring(0,parent);
        String right =  str.substring(parent+1);
          
        if(str.charAt(parent) == '0'){
            if(left.contains("1") || right.contains("1")){
                return 0;
            }
        }
        
        if(check(left) != 0 && check(right) != 0){
            return 1;
        }
        
        return 0;
    }
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0 ; i < numbers.length ; i++){
            String binaryString = Long.toBinaryString(numbers[i]);
            int length = binaryString.length();
            
            int log2 = (int)(Math.log(length) / Math.log(2));
            int length2 = (int)Math.pow(2,log2+1) -1;
            
            int dummyLength = length2 - length;
            
            String dummy = "";
            
            for(int n = 0 ; n < dummyLength ; n++){
                dummy = "0" + dummy;
            }
            
            binaryString = dummy + binaryString;

            answer[i] = check(binaryString);
            
        }
        return answer;
    }
}