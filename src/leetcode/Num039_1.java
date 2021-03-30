package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyue on 2021/1/28.
 */
public class Num039_1 {

    public static void main(String[] args) {
        Num039_1 num039 = new Num039_1();
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(num039.combinationSum(candidates, target));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans =new ArrayList<>();
        List<Integer> combine =new ArrayList<>();
        dfs(candidates,target,ans,combine,0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length){
            return;
        }

        if (target == 0){
            ans.add(new ArrayList<Integer>(combine));
        }

        dfs(candidates,target,ans,combine, idx+1);
        if (target-candidates[idx]>=0){
            combine.add(candidates[idx]);
            dfs(candidates,target-candidates[idx],ans,combine,idx);
            combine.remove(combine.size()-1);
        }

    }

}
