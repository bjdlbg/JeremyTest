import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 测试利用多线程进行文件读写操作
 */
public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
        //预分配文件所占的磁盘空间，磁盘会创建一个指定大小文件
        RandomAccessFile randomAccessFile=new
                RandomAccessFile("c","rw");
        //预分配1M空间
        randomAccessFile.setLength(1024*1024);
        randomAccessFile.close();

        //所要写入的文件内容
        String s1 = "第一个字符串";
        String s2 = "第二个字符串";
        String s3 = "第三个字符串";
        String s4 = "第四个字符串";
        String s5 = "第五个字符串";

        //利用多线程同时写入一个文件
        new FileWriteThread(1024*1,s1.getBytes()).start();
        new FileWriteThread(1024*2,s2.getBytes()).start();// 从文件的2048字节之后开始写入数据
        new FileWriteThread(1024*3,s3.getBytes()).start();// 从文件的3072字节之后开始写入数据
        new FileWriteThread(1024*4,s4.getBytes()).start();// 从文件的4096字节之后开始写入数据
        new FileWriteThread(1024*5,s5.getBytes()).start();// 从文件的5120字节之后开始写入数据


        //

    }

    /**
     * 指定文职写入线程
     */
    static class FileWriteThread extends Thread{
        private int skip;
        private byte[] content;

        FileWriteThread(int skip,byte[] content){
            this.skip=skip;
            this.content=content;
        }

        @Override
        public void run() {
            RandomAccessFile raf=null;
            try {
                raf=new RandomAccessFile("D://java web//JeremyTest//test.txt","rw");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                raf.seek(skip);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                raf.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
