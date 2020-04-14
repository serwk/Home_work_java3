package HomeWork4;

public class MyWaitNotify {

    private final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        MyWaitNotify w = new MyWaitNotify();
        Thread t1 = new Thread(() -> {
            w.printLetter('A','B');
        });
        Thread t2 = new Thread(() -> {
            w.printLetter('B','C');
        });
        Thread t3 = new Thread(() -> {
            w.printLetter('C','A');
        });
        t1.start();
        t2.start();
        t3.start();
    }

    public void printLetter(char currentLetter, char nextLetter) {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (this.currentLetter != currentLetter) {
                        mon.wait();
                    }
                    System.out.print(currentLetter);
                    this.currentLetter = nextLetter;
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
