package com.mmall;

import java.util.Comparator;

/**
 * @program: concurrency
 * @description:
 * @author: Ruhong Lin
 **/

public class Test {
    Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    };

    Comparator<Integer> comparator2 = Comparator.naturalOrder();
    String str1 = "abc";
    String str2 = "abc";
    Integer i1 = 1;
    Integer i2 = 2;
}
