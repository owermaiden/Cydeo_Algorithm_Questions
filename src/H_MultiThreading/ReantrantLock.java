package H_MultiThreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReantrantLock {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(() -> sharedResource.waitForNotification());
        Thread thread2 = new Thread(() -> sharedResource.performTask());

        thread1.start();
        thread2.start();
    }

    static class SharedResource {
        private final Lock lock = new ReentrantLock();
        private final Condition notification = lock.newCondition();

        void performTask() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " is performing a task.");
                notification.signalAll();  // Notify waiting threads
            } finally {
                lock.unlock();
            }
        }

        void waitForNotification() {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting for notification.");
                notification.await();  // Release the lock and enter the waiting state
                System.out.println(Thread.currentThread().getName() + " received notification.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


}
