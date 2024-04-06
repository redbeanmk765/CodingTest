/*
1. 숫자가 매우크다. 이분탐색을 고려해보자
2. 우선적으로 gems에서 다른 보석의 수를 구해야 할까? 그를 위해선 뭐가 제일 효율적일까? 
3. 이분탐색으로 left = 보석수, right = gems의 길이 로 탐색. check를 위해선 단순하게 맨 앞에서 부터 한칸식 슬라이드 하여 그 값으로 가능한지?
> 슬라이드 할때는 어떤 자료구조? dequeue? 
4. hashSet으로 하는거랑 string[]로 하는거랑 어느쪽이 중복체크에 유리한가?  > hashSet쓰자
> 그렇게 할려고 했는데 슬라이드가 이동시 string이 사라졌는지 체크해야함. hashMap을 써보자
5. 필요한 함수 : 이분탐색 = main에서 코드로, 최초 보석의 종류가 몇개인지 메소드, 이분탐색으로 얻은 수만큼 gems 슬라이드 이동.

>> 틀렸다. 슬라이드 탐색자체가 너무 오래걸린다. 첫 순회에서 index를 구해보자
1. 각 보석별로 마지막으로 등장한 위치를 구해보자.
2. start가 0이라 가정했을때, 최초의 end는? 
>매번 순회한 곳이 end라 할수있다. 
3. 그렇다면 start는 언제 갱신? start == end 일때 start는 갱신된다.
> start의 갱신은 map의 value중 가장 작은 값이다. 
*/
import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public static HashMap<String, Integer> map;
    
    public static int getMin() {
        int min = 100001;
        for (Entry<String, Integer> entry : map.entrySet()) {
            min = Math.min(min, entry.getValue());
        }
        return min == 100001 ? 0 : min;
    }

    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        map = new HashMap<String, Integer>();
        int start = 0 , end = 0;
        
        for(int i = 0 ; i < gems.length ; i++){
            if(!map.containsKey(gems[i])){
                map.put(gems[i], i);
                end = i;
                answer = new int[]{start+1, end+1};
            }else{
                map.put(gems[i], i);
                end = i;
                if(gems[start].equals(gems[i])){
                    start = getMin();
                    if((answer[1]- answer[0]) > end - start){
                        answer = new int[]{start+1, end+1};
                    }
                }
            }
        }
         
       
        return answer;
    }
}