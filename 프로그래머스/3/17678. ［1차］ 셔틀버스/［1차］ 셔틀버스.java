/*
타임테이블을 int형 배열로 바꾸고 오름차순
n횟수만큼 버스가 오므로, 각 버스가 올때마다 시간 비교하여 마지막 사람번호 구하기
마지막버스의 자리에 여유가 있다면 정답은 마지막 버스가 온 시간
여유가 없다면(꽉찼다면) 마지막 타임테이블 1분앞

*/
import java.util.Arrays;
class Solution {
    public String makeAnswer(int answerInt){

        int ahour = answerInt / 60;
        int aminute = answerInt % 60;                  
        String shour;
        String sminute;        
                    if(ahour < 10){
                        shour = "0" + ahour;
                    }
                    else{
                        shour = String.valueOf(ahour);
                    }
                    
                    if(aminute < 10){
                        sminute = "0" + aminute;
                    }
                    else{
                        sminute = String.valueOf(aminute);
                    }
                    
                    
                    String answer = shour + ":" + sminute;
                    return answer;
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int[] crew = new int[timetable.length];
        int crewCount = 0;
        
        for(int i = 0 ; i < timetable.length ; i++ ){
            int hour = Integer.parseInt(timetable[i].substring(0,2));
            int minute = Integer.parseInt(timetable[i].substring(3));
            
            crew[i] = hour * 60 + minute;            
        }   
        
        Arrays.sort(crew);
        
        for(int i = 0 ; i < n ; i++){
            int busTime = 540 + i*t;
            for(int busCount = 1 ; busCount <= m ; busCount++){
                if(crew[crewCount] <= busTime){
                    crewCount++;
                }
                else{
                    continue;
                }
                
                if(crewCount >= crew.length){
                    crewCount--;

                    if(i == n-1 && busCount == m){
                        answer = makeAnswer(crew[crewCount] -1);
                        return answer;
                    }
                    else{
                        answer = makeAnswer(540 + ((n-1) * t));
                        return answer;
                    }
                }
                
                if(i == n-1 && busCount == m){
                    crewCount--;
                    answer = makeAnswer(crew[crewCount] -1);
                    return answer;
                }
               
            }   
        }

        answer = makeAnswer(540 + ((n-1) * t));  
        return answer;
    }
}