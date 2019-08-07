package xuliehua;

import java.io.Serializable;

/**
 * 序列化对象
 */
public class User implements Serializable {
    public static String userName;
    private transient String passwd;//密码使用transient修饰，不参与序列化

    public  String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
