package com.itheima;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {
    @Test
    public void testThreadLocalSetAndGet() {
        ThreadLocal<Object> tl = new ThreadLocal<>();

        // 开启两个现场
        new Thread(() -> {
            tl.set("沃里克");
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
        },"蓝色").start();

        new Thread(() -> {
            tl.set("摩托");
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
        },"绿色").start();
    }
}
