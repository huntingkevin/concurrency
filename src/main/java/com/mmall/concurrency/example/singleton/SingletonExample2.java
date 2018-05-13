package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.NotThreadSafe;
import com.mmall.concurrency.annotations.ThreadSafe;

/**
 * @program: concurrency
 * @description: 饿汉模式, 初始化效率比较低
 * @author: Ruhong Lin
 **/

@ThreadSafe
public class SingletonExample2 {
    private SingletonExample2() {

    }

    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance() {
        return instance;
    }
}
