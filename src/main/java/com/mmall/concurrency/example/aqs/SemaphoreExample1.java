package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @program: concurrency
 * @description:
 * @author: Ruhong Lin
 **/

@Slf4j
@SuppressWarnings("Duplicates")
public class SemaphoreExample1 {

    private final static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(20);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    test(threadNum);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                } finally {
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int thradNum) throws InterruptedException {
        log.info("{}", thradNum);
        Thread.sleep(1000);
    }
}
