package com.example.design_patterns.singleton;

/**
 * 双重检查
 */
public class LazyDCL {

    private LazyDCL() {
        System.out.println("init");
    }

    //一个线程中对该变量的修改 对其他线程可见
    public volatile static LazyDCL lazyDCL = null;

    public static LazyDCL getInstance() {
        if (null == lazyDCL) {
            synchronized (LazyDCL.class) {
                if (null == lazyDCL) {
                    lazyDCL = new LazyDCL();
                }
            }
        }
        return lazyDCL;
    }

}
