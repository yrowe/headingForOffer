/**
 * 饿汉式 - 线程安全
 *
 *  优点： 直接实例化避免了多次实例化的问题
 *
 *  缺点: 失去了延迟实例化带来的节约资源的好处。
 *
 * @Author rowe
 * @Date 2020/1/11 19:04
 */
public class Singleton2 {

    private static Singleton2 uniqueInstance = new Singleton2();

    private Singleton2(){

    }

    public static Singleton2 getUniqueInstance(){
        return uniqueInstance;
    }
}

