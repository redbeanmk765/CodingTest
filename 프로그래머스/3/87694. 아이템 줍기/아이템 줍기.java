import java.util.HashSet;

class Solution {
    public static int[][] board;
    public static int[] dirX;
    public static int[] dirY;
    public static int min;
    public static HashSet<int[]> set;
    public static int ItemX;
    public static int ItemY;
    
    public static void initBoard(int[][] rectangle){
        board = new int[101][101];
        dirX = new int[] {1,0,-1,0};
        dirY = new int[] {0,-1,0,1};
        min = 1000;
        set = new HashSet<>();
        
        for(int[] box : rectangle){
            int minX = box[0] * 2;
            int minY = box[1] * 2;
            int maxX = box[2] * 2;
            int maxY = box[3] * 2;
            
            for(int x = minX ; x <= maxX ; x++){
                if(board[x][minY] < 1) board[x][minY] = 1;
                if(board[x][maxY] < 1) board[x][maxY] = 1;
            }
            
            for(int y = minY ; y <= maxY ; y++){
                if(board[minX][y] < 1) board[minX][y] = 1;
                if(board[maxX][y] < 1) board[maxX][y] = 1;
            }
            
            for(int x = minX + 1 ; x <= maxX - 1 ; x++){
                for(int y = minY + 1 ; y <= maxY -1 ; y++){
                    if(board[x][y] < 2) board[x][y] = 2;
                }
            }
        }
    }
    
    public void bfs(int x, int y, int count){
        
        if(min <= count) return;
        if(x == ItemX && y == ItemY){
            min = count;
            return;
        }
        
        set.add(new int[] {x, y}); 
        //System.out.println(count);
        //System.out.print(x + " " + y + " " + board[x][y] + " / ");
        
        loop1:
        for(int i = 0 ; i < 4 ; i ++){
            int dx = dirX[i];
            int dy = dirY[i];
            int nx = x + dx;
            int ny = y + dy;
            
            //System.out.println(nx + " " + ny + " "); 
            
            if(nx < 0 || ny <  0 || nx > 100 || ny > 100 ){
                continue loop1;
            }
            
            if(board[nx][ny] == 1){ 
                for(int[] point : set){
                    if(point[0] == nx && point[1] == ny){
                        continue loop1;
                    }
                }
                //System.out.print(" tt / ");
                 
                bfs(nx,ny,count+1);
            }
        }
        return;
    }
    
    public int solution(int[][] rectangle, int X, int Y, int itemX, int itemY) {
        int answer = 0;
        ItemX = 2 * itemX;
        ItemY = 2 * itemY;
        
        initBoard(rectangle);
        /*for(int y = 20 ; y >= 0 ; y--){            
            for(int x = 0 ; x <= 20 ; x++){
                System.out.print(board[x][y] + " ");
            }
             System.out.println();
        }*/

        set.add(new int[] {2 * X, 2 * Y});        
        
        bfs(2 * X, 2 * Y,0);
        
        answer = min / 2;
        return answer;
    }
}