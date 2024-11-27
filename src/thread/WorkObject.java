package thread;

public class WorkObject {
    public synchronized void methodB() {
        System.out.println("ThreadB의 methodB 작업 실행");
        notify(); // Notify another thread waiting on this object
        try {
            wait(); // Wait until notified by another thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void methodC() {
        System.out.println("ThreadC의 methodC 작업 실행");
        notify(); // Notify another thread waiting on this object
        try {
            wait(); // Wait until notified by another thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
