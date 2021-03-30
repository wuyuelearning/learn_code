package other.dfs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by wuyue on 2021/2/24.
 */
public class Test12 {
    int n =4;
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int vst[][] =new int[n][n];
    int map[][] =new int[][]{{1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}};
    public static void main(String[] args) {
        Test12 test12 =new Test12();
        test12.init();
    }

    private void init(){
        for (int i =0 ;i<n;i++) {
            for (int j = 0; j < n; j++){
                vst[i][j]=0;
            }
        }

        bfs();


    }

    private void bfs(){
        vst[0][0] =1;
        Deque<Node> deque =new LinkedList<>();
        Node node =new Node(0,0,map[0][0]);
        deque.add(node);
        while (!deque.isEmpty()){
//            print(deque);
            Node poll = deque.poll();
            System.out.println(poll.val);
            int x =poll.x;
            int y =poll.y;

            for (int i=0;i<4;i++){
                int m = x+dir[i][0];
                int n = y+dir[i][1];
                if (check(m,n)){
                    Node addNode = new Node(m,n,map[m][n]);
                    deque.addLast(addNode);
                    vst[m][n]=1;
                }
            }
        }
    }

    boolean check(int i,int j){
        return (0<=i && i<n && 0<=j && j<n && vst[i][j] ==0);
    }
    private void print(Deque<Node> deque){
        Object[] objects = deque.toArray();
        for (Object object : objects) {
            Node node = (Node) object;
            System.out.print(node.val+" ");
        }
        System.out.println();

    }
    class Node{
        int x ;int y ;int val;
        Node(int x,int y,int val){
            this.x =x;
            this.y =y;
            this.val =val;
        }
    }
}
