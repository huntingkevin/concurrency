package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.ThreadSafe;

/**
 * @program: concurrency
 * @description: 饿汉模式, 初始化效率比较低
 * @author: Ruhong Lin
 **/

@ThreadSafe
public class SingletonExample6 {
    private SingletonExample6() {

    }

    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
