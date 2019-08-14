import java.util.concurrent.locks.ReentrantLock;

public class LockTest implements Runnable {
    //创建公平锁
    private static ReentrantLock lock=new ReentrantLock(true);

    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()
                        +"亚索已经知道错了");
            }finally {
                lock.unlock();
            }
        }
    }

    /**
     * 看是否交替执行
     * @param args
     */
    public static void main(String[] args){
        LockTest test=new LockTest();
        Thread thread1=new Thread(test);
        Thread thread2=new Thread(test);
        thread1.start();
        thread2.start();
    }
}
