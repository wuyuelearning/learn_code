package other.dfs;

import other.test.time.Test;

/**
 * Created by wuyue on 2021/2/23.
 */
public class Test11 {
    int n =5;
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int vst[][] =new int[n][n];
    int map[][] =new int[][]{{0,0,1,1,0},
            {1,0,0,1,1},
            {1,1,0,0,0},
            {1,0,0,1,1},
            {0,0,1,0,0}};
    public static void main(String[] args) {
        Test11 test11 =new Test11();
        test11.init();

    }

    private void init(){
        for (int i = 0;i<n;i++){
            for (int j=0;j<n;j++){
                vst[i][j]=0;
            }
        }
        dfs(0,0);
        for (int i = 0;i<n;i++){
            for (int j=0;j<n;j++){
                if (vst[i][j]==1){
                    System.out.println( "("+i+","+j+")");
                }
            }
        }

    }

    private void dfs (int x ,int y){
        vst[x][y] =1;
        for (int i =0;i<4;i++){
           if (check(x+dir[i][0],y+dir[i][1])){
               dfs(x+dir[i][0],y+dir[i][1]);
           }
        }

    }
    boolean check(int x ,int y){
     return (0<=x && x<=n-1 && 0<=y && y<=n-1 && vst[x][y] == 0 && map[x][y] ==0);
    }
}
