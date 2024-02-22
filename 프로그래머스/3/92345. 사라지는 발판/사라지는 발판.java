import java.util.List;
import java.util.ArrayList;

class Solution {
    public int N, M, INF = 1000000000;
    public int[][] boardGlobal;
    public int[] dx = {1,0,-1,0};
    public int[] dy = {0,-1,0,1};
    
    public int search(int ax, int ay, int bx, int by, boolean turn){
        int cx = turn ? ax : bx;
        int cy = turn ? ay : by;
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < 4 ; i ++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || boardGlobal[nx][ny] == 0) continue;
            
            if (ax == bx && ay == by) {
                list.add(1);
                continue;
            }
            
            boardGlobal[cx][cy] = 0;
            int res;
            if (turn) res = -search(nx, ny, bx, by, !turn);
            else res = -search(ax, ay, nx, ny, !turn);
            if (res >= 0) res++;
            else res--;
            list.add(res);
            boardGlobal[cx][cy] = 1;
        }
        
        int result;
        int pMax = -INF, pMin = INF;
        int mMax = -INF, mMin = INF;
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (num > 0) {
                pMax = Math.max(pMax, num);
                pMin = Math.min(pMin, num);
            } else {
                mMax = Math.max(mMax, num);
                mMin = Math.min(mMin, num);
            }
        }

        if (pMax == -INF && mMax == -INF) return 0;
        else if (pMax == -INF) return mMin;
        else if (pMax != -INF) return pMin;
        else return 0;
        
        

        
    }
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        int answer = -1;
        N = board.length;
        M = board[0].length;
        boardGlobal = board;
        
        answer = Math.abs(search(aloc[0], aloc[1], bloc[0], bloc[1], true));
        
        return answer;
    }
}