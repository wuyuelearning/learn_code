package other.concurrency;

import sun.misc.LRUCache;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.stream.Collectors;

/**
 * Created by wuyue on 2020/11/30.
 */
public class test {
    public static void main(String[] args) {

//        String s = new String("a") + new String("b");
//        String s2 ="ab";
//        s.intern();
//        System.out.println(s == s2);
//        System.out.println(s2 == "ab");

//        String s1="a";
//        String s2="b";
//        String s3=s1+s2;
//        String s4="ab";
//        System.out.println(s3==s4);//false
//        String s5="a"+s2;
//        System.out.println(s3==s5);//false
//        System.out.println(s4==s5);//true


        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}
