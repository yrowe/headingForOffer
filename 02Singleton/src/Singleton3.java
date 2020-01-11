/**
 *  饿汉式 - 线程安全
 *  对getUniqueInstance方法加锁， 避免了多次实例化uniqueInstance
 *
 *  缺点： 并发性差， 性能存在问题， 不推荐
 *
 * @Author rowe
 * @Date 2020/1/11 19:07
 */
public class Singleton3 {
    private static Singleton3 uniqueInstance;

    private Singleton3(){

    }

    public static synchronized Singleton3 getUniqueInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton3();
        }
        return uniqueInstance;
    }
}
