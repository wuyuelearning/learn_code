package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wuyue on 2021/4/3.
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  思路：将每一个string 重新排序，如果字母相同，排序结果就会相同
 *   ，再以排序后的string，为key，存入相同的map中
 *
 *   时间长，内存占用很高
 *
 */
public class Num049 {
    public static void main(String[] args) {
        Num049 n = new Num049();
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = n.groupAnagrams(s);
        System.out.println(lists);
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0)
            return res;

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // 排序
            String afterChange = change(str);
            if (!map.containsKey(afterChange)) {
                List<String> set = new ArrayList<>();
                set.add(str);
                map.put(afterChange, set);
            } else {
                List<String> set = map.get(afterChange);
                set.add(str);
                map.put(afterChange,set);
            }
        }
        Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, List<String>> next = iterator.next();
            res.add(next.getValue());
        }
        return res;
    }

    private String change(String s) {
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char aChar : chars) {
            list.add(aChar);
        }
        list = list.stream().sorted().collect(Collectors.toList());
        StringBuilder ss =new StringBuilder();
        for (Character character : list) {
            ss.append(character);
        }
        return ss.toString();
    }
}
