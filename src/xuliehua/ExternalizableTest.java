package xuliehua;

import java.io.*;

/**
 * 测试Externalizable接口
 * 2019年8月7日 11:14:41
 */
public class ExternalizableTest implements Externalizable {
    //使用transient关键字(不管用不用都会序列化)
    private transient String content="提莫他不知道到底会不会被序列化掉";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        content= (String) in.readObject();
    }

    public static void main(String[] args) throws IOException {
        ExternalizableTest test=new ExternalizableTest();
        ObjectOutputStream outputStream= new ObjectOutputStream(
                new FileOutputStream(new File("test")));
        try {
            outputStream.writeObject(test);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectInputStream inputStream=new ObjectInputStream(
                new FileInputStream(new File("test"))
        );
        System.out.println(test.content);
        outputStream.close();
        inputStream.close();

    }
}
