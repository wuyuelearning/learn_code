package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 可能出现
 * {[1,4],[0,1]}
 * 的情况
 * 并且
 *
 * {1,2}，{3,8}，{2,7}
 * 要合并成 {1,8}
 *
 * 思路：
 * 通过双端队列 res 和 临时栈 temp 完成，临时栈是用来保存res中元素的，每一轮比较后，会将temp中的元素，回填到res中
 *
 * 例如
 * {1 ，6}  ，{8,10} ，{ 2,9}
 *
 * 假设已经完成{1 ，6}  ，{8,10} 的合并，{1,6}  ，{8,10}已经放在了res中，[1,6,8,10]
 * 之后的看{2,9}如何合并
 *
 * 直观上：
 *
 * 2 大于1，小于6，插入到 {1,6}中间  ， 9 大于 1,6,8 小于10 插入到 {8,10}中间，保留最左边1，和最右边的10， 合并为 {1,10}
 */
public class Num056 {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        Deque<Integer> res = new ArrayDeque<>();
        Stack<Integer> temp =new Stack<>();
        for (int i = 0; i < intervals.length; i++) {
            // 如果res为空，可以直接放入队列中
            if (res.isEmpty()){
                res.addLast(intervals[i][0]);
                res.addLast(intervals[i][1]);
                continue;
            }
            int a =intervals[i][0];
            int b =intervals[i][1];

            int count_a=0;
            int count_b=0;

            while (!res.isEmpty() && a>res.getFirst()){
                count_a++;
                temp.add(res.getFirst());
                res.removeFirst();
            }

            if (count_a%2==0){
                temp.add(a);
            }

            while (!res.isEmpty() && b>=res.getFirst()){
                count_b++;
                res.removeFirst();
            }
            if (count_a%2==1){
                if (count_b%2==1) {
                    temp.add(b);
                }
            } else {
                if (count_b%2==0){
                    temp.add(b);
                }
            }

            while (!temp.isEmpty()){
                int t =temp.pop();
                res.addFirst(t);
            }
        }

        int[][] r = new int[res.size()/2][2];
        int i=0;
        while (!res.isEmpty()){
            r[i][0]=res.pollFirst();
            r[i][1]=res.pollFirst();
            i++;
        }
        return r;
    }
}
