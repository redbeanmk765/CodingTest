/*
1. 가장 큰 길이부터 팰린드롬이 나올때까지 체크. 나오면 답

*/

class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        int length = s.length() - 1;
        char[] chars = s.toCharArray();
        
        for(int i = length ; i > 0 ; i-- ){
            for(int j = 0 ; j <= length - i ; j++){
                if(chars[j] != chars[j+i]) continue;
                else{
                    int left = j;
                    int right = j+i;
                    int mid = (left + right) / 2;
                    for(int k = 0 ; k <= mid - left ; k++){
                        if(chars[left + k] != chars[right - k]) break;
                        if(k == mid - left){
                            return i+1;
                        }
                    }
                }
            }
        }


        return answer;
    }
}