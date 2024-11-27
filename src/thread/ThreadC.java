package thread;

public class ThreadC extends Thread {
    private WorkObject workObject;

    public ThreadC(WorkObject workObject) {
        this.workObject = workObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            workObject.methodC();
        }
    }
}
