/**
 * 静态内部类实现
 *
 *  类被加载时， 静态内部类没有被加载进内存， 只有当调用getUniqueInstance方法时， 触发
 *  SingletonHolder.INSTANCE才被加载， 此时实例化INSTANCE实例， 并且JVM确保INSTANCE只被实例化一次
 *
 *  优点： 延迟加载， 且由JVM提供对线程安全的支持
 * @Author rowe
 * @Date 2020/1/11 19:36
 */
public class Singleton5 {

    private Singleton5(){

    }

    private static class SingletonHolder{
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getUniqueInstance(){
        return SingletonHolder.INSTANCE;
    }
}
