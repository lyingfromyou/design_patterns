package com.example.design_patterns.singleton;

/**
 * 懒汉式1
 * 使用时初始化，多线程时会出现线程安全，会存在两个线程同时
 * 执行 new LazyOne()，初始化两次
 */
public class LazyOne {

    private static LazyOne lazyOne;

    private LazyOne() {
        System.out.println("init");
    }

    public static LazyOne getInstance() {
        if (null == lazyOne) {
            lazyOne = new LazyOne();
        }
        return lazyOne;
    }

}
