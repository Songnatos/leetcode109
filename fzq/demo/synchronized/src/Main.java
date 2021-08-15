public class Main {

    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable, "thread1");
        Thread thread2 = new Thread(myRunnable, "thread2");

        thread1.start();
        thread2.start();
    }
}

class MyRunnable implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + ++count);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
