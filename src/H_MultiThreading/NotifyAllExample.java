package H_MultiThreading;

public class NotifyAllExample {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(() -> sharedResource.waitForNotification());
        Thread thread2 = new Thread(() -> sharedResource.waitForNotification());
        Thread thread3 = new Thread(() -> sharedResource.performTask());

        thread1.start();
        thread2.start();
        thread3.start();
    }
    static class SharedResource {
        synchronized void performTask() {
            System.out.println(Thread.currentThread().getName() + " is performing a task.");
            notifyAll();  // Notify all waiting threads
        }

        synchronized void waitForNotification() {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting for notification.");
                wait();  // Release the lock and enter the waiting state
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " received notification.");
        }
    }


}
