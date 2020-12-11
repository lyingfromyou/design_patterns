package com.example.design_patterns.singleton;

/**
 * 懒汉式2
 * getInstance()方法上使用synchronized关键字
 * 线程安全，每次访问都会加锁，效率不高
 */
public class LazyTwo {

    private static LazyTwo lazyTwo;

    private LazyTwo() {
        System.out.println("init");
    }

    public static synchronized LazyTwo getInstance() {
        if (null == lazyTwo) {
            lazyTwo = new LazyTwo();
        }
        return lazyTwo;
    }

}
