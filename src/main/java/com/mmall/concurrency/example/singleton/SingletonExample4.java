package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.NotRecommend;
import com.mmall.concurrency.annotations.NotThreadSafe;
import com.mmall.concurrency.annotations.ThreadSafe;

/**
 * @program: concurrency
 * @description: 双检锁模式
 * @author: Ruhong Lin
 **/

@NotThreadSafe
public class SingletonExample4 {
    private SingletonExample4() {

    }

    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance() 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存

    // JVM和cpu优化，发生了指令重排

    // 1、memory = allocate() 分配对象的内存空间
    // 3、instance = memory 设置instance指向刚分配的内存
    // 2、ctorInstance() 初始化对象

    private static SingletonExample4 instance = null;

    public static SingletonExample4 getInstance() {
        if (instance == null) { // 双重检测机制
            synchronized (SingletonExample4.class) { // 同步锁
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
