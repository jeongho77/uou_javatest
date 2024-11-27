package thread;

public class WaitNotifyExample {
    public static void main(String[] args) {
        WorkObject sharedObject = new WorkObject();

        ThreadB threadB = new ThreadB(sharedObject);
        ThreadC threadC = new ThreadC(sharedObject);

        threadB.start();
        threadC.start();
    }
}