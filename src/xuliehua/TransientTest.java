package xuliehua;

import java.io.*;

/**
 * 序列化User
 * 测试transient关键字
 * 2019年8月7日 11:07:49
 */
public class TransientTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user=new User();
        user.setUserName("拉克丝");
        user.setPasswd("123456");
        //先打印序列化前内容
        System.out.println("read before Serializable: ");
        System.out.println("username: " + user.getUserName());
        System.err.println("password: " + user.getPasswd());


        //将对象序列化到文件中
        try {
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(
                    new FileOutputStream("D:\\java web\\JeremyTest\\src\\xuliehua\\user.txt"));
            objectOutputStream.writeObject(user);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //修改静态name
        User.userName="金克斯";
        //从文件中反序列化
        ObjectInputStream is=new ObjectInputStream(
                new FileInputStream("D:\\java web\\JeremyTest\\src\\xuliehua\\user.txt"));
        user=(User) is.readObject();
        is.close();
        System.out.println("\nread after Serializable: ");
        System.out.println("username: " + user.getUserName());//名字为修改后的，静态不受影响
        System.err.println("password: " + user.getPasswd());//密码取不到

    }


}
