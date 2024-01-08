package com.tocker.corebase.util;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池工具类
 */
@Component
public class ThreadPoolUtil {
    private int corePoolSize = 10;
    private int maxPoolSize = 10;

    private static ThreadPoolExecutor executor;

    @PostConstruct
    public void initProcessorThreadPool() {
        executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 60, TimeUnit.SECONDS,
                new SynchronousQueue<>(true)   //公平策略 FIFO
                , new BlockRejectExecutionHandler());
    }

    public void submit(Runnable runnable) {
        try {
            executor.getQueue().put(runnable);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //拒绝策略
    private static class BlockRejectExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                //被拒绝放回阻塞队列等待处理
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
