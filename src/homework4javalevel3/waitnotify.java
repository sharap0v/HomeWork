package homework4javalevel3;


public class waitnotify {

    volatile int status = 0;
    public static void main(String[] args) {
        waitnotify lock = new waitnotify();
        Thread t1 = new Thread(new Task("A", lock));
        Thread t2 = new Thread(new Task("B", lock));
        Thread t3 = new Thread(new Task("C", lock));
        t1.start();
        t2.start();
        t3.start();
    }
}

class Task implements Runnable {

    private String message;
    private final waitnotify lock;

    Task(String text, waitnotify obj) {
        message = text;
        this.lock = obj;
    }
    @Override
    public void run() {
        while(lock.status < 13) {
            synchronized (lock) {
                while(!((lock.status % 3) == 0) && message.equals("A")){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while(!((lock.status % 3) == 1) && message.equals("B")){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while(!((lock.status % 3) == 2) && message.equals("C")){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(message);
                lock.status++;
                lock.notifyAll();
            }
        }
    }
}