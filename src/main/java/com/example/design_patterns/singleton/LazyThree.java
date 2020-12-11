package com.example.design_patterns.singleton;

/**
 * 懒汉式3
 * 调用getInstance()的时候，初始化静态内部类
 */
public class LazyThree {

    private LazyThree() {
        System.out.println("init");
    }

    public static final LazyThree getInstance() {
        return LazyHolder.lazy;
    }

    public static class LazyHolder {
        private static final LazyThree lazy = new LazyThree();
    }


}
