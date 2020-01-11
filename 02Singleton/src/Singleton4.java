/**
 * 双重校验锁 - 线程安全
 *
 * 双null判断， 部分加锁
 *
 * @Author rowe
 * @Date 2020/1/11 19:11
 */
public class Singleton4 {

    // volatile修饰是有必要的。
    // uniqueInstance = new Singleton4()实际分三步执行:
    // 1. 为uniqueInstance分配内存空间
    // 2. 初始化uniqueInstance
    // 3. 将uniqueInstance指向分配的内存地址
    // JVM具有指令重排的特性， 执行顺序可能变成1>3>2。 多线程情况下， 如果发生重排且线程T1执行了1,3， 此时T2调用了
    // getUniqueInstance后发现uniqueInstance不为空， 随即返回， 但此时uniqueInstance还未被初始化
    // 使用volatile可以禁止JVM指令重排， 保证在多线程环境下也能正常运行。
    private volatile static Singleton4 uniqueInstance;

    private Singleton4(){

    }

    public static Singleton4 getUniqueInstance(){
        if(uniqueInstance == null){
            synchronized (Singleton4.class){
                // 再次判断null是有必要的， 否则即使此处加锁，
                // 但同时进入第一个null判断的两个线程都会实例化uniqueInstance， 只是时间先后问题
                if(uniqueInstance == null){
                    uniqueInstance = new Singleton4();
                }
            }
        }
        return uniqueInstance;
    }
}
