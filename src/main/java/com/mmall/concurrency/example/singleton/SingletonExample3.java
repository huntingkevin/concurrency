package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.NotRecommend;
import com.mmall.concurrency.annotations.NotThreadSafe;
import com.mmall.concurrency.annotations.ThreadSafe;

/**
 * @program: concurrency
 * @description: 懒汉模式
 * @author: Ruhong Lin
 **/

@ThreadSafe
@NotRecommend
public class SingletonExample3 {
    private SingletonExample3() {

    }

    private static SingletonExample3 instance = null;

    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
