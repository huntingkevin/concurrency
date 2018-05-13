package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.Recommend;
import com.mmall.concurrency.annotations.ThreadSafe;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * @program: concurrency
 * @description: 枚举模式：最安全
 * @author: Ruhong Lin
 **/

@ThreadSafe
@Recommend
public class SingletonExample7 {
    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 singleton;

        // JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }

}
