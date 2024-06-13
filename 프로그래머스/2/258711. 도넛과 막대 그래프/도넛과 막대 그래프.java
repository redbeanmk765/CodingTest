/*
1.나가는 선 - 들어온선 이 2 이상인 지점이 생성된 지점
2. 막대형은 쭉 따라갔을때 막다른 지점, 8자는 나가는 간선이 2개인 지점, 도넛은 시작지점
3. 생성된 지점으로부터 나간 간선의 수가 그래프의 총 수

*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, int[]> nodeCnt = new HashMap<>();
    	int[] answer = {0, 0, 0, 0};
    	
    	Arrays.stream(edges).forEach(edge -> {
    		int a = edge[0];
    		int b = edge[1];
    		if(!nodeCnt.containsKey(a)) {
    			nodeCnt.put(a, new int[] {0, 0});
    		}
    		if(!nodeCnt.containsKey(b)) {
    			nodeCnt.put(b, new int[] {0, 0});
    		}
    		// 가는것, 들어오는것 카운터임
    		nodeCnt.get(a)[0] += 1;
    		nodeCnt.get(b)[1] += 1;
    	});
    	
    	int[] cnts;
    	for(int key : nodeCnt.keySet()) {
    		cnts = nodeCnt.get(key);
    		
    		// 들어오션 노드가 없고 나가는 노드가 2개 이상일때 정점이 된다.
    		if(cnts[0] >= 2 && cnts[1] == 0 ) {
    			answer[0] = key;
    		// 들어오는 정점의 개수가 막대 그래프임 개수
    		}else if(cnts[0] == 0 && cnts[1] > 0) {
    			answer[2]++;
    		// 들어오는것 나가는것 각 2개 이상인 점의 개수는 8자 그래프의 개수
    		}else if(cnts[0] >= 2 && cnts[1] >= 2) {
    			answer[3]++;
    		}
    	
    	}
    	
    	// 점정 나가는 노드 수가 막대와 8자를 제외한것이 도넛 그래프의 개수
        answer[1] = nodeCnt.get(answer[0])[0] - answer[2] - answer[3];
        
        return answer;
    }
}