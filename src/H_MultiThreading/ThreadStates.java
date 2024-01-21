package H_MultiThreading;

public class ThreadStates {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            sharedResource.performTask();
            sharedResource.notifyOtherThread();
        });

        Thread thread2 = new Thread(() -> {
            sharedResource.waitForNotification();
        });

        thread1.start();
        thread2.start();
    }
    static class SharedResource {
        synchronized void performTask() {
            System.out.println(Thread.currentThread().getName() + " is performing a task.");
            // Simulating some work
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized void waitForNotification() {
            System.out.println(Thread.currentThread().getState().name() + " is waiting for notification.");
            try {
                // Entering the waiting state
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " received notification.");
        }

        synchronized void notifyOtherThread() {
            System.out.println(Thread.currentThread().getName() + " notifying waiting thread.");
            // Notifying the waiting thread
            notify();
        }
    }


}
