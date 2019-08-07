import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.function.Predicate;

/**
 * 动态代理
 * @author jixiang
 * @date 2019年8月6日 10:15:38
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        //创建目标对象
        RealSubject realSubject=new RealSubject();
        //创建调用处理器对象
        ProxyHandler handler=new ProxyHandler(realSubject);

        //动态生成代理对象
        Subject proxySubject=(Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),
                RealSubject.class.getInterfaces(),handler);

        //通过代理对象调用方法
        proxySubject.request();

    }

    /**
     * 定义主题接口
     */
    interface Subject{
        void request();
    }

    /**
     * 目标对象类
     */
    static class RealSubject implements Subject{

        @Override
        public void request() {
            System.out.println("===RealSubject Request===");
        }
    }

    /**
     * 代理类的调用处理器
     */
    static class ProxyHandler implements InvocationHandler{
        private Subject subject;
        /**
         * 构造方法
         * @param subject
         */
        public ProxyHandler(Subject subject){
            this.subject=subject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //定义预处理的工作，
            System.out.println("===before===");
            //调用RealSubject中的方法
            Object result = method.invoke(subject,args);
            System.out.println("===after===");
            return result;
        }
    }
}
