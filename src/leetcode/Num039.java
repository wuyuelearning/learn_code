package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by wuyue on 2021/1/26.
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 *
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num039 {

    public static void main(String[] args) {
        Num039 num039 = new Num039();
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(num039.combinationSum(candidates, target));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int[] n = Arrays.stream(candidates).sorted().toArray();
        for (int i = 0; i < n.length; i++) {
            if (n[i] <= target) {
                //  target 无法由 n[i] 及 n[i]右边的数字（n[i]大）组成
                if (2 * n[i] > target) {
                    break;
                }
                ArrayList<Integer> integers = new ArrayList<>();
                List<Integer> resList = fun(i, n, target , integers);
                res.add(resList);
            }
        }
        return res;
}

    private List<Integer> fun(int m, int[] n, int target, List<Integer> list) {
        for (int i = m; i < n.length; i++) {
            if (n[i] <= target) {
                if (2 * n[i] > target) {
                    return list;
                }
                if (target % n[m] == 0) {
                    list.add(n[m]);
                }
                if (n[m] < target) {
                    for (int j = 1; j < target / n[m]; j++) {
                        fun(m + 1, n, target - j * n[m], list);
                    }
                }
            }
        }
        return list;
    }


}
