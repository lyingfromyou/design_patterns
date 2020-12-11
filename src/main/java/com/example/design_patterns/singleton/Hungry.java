package com.example.design_patterns.singleton;

/**
 * 饿汉式
 * 类加载时就实例化，不存在线程安全问题，实例不使用会消耗资源
 */
public class Hungry {

    private final static Hungry hungry = new Hungry();

    private Hungry(){}

    public static Hungry getInstance() {
        return hungry;
    }

}
