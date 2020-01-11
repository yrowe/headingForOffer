/**
 * 懒汉式- 线程不安全
 *
 *  优点： 私有静态变量被uniqueInstance被延迟实例化
 *
 *  缺点： 多线程环境下， 如果多个线程同时进入if(uniqueInstance == null), 并且此时uniqueInstance为null
 *  将导致重复实例化uniqueInstance
 * @Author rowe
 * @Date 2020/1/11 19:01
 */
public class Singleton1 {

    private static Singleton1 uniqueInstance;

    private Singleton1(){

    }

    public static Singleton1 getUniqueInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton1();
        }
        return uniqueInstance;
    }
}
