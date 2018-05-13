package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.NotRecommend;
import com.mmall.concurrency.annotations.NotThreadSafe;
import com.mmall.concurrency.annotations.ThreadSafe;

/**
 * @program: concurrency
 * @description: 双检锁模式
 * @author: Ruhong Lin
 **/

@ThreadSafe
public class SingletonExample5 {
    private SingletonExample5() {

    }

    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance() 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存

    private volatile static SingletonExample5 instance = null;

    public static SingletonExample5 getInstance() {
        if (instance == null) { // 双重检测机制
            synchronized (SingletonExample5.class) { // 同步锁
                if (instance == null) {
                    instance = new SingletonExample5(); // 关键是这句导致线程不安全
                }
            }
        }
        return instance;
    }
}
