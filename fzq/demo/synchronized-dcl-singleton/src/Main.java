public class Main {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable, "thread1");
        Thread thread2 = new Thread(myRunnable, "thread2");
        thread1.start();
        thread2.start();
    }
}
class Singleton {
    private volatile static Singleton instance = null;
    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (instance == null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new Singleton();
            }
        }
        return instance;
    }
}
class MyRunnable implements Runnable {
    @Override
    public void run() {
        Singleton singleton = Singleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ": " + singleton);
    }
}
