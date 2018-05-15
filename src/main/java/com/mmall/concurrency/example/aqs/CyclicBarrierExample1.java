package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: concurrency
 * @description:
 * @author: Ruhong Lin
 **/

@Slf4j
@SuppressWarnings("Duplicates")
public class CyclicBarrierExample1 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("Exception", e);
                }
            });
        }
    }

    private static void race(int i) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready", i);
        cyclicBarrier.await();
        log.info("{} continue", i);
    }
}
