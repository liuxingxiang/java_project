package com.java.Sync;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Description 自定义独占式锁
 * @Author Liu Xing Xiang
 * @Date 2020/6/11 16:19
 **/
public class PlainLock {
    private static final int STATE_0 = 0;
    private static final int STATE_1 = 1;
    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(STATE_0, arg);
        }
        @Override
        protected boolean tryRelease(int arg) {
            setState(arg);
            return true;
        }
        @Override
        protected boolean isHeldExclusively() {
            return getState() == STATE_1;
        }
    }

    private Sync sync = new Sync();

    public void lock() {
        sync.acquire(STATE_1);
    }

    public void unlock() {
        sync.release(STATE_0);
    }
}
