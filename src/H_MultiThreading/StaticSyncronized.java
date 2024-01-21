package H_MultiThreading;

public class StaticSyncronized {

    public static void main(String[] args) {
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();

        // Creating two threads
        Thread thread1 = new Thread(() -> obj1.staticMethod());
        Thread thread2 = new Thread(() -> obj2.instanceMethod());

        // Starting the threads
        thread1.start();
        thread2.start();
    }
    static class MyClass {
        // Static synchronized method
        public static synchronized void staticMethod() {
            System.out.println("Static method: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Non-static synchronized method
        public synchronized void instanceMethod() {
            System.out.println("Instance method: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
