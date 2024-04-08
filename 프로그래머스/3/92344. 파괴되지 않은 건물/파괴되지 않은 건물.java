/*
1. skill의 수가 너무많다. 계산을 줄여야한다
>누적합 기법 사용
2. 누적합을 위한 새로운 board 만들기
> board의 길이보다 1 크게 하여 널포인트 방지
3. 
*/

class Solution {
    public static int[][] sumBoard;
    public static int count;
    
    public static void init(int[][] board){
        sumBoard = new int[board.length+1][board[0].length+1];
    }
    
    public static void getSum(int[] s){
        int sign = (s[0] == 1) ? -1 : 1 ;
        
        sumBoard[s[1]][s[2]] += (sign * s[5]);
        sumBoard[s[1]][s[4]+1] += (-1) * (sign * s[5]);
        sumBoard[s[3]+1][s[2]] += (-1) * (sign * s[5]);
        sumBoard[s[3]+1][s[4]+1] += (sign * s[5]);  
    }
    
    public static void doSum(int[][] board){
        for(int r = 0 ; r < sumBoard.length -1 ; r++){
            for(int c = 0 ; c < sumBoard[0].length -1 ; c++){
                sumBoard[r][c+1] += sumBoard[r][c];
            } 
        }
        
        for(int r = 0 ; r < sumBoard.length -1 ; r++){
            for(int c = 0 ; c < sumBoard[0].length -1 ; c++){
                sumBoard[r+1][c] += sumBoard[r][c];
            } 
        }
        
        for(int r = 0 ; r < board.length ; r++){
            for(int c = 0 ; c < board[0].length; c++){
                board[r][c] += sumBoard[r][c];
                if(board[r][c] > 0) count++;
            } 
        }
        
        
    }
    
    public int solution(int[][] board, int[][] skill) {
        
        init(board);
        
        for(int[] s : skill){
            getSum(s);
        }
                        
        doSum(board);
        
        return count;
    }
}