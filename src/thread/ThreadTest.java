package thread;

import java.sql.SQLOutput;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class ThreadTest {

    static ExecutorService service=new ThreadPoolExecutor(3,
            10,
            30,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>());

    public static void main(String[] args) {
        //使用execute提交一个任务
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("execute方式");
                int i;
                for (i=1;i<20;i++){
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);

                }
            }
        });

        try {
            Integer number=future.get();
            System.out.println(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();//关闭线程（只关闭完成的）
        //service.shutdownNow();//全部关闭

    }


   static Future<Integer> future=service.submit(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            System.out.println("submit提交方式");
            return 2;
        }
    });


}
