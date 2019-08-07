import java.lang.annotation.*;

/**
 * 尝试自定义一个注解
 */
public class AnnotationTest {

    @Documented
    @Target(ElementType.METHOD)
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Jeremy{
        String name();
        String website() default "忘我";
        int revision() default 1;
    }

    @Jeremy(name = "jx")
    public static void main(String[] args) {
        System.out.println("主方法");
    }
}
